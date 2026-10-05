package com.company.documents.chain;
public class SyntaxValidator extends ProcessorHandler {
 protected String processCurrent(String c){int a=c.indexOf("#{"), b=c.indexOf('}',a); if(a>=0&&b<0) return null; return c;}
}
