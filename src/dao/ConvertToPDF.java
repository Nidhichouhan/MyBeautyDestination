package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import utility.ConnectionManager;
import java.io.*;
import java.util.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import utility.*;
import java.sql.*; 


public class ConvertToPDF {
	public static void billPdf(HashMap<String,Double> itemReference,HashMap<String,Double> prices,String username,double finalprice) throws FileNotFoundException, DocumentException{
		PdfPCell pdfcell ;
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
		
		PdfPTable pdftable2 = new PdfPTable(1);
		
		pdftable2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		pdfcell = new PdfPCell(new Phrase("MY BEAUTY DESTINATION",boldFont));
		pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		pdftable2.addCell(pdfcell);
		pdfcell = new PdfPCell(new Phrase("\tORDER DETAILS FOR : "+username.toUpperCase()));
		pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		pdftable2.addCell(pdfcell);
		PdfPTable pdftable = new PdfPTable(3);
		pdftable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		pdftable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
	    pdftable.getDefaultCell().setFixedHeight(70);
	    
		pdfcell = new PdfPCell(new Phrase("Product Name"));
		pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
	    pdftable.addCell(pdfcell);
	    pdfcell = new PdfPCell(new Phrase("Quantity"));
	    pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
	    pdftable.addCell(pdfcell);
		pdfcell = new PdfPCell(new Phrase("Price ( in Rupees )"));
		pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		pdftable.addCell(pdfcell);
		PdfPTable pdftable3 = new PdfPTable(2);
		
		pdftable3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		pdfcell = new PdfPCell(new Phrase("Final Price "));
		pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		pdftable3.addCell(pdfcell);
		pdfcell = new PdfPCell(new Phrase(Double.toString(finalprice)));
		pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pdftable3.addCell(pdfcell);
		
		for(String itemName : itemReference.keySet()) 
		{
			pdfcell=new PdfPCell(new Phrase(itemName));
			pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdftable.addCell(pdfcell);
			pdfcell = new PdfPCell(new Phrase(itemReference.get(itemName).toString()));
			pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	
			pdftable.addCell(pdfcell);
			pdftable.addCell(new PdfPCell(new Phrase(prices.get(itemName).toString())));
		}
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\HP\\eclipse-workspace\\THE_BEAUTY_DESTINATION\\PdfFile\\BillPDF1.pdf"));
		document.open();
		
		document.add(pdftable2);
		document.add(pdftable);
		document.add(pdftable3);
		document.close();
		System.out.println("PDF Generated Successfully");
	
		}
}


