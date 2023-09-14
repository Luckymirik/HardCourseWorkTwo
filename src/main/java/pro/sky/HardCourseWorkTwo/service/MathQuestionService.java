package pro.sky.HardCourseWorkTwo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.HardCourseWorkTwo.Exception.EmptyArrayException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionAlreadyAddedException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionNotFoundException;
import pro.sky.HardCourseWorkTwo.entity.Question;
import pro.sky.HardCourseWorkTwo.repository.QuestionRepository;

import java.util.*;


@Component("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();
    private final QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        return mathQuestionRepository.add(question);
    }

    public Question remove(Question question){
            return mathQuestionRepository.remove(question);
    }
    public Collection<Question> getAll(){
        return mathQuestionRepository.getAll();
    }

    public Question getRandomQuestion(){
        Question[] arr = mathQuestionRepository.getAll().toArray(new Question[0]);
        if (arr.length==0){
            throw new EmptyArrayException();
        }
        return  arr[random.nextInt(arr.length)];


    }
}
