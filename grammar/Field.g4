grammar Field;

import Statement, Tokens, Typing, Ralux;

// TODO: params
field: annotation*? (MODIFIER|STATIC)*? generic? full_type WORD ('=' (expr | body))? (semi_truck);
