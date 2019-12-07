// Derived from http://json.org
grammar XML;

xml: pair* ;


pair:  start (value |  pair*) end;

start: '<' STRING '>';

end: '</' STRING '>';

value:   STRING;


LETTER :  [a-zA-Z] ;
STRING :  (LETTER | ZEICHEN) (LETTER | [0-9] |ZEICHEN)* ;
ZEICHEN: '/' | '.'|[ ];


WS  :   [ \t\n\r]+ -> skip ;