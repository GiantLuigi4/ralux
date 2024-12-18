grammar Arithmetic;

import Tokens, Typing, Statement, Typing;

// Parser rules
expr: expr '.#'
    | '-' expr
    | '(' full_type ')' expr
    | '(' expr ')'
    | expr '<->' expr
    | expr '**' expr
    | expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | expr ('%'|'&'|'^'|'|') expr
    | expr ('<'|'>'|'<='|'>='|'=='|'!='|'.='|'.!=') expr
    | expr ('&&'|'||') expr
    | fb_expr
;

fb_expr: NUMBER | CONSTANT // const&number
       | qualif            // variable
       | STRING | CHR      // string&char
       | call
       | assignment
;
