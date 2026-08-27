package tfc.ralux.compiler.frontend.ralux.parse;
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
		RULE_ctor = 29, RULE_aCtor = 30, RULE_params = 31, RULE_var_ref = 32, 
		RULE_dOperand = 33, RULE_operand = 34, RULE_semi_truck = 35, RULE_expr = 36, 
		RULE_fb_expr = 37, RULE_full_type = 38, RULE_generic = 39, RULE_generic_element = 40, 
		RULE_type = 41, RULE_named_type = 42, RULE_array = 43, RULE_directive = 44, 
		RULE_field = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "header", "static_use", "annotation", "class", "c_body", "c_component", 
			"method", "def_params", "statement_list", "body", "statement", "ret", 
			"flow", "loop", "special", "state_end", "label", "do", "while", "while_header", 
			"if", "for", "loop_enhanced", "loop_standard", "definition", "assignment", 
			"call", "method_call", "ctor", "aCtor", "params", "var_ref", "dOperand", 
			"operand", "semi_truck", "expr", "fb_expr", "full_type", "generic", "generic_element", 
			"type", "named_type", "array", "directive", "field"
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
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 394784L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 785L) != 0)) {
				{
				setState(100);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INFER_STATEMENTS:
				case ENFORCE_STATEMENTS:
					{
					setState(92);
					directive();
					}
					break;
				case USE:
				case PKG:
					{
					setState(93);
					header();
					}
					break;
				case C_TYPE:
				case MODIFIER:
				case STATIC:
				case L_BRACKET:
					{
					setState(94);
					class_();
					}
					break;
				case SEMI:
					{
					setState(96); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(95);
							match(SEMI);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(98); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(104);
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
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				{
				setState(105);
				static_use();
				}
				}
				break;
			case 2:
				{
				setState(106);
				_la = _input.LA(1);
				if ( !(_la==USE || _la==PKG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(107);
				named_type();
				}
				break;
			}
			setState(110);
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
			setState(112);
			match(USE);
			setState(113);
			match(STATIC);
			setState(114);
			named_type();
			setState(115);
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
			setState(117);
			match(L_BRACKET);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 268435451L) != 0)) {
				{
				{
				setState(118);
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
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
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
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(126);
					annotation();
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(132);
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
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(138);
			match(C_TYPE);
			setState(139);
			match(WORD);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(140);
				generic();
				}
			}

			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(143);
				match(EXTENDS);
				setState(144);
				type();
				}
			}

			setState(147);
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
			setState(149);
			match(L_CURLY);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057602627864100L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 1041L) != 0)) {
				{
				{
				setState(150);
				c_component();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
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
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				class_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				field();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				method();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(162); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(161);
						match(SEMI);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(164); 
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
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(168);
					annotation();
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(174);
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
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(180);
				generic();
				}
			}

			setState(183);
			full_type();
			setState(184);
			match(WORD);
			setState(185);
			match(LPAREN);
			setState(186);
			def_params();
			setState(187);
			match(RPAREN);
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(188);
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
				setState(189);
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
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMITIVE || _la==UNSIGNED || _la==WORD) {
				{
				setState(192);
				full_type();
				setState(193);
				match(WORD);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(194);
					match(COMMA);
					setState(195);
					full_type();
					setState(196);
					match(WORD);
					}
					}
					setState(202);
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
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17095983108L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 453L) != 0)) {
				{
				setState(218);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(205);
					body();
					}
					break;
				case 2:
					{
					setState(206);
					flow();
					}
					break;
				case 3:
					{
					setState(216);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(207);
						directive();
						}
						break;
					case 2:
						{
						setState(209); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(208);
								match(SEMI);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(211); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
						} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 3:
						{
						{
						setState(213);
						statement();
						setState(214);
						semi_truck();
						}
						}
						break;
					}
					}
					break;
				}
				}
				setState(222);
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
			setState(223);
			match(L_CURLY);
			setState(224);
			statement_list();
			setState(225);
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
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
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
			setState(234);
			match(RETURN);
			setState(235);
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
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				if_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				loop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				special();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(240);
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
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(243);
				label();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(249);
				for_();
				}
				break;
			case WHILE:
				{
				setState(250);
				while_();
				}
				break;
			case DO:
				{
				setState(251);
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
			setState(254);
			_la = _input.LA(1);
			if ( !(_la==BREAK || _la==CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(255);
				match(WORD);
				}
			}

			}
			setState(258);
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
			setState(260);
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
			setState(262);
			match(WORD);
			setState(263);
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
			setState(265);
			match(DO);
			setState(266);
			body();
			setState(267);
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
			setState(269);
			while_header();
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(270);
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
				setState(271);
				statement();
				setState(272);
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
			setState(276);
			match(WHILE);
			setState(277);
			match(LPAREN);
			setState(278);
			expr(0);
			setState(279);
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
			setState(281);
			match(IF);
			setState(282);
			match(LPAREN);
			setState(283);
			expr(0);
			setState(284);
			match(RPAREN);
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(285);
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
				setState(290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(286);
					flow();
					}
					break;
				case 2:
					{
					{
					setState(287);
					statement();
					setState(288);
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
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				{
				setState(294);
				match(ELSE);
				setState(295);
				if_();
				}
				}
				break;
			case 2:
				{
				{
				setState(296);
				match(ELSE);
				setState(302);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(297);
					flow();
					}
					break;
				case 2:
					{
					setState(298);
					body();
					}
					break;
				case 3:
					{
					{
					setState(299);
					statement();
					setState(300);
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
			setState(306);
			match(FOR);
			setState(307);
			match(LPAREN);
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(308);
				loop_enhanced();
				}
				break;
			case 2:
				{
				setState(309);
				loop_standard();
				}
				break;
			}
			setState(312);
			match(RPAREN);
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(313);
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
				setState(314);
				statement();
				setState(315);
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
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(319);
				full_type();
				}
				break;
			}
			setState(322);
			match(WORD);
			setState(323);
			match(T__0);
			setState(324);
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
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(326);
				flow();
				}
				break;
			case 2:
				{
				setState(327);
				statement();
				}
				break;
			}
			}
			setState(330);
			semi_truck();
			{
			setState(331);
			expr(0);
			}
			setState(332);
			semi_truck();
			{
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(333);
				flow();
				}
				break;
			case 2:
				{
				setState(334);
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
			setState(337);
			full_type();
			setState(338);
			match(WORD);
			setState(339);
			match(EQUAL);
			setState(340);
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
		public Var_refContext var_ref() {
			return getRuleContext(Var_refContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(342);
				var_ref(0);
				setState(343);
				operand();
				setState(344);
				expr(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(346);
				var_ref(0);
				setState(347);
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
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				ctor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
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
		public Var_refContext var_ref() {
			return getRuleContext(Var_refContext.class,0);
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
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(356);
				named_type();
				setState(357);
				match(DOT);
				}
				break;
			}
			setState(361);
			var_ref(0);
			setState(362);
			match(LPAREN);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
				{
				setState(363);
				params();
				}
			}

			setState(366);
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
			setState(368);
			match(NEW);
			setState(369);
			type();
			setState(370);
			match(LPAREN);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
				{
				setState(371);
				params();
				}
			}

			setState(374);
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
			setState(376);
			match(NEW);
			setState(377);
			type();
			setState(383); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(378);
					match(L_BRACKET);
					setState(380);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
						{
						setState(379);
						expr(0);
						}
					}

					setState(382);
					match(R_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(385); 
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
			setState(392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(387);
					expr(0);
					setState(388);
					match(COMMA);
					}
					} 
				}
				setState(394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(395);
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
	public static class Var_refContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(RaluxParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(RaluxParser.WORD, i);
		}
		public Var_refContext var_ref() {
			return getRuleContext(Var_refContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(RaluxParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(RaluxParser.DOT, i);
		}
		public TerminalNode L_BRACKET() { return getToken(RaluxParser.L_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(RaluxParser.R_BRACKET, 0); }
		public Var_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).enterVar_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RaluxListener ) ((RaluxListener)listener).exitVar_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RaluxVisitor) return ((RaluxVisitor<? extends T>)visitor).visitVar_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_refContext var_ref() throws RecognitionException {
		return var_ref(0);
	}

	private Var_refContext var_ref(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Var_refContext _localctx = new Var_refContext(_ctx, _parentState);
		Var_refContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_var_ref, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(398);
			match(WORD);
			}
			_ctx.stop = _input.LT(-1);
			setState(414);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(412);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						_localctx = new Var_refContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_var_ref);
						setState(400);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(403); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(401);
								match(DOT);
								setState(402);
								match(WORD);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(405); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
						} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 2:
						{
						_localctx = new Var_refContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_var_ref);
						setState(407);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(408);
						match(L_BRACKET);
						setState(409);
						expr(0);
						setState(410);
						match(R_BRACKET);
						}
						break;
					}
					} 
				}
				setState(416);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
		enterRule(_localctx, 66, RULE_dOperand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
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
		enterRule(_localctx, 68, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
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
		enterRule(_localctx, 70, RULE_semi_truck);
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
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(424);
				match(MINUS);
				setState(425);
				expr(12);
				}
				break;
			case 2:
				{
				setState(426);
				match(LPAREN);
				setState(427);
				full_type();
				setState(428);
				match(RPAREN);
				setState(429);
				expr(11);
				}
				break;
			case 3:
				{
				setState(431);
				match(LPAREN);
				setState(432);
				expr(0);
				setState(433);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(435);
				fb_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(468);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(466);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(438);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(439);
						match(VAR_SWAP);
						setState(440);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(441);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(442);
						match(POW);
						setState(443);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(444);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(445);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(446);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(447);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(448);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(449);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(450);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(451);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337208320L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(452);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(453);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(454);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -72057594037927936L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(455);
						expr(5);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(456);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(457);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(458);
						expr(4);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(459);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(460);
						match(DHASH);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(461);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(462);
						match(L_BRACKET);
						setState(463);
						expr(0);
						setState(464);
						match(R_BRACKET);
						}
						break;
					}
					} 
				}
				setState(470);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
		public Var_refContext var_ref() {
			return getRuleContext(Var_refContext.class,0);
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
		enterRule(_localctx, 74, RULE_fb_expr);
		try {
			setState(478);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(471);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				match(CONSTANT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(473);
				var_ref(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(474);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(475);
				match(CHR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(476);
				call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(477);
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
		enterRule(_localctx, 76, RULE_full_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			type();
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_BRACKET) {
				{
				setState(481);
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
		enterRule(_localctx, 78, RULE_generic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(LESS);
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589934612L) != 0) || _la==WORD) {
				{
				setState(485);
				generic_element();
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(486);
					match(COMMA);
					setState(487);
					generic_element();
					}
					}
					setState(492);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(495);
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
		enterRule(_localctx, 80, RULE_generic_element);
		int _la;
		try {
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRIMITIVE:
				case UNSIGNED:
				case WORD:
					{
					setState(497);
					full_type();
					}
					break;
				case GENERIC_WILDCARD:
					{
					setState(498);
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
				setState(501);
				_la = _input.LA(1);
				if ( !(_la==GENERIC_WILDCARD || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERIC_CONSTRAINT) {
					{
					setState(502);
					match(GENERIC_CONSTRAINT);
					setState(503);
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
		enterRule(_localctx, 82, RULE_type);
		int _la;
		try {
			setState(513);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE:
			case UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNSIGNED) {
					{
					setState(508);
					match(UNSIGNED);
					}
				}

				setState(511);
				match(PRIMITIVE);
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
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
		enterRule(_localctx, 84, RULE_named_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(515);
					match(WORD);
					setState(516);
					match(DOT);
					}
					} 
				}
				setState(521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			setState(522);
			match(WORD);
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(523);
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
		enterRule(_localctx, 86, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(L_BRACKET);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(527);
				match(NUMBER);
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(528);
					match(COMMA);
					setState(529);
					match(NUMBER);
					}
					}
					setState(534);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(537);
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
		enterRule(_localctx, 88, RULE_directive);
		try {
			setState(543);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INFER_STATEMENTS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(539);
				match(INFER_STATEMENTS);
				 inferSemicolons = true; 
				}
				}
				break;
			case ENFORCE_STATEMENTS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(541);
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
		enterRule(_localctx, 90, RULE_field);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(545);
					annotation();
					}
					} 
				}
				setState(550);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			setState(554);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(551);
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
				setState(556);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(557);
				generic();
				}
			}

			setState(560);
			full_type();
			setState(561);
			match(WORD);
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(562);
				match(EQUAL);
				setState(565);
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
					setState(563);
					expr(0);
					}
					break;
				case L_CURLY:
					{
					setState(564);
					body();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			{
			setState(569);
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
		case 32:
			return var_ref_sempred((Var_refContext)_localctx, predIndex);
		case 36:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean var_ref_sempred(Var_refContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 13);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001[\u023c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000a"+
		"\b\u0000\u000b\u0000\f\u0000b\u0005\u0000e\b\u0000\n\u0000\f\u0000h\t"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001m\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0005\u0003x\b\u0003\n\u0003\f\u0003{\t"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004\u0080\b\u0004\n"+
		"\u0004\f\u0004\u0083\t\u0004\u0001\u0004\u0005\u0004\u0086\b\u0004\n\u0004"+
		"\f\u0004\u0089\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u008e\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0092\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005\u0098\b\u0005\n"+
		"\u0005\f\u0005\u009b\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00a3\b\u0006\u000b\u0006\f"+
		"\u0006\u00a4\u0003\u0006\u00a7\b\u0006\u0001\u0007\u0005\u0007\u00aa\b"+
		"\u0007\n\u0007\f\u0007\u00ad\t\u0007\u0001\u0007\u0005\u0007\u00b0\b\u0007"+
		"\n\u0007\f\u0007\u00b3\t\u0007\u0001\u0007\u0003\u0007\u00b6\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00bf\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00c7\b\b\n\b\f\b\u00ca\t\b\u0003\b\u00cc\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0004\t\u00d2\b\t\u000b\t\f\t\u00d3\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u00d9\b\t\u0005\t\u00db\b\t\n\t\f\t\u00de\t\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00e9\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00f2\b\r\u0001\u000e\u0005\u000e\u00f5"+
		"\b\u000e\n\u000e\f\u000e\u00f8\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00fd\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u0101\b"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0113"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0123\b\u0015\u0003\u0015\u0125"+
		"\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u012f\b\u0015\u0003\u0015\u0131"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0137"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u013e\b\u0016\u0001\u0017\u0003\u0017\u0141\b\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u0149\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0150\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u015e\b\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u0163\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u0168\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u016d\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u0175\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u017d\b\u001e\u0001\u001e"+
		"\u0004\u001e\u0180\b\u001e\u000b\u001e\f\u001e\u0181\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0005\u001f\u0187\b\u001f\n\u001f\f\u001f\u018a\t\u001f"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0004"+
		" \u0194\b \u000b \f \u0195\u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u019d"+
		"\b \n \f \u01a0\t \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$"+
		"\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0003$\u01b5\b$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0005$\u01d3\b$\n$\f$\u01d6\t$\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0003%\u01df\b%\u0001&\u0001&\u0003&\u01e3\b&\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0005\'\u01e9\b\'\n\'\f\'\u01ec\t\'\u0003\'"+
		"\u01ee\b\'\u0001\'\u0001\'\u0001(\u0001(\u0003(\u01f4\b(\u0001(\u0001"+
		"(\u0001(\u0003(\u01f9\b(\u0003(\u01fb\b(\u0001)\u0003)\u01fe\b)\u0001"+
		")\u0001)\u0003)\u0202\b)\u0001*\u0001*\u0005*\u0206\b*\n*\f*\u0209\t*"+
		"\u0001*\u0001*\u0003*\u020d\b*\u0001+\u0001+\u0001+\u0001+\u0005+\u0213"+
		"\b+\n+\f+\u0216\t+\u0003+\u0218\b+\u0001+\u0001+\u0001,\u0001,\u0001,"+
		"\u0001,\u0003,\u0220\b,\u0001-\u0005-\u0223\b-\n-\f-\u0226\t-\u0001-\u0005"+
		"-\u0229\b-\n-\f-\u022c\t-\u0001-\u0003-\u022f\b-\u0001-\u0001-\u0001-"+
		"\u0001-\u0001-\u0003-\u0236\b-\u0003-\u0238\b-\u0001-\u0001-\u0001-\u0006"+
		"\u0081\u0087\u00ab\u00b1\u0224\u022a\u0002@H.\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPRTVXZ\u0000\r\u0001\u0000\u0011\u0012\u0001\u0000BB\u0001"+
		"\u0000\t\n\u0001\u0000\u001e\u001f\u0002\u0000EEXX\u0001\u0000/0\u0001"+
		"\u000016\u0002\u0000$$&&\u0001\u0000\"#\u0001\u0000\'*\u0001\u00008?\u0001"+
		"\u0000+,\u0002\u0000\u0004\u0004KK\u0272\u0000f\u0001\u0000\u0000\u0000"+
		"\u0002l\u0001\u0000\u0000\u0000\u0004p\u0001\u0000\u0000\u0000\u0006u"+
		"\u0001\u0000\u0000\u0000\b\u0081\u0001\u0000\u0000\u0000\n\u0095\u0001"+
		"\u0000\u0000\u0000\f\u00a6\u0001\u0000\u0000\u0000\u000e\u00ab\u0001\u0000"+
		"\u0000\u0000\u0010\u00cb\u0001\u0000\u0000\u0000\u0012\u00dc\u0001\u0000"+
		"\u0000\u0000\u0014\u00df\u0001\u0000\u0000\u0000\u0016\u00e8\u0001\u0000"+
		"\u0000\u0000\u0018\u00ea\u0001\u0000\u0000\u0000\u001a\u00f1\u0001\u0000"+
		"\u0000\u0000\u001c\u00f6\u0001\u0000\u0000\u0000\u001e\u00fe\u0001\u0000"+
		"\u0000\u0000 \u0104\u0001\u0000\u0000\u0000\"\u0106\u0001\u0000\u0000"+
		"\u0000$\u0109\u0001\u0000\u0000\u0000&\u010d\u0001\u0000\u0000\u0000("+
		"\u0114\u0001\u0000\u0000\u0000*\u0119\u0001\u0000\u0000\u0000,\u0132\u0001"+
		"\u0000\u0000\u0000.\u0140\u0001\u0000\u0000\u00000\u0148\u0001\u0000\u0000"+
		"\u00002\u0151\u0001\u0000\u0000\u00004\u015d\u0001\u0000\u0000\u00006"+
		"\u0162\u0001\u0000\u0000\u00008\u0167\u0001\u0000\u0000\u0000:\u0170\u0001"+
		"\u0000\u0000\u0000<\u0178\u0001\u0000\u0000\u0000>\u0188\u0001\u0000\u0000"+
		"\u0000@\u018d\u0001\u0000\u0000\u0000B\u01a1\u0001\u0000\u0000\u0000D"+
		"\u01a3\u0001\u0000\u0000\u0000F\u01a5\u0001\u0000\u0000\u0000H\u01b4\u0001"+
		"\u0000\u0000\u0000J\u01de\u0001\u0000\u0000\u0000L\u01e0\u0001\u0000\u0000"+
		"\u0000N\u01e4\u0001\u0000\u0000\u0000P\u01fa\u0001\u0000\u0000\u0000R"+
		"\u0201\u0001\u0000\u0000\u0000T\u0207\u0001\u0000\u0000\u0000V\u020e\u0001"+
		"\u0000\u0000\u0000X\u021f\u0001\u0000\u0000\u0000Z\u0224\u0001\u0000\u0000"+
		"\u0000\\e\u0003X,\u0000]e\u0003\u0002\u0001\u0000^e\u0003\b\u0004\u0000"+
		"_a\u0005E\u0000\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000"+
		"\u0000d\\\u0001\u0000\u0000\u0000d]\u0001\u0000\u0000\u0000d^\u0001\u0000"+
		"\u0000\u0000d`\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000g\u0001\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000im\u0003\u0004\u0002\u0000jk\u0007\u0000"+
		"\u0000\u0000km\u0003T*\u0000li\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000no\u0003F#\u0000o\u0003\u0001\u0000\u0000"+
		"\u0000pq\u0005\u0011\u0000\u0000qr\u0005\n\u0000\u0000rs\u0003T*\u0000"+
		"st\u0005K\u0000\u0000t\u0005\u0001\u0000\u0000\u0000uy\u0005A\u0000\u0000"+
		"vx\b\u0001\u0000\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|}\u0005B\u0000\u0000}\u0007\u0001\u0000"+
		"\u0000\u0000~\u0080\u0003\u0006\u0003\u0000\u007f~\u0001\u0000\u0000\u0000"+
		"\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0087\u0001\u0000\u0000\u0000"+
		"\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0086\u0007\u0002\u0000\u0000"+
		"\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000"+
		"\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u0005\u0000\u0000\u008b\u008d\u0005K\u0000\u0000\u008c"+
		"\u008e\u0003N\'\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0005\u0015\u0000\u0000\u0090\u0092\u0003R)\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0003\n\u0005\u0000\u0094\t\u0001\u0000\u0000"+
		"\u0000\u0095\u0099\u0005C\u0000\u0000\u0096\u0098\u0003\f\u0006\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005D\u0000\u0000\u009d\u000b\u0001\u0000\u0000\u0000\u009e"+
		"\u00a7\u0003\b\u0004\u0000\u009f\u00a7\u0003Z-\u0000\u00a0\u00a7\u0003"+
		"\u000e\u0007\u0000\u00a1\u00a3\u0005E\u0000\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a6\u009e\u0001\u0000\u0000\u0000\u00a6\u009f\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a0\u0001\u0000\u0000\u0000\u00a6\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a7\r\u0001\u0000\u0000\u0000\u00a8\u00aa\u0003\u0006\u0003"+
		"\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ac\u00b1\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b0\u0007\u0002\u0000\u0000\u00af\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b6\u0003N\'\u0000"+
		"\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0003L&\u0000\u00b8\u00b9"+
		"\u0005K\u0000\u0000\u00b9\u00ba\u0005-\u0000\u0000\u00ba\u00bb\u0003\u0010"+
		"\b\u0000\u00bb\u00be\u0005.\u0000\u0000\u00bc\u00bf\u0003\u0014\n\u0000"+
		"\u00bd\u00bf\u0003F#\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bf\u000f\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0003L&\u0000\u00c1\u00c8\u0005K\u0000\u0000\u00c2\u00c3\u0005H\u0000"+
		"\u0000\u00c3\u00c4\u0003L&\u0000\u00c4\u00c5\u0005K\u0000\u0000\u00c5"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c2\u0001\u0000\u0000\u0000\u00c7"+
		"\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca"+
		"\u00c8\u0001\u0000\u0000\u0000\u00cb\u00c0\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cc\u0011\u0001\u0000\u0000\u0000\u00cd"+
		"\u00db\u0003\u0014\n\u0000\u00ce\u00db\u0003\u001a\r\u0000\u00cf\u00d9"+
		"\u0003X,\u0000\u00d0\u00d2\u0005E\u0000\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d9\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0003\u0016\u000b\u0000\u00d6\u00d7\u0003F#\u0000"+
		"\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d1\u0001\u0000\u0000\u0000\u00d8\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00cd\u0001\u0000\u0000\u0000"+
		"\u00da\u00ce\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u0013\u0001\u0000\u0000\u0000"+
		"\u00de\u00dc\u0001\u0000\u0000\u0000\u00df\u00e0\u0005C\u0000\u0000\u00e0"+
		"\u00e1\u0003\u0012\t\u0000\u00e1\u00e2\u0005D\u0000\u0000\u00e2\u0015"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e9\u00036\u001b\u0000\u00e4\u00e9\u0003"+
		"2\u0019\u0000\u00e5\u00e9\u00034\u001a\u0000\u00e6\u00e9\u0003X,\u0000"+
		"\u00e7\u00e9\u0003\u0018\f\u0000\u00e8\u00e3\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e8\u00e5\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9"+
		"\u0017\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005 \u0000\u0000\u00eb\u00ec"+
		"\u0003H$\u0000\u00ec\u0019\u0001\u0000\u0000\u0000\u00ed\u00f2\u0003*"+
		"\u0015\u0000\u00ee\u00f2\u0003\u001c\u000e\u0000\u00ef\u00f2\u0003\u001e"+
		"\u000f\u0000\u00f0\u00f2\u0003\"\u0011\u0000\u00f1\u00ed\u0001\u0000\u0000"+
		"\u0000\u00f1\u00ee\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2\u001b\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f5\u0003\"\u0011\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00fc\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00fd\u0003,\u0016\u0000\u00fa"+
		"\u00fd\u0003&\u0013\u0000\u00fb\u00fd\u0003$\u0012\u0000\u00fc\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fd\u001d\u0001\u0000\u0000\u0000\u00fe\u0100\u0007"+
		"\u0003\u0000\u0000\u00ff\u0101\u0005K\u0000\u0000\u0100\u00ff\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0003 \u0010\u0000\u0103\u001f\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0007\u0004\u0000\u0000\u0105!\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0005K\u0000\u0000\u0107\u0108\u0005\u0001\u0000\u0000\u0108"+
		"#\u0001\u0000\u0000\u0000\u0109\u010a\u0005\u001d\u0000\u0000\u010a\u010b"+
		"\u0003\u0014\n\u0000\u010b\u010c\u0003(\u0014\u0000\u010c%\u0001\u0000"+
		"\u0000\u0000\u010d\u0112\u0003(\u0014\u0000\u010e\u0113\u0003\u0014\n"+
		"\u0000\u010f\u0110\u0003\u0016\u000b\u0000\u0110\u0111\u0003F#\u0000\u0111"+
		"\u0113\u0001\u0000\u0000\u0000\u0112\u010e\u0001\u0000\u0000\u0000\u0112"+
		"\u010f\u0001\u0000\u0000\u0000\u0113\'\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0005\u001c\u0000\u0000\u0115\u0116\u0005-\u0000\u0000\u0116\u0117\u0003"+
		"H$\u0000\u0117\u0118\u0005.\u0000\u0000\u0118)\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0005\u0019\u0000\u0000\u011a\u011b\u0005-\u0000\u0000\u011b"+
		"\u011c\u0003H$\u0000\u011c\u0124\u0005.\u0000\u0000\u011d\u0125\u0003"+
		"\u0014\n\u0000\u011e\u0123\u0003\u001a\r\u0000\u011f\u0120\u0003\u0016"+
		"\u000b\u0000\u0120\u0121\u0003F#\u0000\u0121\u0123\u0001\u0000\u0000\u0000"+
		"\u0122\u011e\u0001\u0000\u0000\u0000\u0122\u011f\u0001\u0000\u0000\u0000"+
		"\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u011d\u0001\u0000\u0000\u0000"+
		"\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u0130\u0001\u0000\u0000\u0000"+
		"\u0126\u0127\u0005\u001a\u0000\u0000\u0127\u0131\u0003*\u0015\u0000\u0128"+
		"\u012e\u0005\u001a\u0000\u0000\u0129\u012f\u0003\u001a\r\u0000\u012a\u012f"+
		"\u0003\u0014\n\u0000\u012b\u012c\u0003\u0016\u000b\u0000\u012c\u012d\u0003"+
		"F#\u0000\u012d\u012f\u0001\u0000\u0000\u0000\u012e\u0129\u0001\u0000\u0000"+
		"\u0000\u012e\u012a\u0001\u0000\u0000\u0000\u012e\u012b\u0001\u0000\u0000"+
		"\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u0126\u0001\u0000\u0000"+
		"\u0000\u0130\u0128\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000"+
		"\u0000\u0131+\u0001\u0000\u0000\u0000\u0132\u0133\u0005\u001b\u0000\u0000"+
		"\u0133\u0136\u0005-\u0000\u0000\u0134\u0137\u0003.\u0017\u0000\u0135\u0137"+
		"\u00030\u0018\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0135\u0001"+
		"\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013d\u0005"+
		".\u0000\u0000\u0139\u013e\u0003\u0014\n\u0000\u013a\u013b\u0003\u0016"+
		"\u000b\u0000\u013b\u013c\u0003F#\u0000\u013c\u013e\u0001\u0000\u0000\u0000"+
		"\u013d\u0139\u0001\u0000\u0000\u0000\u013d\u013a\u0001\u0000\u0000\u0000"+
		"\u013e-\u0001\u0000\u0000\u0000\u013f\u0141\u0003L&\u0000\u0140\u013f"+
		"\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142"+
		"\u0001\u0000\u0000\u0000\u0142\u0143\u0005K\u0000\u0000\u0143\u0144\u0005"+
		"\u0001\u0000\u0000\u0144\u0145\u0003H$\u0000\u0145/\u0001\u0000\u0000"+
		"\u0000\u0146\u0149\u0003\u001a\r\u0000\u0147\u0149\u0003\u0016\u000b\u0000"+
		"\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u0003F#\u0000\u014b\u014c\u0003H$\u0000\u014c\u014f\u0003"+
		"F#\u0000\u014d\u0150\u0003\u001a\r\u0000\u014e\u0150\u0003\u0016\u000b"+
		"\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u014e\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u01501\u0001\u0000\u0000\u0000"+
		"\u0151\u0152\u0003L&\u0000\u0152\u0153\u0005K\u0000\u0000\u0153\u0154"+
		"\u00051\u0000\u0000\u0154\u0155\u0003H$\u0000\u01553\u0001\u0000\u0000"+
		"\u0000\u0156\u0157\u0003@ \u0000\u0157\u0158\u0003D\"\u0000\u0158\u0159"+
		"\u0003H$\u0000\u0159\u015e\u0001\u0000\u0000\u0000\u015a\u015b\u0003@"+
		" \u0000\u015b\u015c\u0003B!\u0000\u015c\u015e\u0001\u0000\u0000\u0000"+
		"\u015d\u0156\u0001\u0000\u0000\u0000\u015d\u015a\u0001\u0000\u0000\u0000"+
		"\u015e5\u0001\u0000\u0000\u0000\u015f\u0163\u00038\u001c\u0000\u0160\u0163"+
		"\u0003:\u001d\u0000\u0161\u0163\u0003<\u001e\u0000\u0162\u015f\u0001\u0000"+
		"\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0161\u0001\u0000"+
		"\u0000\u0000\u01637\u0001\u0000\u0000\u0000\u0164\u0165\u0003T*\u0000"+
		"\u0165\u0166\u0005G\u0000\u0000\u0166\u0168\u0001\u0000\u0000\u0000\u0167"+
		"\u0164\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168"+
		"\u0169\u0001\u0000\u0000\u0000\u0169\u016a\u0003@ \u0000\u016a\u016c\u0005"+
		"-\u0000\u0000\u016b\u016d\u0003>\u001f\u0000\u016c\u016b\u0001\u0000\u0000"+
		"\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000"+
		"\u0000\u016e\u016f\u0005.\u0000\u0000\u016f9\u0001\u0000\u0000\u0000\u0170"+
		"\u0171\u0005\u0018\u0000\u0000\u0171\u0172\u0003R)\u0000\u0172\u0174\u0005"+
		"-\u0000\u0000\u0173\u0175\u0003>\u001f\u0000\u0174\u0173\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000"+
		"\u0000\u0176\u0177\u0005.\u0000\u0000\u0177;\u0001\u0000\u0000\u0000\u0178"+
		"\u0179\u0005\u0018\u0000\u0000\u0179\u017f\u0003R)\u0000\u017a\u017c\u0005"+
		"A\u0000\u0000\u017b\u017d\u0003H$\u0000\u017c\u017b\u0001\u0000\u0000"+
		"\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000"+
		"\u0000\u017e\u0180\u0005B\u0000\u0000\u017f\u017a\u0001\u0000\u0000\u0000"+
		"\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000"+
		"\u0181\u0182\u0001\u0000\u0000\u0000\u0182=\u0001\u0000\u0000\u0000\u0183"+
		"\u0184\u0003H$\u0000\u0184\u0185\u0005H\u0000\u0000\u0185\u0187\u0001"+
		"\u0000\u0000\u0000\u0186\u0183\u0001\u0000\u0000\u0000\u0187\u018a\u0001"+
		"\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188\u0189\u0001"+
		"\u0000\u0000\u0000\u0189\u018b\u0001\u0000\u0000\u0000\u018a\u0188\u0001"+
		"\u0000\u0000\u0000\u018b\u018c\u0003H$\u0000\u018c?\u0001\u0000\u0000"+
		"\u0000\u018d\u018e\u0006 \uffff\uffff\u0000\u018e\u018f\u0005K\u0000\u0000"+
		"\u018f\u019e\u0001\u0000\u0000\u0000\u0190\u0193\n\u0002\u0000\u0000\u0191"+
		"\u0192\u0005G\u0000\u0000\u0192\u0194\u0005K\u0000\u0000\u0193\u0191\u0001"+
		"\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195\u0193\u0001"+
		"\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u019d\u0001"+
		"\u0000\u0000\u0000\u0197\u0198\n\u0001\u0000\u0000\u0198\u0199\u0005A"+
		"\u0000\u0000\u0199\u019a\u0003H$\u0000\u019a\u019b\u0005B\u0000\u0000"+
		"\u019b\u019d\u0001\u0000\u0000\u0000\u019c\u0190\u0001\u0000\u0000\u0000"+
		"\u019c\u0197\u0001\u0000\u0000\u0000\u019d\u01a0\u0001\u0000\u0000\u0000"+
		"\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000"+
		"\u019fA\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1"+
		"\u01a2\u0007\u0005\u0000\u0000\u01a2C\u0001\u0000\u0000\u0000\u01a3\u01a4"+
		"\u0007\u0006\u0000\u0000\u01a4E\u0001\u0000\u0000\u0000\u01a5\u01a6\u0006"+
		"#\uffff\uffff\u0000\u01a6G\u0001\u0000\u0000\u0000\u01a7\u01a8\u0006$"+
		"\uffff\uffff\u0000\u01a8\u01a9\u0005#\u0000\u0000\u01a9\u01b5\u0003H$"+
		"\f\u01aa\u01ab\u0005-\u0000\u0000\u01ab\u01ac\u0003L&\u0000\u01ac\u01ad"+
		"\u0005.\u0000\u0000\u01ad\u01ae\u0003H$\u000b\u01ae\u01b5\u0001\u0000"+
		"\u0000\u0000\u01af\u01b0\u0005-\u0000\u0000\u01b0\u01b1\u0003H$\u0000"+
		"\u01b1\u01b2\u0005.\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3"+
		"\u01b5\u0003J%\u0000\u01b4\u01a7\u0001\u0000\u0000\u0000\u01b4\u01aa\u0001"+
		"\u0000\u0000\u0000\u01b4\u01af\u0001\u0000\u0000\u0000\u01b4\u01b3\u0001"+
		"\u0000\u0000\u0000\u01b5\u01d4\u0001\u0000\u0000\u0000\u01b6\u01b7\n\t"+
		"\u0000\u0000\u01b7\u01b8\u00057\u0000\u0000\u01b8\u01d3\u0003H$\n\u01b9"+
		"\u01ba\n\b\u0000\u0000\u01ba\u01bb\u0005%\u0000\u0000\u01bb\u01d3\u0003"+
		"H$\t\u01bc\u01bd\n\u0007\u0000\u0000\u01bd\u01be\u0007\u0007\u0000\u0000"+
		"\u01be\u01d3\u0003H$\b\u01bf\u01c0\n\u0006\u0000\u0000\u01c0\u01c1\u0007"+
		"\b\u0000\u0000\u01c1\u01d3\u0003H$\u0007\u01c2\u01c3\n\u0005\u0000\u0000"+
		"\u01c3\u01c4\u0007\t\u0000\u0000\u01c4\u01d3\u0003H$\u0006\u01c5\u01c6"+
		"\n\u0004\u0000\u0000\u01c6\u01c7\u0007\n\u0000\u0000\u01c7\u01d3\u0003"+
		"H$\u0005\u01c8\u01c9\n\u0003\u0000\u0000\u01c9\u01ca\u0007\u000b\u0000"+
		"\u0000\u01ca\u01d3\u0003H$\u0004\u01cb\u01cc\n\r\u0000\u0000\u01cc\u01d3"+
		"\u0005@\u0000\u0000\u01cd\u01ce\n\u0001\u0000\u0000\u01ce\u01cf\u0005"+
		"A\u0000\u0000\u01cf\u01d0\u0003H$\u0000\u01d0\u01d1\u0005B\u0000\u0000"+
		"\u01d1\u01d3\u0001\u0000\u0000\u0000\u01d2\u01b6\u0001\u0000\u0000\u0000"+
		"\u01d2\u01b9\u0001\u0000\u0000\u0000\u01d2\u01bc\u0001\u0000\u0000\u0000"+
		"\u01d2\u01bf\u0001\u0000\u0000\u0000\u01d2\u01c2\u0001\u0000\u0000\u0000"+
		"\u01d2\u01c5\u0001\u0000\u0000\u0000\u01d2\u01c8\u0001\u0000\u0000\u0000"+
		"\u01d2\u01cb\u0001\u0000\u0000\u0000\u01d2\u01cd\u0001\u0000\u0000\u0000"+
		"\u01d3\u01d6\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000"+
		"\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5I\u0001\u0000\u0000\u0000\u01d6"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d7\u01df\u0005L\u0000\u0000\u01d8\u01df"+
		"\u0005\u000b\u0000\u0000\u01d9\u01df\u0003@ \u0000\u01da\u01df\u0005\f"+
		"\u0000\u0000\u01db\u01df\u0005\r\u0000\u0000\u01dc\u01df\u00036\u001b"+
		"\u0000\u01dd\u01df\u00034\u001a\u0000\u01de\u01d7\u0001\u0000\u0000\u0000"+
		"\u01de\u01d8\u0001\u0000\u0000\u0000\u01de\u01d9\u0001\u0000\u0000\u0000"+
		"\u01de\u01da\u0001\u0000\u0000\u0000\u01de\u01db\u0001\u0000\u0000\u0000"+
		"\u01de\u01dc\u0001\u0000\u0000\u0000\u01de\u01dd\u0001\u0000\u0000\u0000"+
		"\u01dfK\u0001\u0000\u0000\u0000\u01e0\u01e2\u0003R)\u0000\u01e1\u01e3"+
		"\u0003V+\u0000\u01e2\u01e1\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000"+
		"\u0000\u0000\u01e3M\u0001\u0000\u0000\u0000\u01e4\u01ed\u00058\u0000\u0000"+
		"\u01e5\u01ea\u0003P(\u0000\u01e6\u01e7\u0005H\u0000\u0000\u01e7\u01e9"+
		"\u0003P(\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001\u0000"+
		"\u0000\u0000\u01eb\u01ee\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000"+
		"\u0000\u0000\u01ed\u01e5\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000"+
		"\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000\u01ef\u01f0\u00059\u0000"+
		"\u0000\u01f0O\u0001\u0000\u0000\u0000\u01f1\u01f4\u0003L&\u0000\u01f2"+
		"\u01f4\u0005\u0004\u0000\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f2\u0001\u0000\u0000\u0000\u01f4\u01fb\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f8\u0007\f\u0000\u0000\u01f6\u01f7\u0005\u0003\u0000\u0000\u01f7\u01f9"+
		"\u0003R)\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8\u01f9\u0001\u0000"+
		"\u0000\u0000\u01f9\u01fb\u0001\u0000\u0000\u0000\u01fa\u01f3\u0001\u0000"+
		"\u0000\u0000\u01fa\u01f5\u0001\u0000\u0000\u0000\u01fbQ\u0001\u0000\u0000"+
		"\u0000\u01fc\u01fe\u0005!\u0000\u0000\u01fd\u01fc\u0001\u0000\u0000\u0000"+
		"\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000"+
		"\u01ff\u0202\u0005\u0002\u0000\u0000\u0200\u0202\u0003T*\u0000\u0201\u01fd"+
		"\u0001\u0000\u0000\u0000\u0201\u0200\u0001\u0000\u0000\u0000\u0202S\u0001"+
		"\u0000\u0000\u0000\u0203\u0204\u0005K\u0000\u0000\u0204\u0206\u0005G\u0000"+
		"\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0206\u0209\u0001\u0000\u0000"+
		"\u0000\u0207\u0205\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000"+
		"\u0000\u0208\u020a\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000"+
		"\u0000\u020a\u020c\u0005K\u0000\u0000\u020b\u020d\u0003N\'\u0000\u020c"+
		"\u020b\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020d"+
		"U\u0001\u0000\u0000\u0000\u020e\u0217\u0005A\u0000\u0000\u020f\u0214\u0005"+
		"L\u0000\u0000\u0210\u0211\u0005H\u0000\u0000\u0211\u0213\u0005L\u0000"+
		"\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0213\u0216\u0001\u0000\u0000"+
		"\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000"+
		"\u0000\u0215\u0218\u0001\u0000\u0000\u0000\u0216\u0214\u0001\u0000\u0000"+
		"\u0000\u0217\u020f\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000\u0000"+
		"\u0000\u0218\u0219\u0001\u0000\u0000\u0000\u0219\u021a\u0005B\u0000\u0000"+
		"\u021aW\u0001\u0000\u0000\u0000\u021b\u021c\u0005I\u0000\u0000\u021c\u0220"+
		"\u0006,\uffff\uffff\u0000\u021d\u021e\u0005J\u0000\u0000\u021e\u0220\u0006"+
		",\uffff\uffff\u0000\u021f\u021b\u0001\u0000\u0000\u0000\u021f\u021d\u0001"+
		"\u0000\u0000\u0000\u0220Y\u0001\u0000\u0000\u0000\u0221\u0223\u0003\u0006"+
		"\u0003\u0000\u0222\u0221\u0001\u0000\u0000\u0000\u0223\u0226\u0001\u0000"+
		"\u0000\u0000\u0224\u0225\u0001\u0000\u0000\u0000\u0224\u0222\u0001\u0000"+
		"\u0000\u0000\u0225\u022a\u0001\u0000\u0000\u0000\u0226\u0224\u0001\u0000"+
		"\u0000\u0000\u0227\u0229\u0007\u0002\u0000\u0000\u0228\u0227\u0001\u0000"+
		"\u0000\u0000\u0229\u022c\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000"+
		"\u0000\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022b\u022e\u0001\u0000"+
		"\u0000\u0000\u022c\u022a\u0001\u0000\u0000\u0000\u022d\u022f\u0003N\'"+
		"\u0000\u022e\u022d\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000"+
		"\u0000\u022f\u0230\u0001\u0000\u0000\u0000\u0230\u0231\u0003L&\u0000\u0231"+
		"\u0237\u0005K\u0000\u0000\u0232\u0235\u00051\u0000\u0000\u0233\u0236\u0003"+
		"H$\u0000\u0234\u0236\u0003\u0014\n\u0000\u0235\u0233\u0001\u0000\u0000"+
		"\u0000\u0235\u0234\u0001\u0000\u0000\u0000\u0236\u0238\u0001\u0000\u0000"+
		"\u0000\u0237\u0232\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000"+
		"\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239\u023a\u0003F#\u0000\u023a"+
		"[\u0001\u0000\u0000\u0000Fbdfly\u0081\u0087\u008d\u0091\u0099\u00a4\u00a6"+
		"\u00ab\u00b1\u00b5\u00be\u00c8\u00cb\u00d3\u00d8\u00da\u00dc\u00e8\u00f1"+
		"\u00f6\u00fc\u0100\u0112\u0122\u0124\u012e\u0130\u0136\u013d\u0140\u0148"+
		"\u014f\u015d\u0162\u0167\u016c\u0174\u017c\u0181\u0188\u0195\u019c\u019e"+
		"\u01b4\u01d2\u01d4\u01de\u01e2\u01ea\u01ed\u01f3\u01f8\u01fa\u01fd\u0201"+
		"\u0207\u020c\u0214\u0217\u021f\u0224\u022a\u022e\u0235\u0237";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}