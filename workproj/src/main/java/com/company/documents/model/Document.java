package com.company.documents.model;

import java.util.*;

public class Document {
    private final String title;
    private final List<String> blocks;
    public Document(String title, List<String> blocks) { this.title=title; this.blocks=new ArrayList<>(blocks); }
    public String getTitle(){return title;}
    public List<String> getBlocks(){return Collections.unmodifiableList(blocks);}
    public String content(){ return String.join("\n", blocks); }
}
