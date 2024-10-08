package tfc.ralux.compiler.parse;// Generated from C:/Users/User/IdeaProjects/RaluxYetAgain/grammar/Ralux.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RaluxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RaluxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RaluxParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(RaluxParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(RaluxParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#static_use}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatic_use(RaluxParser.Static_useContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(RaluxParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(RaluxParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#c_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_body(RaluxParser.C_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#c_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_component(RaluxParser.C_componentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(RaluxParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#def_params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_params(RaluxParser.Def_paramsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(RaluxParser.Statement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(RaluxParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(RaluxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(RaluxParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow(RaluxParser.FlowContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(RaluxParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#special}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecial(RaluxParser.SpecialContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#state_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_end(RaluxParser.State_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(RaluxParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#do}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo(RaluxParser.DoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(RaluxParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#while_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_header(RaluxParser.While_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(RaluxParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(RaluxParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#loop_enhanced}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_enhanced(RaluxParser.Loop_enhancedContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#loop_standard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_standard(RaluxParser.Loop_standardContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(RaluxParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(RaluxParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(RaluxParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call(RaluxParser.Method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#ctor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtor(RaluxParser.CtorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(RaluxParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#dOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOperand(RaluxParser.DOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(RaluxParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#semi_truck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemi_truck(RaluxParser.Semi_truckContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(RaluxParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#fb_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFb_expr(RaluxParser.Fb_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#full_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_type(RaluxParser.Full_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#generic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric(RaluxParser.GenericContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#generic_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric_element(RaluxParser.Generic_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(RaluxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#named_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamed_type(RaluxParser.Named_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(RaluxParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaluxParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(RaluxParser.DirectiveContext ctx);
}