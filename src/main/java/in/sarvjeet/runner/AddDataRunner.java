package in.sarvjeet.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import in.sarvjeet.entity.CitizenPlan;
import in.sarvjeet.repository.CitizenPlanRepository;
//@Component
public class AddDataRunner implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository citizenRepo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	    List<CitizenPlan> citizens= List.of(
	    		new CitizenPlan("Smith","Male","Cash","Approved",LocalDate.now(),LocalDate.now().plusMonths(6),5000.0),
	    		new CitizenPlan("Raj","Male","Food","Approved",LocalDate.now(),LocalDate.now().plusMonths(6),2000.0),
	    		new CitizenPlan("Virat","Male","Medical","Approved",LocalDate.now(),LocalDate.now().plusMonths(6),10000.0),
	    		new CitizenPlan("Smriti","FeMale","Employment","Approved",LocalDate.now(),LocalDate.now().plusMonths(6),5000.0),
	    		new CitizenPlan("Kajol","FeMale","Cash","Approved",LocalDate.now(),LocalDate.now().plusMonths(6),5000.0),
	    		new CitizenPlan("Rahul","Male","Medical","Denied",LocalDate.now(),LocalDate.now().plusMonths(6),0.0),
	    		new CitizenPlan("Priti","FeMale","Cash","Approved",LocalDate.now(),LocalDate.now().plusMonths(6),5000.0),
	    		new CitizenPlan("Rahul","Male","Food","Denied",LocalDate.now(),LocalDate.now().plusMonths(6),0.0),
	    		new CitizenPlan("Pankaj","Male","Cash","Approved",LocalDate.now(),LocalDate.now().plusMonths(6),5000.0)
	    		);
	    
	    citizenRepo.saveAll(citizens);
	}

}
