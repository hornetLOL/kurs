package ru.maks.kurs.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "предметы")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Subject {

	@Id
	@Column(name = "Код_пр")
	private Long id;
	@Column(name = "Предмет")
	private String title;

}
