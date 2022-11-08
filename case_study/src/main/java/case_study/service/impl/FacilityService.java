package case_study.service.impl;

import case_study.model.facility.Facility;
import case_study.repository.facility.IFacilityRepository;
import case_study.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        facilityRepository.removeById(id);
    }

    @Override
    public Page<Facility> findByNameAndFacilityType(String name, String facilityType, Pageable pageable) {
        return facilityRepository.findByNameAndFacilityType(name, facilityType, pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
