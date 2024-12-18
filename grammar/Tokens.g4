lexer grammar Tokens;

// Lexer rules (tokens)

// collectives
PRIMITIVE: PRIMITIVE_INT | PRIMITIVE_FP | PRIMITIVE_OTHER;
GENERIC_CONSTRAINT: SUPER | INSTANCE_OF | EXTENDS;
GENERIC_WILDCARD: QUESTION;
C_TYPE: CLASS|INTERFACE;

// Primitive types have higher precedence than generic WORDs
PRIMITIVE_INT: 'byte' | 'int' | 'short' | 'long' | 'wide';
PRIMITIVE_FP: 'half' | 'float' | 'double' | 'quadruple';
PRIMITIVE_OTHER: 'char' | 'boolean' | 'void';
MODIFIER: 'public' | 'private' | 'protected' | 'final' | 'abi' | 'stub';
STATIC: 'static';

CONSTANT: TRUE | FALSE | NULL;

STRING: '"' ((ESC|~(["]))*?) ('"'|EOF);
CHR: '\'' (ESC|~(['])) ('\''|EOF);
fragment ESC: '\\' [btnfr'"\\];

// constants
TRUE: 'true';
FALSE: 'false';
NULL: 'null';

// keywords
USE: 'use';
PKG: 'pkg';

CLASS: 'class';
INTERFACE: 'interface';

EXTENDS: 'extends';
SUPER: 'super';
INSTANCE_OF: 'instanceof';

NEW: 'new';

IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
DO: 'do';

BREAK: 'break';
CONTINUE: 'continue';
RETURN: 'return';

UNSIGNED: 'unsigned';

// Operators and parentheses
PLUS: '+';
MINUS: '-';
MUL: '*';
POW: '**';
DIV: '/';
XOR: '^';
BOR: '|';
BAND: '&';
MOD: '%';
OR: '||';
AND: '&&';
LPAREN: '(';
RPAREN: ')';

// assignments
INC_INC: '++';
DEC_DEC: '--';

EQUAL: '=';
PLUS_EQUAL: '+=';
MINUS_EQUAL: '-=';
DIV_EQUAL: '/=';
MUL_EQUAL: '*=';
MOD_EQUAL: '%=';
VAR_SWAP: '<->';

// symbols
LESS: '<';
GREATER: '>';
LEQUAL: '<=';
GEQUAL: '>=';
EEQUAL: '==';
NEQUAL: '!=';
DEQUAL: '.=';
DNEQUAL: '.!=';
DHASH: '.#';

L_BRACKET: '[';
R_BRACKET: ']';
L_CURLY: '{';
R_CURLY: '}';
SEMI: ';';
QUESTION: '?';
DOT: '.';
COMMA: ',';
INFER_STATEMENTS: '%infer_semicolon%';
ENFORCE_STATEMENTS: '%enforce_semicolon%';

// generic word token
// words can start with a number, but if they do so, they must also contain a letter (excluding ones that correspond to numeric primitives) or more letters after that
WORD: ([_$#a-zA-Z] [0-9_$#a-zA-Z]*)
    | ([0-9]* (([_$#acegjkmnoprtuvxyzACEGJKMNOPRTUVXYZ] [0-9_$#a-zA-Z]*)|([_$#a-zA-Z] [0-9_$#a-zA-Z]+)))
;

// Numeric tokens
NUMBER: INFERRED_DECIMAL|HALF|FLOAT|DOUBLE|QUAD|BYTE|SHORT|INT|LONG|WIDE|INUM;
INFERRED_DECIMAL: INUM '.' INUM;
HALF: INUM('h'|('.' INUM 'h'));
FLOAT: INUM('f'|('.' INUM 'f'));
DOUBLE: INUM('d'|('.' INUM 'd'));
QUAD: INUM('q'|('.' INUM 'q'));
WIDE: INUM'w';
LONG: INUM'l';
SHORT: INUM's';
INT: INUM'i';
BYTE: INUM'b';
INUM: [0-9]+;

// Skip whitespace
NL: [\n]+    -> channel(2);
WS: [ \t\r]+ -> channel(2);
COMMENT: '//' ~[\n]* -> channel(2);
BLOCK_COMMENT: '/*' .*? '*/' -> channel(2);
