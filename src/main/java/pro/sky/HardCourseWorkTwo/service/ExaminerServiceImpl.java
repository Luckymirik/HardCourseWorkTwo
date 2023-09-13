package pro.sky.HardCourseWorkTwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.HardCourseWorkTwo.Exception.AmountMoreThanRequiredException;
import pro.sky.HardCourseWorkTwo.entity.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private final QuestionService mathQuestionService;
    public ExaminerServiceImpl(QuestionService questionService,@Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.questionService = questionService;
        this.mathQuestionService = mathQuestionService;
    }
    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> randomQuestion = new HashSet<>();

        if (amount < 0 || amount > questionService.getAll().size()+mathQuestionService.getAll().size()) {
            throw new AmountMoreThanRequiredException();
        }
        Collection<Question> allQuestion = new HashSet<>();
        allQuestion.addAll(questionService.getAll());
        allQuestion.addAll(mathQuestionService.getAll());
        if (amount==questionService.getAll().size()+mathQuestionService.getAll().size()){
            return allQuestion;
        }
        Random random = new Random();
        while (randomQuestion.size() < amount) {
            if(random.nextBoolean()) {
                randomQuestion.add(questionService.getRandomQuestion());
            }else{
                randomQuestion.add(mathQuestionService.getRandomQuestion());
            }
        }
        return Collections.unmodifiableSet(randomQuestion);
    }
}
