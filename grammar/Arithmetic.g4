grammar Arithmetic;

import Tokens, Typing, Statement, Typing;

// Parser rules
expr: expr '.#'
    | '(' full_type ')' expr
    | '(' expr ')'
    | expr (
          '**'
        | ('*'|'/')
        | ('+'|'-')
        | ('%'|'&'|'^'|'|')
        | ('&&'|'||')
        | ('<'|'>'|'<='|'>='|'=='|'!='|'.='|'.!=')
    ) expr
    | fb_expr
;

fb_expr: NUMBER | CONSTANT // const&number
       | WORD              // variable
       | STRING | CHR      // string&char
       | call
       | assignment
;
