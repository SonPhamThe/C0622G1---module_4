package management_customer.controller;

import management_customer.model.Customer;
import management_customer.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    public IServiceCustomer serviceCustomer;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = serviceCustomer.findAll();
        model.addAttribute("customers", customerList);
        return "/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
//        customer.setId((int) (Math.random() * 10000));
        serviceCustomer.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create Customers: "+customer.getName()+"success");
        return "redirect:/customer";
    }
}
