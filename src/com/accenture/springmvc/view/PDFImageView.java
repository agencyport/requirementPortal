package com.accenture.springmvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

public class PDFImageView extends NetJSAbstractViewPDF {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, 
      PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
       String path = (String)model.get("path");           
       ImageData data = ImageDataFactory.create(path);              
       
       // Creating an Image object        
       Image image = new Image(data);                        
       image.setWidth(525f);
       image.setHeight(525f);
       // Adding image to the document       
       document.add(image);              
       
       // Closing the document       
       document.close();              
       
       System.out.println("Image added");  
    }
}