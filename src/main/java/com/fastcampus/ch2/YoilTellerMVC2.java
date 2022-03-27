package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

@Controller
public class YoilTellerMVC2 {

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex) {
        ex.printStackTrace();
        return "yoilError";
    }

    @RequestMapping("/getYoilMVC2")
    public String main(@RequestParam(required = true) int year,
                       @RequestParam(required = true) int month,
                       @RequestParam(required = true) int day,
                       Model model)
    {

        if (!isValid(year, month, day)) {
            return "yoilError";
        }

        char yoil = getYoil(year, month, day);

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        return "yoil";
    }

    private boolean isValid(int year, int month, int day) {
        if (year == -1 || month == -1 || day == -1) {
            return false;
        }

        return true;
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
