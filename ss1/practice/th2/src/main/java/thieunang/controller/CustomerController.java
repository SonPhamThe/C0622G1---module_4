package thieunang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import thieunang.model.Customer;
import thieunang.service.ICustomer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    ICustomer customer;

    @GetMapping("/customer")
    public String showList(Model model) {
        List<Customer> customers = customer.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/cu")
    public ModelAndView showListID(@RequestParam Long id) {
        Customer customers = customer.findOne(id);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customers);
        return new ModelAndView( "list","customers", customerList);
    }


}
