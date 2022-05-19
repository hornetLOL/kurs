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
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.Subject;
import ru.maks.kurs.web.dto.StaffDto;

import ru.maks.kurs.web.dto.mapper.StudentMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffService {

    @Transactional
    public StaffDto save(){
        //todo сохранение нового сотрудника
    }
    public void deleteById() {
        //todo удаление сотрудника по id
    }
    @Transactional
    public Staff findById(Long id) {
        //todo поиск по id сотрудника
    }

    @Transactional
    public Staff findByStatus(Long status) {
        //todo поиск по статусу сотрудник (0, 1)
    }

    @Transactional
    public Staff findByNumlb(Long numlb) {
        //todo поиск по номеру трудовой
    }

    @Transactional
    public Staff findByNumpas(Long numpas) {
        //todo поиск по номеру паспорта
    }

}
