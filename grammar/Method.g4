grammar Method;

import Statement, Tokens, Typing, Ralux;

// TODO: params
method: annotation*? (MODIFIER|STATIC)*? generic? full_type WORD '(' def_params ')' body? (SEMI semi_truck)?;
def_params: (full_type WORD (COMMA full_type WORD)*)?;
