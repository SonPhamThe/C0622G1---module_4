package management_customer.service.impl;

import management_customer.model.Customer;
import management_customer.repository.IRepoCustomer;
import management_customer.repository.impl.RepoCustomer;
import management_customer.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCustomer implements IServiceCustomer {
    @Autowired
    private static final IRepoCustomer repoCustomer = new RepoCustomer();

    @Override
    public List<Customer> findAll() {
        return repoCustomer.findAll();
    }

    @Override
    public void save(Customer customer) {
        repoCustomer.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return repoCustomer.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        repoCustomer.update(id, customer);
    }

    @Override
    public void remove(int id) {
        repoCustomer.remove(id);
    }
}
