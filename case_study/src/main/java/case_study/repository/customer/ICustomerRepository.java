package case_study.repository.customer;

import case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c.* from `customer` c inner join `customer_type` ct " +
            "on c.customer_type_id = ct.id " +
            "where c.name like %:name% and c.email like %:email% and ct.name like %:type% and c.status= 1", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerType(@Param("name") String name,
                                                     @Param("email") String email,
                                                     @Param("type") String type,
                                                     Pageable pageable);


    @Query(value = "SELECT * FROM customer where status=1", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `customer` SET `status` = 0 WHERE (`id` = :id);\n", nativeQuery = true)
    void removeById(@Param("id") int id);
}
