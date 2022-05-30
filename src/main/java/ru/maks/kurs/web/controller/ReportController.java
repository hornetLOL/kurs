package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maks.kurs.service.ReportService;
import ru.maks.kurs.web.dto.StudentReportDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

	private final ReportService reportService;

	@GetMapping
	public String createReport(Model model){
		List<StudentReportDto> students = reportService.getStudentFromLastYear();
		model.addAttribute("students", students);
		model.addAttribute("totalPrice", students.stream()
				.mapToDouble(s -> s.getCursePrice() != null ? s.getCursePrice().doubleValue() : 0).sum());
		return "report";
	}
}
