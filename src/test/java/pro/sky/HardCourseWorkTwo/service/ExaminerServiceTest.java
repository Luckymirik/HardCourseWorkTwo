package pro.sky.HardCourseWorkTwo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HardCourseWorkTwo.Exception.AmountMoreThanRequiredException;
import pro.sky.HardCourseWorkTwo.entity.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @BeforeEach
    public void beforeEach() {
        examinerService = new ExaminerServiceImpl(javaQuestionService,mathQuestionService);
        when(javaQuestionService.getAll()).thenReturn(
                Set.of(
                        new Question("●\t@Component",
                                "Spring определяет этот класс как кандидата для создания bean"),
                        new Question("●\t@Service ",
                                " класс содержит бизнес-логику и вызывает методы на уровне хранилища." +
                                " Ничем не отличается от классов с @Component"),
                        new Question("●\t@Controller ",
                                "указывает, что класс выполняет роль контроллера MVC. " +
                                "Диспетчер сервлетов просматривает такие классы для поиска @RequestMapping")
                )
        );
        when(mathQuestionService.getAll()).thenReturn(
                Set.of(
                        new Question("Какую часть оборота вы прошли," +
                                " если встали лицом на запад и повернулись по часовой стрелке лицом на юг?","¾")
                )
                );
    }



    @Test
    void getQuestion() {
        Assertions.assertThrows(AmountMoreThanRequiredException.class,
                ()->examinerService.getQuestion(5));
    }
    @Test
    void getQuestionPositive() {

        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("●\t@Component",
                        "Spring определяет этот класс как кандидата для создания bean"),
                new Question("●\t@Service ",
                        " класс содержит бизнес-логику и вызывает методы на уровне хранилища." +
                                " Ничем не отличается от классов с @Component"),
                new Question("●\t@Service ",
                        " класс содержит бизнес-логику и вызывает методы на уровне хранилища." +
                                " Ничем не отличается от классов с @Component"),
                new Question("●\t@Controller ",
                        "указывает, что класс выполняет роль контроллера MVC. " +
                                "Диспетчер сервлетов просматривает такие классы для поиска @RequestMapping"),
                new Question("●\t@Component",
                        "Spring определяет этот класс как кандидата для создания bean"),
                new Question("●\t@Service "," класс содержит бизнес-логику и вызывает методы на уровне хранилища." +
                        " Ничем не отличается от классов с @Component"));
        when(mathQuestionService.getRandomQuestion()).thenReturn(
                new Question("Какую часть оборота вы прошли," +
                        " если встали лицом на запад и повернулись по часовой стрелке лицом на юг?","¾")
        );



        Set<Question> questionSet = new HashSet<>();
        questionSet.add(new Question("●\t@Component",
                "Spring определяет этот класс как кандидата для создания bean"));
        questionSet.add(new Question("Какую часть оборота вы прошли," +
                " если встали лицом на запад и повернулись по часовой стрелке лицом на юг?","¾"));
        questionSet.add( new Question("●\t@Service ",
                " класс содержит бизнес-логику и вызывает методы на уровне хранилища." +
                        " Ничем не отличается от классов с @Component"));
        questionSet.add(new Question("●\t@Controller ",
                "указывает, что класс выполняет роль контроллера MVC. " +
                        "Диспетчер сервлетов просматривает такие классы для поиска @RequestMapping"));

        Assertions.assertEquals(questionSet,examinerService.getQuestion(4));
    }
}