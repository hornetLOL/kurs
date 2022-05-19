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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectService {

    @Transactional
    public SubjectDto save(){
        //todo сохранение нового предмета
    }
    public void deleteById() {
        //todo удаление предмета по id
    }
    @Transactional
    public Subject findById(Long id) {
        //todo поиск по id предмета
    }
}
