package case_study.service.impl;

import case_study.model.customer.Customer;
import case_study.repository.customer.ICustomerRepository;
import case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> displayListCustomer(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String type, Pageable pageable) {
        return customerRepository.findByNameAndEmailAndCustomerType(name, email, type, pageable);
    }

    @Override
    public void remove(int id) {
        customerRepository.removeById(id);
    }
}
