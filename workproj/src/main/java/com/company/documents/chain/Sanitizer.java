package com.company.documents.chain;
public class Sanitizer extends ProcessorHandler {
 protected String processCurrent(String c){return c.replaceAll("(?i)secret|confidential","[REDACTED]");}
}
