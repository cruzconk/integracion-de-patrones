package com.company.documents.builder;

import com.company.documents.model.Document;

public class ExecutiveReportBuilder extends DocumentBuilder {
    public ExecutiveReportBuilder(){title="Executive Report";}
    @Override public Document build(){return new Document(title,blocks);}
}
