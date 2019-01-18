package com.accenture.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.springmvc.entity.RuleDetailsEntity;
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
    	List<RuleDetailsEntity> listRuleDetails = (List<RuleDetailsEntity>)model.get("ruleDetailsData");
        // Create table with 3 columns of similar length
        Table table = new Table(new float[]{4, 4, 4, 4, 4});
        table.setWidth(UnitValue.createPercentValue(100));
        PdfFont bold = PdfFontFactory.createFont("Times-Bold");
        // adding header
        table.addHeaderCell(new Cell().add(new Paragraph("ruleId").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("Category").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("Coverage").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("Rule Desc").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("Lob Id").setFont(bold)));
        // adding rows
        for(RuleDetailsEntity ruleDetails : listRuleDetails) {
            table.addCell(String.valueOf(ruleDetails.getRuleId()));
            table.addCell(ruleDetails.getCategory());
            table.addCell(ruleDetails.getCoverageAppl());
            table.addCell(ruleDetails.getRuleDesc());
            table.addCell(String.valueOf(ruleDetails.getLobId()));
        }
        
        document.add(table);
    }
}