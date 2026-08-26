package tfc.ralux.compiler.util.linker;

import java.util.*;

public class LLD extends Linker {
	List<String> libraries = new ArrayList<>();
	List<String> libPaths = new ArrayList<>();
	List<String> inputs = new ArrayList<>();
	List<String> mergeSections = new ArrayList<>();
	String entrypoint;
	String output;
	String debug;
	
	boolean isRelease = true;
	EnumSet<Option> options = EnumSet.noneOf(Option.class);
	EnumSet<Optimization> optimizations = EnumSet.noneOf(Optimization.class);
	
	String platform;
	
	public LLD(String platform) {
		this.platform = platform;
	}
	
	@Override
	public Linker addLibrary(String lib) {
		libraries.add(lib);
		return this;
	}
	
	@Override
	public Linker addLibPath(String path) {
		libPaths.add(path);
		return this;
	}
	
	@Override
	public Linker entrypoint(String entrypoint) {
		this.entrypoint = entrypoint;
		return this;
	}
	
	@Override
	public Linker link(String output, String... inputs) {
		this.output = output;
		this.inputs = new ArrayList<>();
		this.inputs.addAll(Arrays.asList(inputs));
		return this;
	}
	
	private Linker setOption(Option opt, boolean value) {
		if (value) {
			options.add(opt);
		} else {
			options.remove(opt);
		}
		return this;
	}
	
	@Override
	public Linker release(boolean b) {
		return setOption(Option.RELEASE, b);
	}
	
	@Override
	public Linker protectDataExecution(boolean value) {
		return setOption(Option.DEP, value);
	}
	
	@Override
	public Linker useLTO(boolean value) {
		return setOption(Option.LTO, value);
	}
	
	@Override
	public Linker verbose(boolean value) {
		return setOption(Option.VERBOSE, value);
	}
	
	@Override
	public Linker allowRelocations(boolean value) {
		return setOption(Option.FIXED, !value);
	}
	
	@Override
	public Linker incrementalLink(boolean value) {
		return setOption(Option.INCREMENTAL, value);
	}
	
	@Override
	public Linker enforceControlFlow(boolean value) {
		return setOption(Option.CTRL_ENFORCEMENT, value);
	}
	
	private Linker setOptimization(Optimization opt, boolean value) {
		if (value) {
			optimizations.add(opt);
		} else {
			optimizations.remove(opt);
		}
		return this;
	}
	
	@Override
	public Linker opt(String option, boolean value) {
		return setOptimization(switch (option) {
			case "dead_ref" -> Optimization.REF;
			case "comdat_folding" -> Optimization.ICF;
			case "long_branches" -> Optimization.LBR;
			default -> throw new RuntimeException("Unrecognized option: " + option);
		}, value);
	}
	
	@Override
	public Linker merge(String section) {
		mergeSections.add("/merge:" + section + "=" + section);
		return this;
	}
	
	@Override
	public Linker debug(String mode) {
		switch (mode) {
			case "strip":
				this.debug = "none";
				return this;
		}
		throw new RuntimeException("Unsupported mode: " + mode);
	}
	
	private enum Option {
		LTO("/ltcg"),
		VERBOSE("/verbose"),
		RELEASE("/release"),
		DEP("/nxcompat", "/nxcompat:no"),
		INCREMENTAL("/incremental", "/incremental:no"),
		FIXED("/fixed", "/fixed:no"),
		CTRL_ENFORCEMENT("/cetcompat", "/cetcompat:no"),
		;
		
		String flag;
		String flagOff;
		
		Option(String flag) {
			this(flag, null);
		}
		
		Option(String flag, String flagOff) {
			this.flag = flag;
			this.flagOff = flagOff;
		}
	}
	
	private enum Optimization {
		REF("-opt:ref", "-opt:noref"),
		ICF("-opt:icf", "-opt:noicf"),
		LBR("-opt:lbr", "-opt:nolbr"),
		;
		
		String flag;
		String flagOff;
		
		Optimization(String flag, String flagOff) {
			this.flag = flag;
			this.flagOff = flagOff;
		}
	}
	
	@Override
	public String buildCommand() {
		String res = "";
		
		switch (platform) {
			case "windows":
				res += "lld-link.exe ";
				break;
			default:
				throw new RuntimeException("TODO");
		}
		
		for (String libPath : libPaths) {
			res += "/libpath:\"" + libPath + "\" ";
		}
		
		for (String library : libraries) {
			res += "/defaultlib:\"" + library + "\" ";
		}
		
		for (String mergeSection : mergeSections) {
			res += mergeSection + " ";
		}
		
		for (Option value : Option.values()) {
			if (options.contains(value)) {
				res += value.flag + " ";
			} else if (value.flagOff != null) {
				res += value.flagOff + " ";
			}
		}
		
		for (Optimization value : Optimization.values()) {
			if (optimizations.contains(value)) {
				res += value.flag + " ";
			} else if (value.flagOff != null) {
				res += value.flagOff + " ";
			}
		}
		
		res += "-entry:" + entrypoint + " ";
		for (String input : inputs) {
			res += input + " ";
		}
		res += "/out:" + output;
		
		return res;
	}
	
	@Override
	public boolean execute() {
		throw new RuntimeException("TODO");
	}
}
