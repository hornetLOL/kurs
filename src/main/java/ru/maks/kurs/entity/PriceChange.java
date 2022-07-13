package ru.maks.kurs.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "изм_цены")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class PriceChange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "Код_курс")
	private Long curseId;
	@Column(name = "Ст_цена")
	private BigDecimal oldPrice;
	@Column(name = "Дата_изм")
	private LocalDate date;

}
