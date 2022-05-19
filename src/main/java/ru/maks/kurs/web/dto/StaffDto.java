package ru.maks.kurs.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import ru.maks.kurs.entity.enums.StaffStatus;

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
public class StaffDto {

    private Long id;

    @NotBlank
    private String lastName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String middleName;
    @NotBlank
    private String post;

    @Size(min = 7, message = "Number must be grater 6 symbols")
    @NotBlank(message = "is required")
    private Long numlb;
    @Size(min = 10, message = "Number must be grater 9 symbols")
    @NotBlank(message = "is required")
    private Long numpas;

    @NotBlank
    private StaffStatus status;


}
