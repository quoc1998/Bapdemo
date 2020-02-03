package jp.bap.demo.powerManager.repository;

import jp.bap.demo.powerManager.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
}
