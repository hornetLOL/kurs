package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Curse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface CurseDao extends JpaRepository<Curse, Long> {

//    Optional<Curse> findBySubject(String title); //todo сделать поиск по сабджекта по слову
    List<Curse> findAllByTargetGroup(String targetGroup);
    Optional<Curse> findByTitle(String title);
    List<Curse> findAllByPriceGreaterThan(BigDecimal price);
    List<Curse> findAllByPriceLessThan(BigDecimal price);
}
