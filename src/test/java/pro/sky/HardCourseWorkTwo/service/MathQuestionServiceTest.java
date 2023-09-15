package pro.sky.HardCourseWorkTwo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HardCourseWorkTwo.entity.Question;
import pro.sky.HardCourseWorkTwo.repository.MathQuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    private MathQuestionService mathQuestionService;

    @Test
    void add() {
        Question expected = new Question("Что предшествует квадриллиону?",
                "Триллион предшествует квадриллиону");
        Question testQuestion = new Question("Что предшествует квадриллиону?",
                "Триллион предшествует квадриллиону");
        when(mathQuestionRepository.add(testQuestion)).thenReturn(new Question("Что предшествует квадриллиону?",
                "Триллион предшествует квадриллиону"));
        Question actual = mathQuestionService.add(new Question("Что предшествует квадриллиону?",
                "Триллион предшествует квадриллиону"));
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void remove() {
        Question testQuestion = new Question(" Кто изобрел знак равенства '='?","Роберт Рекорд");
        when(mathQuestionRepository.remove(testQuestion)).thenReturn(null);
        Assertions.assertNull(mathQuestionService.remove(new Question(" Кто изобрел знак равенства '='?",
                "Роберт Рекорд")));
    }

    @Test
    void getAll() {
        Assertions.assertNotNull(mathQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Set<Question> testQuestion = new HashSet<>();
        testQuestion.add(new Question("Кто является отцом математики?","Архимед"));
        when(mathQuestionRepository.getAll()).thenReturn(testQuestion);
        Assertions.assertNotNull(mathQuestionService.getRandomQuestion());
    }
}