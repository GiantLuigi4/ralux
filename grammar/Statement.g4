grammar Statement;

import Arithmetic, Typing, Directive, Tokens;

statement_list: (body|flow|(directive|SEMI+|(statement semi_truck)))*;
body: '{' statement_list '}';

statement: call | definition | assignment | directive | ret;

// return
ret: RETURN expr;

// control flow
flow: if|loop|special|label;
loop: label* (for|while|do);

special: ((BREAK|CONTINUE) WORD?) state_end;
state_end: SEMI|NL;
label: WORD ':';

// do
do: DO body while_header;

// while loop
while: while_header (body|(statement semi_truck));
while_header: WHILE '(' expr ')';

// if
if: IF '(' expr ')' (body|(flow|(statement semi_truck))) ((ELSE if) | (ELSE (flow|body|(statement semi_truck))))?;

// for loop
for: FOR '(' (loop_enhanced|loop_standard) ')' (body|(statement semi_truck));
loop_enhanced: full_type? WORD ':' expr;
loop_standard: ((flow|statement)?) semi_truck (expr) semi_truck ((flow|statement)?);

//|'+='|'-='|'/='|'*='|'&='|'^='|'%='
definition: full_type WORD '=' expr;
assignment: (qualif operand expr)|(WORD dOperand);

// calls
call: method_call|ctor;
method_call: (named_type '.')? WORD '(' params? ')';
ctor: NEW type '(' params? ')';
// TODO; fix
params: (expr ',')* expr;

qualif: ((named_type '.')? WORD);

// operands
dOperand: INC_INC|DEC_DEC;
operand: EQUAL
       | PLUS_EQUAL|MINUS_EQUAL
       | DIV_EQUAL|MUL_EQUAL
       | MOD_EQUAL
;

//semi_truck: (SEMI+)|{inferSemicolons}?;

// yes, I hand optimized this
semi_truck:
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
;
