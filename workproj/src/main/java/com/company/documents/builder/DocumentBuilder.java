package com.company.documents.builder;

import com.company.documents.model.Document;
import java.util.*;

public abstract class DocumentBuilder {
    protected String title="Document"; protected final List<String> blocks=new ArrayList<>();
    public DocumentBuilder addHeader(String texto){blocks.add("[HEADER] "+texto);return this;}
    public DocumentBuilder addParagraph(String texto){blocks.add("[PARAGRAPH] "+texto);return this;}
    public DocumentBuilder addTable(String texto){blocks.add("[TABLE] "+texto);return this;}
    public DocumentBuilder addFooter(String texto){blocks.add("[FOOTER] "+texto);return this;}
    public abstract Document build();
}
