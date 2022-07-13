package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;

public interface PurchasedCurseDao extends JpaRepository<PurchasedCurse, Long> {
}
