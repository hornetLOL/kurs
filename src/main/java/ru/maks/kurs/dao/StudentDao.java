package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Long> {
	List<Student> findAllByFirstName(String name);
	List<Student> findAllByClassNumber(Long classNum);
	Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
	List<Student> findAllByDateOfContractAfter(LocalDate date);
	List<Student> findAllByDateOfContractBefore(LocalDate date);


}
