package case_study.service.impl;

import case_study.model.customer.CustomerType;
import case_study.repository.customer.ICustomerRepository;
import case_study.repository.customer.ICustomerTypeRepository;
import case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerRepository;

    @Override
    public List<CustomerType> listCustomerType() {
        return customerRepository.findAll();
    }
}
