package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.enums.StaffStatus;

import java.util.List;
import java.util.Optional;


public interface StaffDao extends JpaRepository<Staff, Long>{

    Optional<Staff> findByFirstNameAndMiddleName(String firstName, String middleName);
    Optional<Staff> findByNumlb(Long numlb);
    Optional<Staff> findByNumPass(Long numPass);
    Optional<Staff> findByStatus(StaffStatus status);
    List<Staff> findAllByPost(String post);
    List<Staff> findAllByStatus(StaffStatus status);
}
