grammar Directive;

import Tokens;

@parser::members {
    boolean inferSemicolons = false;
}

directive: (INFER_STATEMENTS { inferSemicolons = true; })
         | (ENFORCE_STATEMENTS { inferSemicolons = false; })
;
