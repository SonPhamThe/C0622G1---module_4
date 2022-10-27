package shop_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop_market.dto.CartDTO;
import shop_market.service.IProductService;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart") /* khai báo session có tên là cart */
public class ProductController {

    @ModelAttribute("cart") /* Khởi tạo gái trị mặc định cho session cart */
    public CartDTO initCart() {
        return new CartDTO();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showListPage(Model model,
                                     @CookieValue(value = "idProduct",
                                             defaultValue = "-1")
                                             int idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct));
        }
        return new ModelAndView("", "productList", productService.displayAll());
    }

}
