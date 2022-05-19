package ru.maks.kurs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maks.kurs.entity.Student;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Long> {
	Optional<Student> findByFirstName(String name);
	Optional<Student> findStudentByClassNumber(Integer class_number);
	Optional<Student> findByDateOfContractAfter(String dateOfContract);
	Optional<Student> findByFirstNameAndLastName(String name);


}
