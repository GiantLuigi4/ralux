grammar Arithmetic;

import Tokens, Typing, Statement;

// Parser rules
expr: expr '.#'
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
