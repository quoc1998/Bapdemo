package jp.bap.demo.powerManager.repository;

import jp.bap.demo.powerManager.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
    Staff findById(int id);

}
