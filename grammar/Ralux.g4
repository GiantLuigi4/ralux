grammar Ralux;

import Class, Method, Directive;

file: (directive|header|class|(SEMI+))*;

header: ((static_use)|('use'|'pkg') named_type) semi_truck;
// syntax: use static tfc.ralux.core.System#out#println
// reason for it ending in just WORD, is because words can include "#", as there's no # token
static_use: 'use' STATIC named_type WORD;

// common
annotation: '[' (~']')* ']';
