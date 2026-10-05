package com.company.documents.interpreter;
import java.util.*;
public class ExpressionParser {
 private final String s; private int p; private final Map<String,Double> variables;
 public ExpressionParser(String s,Map<String,Double> variables){this.s=s.replace(" ","");this.variables=variables;}
 public double evaluate(){Expression e=expression();if(p<s.length())throw new IllegalArgumentException("Invalid expression: "+s);return e.interpret(variables);}
 private Expression expression(){Expression e=term();while(p<s.length()&&(s.charAt(p)=='+'||s.charAt(p)=='-')){char op=s.charAt(p++);e=new NonTerminalExpression(e,op,term());}return e;}
 private Expression term(){Expression e=factor();while(p<s.length()&&(s.charAt(p)=='*'||s.charAt(p)=='/')){char op=s.charAt(p++);e=new NonTerminalExpression(e,op,factor());}return e;}
 private Expression factor(){if(p<s.length()&&s.charAt(p)=='('){p++;Expression e=expression();if(p>=s.length()||s.charAt(p++)!=')')throw new IllegalArgumentException("Missing )");return e;}int i=p;while(p<s.length()&&(Character.isLetterOrDigit(s.charAt(p))||s.charAt(p)=='.'||s.charAt(p)=='_'))p++;if(i==p)throw new IllegalArgumentException("Invalid token");return new TerminalExpression(s.substring(i,p));}
}
