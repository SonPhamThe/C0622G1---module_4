package case_study.service.impl;

import case_study.model.facility.FacilityType;
import case_study.repository.facility.IFacilityTypeRepository;
import case_study.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> listFacilityType() {
        return facilityTypeRepository.findAll();
    }
}
