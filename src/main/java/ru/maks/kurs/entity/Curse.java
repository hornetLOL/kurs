package ru.maks.kurs.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

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
	private String targetGrope;
	@Column(name = "Стоимость")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "Код_пр")
	private Subject subject;
}
