package com.company.documents.interpreter;
import java.util.Map;
public class TerminalExpression implements Expression {
 private final String valor; public TerminalExpression(String valor){this.valor=valor;}
 public double interpret(Map<String,Double> c){try{return Double.parseDouble(valor);}catch(NumberFormatException e){return c.getOrDefault(valor,0.0);}}
}
