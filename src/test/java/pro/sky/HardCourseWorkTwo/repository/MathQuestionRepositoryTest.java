package pro.sky.HardCourseWorkTwo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.HardCourseWorkTwo.Exception.QuestionAlreadyAddedException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionNotFoundException;
import pro.sky.HardCourseWorkTwo.entity.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private  MathQuestionRepository mathQuestionRepositoryTest ;
    @BeforeEach
    public void beforeEach(){
        mathQuestionRepositoryTest.add("Как еще называют периметр круга?","Окружность");
        mathQuestionRepositoryTest.add("Какое самое популярное счастливое число от 1 до 9?","Семь");
        mathQuestionRepositoryTest.add("Сколько секунд в одном дне?","86,400 секунд");
    }

    @Test
    void add() {
        Question expected = new Question("Изображение, которое также можно увидеть в трех измерениях?","Голограмма");
        Question actual = mathQuestionRepositoryTest.add("Изображение, которое также можно увидеть в трех измерениях?","Голограмма");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testAdd() {
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                ()->mathQuestionRepositoryTest.add("Как еще называют периметр круга?","Окружность"));
    }

    @Test
    void remove() {

        Assertions.assertThrows(QuestionNotFoundException.class,
                ()->mathQuestionRepositoryTest.remove(new Question("Изображение, " +
                        "которое также можно увидеть в трех измерениях?","Окружность")));
    }

    @Test
    void getAll() {
        Set<Question> testQuestion = new HashSet<>();
        testQuestion.add(new Question("Как еще называют периметр круга?","Окружность"));
        testQuestion.add(new Question("Какое самое популярное счастливое число от 1 до 9?","Семь"));
        testQuestion.add(new Question("Сколько секунд в одном дне?","86,400 секунд"));
        Assertions.assertEquals(testQuestion,mathQuestionRepositoryTest.getAll());


    }
}