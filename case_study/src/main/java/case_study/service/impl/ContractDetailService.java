package case_study.service.impl;

import case_study.model.contract.ContractDetail;
import case_study.repository.contract.IContractDetailRepository;
import case_study.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> listContractDetail() {
        return contractDetailRepository.findAll();
    }
}
