package tfc.ralux.compiler.backend.llvm.util.helper;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.llvm.LLVM.LLVMErrorRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;
import org.bytedeco.llvm.LLVM.LLVMPassBuilderOptionsRef;
import org.bytedeco.llvm.LLVM.LLVMTargetMachineRef;
import org.bytedeco.llvm.global.LLVM;

import java.util.ArrayList;
import java.util.List;

public class LLVMOptimizer {
	List<PassBuilder> builders = new ArrayList<>();
	PassBuilder current;
	
	private void makePass(String arg, Level lvl) {
		if (current == null) {
			current = new PassBuilder(lvl);
		} else if (!current.level.isCompatible(lvl)) {
			builders.add(current);
			current = new PassBuilder(lvl);
		}
		
		current.add(arg);
	}
	
	// --- MODULE PASSES ---
	public void globalVarOpt() { makePass("globalopt", Level.MODULE); }
	public void globalDCE() { makePass("globaldce", Level.MODULE); }
	public void mergeConstants() { makePass("constmerge", Level.MODULE); }
	public void stripSymbols() { makePass("strip", Level.MODULE); }
	public void lowerExpect() { makePass("lower-expect", Level.MODULE); }
	public void lowerConstantIntrinsics() { makePass("lower-constant-intrinsics", Level.MODULE); }
	public void deadArgElim() { makePass("deadargelim", Level.MODULE); }
	public void calledValuePropagation() { makePass("called-value-propagation", Level.MODULE); }
	public void correlatedPropagation() { makePass("correlated-propagation", Level.MODULE); }
	public void ipSCCP() { makePass("ipsccp", Level.MODULE); }
	public void internalize() { makePass("internalize", Level.MODULE); }
	public void internalize(String... preserveGvs) {
		if (preserveGvs == null || preserveGvs.length == 0) {
			// Default: internalize EVERYTHING (dangerous if you don't use this intentionally)
			makePass("internalize", Level.MODULE);
		} else {
			// Build the parameter string: preserve-gv=name1;preserve-gv=name2
			StringBuilder params = new StringBuilder();
			for (String gv : preserveGvs) {
				if (params.length() > 0) params.append(";");
				params.append("preserve-gv=").append(gv);
			}
			makePass("internalize<" + params + ">", Level.MODULE);
		}
	}
	public void partialInline() { makePass("partial-inliner", Level.MODULE); }
	public void mergeFunctions() { makePass("mergefunc", Level.MODULE); }
	public void lowerSwitch() { makePass("lower-switch", Level.MODULE); }
	public void inferAttributes() { makePass("inferattrs", Level.MODULE); }
	public void extractBlocks() { makePass("extract-blocks", Level.MODULE); }
	
	// --- CGSCC PASSES (Call Graph SCC) ---
	public void functionAttrs() { makePass("function-attrs", Level.CGSCC); }
	public void inlineFunctions() { makePass("inline", Level.CGSCC); }
	public void alwaysInline() { makePass("always-inline", Level.CGSCC); }
	public void argPromotion() { makePass("argpromotion", Level.CGSCC); }
	
	// --- FUNCTION PASSES ---
	public void conditionalConstantSparsePropagation() { makePass("sccp", Level.FUNCTION); }
	public void assumeAlignment() { makePass("alignment-from-assumptions", Level.FUNCTION); }
	public void simplifyControlFlow() { makePass("simplifycfg", Level.FUNCTION); }
	public void convertMem2Reg() { makePass("mem2reg", Level.FUNCTION); }
	public void eliminateDeadCode() { makePass("dce", Level.FUNCTION); } // Function-level DCE
	public void aggressiveDCE() { makePass("adce", Level.FUNCTION); }
	public void combineInstructions() { makePass("instcombine", Level.FUNCTION); }
	public void combineInstructionsAggressive() { makePass("aggressive-instcombine", Level.FUNCTION); }
	public void simplifyInstructions() { makePass("instsimplify", Level.FUNCTION); }
	public void reassociate() { makePass("reassociate", Level.FUNCTION); }
	public void gvn() { makePass("newgvn", Level.FUNCTION); }
	public void aggregatesToScalars() { makePass("sroa", Level.FUNCTION); }
	public void earlyCSE() { makePass("early-cse", Level.FUNCTION); }
	public void jumpThreading() { makePass("jump-threading", Level.FUNCTION); }
	public void tailCallElimination() { makePass("tailcallelim", Level.FUNCTION); }
	public void slpVectorize() { makePass("slp-vectorizer", Level.FUNCTION); }
	public void loopVectorize() { makePass("loop-vectorize", Level.FUNCTION); }
	public void vectorizeSlp() { makePass("slp-vectorizer", Level.FUNCTION); }
	public void optimizeMemCpy() { makePass("memcpyopt", Level.FUNCTION); }
	public void deadStoreElim() { makePass("dse", Level.FUNCTION); }
	public void mldstMotion() { makePass("mldst-motion", Level.FUNCTION); }
	public void lowerAtomic() { makePass("lower-atomic", Level.FUNCTION); }
	public void earlyCSEMemSSA() { makePass("early-cse<memssa>", Level.FUNCTION); }
	public void loopClosedFormSSA() { makePass("lcssa", Level.FUNCTION); }
	public void sink() { makePass("sink", Level.FUNCTION); }
	
	// --- LOOP PASSES ---
	public void loopRotate() { makePass("loop-rotate", Level.LOOP); }
	public void loopUnroll() { makePass("loop-unroll", Level.LOOP); }
	public void loopUnrollAndJam() { makePass("loop-unroll-and-jam", Level.LOOP); }
	public void loopLICM() { makePass("licm", Level.LOOP); }
	public void loopIndVar() { makePass("indvars", Level.LOOP); }
	public void loopIdiom() { makePass("loop-idiom", Level.LOOP); }
	public void loopDeletion() { makePass("loop-deletion", Level.LOOP); }
	public void loopReroll() { makePass("loop-reroll", Level.LOOP); }
	public void loopFusion() { makePass("loop-fusion", Level.LOOP); }
	public void loopSimplify() { makePass("loop-simplify", Level.LOOP); }
	public void loopUnswitch() { makePass("simple-loop-unswitch", Level.LOOP); }
	
	public void opt(int backend) {
		makePass("default<O" + backend + ">", Level.MODULE);
	}
	
	public void invoke(LLVMModuleRef module, LLVMTargetMachineRef tm, LLVMPassBuilderOptionsRef options) {
		if (current != null) {
			builders.add(current);
			current = null;
		}
		
		for (PassBuilder builder : builders) {
			String finalPipeline = builder.builder.toString();
			
			LLVMErrorRef err = LLVM.LLVMRunPasses(module, finalPipeline, tm, options);
			
			if (err != null && !err.isNull()) {
				BytePointer msg = LLVM.LLVMGetErrorMessage(err);
				System.err.println("LLVM Pass Error: " + msg.getString());
				LLVM.LLVMDisposeErrorMessage(msg);
			}
		}
	}
	
	class PassBuilder {
		Level level;
		StringBuilder builder = new StringBuilder();
		boolean empty = true;
		
		public PassBuilder(Level level) {
			this.level = level;
		}
		
		public void add(String arg) {
			if (!empty) {
				builder.append(",");
			}
			empty = false;
			builder.append(arg);
		}
	}
	
	enum Level {
		UNIQUE(),
		LOOP(),
		FUNCTION(),
		CGSCC(FUNCTION),
		MODULE(FUNCTION, CGSCC);
		
		final Level[] compatibleSubLevels;
		
		Level(Level... compatibleSubLevels) {
			this.compatibleSubLevels = compatibleSubLevels;
		}
		
		public boolean isCompatible(Level l) {
			if (this == UNIQUE || l == UNIQUE)
				return false;
			if (this == l) return true;
			
			for (Level compatibleSubLevel : compatibleSubLevels) {
				if (compatibleSubLevel == l)
					return true;
			}
			return false;
		}
	}
}
