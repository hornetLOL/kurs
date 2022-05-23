package ru.maks.kurs.web.dto;

import lombok.*;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Staff;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurseStaffDto {

	private Long id;

	private Curse curse;

	private Staff staff;

	private LocalDate dateOfAttach;

}
