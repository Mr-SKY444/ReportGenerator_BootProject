package in.sarvjeet.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sarvjeet.dto.SearchRequestDTO;
import in.sarvjeet.entity.CitizenPlan;
import in.sarvjeet.service.ReportService;
import in.sarvjeet.util.EmailUtils;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	@Autowired
	private EmailUtils email;
	
	@GetMapping("/getPdf")
	public void exportPdf(HttpServletResponse response) {
		
		File f=new File("plan.pdf");
		response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=\"plans.pdf\"");
         try {
	    service.exportPdf(response,f);
	    response.flushBuffer();
	    email.sendMail("sk444hyd@gmail.com", "Import message for you", "<h1>Hi Sarvjeet,<br>How are you.</>", f);
         }
         catch(Exception e) {
        	 e.printStackTrace();
         }
         
         f.delete();
	}
	
	@GetMapping("/getExcel")
	public void exportExcel(HttpServletResponse response) {
		
		File f=new File("plan.xls");
		response.setContentType("application/octet-stream");
		 
		  String headerKey = "Content-Disposition";
		  String headerValue = "attachment;filename=plans.xls";

		  response.setHeader(headerKey, headerValue);

		  try {
		  service.exportExcel(response, f);
		  response.flushBuffer();
		  email.sendMail("sk444hyd@gmail.com", "Import message for you", "<h1>Hi Sarvjeet,<br>How are you.</>", f);
	      
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  f.delete();
		 
	}
	@PostMapping("/searchData")
	public String dynamicSearch(@ModelAttribute("search") SearchRequestDTO search, Model model) {
		
		
		List<CitizenPlan> search2 = service.search(search);
	
		model.addAttribute("citizens", search2);
		
		init(model);
		
		return "index";
	}
	@GetMapping("/")
	public String showHomePage(Model model) {
		
		model.addAttribute("search", new SearchRequestDTO());
		
		init(model);
		
		return "index";
	}
	
	public void init(Model model) {
		
		model.addAttribute("plans", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}
}
