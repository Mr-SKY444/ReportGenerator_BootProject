package in.sarvjeet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.openpdf.text.Document;
import org.openpdf.text.Element;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;

import in.sarvjeet.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

public class PdfGenerator {

	public boolean exportPdf(HttpServletResponse response, List<CitizenPlan> citizens, File file) throws Exception {
		
		Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream()); 
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
        Paragraph p1=new Paragraph();
        p1.add(new Paragraph(" "));
        p1.add(new Paragraph("CITIZEN_PLAN REPORT"));
        p1.add(new Paragraph(" "));
        p1.setAlignment(Element.ALIGN_CENTER);
        
        document.add(p1);
        
        PdfPTable tab=new PdfPTable(8);
        
        tab.setWidthPercentage(100);
		tab.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		tab.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        
          tab.addCell("Plan Id");
          tab.addCell("Citizen Name");
          tab.addCell("Gender");
          tab.addCell("Plan Name");
          tab.addCell("Plan Status");
          tab.addCell("Plan Start Date");
          tab.addCell("Plan End Date");
          tab.addCell("Benefit Amount");
          
            for(CitizenPlan citizen : citizens) {
            	tab.addCell(citizen.getCitizenId()+"");
            	tab.addCell(citizen.getCitizenName());
            	tab.addCell(citizen.getCitizenGender());
            	tab.addCell(citizen.getPlanName());
            	tab.addCell(citizen.getPlanStatus());
            	tab.addCell(citizen.getPlanStartDate()+"");
            	tab.addCell(citizen.getPlanEndDate()+"");
            	tab.addCell(citizen.getBenefitAmount()+"");
            }
            
            document.add(tab);
        document.close();
		return true;
	}
}
