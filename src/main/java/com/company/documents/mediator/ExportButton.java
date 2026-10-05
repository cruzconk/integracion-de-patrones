package com.company.documents.mediator;
import com.company.documents.builder.DocumentBuilder;import com.company.documents.bridge.RenderEngine;
public class ExportButton {private DocumentEditorMediator mediator;void setMediator(DocumentEditorMediator m){mediator=m;}public void click(){mediator.exportDocument();}void exportInternal(DocumentBuilder b,RenderEngine r){if(b==null||r==null)throw new IllegalStateException("Missing configuration");System.out.println("  Export prepared through Bridge.");}}
