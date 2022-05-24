package ru.maks.kurs.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.maks.kurs.entity.enums.StaffStatus;
import ru.maks.kurs.entity.relationTables.CurseStaff;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "сотрудники")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Staff {
    @Id
    @Column(name = "Код_сотруд")
    private Long id;

    @Column(name = "Фамилия")
    private String lastName;

    @Column(name = "Имя")
    private String firstName;

    @Column(name = "Отчество")
    private String middleName;

    @Column(name = "Должность")
    private String post;

    @Column(name = "Номер_тр_книги")
    private Long numlb;

    @Column(name = "Паспортные_данные")
    private Long numPass;

    @Enumerated(EnumType.STRING)
    @Column(name = "Статус")
    private StaffStatus status;

    @OneToMany(mappedBy = "staff")
    Set<CurseStaff> curses;
}
