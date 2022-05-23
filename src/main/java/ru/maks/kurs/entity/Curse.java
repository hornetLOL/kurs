package ru.maks.kurs.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.maks.kurs.entity.relationTables.CurseStaff;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "учебные_курсы")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Curse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Код_курс")
	private Long id;
	@Column(name = "Название")
	private String title;
	@Column(name = "Целевая_аудитория")
	private String targetGroup;
	@Column(name = "Стоимость")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "Код_пр")
	private Subject subject;

	@OneToMany(mappedBy = "curse")
	Set<PurchasedCurse> studentsAtCurse;

	@OneToMany(mappedBy = "curse")
	Set<CurseStaff> staffOnCurse;
}
