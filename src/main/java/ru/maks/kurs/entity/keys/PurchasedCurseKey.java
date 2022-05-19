package ru.maks.kurs.entity.keys;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
@Table(name = "купл_курс")
public class PurchasedCurseKey implements Serializable {

	@Column(name = "код_уч")
	Long studId;

	@Column(name = "код_курс")
	Long curseId;
}
