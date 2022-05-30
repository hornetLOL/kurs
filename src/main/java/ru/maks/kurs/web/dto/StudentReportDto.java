package ru.maks.kurs.web.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentReportDto {

	private String namesConcatenated;
	private String curseName;
	private BigDecimal cursePrice;
}
