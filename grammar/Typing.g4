grammar Typing;

import Tokens;

full_type: type array?;
generic: '<' (generic_element (COMMA generic_element)*)? '>';
generic_element: (full_type|GENERIC_WILDCARD)
               | ((WORD|GENERIC_WILDCARD) (GENERIC_CONSTRAINT type)?);
type: (UNSIGNED? PRIMITIVE)|named_type;
named_type: (WORD DOT)* WORD generic?;
array: '[' (NUMBER (COMMA NUMBER)*)? ']';
