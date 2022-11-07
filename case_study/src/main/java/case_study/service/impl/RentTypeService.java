package case_study.service.impl;

import case_study.model.facility.RentType;
import case_study.repository.facility.IRentTypeRepository;
import case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> listRentType() {
        return rentTypeRepository.findAll();
    }
}
