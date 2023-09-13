package pro.sky.HardCourseWorkTwo.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HardCourseWorkTwo.Exception.QuestionAlreadyAddedException;
import pro.sky.HardCourseWorkTwo.Exception.QuestionNotFoundException;
import pro.sky.HardCourseWorkTwo.entity.Question;
import pro.sky.HardCourseWorkTwo.repository.JavaQuestionRepository;
import pro.sky.HardCourseWorkTwo.repository.QuestionRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {
//    Set<Question> myQuestion;

    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionService javaQuestionService;


    @Test
    void add() {
        Question expected = new Question("Bean Factory", "BeanFactory - это фактический контейнер, " +
                "который создает, настраивает и управляет рядом bean-компонентов. " +
                "Эти бины обычно взаимодействуют друг с другом и, таким образом, имеют зависимости между собой. " +
                "Эти зависимости отражены в данных конфигурации, используемых BeanFactory. " +
                "BeanFactory обычно используется тогда, когда ресурсы ограничены (мобильные устройства)" +
                ". Поэтому, если ресурсы не сильно ограничены, то лучше использовать ApplicationContext.");
        Question testQuestion = new Question("Bean Factory", "BeanFactory - это фактический контейнер, " +
                "который создает, настраивает и управляет рядом bean-компонентов. " +
                "Эти бины обычно взаимодействуют друг с другом и, таким образом, имеют зависимости между собой. " +
                "Эти зависимости отражены в данных конфигурации, используемых BeanFactory. " +
                "BeanFactory обычно используется тогда, когда ресурсы ограничены (мобильные устройства)" +
                ". Поэтому, если ресурсы не сильно ограничены, то лучше использовать ApplicationContext.");
        when(javaQuestionRepository.add(testQuestion)).
                thenReturn(new Question("Bean Factory", "BeanFactory - это фактический контейнер, " +
                        "который создает, настраивает и управляет рядом bean-компонентов. " +
                        "Эти бины обычно взаимодействуют друг с другом и, таким образом, имеют зависимости между собой. " +
                        "Эти зависимости отражены в данных конфигурации, используемых BeanFactory. " +
                        "BeanFactory обычно используется тогда, когда ресурсы ограничены (мобильные устройства)" +
                        ". Поэтому, если ресурсы не сильно ограничены, то лучше использовать ApplicationContext."));
        Question actual = javaQuestionService.add(new Question("Bean Factory", "BeanFactory - это фактический контейнер, " +
                "который создает, настраивает и управляет рядом bean-компонентов. " +
                "Эти бины обычно взаимодействуют друг с другом и, таким образом, имеют зависимости между собой. " +
                "Эти зависимости отражены в данных конфигурации, используемых BeanFactory. " +
                "BeanFactory обычно используется тогда, когда ресурсы ограничены (мобильные устройства)" +
                ". Поэтому, если ресурсы не сильно ограничены, то лучше использовать ApplicationContext."));

        Assertions.assertEquals(actual
                , expected);

    }
    @Test
    void remove() {
        Question testQuestion = new Question("IOC",
                "Центральной частью Spring является подход Inversion of Control, " +
                        "который позволяет конфигурировать и управлять объектами Java с помощью рефлексии. " +
                        "Вместо ручного внедрения зависимостей, фреймворк забирает ответственность за это посредством контейнера. Контейнер отвечает за управление жизненным циклом объекта: создание объектов, вызов методов инициализации и конфигурирование объектов путём связывания их между собой.\n" +
                        "Объекты, создаваемые контейнером, также называются управляемыми объектами (beans). " +
                        "Обычно, конфигурирование контейнера, осуществляется путём внедрения аннотаций " +
                        "(начиная с 5 версии J2SE), но также, есть возможность, по старинке, " +
                        "загрузить XML-файлы, содержащие определение bean’ов и предоставляющие информацию, " +
                        "необходимую для создания bean’ов.\n" +
                        "Объекты могут быть получены одним из двух способов:\n" +
                        "Dependency Lookup (поиск зависимости) — шаблон проектирования, " +
                        "в котором вызывающий объект запрашивает у объекта-контейнера" +
                        " экземпляр объекта с определённым именем или определённого типа.\n" +
                        "Dependency Injection (внедрение зависимости) — шаблон проектирования, " +
                        "в котором контейнер передает экземпляры объектов по их имени другим объектам" +
                        " с помощью конструктора, свойства или фабричного метода.\n");
        when(javaQuestionRepository.remove(testQuestion)).thenReturn(null);
        Assertions.assertNull(javaQuestionService.remove(new Question("IOC",
                "Центральной частью Spring является подход Inversion of Control, " +
                        "который позволяет конфигурировать и управлять объектами Java с помощью рефлексии. " +
                        "Вместо ручного внедрения зависимостей, фреймворк забирает ответственность за это посредством контейнера. Контейнер отвечает за управление жизненным циклом объекта: создание объектов, вызов методов инициализации и конфигурирование объектов путём связывания их между собой.\n" +
                        "Объекты, создаваемые контейнером, также называются управляемыми объектами (beans). " +
                        "Обычно, конфигурирование контейнера, осуществляется путём внедрения аннотаций " +
                        "(начиная с 5 версии J2SE), но также, есть возможность, по старинке, " +
                        "загрузить XML-файлы, содержащие определение bean’ов и предоставляющие информацию, " +
                        "необходимую для создания bean’ов.\n" +
                        "Объекты могут быть получены одним из двух способов:\n" +
                        "Dependency Lookup (поиск зависимости) — шаблон проектирования, " +
                        "в котором вызывающий объект запрашивает у объекта-контейнера" +
                        " экземпляр объекта с определённым именем или определённого типа.\n" +
                        "Dependency Injection (внедрение зависимости) — шаблон проектирования, " +
                        "в котором контейнер передает экземпляры объектов по их имени другим объектам" +
                        " с помощью конструктора, свойства или фабричного метода.\n")));
    }
    @Test
    void getAll() {
        Assertions.assertNotNull(javaQuestionService.getAll());


    }
    @Test
    void getRandomQuestion() {
        Set<Question> testQuestion = new HashSet<>();
        testQuestion.add(new Question("Жизненный цикл Spring бина", "время существования класса. " +
                "Spring бины инициализируются при инициализации Spring контейнера " +
                "и происходит внедрение всех зависимостей. Когда контейнер уничтожается, " +
                "то уничтожается и всё содержимое. Если нам необходимо задать какое-либо действие " +
                "при инициализации и уничтожении бина, то нужно воспользоваться методами init() и destroy()" +
                "Для этого можно использовать аннотации @PostConstruct и @PreDestroy()."));
        when(javaQuestionRepository.getAll()).thenReturn(testQuestion);
        Assertions.assertNotNull(javaQuestionService.getRandomQuestion());
    }
}