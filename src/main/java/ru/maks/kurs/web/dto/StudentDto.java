package ru.maks.kurs.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
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
public class StudentDto {

    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String middleName;

    @NotNull
//    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    private Long classNumber;
    @Size(min = 5, message = "phone must be grater than 4 symbols")
    @NotBlank(message = "is required")
    private String phone;
    @Email
    @NotBlank(message = "is required")
    private String email;
    @NotBlank
    private LocalDate dateOfContract;

    Set<CurseDto> curses;
}