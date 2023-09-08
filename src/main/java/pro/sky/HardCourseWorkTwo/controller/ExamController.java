package pro.sky.HardCourseWorkTwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HardCourseWorkTwo.entity.Question;
import pro.sky.HardCourseWorkTwo.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping
    public Collection<Question> getQuestion(@RequestParam int amount){
        return examinerService.getQuestion(amount);
    }
}
