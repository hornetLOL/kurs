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
import ru.maks.kurs.dao.SubjectDao;
import ru.maks.kurs.entity.Subject;
import ru.maks.kurs.web.dto.SubjectDto;
import ru.maks.kurs.web.dto.mapper.StudentMapper;
import ru.maks.kurs.web.dto.mapper.SubjectMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectService {

    private final SubjectDao subjectDao;
    private final SubjectMapper subjectMapper;

    @Transactional
    public SubjectDto save(final SubjectDto subjectDto){
        Subject subject;
        try {
            subject = subjectMapper.toSubject(subjectDto);
//            if (subject.getId() != null) {
//                subjectDao.findById(subjectDto.getId()).ifPresent(
//                        (p) -> subject.setVersion(p.getVersion())
//                );
//            }
            return subjectMapper.toSubjectDto(subjectDao.save(subject));
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public void deleteById() {
        //todo удаление предмета по id
    }
    @Transactional(readOnly = true)
    public SubjectDto findById(Long id) {
        return subjectMapper.toSubjectDto((subjectDao.findById(id).orElse(null)));
    }

    public List<SubjectDto> findAll() {
        return subjectDao.findAll().stream().map(subjectMapper::toSubjectDto).collect(Collectors.toList());
    }
}
