package in.sarvjeet.dto;

import lombok.Data;

@Data
public class SearchRequestDTO {

	private String planName;
	private String planStatus;
	private String gender;
	private String planStartDate;
	private String planEndDate;
}
