package com.company.documents.interpreter;
import java.util.Map;
public class NonTerminalExpression implements Expression {
 private final Expression left,right; private final char operator;
 public NonTerminalExpression(Expression i,char o,Expression d){left=i;operator=o;right=d;}
 public double interpret(Map<String,Double> c){double a=left.interpret(c),b=right.interpret(c);return operator=='+'?a+b:operator=='-'?a-b:operator=='*'?a*b:a/b;}
}
