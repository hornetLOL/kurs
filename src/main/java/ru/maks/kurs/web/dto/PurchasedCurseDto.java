package ru.maks.kurs.web.dto;

import lombok.*;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Student;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchasedCurseDto {

	private Long id;

	private Curse curse;

	private Student student;

	private LocalDate dateOfBuy;

	private LocalDate dateOfEnd;

}
