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
import ru.maks.kurs.dao.StudentDao;
import ru.maks.kurs.entity.Student;
import ru.maks.kurs.web.dto.StudentDto;
import ru.maks.kurs.web.dto.mapper.StudentMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentDao studentDao;
    private final StudentMapper studentMapper;

//    @Transactional(propagation = Propagation.NEVER, isolation = Isolation.DEFAULT)
//    public long count() {
//        System.out.println(studentDao.count());
//        return studentDao.count();
//    }

    @Transactional
    public StudentDto save(final StudentDto studentDto) {
        Student student;
        try {
            student = studentMapper.toStudent(studentDto);
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

//    public List<Student> findAllActive() {
//        return studentDao.findAllByStatus(Status.ACTIVE);
//    }

    public void deleteById(Long id) {
        try {
            studentDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
        }
    }

//    public void disable(Long id) {
//        Optional<Student> student = studentDao.findById(id);
//        student.ifPresent(p -> {
//            p.setStatus(Status.DISABLED);
//            studentDao.save(p);
//        });
//    }

    public List<Student> findAll(int page, int size) {
        return studentDao.findAll();
    }

//    public List<Student> findAllSortedById() {
//        return studentDao.findAllByStatus(Status.ACTIVE, Sort.by("id"));
//    }
//
//    public List<Student> findAllSortedById(int page, int size) {
//        return studentDao.findAllByStatus(Status.ACTIVE, PageRequest.of(page, size, Sort.by("id")));
//    }

}
