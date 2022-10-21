package upgrade_app_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import upgrade_app_blog.model.Blog;
import upgrade_app_blog.service.IBlogService;
import upgrade_app_blog.service.ICategoryService;

@Controller
@RequestMapping("/upgrade_blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String showBlogList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Blog> blogers = blogService.findAll(pageable);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blogs", blogers);
        return "list";
    }

    @GetMapping("/create")
    private String createBlog(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog bloger) {
        blogService.save(bloger);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("message", "Blog created successfully");
        return modelAndView;
    }


    @GetMapping("/edit-blog/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Blog bloger = blogService.findById(id);
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute("blog") Blog bloger) {
        blogService.save(bloger);

        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("message", "Updated blog successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Blog bloger = blogService.findById(id);

        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog") Blog bloger) {
        blogService.remove(bloger);
        return "redirect:blogger";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView view(@PathVariable int id) {
        Blog bloger = blogService.findById(id);

        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            return new ModelAndView("error.404");
        }
    }

}
