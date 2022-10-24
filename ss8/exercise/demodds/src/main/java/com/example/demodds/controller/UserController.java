package com.example.demodds.controller;

import com.example.demodds.dto.UserDTO;
import com.example.demodds.model.User;
import com.example.demodds.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String displayAll(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<User> userList = userService.displayAll(pageable);
        model.addAttribute("userList", userList);
        return "home";
    }

    @GetMapping("/create")
    public String showCreateUser(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute UserDTO userDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model
    ) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "Create new User" + user.getLastName() + " " + user.getFirstName() + " success ! ");
            return "home";
        }
    }
}
