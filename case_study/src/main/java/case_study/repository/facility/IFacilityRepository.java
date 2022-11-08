package case_study.repository.facility;

import case_study.model.customer.Customer;
import case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select f.* from `facility` f inner join `facility_type` ft " +
            "on f.facility_type = ft.id " +
            "where f.name like %:name% and ft.name like %:facilityType% and f.status= 1", nativeQuery = true)
    Page<Facility> findByNameAndFacilityType(@Param("name") String name,
                                             @Param("facilityType") String facilityType,
                                             Pageable pageable);

    @Query(value = "SELECT * FROM facility where status=1", nativeQuery = true)
    Page<Facility> findAllCustomer(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `facility` SET `status` = 0 WHERE (`id` = :id);\n", nativeQuery = true)
    void removeById(@Param("id") int id);
}
