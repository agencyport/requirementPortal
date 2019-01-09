
package com.accenture.springmvc.cc;


import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.accenture.springmvc.entity.ExcelData;


public class XMLWriterDOM {

    public static void write(List<ExcelData> list) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                doc.createElement("Rules");
            //append root element to document
            doc.appendChild(rootElement);
 // add all nodes
            for(ExcelData data :list){
            //append first child element to root element
            rootElement.appendChild(getRule(doc,data.getCategory(),data.getCoverage(),data.getDescription()));
            }
            
           
           
           

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("rules.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    
    private static Node getRule(Document doc, String category, String coverage ,String desc) {
        Element employee = doc.createElement("Rule");

        //create name element
        employee.appendChild(getRuleElements(doc, employee, "Category", category));

        //create gender element
        employee.appendChild(getRuleElements(doc, employee, "Coverage", coverage));
        
        employee.appendChild(getRuleElements(doc, employee, "Desc", desc));

        return employee;
    }


    //utility method to create text node
    private static Node getRuleElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
