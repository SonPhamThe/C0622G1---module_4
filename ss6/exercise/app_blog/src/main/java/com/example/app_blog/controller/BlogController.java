package com.example.app_blog.controller;

import com.example.app_blog.model.Blog;
import com.example.app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public String show(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Blog> blogList = blogService.findAll(pageable);
        model.addAttribute("blogs", blogList);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("message", "Create Products: " + blog.getNameBlog() + " success");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog);
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "searchNameOne", defaultValue = "") String searchNameOne,
                         @RequestParam(value = "searchNameTwo", defaultValue = "") String searchNameTwo
            , Model model) {
        model.addAttribute("blogs", blogService.searchByNameBlog(searchNameOne, searchNameTwo));
        return "home";
    }
}
