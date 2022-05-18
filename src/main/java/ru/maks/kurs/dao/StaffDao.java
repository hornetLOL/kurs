package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Staff;

import java.util.Optional;


public interface StaffDao extends JpaRepository<Staff, Long>{

    Optional<Staff> findStaffByFirstNameAndMiddleName(String name);
    Optional<Staff> findStaffById(Long id);
    Optional<Staff> findStaffByNumlb(Long numlb);
    Optional<Staff> findStaffByStatusTrue(Long status);
}
