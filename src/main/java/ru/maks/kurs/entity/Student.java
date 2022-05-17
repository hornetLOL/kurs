package ru.maks.kurs.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.maks.kurs.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ученики")
@EntityListeners(AuditingEntityListener.class)
public class Student extends BaseEntity {


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
	private String dateOfContract;
}
