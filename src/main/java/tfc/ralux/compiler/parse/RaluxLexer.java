package tfc.ralux.compiler.parse;// Generated from C:/Users/User/IdeaProjects/RaluxYetAgain/grammar/Ralux.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RaluxLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "PRIMITIVE", "GENERIC_CONSTRAINT", "GENERIC_WILDCARD", "C_TYPE", 
			"PRIMITIVE_INT", "PRIMITIVE_FP", "PRIMITIVE_OTHER", "MODIFIER", "STATIC", 
			"CONSTANT", "STRING", "CHR", "ESC", "TRUE", "FALSE", "NULL", "USE", "PKG", 
			"CLASS", "INTERFACE", "EXTENDS", "SUPER", "INSTANCE_OF", "NEW", "IF", 
			"FOR", "WHILE", "DO", "UNSIGNED", "BREAK", "CONTINUE", "RETURN", "PLUS", 
			"MINUS", "MUL", "POW", "DIV", "XOR", "BOR", "BAND", "MOD", "OR", "AND", 
			"LPAREN", "RPAREN", "INC_INC", "DEC_DEC", "EQUAL", "PLUS_EQUAL", "MINUS_EQUAL", 
			"DIV_EQUAL", "MUL_EQUAL", "MOD_EQUAL", "LESS", "GREATER", "LEQUAL", "GEQUAL", 
			"EEQUAL", "NEQUAL", "DEQUAL", "DHASH", "L_BRACKET", "R_BRACKET", "L_CURLY", 
			"R_CURLY", "SEMI", "QUESTION", "DOT", "COMMA", "INFER_STATEMENTS", "ENFORCE_STATEMENTS", 
			"WORD", "NUMBER", "INFERRED_DECIMAL", "HALF", "FLOAT", "DOUBLE", "LONG", 
			"SHORT", "INT", "BYTE", "INUM", "NL", "WS", "COMMENT", "BLOCK_COMMENT"
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


	public RaluxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ralux.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000V\u02a3\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007"+
		"D\u0002E\u0007E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007"+
		"I\u0002J\u0007J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007"+
		"N\u0002O\u0007O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007"+
		"S\u0002T\u0007T\u0002U\u0007U\u0002V\u0007V\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00b5\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u00ba\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u00c0\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00d2\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00e3\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00f4\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u0111\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u011d\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u0122\b\u000b\n\u000b\f\u000b\u0125"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u012c"+
		"\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001"+
		",\u0001,\u0001-\u0001-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001"+
		"0\u00010\u00011\u00011\u00011\u00012\u00012\u00012\u00013\u00013\u0001"+
		"3\u00014\u00014\u00014\u00015\u00015\u00015\u00016\u00016\u00017\u0001"+
		"7\u00018\u00018\u00018\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001"+
		";\u0001;\u0001;\u0001<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001>\u0001"+
		">\u0001?\u0001?\u0001@\u0001@\u0001A\u0001A\u0001B\u0001B\u0001C\u0001"+
		"C\u0001D\u0001D\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0001H\u0001H\u0005H\u0229\bH\nH\fH\u022c\tH\u0001H\u0005"+
		"H\u022f\bH\nH\fH\u0232\tH\u0001H\u0001H\u0005H\u0236\bH\nH\fH\u0239\t"+
		"H\u0001H\u0001H\u0004H\u023d\bH\u000bH\fH\u023e\u0003H\u0241\bH\u0003"+
		"H\u0243\bH\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001"+
		"I\u0003I\u024e\bI\u0001J\u0001J\u0001J\u0001J\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0003K\u025a\bK\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0003L\u0262\bL\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0003M\u026a"+
		"\bM\u0001N\u0001N\u0001N\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001"+
		"Q\u0001Q\u0001Q\u0001R\u0004R\u0279\bR\u000bR\fR\u027a\u0001S\u0004S\u027e"+
		"\bS\u000bS\fS\u027f\u0001S\u0001S\u0001T\u0004T\u0285\bT\u000bT\fT\u0286"+
		"\u0001T\u0001T\u0001U\u0001U\u0001U\u0001U\u0005U\u028f\bU\nU\fU\u0292"+
		"\tU\u0001U\u0001U\u0001V\u0001V\u0001V\u0001V\u0005V\u029a\bV\nV\fV\u029d"+
		"\tV\u0001V\u0001V\u0001V\u0001V\u0001V\u0002\u0123\u029b\u0000W\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u0000\u001d"+
		"\u000e\u001f\u000f!\u0010#\u0011%\u0012\'\u0013)\u0014+\u0015-\u0016/"+
		"\u00171\u00183\u00195\u001a7\u001b9\u001c;\u001d=\u001e?\u001fA C!E\""+
		"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a0c1e2g3i4k5m6o7q8s9u:w;y<{=}>\u007f?\u0081"+
		"@\u0083A\u0085B\u0087C\u0089D\u008bE\u008dF\u008fG\u0091H\u0093I\u0095"+
		"J\u0097K\u0099L\u009bM\u009dN\u009fO\u00a1P\u00a3Q\u00a5R\u00a7S\u00a9"+
		"T\u00abU\u00adV\u0001\u0000\u0007\b\u0000\"\"\'\'\\\\bbffnnrrtt\u0004"+
		"\u0000#$AZ__az\u0005\u0000#$09AZ__az\u0001\u000009\u0010\u0000#$AACCE"+
		"EGGJKMRTZ__aacceeggjkmrtz\u0001\u0000\n\n\u0003\u0000\t\t\r\r  \u02cb"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000"+
		";\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001"+
		"\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000"+
		"\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000"+
		"I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001"+
		"\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000"+
		"\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000"+
		"W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001"+
		"\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000"+
		"\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000"+
		"e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001"+
		"\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000"+
		"\u0000\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0000"+
		"s\u0001\u0000\u0000\u0000\u0000u\u0001\u0000\u0000\u0000\u0000w\u0001"+
		"\u0000\u0000\u0000\u0000y\u0001\u0000\u0000\u0000\u0000{\u0001\u0000\u0000"+
		"\u0000\u0000}\u0001\u0000\u0000\u0000\u0000\u007f\u0001\u0000\u0000\u0000"+
		"\u0000\u0081\u0001\u0000\u0000\u0000\u0000\u0083\u0001\u0000\u0000\u0000"+
		"\u0000\u0085\u0001\u0000\u0000\u0000\u0000\u0087\u0001\u0000\u0000\u0000"+
		"\u0000\u0089\u0001\u0000\u0000\u0000\u0000\u008b\u0001\u0000\u0000\u0000"+
		"\u0000\u008d\u0001\u0000\u0000\u0000\u0000\u008f\u0001\u0000\u0000\u0000"+
		"\u0000\u0091\u0001\u0000\u0000\u0000\u0000\u0093\u0001\u0000\u0000\u0000"+
		"\u0000\u0095\u0001\u0000\u0000\u0000\u0000\u0097\u0001\u0000\u0000\u0000"+
		"\u0000\u0099\u0001\u0000\u0000\u0000\u0000\u009b\u0001\u0000\u0000\u0000"+
		"\u0000\u009d\u0001\u0000\u0000\u0000\u0000\u009f\u0001\u0000\u0000\u0000"+
		"\u0000\u00a1\u0001\u0000\u0000\u0000\u0000\u00a3\u0001\u0000\u0000\u0000"+
		"\u0000\u00a5\u0001\u0000\u0000\u0000\u0000\u00a7\u0001\u0000\u0000\u0000"+
		"\u0000\u00a9\u0001\u0000\u0000\u0000\u0000\u00ab\u0001\u0000\u0000\u0000"+
		"\u0000\u00ad\u0001\u0000\u0000\u0000\u0001\u00af\u0001\u0000\u0000\u0000"+
		"\u0003\u00b4\u0001\u0000\u0000\u0000\u0005\u00b9\u0001\u0000\u0000\u0000"+
		"\u0007\u00bb\u0001\u0000\u0000\u0000\t\u00bf\u0001\u0000\u0000\u0000\u000b"+
		"\u00d1\u0001\u0000\u0000\u0000\r\u00e2\u0001\u0000\u0000\u0000\u000f\u00f3"+
		"\u0001\u0000\u0000\u0000\u0011\u0110\u0001\u0000\u0000\u0000\u0013\u0112"+
		"\u0001\u0000\u0000\u0000\u0015\u011c\u0001\u0000\u0000\u0000\u0017\u011e"+
		"\u0001\u0000\u0000\u0000\u0019\u0128\u0001\u0000\u0000\u0000\u001b\u012f"+
		"\u0001\u0000\u0000\u0000\u001d\u0132\u0001\u0000\u0000\u0000\u001f\u0137"+
		"\u0001\u0000\u0000\u0000!\u013d\u0001\u0000\u0000\u0000#\u0142\u0001\u0000"+
		"\u0000\u0000%\u0146\u0001\u0000\u0000\u0000\'\u014a\u0001\u0000\u0000"+
		"\u0000)\u0150\u0001\u0000\u0000\u0000+\u015a\u0001\u0000\u0000\u0000-"+
		"\u0162\u0001\u0000\u0000\u0000/\u0168\u0001\u0000\u0000\u00001\u0173\u0001"+
		"\u0000\u0000\u00003\u0177\u0001\u0000\u0000\u00005\u017a\u0001\u0000\u0000"+
		"\u00007\u017e\u0001\u0000\u0000\u00009\u0184\u0001\u0000\u0000\u0000;"+
		"\u0187\u0001\u0000\u0000\u0000=\u0190\u0001\u0000\u0000\u0000?\u0196\u0001"+
		"\u0000\u0000\u0000A\u019f\u0001\u0000\u0000\u0000C\u01a6\u0001\u0000\u0000"+
		"\u0000E\u01a8\u0001\u0000\u0000\u0000G\u01aa\u0001\u0000\u0000\u0000I"+
		"\u01ac\u0001\u0000\u0000\u0000K\u01af\u0001\u0000\u0000\u0000M\u01b1\u0001"+
		"\u0000\u0000\u0000O\u01b3\u0001\u0000\u0000\u0000Q\u01b5\u0001\u0000\u0000"+
		"\u0000S\u01b7\u0001\u0000\u0000\u0000U\u01b9\u0001\u0000\u0000\u0000W"+
		"\u01bc\u0001\u0000\u0000\u0000Y\u01bf\u0001\u0000\u0000\u0000[\u01c1\u0001"+
		"\u0000\u0000\u0000]\u01c3\u0001\u0000\u0000\u0000_\u01c6\u0001\u0000\u0000"+
		"\u0000a\u01c9\u0001\u0000\u0000\u0000c\u01cb\u0001\u0000\u0000\u0000e"+
		"\u01ce\u0001\u0000\u0000\u0000g\u01d1\u0001\u0000\u0000\u0000i\u01d4\u0001"+
		"\u0000\u0000\u0000k\u01d7\u0001\u0000\u0000\u0000m\u01da\u0001\u0000\u0000"+
		"\u0000o\u01dc\u0001\u0000\u0000\u0000q\u01de\u0001\u0000\u0000\u0000s"+
		"\u01e1\u0001\u0000\u0000\u0000u\u01e4\u0001\u0000\u0000\u0000w\u01e7\u0001"+
		"\u0000\u0000\u0000y\u01ea\u0001\u0000\u0000\u0000{\u01ed\u0001\u0000\u0000"+
		"\u0000}\u01f0\u0001\u0000\u0000\u0000\u007f\u01f2\u0001\u0000\u0000\u0000"+
		"\u0081\u01f4\u0001\u0000\u0000\u0000\u0083\u01f6\u0001\u0000\u0000\u0000"+
		"\u0085\u01f8\u0001\u0000\u0000\u0000\u0087\u01fa\u0001\u0000\u0000\u0000"+
		"\u0089\u01fc\u0001\u0000\u0000\u0000\u008b\u01fe\u0001\u0000\u0000\u0000"+
		"\u008d\u0200\u0001\u0000\u0000\u0000\u008f\u0212\u0001\u0000\u0000\u0000"+
		"\u0091\u0242\u0001\u0000\u0000\u0000\u0093\u024d\u0001\u0000\u0000\u0000"+
		"\u0095\u024f\u0001\u0000\u0000\u0000\u0097\u0253\u0001\u0000\u0000\u0000"+
		"\u0099\u025b\u0001\u0000\u0000\u0000\u009b\u0263\u0001\u0000\u0000\u0000"+
		"\u009d\u026b\u0001\u0000\u0000\u0000\u009f\u026e\u0001\u0000\u0000\u0000"+
		"\u00a1\u0271\u0001\u0000\u0000\u0000\u00a3\u0274\u0001\u0000\u0000\u0000"+
		"\u00a5\u0278\u0001\u0000\u0000\u0000\u00a7\u027d\u0001\u0000\u0000\u0000"+
		"\u00a9\u0284\u0001\u0000\u0000\u0000\u00ab\u028a\u0001\u0000\u0000\u0000"+
		"\u00ad\u0295\u0001\u0000\u0000\u0000\u00af\u00b0\u0005:\u0000\u0000\u00b0"+
		"\u0002\u0001\u0000\u0000\u0000\u00b1\u00b5\u0003\u000b\u0005\u0000\u00b2"+
		"\u00b5\u0003\r\u0006\u0000\u00b3\u00b5\u0003\u000f\u0007\u0000\u00b4\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b5\u0004\u0001\u0000\u0000\u0000\u00b6\u00ba"+
		"\u0003-\u0016\u0000\u00b7\u00ba\u0003/\u0017\u0000\u00b8\u00ba\u0003+"+
		"\u0015\u0000\u00b9\u00b6\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u0006\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0003\u0087C\u0000\u00bc\b\u0001\u0000\u0000"+
		"\u0000\u00bd\u00c0\u0003\'\u0013\u0000\u00be\u00c0\u0003)\u0014\u0000"+
		"\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000"+
		"\u00c0\n\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005b\u0000\u0000\u00c2"+
		"\u00c3\u0005y\u0000\u0000\u00c3\u00c4\u0005t\u0000\u0000\u00c4\u00d2\u0005"+
		"e\u0000\u0000\u00c5\u00c6\u0005i\u0000\u0000\u00c6\u00c7\u0005n\u0000"+
		"\u0000\u00c7\u00d2\u0005t\u0000\u0000\u00c8\u00c9\u0005s\u0000\u0000\u00c9"+
		"\u00ca\u0005h\u0000\u0000\u00ca\u00cb\u0005o\u0000\u0000\u00cb\u00cc\u0005"+
		"r\u0000\u0000\u00cc\u00d2\u0005t\u0000\u0000\u00cd\u00ce\u0005l\u0000"+
		"\u0000\u00ce\u00cf\u0005o\u0000\u0000\u00cf\u00d0\u0005n\u0000\u0000\u00d0"+
		"\u00d2\u0005g\u0000\u0000\u00d1\u00c1\u0001\u0000\u0000\u0000\u00d1\u00c5"+
		"\u0001\u0000\u0000\u0000\u00d1\u00c8\u0001\u0000\u0000\u0000\u00d1\u00cd"+
		"\u0001\u0000\u0000\u0000\u00d2\f\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005"+
		"h\u0000\u0000\u00d4\u00d5\u0005a\u0000\u0000\u00d5\u00d6\u0005l\u0000"+
		"\u0000\u00d6\u00e3\u0005f\u0000\u0000\u00d7\u00d8\u0005f\u0000\u0000\u00d8"+
		"\u00d9\u0005l\u0000\u0000\u00d9\u00da\u0005o\u0000\u0000\u00da\u00db\u0005"+
		"a\u0000\u0000\u00db\u00e3\u0005t\u0000\u0000\u00dc\u00dd\u0005d\u0000"+
		"\u0000\u00dd\u00de\u0005o\u0000\u0000\u00de\u00df\u0005u\u0000\u0000\u00df"+
		"\u00e0\u0005b\u0000\u0000\u00e0\u00e1\u0005l\u0000\u0000\u00e1\u00e3\u0005"+
		"e\u0000\u0000\u00e2\u00d3\u0001\u0000\u0000\u0000\u00e2\u00d7\u0001\u0000"+
		"\u0000\u0000\u00e2\u00dc\u0001\u0000\u0000\u0000\u00e3\u000e\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0005c\u0000\u0000\u00e5\u00e6\u0005h\u0000\u0000"+
		"\u00e6\u00e7\u0005a\u0000\u0000\u00e7\u00f4\u0005r\u0000\u0000\u00e8\u00e9"+
		"\u0005b\u0000\u0000\u00e9\u00ea\u0005o\u0000\u0000\u00ea\u00eb\u0005o"+
		"\u0000\u0000\u00eb\u00ec\u0005l\u0000\u0000\u00ec\u00ed\u0005e\u0000\u0000"+
		"\u00ed\u00ee\u0005a\u0000\u0000\u00ee\u00f4\u0005n\u0000\u0000\u00ef\u00f0"+
		"\u0005v\u0000\u0000\u00f0\u00f1\u0005o\u0000\u0000\u00f1\u00f2\u0005i"+
		"\u0000\u0000\u00f2\u00f4\u0005d\u0000\u0000\u00f3\u00e4\u0001\u0000\u0000"+
		"\u0000\u00f3\u00e8\u0001\u0000\u0000\u0000\u00f3\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f4\u0010\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005p\u0000\u0000"+
		"\u00f6\u00f7\u0005u\u0000\u0000\u00f7\u00f8\u0005b\u0000\u0000\u00f8\u00f9"+
		"\u0005l\u0000\u0000\u00f9\u00fa\u0005i\u0000\u0000\u00fa\u0111\u0005c"+
		"\u0000\u0000\u00fb\u00fc\u0005p\u0000\u0000\u00fc\u00fd\u0005r\u0000\u0000"+
		"\u00fd\u00fe\u0005i\u0000\u0000\u00fe\u00ff\u0005v\u0000\u0000\u00ff\u0100"+
		"\u0005a\u0000\u0000\u0100\u0101\u0005t\u0000\u0000\u0101\u0111\u0005e"+
		"\u0000\u0000\u0102\u0103\u0005p\u0000\u0000\u0103\u0104\u0005r\u0000\u0000"+
		"\u0104\u0105\u0005o\u0000\u0000\u0105\u0106\u0005t\u0000\u0000\u0106\u0107"+
		"\u0005e\u0000\u0000\u0107\u0108\u0005c\u0000\u0000\u0108\u0109\u0005t"+
		"\u0000\u0000\u0109\u010a\u0005e\u0000\u0000\u010a\u0111\u0005d\u0000\u0000"+
		"\u010b\u010c\u0005f\u0000\u0000\u010c\u010d\u0005i\u0000\u0000\u010d\u010e"+
		"\u0005n\u0000\u0000\u010e\u010f\u0005a\u0000\u0000\u010f\u0111\u0005l"+
		"\u0000\u0000\u0110\u00f5\u0001\u0000\u0000\u0000\u0110\u00fb\u0001\u0000"+
		"\u0000\u0000\u0110\u0102\u0001\u0000\u0000\u0000\u0110\u010b\u0001\u0000"+
		"\u0000\u0000\u0111\u0012\u0001\u0000\u0000\u0000\u0112\u0113\u0005s\u0000"+
		"\u0000\u0113\u0114\u0005t\u0000\u0000\u0114\u0115\u0005a\u0000\u0000\u0115"+
		"\u0116\u0005t\u0000\u0000\u0116\u0117\u0005i\u0000\u0000\u0117\u0118\u0005"+
		"c\u0000\u0000\u0118\u0014\u0001\u0000\u0000\u0000\u0119\u011d\u0003\u001d"+
		"\u000e\u0000\u011a\u011d\u0003\u001f\u000f\u0000\u011b\u011d\u0003!\u0010"+
		"\u0000\u011c\u0119\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000"+
		"\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d\u0016\u0001\u0000\u0000"+
		"\u0000\u011e\u0123\u0005\"\u0000\u0000\u011f\u0122\u0003\u001b\r\u0000"+
		"\u0120\u0122\t\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121"+
		"\u0120\u0001\u0000\u0000\u0000\u0122\u0125\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0124"+
		"\u0126\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0005\"\u0000\u0000\u0127\u0018\u0001\u0000\u0000\u0000\u0128\u012b"+
		"\u0005\'\u0000\u0000\u0129\u012c\u0003\u001b\r\u0000\u012a\u012c\t\u0000"+
		"\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012a\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012e\u0005\'\u0000"+
		"\u0000\u012e\u001a\u0001\u0000\u0000\u0000\u012f\u0130\u0005\\\u0000\u0000"+
		"\u0130\u0131\u0007\u0000\u0000\u0000\u0131\u001c\u0001\u0000\u0000\u0000"+
		"\u0132\u0133\u0005t\u0000\u0000\u0133\u0134\u0005r\u0000\u0000\u0134\u0135"+
		"\u0005u\u0000\u0000\u0135\u0136\u0005e\u0000\u0000\u0136\u001e\u0001\u0000"+
		"\u0000\u0000\u0137\u0138\u0005f\u0000\u0000\u0138\u0139\u0005a\u0000\u0000"+
		"\u0139\u013a\u0005l\u0000\u0000\u013a\u013b\u0005s\u0000\u0000\u013b\u013c"+
		"\u0005e\u0000\u0000\u013c \u0001\u0000\u0000\u0000\u013d\u013e\u0005n"+
		"\u0000\u0000\u013e\u013f\u0005u\u0000\u0000\u013f\u0140\u0005l\u0000\u0000"+
		"\u0140\u0141\u0005l\u0000\u0000\u0141\"\u0001\u0000\u0000\u0000\u0142"+
		"\u0143\u0005u\u0000\u0000\u0143\u0144\u0005s\u0000\u0000\u0144\u0145\u0005"+
		"e\u0000\u0000\u0145$\u0001\u0000\u0000\u0000\u0146\u0147\u0005p\u0000"+
		"\u0000\u0147\u0148\u0005k\u0000\u0000\u0148\u0149\u0005g\u0000\u0000\u0149"+
		"&\u0001\u0000\u0000\u0000\u014a\u014b\u0005c\u0000\u0000\u014b\u014c\u0005"+
		"l\u0000\u0000\u014c\u014d\u0005a\u0000\u0000\u014d\u014e\u0005s\u0000"+
		"\u0000\u014e\u014f\u0005s\u0000\u0000\u014f(\u0001\u0000\u0000\u0000\u0150"+
		"\u0151\u0005i\u0000\u0000\u0151\u0152\u0005n\u0000\u0000\u0152\u0153\u0005"+
		"t\u0000\u0000\u0153\u0154\u0005e\u0000\u0000\u0154\u0155\u0005r\u0000"+
		"\u0000\u0155\u0156\u0005f\u0000\u0000\u0156\u0157\u0005a\u0000\u0000\u0157"+
		"\u0158\u0005c\u0000\u0000\u0158\u0159\u0005e\u0000\u0000\u0159*\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0005e\u0000\u0000\u015b\u015c\u0005x\u0000"+
		"\u0000\u015c\u015d\u0005t\u0000\u0000\u015d\u015e\u0005e\u0000\u0000\u015e"+
		"\u015f\u0005n\u0000\u0000\u015f\u0160\u0005d\u0000\u0000\u0160\u0161\u0005"+
		"s\u0000\u0000\u0161,\u0001\u0000\u0000\u0000\u0162\u0163\u0005s\u0000"+
		"\u0000\u0163\u0164\u0005u\u0000\u0000\u0164\u0165\u0005p\u0000\u0000\u0165"+
		"\u0166\u0005e\u0000\u0000\u0166\u0167\u0005r\u0000\u0000\u0167.\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0005i\u0000\u0000\u0169\u016a\u0005n\u0000"+
		"\u0000\u016a\u016b\u0005s\u0000\u0000\u016b\u016c\u0005t\u0000\u0000\u016c"+
		"\u016d\u0005a\u0000\u0000\u016d\u016e\u0005n\u0000\u0000\u016e\u016f\u0005"+
		"c\u0000\u0000\u016f\u0170\u0005e\u0000\u0000\u0170\u0171\u0005o\u0000"+
		"\u0000\u0171\u0172\u0005f\u0000\u0000\u01720\u0001\u0000\u0000\u0000\u0173"+
		"\u0174\u0005n\u0000\u0000\u0174\u0175\u0005e\u0000\u0000\u0175\u0176\u0005"+
		"w\u0000\u0000\u01762\u0001\u0000\u0000\u0000\u0177\u0178\u0005i\u0000"+
		"\u0000\u0178\u0179\u0005f\u0000\u0000\u01794\u0001\u0000\u0000\u0000\u017a"+
		"\u017b\u0005f\u0000\u0000\u017b\u017c\u0005o\u0000\u0000\u017c\u017d\u0005"+
		"r\u0000\u0000\u017d6\u0001\u0000\u0000\u0000\u017e\u017f\u0005w\u0000"+
		"\u0000\u017f\u0180\u0005h\u0000\u0000\u0180\u0181\u0005i\u0000\u0000\u0181"+
		"\u0182\u0005l\u0000\u0000\u0182\u0183\u0005e\u0000\u0000\u01838\u0001"+
		"\u0000\u0000\u0000\u0184\u0185\u0005d\u0000\u0000\u0185\u0186\u0005o\u0000"+
		"\u0000\u0186:\u0001\u0000\u0000\u0000\u0187\u0188\u0005u\u0000\u0000\u0188"+
		"\u0189\u0005n\u0000\u0000\u0189\u018a\u0005s\u0000\u0000\u018a\u018b\u0005"+
		"i\u0000\u0000\u018b\u018c\u0005g\u0000\u0000\u018c\u018d\u0005n\u0000"+
		"\u0000\u018d\u018e\u0005e\u0000\u0000\u018e\u018f\u0005d\u0000\u0000\u018f"+
		"<\u0001\u0000\u0000\u0000\u0190\u0191\u0005b\u0000\u0000\u0191\u0192\u0005"+
		"r\u0000\u0000\u0192\u0193\u0005e\u0000\u0000\u0193\u0194\u0005a\u0000"+
		"\u0000\u0194\u0195\u0005k\u0000\u0000\u0195>\u0001\u0000\u0000\u0000\u0196"+
		"\u0197\u0005c\u0000\u0000\u0197\u0198\u0005o\u0000\u0000\u0198\u0199\u0005"+
		"n\u0000\u0000\u0199\u019a\u0005t\u0000\u0000\u019a\u019b\u0005i\u0000"+
		"\u0000\u019b\u019c\u0005n\u0000\u0000\u019c\u019d\u0005u\u0000\u0000\u019d"+
		"\u019e\u0005e\u0000\u0000\u019e@\u0001\u0000\u0000\u0000\u019f\u01a0\u0005"+
		"r\u0000\u0000\u01a0\u01a1\u0005e\u0000\u0000\u01a1\u01a2\u0005t\u0000"+
		"\u0000\u01a2\u01a3\u0005u\u0000\u0000\u01a3\u01a4\u0005r\u0000\u0000\u01a4"+
		"\u01a5\u0005n\u0000\u0000\u01a5B\u0001\u0000\u0000\u0000\u01a6\u01a7\u0005"+
		"+\u0000\u0000\u01a7D\u0001\u0000\u0000\u0000\u01a8\u01a9\u0005-\u0000"+
		"\u0000\u01a9F\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005*\u0000\u0000\u01ab"+
		"H\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005*\u0000\u0000\u01ad\u01ae\u0005"+
		"*\u0000\u0000\u01aeJ\u0001\u0000\u0000\u0000\u01af\u01b0\u0005/\u0000"+
		"\u0000\u01b0L\u0001\u0000\u0000\u0000\u01b1\u01b2\u0005^\u0000\u0000\u01b2"+
		"N\u0001\u0000\u0000\u0000\u01b3\u01b4\u0005|\u0000\u0000\u01b4P\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b6\u0005&\u0000\u0000\u01b6R\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u0005%\u0000\u0000\u01b8T\u0001\u0000\u0000\u0000\u01b9"+
		"\u01ba\u0005|\u0000\u0000\u01ba\u01bb\u0005|\u0000\u0000\u01bbV\u0001"+
		"\u0000\u0000\u0000\u01bc\u01bd\u0005&\u0000\u0000\u01bd\u01be\u0005&\u0000"+
		"\u0000\u01beX\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005(\u0000\u0000\u01c0"+
		"Z\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005)\u0000\u0000\u01c2\\\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c4\u0005+\u0000\u0000\u01c4\u01c5\u0005+\u0000"+
		"\u0000\u01c5^\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005-\u0000\u0000\u01c7"+
		"\u01c8\u0005-\u0000\u0000\u01c8`\u0001\u0000\u0000\u0000\u01c9\u01ca\u0005"+
		"=\u0000\u0000\u01cab\u0001\u0000\u0000\u0000\u01cb\u01cc\u0005+\u0000"+
		"\u0000\u01cc\u01cd\u0005=\u0000\u0000\u01cdd\u0001\u0000\u0000\u0000\u01ce"+
		"\u01cf\u0005-\u0000\u0000\u01cf\u01d0\u0005=\u0000\u0000\u01d0f\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d2\u0005/\u0000\u0000\u01d2\u01d3\u0005=\u0000"+
		"\u0000\u01d3h\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005*\u0000\u0000\u01d5"+
		"\u01d6\u0005=\u0000\u0000\u01d6j\u0001\u0000\u0000\u0000\u01d7\u01d8\u0005"+
		"%\u0000\u0000\u01d8\u01d9\u0005=\u0000\u0000\u01d9l\u0001\u0000\u0000"+
		"\u0000\u01da\u01db\u0005<\u0000\u0000\u01dbn\u0001\u0000\u0000\u0000\u01dc"+
		"\u01dd\u0005>\u0000\u0000\u01ddp\u0001\u0000\u0000\u0000\u01de\u01df\u0005"+
		"<\u0000\u0000\u01df\u01e0\u0005=\u0000\u0000\u01e0r\u0001\u0000\u0000"+
		"\u0000\u01e1\u01e2\u0005>\u0000\u0000\u01e2\u01e3\u0005=\u0000\u0000\u01e3"+
		"t\u0001\u0000\u0000\u0000\u01e4\u01e5\u0005=\u0000\u0000\u01e5\u01e6\u0005"+
		"=\u0000\u0000\u01e6v\u0001\u0000\u0000\u0000\u01e7\u01e8\u0005!\u0000"+
		"\u0000\u01e8\u01e9\u0005=\u0000\u0000\u01e9x\u0001\u0000\u0000\u0000\u01ea"+
		"\u01eb\u0005.\u0000\u0000\u01eb\u01ec\u0005=\u0000\u0000\u01ecz\u0001"+
		"\u0000\u0000\u0000\u01ed\u01ee\u0005.\u0000\u0000\u01ee\u01ef\u0005#\u0000"+
		"\u0000\u01ef|\u0001\u0000\u0000\u0000\u01f0\u01f1\u0005[\u0000\u0000\u01f1"+
		"~\u0001\u0000\u0000\u0000\u01f2\u01f3\u0005]\u0000\u0000\u01f3\u0080\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f5\u0005{\u0000\u0000\u01f5\u0082\u0001\u0000"+
		"\u0000\u0000\u01f6\u01f7\u0005}\u0000\u0000\u01f7\u0084\u0001\u0000\u0000"+
		"\u0000\u01f8\u01f9\u0005;\u0000\u0000\u01f9\u0086\u0001\u0000\u0000\u0000"+
		"\u01fa\u01fb\u0005?\u0000\u0000\u01fb\u0088\u0001\u0000\u0000\u0000\u01fc"+
		"\u01fd\u0005.\u0000\u0000\u01fd\u008a\u0001\u0000\u0000\u0000\u01fe\u01ff"+
		"\u0005,\u0000\u0000\u01ff\u008c\u0001\u0000\u0000\u0000\u0200\u0201\u0005"+
		"%\u0000\u0000\u0201\u0202\u0005i\u0000\u0000\u0202\u0203\u0005n\u0000"+
		"\u0000\u0203\u0204\u0005f\u0000\u0000\u0204\u0205\u0005e\u0000\u0000\u0205"+
		"\u0206\u0005r\u0000\u0000\u0206\u0207\u0005_\u0000\u0000\u0207\u0208\u0005"+
		"s\u0000\u0000\u0208\u0209\u0005e\u0000\u0000\u0209\u020a\u0005m\u0000"+
		"\u0000\u020a\u020b\u0005i\u0000\u0000\u020b\u020c\u0005c\u0000\u0000\u020c"+
		"\u020d\u0005o\u0000\u0000\u020d\u020e\u0005l\u0000\u0000\u020e\u020f\u0005"+
		"o\u0000\u0000\u020f\u0210\u0005n\u0000\u0000\u0210\u0211\u0005%\u0000"+
		"\u0000\u0211\u008e\u0001\u0000\u0000\u0000\u0212\u0213\u0005%\u0000\u0000"+
		"\u0213\u0214\u0005e\u0000\u0000\u0214\u0215\u0005n\u0000\u0000\u0215\u0216"+
		"\u0005f\u0000\u0000\u0216\u0217\u0005o\u0000\u0000\u0217\u0218\u0005r"+
		"\u0000\u0000\u0218\u0219\u0005c\u0000\u0000\u0219\u021a\u0005e\u0000\u0000"+
		"\u021a\u021b\u0005_\u0000\u0000\u021b\u021c\u0005s\u0000\u0000\u021c\u021d"+
		"\u0005e\u0000\u0000\u021d\u021e\u0005m\u0000\u0000\u021e\u021f\u0005i"+
		"\u0000\u0000\u021f\u0220\u0005c\u0000\u0000\u0220\u0221\u0005o\u0000\u0000"+
		"\u0221\u0222\u0005l\u0000\u0000\u0222\u0223\u0005o\u0000\u0000\u0223\u0224"+
		"\u0005n\u0000\u0000\u0224\u0225\u0005%\u0000\u0000\u0225\u0090\u0001\u0000"+
		"\u0000\u0000\u0226\u022a\u0007\u0001\u0000\u0000\u0227\u0229\u0007\u0002"+
		"\u0000\u0000\u0228\u0227\u0001\u0000\u0000\u0000\u0229\u022c\u0001\u0000"+
		"\u0000\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000"+
		"\u0000\u0000\u022b\u0243\u0001\u0000\u0000\u0000\u022c\u022a\u0001\u0000"+
		"\u0000\u0000\u022d\u022f\u0007\u0003\u0000\u0000\u022e\u022d\u0001\u0000"+
		"\u0000\u0000\u022f\u0232\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000"+
		"\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u0240\u0001\u0000"+
		"\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0233\u0237\u0007\u0004"+
		"\u0000\u0000\u0234\u0236\u0007\u0002\u0000\u0000\u0235\u0234\u0001\u0000"+
		"\u0000\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237\u0235\u0001\u0000"+
		"\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u0241\u0001\u0000"+
		"\u0000\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a\u023c\u0007\u0001"+
		"\u0000\u0000\u023b\u023d\u0007\u0002\u0000\u0000\u023c\u023b\u0001\u0000"+
		"\u0000\u0000\u023d\u023e\u0001\u0000\u0000\u0000\u023e\u023c\u0001\u0000"+
		"\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0241\u0001\u0000"+
		"\u0000\u0000\u0240\u0233\u0001\u0000\u0000\u0000\u0240\u023a\u0001\u0000"+
		"\u0000\u0000\u0241\u0243\u0001\u0000\u0000\u0000\u0242\u0226\u0001\u0000"+
		"\u0000\u0000\u0242\u0230\u0001\u0000\u0000\u0000\u0243\u0092\u0001\u0000"+
		"\u0000\u0000\u0244\u024e\u0003\u0095J\u0000\u0245\u024e\u0003\u0097K\u0000"+
		"\u0246\u024e\u0003\u0099L\u0000\u0247\u024e\u0003\u009bM\u0000\u0248\u024e"+
		"\u0003\u00a3Q\u0000\u0249\u024e\u0003\u009fO\u0000\u024a\u024e\u0003\u00a1"+
		"P\u0000\u024b\u024e\u0003\u009dN\u0000\u024c\u024e\u0003\u00a5R\u0000"+
		"\u024d\u0244\u0001\u0000\u0000\u0000\u024d\u0245\u0001\u0000\u0000\u0000"+
		"\u024d\u0246\u0001\u0000\u0000\u0000\u024d\u0247\u0001\u0000\u0000\u0000"+
		"\u024d\u0248\u0001\u0000\u0000\u0000\u024d\u0249\u0001\u0000\u0000\u0000"+
		"\u024d\u024a\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000\u0000\u0000"+
		"\u024d\u024c\u0001\u0000\u0000\u0000\u024e\u0094\u0001\u0000\u0000\u0000"+
		"\u024f\u0250\u0003\u00a5R\u0000\u0250\u0251\u0005.\u0000\u0000\u0251\u0252"+
		"\u0003\u00a5R\u0000\u0252\u0096\u0001\u0000\u0000\u0000\u0253\u0259\u0003"+
		"\u00a5R\u0000\u0254\u025a\u0005h\u0000\u0000\u0255\u0256\u0005.\u0000"+
		"\u0000\u0256\u0257\u0003\u00a5R\u0000\u0257\u0258\u0005h\u0000\u0000\u0258"+
		"\u025a\u0001\u0000\u0000\u0000\u0259\u0254\u0001\u0000\u0000\u0000\u0259"+
		"\u0255\u0001\u0000\u0000\u0000\u025a\u0098\u0001\u0000\u0000\u0000\u025b"+
		"\u0261\u0003\u00a5R\u0000\u025c\u0262\u0005f\u0000\u0000\u025d\u025e\u0005"+
		".\u0000\u0000\u025e\u025f\u0003\u00a5R\u0000\u025f\u0260\u0005f\u0000"+
		"\u0000\u0260\u0262\u0001\u0000\u0000\u0000\u0261\u025c\u0001\u0000\u0000"+
		"\u0000\u0261\u025d\u0001\u0000\u0000\u0000\u0262\u009a\u0001\u0000\u0000"+
		"\u0000\u0263\u0269\u0003\u00a5R\u0000\u0264\u026a\u0005d\u0000\u0000\u0265"+
		"\u0266\u0005.\u0000\u0000\u0266\u0267\u0003\u00a5R\u0000\u0267\u0268\u0005"+
		"d\u0000\u0000\u0268\u026a\u0001\u0000\u0000\u0000\u0269\u0264\u0001\u0000"+
		"\u0000\u0000\u0269\u0265\u0001\u0000\u0000\u0000\u026a\u009c\u0001\u0000"+
		"\u0000\u0000\u026b\u026c\u0003\u00a5R\u0000\u026c\u026d\u0005l\u0000\u0000"+
		"\u026d\u009e\u0001\u0000\u0000\u0000\u026e\u026f\u0003\u00a5R\u0000\u026f"+
		"\u0270\u0005s\u0000\u0000\u0270\u00a0\u0001\u0000\u0000\u0000\u0271\u0272"+
		"\u0003\u00a5R\u0000\u0272\u0273\u0005i\u0000\u0000\u0273\u00a2\u0001\u0000"+
		"\u0000\u0000\u0274\u0275\u0003\u00a5R\u0000\u0275\u0276\u0005b\u0000\u0000"+
		"\u0276\u00a4\u0001\u0000\u0000\u0000\u0277\u0279\u0007\u0003\u0000\u0000"+
		"\u0278\u0277\u0001\u0000\u0000\u0000\u0279\u027a\u0001\u0000\u0000\u0000"+
		"\u027a\u0278\u0001\u0000\u0000\u0000\u027a\u027b\u0001\u0000\u0000\u0000"+
		"\u027b\u00a6\u0001\u0000\u0000\u0000\u027c\u027e\u0007\u0005\u0000\u0000"+
		"\u027d\u027c\u0001\u0000\u0000\u0000\u027e\u027f\u0001\u0000\u0000\u0000"+
		"\u027f\u027d\u0001\u0000\u0000\u0000\u027f\u0280\u0001\u0000\u0000\u0000"+
		"\u0280\u0281\u0001\u0000\u0000\u0000\u0281\u0282\u0006S\u0000\u0000\u0282"+
		"\u00a8\u0001\u0000\u0000\u0000\u0283\u0285\u0007\u0006\u0000\u0000\u0284"+
		"\u0283\u0001\u0000\u0000\u0000\u0285\u0286\u0001\u0000\u0000\u0000\u0286"+
		"\u0284\u0001\u0000\u0000\u0000\u0286\u0287\u0001\u0000\u0000\u0000\u0287"+
		"\u0288\u0001\u0000\u0000\u0000\u0288\u0289\u0006T\u0001\u0000\u0289\u00aa"+
		"\u0001\u0000\u0000\u0000\u028a\u028b\u0005/\u0000\u0000\u028b\u028c\u0005"+
		"/\u0000\u0000\u028c\u0290\u0001\u0000\u0000\u0000\u028d\u028f\b\u0005"+
		"\u0000\u0000\u028e\u028d\u0001\u0000\u0000\u0000\u028f\u0292\u0001\u0000"+
		"\u0000\u0000\u0290\u028e\u0001\u0000\u0000\u0000\u0290\u0291\u0001\u0000"+
		"\u0000\u0000\u0291\u0293\u0001\u0000\u0000\u0000\u0292\u0290\u0001\u0000"+
		"\u0000\u0000\u0293\u0294\u0006U\u0001\u0000\u0294\u00ac\u0001\u0000\u0000"+
		"\u0000\u0295\u0296\u0005/\u0000\u0000\u0296\u0297\u0005*\u0000\u0000\u0297"+
		"\u029b\u0001\u0000\u0000\u0000\u0298\u029a\t\u0000\u0000\u0000\u0299\u0298"+
		"\u0001\u0000\u0000\u0000\u029a\u029d\u0001\u0000\u0000\u0000\u029b\u029c"+
		"\u0001\u0000\u0000\u0000\u029b\u0299\u0001\u0000\u0000\u0000\u029c\u029e"+
		"\u0001\u0000\u0000\u0000\u029d\u029b\u0001\u0000\u0000\u0000\u029e\u029f"+
		"\u0005*\u0000\u0000\u029f\u02a0\u0005/\u0000\u0000\u02a0\u02a1\u0001\u0000"+
		"\u0000\u0000\u02a1\u02a2\u0006V\u0001\u0000\u02a2\u00ae\u0001\u0000\u0000"+
		"\u0000\u001b\u0000\u00b4\u00b9\u00bf\u00d1\u00e2\u00f3\u0110\u011c\u0121"+
		"\u0123\u012b\u022a\u0230\u0237\u023e\u0240\u0242\u024d\u0259\u0261\u0269"+
		"\u027a\u027f\u0286\u0290\u029b\u0002\u0000\u0001\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}