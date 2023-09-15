package pro.sky.HardCourseWorkTwo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class EmptyArrayException extends RuntimeException {
}
