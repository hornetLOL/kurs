package ru.maks.kurs.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ученики")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Student {

	@Id
	@Column(name = "Код_уч")
	private Long id;
	@Column(name = "имя")
	private String firstName;
	@Column(name = "фамилия")
	private String lastName;
	@Column(name = "отчество")
	private String middleName;
	@Column(name = "Номер_класса")
	private Long classNumber;
	@Column(name = "Номер_тлф")
	private String phone;
	@Column(name = "Электронная_почта")
	private String email;
	@Column(name = "Дата_Контр")
	private LocalDate dateOfContract;

	@OneToMany(mappedBy = "student")
	private Set<PurchasedCurse> curses;

	public PurchasedCurse addCurse(Curse curse){
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date nextYear = cal.getTime();
		PurchasedCurse pc = PurchasedCurse.builder()
				.id(ThreadLocalRandom.current().nextLong(100000, 999999))
				.curse(curse)
				.student(this)
				.dateOfBuy(today.toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate())
				.dateOfEnd(nextYear.toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate())
				.build();
		if(curses == null)
			curses = new HashSet<>();
		curses.add(pc);
		return pc;
	}

//	@ManyToOne
//	@JoinTable(name = "купл_курс",
//			joinColumns = @JoinColumn(name = "код_уч"),
//			inverseJoinColumns = @JoinColumn(name = "код_курс"))
//	private Curse curse;


}
