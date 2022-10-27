package product_cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import product_cart.dto.CartDTO;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDTO cart) {
        /* public ModelAndView showCart(@ModelAttribute(value = "cart") cartDTO cart)
        * không được vì với modelAttribute dùng phải trong cùng 1 controller */
        return new ModelAndView("cart/list", "cart", cart);
    }

}
