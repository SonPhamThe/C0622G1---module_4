package case_study.service;

import case_study.model.customer.Customer;
import case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> displayFacility(Pageable pageable);

    void save(Facility facility);

    Optional<Facility> findById(int id);

    void remove(int id);

    Page<Facility> findByNameAndFacilityType(String name, String facilityType, Pageable pageable);

    List<Facility> findAll();
}
