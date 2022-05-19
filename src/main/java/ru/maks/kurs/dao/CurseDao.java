package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Curse;

import java.util.Optional;


public interface CurseDao extends JpaRepository<Curse, Long> {

    Optional<Curse> findCurseBySubject(String title);
    Optional<Curse> findCurseByTargetGrope(String targetGroup);
    Optional<Curse> findCurseByTitle(String title);
}
