package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController {

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String catcher(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }

    @RequestMapping("/ex")
    public String main() throws Exception {
        throw new Exception("예외발생");
    }

    @RequestMapping("/ex2")
    public String main2() throws Exception {
        throw new FileNotFoundException("예외발생");
    }

}
