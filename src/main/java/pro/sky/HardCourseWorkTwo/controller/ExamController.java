package pro.sky.HardCourseWorkTwo.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.HardCourseWorkTwo.entity.Question;
import pro.sky.HardCourseWorkTwo.service.ExaminerService;
import pro.sky.HardCourseWorkTwo.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class  ExamController {
    private final ExaminerService examinerService;
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount){
        return examinerService.getQuestion(amount);
    }
}
