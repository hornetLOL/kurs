package ru.maks.kurs.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "предметы")
@EntityListeners(AuditingEntityListener.class)
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Код_пр")
	private Long id;
	@Column(name = "Предмет")
	private String title;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.MERGE)
	private Set<Curse> products;

	@Builder
	public Subject(Long id, String title, Set<Curse> products){
		this.id = id;
		this.products = products;
		this.title = title;
	}
}
