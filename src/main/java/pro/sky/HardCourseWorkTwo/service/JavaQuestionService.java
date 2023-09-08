package pro.sky.HardCourseWorkTwo.service;

import org.springframework.stereotype.Service;
import pro.sky.HardCourseWorkTwo.Exception.QuestionAlreadyAddedException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionNotFoundException;
import pro.sky.HardCourseWorkTwo.entity.Question;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        for (Question q:questions){
            if (q.equals(question)){
                throw new QuestionAlreadyAddedException();
            }
        }
        questions.add(question);
        return question;
    }

    public Question remove(Question question){
        if(questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }
    public Collection<Question> getAll(){
        return new HashSet<>(questions);
    }
    public Question getRandomQuestion(){
        if (questions.isEmpty()){
            throw new QuestionNotFoundException();
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));


    }

}
