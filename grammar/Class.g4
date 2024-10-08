grammar Class;

import Method, Ralux, Arithmetic, Statement;

class: annotation*? (MODIFIER|STATIC)*? C_TYPE WORD generic? (EXTENDS type)? c_body;

c_body: '{' c_component* '}';
c_component: class|method|SEMI+;
