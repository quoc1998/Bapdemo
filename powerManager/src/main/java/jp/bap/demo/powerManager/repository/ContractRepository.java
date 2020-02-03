package jp.bap.demo.powerManager.repository;

import jp.bap.demo.powerManager.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
