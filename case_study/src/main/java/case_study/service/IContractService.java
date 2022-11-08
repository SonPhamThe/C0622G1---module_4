package case_study.service;

import case_study.model.contract.AttachFacility;
import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    Page<Contract> listContract(Pageable pageable);

    void save(Contract contract);

    Optional<Contract> findById(int id);

    void remove(int id);

    Contract findByIdToCreateAttach(int id);

    AttachFacility findAttachFacility(int id);

    ContractDetail findContractDetail(int attachId, int contractDetailId);

    void saveContractDetail(ContractDetail contractDetail);

    List<AttachFacility> listAttachFacility();
}
