package pro.sky.HardCourseWorkTwo.service;

import pro.sky.HardCourseWorkTwo.entity.Question;

import java.util.Collection;

public interface ExaminerService {
   Collection<Question> getQuestion(int amount);
}
