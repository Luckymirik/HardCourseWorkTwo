package pro.sky.HardCourseWorkTwo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
@Primary
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> javaQuestions = new HashSet<>();

    public JavaQuestionRepository() {
    }

    @PostConstruct
    public void init() {
        Question question = new Question("IOC",
                "Центральной частью Spring является подход Inversion of Control, " +
                        "который позволяет конфигурировать и управлять объектами Java с помощью рефлексии." +
                        " Вместо ручного внедрения зависимостей," +
                        " фреймворк забирает ответственность за это посредством контейнера. " +
                        "Контейнер отвечает за управление жизненным циклом объекта: создание объектов," +
                        " вызов методов инициализации" +
                        " и конфигурирование объектов путём связывания их между собой.\n" +
                "Объекты, создаваемые контейнером, также называются управляемыми объектами (beans). " +
                        "Обычно, конфигурирование контейнера, осуществляется путём внедрения аннотаций (начиная с 5 версии J2SE), " +
                        "но также, есть возможность, по старинке, загрузить XML-файлы, " +
                        "содержащие определение bean’ов и предоставляющие информацию," +
                        " необходимую для создания bean’ов.\n" +
                "Объекты могут быть получены одним из двух способов:\n" +
                "Dependency Lookup (поиск зависимости) — шаблон проектирования," +
                        " в котором вызывающий объект запрашивает у объекта-" +
                        "контейнера экземпляр объекта с определённым именем или определённого типа.\n" +
                "Dependency Injection (внедрение зависимости) — " +
                        "шаблон проектирования, в котором контейнер передает экземпляры" +
                        " объектов по их имени другим объектам с помощью конструктора, " +
                        "свойства или фабричного метода.\n");
        javaQuestions.add(question);
        question = new Question("Application context",
                "ApplicationContext - это главный интерфейс в Spring-приложении," +
                        " который предоставляет информацию о конфигурации приложения. " +
                        "Так же, как BeanFactory, ApplicationContext загружает бины, связывает их вместе" +
                        " и конфигурирует их определённым образом. " +
                        "Но кроме этого, ApplicationContext обладает дополнительной функциональностью.\n" +
                "ApplicationContext предоставляет:\n" +
                "●\tФабричные методы бина для доступа к компонентам приложения\n" +
                "●\tВозможность загружать файловые ресурсы в общем виде\n" +
                "●\tВозможность публиковать события и регистрировать обработчики на них\n" +
                "●\tВозможность работать с сообщениями с поддержкой интернационализации\n" +
                "●\tНаследование от родительского контекста\n");
        javaQuestions.add(question);
        question = new Question("Основные этапы поднятия ApplicationContext",
                "1 этап: Парсирование конфигурации (xml, groovy, JavaConfig и пр.) " +
                        "и создание всех BeanDefinition (AnnotatedBeanDefinitionReader," +
                        " BeanDefinitionReader, ClassPathBeanDefinitionScanner)\n" +
                "2 этап: Настройка созданных BeanDefinition (BeanFactoryPostProcessor)\n" +
                "3 этап: Создание кастомных FactoryBean (FactoryBean<T>)\n" +
                "4 этап: BeanFactory создает экземпляры бинов, " +
                        "при необходимости делегируя создание FactoryBean (BeanFactory)\n" +
                "5 этап: Настройка созданных бинов (BeanPostProcessor)\n");
        javaQuestions.add(question);
        question = new Question("●\t@Component",
                "Spring определяет этот класс как кандидата для создания bean");
        javaQuestions.add(question);
        question = new Question("●\t@Service ",
                " класс содержит бизнес-логику и вызывает методы на уровне хранилища." +
                " Ничем не отличается от классов с @Component");
        javaQuestions.add(question);
        question = new Question("●\t@Controller ",
                "указывает, что класс выполняет роль контроллера MVC. " +
                "Диспетчер сервлетов просматривает такие классы для поиска @RequestMapping");
        javaQuestions.add(question);



    }

    @Override
    public Question add(String question, String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        for (Question q:javaQuestions){
            if (q.equals(question)){
                throw new QuestionAlreadyAddedException();
            }
        }
        javaQuestions.add(question);
        return question;
    }
    @Override

    public Question remove(Question question){
        if(javaQuestions.contains(question)) {
            javaQuestions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }
    @Override
    public Collection<Question> getAll(){
        return Collections.unmodifiableSet(javaQuestions);
    }
}
