package com.company.documents.model;

import com.company.documents.bridge.RenderEngine;

public class PagedDocument {
    private final Document document;
    private final RenderEngine renderingr;
    public PagedDocument(Document document, RenderEngine renderingr){this.document=document;this.renderingr=renderingr;}
    public String render(){return renderingr.render(document);}
}
