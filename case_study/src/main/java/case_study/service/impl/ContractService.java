package case_study.service.impl;

import case_study.model.contract.AttachFacility;
import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;
import case_study.repository.contract.IAttachFacilityRepository;
import case_study.repository.contract.IContractDetailRepository;
import case_study.repository.contract.IContractRepository;
import case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public Page<Contract> listContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        contractRepository.remove(id);
    }

    @Override
    public Contract findByIdToCreateAttach(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public AttachFacility findAttachFacility(int id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public ContractDetail findContractDetail(int attachId, int contractDetailId) {
        return contractDetailRepository.findContractDetailId(attachId, contractDetailId);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<AttachFacility> listAttachFacility() {
        return attachFacilityRepository.findAll();
    }
}
