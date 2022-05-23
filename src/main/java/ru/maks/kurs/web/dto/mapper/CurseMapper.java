package ru.maks.kurs.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.maks.kurs.dao.*;
import ru.maks.kurs.entity.*;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.relationTables.CurseStaff;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.StudentDto;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper()
public interface CurseMapper {

//	@Mapping(source = "studentsAtCurse.getStudentDto", target = "student.firstName")
	Curse toCurse(CurseDto curseDto, @Context SubjectDao subjectDao, @Context StudentDao studentDao, @Context StaffDao staffDao);

	CurseDto toCurseDto(Curse curse);

//	default Subject getSubject(String subject, @Context SubjectDao subjectDao) {
//		return subjectDao.findByTitle(subject).orElseThrow(
//				() -> new NoSuchElementException("There isn't subject with name " + subject));
//	}
//
//	default String getSubject(Subject subject) {
//		return subject.getTitle();
//	}

	//Set<PurchasedCurse> studentDtoSetToPurchasedCurseSet
//	default Set<Student> studentDtoSetToPurchasedCurseSet(Set<StudentDto> students, @Context StudentDao studentDao) {
//		return students.stream().map(c -> studentDao.findById(c.getId())
//						.orElseThrow(
//								() -> new NoSuchElementException("There isn't student with id + " + c.getId()))
//				)
//				.collect(Collectors.toSet());
//	}

//	default Set<CurseStaff> staffDtoSetToCurseStaffSet(Set<StaffDto> staff, CurseDto curseDto, @Context StaffDao staffDao, @Context CurseDao curseDao) {
//		return staff.stream().map(c -> curseStaffDao.findByCurseAndStaff(curseDao.getById(curseDto.getId()),  staffDao.findById(c.getId()).orElse(null))
//						.orElseThrow(
//								() -> new NoSuchElementException("There isn't staff with id + " + c.getId()))
//				)
//				.collect(Collectors.toSet());
//	}

}
