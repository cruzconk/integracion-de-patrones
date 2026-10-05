package com.company.documents.mediator;
import com.company.documents.bridge.*;
public class FormatSelector {private DocumentEditorMediator mediator;void setMediator(DocumentEditorMediator m){mediator=m;} public void select(String f){mediator.formatChanged(f);} public RenderEngine createRenderer(String f){return switch(f.toUpperCase()){case "PDF"->new PdfRenderEngine();case "HTML"->new HtmlRenderEngine();default->new MarkdownRenderEngine();};}}
