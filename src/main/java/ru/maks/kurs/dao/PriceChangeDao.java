package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.PriceChange;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;

public interface PriceChangeDao extends JpaRepository<PriceChange, Long> {
}
