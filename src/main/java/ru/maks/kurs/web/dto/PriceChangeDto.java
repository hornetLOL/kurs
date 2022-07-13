package ru.maks.kurs.web.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceChangeDto {

	private Long id;

	@NotBlank
	private Long curseId;
	@NotBlank
	private BigDecimal oldPrice;
	@NotBlank
	private LocalDate date;

}
