package com.company.documents.builder;

import com.company.documents.model.Document;

public class SimpleInvoiceBuilder extends DocumentBuilder {
    public SimpleInvoiceBuilder(){title="Simple Invoice";}
    @Override public Document build(){return new Document(title,blocks);}
}
