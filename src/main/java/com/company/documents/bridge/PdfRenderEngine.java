package com.company.documents.bridge;
import com.company.documents.model.Document;
public class PdfRenderEngine implements RenderEngine {
 public String render(Document d){return "=== PDF ===\n"+d.getTitle()+"\n"+d.content();}
}
