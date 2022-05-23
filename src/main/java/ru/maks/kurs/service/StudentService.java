package ru.maks.kurs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.maks.kurs.dao.CurseDao;
import ru.maks.kurs.dao.StudentDao;
import ru.maks.kurs.entity.Student;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.PurchasedCurseDto;
import ru.maks.kurs.web.dto.StudentDto;
import ru.maks.kurs.web.dto.mapper.StudentMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentDao studentDao;
    private final StudentMapper studentMapper;
    private final CurseDao curseDao;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//    @Transactional(propagation = Propagation.NEVER, isolation = Isolation.DEFAULT)
//    public long count() {
//        System.out.println(studentDao.count());
//        return studentDao.count();
//    }

    @Transactional
    public StudentDto save(final StudentDto studentDto) {
        Student student;
        try {
            student = studentMapper.toStudent(studentDto, curseDao);
//            if (student.getId() != null) {
//                studentDao.findById(studentDto.getId()).ifPresent(
//                        (p) -> student.setVersion(p.getVersion())
//                );
//            }
            return studentMapper.toStudentDto(studentDao.save(student));
        }catch (NoSuchElementException e){
            return null;
        }
    }


    @Transactional(readOnly = true)
    public StudentDto findById(Long id) {
        return studentMapper.toStudentDto((studentDao.findById(id).orElse(null)));
    }


    public List<StudentDto> findAll() {
        return studentDao.findAll().stream().map(studentMapper::toStudentDto).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        try {
            studentDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
        }
    }

    public List<StudentDto> findAllByClassNumber(Long classNum){
        return studentDao.findAllByClassNumber(classNum)
                .stream().map(studentMapper::toStudentDto).collect(Collectors.toList());
    }

    public List<StudentDto> findAllByCurseName(String curseName) {
        List<StudentDto> students = findAll();
        List<StudentDto> studentCurse = new ArrayList<>();
        for(StudentDto student : students){
            for(PurchasedCurseDto purchasedCurse : student.getCurses())
                if(purchasedCurse.getCurse().getTitle().equals(curseName))
                    studentCurse.add(student);
        }
        return studentCurse;
    }

    public List<StudentDto> findAllBeforeDate(String dateBefore) {
        //convert String to LocalDate
        LocalDate date = LocalDate.parse(dateBefore, formatter);
        return studentDao.findAllByDateOfContractBefore(date)
                .stream().map(studentMapper::toStudentDto).collect(Collectors.toList());
    }

    public List<StudentDto> findAllAfterDate(String dateAfter) {
        LocalDate date = LocalDate.parse(dateAfter, formatter);
        return studentDao.findAllByDateOfContractAfter(date)
                .stream().map(studentMapper::toStudentDto).collect(Collectors.toList());
    }

}
