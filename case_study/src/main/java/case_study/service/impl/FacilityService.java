package case_study.service.impl;

import case_study.model.facility.Facility;
import case_study.repository.facility.IFacilityRepository;
import case_study.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> displayFacility(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }
}
