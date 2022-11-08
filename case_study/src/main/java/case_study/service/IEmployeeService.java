package case_study.service;

import case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> listEmployee(Pageable pageable);

    List<Employee> findAll();
}
