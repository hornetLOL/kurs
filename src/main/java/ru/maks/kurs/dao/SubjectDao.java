package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.maks.kurs.entity.Subject;

import java.util.Optional;

public interface SubjectDao extends JpaRepository<Subject, Long>{

    Optional<Subject> findByTitle(String name);
}
