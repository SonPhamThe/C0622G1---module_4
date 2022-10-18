package management_customer.service;

import management_customer.model.Customer;

import java.util.List;

public interface IServiceCustomer {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
