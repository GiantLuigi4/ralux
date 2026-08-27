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
    | expr '[' expr ']'
;

fb_expr: NUMBER | CONSTANT // const&number
       | var_ref            // variable
       | STRING | CHR      // string&char
       | call
       | assignment
;
