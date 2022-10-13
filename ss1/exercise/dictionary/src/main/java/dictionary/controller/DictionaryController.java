package dictionary.controller;

import dictionary.service.IServiceDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IServiceDictionary serviceDictionary;

    @GetMapping
    public String showSearchForm(Model model) {
        return "/search";
    }

    @GetMapping
    public String showResult(@RequestParam String word, Model model) {
        String mean = serviceDictionary.findWord(word);
        model.addAttribute("mean", mean);
        model.addAttribute("word", word);
        return "/search";
    }
}
