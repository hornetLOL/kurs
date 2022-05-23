package ru.maks.kurs.entity.relationTables;


import lombok.*;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Staff;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "курс_сотруд")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CurseStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Код_прикреп")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "Код_курс")
	private Curse curse;

	@ManyToOne
	@JoinColumn(name = "Код_сотруд")
	private Staff staff;

	@Column(name = "Дата_прикреп")
	private LocalDate dateOfAttach;
}
