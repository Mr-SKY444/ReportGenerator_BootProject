package in.sarvjeet.entity;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	@Nonnull
	private String citizenName;
	@Nonnull
	private String citizenGender;
	@Nonnull
	private String planName;
	@Nonnull
	private String planStatus;
	@Nonnull
	private LocalDate planStartDate;
	@Nonnull
	private LocalDate planEndDate;
	@Nonnull
	private Double benefitAmount;
	
}
