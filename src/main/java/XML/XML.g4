// Derived from http://json.org
grammar XML;

xml: pair* ;


pair:  startv (value | array) endv;

startv: '<' value '>';

endv: '</' value '>';

value:   STRING;

array: pair*;


LETTER :  [a-zA-Z] ;
STRING :  (LETTER | ZEICHEN) (LETTER | [0-9] |ZEICHEN)* ;
ZEICHEN: '/' | '.'|[ ];


WS  :   [ \t\n\r]+ -> skip ;