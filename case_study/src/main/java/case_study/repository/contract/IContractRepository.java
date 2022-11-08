package case_study.repository.contract;

import case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from `contract` where status= 1", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select * from `contract` where id=:id and status = 1", nativeQuery = true)
    Optional<Contract> findById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update customer set status = 0 where id = :id", nativeQuery = true)
    void remove(@Param("id") int id);
}
