package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String EMAIL_REGEX = "\\w+@\\w+\\.\\w+";
    private static Pattern pattern;
    private static Matcher matcher;

    public HomeController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    private boolean CheckEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @PostMapping("/validate")
    public String FormCheck(@RequestParam("email") String email, ModelMap modelMap) {
            boolean isValid = CheckEmail(email);
            if(!isValid) {
                modelMap.addAttribute("message","Email is invalid");
                return "home";
            }
            modelMap.addAttribute("email",email);
            return "success";
    }
}
