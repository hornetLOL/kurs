package ru.maks.kurs.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import ru.maks.kurs.dao.CurseDao;
import ru.maks.kurs.dao.StaffDao;
import ru.maks.kurs.dao.StudentDao;
import ru.maks.kurs.dao.SubjectDao;
import ru.maks.kurs.entity.*;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.StudentDto;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = SubjectMapper.class)
public interface CurseMapper {

	Curse toCurse(CurseDto curseDto, @Context StudentDao studentDao);

	CurseDto toCurseDto(Curse curse);

	default Subject getSubject(String subject, @Context SubjectDao subjectDao) {
		return subjectDao.findByTitle(subject).orElseThrow(
				() -> new NoSuchElementException("There isn't subject with name " + subject));
	}

	default String getSubject(Subject subject) {
		return subject.getTitle();
	}

	default Set<Student> studentDtoSetToStudentSet(Set<StudentDto> students, @Context StudentDao studentDao) {
		return students.stream().map(c -> studentDao.findById(c.getId())
						.orElseThrow(
								() -> new NoSuchElementException("There isn't student with id + " + c.getId()))
				)
				.collect(Collectors.toSet());
	}

	default Set<Staff> staffDtoSetToStaffSet(Set<StaffDto> staff, @Context StaffDao staffDao) {
		return staff.stream().map(c -> staffDao.findById(c.getId())
						.orElseThrow(
								() -> new NoSuchElementException("There isn't staff with id + " + c.getId()))
				)
				.collect(Collectors.toSet());
	}
	
}
