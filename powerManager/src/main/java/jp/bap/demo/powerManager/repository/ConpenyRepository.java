package jp.bap.demo.powerManager.repository;

import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConpenyRepository extends JpaRepository<Company,Integer> {

    Company findById(int id);
    Company findCompanyByContact(Contact contact);

}
