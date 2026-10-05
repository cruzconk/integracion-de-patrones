package com.company.documents.chain;
public abstract class ProcessorHandler {
 protected ProcessorHandler next;
 public ProcessorHandler linkWith(ProcessorHandler h){next=h;return h;}
 public final String process(String content){String r=processCurrent(content);if(r==null)throw new IllegalStateException("Chain stopped due to a critical error.");return next==null?r:next.process(r);}
 protected abstract String processCurrent(String content);
}
