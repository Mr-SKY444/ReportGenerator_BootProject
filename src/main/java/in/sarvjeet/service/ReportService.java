package in.sarvjeet.service;

import java.io.File;
import java.util.List;

import in.sarvjeet.dto.SearchRequestDTO;
import in.sarvjeet.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequestDTO request);
	
	public boolean exportPdf(HttpServletResponse response, File file) throws Exception;
	
	public boolean exportExcel(HttpServletResponse response, File file) throws Exception;
	
}
