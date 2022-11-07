package case_study.controller;

import case_study.dto.CustomerDTO;
import case_study.model.customer.Customer;
import case_study.model.customer.CustomerType;
import case_study.service.ICustomerService;
import case_study.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customerType")
    public List<CustomerType> listCustomerType() {
        return customerTypeService.listCustomerType();
    }

    @GetMapping("")
    public String searchCustomer(@RequestParam(value = "searchName", defaultValue = "") String searchName,
                                 @RequestParam(value = "searchEmail", defaultValue = "") String searchEmail,
                                 @RequestParam(value = "searchCustomerType", defaultValue = "") String searchCustomerType,
                                 @PageableDefault(value = 4) Pageable pageable,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        Page<Customer> customers = customerService.findByNameAndEmailAndCustomerType(searchName, searchEmail, searchCustomerType, pageable);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("searchCustomerType", searchCustomerType);
        model.addAttribute("customerSearch", customers);
        model.addAttribute("customers", customerService.displayListCustomer(pageable));
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String createCustomer(@Validated @ModelAttribute CustomerDTO customerDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.create(customer);
            redirectAttributes.addFlashAttribute("message", "Create New Customer " + customer.getName() + " success");
            return "redirect:/customers/create";
        }
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute("customer") CustomerDTO customerDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.create(customer);
            redirectAttributes.addFlashAttribute("message", "Edit customer: " + customer.getName() + " success");
            return "redirect:/customers";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        customerService.remove(id);
        return "redirect:/customers";
    }
}
