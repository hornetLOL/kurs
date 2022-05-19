package ru.maks.kurs.entity.relationTables;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.keys.CurseStuffKey;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "курс_сотруд")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class CurseStaff {
    /**
     Еще хз нужны ли на в принципе ид_курса и сотрудника, тк они будут добавлены
     в энтити курса и сотрудника соответственно
     (собсна вроде как так, но надо тестировать)
     **/
    @EmbeddedId
    private CurseStuffKey id;
    @ManyToOne
    @MapsId("curseId")
    @JoinColumn(name = "Код_курс")
    private Curse curse;

    @ManyToOne
    @MapsId("staffId")
    @JoinColumn(name = "Код_сотруд")
    private Staff staff;

    @Column(name = "Дата_прикреп")
    private String date_att;

}