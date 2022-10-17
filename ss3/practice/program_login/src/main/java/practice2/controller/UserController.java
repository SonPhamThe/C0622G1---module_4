package practice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import practice2.model.Login;
import practice2.model.User;
import practice2.service.IServiceUser;

@Controller
public class UserController {
    @Autowired
    private IServiceUser serviceUser;

    @GetMapping("/login")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = serviceUser.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
