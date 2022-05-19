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
@Table(name = "курс_сотруд")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Curse_staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код_прикреп")
    private String id;
    @Column(name = "Код_курс")
    private Long id_curse;
    @Column(name = "Код_сотруд")
    private Long id_staff;
    @Column(name = "Дата_прикреп")
    private String date_att;

}