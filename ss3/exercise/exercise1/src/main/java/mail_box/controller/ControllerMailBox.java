package mail_box.controller;

import mail_box.model.MailBox;
import mail_box.service.IServiceMailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerMailBox {
    @Autowired
    public IServiceMailBox serviceMailBox;

    @GetMapping
    public String showForm(ModelMap modelMap) {

        modelMap.addAttribute("mail", new MailBox());
        modelMap.addAttribute("languageList", serviceMailBox.languageList());
        modelMap.addAttribute("sizeList", serviceMailBox.sizeList());
        return "home";
    }

    @PostMapping("/home")
    public String updateMailBox(@ModelAttribute("mail") MailBox mailBox, Model model) {
        model.addAttribute("message", "Update mail box is success");
        return "list";
    }
}
