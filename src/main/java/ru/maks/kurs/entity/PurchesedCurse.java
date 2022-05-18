package ru.maks.kurs.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.maks.kurs.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "купл_курс")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class PurchesedCurse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Код_уч")
	private Long id;
	@Column(name = "код_курс")
	private Long id_curse;
	@Column(name = "дата_покупки")
	private String Date_Prsch;
	@Column(name = "дата_оконч")
	private String Date_End;

}
