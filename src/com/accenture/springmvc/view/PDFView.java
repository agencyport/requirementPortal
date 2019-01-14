package com.accenture.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.springmvc.entity.LobData;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class PDFView extends NetJSAbstractViewPDF {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, 
      PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // List of users that will be displayed in the PDF
        List<LobData> lobDatas = (List<LobData>)model.get("excelData");
        // Create table with 3 columns of similar length
        Table table = new Table(new float[]{4, 4, 4});
        table.setWidth(UnitValue.createPercentValue(100));
        PdfFont bold = PdfFontFactory.createFont("Times-Bold");
        // adding header
        table.addHeaderCell(new Cell().add(new Paragraph("dataId").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("data").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("lobReferenceId").setFont(bold)));
        // adding rows
        for(LobData data : lobDatas) {
            table.addCell(String.valueOf(data.getDataId()));
            table.addCell(data.getData());
            table.addCell(String.valueOf(data.getLobReferenceId()));
        }
        
        document.add(table);
    }
}