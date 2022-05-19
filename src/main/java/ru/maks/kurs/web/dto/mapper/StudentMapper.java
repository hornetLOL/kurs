package ru.maks.kurs.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import ru.maks.kurs.dao.CurseDao;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Student;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.StudentDto;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = CurseMapper.class)
public interface StudentMapper {
    Student toStudent(StudentDto studentDto, @Context CurseDao curseDao);

    StudentDto toStudentDto(Student student);

    default Curse getCurse(String curse, @Context CurseDao curseDao) {
        return curseDao.findByTitle(curse).orElseThrow(
                () -> new NoSuchElementException("There isn't manufacturer with name " + curse));
    }

    default String getCurse(Curse curse) {
        return curse.getTitle();
    }

    default Set<Curse> curseDtoSetToCurseSet(Set<CurseDto> curses, @Context CurseDao curseDao) {
        return curses.stream().map(c -> curseDao.findById(c.getId())
                        .orElseThrow(
                                () -> new NoSuchElementException("There isn't curse with id + " + c.getId()))
                )
                .collect(Collectors.toSet());
    }

}