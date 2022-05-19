package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Student;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Long> {
	Optional<Student> findByFirstName(String name);
	Optional<Student> findByClassNumber(Long class_number);
	Optional<Student> findByDateOfContract(String dateOfContract);
	Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
	Optional<Student> findByPurchasedCurses(String curseName); //todo


}
