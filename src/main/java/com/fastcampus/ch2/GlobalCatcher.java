package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

@ControllerAdvice("com.fastcampus.ch3")
public class GlobalCatcher {

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
