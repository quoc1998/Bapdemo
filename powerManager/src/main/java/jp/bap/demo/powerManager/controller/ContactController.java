package jp.bap.demo.powerManager.controller;


import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.model.Contact;
import jp.bap.demo.powerManager.model.Staff;
import jp.bap.demo.powerManager.model.User;
import jp.bap.demo.powerManager.repository.ContactRepository;
import jp.bap.demo.powerManager.service.ContactService;
import jp.bap.demo.powerManager.service.impl.CompanyServiceImpl;
import jp.bap.demo.powerManager.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContactController {
    @Autowired
    ContactService contactService;

    @Autowired
    ContactServiceImpl contactServiceImpl;
    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @GetMapping("/Contact")
    List<Contact> get() {
        List<Contact> list = contactService.getconcat();
        return list;
    }

    @GetMapping("/contact/{contactId}/staff")
    List<Staff> getStaff(@PathVariable int contactId) {
        return contactServiceImpl.getContactRepository().getStaffByContactId( contactId );
    }
    @DeleteMapping("/deleteContact/{id}")
    public boolean delete(@PathVariable int id){
        Company company = contactServiceImpl.getContactRepository().findCompanyByContact( id );
        company.setContact( null );
        contactServiceImpl.getContactRepository().deleteById( id );
        return true;
    }
    @PostMapping("/efef/post")
    Contact contact(@RequestBody Map<String,String> body){
        String contact = body.get( "contact" );
        int contactInt = Integer.parseInt( contact );
        String emaill = body.get( "email" );
        String address1 = body.get( "address1" );
        String address2 = body.get( "address2" );
        String phoneNumber = body.get( "phoneNumber" );
//        int d = Integer.parseInt( phoneNumber );
        String fax = body.get( "fax" );
//        int fax1 = Integer.parseInt( fax );
        Contact contact1 = new Contact(  );
        contact1.setId( contactInt );
        contact1.setEmail( emaill );
        contact1.setAddress1( address1 );
        contact1.setAddress2( address2 );
        contact1.setPhoneNumber(phoneNumber);
        contact1.setFax( fax );
        Contact contact2 = contactService.save( contact1 );
        return contact2;
    }
    @PutMapping("/contact/put/{id}")
    Contact contact(@PathVariable int id,@RequestBody Map<String,String>body ){


        String emaill = body.get( "email" );
        String address1 = body.get( "address1" );
        String address2 = body.get( "address2" );
        String phoneNumber = body.get( "phoneNumber" );
//        int d = Integer.parseInt( phoneNumber );
        String fax = body.get( "fax" );
//        int fax1 = Integer.parseInt( fax );
        Contact contact1 = new Contact(  );
        contact1.setId( id );
        contact1.setEmail( emaill );
        contact1.setAddress1( address1 );
        contact1.setAddress2( address2 );
        contact1.setPhoneNumber(phoneNumber);
        contact1.setFax( fax );
        Contact contact2 = contactService.put( contact1 );
        return contact2;
    }

}



