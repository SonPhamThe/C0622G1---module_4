package case_study.repository.contract;

import case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    @Query(value = "select * from contract_detail where contract_id = :id",nativeQuery = true)
    List<ContractDetail> findList(@Param("id") int id);

    @Query(value = "select * from contract_detail where attach_facility_id = :attachId and contract_id = :contractId",nativeQuery = true)
    ContractDetail findContractDetailId(@Param("attachId") int attachId,
                                        @Param("contractId")int contractId);
}
