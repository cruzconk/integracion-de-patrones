package com.company.documents.mediator;
import com.company.documents.builder.DocumentBuilder;
import com.company.documents.bridge.RenderEngine;
public class DocumentEditorMediator {
 private final FormatSelector selector; private final ToolbarBuilder toolbar; private final Preview preview; private final ExportButton exportButton;
 private DocumentBuilder builder; private RenderEngine renderingr;
 public DocumentEditorMediator(FormatSelector s,ToolbarBuilder b,Preview v,ExportButton e){selector=s;toolbar=b;preview=v;exportButton=e;s.setMediator(this);b.setMediator(this);v.setMediator(this);e.setMediator(this);}
 public void setBuilder(DocumentBuilder b){builder=b;toolbar.update();}
 public void formatChanged(String f){renderingr=selector.createRenderer(f);toolbar.update();preview.update();}
 public void exportDocument(){exportButton.exportInternal(builder,renderingr);}
 public DocumentBuilder getBuilder(){return builder;}
}
