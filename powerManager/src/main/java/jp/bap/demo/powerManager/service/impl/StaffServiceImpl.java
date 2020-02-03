package jp.bap.demo.powerManager.service.impl;
import jp.bap.demo.powerManager.model.Staff;
import jp.bap.demo.powerManager.repository.StaffRepository;
import jp.bap.demo.powerManager.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepository staffRepository;
    @Override
    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save( staff );
    }

    @Override
    public Staff getId(int id) {
        return staffRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        staffRepository.deleteById( id );
    }
}
