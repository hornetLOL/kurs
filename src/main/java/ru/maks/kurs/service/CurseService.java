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
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.Student;
import ru.maks.kurs.entity.Subject;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.StudentDto;
import ru.maks.kurs.web.dto.mapper.StudentMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class CurseService {


    @Transactional
    public CurseDto save(){
        //todo сохранение нового курса
    }
    public void deleteById() {
        //todo удаление курса по id
    }
    @Transactional
    public Curse findById(Long id) {
        //todo поиск по id курса
    }

    @Transactional
    public Curse findByTitle(String title) {
        //todo поиск по названию курса
    }

    @Transactional
    public Curse findBytargetGroup(String tragetGroup) {
        //todo поиск по номеру трудовой
    }

    @Transactional
    public Curse findByPrice(Long price) {
        //todo поиск по цене, которая больше\меньше заданной
    }
}
