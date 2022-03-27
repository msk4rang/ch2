package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class RegisterController {
    @GetMapping("/register/add")
    public String register()
    {
        return "registerForm";
    }

//    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    @PostMapping("/register/save")
    public String save(User user, Model m) throws UnsupportedEncodingException {
        // 1. 유효성 검사
        if (!isVaild(user)) {
            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
            m.addAttribute("msg", msg);
            return "redirect:/register/add";
//            return "redirect:/register/add?msg="+msg;
        }

        // 2. DB에 신규회원 정보 저장
        return "registerInfo";
    }

    private boolean isVaild(User user) {
        return true;
    }

}
