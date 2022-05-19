package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Curse;

import java.util.Optional;


public interface CurseDao extends JpaRepository<Curse, Long> {

    Optional<Curse> findBySubject(String title); //todo сделать поиск по сабджекта по слову
    Optional<Curse> findByTargetGrope(String targetGroup);
    Optional<Curse> findByTitle(String title);
}
