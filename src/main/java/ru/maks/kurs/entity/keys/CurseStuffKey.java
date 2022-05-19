package ru.maks.kurs.entity.keys;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "курс_сотруд")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
public class CurseStuffKey implements Serializable {

	@Column(name = "Код_курс")
	Long curseId;

	@Column(name = "Код_сотруд")
	Long staffId;
}
