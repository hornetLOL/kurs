package ru.maks.kurs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.maks.kurs.dao.StudentDao;
import ru.maks.kurs.entity.Student;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;
import ru.maks.kurs.web.dto.StudentReportDto;
import ru.maks.kurs.web.dto.mapper.StudentMapper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

	private final StudentDao studentDao;

	public List<StudentReportDto> getStudentFromLastYear() {
		LocalDate yearBefore = LocalDate.of(LocalDate.now().getYear()-1,
			LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
		List<Student> students = studentDao.findAllByDateOfContractAfter(yearBefore);
		return students.stream().map(s -> StudentReportDto.builder()
				.namesConcatenated(s.getFirstName() + " " + s.getLastName())
				.curseName(s.getCurses().stream().max(Comparator.comparing(PurchasedCurse::getDateOfBuy))
						.map(c-> c.getCurse().getTitle()).orElse(null))
				.cursePrice(s.getCurses().stream().max(Comparator.comparing(PurchasedCurse::getDateOfBuy))
						.map(c-> c.getCurse().getPrice()).orElse(null))
				.build()).collect(Collectors.toList());

	}
}
