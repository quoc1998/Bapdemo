package jp.bap.demo.powerManager.service.impl;

import jp.bap.demo.powerManager.model.Device;
import jp.bap.demo.powerManager.repository.DeviceRepository;
import jp.bap.demo.powerManager.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceRepository deviceRepository;
    @Override
    public List<Device> getDevice() {
        return deviceRepository.findAll();
    }

    @Override
    public Device save(Device device) {
        return deviceRepository.save( device );
    }

    @Override
    public void delete(int id) {
        deviceRepository.deleteById( id );
    }
}
