package on_tap.controller;

import on_tap.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(/student)
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String displayAll(Pageable pageable, Model model) {
        model.addAttribute("studentList", studentService.displayAll(pageable));
        return "home";
    }
}
