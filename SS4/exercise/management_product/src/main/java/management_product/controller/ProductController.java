package management_product.controller;

import management_product.model.Product;
import management_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public IProductService serviceProduct;

    @GetMapping("")
    public String productList(Model model) {
        List<Product> productList = serviceProduct.displayAll();
        model.addAttribute("products", productList);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        serviceProduct.create(product);
        redirectAttributes.addFlashAttribute("message", "Create Products: " + product.getName() + " success");
        return "redirect:/product";
    }

    //    id tự động tăng
//    public int createId() {
//        List<Product> productList = serviceProduct.displayAll();
//        int maxId = 0;
//        for (Product product : productList) {
//            if (product.getId() > maxId) {
//                maxId = product.getId();
//            }
//        }
//        return maxId + 1;
//    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", serviceProduct.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        serviceProduct.remove(product);
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", serviceProduct.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        serviceProduct.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", serviceProduct.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "searchName", defaultValue = "") String searchName, Model model) {
        model.addAttribute("products", serviceProduct.searchProduct(searchName));
        return "home";
    }
}
