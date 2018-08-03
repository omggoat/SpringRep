package cn.shil.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NotFoundException.class)
    public String notFoundExceptionHandle(Model model){
        model.addAttribute("exception_type","not_found_exception");
        return "error";
    }

    @ExceptionHandler(value = DuplicateValueException.class)
    public String duplicateValueExceptionHandle(Model model){
        model.addAttribute("exception_type","duplicate_value_exception");
        return "error";
    }
}
