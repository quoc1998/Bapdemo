package jp.bap.demo.powerManager.service;

import jp.bap.demo.powerManager.model.Device;

import java.util.List;

public interface DeviceService {
    List<Device>getDevice();
    Device save(Device device);
    void delete(int id);
}
