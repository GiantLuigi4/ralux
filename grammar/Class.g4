grammar Class;

import Method, Ralux, Arithmetic, Statement, Field;

class: annotation*? (MODIFIER|STATIC)*? C_TYPE WORD generic? (EXTENDS type)? c_body;

c_body: '{' c_component* '}';
c_component: class|field|method|SEMI+;
