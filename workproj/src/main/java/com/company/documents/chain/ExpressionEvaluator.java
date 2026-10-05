package com.company.documents.chain;
import com.company.documents.interpreter.*;
import java.util.*;import java.util.regex.*;
public class ExpressionEvaluator extends ProcessorHandler {
 private final Map<String,Double> variables;
 public ExpressionEvaluator(Map<String,Double> variables){this.variables=variables;}
 protected String processCurrent(String c){Matcher m=Pattern.compile("#\\{([^}]+)\\}").matcher(c);StringBuffer sb=new StringBuffer();while(m.find()){double v=new ExpressionParser(m.group(1),variables).evaluate();m.appendReplacement(sb,Matcher.quoteReplacement(String.format(Locale.US,"%.2f",v)));}m.appendTail(sb);return sb.toString();}
}
