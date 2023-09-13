package pro.sky.HardCourseWorkTwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.HardCourseWorkTwo.Exception.QuestionAlreadyAddedException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionNotFoundException;
import pro.sky.HardCourseWorkTwo.entity.Question;
import pro.sky.HardCourseWorkTwo.repository.QuestionRepository;

import java.util.*;

@Service
@Primary

public class JavaQuestionService implements QuestionService{


    private final Random random = new Random();
    private final QuestionRepository javaQuestionRepository;

    public JavaQuestionService(QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }
    @Override
    public Question add(String question, String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        return javaQuestionRepository.add(question);
    }

    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }
    public Collection<Question> getAll(){
        return javaQuestionRepository.getAll();
    }


    public Question getRandomQuestion(){
        Question[] arr = javaQuestionRepository.getAll().toArray(new Question[0]);
        return arr[random.nextInt(arr.length)];


    }


}
