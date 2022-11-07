package case_study.service;

import case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> displayFacility(Pageable pageable);

    void save(Facility facility);
}
