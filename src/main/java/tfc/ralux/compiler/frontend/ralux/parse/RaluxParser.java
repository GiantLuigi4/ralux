package tfc.ralux.compiler.frontend.ralux.parse;// Generated from C:/Users/User/IdeaProjects/RaluxYetAgain/grammar/Ralux.g4 by ANTLR 4.13.1
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
		RULE_ctor = 29, RULE_params = 30, RULE_qualif = 31, RULE_dOperand = 32, 
		RULE_operand = 33, RULE_semi_truck = 34, RULE_expr = 35, RULE_fb_expr = 36, 
		RULE_full_type = 37, RULE_generic = 38, RULE_generic_element = 39, RULE_type = 40, 
		RULE_named_type = 41, RULE_array = 42, RULE_directive = 43, RULE_field = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "header", "static_use", "annotation", "class", "c_body", "c_component", 
			"method", "def_params", "statement_list", "body", "statement", "ret", 
			"flow", "loop", "special", "state_end", "label", "do", "while", "while_header", 
			"if", "for", "loop_enhanced", "loop_standard", "definition", "assignment", 
			"call", "method_call", "ctor", "params", "qualif", "dOperand", "operand", 
			"semi_truck", "expr", "fb_expr", "full_type", "generic", "generic_element", 
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
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 394784L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 785L) != 0)) {
				{
				setState(98);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INFER_STATEMENTS:
				case ENFORCE_STATEMENTS:
					{
					setState(90);
					directive();
					}
					break;
				case USE:
				case PKG:
					{
					setState(91);
					header();
					}
					break;
				case C_TYPE:
				case MODIFIER:
				case STATIC:
				case L_BRACKET:
					{
					setState(92);
					class_();
					}
					break;
				case SEMI:
					{
					setState(94); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(93);
							match(SEMI);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(96); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(102);
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				{
				setState(103);
				static_use();
				}
				}
				break;
			case 2:
				{
				setState(104);
				_la = _input.LA(1);
				if ( !(_la==USE || _la==PKG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(105);
				named_type();
				}
				break;
			}
			setState(108);
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
			setState(110);
			match(USE);
			setState(111);
			match(STATIC);
			setState(112);
			named_type();
			setState(113);
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
			setState(115);
			match(L_BRACKET);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 268435451L) != 0)) {
				{
				{
				setState(116);
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
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
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
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(124);
					annotation();
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(130);
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
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(136);
			match(C_TYPE);
			setState(137);
			match(WORD);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(138);
				generic();
				}
			}

			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(141);
				match(EXTENDS);
				setState(142);
				type();
				}
			}

			setState(145);
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
			setState(147);
			match(L_CURLY);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057602627864100L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 1041L) != 0)) {
				{
				{
				setState(148);
				c_component();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				class_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				field();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				method();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(159);
						match(SEMI);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(162); 
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
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(166);
					annotation();
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(172);
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
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(178);
				generic();
				}
			}

			setState(181);
			full_type();
			setState(182);
			match(WORD);
			setState(183);
			match(LPAREN);
			setState(184);
			def_params();
			setState(185);
			match(RPAREN);
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(186);
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
				setState(187);
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
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMITIVE || _la==UNSIGNED || _la==WORD) {
				{
				setState(190);
				full_type();
				setState(191);
				match(WORD);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(192);
					match(COMMA);
					setState(193);
					full_type();
					setState(194);
					match(WORD);
					}
					}
					setState(200);
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
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17095983108L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 453L) != 0)) {
				{
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(203);
					body();
					}
					break;
				case 2:
					{
					setState(204);
					flow();
					}
					break;
				case 3:
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(205);
						directive();
						}
						break;
					case 2:
						{
						setState(207); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(206);
								match(SEMI);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(209); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
						} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 3:
						{
						{
						setState(211);
						statement();
						setState(212);
						semi_truck();
						}
						}
						break;
					}
					}
					break;
				}
				}
				setState(220);
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
			setState(221);
			match(L_CURLY);
			setState(222);
			statement_list();
			setState(223);
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
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(229);
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
			setState(232);
			match(RETURN);
			setState(233);
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
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				if_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				loop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				special();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
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
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(241);
				label();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(247);
				for_();
				}
				break;
			case WHILE:
				{
				setState(248);
				while_();
				}
				break;
			case DO:
				{
				setState(249);
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
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==BREAK || _la==CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(253);
				match(WORD);
				}
			}

			}
			setState(256);
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
			setState(258);
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
			setState(260);
			match(WORD);
			setState(261);
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
			setState(263);
			match(DO);
			setState(264);
			body();
			setState(265);
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
			setState(267);
			while_header();
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(268);
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
				setState(269);
				statement();
				setState(270);
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
			setState(274);
			match(WHILE);
			setState(275);
			match(LPAREN);
			setState(276);
			expr(0);
			setState(277);
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
			setState(279);
			match(IF);
			setState(280);
			match(LPAREN);
			setState(281);
			expr(0);
			setState(282);
			match(RPAREN);
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(283);
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
				setState(288);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(284);
					flow();
					}
					break;
				case 2:
					{
					{
					setState(285);
					statement();
					setState(286);
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
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				{
				setState(292);
				match(ELSE);
				setState(293);
				if_();
				}
				}
				break;
			case 2:
				{
				{
				setState(294);
				match(ELSE);
				setState(300);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(295);
					flow();
					}
					break;
				case 2:
					{
					setState(296);
					body();
					}
					break;
				case 3:
					{
					{
					setState(297);
					statement();
					setState(298);
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
			setState(304);
			match(FOR);
			setState(305);
			match(LPAREN);
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(306);
				loop_enhanced();
				}
				break;
			case 2:
				{
				setState(307);
				loop_standard();
				}
				break;
			}
			setState(310);
			match(RPAREN);
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				{
				setState(311);
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
				setState(312);
				statement();
				setState(313);
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
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(317);
				full_type();
				}
				break;
			}
			setState(320);
			match(WORD);
			setState(321);
			match(T__0);
			setState(322);
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
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(324);
				flow();
				}
				break;
			case 2:
				{
				setState(325);
				statement();
				}
				break;
			}
			}
			setState(328);
			semi_truck();
			{
			setState(329);
			expr(0);
			}
			setState(330);
			semi_truck();
			{
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(331);
				flow();
				}
				break;
			case 2:
				{
				setState(332);
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
			setState(335);
			full_type();
			setState(336);
			match(WORD);
			setState(337);
			match(EQUAL);
			setState(338);
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
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
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
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(340);
				qualif();
				setState(341);
				operand();
				setState(342);
				expr(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(344);
				match(WORD);
				setState(345);
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
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				method_call();
				}
				break;
			case NEW:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
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
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(352);
				named_type();
				setState(353);
				match(DOT);
				}
				break;
			}
			setState(357);
			match(WORD);
			setState(358);
			match(LPAREN);
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
				{
				setState(359);
				params();
				}
			}

			setState(362);
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
			setState(364);
			match(NEW);
			setState(365);
			type();
			setState(366);
			match(LPAREN);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218748618752L) != 0) || _la==WORD || _la==NUMBER) {
				{
				setState(367);
				params();
				}
			}

			setState(370);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(372);
					expr(0);
					setState(373);
					match(COMMA);
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(380);
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
		public TerminalNode WORD() { return getToken(RaluxParser.WORD, 0); }
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
		enterRule(_localctx, 62, RULE_qualif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(382);
				named_type();
				setState(383);
				match(DOT);
				}
				break;
			}
			setState(387);
			match(WORD);
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
		enterRule(_localctx, 64, RULE_dOperand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
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
		enterRule(_localctx, 66, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
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
		enterRule(_localctx, 68, RULE_semi_truck);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(396);
				match(MINUS);
				setState(397);
				expr(11);
				}
				break;
			case 2:
				{
				setState(398);
				match(LPAREN);
				setState(399);
				full_type();
				setState(400);
				match(RPAREN);
				setState(401);
				expr(10);
				}
				break;
			case 3:
				{
				setState(403);
				match(LPAREN);
				setState(404);
				expr(0);
				setState(405);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(407);
				fb_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(435);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(433);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(410);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(411);
						match(VAR_SWAP);
						setState(412);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(413);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(414);
						match(POW);
						setState(415);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(416);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(417);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(418);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(419);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(420);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(421);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(422);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(423);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337208320L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(424);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(425);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(426);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -72057594037927936L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(427);
						expr(4);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(428);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(429);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(430);
						expr(3);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(431);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(432);
						match(DHASH);
						}
						break;
					}
					} 
				}
				setState(437);
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
		enterRule(_localctx, 72, RULE_fb_expr);
		try {
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				match(CONSTANT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(440);
				qualif();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(441);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(442);
				match(CHR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(443);
				call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(444);
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
		enterRule(_localctx, 74, RULE_full_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			type();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_BRACKET) {
				{
				setState(448);
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
		enterRule(_localctx, 76, RULE_generic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(LESS);
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589934612L) != 0) || _la==WORD) {
				{
				setState(452);
				generic_element();
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(453);
					match(COMMA);
					setState(454);
					generic_element();
					}
					}
					setState(459);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(462);
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
		enterRule(_localctx, 78, RULE_generic_element);
		int _la;
		try {
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRIMITIVE:
				case UNSIGNED:
				case WORD:
					{
					setState(464);
					full_type();
					}
					break;
				case GENERIC_WILDCARD:
					{
					setState(465);
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
				setState(468);
				_la = _input.LA(1);
				if ( !(_la==GENERIC_WILDCARD || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERIC_CONSTRAINT) {
					{
					setState(469);
					match(GENERIC_CONSTRAINT);
					setState(470);
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
		enterRule(_localctx, 80, RULE_type);
		int _la;
		try {
			setState(480);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE:
			case UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNSIGNED) {
					{
					setState(475);
					match(UNSIGNED);
					}
				}

				setState(478);
				match(PRIMITIVE);
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(479);
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
		enterRule(_localctx, 82, RULE_named_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(482);
					match(WORD);
					setState(483);
					match(DOT);
					}
					} 
				}
				setState(488);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			setState(489);
			match(WORD);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(490);
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
		enterRule(_localctx, 84, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			match(L_BRACKET);
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(494);
				match(NUMBER);
				setState(499);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(495);
					match(COMMA);
					setState(496);
					match(NUMBER);
					}
					}
					setState(501);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(504);
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
		enterRule(_localctx, 86, RULE_directive);
		try {
			setState(510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INFER_STATEMENTS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(506);
				match(INFER_STATEMENTS);
				 inferSemicolons = true; 
				}
				}
				break;
			case ENFORCE_STATEMENTS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(508);
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
		enterRule(_localctx, 88, RULE_field);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(512);
					annotation();
					}
					} 
				}
				setState(517);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			setState(521);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(518);
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
				setState(523);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(524);
				generic();
				}
			}

			setState(527);
			full_type();
			setState(528);
			match(WORD);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(529);
				match(EQUAL);
				setState(532);
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
					setState(530);
					expr(0);
					}
					break;
				case L_CURLY:
					{
					setState(531);
					body();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			{
			setState(536);
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
		case 35:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001[\u021b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000_\b\u0000\u000b"+
		"\u0000\f\u0000`\u0005\u0000c\b\u0000\n\u0000\f\u0000f\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001k\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0005\u0003v\b\u0003\n\u0003\f\u0003y\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0005\u0004~\b\u0004\n\u0004\f\u0004\u0081\t"+
		"\u0004\u0001\u0004\u0005\u0004\u0084\b\u0004\n\u0004\f\u0004\u0087\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u008c\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0090\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u0096\b\u0005\n\u0005\f\u0005\u0099\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006\u00a1\b\u0006\u000b\u0006\f\u0006\u00a2\u0003\u0006\u00a5\b\u0006"+
		"\u0001\u0007\u0005\u0007\u00a8\b\u0007\n\u0007\f\u0007\u00ab\t\u0007\u0001"+
		"\u0007\u0005\u0007\u00ae\b\u0007\n\u0007\f\u0007\u00b1\t\u0007\u0001\u0007"+
		"\u0003\u0007\u00b4\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00bd\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00c5\b\b\n\b\f\b\u00c8"+
		"\t\b\u0003\b\u00ca\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00d0\b"+
		"\t\u000b\t\f\t\u00d1\u0001\t\u0001\t\u0001\t\u0003\t\u00d7\b\t\u0005\t"+
		"\u00d9\b\t\n\t\f\t\u00dc\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e7\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00f0"+
		"\b\r\u0001\u000e\u0005\u000e\u00f3\b\u000e\n\u000e\f\u000e\u00f6\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00fb\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00ff\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0111\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u0121\b\u0015\u0003\u0015\u0123\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u012d\b\u0015\u0003\u0015\u012f\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u0135\b\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u013c\b\u0016\u0001\u0017"+
		"\u0003\u0017\u013f\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0147\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u014e\b\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u015b\b\u001a"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u015f\b\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u0164\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u0169\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u0171\b\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0178\b\u001e\n\u001e"+
		"\f\u001e\u017b\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0003\u001f\u0182\b\u001f\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u0199"+
		"\b#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0005#\u01b2\b#\n#\f#\u01b5\t#\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0003$\u01be\b$\u0001%\u0001%\u0003%\u01c2"+
		"\b%\u0001&\u0001&\u0001&\u0001&\u0005&\u01c8\b&\n&\f&\u01cb\t&\u0003&"+
		"\u01cd\b&\u0001&\u0001&\u0001\'\u0001\'\u0003\'\u01d3\b\'\u0001\'\u0001"+
		"\'\u0001\'\u0003\'\u01d8\b\'\u0003\'\u01da\b\'\u0001(\u0003(\u01dd\b("+
		"\u0001(\u0001(\u0003(\u01e1\b(\u0001)\u0001)\u0005)\u01e5\b)\n)\f)\u01e8"+
		"\t)\u0001)\u0001)\u0003)\u01ec\b)\u0001*\u0001*\u0001*\u0001*\u0005*\u01f2"+
		"\b*\n*\f*\u01f5\t*\u0003*\u01f7\b*\u0001*\u0001*\u0001+\u0001+\u0001+"+
		"\u0001+\u0003+\u01ff\b+\u0001,\u0005,\u0202\b,\n,\f,\u0205\t,\u0001,\u0005"+
		",\u0208\b,\n,\f,\u020b\t,\u0001,\u0003,\u020e\b,\u0001,\u0001,\u0001,"+
		"\u0001,\u0001,\u0003,\u0215\b,\u0003,\u0217\b,\u0001,\u0001,\u0001,\u0006"+
		"\u007f\u0085\u00a9\u00af\u0203\u0209\u0001F-\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@BDFHJLNPRTVX\u0000\r\u0001\u0000\u0011\u0012\u0001\u0000BB\u0001"+
		"\u0000\t\n\u0001\u0000\u001e\u001f\u0002\u0000EEXX\u0001\u0000/0\u0001"+
		"\u000016\u0002\u0000$$&&\u0001\u0000\"#\u0001\u0000\'*\u0001\u00008?\u0001"+
		"\u0000+,\u0002\u0000\u0004\u0004KK\u024c\u0000d\u0001\u0000\u0000\u0000"+
		"\u0002j\u0001\u0000\u0000\u0000\u0004n\u0001\u0000\u0000\u0000\u0006s"+
		"\u0001\u0000\u0000\u0000\b\u007f\u0001\u0000\u0000\u0000\n\u0093\u0001"+
		"\u0000\u0000\u0000\f\u00a4\u0001\u0000\u0000\u0000\u000e\u00a9\u0001\u0000"+
		"\u0000\u0000\u0010\u00c9\u0001\u0000\u0000\u0000\u0012\u00da\u0001\u0000"+
		"\u0000\u0000\u0014\u00dd\u0001\u0000\u0000\u0000\u0016\u00e6\u0001\u0000"+
		"\u0000\u0000\u0018\u00e8\u0001\u0000\u0000\u0000\u001a\u00ef\u0001\u0000"+
		"\u0000\u0000\u001c\u00f4\u0001\u0000\u0000\u0000\u001e\u00fc\u0001\u0000"+
		"\u0000\u0000 \u0102\u0001\u0000\u0000\u0000\"\u0104\u0001\u0000\u0000"+
		"\u0000$\u0107\u0001\u0000\u0000\u0000&\u010b\u0001\u0000\u0000\u0000("+
		"\u0112\u0001\u0000\u0000\u0000*\u0117\u0001\u0000\u0000\u0000,\u0130\u0001"+
		"\u0000\u0000\u0000.\u013e\u0001\u0000\u0000\u00000\u0146\u0001\u0000\u0000"+
		"\u00002\u014f\u0001\u0000\u0000\u00004\u015a\u0001\u0000\u0000\u00006"+
		"\u015e\u0001\u0000\u0000\u00008\u0163\u0001\u0000\u0000\u0000:\u016c\u0001"+
		"\u0000\u0000\u0000<\u0179\u0001\u0000\u0000\u0000>\u0181\u0001\u0000\u0000"+
		"\u0000@\u0185\u0001\u0000\u0000\u0000B\u0187\u0001\u0000\u0000\u0000D"+
		"\u0189\u0001\u0000\u0000\u0000F\u0198\u0001\u0000\u0000\u0000H\u01bd\u0001"+
		"\u0000\u0000\u0000J\u01bf\u0001\u0000\u0000\u0000L\u01c3\u0001\u0000\u0000"+
		"\u0000N\u01d9\u0001\u0000\u0000\u0000P\u01e0\u0001\u0000\u0000\u0000R"+
		"\u01e6\u0001\u0000\u0000\u0000T\u01ed\u0001\u0000\u0000\u0000V\u01fe\u0001"+
		"\u0000\u0000\u0000X\u0203\u0001\u0000\u0000\u0000Zc\u0003V+\u0000[c\u0003"+
		"\u0002\u0001\u0000\\c\u0003\b\u0004\u0000]_\u0005E\u0000\u0000^]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000bZ\u0001\u0000\u0000"+
		"\u0000b[\u0001\u0000\u0000\u0000b\\\u0001\u0000\u0000\u0000b^\u0001\u0000"+
		"\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001"+
		"\u0000\u0000\u0000e\u0001\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000gk\u0003\u0004\u0002\u0000hi\u0007\u0000\u0000\u0000ik\u0003R)\u0000"+
		"jg\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000lm\u0003D\"\u0000m\u0003\u0001\u0000\u0000\u0000no\u0005\u0011\u0000"+
		"\u0000op\u0005\n\u0000\u0000pq\u0003R)\u0000qr\u0005K\u0000\u0000r\u0005"+
		"\u0001\u0000\u0000\u0000sw\u0005A\u0000\u0000tv\b\u0001\u0000\u0000ut"+
		"\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000z{\u0005B\u0000\u0000{\u0007\u0001\u0000\u0000\u0000|~\u0003"+
		"\u0006\u0003\u0000}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000"+
		"\u0080\u0085\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0007\u0002\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000"+
		"\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0005\u0000\u0000"+
		"\u0089\u008b\u0005K\u0000\u0000\u008a\u008c\u0003L&\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008f"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0015\u0000\u0000\u008e\u0090"+
		"\u0003P(\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0003\n\u0005"+
		"\u0000\u0092\t\u0001\u0000\u0000\u0000\u0093\u0097\u0005C\u0000\u0000"+
		"\u0094\u0096\u0003\f\u0006\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096"+
		"\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0001\u0000\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u009a\u009b\u0005D\u0000\u0000\u009b\u000b"+
		"\u0001\u0000\u0000\u0000\u009c\u00a5\u0003\b\u0004\u0000\u009d\u00a5\u0003"+
		"X,\u0000\u009e\u00a5\u0003\u000e\u0007\u0000\u009f\u00a1\u0005E\u0000"+
		"\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u009c\u0001\u0000\u0000"+
		"\u0000\u00a4\u009d\u0001\u0000\u0000\u0000\u00a4\u009e\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a0\u0001\u0000\u0000\u0000\u00a5\r\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a8\u0003\u0006\u0003\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00af\u0001\u0000\u0000\u0000"+
		"\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ae\u0007\u0002\u0000\u0000"+
		"\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b4\u0003L&\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0003J%\u0000\u00b6\u00b7\u0005K\u0000\u0000\u00b7\u00b8\u0005-\u0000"+
		"\u0000\u00b8\u00b9\u0003\u0010\b\u0000\u00b9\u00bc\u0005.\u0000\u0000"+
		"\u00ba\u00bd\u0003\u0014\n\u0000\u00bb\u00bd\u0003D\"\u0000\u00bc\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bd\u000f"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0003J%\u0000\u00bf\u00c6\u0005K"+
		"\u0000\u0000\u00c0\u00c1\u0005H\u0000\u0000\u00c1\u00c2\u0003J%\u0000"+
		"\u00c2\u00c3\u0005K\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9"+
		"\u00be\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"\u0011\u0001\u0000\u0000\u0000\u00cb\u00d9\u0003\u0014\n\u0000\u00cc\u00d9"+
		"\u0003\u001a\r\u0000\u00cd\u00d7\u0003V+\u0000\u00ce\u00d0\u0005E\u0000"+
		"\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d7\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003\u0016\u000b"+
		"\u0000\u00d4\u00d5\u0003D\"\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d6\u00cd\u0001\u0000\u0000\u0000\u00d6\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d8\u00cb\u0001\u0000\u0000\u0000\u00d8\u00cc\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000"+
		"\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000"+
		"\u00db\u0013\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\u0005C\u0000\u0000\u00de\u00df\u0003\u0012\t\u0000\u00df"+
		"\u00e0\u0005D\u0000\u0000\u00e0\u0015\u0001\u0000\u0000\u0000\u00e1\u00e7"+
		"\u00036\u001b\u0000\u00e2\u00e7\u00032\u0019\u0000\u00e3\u00e7\u00034"+
		"\u001a\u0000\u00e4\u00e7\u0003V+\u0000\u00e5\u00e7\u0003\u0018\f\u0000"+
		"\u00e6\u00e1\u0001\u0000\u0000\u0000\u00e6\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u0017\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0005 \u0000\u0000\u00e9\u00ea\u0003F#\u0000\u00ea\u0019"+
		"\u0001\u0000\u0000\u0000\u00eb\u00f0\u0003*\u0015\u0000\u00ec\u00f0\u0003"+
		"\u001c\u000e\u0000\u00ed\u00f0\u0003\u001e\u000f\u0000\u00ee\u00f0\u0003"+
		"\"\u0011\u0000\u00ef\u00eb\u0001\u0000\u0000\u0000\u00ef\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f0\u001b\u0001\u0000\u0000\u0000\u00f1\u00f3\u0003\"\u0011"+
		"\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00fa\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f7\u00fb\u0003,\u0016\u0000\u00f8\u00fb\u0003&\u0013\u0000\u00f9"+
		"\u00fb\u0003$\u0012\u0000\u00fa\u00f7\u0001\u0000\u0000\u0000\u00fa\u00f8"+
		"\u0001\u0000\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u001d"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fe\u0007\u0003\u0000\u0000\u00fd\u00ff"+
		"\u0005K\u0000\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001"+
		"\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0101\u0003"+
		" \u0010\u0000\u0101\u001f\u0001\u0000\u0000\u0000\u0102\u0103\u0007\u0004"+
		"\u0000\u0000\u0103!\u0001\u0000\u0000\u0000\u0104\u0105\u0005K\u0000\u0000"+
		"\u0105\u0106\u0005\u0001\u0000\u0000\u0106#\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0005\u001d\u0000\u0000\u0108\u0109\u0003\u0014\n\u0000\u0109\u010a"+
		"\u0003(\u0014\u0000\u010a%\u0001\u0000\u0000\u0000\u010b\u0110\u0003("+
		"\u0014\u0000\u010c\u0111\u0003\u0014\n\u0000\u010d\u010e\u0003\u0016\u000b"+
		"\u0000\u010e\u010f\u0003D\"\u0000\u010f\u0111\u0001\u0000\u0000\u0000"+
		"\u0110\u010c\u0001\u0000\u0000\u0000\u0110\u010d\u0001\u0000\u0000\u0000"+
		"\u0111\'\u0001\u0000\u0000\u0000\u0112\u0113\u0005\u001c\u0000\u0000\u0113"+
		"\u0114\u0005-\u0000\u0000\u0114\u0115\u0003F#\u0000\u0115\u0116\u0005"+
		".\u0000\u0000\u0116)\u0001\u0000\u0000\u0000\u0117\u0118\u0005\u0019\u0000"+
		"\u0000\u0118\u0119\u0005-\u0000\u0000\u0119\u011a\u0003F#\u0000\u011a"+
		"\u0122\u0005.\u0000\u0000\u011b\u0123\u0003\u0014\n\u0000\u011c\u0121"+
		"\u0003\u001a\r\u0000\u011d\u011e\u0003\u0016\u000b\u0000\u011e\u011f\u0003"+
		"D\"\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120\u011c\u0001\u0000"+
		"\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121\u0123\u0001\u0000"+
		"\u0000\u0000\u0122\u011b\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000"+
		"\u0000\u0000\u0123\u012e\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u001a"+
		"\u0000\u0000\u0125\u012f\u0003*\u0015\u0000\u0126\u012c\u0005\u001a\u0000"+
		"\u0000\u0127\u012d\u0003\u001a\r\u0000\u0128\u012d\u0003\u0014\n\u0000"+
		"\u0129\u012a\u0003\u0016\u000b\u0000\u012a\u012b\u0003D\"\u0000\u012b"+
		"\u012d\u0001\u0000\u0000\u0000\u012c\u0127\u0001\u0000\u0000\u0000\u012c"+
		"\u0128\u0001\u0000\u0000\u0000\u012c\u0129\u0001\u0000\u0000\u0000\u012d"+
		"\u012f\u0001\u0000\u0000\u0000\u012e\u0124\u0001\u0000\u0000\u0000\u012e"+
		"\u0126\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f"+
		"+\u0001\u0000\u0000\u0000\u0130\u0131\u0005\u001b\u0000\u0000\u0131\u0134"+
		"\u0005-\u0000\u0000\u0132\u0135\u0003.\u0017\u0000\u0133\u0135\u00030"+
		"\u0018\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0133\u0001\u0000"+
		"\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u013b\u0005.\u0000"+
		"\u0000\u0137\u013c\u0003\u0014\n\u0000\u0138\u0139\u0003\u0016\u000b\u0000"+
		"\u0139\u013a\u0003D\"\u0000\u013a\u013c\u0001\u0000\u0000\u0000\u013b"+
		"\u0137\u0001\u0000\u0000\u0000\u013b\u0138\u0001\u0000\u0000\u0000\u013c"+
		"-\u0001\u0000\u0000\u0000\u013d\u013f\u0003J%\u0000\u013e\u013d\u0001"+
		"\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0140\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u0005K\u0000\u0000\u0141\u0142\u0005\u0001"+
		"\u0000\u0000\u0142\u0143\u0003F#\u0000\u0143/\u0001\u0000\u0000\u0000"+
		"\u0144\u0147\u0003\u001a\r\u0000\u0145\u0147\u0003\u0016\u000b\u0000\u0146"+
		"\u0144\u0001\u0000\u0000\u0000\u0146\u0145\u0001\u0000\u0000\u0000\u0146"+
		"\u0147\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148"+
		"\u0149\u0003D\"\u0000\u0149\u014a\u0003F#\u0000\u014a\u014d\u0003D\"\u0000"+
		"\u014b\u014e\u0003\u001a\r\u0000\u014c\u014e\u0003\u0016\u000b\u0000\u014d"+
		"\u014b\u0001\u0000\u0000\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014d"+
		"\u014e\u0001\u0000\u0000\u0000\u014e1\u0001\u0000\u0000\u0000\u014f\u0150"+
		"\u0003J%\u0000\u0150\u0151\u0005K\u0000\u0000\u0151\u0152\u00051\u0000"+
		"\u0000\u0152\u0153\u0003F#\u0000\u01533\u0001\u0000\u0000\u0000\u0154"+
		"\u0155\u0003>\u001f\u0000\u0155\u0156\u0003B!\u0000\u0156\u0157\u0003"+
		"F#\u0000\u0157\u015b\u0001\u0000\u0000\u0000\u0158\u0159\u0005K\u0000"+
		"\u0000\u0159\u015b\u0003@ \u0000\u015a\u0154\u0001\u0000\u0000\u0000\u015a"+
		"\u0158\u0001\u0000\u0000\u0000\u015b5\u0001\u0000\u0000\u0000\u015c\u015f"+
		"\u00038\u001c\u0000\u015d\u015f\u0003:\u001d\u0000\u015e\u015c\u0001\u0000"+
		"\u0000\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015f7\u0001\u0000\u0000"+
		"\u0000\u0160\u0161\u0003R)\u0000\u0161\u0162\u0005G\u0000\u0000\u0162"+
		"\u0164\u0001\u0000\u0000\u0000\u0163\u0160\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0005K\u0000\u0000\u0166\u0168\u0005-\u0000\u0000\u0167\u0169\u0003"+
		"<\u001e\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016b\u0005.\u0000"+
		"\u0000\u016b9\u0001\u0000\u0000\u0000\u016c\u016d\u0005\u0018\u0000\u0000"+
		"\u016d\u016e\u0003P(\u0000\u016e\u0170\u0005-\u0000\u0000\u016f\u0171"+
		"\u0003<\u001e\u0000\u0170\u016f\u0001\u0000\u0000\u0000\u0170\u0171\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0173\u0005"+
		".\u0000\u0000\u0173;\u0001\u0000\u0000\u0000\u0174\u0175\u0003F#\u0000"+
		"\u0175\u0176\u0005H\u0000\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177"+
		"\u0174\u0001\u0000\u0000\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179"+
		"\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a"+
		"\u017c\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c"+
		"\u017d\u0003F#\u0000\u017d=\u0001\u0000\u0000\u0000\u017e\u017f\u0003"+
		"R)\u0000\u017f\u0180\u0005G\u0000\u0000\u0180\u0182\u0001\u0000\u0000"+
		"\u0000\u0181\u017e\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0005K\u0000\u0000"+
		"\u0184?\u0001\u0000\u0000\u0000\u0185\u0186\u0007\u0005\u0000\u0000\u0186"+
		"A\u0001\u0000\u0000\u0000\u0187\u0188\u0007\u0006\u0000\u0000\u0188C\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0006\"\uffff\uffff\u0000\u018aE\u0001"+
		"\u0000\u0000\u0000\u018b\u018c\u0006#\uffff\uffff\u0000\u018c\u018d\u0005"+
		"#\u0000\u0000\u018d\u0199\u0003F#\u000b\u018e\u018f\u0005-\u0000\u0000"+
		"\u018f\u0190\u0003J%\u0000\u0190\u0191\u0005.\u0000\u0000\u0191\u0192"+
		"\u0003F#\n\u0192\u0199\u0001\u0000\u0000\u0000\u0193\u0194\u0005-\u0000"+
		"\u0000\u0194\u0195\u0003F#\u0000\u0195\u0196\u0005.\u0000\u0000\u0196"+
		"\u0199\u0001\u0000\u0000\u0000\u0197\u0199\u0003H$\u0000\u0198\u018b\u0001"+
		"\u0000\u0000\u0000\u0198\u018e\u0001\u0000\u0000\u0000\u0198\u0193\u0001"+
		"\u0000\u0000\u0000\u0198\u0197\u0001\u0000\u0000\u0000\u0199\u01b3\u0001"+
		"\u0000\u0000\u0000\u019a\u019b\n\b\u0000\u0000\u019b\u019c\u00057\u0000"+
		"\u0000\u019c\u01b2\u0003F#\t\u019d\u019e\n\u0007\u0000\u0000\u019e\u019f"+
		"\u0005%\u0000\u0000\u019f\u01b2\u0003F#\b\u01a0\u01a1\n\u0006\u0000\u0000"+
		"\u01a1\u01a2\u0007\u0007\u0000\u0000\u01a2\u01b2\u0003F#\u0007\u01a3\u01a4"+
		"\n\u0005\u0000\u0000\u01a4\u01a5\u0007\b\u0000\u0000\u01a5\u01b2\u0003"+
		"F#\u0006\u01a6\u01a7\n\u0004\u0000\u0000\u01a7\u01a8\u0007\t\u0000\u0000"+
		"\u01a8\u01b2\u0003F#\u0005\u01a9\u01aa\n\u0003\u0000\u0000\u01aa\u01ab"+
		"\u0007\n\u0000\u0000\u01ab\u01b2\u0003F#\u0004\u01ac\u01ad\n\u0002\u0000"+
		"\u0000\u01ad\u01ae\u0007\u000b\u0000\u0000\u01ae\u01b2\u0003F#\u0003\u01af"+
		"\u01b0\n\f\u0000\u0000\u01b0\u01b2\u0005@\u0000\u0000\u01b1\u019a\u0001"+
		"\u0000\u0000\u0000\u01b1\u019d\u0001\u0000\u0000\u0000\u01b1\u01a0\u0001"+
		"\u0000\u0000\u0000\u01b1\u01a3\u0001\u0000\u0000\u0000\u01b1\u01a6\u0001"+
		"\u0000\u0000\u0000\u01b1\u01a9\u0001\u0000\u0000\u0000\u01b1\u01ac\u0001"+
		"\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b5\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b4G\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000"+
		"\u0000\u0000\u01b6\u01be\u0005L\u0000\u0000\u01b7\u01be\u0005\u000b\u0000"+
		"\u0000\u01b8\u01be\u0003>\u001f\u0000\u01b9\u01be\u0005\f\u0000\u0000"+
		"\u01ba\u01be\u0005\r\u0000\u0000\u01bb\u01be\u00036\u001b\u0000\u01bc"+
		"\u01be\u00034\u001a\u0000\u01bd\u01b6\u0001\u0000\u0000\u0000\u01bd\u01b7"+
		"\u0001\u0000\u0000\u0000\u01bd\u01b8\u0001\u0000\u0000\u0000\u01bd\u01b9"+
		"\u0001\u0000\u0000\u0000\u01bd\u01ba\u0001\u0000\u0000\u0000\u01bd\u01bb"+
		"\u0001\u0000\u0000\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01beI\u0001"+
		"\u0000\u0000\u0000\u01bf\u01c1\u0003P(\u0000\u01c0\u01c2\u0003T*\u0000"+
		"\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000"+
		"\u01c2K\u0001\u0000\u0000\u0000\u01c3\u01cc\u00058\u0000\u0000\u01c4\u01c9"+
		"\u0003N\'\u0000\u01c5\u01c6\u0005H\u0000\u0000\u01c6\u01c8\u0003N\'\u0000"+
		"\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01cb\u0001\u0000\u0000\u0000"+
		"\u01c9\u01c7\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000"+
		"\u01ca\u01cd\u0001\u0000\u0000\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000"+
		"\u01cc\u01c4\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000\u0000"+
		"\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01cf\u00059\u0000\u0000\u01cf"+
		"M\u0001\u0000\u0000\u0000\u01d0\u01d3\u0003J%\u0000\u01d1\u01d3\u0005"+
		"\u0004\u0000\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d2\u01d1\u0001"+
		"\u0000\u0000\u0000\u01d3\u01da\u0001\u0000\u0000\u0000\u01d4\u01d7\u0007"+
		"\f\u0000\u0000\u01d5\u01d6\u0005\u0003\u0000\u0000\u01d6\u01d8\u0003P"+
		"(\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000"+
		"\u0000\u01d8\u01da\u0001\u0000\u0000\u0000\u01d9\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d9\u01d4\u0001\u0000\u0000\u0000\u01daO\u0001\u0000\u0000\u0000"+
		"\u01db\u01dd\u0005!\u0000\u0000\u01dc\u01db\u0001\u0000\u0000\u0000\u01dc"+
		"\u01dd\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de"+
		"\u01e1\u0005\u0002\u0000\u0000\u01df\u01e1\u0003R)\u0000\u01e0\u01dc\u0001"+
		"\u0000\u0000\u0000\u01e0\u01df\u0001\u0000\u0000\u0000\u01e1Q\u0001\u0000"+
		"\u0000\u0000\u01e2\u01e3\u0005K\u0000\u0000\u01e3\u01e5\u0005G\u0000\u0000"+
		"\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000"+
		"\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e9\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e9\u01eb\u0005K\u0000\u0000\u01ea\u01ec\u0003L&\u0000\u01eb\u01ea"+
		"\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ecS\u0001"+
		"\u0000\u0000\u0000\u01ed\u01f6\u0005A\u0000\u0000\u01ee\u01f3\u0005L\u0000"+
		"\u0000\u01ef\u01f0\u0005H\u0000\u0000\u01f0\u01f2\u0005L\u0000\u0000\u01f1"+
		"\u01ef\u0001\u0000\u0000\u0000\u01f2\u01f5\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4"+
		"\u01f7\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f6"+
		"\u01ee\u0001\u0000\u0000\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7"+
		"\u01f8\u0001\u0000\u0000\u0000\u01f8\u01f9\u0005B\u0000\u0000\u01f9U\u0001"+
		"\u0000\u0000\u0000\u01fa\u01fb\u0005I\u0000\u0000\u01fb\u01ff\u0006+\uffff"+
		"\uffff\u0000\u01fc\u01fd\u0005J\u0000\u0000\u01fd\u01ff\u0006+\uffff\uffff"+
		"\u0000\u01fe\u01fa\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000"+
		"\u0000\u01ffW\u0001\u0000\u0000\u0000\u0200\u0202\u0003\u0006\u0003\u0000"+
		"\u0201\u0200\u0001\u0000\u0000\u0000\u0202\u0205\u0001\u0000\u0000\u0000"+
		"\u0203\u0204\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000"+
		"\u0204\u0209\u0001\u0000\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000"+
		"\u0206\u0208\u0007\u0002\u0000\u0000\u0207\u0206\u0001\u0000\u0000\u0000"+
		"\u0208\u020b\u0001\u0000\u0000\u0000\u0209\u020a\u0001\u0000\u0000\u0000"+
		"\u0209\u0207\u0001\u0000\u0000\u0000\u020a\u020d\u0001\u0000\u0000\u0000"+
		"\u020b\u0209\u0001\u0000\u0000\u0000\u020c\u020e\u0003L&\u0000\u020d\u020c"+
		"\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e\u020f"+
		"\u0001\u0000\u0000\u0000\u020f\u0210\u0003J%\u0000\u0210\u0216\u0005K"+
		"\u0000\u0000\u0211\u0214\u00051\u0000\u0000\u0212\u0215\u0003F#\u0000"+
		"\u0213\u0215\u0003\u0014\n\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0214"+
		"\u0213\u0001\u0000\u0000\u0000\u0215\u0217\u0001\u0000\u0000\u0000\u0216"+
		"\u0211\u0001\u0000\u0000\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217"+
		"\u0218\u0001\u0000\u0000\u0000\u0218\u0219\u0003D\"\u0000\u0219Y\u0001"+
		"\u0000\u0000\u0000B`bdjw\u007f\u0085\u008b\u008f\u0097\u00a2\u00a4\u00a9"+
		"\u00af\u00b3\u00bc\u00c6\u00c9\u00d1\u00d6\u00d8\u00da\u00e6\u00ef\u00f4"+
		"\u00fa\u00fe\u0110\u0120\u0122\u012c\u012e\u0134\u013b\u013e\u0146\u014d"+
		"\u015a\u015e\u0163\u0168\u0170\u0179\u0181\u0198\u01b1\u01b3\u01bd\u01c1"+
		"\u01c9\u01cc\u01d2\u01d7\u01d9\u01dc\u01e0\u01e6\u01eb\u01f3\u01f6\u01fe"+
		"\u0203\u0209\u020d\u0214\u0216";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}