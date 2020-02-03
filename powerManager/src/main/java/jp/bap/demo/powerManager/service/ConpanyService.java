package jp.bap.demo.powerManager.service;
import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.repository.ConpenyRepository;
import jp.bap.demo.powerManager.repository.ContactRepository;

import java.util.List;

public interface ConpanyService {
    List<Company>get();
    Company get(int id);
//    Company c(Company company);
    Company save(Company company);
    Company put(Company company);

     ConpenyRepository getconpenyRepository();

//     boolean delete(int id);

}
