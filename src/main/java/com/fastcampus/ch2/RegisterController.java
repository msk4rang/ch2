package com.fastcampus.ch2;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RegisterController {

    @InitBinder
    public void registerBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    // test
    @GetMapping("/register/add")
    public String register()
    {
        return "registerForm";
    }

//    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    @PostMapping("/register/save")
    public String save(@Valid User user, BindingResult result, Model m) throws UnsupportedEncodingException {
        System.out.println("result="+result);
        System.out.println("user="+user);

//        // 수동 검증
//        UserValidator userValidator = new UserValidator();
//        if (!userValidator.supports(user.getClass())) {
//            return "registerForm";
//        }
//        userValidator.validate(user, result);

        if (result.hasErrors()) {
            System.out.println("result="+result);

            return "registerForm";
        }
//        // 1. 유효성 검사
//        if (!isVaild(user)) {
//            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//            m.addAttribute("msg", msg);
//            return "redirect:/register/add";
////            return "redirect:/register/add?msg="+msg;
//        }

        // 2. DB에 신규회원 정보 저장
        return "registerInfo";
    }

    private boolean isVaild(User user) {
        return true;
    }

}
