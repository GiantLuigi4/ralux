package tfc.ralux.compiler.parse;// Generated from C:/Users/User/IdeaProjects/RaluxYetAgain/grammar/Ralux.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RaluxParser}.
 */
public interface RaluxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RaluxParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(RaluxParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(RaluxParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(RaluxParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(RaluxParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#static_use}.
	 * @param ctx the parse tree
	 */
	void enterStatic_use(RaluxParser.Static_useContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#static_use}.
	 * @param ctx the parse tree
	 */
	void exitStatic_use(RaluxParser.Static_useContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(RaluxParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(RaluxParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(RaluxParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(RaluxParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#c_body}.
	 * @param ctx the parse tree
	 */
	void enterC_body(RaluxParser.C_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#c_body}.
	 * @param ctx the parse tree
	 */
	void exitC_body(RaluxParser.C_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#c_component}.
	 * @param ctx the parse tree
	 */
	void enterC_component(RaluxParser.C_componentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#c_component}.
	 * @param ctx the parse tree
	 */
	void exitC_component(RaluxParser.C_componentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(RaluxParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(RaluxParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#def_params}.
	 * @param ctx the parse tree
	 */
	void enterDef_params(RaluxParser.Def_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#def_params}.
	 * @param ctx the parse tree
	 */
	void exitDef_params(RaluxParser.Def_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(RaluxParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(RaluxParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(RaluxParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(RaluxParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(RaluxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(RaluxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(RaluxParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(RaluxParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterFlow(RaluxParser.FlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitFlow(RaluxParser.FlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(RaluxParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(RaluxParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#special}.
	 * @param ctx the parse tree
	 */
	void enterSpecial(RaluxParser.SpecialContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#special}.
	 * @param ctx the parse tree
	 */
	void exitSpecial(RaluxParser.SpecialContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#state_end}.
	 * @param ctx the parse tree
	 */
	void enterState_end(RaluxParser.State_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#state_end}.
	 * @param ctx the parse tree
	 */
	void exitState_end(RaluxParser.State_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(RaluxParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(RaluxParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#do}.
	 * @param ctx the parse tree
	 */
	void enterDo(RaluxParser.DoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#do}.
	 * @param ctx the parse tree
	 */
	void exitDo(RaluxParser.DoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(RaluxParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(RaluxParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#while_header}.
	 * @param ctx the parse tree
	 */
	void enterWhile_header(RaluxParser.While_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#while_header}.
	 * @param ctx the parse tree
	 */
	void exitWhile_header(RaluxParser.While_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(RaluxParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(RaluxParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(RaluxParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(RaluxParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#loop_enhanced}.
	 * @param ctx the parse tree
	 */
	void enterLoop_enhanced(RaluxParser.Loop_enhancedContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#loop_enhanced}.
	 * @param ctx the parse tree
	 */
	void exitLoop_enhanced(RaluxParser.Loop_enhancedContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#loop_standard}.
	 * @param ctx the parse tree
	 */
	void enterLoop_standard(RaluxParser.Loop_standardContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#loop_standard}.
	 * @param ctx the parse tree
	 */
	void exitLoop_standard(RaluxParser.Loop_standardContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(RaluxParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(RaluxParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(RaluxParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(RaluxParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(RaluxParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(RaluxParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call(RaluxParser.Method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call(RaluxParser.Method_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#ctor}.
	 * @param ctx the parse tree
	 */
	void enterCtor(RaluxParser.CtorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#ctor}.
	 * @param ctx the parse tree
	 */
	void exitCtor(RaluxParser.CtorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(RaluxParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(RaluxParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#dOperand}.
	 * @param ctx the parse tree
	 */
	void enterDOperand(RaluxParser.DOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#dOperand}.
	 * @param ctx the parse tree
	 */
	void exitDOperand(RaluxParser.DOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(RaluxParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(RaluxParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#semi_truck}.
	 * @param ctx the parse tree
	 */
	void enterSemi_truck(RaluxParser.Semi_truckContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#semi_truck}.
	 * @param ctx the parse tree
	 */
	void exitSemi_truck(RaluxParser.Semi_truckContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(RaluxParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(RaluxParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#full_type}.
	 * @param ctx the parse tree
	 */
	void enterFull_type(RaluxParser.Full_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#full_type}.
	 * @param ctx the parse tree
	 */
	void exitFull_type(RaluxParser.Full_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#generic}.
	 * @param ctx the parse tree
	 */
	void enterGeneric(RaluxParser.GenericContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#generic}.
	 * @param ctx the parse tree
	 */
	void exitGeneric(RaluxParser.GenericContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#generic_element}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_element(RaluxParser.Generic_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#generic_element}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_element(RaluxParser.Generic_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(RaluxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(RaluxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#named_type}.
	 * @param ctx the parse tree
	 */
	void enterNamed_type(RaluxParser.Named_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#named_type}.
	 * @param ctx the parse tree
	 */
	void exitNamed_type(RaluxParser.Named_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(RaluxParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(RaluxParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaluxParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(RaluxParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaluxParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(RaluxParser.DirectiveContext ctx);
}