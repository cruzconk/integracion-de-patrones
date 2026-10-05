package com.company.documents.bridge;
import com.company.documents.model.Document;
public class HtmlRenderEngine implements RenderEngine {
 public String render(Document d){return "<html><body><h1>"+d.getTitle()+"</h1><pre>"+d.content()+"</pre></body></html>";}
}
