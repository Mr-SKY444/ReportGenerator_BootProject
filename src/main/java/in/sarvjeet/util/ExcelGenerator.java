package in.sarvjeet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import in.sarvjeet.entity.CitizenPlan;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelGenerator {

	public boolean exportExcel(HttpServletResponse response, List<CitizenPlan> citizens, File file) throws Exception{
		

		    Workbook workbook = new HSSFWorkbook();
		    Sheet sheet = workbook.createSheet("CitizenPlan");
		    Row row = sheet.createRow(0);

		    row.createCell(0).setCellValue("Plan Id");
		    row.createCell(1).setCellValue("Citizen Name");
		    row.createCell(2).setCellValue("Gender");
		    row.createCell(3).setCellValue("Plan Name");
		    row.createCell(4).setCellValue("Plan Status");
		    row.createCell(5).setCellValue("Plan Start Date");
		    row.createCell(6).setCellValue("Plan End Date");
		    row.createCell(7).setCellValue("Benefit Amount");
		   

		    int dataRowIndex = 1;

		    for (CitizenPlan citizen : citizens) {
		        Row dataRow = sheet.createRow(dataRowIndex);
		        dataRow.createCell(0).setCellValue(citizen.getCitizenId());
		        dataRow.createCell(1).setCellValue(citizen.getCitizenName());
		        dataRow.createCell(2).setCellValue(citizen.getCitizenGender());
		        dataRow.createCell(3).setCellValue(citizen.getPlanName());
		        dataRow.createCell(4).setCellValue(citizen.getPlanStatus());
		        dataRow.createCell(5).setCellValue(citizen.getPlanEndDate()+"");
		        dataRow.createCell(6).setCellValue(citizen.getPlanEndDate()!=null?citizen.getPlanEndDate()+"" :"N/A");
		        dataRow.createCell(7).setCellValue(citizen.getBenefitAmount()!=null?citizen.getBenefitAmount()+"":"N/A");

		        dataRowIndex++;
		    }


		    FileOutputStream fos= new FileOutputStream(file);
		    workbook.write(fos);
		    fos.close();
		    
		    ServletOutputStream ops = response.getOutputStream();
		    
		    workbook.write(ops);
		    workbook.close();
		    ops.close();
	
		    return true;
	}
}
