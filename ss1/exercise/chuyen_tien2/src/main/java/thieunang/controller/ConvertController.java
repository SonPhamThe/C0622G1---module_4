package thieunang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thieunang.service.IConvert;

@Controller
public class ConvertController {
    @Autowired
    IConvert convert;

    @GetMapping("/")
    public String showMoney() {
        return "/list";
    }

    @PostMapping("/result")
    public String convert_money(@RequestParam double usd, Model model) {
        double vnd = convert.convertMoney(usd);
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "/list";
    }
}
