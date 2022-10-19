package management_product.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import management_product.model.Product;
import management_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String productList(Model model) {
        List<Product> productList = productService.displayALl();
        model.addAttribute("products", productList);
        return "home";
    }
}
