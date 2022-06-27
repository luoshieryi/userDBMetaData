package moe.gothiclolita.userdbmetadata.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ClassNotFoundException.class)
    public String handleClassNotFoundException(ClassNotFoundException e) {
        // stack
        log.error("ClassNotFoundException: {}", e.getMessage());
        log.error("StackTrace: {}", (Object) e.getStackTrace());
        return "Class not found: " + e.getMessage();
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public String handleNoSuchFieldException(NoSuchFieldException e) {
        log.error("ClassNotFoundException: {}", e.getMessage());
        log.error("StackTrace: {}", (Object) e.getStackTrace());
        return "No such field: " + e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        log.error("ClassNotFoundException: {}", e.getMessage());
        log.error("StackTrace: {}", (Object) e.getStackTrace());
        return "Error: " + e.getMessage();
    }
}
