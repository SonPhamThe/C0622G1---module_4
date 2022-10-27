package product_cart.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import product_cart.dto.CartDTO;
import product_cart.dto.ProductDTO;
import product_cart.model.Product;
import product_cart.service.IProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

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
        return new ModelAndView("product/list", "productList", productService.displayAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response) {
        /* Tạo cookie và chú ý là HttpServletResponse */
        Cookie cookie = new Cookie("idProduct", id + ""); // cookie của java.serverlet
        cookie.setMaxAge(24 * 60 * 60); // thời gian tồn tại trong 1 ngày
//        cookie.setMaxAge(0); hủy cookie
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("product/detail", "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
//                            @ModelAttribute("cart") CartDTO cartDTO) {
                            @SessionAttribute("cart") CartDTO cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) // kiểm tra đối tượng có tồn tại không
        {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productOptional.get(), productDTO);
            cart.addProduct(productDTO);
        }
        return "redirect:/cart";
    }

}
