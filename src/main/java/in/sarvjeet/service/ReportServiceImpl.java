package in.sarvjeet.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.sarvjeet.dto.SearchRequestDTO;
import in.sarvjeet.entity.CitizenPlan;
import in.sarvjeet.repository.CitizenPlanRepository;
import in.sarvjeet.util.ExcelGenerator;
import in.sarvjeet.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	private CitizenPlanRepository citizenRepo;

	@Autowired
	public void setCitizenPlanRepoistory(CitizenPlanRepository citizenRepo) {
		this.citizenRepo=citizenRepo;
	}
	
	@Override
	public List<String> getPlanNames() {

		return citizenRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {

		return citizenRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequestDTO request) {

		CitizenPlan citizen = new CitizenPlan();

		if (request.getPlanName() != null && !request.getPlanName().isBlank()) {
			citizen.setPlanName(request.getPlanName());
		}

		if (request.getPlanStatus() != null && !request.getPlanStatus().isBlank()) {
			citizen.setPlanStatus(request.getPlanStatus());
		}

		if (request.getGender() != null && !request.getGender().isBlank()) {
			citizen.setCitizenGender(request.getGender());
		}

		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		if (request.getPlanStartDate() != null && !request.getPlanStartDate().isBlank()) {
		LocalDate planStartDate=LocalDate.parse(request.getPlanStartDate(),formatter);
		citizen.setPlanStartDate(planStartDate);
		}

		if (request.getPlanEndDate() != null && !request.getPlanEndDate().isBlank()) {
           LocalDate planEndDate = LocalDate.parse(request.getPlanEndDate(),formatter);
           citizen.setPlanEndDate(planEndDate);
		}
		
		   Example<CitizenPlan> citizenExample = Example.of(citizen);
		   
		return citizenRepo.findAll(citizenExample);
	}

	@Override
	public boolean exportExcel(HttpServletResponse response, File file) throws Exception {
		
		return new ExcelGenerator().exportExcel(response, citizenRepo.findAll(), file);
	}
	@Override
	public boolean exportPdf(HttpServletResponse response, File file) throws Exception {
		
		
		return new PdfGenerator().exportPdf(response, citizenRepo.findAll(), file);
	}
}
