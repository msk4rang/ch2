package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class YoilTellerMVC6 {

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, BindingResult result) {
        System.out.println("result=" + result);
        FieldError error = result.getFieldError();
        System.out.println("Code="+error.getCode());
        System.out.println("Field="+error.getField());
        System.out.println("Message="+error.getDefaultMessage());


        ex.printStackTrace();
        return "yoilError";
    }

    @RequestMapping("/getYoilMVC6")
    public String main(MyDate date, BindingResult result)
    {
        System.out.println("result=" + result);

        if (!isValid(date)) {
            return "yoilError";
        }

        char yoil = getYoil(date);

        return "yoil";
    }

    private boolean isValid(MyDate date) {
        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }

    private boolean isValid(int year, int month, int day) {
        if (year == -1 || month == -1 || day == -1) {
            return false;
        }

        return true;
    }

    private @ModelAttribute("yoil") char getYoil(MyDate date) {
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
