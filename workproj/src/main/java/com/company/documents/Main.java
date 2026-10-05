package com.company.documents;

import com.company.documents.builder.*;
import com.company.documents.model.*;
import com.company.documents.flyweight.*;
import com.company.documents.chain.*;
import com.company.documents.interpreter.*;
import com.company.documents.bridge.*;
import com.company.documents.mediator.*;
import java.util.*;

public class Main {
 public static void main(String[] args){
  System.out.println("=== SMART DOCUMENT ENGINE ===");
  System.out.println("=== 1. MEDIATOR ===");
  FormatSelector selector=new FormatSelector(); ToolbarBuilder toolbar=new ToolbarBuilder(); Preview preview=new Preview(); ExportButton exportButton=new ExportButton();
  DocumentEditorMediator mediator=new DocumentEditorMediator(selector,toolbar,preview,exportButton); DocumentBuilder builder=new ExecutiveReportBuilder(); mediator.setBuilder(builder); selector.select("HTML");
  System.out.println("=== 2. BUILDER + FLYWEIGHT ===");
  FlyweightFactory factory=new FlyweightFactory(); CharacterFlyweight c1=factory.get('A',"Arial"); CharacterFlyweight c2=factory.get('A',"Arial");
  builder.addHeader("Financial report 2026").addParagraph("Final price: #{BASE_PRICE * 1.19 - DISCOUNT}").addTable("Item | Value").addFooter("Document processed automatically");
  System.out.println("  Flyweight reused: "+(c1==c2)); System.out.println("  Shared flyweights: "+factory.sharedCount()); System.out.println("  Extrinsic state example: "+c1.draw(20,40,"black",1.0));
  Document document=builder.build();
  System.out.println("=== 3. CHAIN OF RESPONSIBILITY ===");
  Map<String,Double> variables=new HashMap<>();variables.put("BASE_PRICE",100.0);variables.put("DISCOUNT",10.0);
  ProcessorHandler chain=new SyntaxValidator();chain.linkWith(new Sanitizer()).linkWith(new ExpressionEvaluator(variables)); String processedDoc=chain.process(document.content());
  Document processedDocument=new Document(document.getTitle(),List.of(processedDoc)); System.out.println("  Chain completed successfully.");
  System.out.println("=== 4. INTERPRETER ==="); double result=new ExpressionParser("BASE_PRICE*1.19-DISCOUNT",variables).evaluate();System.out.printf(Locale.US,"  Formula: BASE_PRICE * 1.19 - DISCOUNT = %.2f%n",result);
  System.out.println("=== 5. BRIDGE ===");
  PagedDocument pdf=new PagedDocument(processedDocument,new PdfRenderEngine()); PagedDocument html=new PagedDocument(processedDocument,new HtmlRenderEngine());
  System.out.println(pdf.render()); System.out.println(html.render());
  System.out.println("=== 6. MEDIATOR: EXPORT ==="); exportButton.click();
  System.out.println("=== DEMO COMPLETED SUCCESSFULLY ===");
 }
}
