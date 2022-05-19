package ru.maks.kurs.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import ru.maks.kurs.entity.Subject;
import ru.maks.kurs.entity.relationTables.CurseStaff;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurseDto {

    private Long id;

    @NotBlank
    private String title;
    @NotBlank
    private String targetGroup;
    @NotBlank
    private BigDecimal price;

    @NotBlank
    private Subject subject;

    Set<PurchasedCurse> studentsAtCurse;
    Set<CurseStaff> staffOnCurse;
}
