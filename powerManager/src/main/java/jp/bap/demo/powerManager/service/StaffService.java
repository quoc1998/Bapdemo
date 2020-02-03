package jp.bap.demo.powerManager.service;
import jp.bap.demo.powerManager.model.Staff;

import java.util.List;

public interface StaffService {
    List<Staff>getStaff();
    Staff save(Staff staff);
    Staff getId(int id);
    void delete(int id);

}
