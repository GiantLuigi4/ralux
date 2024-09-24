package tfc.ralux.compiler.parse;// Generated from C:/Users/User/IdeaProjects/RaluxYetAgain/grammar/Ralux.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RaluxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PRIMITIVE=2, GENERIC_CONSTRAINT=3, GENERIC_WILDCARD=4, C_TYPE=5, 
		PRIMITIVE_INT=6, PRIMITIVE_FP=7, PRIMITIVE_OTHER=8, MODIFIER=9, STATIC=10, 
		CONSTANT=11, STRING=12, CHR=13, TRUE=14, FALSE=15, NULL=16, USE=17, PKG=18, 
		CLASS=19, INTERFACE=20, EXTENDS=21, SUPER=22, INSTANCE_OF=23, NEW=24, 
		IF=25, FOR=26, WHILE=27, DO=28, UNSIGNED=29, BREAK=30, CONTINUE=31, RETURN=32, 
		PLUS=33, MINUS=34, MUL=35, POW=36, DIV=37, XOR=38, BOR=39, BAND=40, MOD=41, 
		OR=42, AND=43, LPAREN=44, RPAREN=45, INC_INC=46, DEC_DEC=47, EQUAL=48, 
		PLUS_EQUAL=49, MINUS_EQUAL=50, DIV_EQUAL=51, MUL_EQUAL=52, MOD_EQUAL=53, 
		LESS=54, GREATER=55, LEQUAL=56, GEQUAL=57, EEQUAL=58, NEQUAL=59, DEQUAL=60, 
		DHASH=61, L_BRACKET=62, R_BRACKET=63, L_CURLY=64, R_CURLY=65, SEMI=66, 
		QUESTION=67, DOT=68, COMMA=69, INFER_STATEMENTS=70, ENFORCE_STATEMENTS=71, 
		WORD=72, NUMBER=73, INFERRED_DECIMAL=74, HALF=75, FLOAT=76, DOUBLE=77, 
		LONG=78, SHORT=79, INT=80, BYTE=81, INUM=82, NL=83, WS=84, COMMENT=85, 
		BLOCK_COMMENT=86;
	public static final int
		RULE_file = 0, RULE_header = 1, RULE_static_use = 2, RULE_annotation = 3, 
		RULE_class = 4, RULE_c_body = 5, RULE_c_component = 6, RULE_method = 7, 
		RULE_def_params = 8, RULE_statement_list = 9, RULE_body = 10, RULE_statement = 11, 
		RULE_ret = 12, RULE_flow = 13, RULE_loop = 14, RULE_special = 15, RULE_state_end = 16, 
		RULE_label = 17, RULE_do = 18, RULE_while = 19, RULE_while_header = 20, 
		RULE_if = 21, RULE_for = 22, RULE_loop_enhanced = 23, RULE_loop_standard = 24, 
		RULE_definition = 25, RULE_assignment = 26, RULE_call = 27, RULE_method_call = 28, 
		RULE_ctor = 29, RULE_params = 30, RULE_dOperand = 31, RULE_operand = 32, 
		RULE_semi_truck = 33, RULE_expr = 34, RULE_full_type = 35, RULE_generic = 36, 
		RULE_generic_element = 37, RULE_type = 38, RULE_named_type = 39, RULE_array = 40, 
		RULE_directive = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "header", "static_use", "annotation", "class", "c_body", "c_component", 
			"method", "def_params", "statement_list", "body", "statement", "ret", 
			"flow", "loop", "special", "state_end", "label", "do", "while", "while_header", 
			"if", "for", "loop_enhanced", "loop_standard", "definition", "assignment", 
			"call", "method_call", "ctor", "params", "dOperand", "operand", "semi_truck", 
			"expr", "full_type", "generic", "generic_element", "type", "named_type", 
			"array", "directive"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, null, null, null, null, null, null, null, "'static'", 
			null, null, null, "'true'", "'false'", "'null'", "'use'", "'pkg'", "'class'", 
			"'interface'", "'extends'", "'super'", "'instanceof'", "'new'", "'if'", 
			"'for'", "'while'", "'do'", "'unsigned'", "'break'", "'continue'", "'return'", 
			"'+'", "'-'", "'*'", "'**'", "'/'", "'^'", "'|'", "'&'", "'%'", "'||'", 
			"'&&'", "'('", "')'", "'++'", "'--'", "'='", "'+='", "'-='", "'/='", 
			"'*='", "'%='", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'.='", 
			"'.#'", "'['", "']'", "'{'", "'}'", "';'", "'?'", "'.'", "','", "'%infer_semicolon%'", 
			"'%enforce_semicolon%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "PRIMITIVE", "GENERIC_CONSTRAINT", "GENERIC_WILDCARD", "C_TYPE", 
			"PRIMITIVE_INT", "PRIMITIVE_FP", "PRIMITIVE_OTHER", "MODIFIER", "STATIC", 
			"CONSTANT", "STRING", "CHR", "TRUE", "FALSE", "NULL", "USE", "PKG", "CLASS", 
			"INTERFACE", "EXTENDS", "SUPER", "INSTANCE_OF", "NEW", "IF", "FOR", "WHILE", 
			"DO", "UNSIGNED", "BREAK", "CONTINUE", "RETURN", "PLUS", "MINUS", "MUL", 
			"POW", "DIV", "XOR", "BOR", "BAND", "MOD", "OR", "AND", "LPAREN", "RPAREN", 
			"INC_INC", "DEC_DEC", "EQUAL", "PLUS_EQUAL", "MINUS_EQUAL", "DIV_EQUAL", 
			"MUL_EQUAL", "MOD_EQUAL", "LESS", "GREATER", "LEQUAL", "GEQUAL", "EEQUAL", 
			"NEQUAL", "DEQUAL", "DHASH", "L_BRACKET", "R_BRACKET", "L_CURLY", "R_CURLY", 
			"SEMI", "QUESTION", "DOT", "COMMA", "INFER_STATEMENTS", "ENFORCE_STATEMENTS", 
			"WORD", "NUMBER", "INFERRED_DECIMAL", "HALF", "FLOAT", "DOUBLE", "LONG", 
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
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018427782688L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 49L) != 0)) {
				{
				setState(92);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INFER_STATEMENTS:
				case ENFORCE_STATEMENTS:
					{
					setState(84);
					directive();
					}
					break;
				case USE:
				case PKG:
					{
					setState(85);
					header();
					}
					break;
				case C_TYPE:
				case MODIFIER:
				case STATIC:
				case L_BRACKET:
					{
					setState(86);
					class_();
					}
					break;
				case SEMI:
					{
					{
					setState(88); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(87);
							match(SEMI);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(90); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(96);
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
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				{
				setState(97);
				static_use();
				}
				}
				break;
			case 2:
				{
				setState(98);
				_la = _input.LA(1);
				if ( !(_la==USE || _la==PKG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				named_type();
				}
				break;
			}
			setState(102);
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
			setState(104);
			match(USE);
			setState(105);
			match(STATIC);
			setState(106);
			named_type();
			setState(107);
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
			setState(109);
			match(L_BRACKET);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9223372036854775806L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 8388607L) != 0)) {
				{
				{
				setState(110);
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
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(118);
					annotation();
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(124);
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
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(130);
			match(C_TYPE);
			setState(131);
			match(WORD);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(132);
				generic();
				}
			}

			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(135);
				match(EXTENDS);
				setState(136);
				type();
				}
			}

			setState(139);
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
			setState(141);
			match(L_CURLY);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4629700417473742372L) != 0) || _la==SEMI || _la==WORD) {
				{
				{
				setState(142);
				c_component();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
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
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				class_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				method();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(153); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(152);
						match(SEMI);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(155); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public GenericContext generic() {
			return getRuleContext(GenericContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(RaluxParser.SEMI, 0); }
		public Semi_truckContext semi_truck() {
			return getRuleContext(Semi_truckContext.class,0);
		}
		public List<TerminalNode> MODIFIER() { return getTokens(RaluxParser.MODIFIER); }
		public TerminalNode MODIFIER(int i) {
			return getToken(RaluxParser.MODIFIER, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(RaluxParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(RaluxParser.STATIC, i);
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
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(159);
					annotation();
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(165);
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
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(171);
				generic();
				}
			}

			setState(174);
			full_type();
			setState(175);
			match(WORD);
			setState(176);
			match(LPAREN);
			setState(177);
			def_params();
			setState(178);
			match(RPAREN);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_CURLY) {
				{
				setState(179);
				body();
				}
			}

			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(182);
				match(SEMI);
				setState(183);
				semi_truck();
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
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMITIVE || _la==UNSIGNED || _la==WORD) {
				{
				setState(186);
				full_type();
				setState(187);
				match(WORD);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(188);
					match(COMMA);
					setState(189);
					full_type();
					setState(190);
					match(WORD);
					}
					}
					setState(196);
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
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8573157380L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 453L) != 0)) {
				{
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(199);
					body();
					}
					break;
				case 2:
					{
					setState(200);
					flow();
					}
					break;
				case 3:
					{
					setState(210);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(201);
						directive();
						}
						break;
					case 2:
						{
						setState(203); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(202);
								match(SEMI);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(205); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
						} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 3:
						{
						{
						setState(207);
						statement();
						setState(208);
						semi_truck();
						}
						}
						break;
					}
					}
					break;
				}
				}
				setState(216);
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
			setState(217);
			match(L_CURLY);
			setState(218);
			statement_list();
			setState(219);
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
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
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
			setState(228);
			match(RETURN);
			setState(229);
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
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				if_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				loop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				special();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(234);
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
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(237);
				label();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(243);
				for_();
				}
				break;
			case WHILE:
				{
				setState(244);
				while_();
				}
				break;
			case DO:
				{
				setState(245);
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
			setState(248);
			_la = _input.LA(1);
			if ( !(_la==BREAK || _la==CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(249);
				match(WORD);
				}
			}

			}
			setState(252);
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
			setState(254);
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
			setState(256);
			match(WORD);
			setState(257);
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
			setState(259);
			match(DO);
			setState(260);
			body();
			setState(261);
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
			setState(263);
			while_header();
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(264);
				body();
				}
				break;
			case PRIMITIVE:
			case NEW:
			case UNSIGNED:
			case RETURN:
			case INFER_STATEMENTS:
			case ENFORCE_STATEMENTS:
			case WORD:
				{
				{
				setState(265);
				statement();
				setState(266);
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
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
			setState(270);
			match(WHILE);
			setState(271);
			match(LPAREN);
			{
			setState(272);
			expr(0);
			}
			setState(273);
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
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Semi_truckContext semi_truck() {
			return getRuleContext(Semi_truckContext.class,0);
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
			setState(275);
			match(IF);
			setState(276);
			match(LPAREN);
			setState(277);
			expr(0);
			setState(278);
			match(RPAREN);
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(279);
				body();
				}
				break;
			case PRIMITIVE:
			case NEW:
			case UNSIGNED:
			case RETURN:
			case INFER_STATEMENTS:
			case ENFORCE_STATEMENTS:
			case WORD:
				{
				{
				setState(280);
				statement();
				setState(281);
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
			setState(285);
			match(FOR);
			setState(286);
			match(LPAREN);
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(287);
				loop_enhanced();
				}
				break;
			case 2:
				{
				setState(288);
				loop_standard();
				}
				break;
			}
			setState(291);
			match(RPAREN);
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(292);
				body();
				}
				break;
			case PRIMITIVE:
			case NEW:
			case UNSIGNED:
			case RETURN:
			case INFER_STATEMENTS:
			case ENFORCE_STATEMENTS:
			case WORD:
				{
				{
				setState(293);
				statement();
				setState(294);
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
			{
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(298);
				full_type();
				}
				break;
			}
			setState(301);
			match(WORD);
			setState(302);
			match(T__0);
			setState(303);
			expr(0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(305);
				statement();
				}
				break;
			}
			}
			setState(308);
			semi_truck();
			{
			setState(309);
			expr(0);
			}
			setState(310);
			semi_truck();
			{
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4848615428L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 7L) != 0)) {
				{
				setState(311);
				statement();
				}
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
			setState(314);
			full_type();
			setState(315);
			match(WORD);
			setState(316);
			match(EQUAL);
			setState(317);
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
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
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
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(319);
				match(WORD);
				setState(320);
				operand();
				setState(321);
				expr(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(323);
				match(WORD);
				setState(324);
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
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				method_call();
				}
				break;
			case NEW:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				ctor();
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
	public static class Method_callContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public Named_typeContext named_type() {
			return getRuleContext(Named_typeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RaluxParser.DOT, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(331);
				named_type();
				setState(332);
				match(DOT);
				}
				break;
			}
			setState(336);
			match(WORD);
			setState(337);
			match(LPAREN);
			setState(338);
			params();
			setState(339);
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
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(NEW);
			setState(342);
			type();
			setState(343);
			match(LPAREN);
			setState(344);
			params();
			setState(345);
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
		enterRule(_localctx, 60, RULE_params);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(347);
					expr(0);
					setState(348);
					match(COMMA);
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & 6917529036231024647L) != 0)) {
				{
				setState(355);
				expr(0);
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
		enterRule(_localctx, 62, RULE_dOperand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
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
		enterRule(_localctx, 64, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732923532771328L) != 0)) ) {
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
		public List<TerminalNode> SEMI() { return getTokens(RaluxParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(RaluxParser.SEMI, i);
		}
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
		enterRule(_localctx, 66, RULE_semi_truck);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				{
				setState(363); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(362);
						match(SEMI);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(365); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				}
				break;
			case 2:
				{
				{
				setState(367);
				if (!(inferSemicolons)) throw new FailedPredicateException(this, "inferSemicolons");
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
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(RaluxParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(RaluxParser.RPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(RaluxParser.NUMBER, 0); }
		public TerminalNode CONSTANT() { return getToken(RaluxParser.CONSTANT, 0); }
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
		public TerminalNode STRING() { return getToken(RaluxParser.STRING, 0); }
		public TerminalNode CHR() { return getToken(RaluxParser.CHR, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode POW() { return getToken(RaluxParser.POW, 0); }
		public TerminalNode MUL() { return getToken(RaluxParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(RaluxParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(RaluxParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(RaluxParser.MINUS, 0); }
		public TerminalNode MOD() { return getToken(RaluxParser.MOD, 0); }
		public TerminalNode BAND() { return getToken(RaluxParser.BAND, 0); }
		public TerminalNode XOR() { return getToken(RaluxParser.XOR, 0); }
		public TerminalNode BOR() { return getToken(RaluxParser.BOR, 0); }
		public TerminalNode AND() { return getToken(RaluxParser.AND, 0); }
		public TerminalNode OR() { return getToken(RaluxParser.OR, 0); }
		public TerminalNode LESS() { return getToken(RaluxParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(RaluxParser.GREATER, 0); }
		public TerminalNode LEQUAL() { return getToken(RaluxParser.LEQUAL, 0); }
		public TerminalNode GEQUAL() { return getToken(RaluxParser.GEQUAL, 0); }
		public TerminalNode EEQUAL() { return getToken(RaluxParser.EEQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(RaluxParser.NEQUAL, 0); }
		public TerminalNode DEQUAL() { return getToken(RaluxParser.DEQUAL, 0); }
		public TerminalNode DHASH() { return getToken(RaluxParser.DHASH, 0); }
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
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(371);
				match(LPAREN);
				setState(372);
				expr(0);
				setState(373);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(375);
				match(NUMBER);
				}
				break;
			case 3:
				{
				setState(376);
				match(CONSTANT);
				}
				break;
			case 4:
				{
				setState(377);
				match(WORD);
				}
				break;
			case 5:
				{
				setState(378);
				match(STRING);
				}
				break;
			case 6:
				{
				setState(379);
				match(CHR);
				}
				break;
			case 7:
				{
				setState(380);
				call();
				}
				break;
			case 8:
				{
				setState(381);
				assignment();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(391);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(389);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(384);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(385);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2287846194300321792L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(386);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(387);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(388);
						match(DHASH);
						}
						break;
					}
					} 
				}
				setState(393);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
		enterRule(_localctx, 70, RULE_full_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			type();
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_BRACKET) {
				{
				setState(395);
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
		enterRule(_localctx, 72, RULE_generic);
		int _la;
		try {
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(398);
				match(LESS);
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536870932L) != 0) || _la==WORD) {
					{
					setState(399);
					generic_element();
					setState(404);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(400);
						match(COMMA);
						setState(401);
						generic_element();
						}
						}
						setState(406);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(409);
				match(GREATER);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(410);
				match(LESS);
				setState(411);
				match(GREATER);
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
		enterRule(_localctx, 74, RULE_generic_element);
		int _la;
		try {
			setState(423);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(416);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRIMITIVE:
				case UNSIGNED:
				case WORD:
					{
					setState(414);
					full_type();
					}
					break;
				case GENERIC_WILDCARD:
					{
					setState(415);
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
				setState(418);
				_la = _input.LA(1);
				if ( !(_la==GENERIC_WILDCARD || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERIC_CONSTRAINT) {
					{
					setState(419);
					match(GENERIC_CONSTRAINT);
					setState(420);
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
		enterRule(_localctx, 76, RULE_type);
		int _la;
		try {
			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE:
			case UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNSIGNED) {
					{
					setState(425);
					match(UNSIGNED);
					}
				}

				setState(428);
				match(PRIMITIVE);
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
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
		enterRule(_localctx, 78, RULE_named_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(432);
					match(WORD);
					setState(433);
					match(DOT);
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(439);
			match(WORD);
			{
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(440);
				generic();
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
		enterRule(_localctx, 80, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(L_BRACKET);
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(444);
				match(NUMBER);
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(445);
					match(COMMA);
					setState(446);
					match(NUMBER);
					}
					}
					setState(451);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(454);
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
		enterRule(_localctx, 82, RULE_directive);
		try {
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INFER_STATEMENTS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(456);
				match(INFER_STATEMENTS);
				 inferSemicolons = true; 
				}
				}
				break;
			case ENFORCE_STATEMENTS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(458);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 33:
			return semi_truck_sempred((Semi_truckContext)_localctx, predIndex);
		case 34:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean semi_truck_sempred(Semi_truckContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return inferSemicolons;
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001V\u01cf\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000Y\b\u0000\u000b\u0000\f\u0000Z\u0005\u0000]\b\u0000\n\u0000"+
		"\f\u0000`\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001e\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003p\b\u0003\n\u0003\f\u0003"+
		"s\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004x\b\u0004\n\u0004"+
		"\f\u0004{\t\u0004\u0001\u0004\u0005\u0004~\b\u0004\n\u0004\f\u0004\u0081"+
		"\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0086\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u008a\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0090\b\u0005\n\u0005\f\u0005\u0093"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006\u009a\b\u0006\u000b\u0006\f\u0006\u009b\u0003\u0006\u009e\b\u0006"+
		"\u0001\u0007\u0005\u0007\u00a1\b\u0007\n\u0007\f\u0007\u00a4\t\u0007\u0001"+
		"\u0007\u0005\u0007\u00a7\b\u0007\n\u0007\f\u0007\u00aa\t\u0007\u0001\u0007"+
		"\u0003\u0007\u00ad\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00b5\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u00b9\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u00c1\b\b\n\b\f\b\u00c4\t\b\u0003\b\u00c6\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0004\t\u00cc\b\t\u000b\t\f\t\u00cd\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u00d3\b\t\u0005\t\u00d5\b\t\n\t\f\t\u00d8\t\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00e3\b\u000b\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u00ec\b\r\u0001\u000e\u0005\u000e\u00ef"+
		"\b\u000e\n\u000e\f\u000e\u00f2\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00f7\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00fb\b"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u010d"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u011c\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u0122\b\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0129\b\u0016\u0001\u0017\u0003"+
		"\u0017\u012c\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0003\u0018\u0133\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0139\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u0146\b\u001a\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u014a\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u014f"+
		"\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u015f\b\u001e\n\u001e\f\u001e"+
		"\u0162\t\u001e\u0001\u001e\u0003\u001e\u0165\b\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001!\u0004!\u016c\b!\u000b!\f!\u016d\u0001!\u0003"+
		"!\u0171\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u017f\b\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0005\"\u0186\b\"\n\"\f\"\u0189\t\"\u0001#\u0001#\u0003"+
		"#\u018d\b#\u0001$\u0001$\u0001$\u0001$\u0005$\u0193\b$\n$\f$\u0196\t$"+
		"\u0003$\u0198\b$\u0001$\u0001$\u0001$\u0003$\u019d\b$\u0001%\u0001%\u0003"+
		"%\u01a1\b%\u0001%\u0001%\u0001%\u0003%\u01a6\b%\u0003%\u01a8\b%\u0001"+
		"&\u0003&\u01ab\b&\u0001&\u0001&\u0003&\u01af\b&\u0001\'\u0001\'\u0005"+
		"\'\u01b3\b\'\n\'\f\'\u01b6\t\'\u0001\'\u0001\'\u0003\'\u01ba\b\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0005(\u01c0\b(\n(\f(\u01c3\t(\u0003(\u01c5\b("+
		"\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0003)\u01cd\b)\u0001)\u0005"+
		"y\u007f\u00a2\u00a8\u0160\u0001D*\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPR\u0000\t\u0001\u0000\u0011\u0012\u0001\u0000??\u0001\u0000\t\n\u0001"+
		"\u0000\u001e\u001f\u0002\u0000BBSS\u0001\u0000./\u0001\u000005\u0002\u0000"+
		"!+6<\u0002\u0000\u0004\u0004HH\u01f0\u0000^\u0001\u0000\u0000\u0000\u0002"+
		"d\u0001\u0000\u0000\u0000\u0004h\u0001\u0000\u0000\u0000\u0006m\u0001"+
		"\u0000\u0000\u0000\by\u0001\u0000\u0000\u0000\n\u008d\u0001\u0000\u0000"+
		"\u0000\f\u009d\u0001\u0000\u0000\u0000\u000e\u00a2\u0001\u0000\u0000\u0000"+
		"\u0010\u00c5\u0001\u0000\u0000\u0000\u0012\u00d6\u0001\u0000\u0000\u0000"+
		"\u0014\u00d9\u0001\u0000\u0000\u0000\u0016\u00e2\u0001\u0000\u0000\u0000"+
		"\u0018\u00e4\u0001\u0000\u0000\u0000\u001a\u00eb\u0001\u0000\u0000\u0000"+
		"\u001c\u00f0\u0001\u0000\u0000\u0000\u001e\u00f8\u0001\u0000\u0000\u0000"+
		" \u00fe\u0001\u0000\u0000\u0000\"\u0100\u0001\u0000\u0000\u0000$\u0103"+
		"\u0001\u0000\u0000\u0000&\u0107\u0001\u0000\u0000\u0000(\u010e\u0001\u0000"+
		"\u0000\u0000*\u0113\u0001\u0000\u0000\u0000,\u011d\u0001\u0000\u0000\u0000"+
		".\u012b\u0001\u0000\u0000\u00000\u0132\u0001\u0000\u0000\u00002\u013a"+
		"\u0001\u0000\u0000\u00004\u0145\u0001\u0000\u0000\u00006\u0149\u0001\u0000"+
		"\u0000\u00008\u014e\u0001\u0000\u0000\u0000:\u0155\u0001\u0000\u0000\u0000"+
		"<\u0160\u0001\u0000\u0000\u0000>\u0166\u0001\u0000\u0000\u0000@\u0168"+
		"\u0001\u0000\u0000\u0000B\u0170\u0001\u0000\u0000\u0000D\u017e\u0001\u0000"+
		"\u0000\u0000F\u018a\u0001\u0000\u0000\u0000H\u019c\u0001\u0000\u0000\u0000"+
		"J\u01a7\u0001\u0000\u0000\u0000L\u01ae\u0001\u0000\u0000\u0000N\u01b4"+
		"\u0001\u0000\u0000\u0000P\u01bb\u0001\u0000\u0000\u0000R\u01cc\u0001\u0000"+
		"\u0000\u0000T]\u0003R)\u0000U]\u0003\u0002\u0001\u0000V]\u0003\b\u0004"+
		"\u0000WY\u0005B\u0000\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000"+
		"\u0000\u0000\\T\u0001\u0000\u0000\u0000\\U\u0001\u0000\u0000\u0000\\V"+
		"\u0001\u0000\u0000\u0000\\X\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0001\u0001"+
		"\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ae\u0003\u0004\u0002\u0000"+
		"bc\u0007\u0000\u0000\u0000ce\u0003N\'\u0000da\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0003B!\u0000g"+
		"\u0003\u0001\u0000\u0000\u0000hi\u0005\u0011\u0000\u0000ij\u0005\n\u0000"+
		"\u0000jk\u0003N\'\u0000kl\u0005H\u0000\u0000l\u0005\u0001\u0000\u0000"+
		"\u0000mq\u0005>\u0000\u0000np\b\u0001\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005"+
		"?\u0000\u0000u\u0007\u0001\u0000\u0000\u0000vx\u0003\u0006\u0003\u0000"+
		"wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000z\u007f\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|~\u0007\u0002\u0000\u0000}|\u0001\u0000\u0000\u0000"+
		"~\u0081\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u007f"+
		"}\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0005\u0000\u0000\u0083\u0085"+
		"\u0005H\u0000\u0000\u0084\u0086\u0003H$\u0000\u0085\u0084\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005\u0015\u0000\u0000\u0088\u008a\u0003L&\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0003\n\u0005\u0000\u008c"+
		"\t\u0001\u0000\u0000\u0000\u008d\u0091\u0005@\u0000\u0000\u008e\u0090"+
		"\u0003\f\u0006\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0093\u0001"+
		"\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001"+
		"\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0005A\u0000\u0000\u0095\u000b\u0001\u0000"+
		"\u0000\u0000\u0096\u009e\u0003\b\u0004\u0000\u0097\u009e\u0003\u000e\u0007"+
		"\u0000\u0098\u009a\u0005B\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000"+
		"\u009d\u0096\u0001\u0000\u0000\u0000\u009d\u0097\u0001\u0000\u0000\u0000"+
		"\u009d\u0099\u0001\u0000\u0000\u0000\u009e\r\u0001\u0000\u0000\u0000\u009f"+
		"\u00a1\u0003\u0006\u0003\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a8\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7\u0007\u0002\u0000\u0000\u00a6"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ad\u0003H$\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0003"+
		"F#\u0000\u00af\u00b0\u0005H\u0000\u0000\u00b0\u00b1\u0005,\u0000\u0000"+
		"\u00b1\u00b2\u0003\u0010\b\u0000\u00b2\u00b4\u0005-\u0000\u0000\u00b3"+
		"\u00b5\u0003\u0014\n\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0005B\u0000\u0000\u00b7\u00b9\u0003B!\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u000f\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0003F#\u0000\u00bb\u00c2\u0005H\u0000\u0000"+
		"\u00bc\u00bd\u0005E\u0000\u0000\u00bd\u00be\u0003F#\u0000\u00be\u00bf"+
		"\u0005H\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00ba\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u0011\u0001"+
		"\u0000\u0000\u0000\u00c7\u00d5\u0003\u0014\n\u0000\u00c8\u00d5\u0003\u001a"+
		"\r\u0000\u00c9\u00d3\u0003R)\u0000\u00ca\u00cc\u0005B\u0000\u0000\u00cb"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d3\u0001\u0000\u0000\u0000\u00cf\u00d0\u0003\u0016\u000b\u0000\u00d0"+
		"\u00d1\u0003B!\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00c9\u0001"+
		"\u0000\u0000\u0000\u00d2\u00cb\u0001\u0000\u0000\u0000\u00d2\u00cf\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00c7\u0001"+
		"\u0000\u0000\u0000\u00d4\u00c8\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u0013\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da\u0005"+
		"@\u0000\u0000\u00da\u00db\u0003\u0012\t\u0000\u00db\u00dc\u0005A\u0000"+
		"\u0000\u00dc\u0015\u0001\u0000\u0000\u0000\u00dd\u00e3\u00036\u001b\u0000"+
		"\u00de\u00e3\u00032\u0019\u0000\u00df\u00e3\u00034\u001a\u0000\u00e0\u00e3"+
		"\u0003R)\u0000\u00e1\u00e3\u0003\u0018\f\u0000\u00e2\u00dd\u0001\u0000"+
		"\u0000\u0000\u00e2\u00de\u0001\u0000\u0000\u0000\u00e2\u00df\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e3\u0017\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005 \u0000"+
		"\u0000\u00e5\u00e6\u0003D\"\u0000\u00e6\u0019\u0001\u0000\u0000\u0000"+
		"\u00e7\u00ec\u0003*\u0015\u0000\u00e8\u00ec\u0003\u001c\u000e\u0000\u00e9"+
		"\u00ec\u0003\u001e\u000f\u0000\u00ea\u00ec\u0003\"\u0011\u0000\u00eb\u00e7"+
		"\u0001\u0000\u0000\u0000\u00eb\u00e8\u0001\u0000\u0000\u0000\u00eb\u00e9"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec\u001b"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ef\u0003\"\u0011\u0000\u00ee\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f7\u0003"+
		",\u0016\u0000\u00f4\u00f7\u0003&\u0013\u0000\u00f5\u00f7\u0003$\u0012"+
		"\u0000\u00f6\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f7\u001d\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fa\u0007\u0003\u0000\u0000\u00f9\u00fb\u0005H\u0000\u0000"+
		"\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0003 \u0010\u0000\u00fd"+
		"\u001f\u0001\u0000\u0000\u0000\u00fe\u00ff\u0007\u0004\u0000\u0000\u00ff"+
		"!\u0001\u0000\u0000\u0000\u0100\u0101\u0005H\u0000\u0000\u0101\u0102\u0005"+
		"\u0001\u0000\u0000\u0102#\u0001\u0000\u0000\u0000\u0103\u0104\u0005\u001c"+
		"\u0000\u0000\u0104\u0105\u0003\u0014\n\u0000\u0105\u0106\u0003(\u0014"+
		"\u0000\u0106%\u0001\u0000\u0000\u0000\u0107\u010c\u0003(\u0014\u0000\u0108"+
		"\u010d\u0003\u0014\n\u0000\u0109\u010a\u0003\u0016\u000b\u0000\u010a\u010b"+
		"\u0003B!\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u0108\u0001\u0000"+
		"\u0000\u0000\u010c\u0109\u0001\u0000\u0000\u0000\u010d\'\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0005\u001b\u0000\u0000\u010f\u0110\u0005,\u0000\u0000"+
		"\u0110\u0111\u0003D\"\u0000\u0111\u0112\u0005-\u0000\u0000\u0112)\u0001"+
		"\u0000\u0000\u0000\u0113\u0114\u0005\u0019\u0000\u0000\u0114\u0115\u0005"+
		",\u0000\u0000\u0115\u0116\u0003D\"\u0000\u0116\u011b\u0005-\u0000\u0000"+
		"\u0117\u011c\u0003\u0014\n\u0000\u0118\u0119\u0003\u0016\u000b\u0000\u0119"+
		"\u011a\u0003B!\u0000\u011a\u011c\u0001\u0000\u0000\u0000\u011b\u0117\u0001"+
		"\u0000\u0000\u0000\u011b\u0118\u0001\u0000\u0000\u0000\u011c+\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0005\u001a\u0000\u0000\u011e\u0121\u0005,\u0000"+
		"\u0000\u011f\u0122\u0003.\u0017\u0000\u0120\u0122\u00030\u0018\u0000\u0121"+
		"\u011f\u0001\u0000\u0000\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0001\u0000\u0000\u0000\u0123\u0128\u0005-\u0000\u0000\u0124\u0129"+
		"\u0003\u0014\n\u0000\u0125\u0126\u0003\u0016\u000b\u0000\u0126\u0127\u0003"+
		"B!\u0000\u0127\u0129\u0001\u0000\u0000\u0000\u0128\u0124\u0001\u0000\u0000"+
		"\u0000\u0128\u0125\u0001\u0000\u0000\u0000\u0129-\u0001\u0000\u0000\u0000"+
		"\u012a\u012c\u0003F#\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012b\u012c"+
		"\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012e"+
		"\u0005H\u0000\u0000\u012e\u012f\u0005\u0001\u0000\u0000\u012f\u0130\u0003"+
		"D\"\u0000\u0130/\u0001\u0000\u0000\u0000\u0131\u0133\u0003\u0016\u000b"+
		"\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000"+
		"\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0003B!\u0000\u0135"+
		"\u0136\u0003D\"\u0000\u0136\u0138\u0003B!\u0000\u0137\u0139\u0003\u0016"+
		"\u000b\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000"+
		"\u0000\u0000\u01391\u0001\u0000\u0000\u0000\u013a\u013b\u0003F#\u0000"+
		"\u013b\u013c\u0005H\u0000\u0000\u013c\u013d\u00050\u0000\u0000\u013d\u013e"+
		"\u0003D\"\u0000\u013e3\u0001\u0000\u0000\u0000\u013f\u0140\u0005H\u0000"+
		"\u0000\u0140\u0141\u0003@ \u0000\u0141\u0142\u0003D\"\u0000\u0142\u0146"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0005H\u0000\u0000\u0144\u0146\u0003"+
		">\u001f\u0000\u0145\u013f\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000"+
		"\u0000\u0000\u01465\u0001\u0000\u0000\u0000\u0147\u014a\u00038\u001c\u0000"+
		"\u0148\u014a\u0003:\u001d\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149"+
		"\u0148\u0001\u0000\u0000\u0000\u014a7\u0001\u0000\u0000\u0000\u014b\u014c"+
		"\u0003N\'\u0000\u014c\u014d\u0005D\u0000\u0000\u014d\u014f\u0001\u0000"+
		"\u0000\u0000\u014e\u014b\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000"+
		"\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0151\u0005H\u0000"+
		"\u0000\u0151\u0152\u0005,\u0000\u0000\u0152\u0153\u0003<\u001e\u0000\u0153"+
		"\u0154\u0005-\u0000\u0000\u01549\u0001\u0000\u0000\u0000\u0155\u0156\u0005"+
		"\u0018\u0000\u0000\u0156\u0157\u0003L&\u0000\u0157\u0158\u0005,\u0000"+
		"\u0000\u0158\u0159\u0003<\u001e\u0000\u0159\u015a\u0005-\u0000\u0000\u015a"+
		";\u0001\u0000\u0000\u0000\u015b\u015c\u0003D\"\u0000\u015c\u015d\u0005"+
		"E\u0000\u0000\u015d\u015f\u0001\u0000\u0000\u0000\u015e\u015b\u0001\u0000"+
		"\u0000\u0000\u015f\u0162\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000"+
		"\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0164\u0001\u0000"+
		"\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0163\u0165\u0003D\""+
		"\u0000\u0164\u0163\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000"+
		"\u0000\u0165=\u0001\u0000\u0000\u0000\u0166\u0167\u0007\u0005\u0000\u0000"+
		"\u0167?\u0001\u0000\u0000\u0000\u0168\u0169\u0007\u0006\u0000\u0000\u0169"+
		"A\u0001\u0000\u0000\u0000\u016a\u016c\u0005B\u0000\u0000\u016b\u016a\u0001"+
		"\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016b\u0001"+
		"\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u0171\u0001"+
		"\u0000\u0000\u0000\u016f\u0171\u0004!\u0000\u0000\u0170\u016b\u0001\u0000"+
		"\u0000\u0000\u0170\u016f\u0001\u0000\u0000\u0000\u0171C\u0001\u0000\u0000"+
		"\u0000\u0172\u0173\u0006\"\uffff\uffff\u0000\u0173\u0174\u0005,\u0000"+
		"\u0000\u0174\u0175\u0003D\"\u0000\u0175\u0176\u0005-\u0000\u0000\u0176"+
		"\u017f\u0001\u0000\u0000\u0000\u0177\u017f\u0005I\u0000\u0000\u0178\u017f"+
		"\u0005\u000b\u0000\u0000\u0179\u017f\u0005H\u0000\u0000\u017a\u017f\u0005"+
		"\f\u0000\u0000\u017b\u017f\u0005\r\u0000\u0000\u017c\u017f\u00036\u001b"+
		"\u0000\u017d\u017f\u00034\u001a\u0000\u017e\u0172\u0001\u0000\u0000\u0000"+
		"\u017e\u0177\u0001\u0000\u0000\u0000\u017e\u0178\u0001\u0000\u0000\u0000"+
		"\u017e\u0179\u0001\u0000\u0000\u0000\u017e\u017a\u0001\u0000\u0000\u0000"+
		"\u017e\u017b\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000"+
		"\u017e\u017d\u0001\u0000\u0000\u0000\u017f\u0187\u0001\u0000\u0000\u0000"+
		"\u0180\u0181\n\t\u0000\u0000\u0181\u0182\u0007\u0007\u0000\u0000\u0182"+
		"\u0186\u0003D\"\n\u0183\u0184\n\n\u0000\u0000\u0184\u0186\u0005=\u0000"+
		"\u0000\u0185\u0180\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000"+
		"\u0000\u0186\u0189\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000"+
		"\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188E\u0001\u0000\u0000\u0000"+
		"\u0189\u0187\u0001\u0000\u0000\u0000\u018a\u018c\u0003L&\u0000\u018b\u018d"+
		"\u0003P(\u0000\u018c\u018b\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000"+
		"\u0000\u0000\u018dG\u0001\u0000\u0000\u0000\u018e\u0197\u00056\u0000\u0000"+
		"\u018f\u0194\u0003J%\u0000\u0190\u0191\u0005E\u0000\u0000\u0191\u0193"+
		"\u0003J%\u0000\u0192\u0190\u0001\u0000\u0000\u0000\u0193\u0196\u0001\u0000"+
		"\u0000\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000"+
		"\u0000\u0000\u0195\u0198\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000"+
		"\u0000\u0000\u0197\u018f\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000"+
		"\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019d\u00057\u0000"+
		"\u0000\u019a\u019b\u00056\u0000\u0000\u019b\u019d\u00057\u0000\u0000\u019c"+
		"\u018e\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019d"+
		"I\u0001\u0000\u0000\u0000\u019e\u01a1\u0003F#\u0000\u019f\u01a1\u0005"+
		"\u0004\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0\u019f\u0001"+
		"\u0000\u0000\u0000\u01a1\u01a8\u0001\u0000\u0000\u0000\u01a2\u01a5\u0007"+
		"\b\u0000\u0000\u01a3\u01a4\u0005\u0003\u0000\u0000\u01a4\u01a6\u0003L"+
		"&\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000"+
		"\u0000\u01a6\u01a8\u0001\u0000\u0000\u0000\u01a7\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a2\u0001\u0000\u0000\u0000\u01a8K\u0001\u0000\u0000\u0000"+
		"\u01a9\u01ab\u0005\u001d\u0000\u0000\u01aa\u01a9\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ac\u01af\u0005\u0002\u0000\u0000\u01ad\u01af\u0003N\'\u0000\u01ae"+
		"\u01aa\u0001\u0000\u0000\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01af"+
		"M\u0001\u0000\u0000\u0000\u01b0\u01b1\u0005H\u0000\u0000\u01b1\u01b3\u0005"+
		"D\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b7\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b9\u0005H\u0000\u0000\u01b8\u01ba\u0003H$\u0000"+
		"\u01b9\u01b8\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000"+
		"\u01baO\u0001\u0000\u0000\u0000\u01bb\u01c4\u0005>\u0000\u0000\u01bc\u01c1"+
		"\u0005I\u0000\u0000\u01bd\u01be\u0005E\u0000\u0000\u01be\u01c0\u0005I"+
		"\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0\u01c3\u0001\u0000"+
		"\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c2\u01c5\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000"+
		"\u0000\u0000\u01c4\u01bc\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000"+
		"\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005?\u0000"+
		"\u0000\u01c7Q\u0001\u0000\u0000\u0000\u01c8\u01c9\u0005F\u0000\u0000\u01c9"+
		"\u01cd\u0006)\uffff\uffff\u0000\u01ca\u01cb\u0005G\u0000\u0000\u01cb\u01cd"+
		"\u0006)\uffff\uffff\u0000\u01cc\u01c8\u0001\u0000\u0000\u0000\u01cc\u01ca"+
		"\u0001\u0000\u0000\u0000\u01cdS\u0001\u0000\u0000\u0000;Z\\^dqy\u007f"+
		"\u0085\u0089\u0091\u009b\u009d\u00a2\u00a8\u00ac\u00b4\u00b8\u00c2\u00c5"+
		"\u00cd\u00d2\u00d4\u00d6\u00e2\u00eb\u00f0\u00f6\u00fa\u010c\u011b\u0121"+
		"\u0128\u012b\u0132\u0138\u0145\u0149\u014e\u0160\u0164\u016d\u0170\u017e"+
		"\u0185\u0187\u018c\u0194\u0197\u019c\u01a0\u01a5\u01a7\u01aa\u01ae\u01b4"+
		"\u01b9\u01c1\u01c4\u01cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}