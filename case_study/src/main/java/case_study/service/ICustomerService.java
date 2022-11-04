package case_study.service;

import case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> displayListCustomer(Pageable pageable);

    void create(Customer customer);

    Customer findById(int id);


    Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String type, Pageable pageable);

    void remove(Customer customer);
}
