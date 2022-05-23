package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maks.kurs.service.SubjectService;
import ru.maks.kurs.service.SubjectService;
import ru.maks.kurs.web.dto.SubjectDto;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {
    
    private final SubjectService subjectService;

    @GetMapping("/all")
    public String getSubjectList(Model model) {
        List<SubjectDto> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        return "subject/subject-list";
    }

    @GetMapping
    public String getSubject(Model model, @RequestParam(name = "id", required = false) Long id) {
        SubjectDto subject;
        if (id != null) {
            subject = subjectService.findById(id);
        } else {
            subject = new SubjectDto();
        }
        model.addAttribute("subject", subject);
        return "subject/subject-list";
    }

    @PostMapping
    public String handlePost(SubjectDto subject) {
        subjectService.save(subject);
        return "redirect:/subject/all";
    }

//    @GetMapping("/delete")
//    public String deleteById(@RequestParam(name = "id") Long id) {
//        subjectService.deleteById(id);
//        return "redirect:/subject/all";
//    }
}
