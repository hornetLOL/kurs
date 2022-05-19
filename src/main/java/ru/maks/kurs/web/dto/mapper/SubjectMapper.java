package ru.maks.kurs.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.maks.kurs.entity.Subject;
import ru.maks.kurs.web.dto.SubjectDto;

@Mapper
public interface SubjectMapper {

	Subject toSubject(SubjectDto subjectDto);

	SubjectDto toSubjectDto(Subject subject);
}
