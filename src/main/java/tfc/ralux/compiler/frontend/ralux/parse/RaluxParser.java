package tfc.ralux.compiler.frontend.ralux.parse;// Generated from D:/programs/jetbrains/workspaces/ralux/grammar/Ralux.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RaluxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PRIMITIVE=2, GENERIC_CONSTRAINT=3, GENERIC_WILDCARD=4, C_TYPE=5, 
		PRIMITIVE_INT=6, PRIMITIVE_FP=7, PRIMITIVE_OTHER=8, MODIFIER=9, STATIC=10, 
		CONSTANT=11, STRING=12, CHR=13, TRUE=14, FALSE=15, NULL=16, USE=17, PKG=18, 
		CLASS=19, INTERFACE=20, EXTENDS=21, SUPER=22, INSTANCE_OF=23, NEW=24, 
		IF=25, ELSE=26, FOR=27, WHILE=28, DO=29, BREAK=30, CONTINUE=31, RETURN=32, 
		UNSIGNED=33, PLUS=34, MINUS=35, MUL=36, POW=37, DIV=38, XOR=39, BOR=40, 
		BAND=41, MOD=42, OR=43, AND=44, LPAREN=45, RPAREN=46, INC_INC=47, DEC_DEC=48, 
		EQUAL=49, PLUS_EQUAL=50, MINUS_EQUAL=51, DIV_EQUAL=52, MUL_EQUAL=53, MOD_EQUAL=54, 
		VAR_SWAP=55, LESS=56, GREATER=57, LEQUAL=58, GEQUAL=59, EEQUAL=60, NEQUAL=61, 
		DEQUAL=62, DNEQUAL=63, DHASH=64, L_BRACKET=65, R_BRACKET=66, L_CURLY=67, 
		R_CURLY=68, SEMI=69, QUESTION=70, DOT=71, COMMA=72, INFER_STATEMENTS=73, 
		ENFORCE_STATEMENTS=74, WORD=75, NUMBER=76, INFERRED_DECIMAL=77, HALF=78, 
		FLOAT=79, DOUBLE=80, QUAD=81, WIDE=82, LONG=83, SHORT=84, INT=85, BYTE=86, 
		INUM=87, NL=88, WS=89, COMMENT=90, BLOCK_COMMENT=91;
	public static final int
		RULE_file = 0, RULE_header = 1, RULE_static_use = 2, RULE_annotation = 3, 
		RULE_class = 4, RULE_c_body = 5, RULE_c_component = 6, RULE_method = 7, 
		RULE_def_params = 8, RULE_statement_list = 9, RULE_body = 10, RULE_statement = 11, 
		RULE_ret = 12, RULE_flow = 13, RULE_loop = 14, RULE_special = 15, RULE_state_end = 16, 
		RULE_label = 17, RULE_do = 18, RULE_while = 19, RULE_while_header = 20, 
		RULE_if = 21, RULE_for = 22, RULE_loop_enhanced = 23, RULE_loop_standard = 24, 
		RULE_definition = 25, RULE_assignment = 26, RULE_call = 27, RULE_method_call = 28, 
		RULE_ctor = 29, RULE_aCtor = 30, RULE_params = 31, RULE_qualif = 32, RULE_aqualif = 33, 
		RULE_dOperand = 34, RULE_operand = 35, RULE_semi_truck = 36, RULE_expr = 37, 
		RULE_fb_expr = 38, RULE_full_type = 39, RULE_generic = 40, RULE_generic_element = 41, 
		RULE_type = 42, RULE_named_type = 43, RULE_array = 44, RULE_directive = 45, 
		RULE_field = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "header", "static_use", "annotation", "class", "c_body", "c_component", 
			"method", "def_params", "statement_list", "body", "statement", "ret", 
			"flow", "loop", "special", "state_end", "label", "do", "while", "while_header", 
			"if", "for", "loop_enhanced", "loop_standard", "definition", "assignment", 
			"call", "method_call", "ctor", "aCtor", "params", "qualif", "aqualif", 
			"dOperand", "operand", "semi_truck", "expr", "fb_expr", "full_type", 
			"generic", "generic_element", "type", "named_type", "array", "directive", 
			"field"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, null, null, null, null, null, null, null, "'static'", 
			null, null, null, "'true'", "'false'", "'null'", "'use'", "'pkg'", "'class'", 
			"'interface'", "'extends'", "'super'", "'instanceof'", "'new'", "'if'", 
			"'else'", "'for'", "'while'", "'do'", "'break'", "'continue'", "'return'", 
			"'unsigned'", "'+'", "'-'", "'*'", "'**'", "'/'", "'^'", "'|'", "'&'", 
			"'%'", "'||'", "'&&'", "'('", "')'", "'++'", "'--'", "'='", "'+='", "'-='", 
			"'/='", "'*='", "'%='", "'<->'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'.='", "'.!='", "'.#'", "'['", "']'", "'{'", "'}'", "';'", "'?'", 
			"'.'", "','", "'%infer_semicolon%'", "'%enforce_semicolon%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "PRIMITIVE", "GENERIC_CONSTRAINT", "GENERIC_WILDCARD", "C_TYPE", 
			"PRIMITIVE_INT", "PRIMITIVE_FP", "PRIMITIVE_OTHER", "MODIFIER", "STATIC", 
			"CONSTANT", "STRING", "CHR", "TRUE", "FALSE", "NULL", "USE", "PKG", "CLASS", 
			"INTERFACE", "EXTENDS", "SUPER", "INSTANCE_OF", "NEW", "IF", "ELSE", 
			"FOR", "WHILE", "DO", "BREAK", "CONTINUE", "RETURN", "UNSIGNED", "PLUS", 
			"MINUS", "MUL", "POW", "DIV", "XOR", "BOR", "BAND", "MOD", "OR", "AND", 
			"LPAREN", "RPAREN", "INC_INC", "DEC_DEC", "EQUAL", "PLUS_EQUAL", "MINUS_EQUAL", 
			"DIV_EQUAL", "MUL_EQUAL", "MOD_EQUAL", "VAR_SWAP", "LESS", "GREATER", 
			"LEQUAL", "GEQUAL", "EEQUAL", "NEQUAL", "DEQUAL", "DNEQUAL", "DHASH", 
			"L_BRACKET", "R_BRACKET", "L_CURLY", "R_CURLY", "SEMI", "QUESTION", "DOT", 
			"COMMA", "INFER_STATEMENTS", "ENFORCE_STATEMENTS", "WORD", "NUMBER", 
			"INFERRED_DECIMAL", "HALF", "FLOAT", "DOUBLE", "QUAD", "WIDE", "LONG", 
			"SHORT", "INT", "BYTE", "INUM", "NL", "WS", "COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Ralux.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    boolean inferSemicolons = false;

	public RaluxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public List<DirectiveContext> directive() {
			return getRuleContexts(DirectiveContext.class);
		}
		public DirectiveContext directive(int i) {
			return getRuleContext(DirectiveContext.class,i);
		}
		public List<HeaderContext> header() {
			return getRuleContexts(HeaderContext.class);
		}
		public HeaderContext header(int i) {
			return getRuleContext(HeaderContext.class,i);
		}
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(RaluxParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(RaluxParser.SEMI, i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 394784L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 785L) != 0)) {
				{
				setState(102);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INFER_STATEMENTS:
				case ENFORCE_STATEMENTS:
					{
					setState(94);
					directive();
					}
					break;
				case USE:
				case PKG:
					{
					setState(95);
					header();
					}
					break;
				case C_TYPE:
				case MODIFIER:
				case STATIC:
				case L_BRACKET:
					{
					setState(96);
					class_();
					}
					break;
				case SEMI:
					{
					setState(98); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(97);
							match(SEMI);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(100); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public Semi_truckContext semi_truck() {
			return getRuleContext(Semi_truckContext.class,0);
		}
		public Named_typeContext named_type() {
			return getRuleContext(Named_typeContext.class,0);
		}
		public TerminalNode USE() { return getToken(RaluxParser.USE, 0); }
		public TerminalNode PKG() { return getToken(RaluxParser.PKG, 0); }
		public Static_useContext static_use() {
			return getRuleContext(Static_useContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				{
				setState(107);
				static_use();
				}
				}
				break;
			case 2:
				{
				setState(108);
				_la = _input.LA(1);
				if ( !(_la==USE || _la==PKG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(109);
				named_type();
				}
				break;
			}
			setState(112);
			semi_truck();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Static_useContext extends ParserRuleContext {
		public TerminalNode USE() { return getToken(RaluxParser.USE, 0); }
		public TerminalNode STATIC() { return getToken(RaluxParser.STATIC, 0); }
		public Named_typeContext named_type() {
			return getRuleContext(Named_typeContext.class,0);
		}
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public Static_useContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_use; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterStatic_use(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitStatic_use(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitStatic_use(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Static_useContext static_use() throws RecognitionException {
		Static_useContext _localctx = new Static_useContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_static_use);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(USE);
			setState(115);
			match(STATIC);
			setState(116);
			named_type();
			setState(117);
			match(WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(RaluxParser.L_BRACKET, 0); }
		public List<TerminalNode> R_BRACKET() { return getTokens(RaluxParser.R_BRACKET); }
		public TerminalNode R_BRACKET(int i) {
			return getToken(RaluxParser.R_BRACKET, i);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(L_BRACKET);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 268435451L) != 0)) {
				{
				{
				setState(120);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==R_BRACKET) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(R_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassContext extends ParserRuleContext {
		public TerminalNode C_TYPE() { return getToken(RaluxParser.C_TYPE, 0); }
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public C_bodyContext c_body() {
			return getRuleContext(C_bodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public GenericContext generic() {
			return getRuleContext(GenericContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(RaluxParser.EXTENDS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> MODIFIER() { return getTokens(RaluxParser.MODIFIER); }
		public TerminalNode MODIFIER(int i) {
			return getToken(RaluxParser.MODIFIER, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(RaluxParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(RaluxParser.STATIC, i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(128);
					annotation();
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(134);
					_la = _input.LA(1);
					if ( !(_la==MODIFIER || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(140);
			match(C_TYPE);
			setState(141);
			match(WORD);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(142);
				generic();
				}
			}

			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(145);
				match(EXTENDS);
				setState(146);
				type();
				}
			}

			setState(149);
			c_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class C_bodyContext extends ParserRuleContext {
		public TerminalNode L_CURLY() { return getToken(RaluxParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(RaluxParser.R_CURLY, 0); }
		public List<C_componentContext> c_component() {
			return getRuleContexts(C_componentContext.class);
		}
		public C_componentContext c_component(int i) {
			return getRuleContext(C_componentContext.class,i);
		}
		public C_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterC_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitC_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitC_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final C_bodyContext c_body() throws RecognitionException {
		C_bodyContext _localctx = new C_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_c_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(L_CURLY);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057602627864100L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 1041L) != 0)) {
				{
				{
				setState(152);
				c_component();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			match(R_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class C_componentContext extends ParserRuleContext {
		public ClassContext class_() {
			return getRuleContext(ClassContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(RaluxParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(RaluxParser.SEMI, i);
		}
		public C_componentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c_component; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterC_component(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitC_component(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitC_component(this);
			else return visitor.visitChildren(this);
		}
	}

	public final C_componentContext c_component() throws RecognitionException {
		C_componentContext _localctx = new C_componentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_c_component);
		try {
			int _alt;
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				class_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				field();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				method();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(164); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(163);
						match(SEMI);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(166); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public Full_typeContext full_type() {
			return getRuleContext(Full_typeContext.class,0);
		}
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public Def_paramsContext def_params() {
			return getRuleContext(Def_paramsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public GenericContext generic() {
			return getRuleContext(GenericContext.class,0);
		}
		public List<TerminalNode> MODIFIER() { return getTokens(RaluxParser.MODIFIER); }
		public TerminalNode MODIFIER(int i) {
			return getToken(RaluxParser.MODIFIER, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(RaluxParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(RaluxParser.STATIC, i);
		}
		public Semi_truckContext semi_truck() {
			return getRuleContext(Semi_truckContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_method);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(170);
					annotation();
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(176);
					_la = _input.LA(1);
					if ( !(_la==MODIFIER || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(182);
				generic();
				}
			}

			setState(185);
			full_type();
			setState(186);
			match(WORD);
			setState(187);
			match(LPAREN);
			setState(188);
			def_params();
			setState(189);
			match(RPAREN);
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(190);
				body();
				}
				break;
			case PRIMITIVE:
			case C_TYPE:
			case MODIFIER:
			case STATIC:
			case UNSIGNED:
			case LESS:
			case L_BRACKET:
			case R_CURLY:
			case SEMI:
			case WORD:
				{
				{
				setState(191);
				semi_truck();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Def_paramsContext extends ParserRuleContext {
		public List<Full_typeContext> full_type() {
			return getRuleContexts(Full_typeContext.class);
		}
		public Full_typeContext full_type(int i) {
			return getRuleContext(Full_typeContext.class,i);
		}
		public List<TerminalNode> WORD() { return getTokens(RaluxParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(RaluxParser.WORD, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(RaluxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(RaluxParser.COMMA, i);
		}
		public Def_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterDef_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitDef_params(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitDef_params(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Def_paramsContext def_params() throws RecognitionException {
		Def_paramsContext _localctx = new Def_paramsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_def_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMITIVE || _la==UNSIGNED || _la==WORD) {
				{
				setState(194);
				full_type();
				setState(195);
				match(WORD);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(196);
					match(COMMA);
					setState(197);
					full_type();
					setState(198);
					match(WORD);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statement_listContext extends ParserRuleContext {
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public List<FlowContext> flow() {
			return getRuleContexts(FlowContext.class);
		}
		public FlowContext flow(int i) {
			return getRuleContext(FlowContext.class,i);
		}
		public List<DirectiveContext> directive() {
			return getRuleContexts(DirectiveContext.class);
		}
		public DirectiveContext directive(int i) {
			return getRuleContext(DirectiveContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Semi_truckContext> semi_truck() {
			return getRuleContexts(Semi_truckContext.class);
		}
		public Semi_truckContext semi_truck(int i) {
			return getRuleContext(Semi_truckContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(RaluxParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(RaluxParser.SEMI, i);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterStatement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitStatement_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitStatement_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		Statement_listContext _localctx = new Statement_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17095983108L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 453L) != 0)) {
				{
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(207);
					body();
					}
					break;
				case 2:
					{
					setState(208);
					flow();
					}
					break;
				case 3:
					{
					setState(218);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(209);
						directive();
						}
						break;
					case 2:
						{
						setState(211); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(210);
								match(SEMI);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(213); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
						} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 3:
						{
						{
						setState(215);
						statement();
						setState(216);
						semi_truck();
						}
						}
						break;
					}
					}
					break;
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public TerminalNode L_CURLY() { return getToken(RaluxParser.L_CURLY, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode R_CURLY() { return getToken(RaluxParser.R_CURLY, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(L_CURLY);
			setState(226);
			statement_list();
			setState(227);
			match(R_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DirectiveContext directive() {
			return getRuleContext(DirectiveContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(233);
				ret();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RetContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(RaluxParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(RETURN);
			setState(237);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FlowContext extends ParserRuleContext {
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public SpecialContext special() {
			return getRuleContext(SpecialContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public FlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitFlow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitFlow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlowContext flow() throws RecognitionException {
		FlowContext _localctx = new FlowContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_flow);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				if_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				loop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(241);
				special();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(242);
				label();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public DoContext do_() {
			return getRuleContext(DoContext.class,0);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(245);
				label();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(251);
				for_();
				}
				break;
			case WHILE:
				{
				setState(252);
				while_();
				}
				break;
			case DO:
				{
				setState(253);
				do_();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecialContext extends ParserRuleContext {
		public State_endContext state_end() {
			return getRuleContext(State_endContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(RaluxParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(RaluxParser.CONTINUE, 0); }
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public SpecialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterSpecial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitSpecial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitSpecial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialContext special() throws RecognitionException {
		SpecialContext _localctx = new SpecialContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_special);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(256);
			_la = _input.LA(1);
			if ( !(_la==BREAK || _la==CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(257);
				match(WORD);
				}
			}

			}
			setState(260);
			state_end();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class State_endContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(RaluxParser.SEMI, 0); }
		public TerminalNode NL() { return getToken(RaluxParser.NL, 0); }
		public State_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterState_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitState_end(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitState_end(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_endContext state_end() throws RecognitionException {
		State_endContext _localctx = new State_endContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_state_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==SEMI || _la==NL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(WORD);
			setState(265);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(RaluxParser.DO, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public While_headerContext while_header() {
			return getRuleContext(While_headerContext.class,0);
		}
		public DoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterDo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitDo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitDo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoContext do_() throws RecognitionException {
		DoContext _localctx = new DoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_do);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(DO);
			setState(268);
			body();
			setState(269);
			while_header();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ParserRuleContext {
		public While_headerContext while_header() {
			return getRuleContext(While_headerContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Semi_truckContext semi_truck() {
			return getRuleContext(Semi_truckContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			while_header();
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(272);
				body();
				}
				break;
			case PRIMITIVE:
			case NEW:
			case RETURN:
			case UNSIGNED:
			case INFER_STATEMENTS:
			case ENFORCE_STATEMENTS:
			case WORD:
				{
				{
				setState(273);
				statement();
				setState(274);
				semi_truck();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_headerContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(RaluxParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public While_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterWhile_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitWhile_header(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitWhile_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_headerContext while_header() throws RecognitionException {
		While_headerContext _localctx = new While_headerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_while_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(WHILE);
			setState(279);
			match(LPAREN);
			setState(280);
			expr(0);
			setState(281);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(RaluxParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public List<FlowContext> flow() {
			return getRuleContexts(FlowContext.class);
		}
		public FlowContext flow(int i) {
			return getRuleContext(FlowContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(RaluxParser.ELSE, 0); }
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Semi_truckContext> semi_truck() {
			return getRuleContexts(Semi_truckContext.class);
		}
		public Semi_truckContext semi_truck(int i) {
			return getRuleContext(Semi_truckContext.class,i);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(IF);
			setState(284);
			match(LPAREN);
			setState(285);
			expr(0);
			setState(286);
			match(RPAREN);
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(287);
				body();
				}
				break;
			case PRIMITIVE:
			case NEW:
			case IF:
			case FOR:
			case WHILE:
			case DO:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case UNSIGNED:
			case INFER_STATEMENTS:
			case ENFORCE_STATEMENTS:
			case WORD:
				{
				setState(292);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(288);
					flow();
					}
					break;
				case 2:
					{
					{
					setState(289);
					statement();
					setState(290);
					semi_truck();
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				{
				setState(296);
				match(ELSE);
				setState(297);
				if_();
				}
				}
				break;
			case 2:
				{
				{
				setState(298);
				match(ELSE);
				setState(304);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(299);
					flow();
					}
					break;
				case 2:
					{
					setState(300);
					body();
					}
					break;
				case 3:
					{
					{
					setState(301);
					statement();
					setState(302);
					semi_truck();
					}
					}
					break;
				}
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(RaluxParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public Loop_enhancedContext loop_enhanced() {
			return getRuleContext(Loop_enhancedContext.class,0);
		}
		public Loop_standardContext loop_standard() {
			return getRuleContext(Loop_standardContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Semi_truckContext semi_truck() {
			return getRuleContext(Semi_truckContext.class,0);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(FOR);
			setState(309);
			match(LPAREN);
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(310);
				loop_enhanced();
				}
				break;
			case 2:
				{
				setState(311);
				loop_standard();
				}
				break;
			}
			setState(314);
			match(RPAREN);
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(315);
				body();
				}
				break;
			case PRIMITIVE:
			case NEW:
			case RETURN:
			case UNSIGNED:
			case INFER_STATEMENTS:
			case ENFORCE_STATEMENTS:
			case WORD:
				{
				{
				setState(316);
				statement();
				setState(317);
				semi_truck();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_enhancedContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Full_typeContext full_type() {
			return getRuleContext(Full_typeContext.class,0);
		}
		public Loop_enhancedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_enhanced; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterLoop_enhanced(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitLoop_enhanced(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitLoop_enhanced(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_enhancedContext loop_enhanced() throws RecognitionException {
		Loop_enhancedContext _localctx = new Loop_enhancedContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_loop_enhanced);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(321);
				full_type();
				}
				break;
			}
			setState(324);
			match(WORD);
			setState(325);
			match(T__0);
			setState(326);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_standardContext extends ParserRuleContext {
		public List<Semi_truckContext> semi_truck() {
			return getRuleContexts(Semi_truckContext.class);
		}
		public Semi_truckContext semi_truck(int i) {
			return getRuleContext(Semi_truckContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<FlowContext> flow() {
			return getRuleContexts(FlowContext.class);
		}
		public FlowContext flow(int i) {
			return getRuleContext(FlowContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Loop_standardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_standard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterLoop_standard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitLoop_standard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitLoop_standard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_standardContext loop_standard() throws RecognitionException {
		Loop_standardContext _localctx = new Loop_standardContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_loop_standard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(328);
				flow();
				}
				break;
			case 2:
				{
				setState(329);
				statement();
				}
				break;
			}
			}
			setState(332);
			semi_truck();
			{
			setState(333);
			expr(0);
			}
			setState(334);
			semi_truck();
			{
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(335);
				flow();
				}
				break;
			case 2:
				{
				setState(336);
				statement();
				}
				break;
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public Full_typeContext full_type() {
			return getRuleContext(Full_typeContext.class,0);
		}
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(RaluxParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			full_type();
			setState(340);
			match(WORD);
			setState(341);
			match(EQUAL);
			setState(342);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public QualifContext qualif() {
			return getRuleContext(QualifContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AqualifContext aqualif() {
			return getRuleContext(AqualifContext.class,0);
		}
		public DOperandContext dOperand() {
			return getRuleContext(DOperandContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_assignment);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(344);
				qualif();
				setState(345);
				operand();
				setState(346);
				expr(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(348);
				aqualif();
				setState(349);
				dOperand();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public CtorContext ctor() {
			return getRuleContext(CtorContext.class,0);
		}
		public ACtorContext aCtor() {
			return getRuleContext(ACtorContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_call);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				ctor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				aCtor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_callContext extends ParserRuleContext {
		public AqualifContext aqualif() {
			return getRuleContext(AqualifContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public Named_typeContext named_type() {
			return getRuleContext(Named_typeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RaluxParser.DOT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitMethod_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitMethod_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(358);
				named_type();
				setState(359);
				match(DOT);
				}
				break;
			}
			setState(363);
			aqualif();
			setState(364);
			match(LPAREN);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
				{
				setState(365);
				params();
				}
			}

			setState(368);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CtorContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(RaluxParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public CtorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterCtor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitCtor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitCtor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtorContext ctor() throws RecognitionException {
		CtorContext _localctx = new CtorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ctor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(NEW);
			setState(371);
			type();
			setState(372);
			match(LPAREN);
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
				{
				setState(373);
				params();
				}
			}

			setState(376);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ACtorContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(RaluxParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> L_BRACKET() { return getTokens(RaluxParser.L_BRACKET); }
		public TerminalNode L_BRACKET(int i) {
			return getToken(RaluxParser.L_BRACKET, i);
		}
		public List<TerminalNode> R_BRACKET() { return getTokens(RaluxParser.R_BRACKET); }
		public TerminalNode R_BRACKET(int i) {
			return getToken(RaluxParser.R_BRACKET, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ACtorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aCtor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterACtor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitACtor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitACtor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ACtorContext aCtor() throws RecognitionException {
		ACtorContext _localctx = new ACtorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_aCtor);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(NEW);
			setState(379);
			type();
			setState(385); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(380);
					match(L_BRACKET);
					setState(382);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
						{
						setState(381);
						expr(0);
						}
					}

					setState(384);
					match(R_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(387); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(RaluxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(RaluxParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_params);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(389);
					expr(0);
					setState(390);
					match(COMMA);
					}
					} 
				}
				setState(396);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(397);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifContext extends ParserRuleContext {
		public AqualifContext aqualif() {
			return getRuleContext(AqualifContext.class,0);
		}
		public Named_typeContext named_type() {
			return getRuleContext(Named_typeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RaluxParser.DOT, 0); }
		public QualifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterQualif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitQualif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitQualif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifContext qualif() throws RecognitionException {
		QualifContext _localctx = new QualifContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_qualif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(399);
				named_type();
				setState(400);
				match(DOT);
				}
				break;
			}
			setState(404);
			aqualif();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AqualifContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public List<TerminalNode> L_BRACKET() { return getTokens(RaluxParser.L_BRACKET); }
		public TerminalNode L_BRACKET(int i) {
			return getToken(RaluxParser.L_BRACKET, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> R_BRACKET() { return getTokens(RaluxParser.R_BRACKET); }
		public TerminalNode R_BRACKET(int i) {
			return getToken(RaluxParser.R_BRACKET, i);
		}
		public AqualifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aqualif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterAqualif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitAqualif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitAqualif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AqualifContext aqualif() throws RecognitionException {
		AqualifContext _localctx = new AqualifContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_aqualif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(WORD);
			setState(413);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(407);
					match(L_BRACKET);
					setState(408);
					expr(0);
					setState(409);
					match(R_BRACKET);
					}
					} 
				}
				setState(415);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DOperandContext extends ParserRuleContext {
		public TerminalNode INC_INC() { return getToken(RaluxParser.INC_INC, 0); }
		public TerminalNode DEC_DEC() { return getToken(RaluxParser.DEC_DEC, 0); }
		public DOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterDOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitDOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitDOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DOperandContext dOperand() throws RecognitionException {
		DOperandContext _localctx = new DOperandContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_dOperand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_la = _input.LA(1);
			if ( !(_la==INC_INC || _la==DEC_DEC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperandContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(RaluxParser.EQUAL, 0); }
		public TerminalNode PLUS_EQUAL() { return getToken(RaluxParser.PLUS_EQUAL, 0); }
		public TerminalNode MINUS_EQUAL() { return getToken(RaluxParser.MINUS_EQUAL, 0); }
		public TerminalNode DIV_EQUAL() { return getToken(RaluxParser.DIV_EQUAL, 0); }
		public TerminalNode MUL_EQUAL() { return getToken(RaluxParser.MUL_EQUAL, 0); }
		public TerminalNode MOD_EQUAL() { return getToken(RaluxParser.MOD_EQUAL, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 35465847065542656L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Semi_truckContext extends ParserRuleContext {
		public Semi_truckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semi_truck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterSemi_truck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitSemi_truck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitSemi_truck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Semi_truckContext semi_truck() throws RecognitionException {
		Semi_truckContext _localctx = new Semi_truckContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_semi_truck);
		try {
			enterOuterAlt(_localctx, 1);
			{

			            if (getCurrentToken().getType() != SEMI) {
			                if (!inferSemicolons) {
			                    throw new NoViableAltException(this);
			                }
			            } else {
			                consume();
			                while (getCurrentToken().getType() == SEMI) {
			                    consume();
			                }
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(RaluxParser.MINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public Full_typeContext full_type() {
			return getRuleContext(Full_typeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public Fb_exprContext fb_expr() {
			return getRuleContext(Fb_exprContext.class,0);
		}
		public TerminalNode VAR_SWAP() { return getToken(RaluxParser.VAR_SWAP, 0); }
		public TerminalNode POW() { return getToken(RaluxParser.POW, 0); }
		public TerminalNode MUL() { return getToken(RaluxParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(RaluxParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(RaluxParser.PLUS, 0); }
		public TerminalNode MOD() { return getToken(RaluxParser.MOD, 0); }
		public TerminalNode BAND() { return getToken(RaluxParser.BAND, 0); }
		public TerminalNode XOR() { return getToken(RaluxParser.XOR, 0); }
		public TerminalNode BOR() { return getToken(RaluxParser.BOR, 0); }
		public TerminalNode LESS() { return getToken(RaluxParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(RaluxParser.GREATER, 0); }
		public TerminalNode LEQUAL() { return getToken(RaluxParser.LEQUAL, 0); }
		public TerminalNode GEQUAL() { return getToken(RaluxParser.GEQUAL, 0); }
		public TerminalNode EEQUAL() { return getToken(RaluxParser.EEQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(RaluxParser.NEQUAL, 0); }
		public TerminalNode DEQUAL() { return getToken(RaluxParser.DEQUAL, 0); }
		public TerminalNode DNEQUAL() { return getToken(RaluxParser.DNEQUAL, 0); }
		public TerminalNode AND() { return getToken(RaluxParser.AND, 0); }
		public TerminalNode OR() { return getToken(RaluxParser.OR, 0); }
		public TerminalNode DHASH() { return getToken(RaluxParser.DHASH, 0); }
		public TerminalNode L_BRACKET() { return getToken(RaluxParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(RaluxParser.R_BRACKET, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(423);
				match(MINUS);
				setState(424);
				expr(12);
				}
				break;
			case 2:
				{
				setState(425);
				match(LPAREN);
				setState(426);
				full_type();
				setState(427);
				match(RPAREN);
				setState(428);
				expr(11);
				}
				break;
			case 3:
				{
				setState(430);
				match(LPAREN);
				setState(431);
				expr(0);
				setState(432);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(434);
				fb_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(465);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(437);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(438);
						match(VAR_SWAP);
						setState(439);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(440);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(441);
						match(POW);
						setState(442);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(443);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(444);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(445);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(446);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(447);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(448);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(449);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(450);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337208320L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(451);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(452);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(453);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -72057594037927936L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(454);
						expr(5);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(455);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(456);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(457);
						expr(4);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(458);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(459);
						match(DHASH);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(460);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(461);
						match(L_BRACKET);
						setState(462);
						expr(0);
						setState(463);
						match(R_BRACKET);
						}
						break;
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fb_exprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(RaluxParser.NUMBER, 0); }
		public TerminalNode CONSTANT() { return getToken(RaluxParser.CONSTANT, 0); }
		public QualifContext qualif() {
			return getRuleContext(QualifContext.class,0);
		}
		public TerminalNode STRING() { return getToken(RaluxParser.STRING, 0); }
		public TerminalNode CHR() { return getToken(RaluxParser.CHR, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Fb_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fb_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterFb_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitFb_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitFb_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fb_exprContext fb_expr() throws RecognitionException {
		Fb_exprContext _localctx = new Fb_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_fb_expr);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
				match(CONSTANT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(472);
				qualif();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(473);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(474);
				match(CHR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(475);
				call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(476);
				assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Full_typeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Full_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_full_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterFull_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitFull_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitFull_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Full_typeContext full_type() throws RecognitionException {
		Full_typeContext _localctx = new Full_typeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_full_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			type();
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_BRACKET) {
				{
				setState(480);
				array();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(RaluxParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(RaluxParser.GREATER, 0); }
		public List<Generic_elementContext> generic_element() {
			return getRuleContexts(Generic_elementContext.class);
		}
		public Generic_elementContext generic_element(int i) {
			return getRuleContext(Generic_elementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(RaluxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(RaluxParser.COMMA, i);
		}
		public GenericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitGeneric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitGeneric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericContext generic() throws RecognitionException {
		GenericContext _localctx = new GenericContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_generic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(LESS);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589934612L) != 0) || _la==WORD) {
				{
				setState(484);
				generic_element();
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(485);
					match(COMMA);
					setState(486);
					generic_element();
					}
					}
					setState(491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(494);
			match(GREATER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_elementContext extends ParserRuleContext {
		public Full_typeContext full_type() {
			return getRuleContext(Full_typeContext.class,0);
		}
		public TerminalNode GENERIC_WILDCARD() { return getToken(RaluxParser.GENERIC_WILDCARD, 0); }
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public TerminalNode GENERIC_CONSTRAINT() { return getToken(RaluxParser.GENERIC_CONSTRAINT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Generic_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterGeneric_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitGeneric_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitGeneric_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Generic_elementContext generic_element() throws RecognitionException {
		Generic_elementContext _localctx = new Generic_elementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_generic_element);
		int _la;
		try {
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRIMITIVE:
				case UNSIGNED:
				case WORD:
					{
					setState(496);
					full_type();
					}
					break;
				case GENERIC_WILDCARD:
					{
					setState(497);
					match(GENERIC_WILDCARD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(500);
				_la = _input.LA(1);
				if ( !(_la==GENERIC_WILDCARD || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERIC_CONSTRAINT) {
					{
					setState(501);
					match(GENERIC_CONSTRAINT);
					setState(502);
					type();
					}
				}

				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode PRIMITIVE() { return getToken(RaluxParser.PRIMITIVE, 0); }
		public TerminalNode UNSIGNED() { return getToken(RaluxParser.UNSIGNED, 0); }
		public Named_typeContext named_type() {
			return getRuleContext(Named_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_type);
		int _la;
		try {
			setState(512);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE:
			case UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNSIGNED) {
					{
					setState(507);
					match(UNSIGNED);
					}
				}

				setState(510);
				match(PRIMITIVE);
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				named_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Named_typeContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(RaluxParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(RaluxParser.WORD, i);
		}
		public List<TerminalNode> DOT() { return getTokens(RaluxParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(RaluxParser.DOT, i);
		}
		public GenericContext generic() {
			return getRuleContext(GenericContext.class,0);
		}
		public Named_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterNamed_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitNamed_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitNamed_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Named_typeContext named_type() throws RecognitionException {
		Named_typeContext _localctx = new Named_typeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_named_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(514);
					match(WORD);
					setState(515);
					match(DOT);
					}
					} 
				}
				setState(520);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			}
			setState(521);
			match(WORD);
			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(522);
				generic();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(RaluxParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(RaluxParser.R_BRACKET, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(RaluxParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(RaluxParser.NUMBER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(RaluxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(RaluxParser.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			match(L_BRACKET);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(526);
				match(NUMBER);
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(527);
					match(COMMA);
					setState(528);
					match(NUMBER);
					}
					}
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(536);
			match(R_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectiveContext extends ParserRuleContext {
		public TerminalNode INFER_STATEMENTS() { return getToken(RaluxParser.INFER_STATEMENTS, 0); }
		public TerminalNode ENFORCE_STATEMENTS() { return getToken(RaluxParser.ENFORCE_STATEMENTS, 0); }
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_directive);
		try {
			setState(542);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INFER_STATEMENTS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(538);
				match(INFER_STATEMENTS);
				 inferSemicolons = true; 
				}
				}
				break;
			case ENFORCE_STATEMENTS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(540);
				match(ENFORCE_STATEMENTS);
				 inferSemicolons = false; 
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public Full_typeContext full_type() {
			return getRuleContext(Full_typeContext.class,0);
		}
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public Semi_truckContext semi_truck() {
			return getRuleContext(Semi_truckContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public GenericContext generic() {
			return getRuleContext(GenericContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(RaluxParser.EQUAL, 0); }
		public List<TerminalNode> MODIFIER() { return getTokens(RaluxParser.MODIFIER); }
		public TerminalNode MODIFIER(int i) {
			return getToken(RaluxParser.MODIFIER, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(RaluxParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(RaluxParser.STATIC, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_field);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(544);
					annotation();
					}
					} 
				}
				setState(549);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			setState(553);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(550);
					_la = _input.LA(1);
					if ( !(_la==MODIFIER || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(555);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(556);
				generic();
				}
			}

			setState(559);
			full_type();
			setState(560);
			match(WORD);
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(561);
				match(EQUAL);
				setState(564);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONSTANT:
				case STRING:
				case CHR:
				case NEW:
				case MINUS:
				case LPAREN:
				case WORD:
				case NUMBER:
					{
					setState(562);
					expr(0);
					}
					break;
				case L_CURLY:
					{
					setState(563);
					body();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			{
			setState(568);
			semi_truck();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 37:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001[\u023b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000c\b\u0000\u000b\u0000\f\u0000d\u0005\u0000g\b\u0000\n\u0000"+
		"\f\u0000j\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001o\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003z\b\u0003\n\u0003\f\u0003"+
		"}\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004\u0082\b\u0004"+
		"\n\u0004\f\u0004\u0085\t\u0004\u0001\u0004\u0005\u0004\u0088\b\u0004\n"+
		"\u0004\f\u0004\u008b\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u0090\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0094\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005\u009a\b\u0005"+
		"\n\u0005\f\u0005\u009d\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00a5\b\u0006\u000b\u0006\f"+
		"\u0006\u00a6\u0003\u0006\u00a9\b\u0006\u0001\u0007\u0005\u0007\u00ac\b"+
		"\u0007\n\u0007\f\u0007\u00af\t\u0007\u0001\u0007\u0005\u0007\u00b2\b\u0007"+
		"\n\u0007\f\u0007\u00b5\t\u0007\u0001\u0007\u0003\u0007\u00b8\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00c1\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00c9\b\b\n\b\f\b\u00cc\t\b\u0003\b\u00ce\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0004\t\u00d4\b\t\u000b\t\f\t\u00d5\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u00db\b\t\u0005\t\u00dd\b\t\n\t\f\t\u00e0\t\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00eb\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00f4\b\r\u0001\u000e\u0005\u000e\u00f7"+
		"\b\u000e\n\u000e\f\u000e\u00fa\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00ff\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u0103\b"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0115"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0125\b\u0015\u0003\u0015\u0127"+
		"\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0131\b\u0015\u0003\u0015\u0133"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0139"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u0140\b\u0016\u0001\u0017\u0003\u0017\u0143\b\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u014b\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0152\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u0160\b\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u0165\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u016a\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u016f\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u0177\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u017f\b\u001e\u0001\u001e"+
		"\u0004\u001e\u0182\b\u001e\u000b\u001e\f\u001e\u0183\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0005\u001f\u0189\b\u001f\n\u001f\f\u001f\u018c\t\u001f"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0003 \u0193\b \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u019c\b!\n!\f!\u019f\t!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u01b4"+
		"\b%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0005%\u01d2"+
		"\b%\n%\f%\u01d5\t%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u01de\b&\u0001\'\u0001\'\u0003\'\u01e2\b\'\u0001(\u0001(\u0001(\u0001"+
		"(\u0005(\u01e8\b(\n(\f(\u01eb\t(\u0003(\u01ed\b(\u0001(\u0001(\u0001)"+
		"\u0001)\u0003)\u01f3\b)\u0001)\u0001)\u0001)\u0003)\u01f8\b)\u0003)\u01fa"+
		"\b)\u0001*\u0003*\u01fd\b*\u0001*\u0001*\u0003*\u0201\b*\u0001+\u0001"+
		"+\u0005+\u0205\b+\n+\f+\u0208\t+\u0001+\u0001+\u0003+\u020c\b+\u0001,"+
		"\u0001,\u0001,\u0001,\u0005,\u0212\b,\n,\f,\u0215\t,\u0003,\u0217\b,\u0001"+
		",\u0001,\u0001-\u0001-\u0001-\u0001-\u0003-\u021f\b-\u0001.\u0005.\u0222"+
		"\b.\n.\f.\u0225\t.\u0001.\u0005.\u0228\b.\n.\f.\u022b\t.\u0001.\u0003"+
		".\u022e\b.\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u0235\b.\u0003.\u0237"+
		"\b.\u0001.\u0001.\u0001.\u0006\u0083\u0089\u00ad\u00b3\u0223\u0229\u0001"+
		"J/\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\\u0000\r\u0001\u0000\u0011"+
		"\u0012\u0001\u0000BB\u0001\u0000\t\n\u0001\u0000\u001e\u001f\u0002\u0000"+
		"EEXX\u0001\u0000/0\u0001\u000016\u0002\u0000$$&&\u0001\u0000\"#\u0001"+
		"\u0000\'*\u0001\u00008?\u0001\u0000+,\u0002\u0000\u0004\u0004KK\u026f"+
		"\u0000h\u0001\u0000\u0000\u0000\u0002n\u0001\u0000\u0000\u0000\u0004r"+
		"\u0001\u0000\u0000\u0000\u0006w\u0001\u0000\u0000\u0000\b\u0083\u0001"+
		"\u0000\u0000\u0000\n\u0097\u0001\u0000\u0000\u0000\f\u00a8\u0001\u0000"+
		"\u0000\u0000\u000e\u00ad\u0001\u0000\u0000\u0000\u0010\u00cd\u0001\u0000"+
		"\u0000\u0000\u0012\u00de\u0001\u0000\u0000\u0000\u0014\u00e1\u0001\u0000"+
		"\u0000\u0000\u0016\u00ea\u0001\u0000\u0000\u0000\u0018\u00ec\u0001\u0000"+
		"\u0000\u0000\u001a\u00f3\u0001\u0000\u0000\u0000\u001c\u00f8\u0001\u0000"+
		"\u0000\u0000\u001e\u0100\u0001\u0000\u0000\u0000 \u0106\u0001\u0000\u0000"+
		"\u0000\"\u0108\u0001\u0000\u0000\u0000$\u010b\u0001\u0000\u0000\u0000"+
		"&\u010f\u0001\u0000\u0000\u0000(\u0116\u0001\u0000\u0000\u0000*\u011b"+
		"\u0001\u0000\u0000\u0000,\u0134\u0001\u0000\u0000\u0000.\u0142\u0001\u0000"+
		"\u0000\u00000\u014a\u0001\u0000\u0000\u00002\u0153\u0001\u0000\u0000\u0000"+
		"4\u015f\u0001\u0000\u0000\u00006\u0164\u0001\u0000\u0000\u00008\u0169"+
		"\u0001\u0000\u0000\u0000:\u0172\u0001\u0000\u0000\u0000<\u017a\u0001\u0000"+
		"\u0000\u0000>\u018a\u0001\u0000\u0000\u0000@\u0192\u0001\u0000\u0000\u0000"+
		"B\u0196\u0001\u0000\u0000\u0000D\u01a0\u0001\u0000\u0000\u0000F\u01a2"+
		"\u0001\u0000\u0000\u0000H\u01a4\u0001\u0000\u0000\u0000J\u01b3\u0001\u0000"+
		"\u0000\u0000L\u01dd\u0001\u0000\u0000\u0000N\u01df\u0001\u0000\u0000\u0000"+
		"P\u01e3\u0001\u0000\u0000\u0000R\u01f9\u0001\u0000\u0000\u0000T\u0200"+
		"\u0001\u0000\u0000\u0000V\u0206\u0001\u0000\u0000\u0000X\u020d\u0001\u0000"+
		"\u0000\u0000Z\u021e\u0001\u0000\u0000\u0000\\\u0223\u0001\u0000\u0000"+
		"\u0000^g\u0003Z-\u0000_g\u0003\u0002\u0001\u0000`g\u0003\b\u0004\u0000"+
		"ac\u0005E\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000"+
		"\u0000f^\u0001\u0000\u0000\u0000f_\u0001\u0000\u0000\u0000f`\u0001\u0000"+
		"\u0000\u0000fb\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0001\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000ko\u0003\u0004\u0002\u0000lm\u0007\u0000"+
		"\u0000\u0000mo\u0003V+\u0000nk\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pq\u0003H$\u0000q\u0003\u0001\u0000\u0000"+
		"\u0000rs\u0005\u0011\u0000\u0000st\u0005\n\u0000\u0000tu\u0003V+\u0000"+
		"uv\u0005K\u0000\u0000v\u0005\u0001\u0000\u0000\u0000w{\u0005A\u0000\u0000"+
		"xz\b\u0001\u0000\u0000yx\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000"+
		"\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005B\u0000\u0000\u007f\u0007"+
		"\u0001\u0000\u0000\u0000\u0080\u0082\u0003\u0006\u0003\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0089"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0007\u0002\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u008b"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0005\u0000\u0000\u008d\u008f"+
		"\u0005K\u0000\u0000\u008e\u0090\u0003P(\u0000\u008f\u008e\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0005\u0015\u0000\u0000\u0092\u0094\u0003T*\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0003\n\u0005\u0000\u0096"+
		"\t\u0001\u0000\u0000\u0000\u0097\u009b\u0005C\u0000\u0000\u0098\u009a"+
		"\u0003\f\u0006\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001"+
		"\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005D\u0000\u0000\u009f\u000b\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a9\u0003\b\u0004\u0000\u00a1\u00a9\u0003\\.\u0000"+
		"\u00a2\u00a9\u0003\u000e\u0007\u0000\u00a3\u00a5\u0005E\u0000\u0000\u00a4"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a0\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a8\u00a2\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a9\r\u0001\u0000\u0000\u0000\u00aa\u00ac"+
		"\u0003\u0006\u0003\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ad\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b3\u0001\u0000\u0000\u0000\u00af\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b2\u0007\u0002\u0000\u0000\u00b1\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b8"+
		"\u0003P(\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003N\'"+
		"\u0000\u00ba\u00bb\u0005K\u0000\u0000\u00bb\u00bc\u0005-\u0000\u0000\u00bc"+
		"\u00bd\u0003\u0010\b\u0000\u00bd\u00c0\u0005.\u0000\u0000\u00be\u00c1"+
		"\u0003\u0014\n\u0000\u00bf\u00c1\u0003H$\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u000f\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0003N\'\u0000\u00c3\u00ca\u0005K\u0000\u0000"+
		"\u00c4\u00c5\u0005H\u0000\u0000\u00c5\u00c6\u0003N\'\u0000\u00c6\u00c7"+
		"\u0005K\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00c2\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u0011\u0001"+
		"\u0000\u0000\u0000\u00cf\u00dd\u0003\u0014\n\u0000\u00d0\u00dd\u0003\u001a"+
		"\r\u0000\u00d1\u00db\u0003Z-\u0000\u00d2\u00d4\u0005E\u0000\u0000\u00d3"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00db\u0001\u0000\u0000\u0000\u00d7\u00d8\u0003\u0016\u000b\u0000\u00d8"+
		"\u00d9\u0003H$\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00d1\u0001"+
		"\u0000\u0000\u0000\u00da\u00d3\u0001\u0000\u0000\u0000\u00da\u00d7\u0001"+
		"\u0000\u0000\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00cf\u0001"+
		"\u0000\u0000\u0000\u00dc\u00d0\u0001\u0000\u0000\u0000\u00dc\u00da\u0001"+
		"\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000\u0000\u00de\u00dc\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u0013\u0001"+
		"\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005"+
		"C\u0000\u0000\u00e2\u00e3\u0003\u0012\t\u0000\u00e3\u00e4\u0005D\u0000"+
		"\u0000\u00e4\u0015\u0001\u0000\u0000\u0000\u00e5\u00eb\u00036\u001b\u0000"+
		"\u00e6\u00eb\u00032\u0019\u0000\u00e7\u00eb\u00034\u001a\u0000\u00e8\u00eb"+
		"\u0003Z-\u0000\u00e9\u00eb\u0003\u0018\f\u0000\u00ea\u00e5\u0001\u0000"+
		"\u0000\u0000\u00ea\u00e6\u0001\u0000\u0000\u0000\u00ea\u00e7\u0001\u0000"+
		"\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00e9\u0001\u0000"+
		"\u0000\u0000\u00eb\u0017\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005 \u0000"+
		"\u0000\u00ed\u00ee\u0003J%\u0000\u00ee\u0019\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f4\u0003*\u0015\u0000\u00f0\u00f4\u0003\u001c\u000e\u0000\u00f1\u00f4"+
		"\u0003\u001e\u000f\u0000\u00f2\u00f4\u0003\"\u0011\u0000\u00f3\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u001b\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f7\u0003\"\u0011\u0000\u00f6\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00ff\u0003,\u0016"+
		"\u0000\u00fc\u00ff\u0003&\u0013\u0000\u00fd\u00ff\u0003$\u0012\u0000\u00fe"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe"+
		"\u00fd\u0001\u0000\u0000\u0000\u00ff\u001d\u0001\u0000\u0000\u0000\u0100"+
		"\u0102\u0007\u0003\u0000\u0000\u0101\u0103\u0005K\u0000\u0000\u0102\u0101"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0003 \u0010\u0000\u0105\u001f\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u0007\u0004\u0000\u0000\u0107!\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0005K\u0000\u0000\u0109\u010a\u0005\u0001\u0000"+
		"\u0000\u010a#\u0001\u0000\u0000\u0000\u010b\u010c\u0005\u001d\u0000\u0000"+
		"\u010c\u010d\u0003\u0014\n\u0000\u010d\u010e\u0003(\u0014\u0000\u010e"+
		"%\u0001\u0000\u0000\u0000\u010f\u0114\u0003(\u0014\u0000\u0110\u0115\u0003"+
		"\u0014\n\u0000\u0111\u0112\u0003\u0016\u000b\u0000\u0112\u0113\u0003H"+
		"$\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0110\u0001\u0000\u0000"+
		"\u0000\u0114\u0111\u0001\u0000\u0000\u0000\u0115\'\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\u0005\u001c\u0000\u0000\u0117\u0118\u0005-\u0000\u0000\u0118"+
		"\u0119\u0003J%\u0000\u0119\u011a\u0005.\u0000\u0000\u011a)\u0001\u0000"+
		"\u0000\u0000\u011b\u011c\u0005\u0019\u0000\u0000\u011c\u011d\u0005-\u0000"+
		"\u0000\u011d\u011e\u0003J%\u0000\u011e\u0126\u0005.\u0000\u0000\u011f"+
		"\u0127\u0003\u0014\n\u0000\u0120\u0125\u0003\u001a\r\u0000\u0121\u0122"+
		"\u0003\u0016\u000b\u0000\u0122\u0123\u0003H$\u0000\u0123\u0125\u0001\u0000"+
		"\u0000\u0000\u0124\u0120\u0001\u0000\u0000\u0000\u0124\u0121\u0001\u0000"+
		"\u0000\u0000\u0125\u0127\u0001\u0000\u0000\u0000\u0126\u011f\u0001\u0000"+
		"\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u0132\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0005\u001a\u0000\u0000\u0129\u0133\u0003*\u0015"+
		"\u0000\u012a\u0130\u0005\u001a\u0000\u0000\u012b\u0131\u0003\u001a\r\u0000"+
		"\u012c\u0131\u0003\u0014\n\u0000\u012d\u012e\u0003\u0016\u000b\u0000\u012e"+
		"\u012f\u0003H$\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u012b\u0001"+
		"\u0000\u0000\u0000\u0130\u012c\u0001\u0000\u0000\u0000\u0130\u012d\u0001"+
		"\u0000\u0000\u0000\u0131\u0133\u0001\u0000\u0000\u0000\u0132\u0128\u0001"+
		"\u0000\u0000\u0000\u0132\u012a\u0001\u0000\u0000\u0000\u0132\u0133\u0001"+
		"\u0000\u0000\u0000\u0133+\u0001\u0000\u0000\u0000\u0134\u0135\u0005\u001b"+
		"\u0000\u0000\u0135\u0138\u0005-\u0000\u0000\u0136\u0139\u0003.\u0017\u0000"+
		"\u0137\u0139\u00030\u0018\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138"+
		"\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a"+
		"\u013f\u0005.\u0000\u0000\u013b\u0140\u0003\u0014\n\u0000\u013c\u013d"+
		"\u0003\u0016\u000b\u0000\u013d\u013e\u0003H$\u0000\u013e\u0140\u0001\u0000"+
		"\u0000\u0000\u013f\u013b\u0001\u0000\u0000\u0000\u013f\u013c\u0001\u0000"+
		"\u0000\u0000\u0140-\u0001\u0000\u0000\u0000\u0141\u0143\u0003N\'\u0000"+
		"\u0142\u0141\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000"+
		"\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0145\u0005K\u0000\u0000\u0145"+
		"\u0146\u0005\u0001\u0000\u0000\u0146\u0147\u0003J%\u0000\u0147/\u0001"+
		"\u0000\u0000\u0000\u0148\u014b\u0003\u001a\r\u0000\u0149\u014b\u0003\u0016"+
		"\u000b\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u0149\u0001\u0000"+
		"\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000"+
		"\u0000\u0000\u014c\u014d\u0003H$\u0000\u014d\u014e\u0003J%\u0000\u014e"+
		"\u0151\u0003H$\u0000\u014f\u0152\u0003\u001a\r\u0000\u0150\u0152\u0003"+
		"\u0016\u000b\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0150\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u01521\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0003N\'\u0000\u0154\u0155\u0005K\u0000\u0000"+
		"\u0155\u0156\u00051\u0000\u0000\u0156\u0157\u0003J%\u0000\u01573\u0001"+
		"\u0000\u0000\u0000\u0158\u0159\u0003@ \u0000\u0159\u015a\u0003F#\u0000"+
		"\u015a\u015b\u0003J%\u0000\u015b\u0160\u0001\u0000\u0000\u0000\u015c\u015d"+
		"\u0003B!\u0000\u015d\u015e\u0003D\"\u0000\u015e\u0160\u0001\u0000\u0000"+
		"\u0000\u015f\u0158\u0001\u0000\u0000\u0000\u015f\u015c\u0001\u0000\u0000"+
		"\u0000\u01605\u0001\u0000\u0000\u0000\u0161\u0165\u00038\u001c\u0000\u0162"+
		"\u0165\u0003:\u001d\u0000\u0163\u0165\u0003<\u001e\u0000\u0164\u0161\u0001"+
		"\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0164\u0163\u0001"+
		"\u0000\u0000\u0000\u01657\u0001\u0000\u0000\u0000\u0166\u0167\u0003V+"+
		"\u0000\u0167\u0168\u0005G\u0000\u0000\u0168\u016a\u0001\u0000\u0000\u0000"+
		"\u0169\u0166\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000"+
		"\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016c\u0003B!\u0000\u016c\u016e"+
		"\u0005-\u0000\u0000\u016d\u016f\u0003>\u001f\u0000\u016e\u016d\u0001\u0000"+
		"\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0005.\u0000\u0000\u01719\u0001\u0000\u0000\u0000"+
		"\u0172\u0173\u0005\u0018\u0000\u0000\u0173\u0174\u0003T*\u0000\u0174\u0176"+
		"\u0005-\u0000\u0000\u0175\u0177\u0003>\u001f\u0000\u0176\u0175\u0001\u0000"+
		"\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000"+
		"\u0000\u0000\u0178\u0179\u0005.\u0000\u0000\u0179;\u0001\u0000\u0000\u0000"+
		"\u017a\u017b\u0005\u0018\u0000\u0000\u017b\u0181\u0003T*\u0000\u017c\u017e"+
		"\u0005A\u0000\u0000\u017d\u017f\u0003J%\u0000\u017e\u017d\u0001\u0000"+
		"\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000"+
		"\u0000\u0000\u0180\u0182\u0005B\u0000\u0000\u0181\u017c\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000"+
		"\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184=\u0001\u0000\u0000\u0000"+
		"\u0185\u0186\u0003J%\u0000\u0186\u0187\u0005H\u0000\u0000\u0187\u0189"+
		"\u0001\u0000\u0000\u0000\u0188\u0185\u0001\u0000\u0000\u0000\u0189\u018c"+
		"\u0001\u0000\u0000\u0000\u018a\u0188\u0001\u0000\u0000\u0000\u018a\u018b"+
		"\u0001\u0000\u0000\u0000\u018b\u018d\u0001\u0000\u0000\u0000\u018c\u018a"+
		"\u0001\u0000\u0000\u0000\u018d\u018e\u0003J%\u0000\u018e?\u0001\u0000"+
		"\u0000\u0000\u018f\u0190\u0003V+\u0000\u0190\u0191\u0005G\u0000\u0000"+
		"\u0191\u0193\u0001\u0000\u0000\u0000\u0192\u018f\u0001\u0000\u0000\u0000"+
		"\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000"+
		"\u0194\u0195\u0003B!\u0000\u0195A\u0001\u0000\u0000\u0000\u0196\u019d"+
		"\u0005K\u0000\u0000\u0197\u0198\u0005A\u0000\u0000\u0198\u0199\u0003J"+
		"%\u0000\u0199\u019a\u0005B\u0000\u0000\u019a\u019c\u0001\u0000\u0000\u0000"+
		"\u019b\u0197\u0001\u0000\u0000\u0000\u019c\u019f\u0001\u0000\u0000\u0000"+
		"\u019d\u019b\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000"+
		"\u019eC\u0001\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0"+
		"\u01a1\u0007\u0005\u0000\u0000\u01a1E\u0001\u0000\u0000\u0000\u01a2\u01a3"+
		"\u0007\u0006\u0000\u0000\u01a3G\u0001\u0000\u0000\u0000\u01a4\u01a5\u0006"+
		"$\uffff\uffff\u0000\u01a5I\u0001\u0000\u0000\u0000\u01a6\u01a7\u0006%"+
		"\uffff\uffff\u0000\u01a7\u01a8\u0005#\u0000\u0000\u01a8\u01b4\u0003J%"+
		"\f\u01a9\u01aa\u0005-\u0000\u0000\u01aa\u01ab\u0003N\'\u0000\u01ab\u01ac"+
		"\u0005.\u0000\u0000\u01ac\u01ad\u0003J%\u000b\u01ad\u01b4\u0001\u0000"+
		"\u0000\u0000\u01ae\u01af\u0005-\u0000\u0000\u01af\u01b0\u0003J%\u0000"+
		"\u01b0\u01b1\u0005.\u0000\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b4\u0003L&\u0000\u01b3\u01a6\u0001\u0000\u0000\u0000\u01b3\u01a9\u0001"+
		"\u0000\u0000\u0000\u01b3\u01ae\u0001\u0000\u0000\u0000\u01b3\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b4\u01d3\u0001\u0000\u0000\u0000\u01b5\u01b6\n\t"+
		"\u0000\u0000\u01b6\u01b7\u00057\u0000\u0000\u01b7\u01d2\u0003J%\n\u01b8"+
		"\u01b9\n\b\u0000\u0000\u01b9\u01ba\u0005%\u0000\u0000\u01ba\u01d2\u0003"+
		"J%\t\u01bb\u01bc\n\u0007\u0000\u0000\u01bc\u01bd\u0007\u0007\u0000\u0000"+
		"\u01bd\u01d2\u0003J%\b\u01be\u01bf\n\u0006\u0000\u0000\u01bf\u01c0\u0007"+
		"\b\u0000\u0000\u01c0\u01d2\u0003J%\u0007\u01c1\u01c2\n\u0005\u0000\u0000"+
		"\u01c2\u01c3\u0007\t\u0000\u0000\u01c3\u01d2\u0003J%\u0006\u01c4\u01c5"+
		"\n\u0004\u0000\u0000\u01c5\u01c6\u0007\n\u0000\u0000\u01c6\u01d2\u0003"+
		"J%\u0005\u01c7\u01c8\n\u0003\u0000\u0000\u01c8\u01c9\u0007\u000b\u0000"+
		"\u0000\u01c9\u01d2\u0003J%\u0004\u01ca\u01cb\n\r\u0000\u0000\u01cb\u01d2"+
		"\u0005@\u0000\u0000\u01cc\u01cd\n\u0001\u0000\u0000\u01cd\u01ce\u0005"+
		"A\u0000\u0000\u01ce\u01cf\u0003J%\u0000\u01cf\u01d0\u0005B\u0000\u0000"+
		"\u01d0\u01d2\u0001\u0000\u0000\u0000\u01d1\u01b5\u0001\u0000\u0000\u0000"+
		"\u01d1\u01b8\u0001\u0000\u0000\u0000\u01d1\u01bb\u0001\u0000\u0000\u0000"+
		"\u01d1\u01be\u0001\u0000\u0000\u0000\u01d1\u01c1\u0001\u0000\u0000\u0000"+
		"\u01d1\u01c4\u0001\u0000\u0000\u0000\u01d1\u01c7\u0001\u0000\u0000\u0000"+
		"\u01d1\u01ca\u0001\u0000\u0000\u0000\u01d1\u01cc\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d5\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000"+
		"\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4K\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d6\u01de\u0005L\u0000\u0000\u01d7\u01de"+
		"\u0005\u000b\u0000\u0000\u01d8\u01de\u0003@ \u0000\u01d9\u01de\u0005\f"+
		"\u0000\u0000\u01da\u01de\u0005\r\u0000\u0000\u01db\u01de\u00036\u001b"+
		"\u0000\u01dc\u01de\u00034\u001a\u0000\u01dd\u01d6\u0001\u0000\u0000\u0000"+
		"\u01dd\u01d7\u0001\u0000\u0000\u0000\u01dd\u01d8\u0001\u0000\u0000\u0000"+
		"\u01dd\u01d9\u0001\u0000\u0000\u0000\u01dd\u01da\u0001\u0000\u0000\u0000"+
		"\u01dd\u01db\u0001\u0000\u0000\u0000\u01dd\u01dc\u0001\u0000\u0000\u0000"+
		"\u01deM\u0001\u0000\u0000\u0000\u01df\u01e1\u0003T*\u0000\u01e0\u01e2"+
		"\u0003X,\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e2O\u0001\u0000\u0000\u0000\u01e3\u01ec\u00058\u0000\u0000"+
		"\u01e4\u01e9\u0003R)\u0000\u01e5\u01e6\u0005H\u0000\u0000\u01e6\u01e8"+
		"\u0003R)\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e8\u01eb\u0001\u0000"+
		"\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000"+
		"\u0000\u0000\u01ea\u01ed\u0001\u0000\u0000\u0000\u01eb\u01e9\u0001\u0000"+
		"\u0000\u0000\u01ec\u01e4\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000"+
		"\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee\u01ef\u00059\u0000"+
		"\u0000\u01efQ\u0001\u0000\u0000\u0000\u01f0\u01f3\u0003N\'\u0000\u01f1"+
		"\u01f3\u0005\u0004\u0000\u0000\u01f2\u01f0\u0001\u0000\u0000\u0000\u01f2"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f3\u01fa\u0001\u0000\u0000\u0000\u01f4"+
		"\u01f7\u0007\f\u0000\u0000\u01f5\u01f6\u0005\u0003\u0000\u0000\u01f6\u01f8"+
		"\u0003T*\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000"+
		"\u0000\u0000\u01f8\u01fa\u0001\u0000\u0000\u0000\u01f9\u01f2\u0001\u0000"+
		"\u0000\u0000\u01f9\u01f4\u0001\u0000\u0000\u0000\u01faS\u0001\u0000\u0000"+
		"\u0000\u01fb\u01fd\u0005!\u0000\u0000\u01fc\u01fb\u0001\u0000\u0000\u0000"+
		"\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000"+
		"\u01fe\u0201\u0005\u0002\u0000\u0000\u01ff\u0201\u0003V+\u0000\u0200\u01fc"+
		"\u0001\u0000\u0000\u0000\u0200\u01ff\u0001\u0000\u0000\u0000\u0201U\u0001"+
		"\u0000\u0000\u0000\u0202\u0203\u0005K\u0000\u0000\u0203\u0205\u0005G\u0000"+
		"\u0000\u0204\u0202\u0001\u0000\u0000\u0000\u0205\u0208\u0001\u0000\u0000"+
		"\u0000\u0206\u0204\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000"+
		"\u0000\u0207\u0209\u0001\u0000\u0000\u0000\u0208\u0206\u0001\u0000\u0000"+
		"\u0000\u0209\u020b\u0005K\u0000\u0000\u020a\u020c\u0003P(\u0000\u020b"+
		"\u020a\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000\u0000\u020c"+
		"W\u0001\u0000\u0000\u0000\u020d\u0216\u0005A\u0000\u0000\u020e\u0213\u0005"+
		"L\u0000\u0000\u020f\u0210\u0005H\u0000\u0000\u0210\u0212\u0005L\u0000"+
		"\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0212\u0215\u0001\u0000\u0000"+
		"\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0213\u0214\u0001\u0000\u0000"+
		"\u0000\u0214\u0217\u0001\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000"+
		"\u0000\u0216\u020e\u0001\u0000\u0000\u0000\u0216\u0217\u0001\u0000\u0000"+
		"\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u0219\u0005B\u0000\u0000"+
		"\u0219Y\u0001\u0000\u0000\u0000\u021a\u021b\u0005I\u0000\u0000\u021b\u021f"+
		"\u0006-\uffff\uffff\u0000\u021c\u021d\u0005J\u0000\u0000\u021d\u021f\u0006"+
		"-\uffff\uffff\u0000\u021e\u021a\u0001\u0000\u0000\u0000\u021e\u021c\u0001"+
		"\u0000\u0000\u0000\u021f[\u0001\u0000\u0000\u0000\u0220\u0222\u0003\u0006"+
		"\u0003\u0000\u0221\u0220\u0001\u0000\u0000\u0000\u0222\u0225\u0001\u0000"+
		"\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0223\u0221\u0001\u0000"+
		"\u0000\u0000\u0224\u0229\u0001\u0000\u0000\u0000\u0225\u0223\u0001\u0000"+
		"\u0000\u0000\u0226\u0228\u0007\u0002\u0000\u0000\u0227\u0226\u0001\u0000"+
		"\u0000\u0000\u0228\u022b\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000"+
		"\u0000\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u022a\u022d\u0001\u0000"+
		"\u0000\u0000\u022b\u0229\u0001\u0000\u0000\u0000\u022c\u022e\u0003P(\u0000"+
		"\u022d\u022c\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000"+
		"\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0230\u0003N\'\u0000\u0230"+
		"\u0236\u0005K\u0000\u0000\u0231\u0234\u00051\u0000\u0000\u0232\u0235\u0003"+
		"J%\u0000\u0233\u0235\u0003\u0014\n\u0000\u0234\u0232\u0001\u0000\u0000"+
		"\u0000\u0234\u0233\u0001\u0000\u0000\u0000\u0235\u0237\u0001\u0000\u0000"+
		"\u0000\u0236\u0231\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000"+
		"\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u0239\u0003H$\u0000\u0239"+
		"]\u0001\u0000\u0000\u0000Edfhn{\u0083\u0089\u008f\u0093\u009b\u00a6\u00a8"+
		"\u00ad\u00b3\u00b7\u00c0\u00ca\u00cd\u00d5\u00da\u00dc\u00de\u00ea\u00f3"+
		"\u00f8\u00fe\u0102\u0114\u0124\u0126\u0130\u0132\u0138\u013f\u0142\u014a"+
		"\u0151\u015f\u0164\u0169\u016e\u0176\u017e\u0183\u018a\u0192\u019d\u01b3"+
		"\u01d1\u01d3\u01dd\u01e1\u01e9\u01ec\u01f2\u01f7\u01f9\u01fc\u0200\u0206"+
		"\u020b\u0213\u0216\u021e\u0223\u0229\u022d\u0234\u0236";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}