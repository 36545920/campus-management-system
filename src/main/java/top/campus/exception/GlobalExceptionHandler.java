package top.campus.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.campus.common.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> handleException(Exception e) {
        e.printStackTrace();
        return Result.fail(e.getMessage());

    }

    @ExceptionHandler(value = BusinessException.class)
    public Result<String> handleBusinessException(BusinessException e) {
        e.printStackTrace();
        return Result.build(e.getCode(), e.getMessage());
    }
}
