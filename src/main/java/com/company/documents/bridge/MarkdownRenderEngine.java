package com.company.documents.bridge;
import com.company.documents.model.Document;
public class MarkdownRenderEngine implements RenderEngine {
 public String render(Document d){return "# "+d.getTitle()+"\n\n"+d.content();}
}
