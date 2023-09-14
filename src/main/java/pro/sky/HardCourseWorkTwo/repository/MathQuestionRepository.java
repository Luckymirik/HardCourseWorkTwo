package pro.sky.HardCourseWorkTwo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pro.sky.HardCourseWorkTwo.Exception.QuestionAlreadyAddedException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionNotFoundException;
import pro.sky.HardCourseWorkTwo.entity.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
@Component("mathQuestionRepository")
public class MathQuestionRepository implements QuestionRepository {


    private final Set<Question> mathQuestions = new HashSet<>();
    @PostConstruct
    private void init(){
        Question question = new Question("Остаток от деления",
                "Пример:11 % 5 — такое выражение равно единице, так как остаток единица.");
        mathQuestions.add(question);
         question = new Question("Проценты",
                "Пример: Как найти 120% от числа 200 * 1.2 = 240");
        mathQuestions.add(question);
        question = new Question("Как изучать математику" ,
                "В освоении математики есть два уровня понимания." +
                " Первый уровень — идейный. " +
                "Это осознание того, для чего нужны определенные объекты," +
                        " какая задача решается и где это используется." +
                " Второй уровень понимания — детальный; это подробное изучение подробностей решения задачи. " +
                "Иногда нужно разобраться в задаче на детальном уровня понимания," +
                " но в большинстве случаев — достаточно идейного.");
        mathQuestions.add(question);
        question = new Question("Дискретная математика",
               "Область математики, которая занимается дискретными структурами " +
                       "(например: графами, автоматами, утверждениями в логике). " +
                       "Основное ее отличие от обычной математики, которую вы изучали в школе," +
                       " — ее объекты не могут изменяться так же гладко, как и вещественные числа.");
        mathQuestions.add(question);
        question = new Question("Логика",
                "Это наука о формальных системах и доказательствах. " +
                        "Она лежит в основе компьютерных наук, ведь любой язык программирования" +
                        " — формальная система. " +
                        "Но не нужно заглядывать глубоко в теорию, чтобы найти применение этой науке в написании программ," +
                        " да и вообще в решении задач");
        mathQuestions.add(question);
        question = new Question("Комбинаторика",
                "Комбинаторика изучает разные дискретные множества и отношения их элементов." +
                        " Наиболее часто встречаемая программистами комбинаторная задача — вывести количество элементов, " +
                        "которые необходимо перебрать, чтобы получить решение в зависимости от некоторых параметров." +
                        " Таким образом вы можете вывести асимптотическую сложность алгоритма.");
        mathQuestions.add(question);
        question = new Question("Теория вероятностей",
                "Теория вероятности делится на две части: дискретную и непрерывную." +
                        " Хотя в теории дискретная — это подкласс непрерывной, методы решения задач несколько различаются. " +
                        "Опять же лучше начинать с простого — дискретная теория вероятности часто сводится к комбинаторным задачам." +
                        " И теоретическая часть у дискретной формулируется проще.");
        mathQuestions.add(question);
    }



    @Override
    public Question add(String question, String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        if (!mathQuestions.add(question)){
            throw new QuestionAlreadyAddedException();
        }
        return question;
    }

    public Question remove(Question question){
        if (!mathQuestions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }
    public Collection<Question> getAll(){
        return  Collections.unmodifiableSet(mathQuestions);
    }
}
