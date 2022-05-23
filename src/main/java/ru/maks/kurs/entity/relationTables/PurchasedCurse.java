package ru.maks.kurs.entity.relationTables;

import lombok.*;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Student;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "купл_курс")
@Entity
public class PurchasedCurse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Код_чека")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "Код_курс")
	private Curse curse;

	@ManyToOne
	@JoinColumn(name = "Код_уч")
	private Student student;

	@Column(name = "Дата_покупки")
	private LocalDate dateOfBuy;

	@Column(name = "Дата_оконч")
	private LocalDate dateOfEnd;
}
