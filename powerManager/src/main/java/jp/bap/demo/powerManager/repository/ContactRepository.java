package jp.bap.demo.powerManager.repository;
import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.model.Contact;
import jp.bap.demo.powerManager.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    Contact findById(int id);

    @Query(value = "Select c.staff from Contact c where c.id = ?1", nativeQuery = false)
    List<Staff> getStaffByContactId(int id);
//    Company findCompanyByContact(Contact contact);

    Contact findContactByCompanies(Company company);

    @Query(value = "select c.companies from Contact c where c.id = ?1", nativeQuery = false)
    Company findCompanyByContact(int id);
}
