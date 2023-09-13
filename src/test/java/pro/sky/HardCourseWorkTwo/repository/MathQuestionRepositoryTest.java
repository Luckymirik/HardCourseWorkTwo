package pro.sky.HardCourseWorkTwo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.HardCourseWorkTwo.Exception.QuestionAlreadyAddedException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionNotFoundException;
import pro.sky.HardCourseWorkTwo.entity.Question;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private final MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();
    @BeforeEach
    public void beforeEach(){
        mathQuestionRepository.add("Как еще называют периметр круга?","Окружность");
        mathQuestionRepository.add("Какое самое популярное счастливое число от 1 до 9?","Семь");
        mathQuestionRepository.add("Сколько секунд в одном дне?","86,400 секунд");
    }

    @Test
    void add() {
        Question expected = new Question("Изображение, которое также можно увидеть в трех измерениях?","Голограмма");
        Question actual = mathQuestionRepository.add("Изображение, которое также можно увидеть в трех измерениях?","Голограмма");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testAdd() {
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                ()->mathQuestionRepository.add("Как еще называют периметр круга?","Окружность"));
    }

    @Test
    void remove() {
        Assertions.assertThrows(QuestionNotFoundException.class,
                ()->mathQuestionRepository.remove(new Question("Изображение, " +
                        "которое также можно увидеть в трех измерениях?","Окружность")));
    }

    @Test
    void getAll() {
        Assertions.assertNotNull(mathQuestionRepository.getAll());
    }
}