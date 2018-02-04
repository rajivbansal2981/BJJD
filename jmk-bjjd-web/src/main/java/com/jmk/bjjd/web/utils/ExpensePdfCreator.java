package com.jmk.bjjd.web.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jmk.bjjd.models.ExpenseModel;
import com.lowagie.text.pdf.PdfCell;

@Component("expensePdfCreator")
public class ExpensePdfCreator implements PdfCreator<ExpenseModel> {
	
		protected Font mainHeadingFont = null;
		
		protected Font subHeadingFont =null;
		
		protected Font normalHeadingFont = null;
		
		protected Font normalFont = null;
		
		protected Font smallFont = null;
	    
	    public ExpensePdfCreator(){
	    	mainHeadingFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	    	subHeadingFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
	    	normalHeadingFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
	    	normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
	    	smallFont = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
	    	subHeadingFont.setStyle(Font.UNDERLINE);
	    }
	   
	

	public void createPdf(String destination, List<ExpenseModel> list) throws FileNotFoundException, DocumentException {
		File file=new File("F:/JAVA/apache-tomcat-8.0.36/bjjd/expense_details/vouchers/voucher.pdf");
		Document document=new Document(PageSize.A4,21f,21f,29f,19f);
		
		PdfWriter.getInstance(document,new FileOutputStream(file));

		document.open();
		
		
		int i=1;
		for (ExpenseModel expense : list) {

			// Header Table
			PdfPTable headerTable = getHeaderTable(expense);
			document.add(headerTable);

			// Detail Table
			PdfPTable detailTable = getDetailTable(expense);
			document.add(detailTable);

			// Footer
			PdfPTable footerTable = getFooterTable(expense);
			document.add(footerTable);
			
			if(i%2==0){
				document.newPage();
			}
			i++;
		}
        
        document.close();
		
	}
	
	protected PdfPTable getHeaderTable(ExpenseModel expenseModel){
		 PdfPTable headerTable=new PdfPTable(2);
	        headerTable.setWidthPercentage(95);
	        headerTable.setSpacingBefore(50f);
	        
	        PdfPCell cashVoucherHeaderCell=new PdfPCell();
	        cashVoucherHeaderCell.setColspan(2);
	        cashVoucherHeaderCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cashVoucherHeaderCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        
	        Paragraph headerParagraph=new Paragraph("BHAVYA JAG JANNI DARBAR JAN KALYAN YUVA VAHINI",mainHeadingFont);
	        headerParagraph.setAlignment(Element.ALIGN_CENTER);
	        Paragraph headerAddress=new Paragraph("B-45, New Ramprastha Vihar, Behta Hazipur, Ghaziabad, U.P., Mob: +919350995745",smallFont);
	        headerAddress.setAlignment(Element.ALIGN_CENTER);
	        
	        cashVoucherHeaderCell.addElement(headerParagraph);
	        cashVoucherHeaderCell.addElement(headerAddress);
	        cashVoucherHeaderCell.setPaddingBottom(7f);
	        cashVoucherHeaderCell.setBorderWidth(2f);
	        
	        headerTable.addCell(cashVoucherHeaderCell);
	       
	        Paragraph cashVoucherParagraph=new Paragraph("CASH VOUCHER",subHeadingFont);
	        cashVoucherParagraph.setAlignment(Element.ALIGN_CENTER);
	        
	        Paragraph cashVoucherNoParagraph=new Paragraph();
	        cashVoucherNoParagraph.setFont(normalFont);
	        cashVoucherNoParagraph.add(new Phrase("Voucher No:",normalHeadingFont));
	        cashVoucherNoParagraph.add(new Phrase(expenseModel.getId()));
	        cashVoucherNoParagraph.setAlignment(Element.ALIGN_RIGHT);
	      
	        PdfPCell cashVocherSubHeaderCell=new PdfPCell();
	        cashVocherSubHeaderCell.setColspan(2);
	        cashVocherSubHeaderCell.setBorder(PdfPCell.NO_BORDER);
	        cashVocherSubHeaderCell.addElement(cashVoucherParagraph);
	        cashVocherSubHeaderCell.addElement(cashVoucherNoParagraph);
	        
	        headerTable.addCell(cashVocherSubHeaderCell);
	        
	       
	        Paragraph payToParagraph=new Paragraph();
	        payToParagraph.setFont(normalFont);
	        payToParagraph.add(new Phrase("Pay to:",normalHeadingFont));
	        payToParagraph.add(new Phrase(expenseModel.getPaidTo()));
	        payToParagraph.setAlignment(Element.ALIGN_LEFT);
	        
	        PdfPCell payToCell=new PdfPCell();
	        payToCell.setBorder(PdfPCell.NO_BORDER);
	        payToCell.addElement(payToParagraph);
	        
	        
	        Paragraph dateParagraph=new Paragraph();
	        dateParagraph.setFont(normalFont);
	        dateParagraph.add(new Phrase("Date:",normalHeadingFont));
	        dateParagraph.add(new Phrase(expenseModel.getDateString()));
	        dateParagraph.setAlignment(Element.ALIGN_RIGHT);
	     
	        PdfPCell dateCell=new PdfPCell();
	        dateCell.setBorder(PdfPCell.NO_BORDER);
	        dateCell.addElement(dateParagraph);
	        	
	        headerTable.addCell(payToCell);
	        headerTable.addCell(dateCell);
	        return headerTable;
	}
	
	protected PdfPTable getDetailTable(ExpenseModel expenseModel) throws DocumentException{
		 	PdfPTable detailTable=new PdfPTable(3);
	        float[] columnWidths = new float[]{19f, 62f,19f};
	        detailTable.setSpacingBefore(7f);
	        detailTable.setWidths(columnWidths);
	        detailTable.setWidthPercentage(95);
	        
	      
	        //Detail Header Row
	        Paragraph dateDetailParagraph=new Paragraph(new Chunk("Date",normalHeadingFont));
	        PdfPCell dateDetailCell=getCell(dateDetailParagraph, PdfCell.ALIGN_CENTER, PdfCell.ALIGN_MIDDLE, BaseColor.LIGHT_GRAY);
	        detailTable.addCell(dateDetailCell);
	        
	        Paragraph particularDetailParagraph=new Paragraph(new Chunk("Particular",normalHeadingFont));
	        PdfPCell particularDetailCell=getCell(particularDetailParagraph, PdfCell.ALIGN_CENTER, PdfCell.ALIGN_MIDDLE, BaseColor.LIGHT_GRAY);
	        detailTable.addCell(particularDetailCell);
	        
	        Paragraph amountDetailParagraph=new Paragraph(new Chunk("Amount",normalHeadingFont));
	        PdfPCell amountDetailCell=getCell(amountDetailParagraph, PdfCell.ALIGN_CENTER, PdfCell.ALIGN_MIDDLE, BaseColor.LIGHT_GRAY);
	        detailTable.addCell(amountDetailCell);
	        
	        
	        //Detail Row
	        Paragraph date=new Paragraph(expenseModel.getDateString(),normalFont);
	        PdfPCell expenseDateCell=getCell(date, PdfCell.ALIGN_CENTER, -1, null);
	        expenseDateCell.setFixedHeight(90f);
	        detailTable.addCell(expenseDateCell);
	        
	        Paragraph particulars=new Paragraph(expenseModel.getDescription(),normalFont);
	        PdfPCell particularsCell=getCell(particulars, PdfCell.ALIGN_LEFT, -1, null);
	        detailTable.addCell(particularsCell);
	        
	        Paragraph amount=new Paragraph(expenseModel.getAmount().toString(),normalFont);
	        PdfPCell amountCell=getCell(amount, PdfCell.ALIGN_RIGHT, -1, null);
	        detailTable.addCell(amountCell);

	        //Detail Footer Row
	        Paragraph totalParagraph=new Paragraph(new Chunk("Total",normalHeadingFont));
	        PdfPCell totalHeaderCell=getCell(totalParagraph, PdfCell.ALIGN_CENTER, PdfCell.ALIGN_MIDDLE, BaseColor.LIGHT_GRAY);
	        totalHeaderCell.setColspan(2);
	        detailTable.addCell(totalHeaderCell);
	        
	        Paragraph totalAmountParagraph=new Paragraph(new Chunk(expenseModel.getAmount().toString(),normalHeadingFont));
	        PdfPCell totalAmountCell=getCell(totalAmountParagraph, PdfCell.ALIGN_RIGHT, PdfCell.ALIGN_MIDDLE, BaseColor.LIGHT_GRAY);
	        detailTable.addCell(totalAmountCell);

	        return detailTable;
	}
	
	protected PdfPTable getFooterTable(ExpenseModel expenseModel){
		PdfPTable footerTable=new PdfPTable(2);
        footerTable.setSpacingBefore(14f);
        footerTable.setWidthPercentage(95);
        
        
        Paragraph receivedByParagraph=new Paragraph();
        receivedByParagraph.setFont(normalFont);
        receivedByParagraph.add(new Phrase("Received By:",normalHeadingFont));
        receivedByParagraph.add(new Phrase(expenseModel.getPaidTo()));
        
        PdfPCell receivedByCell=new PdfPCell();
        receivedByCell.setBorder(PdfPCell.NO_BORDER);
        receivedByCell.addElement(receivedByParagraph);
        
        Paragraph approvedByParagraph=new Paragraph();
        approvedByParagraph.setFont(normalFont);
        approvedByParagraph.add(new Chunk("Approved By:",normalHeadingFont));
        approvedByParagraph.add(new Phrase("...................."));
        approvedByParagraph.setAlignment(Element.ALIGN_RIGHT);
        
        PdfPCell approvedByCell=new PdfPCell();
        approvedByCell.setBorder(PdfPCell.NO_BORDER);
        approvedByCell.addElement(approvedByParagraph);
       
        footerTable.addCell(receivedByCell);
        footerTable.addCell(approvedByCell);
        return footerTable;
	}
	
	protected PdfPCell getCell(Paragraph paragraph,int horizontalAlignment,int verticalAlignment,BaseColor color){
		PdfPCell cell=new PdfPCell(paragraph);
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setVerticalAlignment(verticalAlignment);
		if(color!=null){
			cell.setBackgroundColor(color);
		}
		return cell;
	}

}
