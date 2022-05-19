package ru.maks.kurs.entity.relationTables;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Student;
import ru.maks.kurs.entity.keys.PurchasedCurseKey;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "купл_курс")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class PurchasedCurse {

	/**
	 Опять же, хз нужны ли нам ид курса и ученика, я думаю надо чутка по другому сущсности строить, буду думать как
	 **/

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "Код_чека")
//	private Long id;
//	@Column(name = "код_курс")
//	private Long id_curse;
//	@Column(name = "код_уч")
//	private Long id_stud;

	@EmbeddedId
	private PurchasedCurseKey id;

	@ManyToOne
	@MapsId("studId")
	@JoinColumn(name = "код_уч")
	private Student student;

	@ManyToOne
	@MapsId("curseId")
	@JoinColumn(name = "код_курс")
	private Curse curse;

	@Column(name = "дата_покупки")
	private String dateOfPurchase;
	@Column(name = "дата_оконч")
	private String dateOfEnd;

}
