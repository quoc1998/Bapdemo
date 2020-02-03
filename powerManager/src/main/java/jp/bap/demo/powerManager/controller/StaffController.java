package jp.bap.demo.powerManager.controller;
import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.model.Contact;
import jp.bap.demo.powerManager.model.Staff;
import jp.bap.demo.powerManager.service.ConpanyService;
import jp.bap.demo.powerManager.service.ContactService;
import jp.bap.demo.powerManager.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class StaffController {
    @Autowired
    StaffService staffService;
    @Autowired
    private ConpanyService conpanyService;
    @Autowired
    private ContactService contactService;
    @GetMapping("/Staff")
    List<Staff>get(){
        List<Staff>staff = staffService.getStaff();
        return staff;
    }
    @PostMapping("/staff/post")
    Staff staff(@RequestBody Map<String,String> body) throws ParseException {
        String idstaff = body.get( "idstaff" );
        int a  = Integer.parseInt( idstaff );

        String startDate= body.get( "startDate" );
        DateFormat b = new SimpleDateFormat("yyyy-MM-dd");
        Date date = b.parse(startDate);
        String endDate = body.get( "endDate" );
        DateFormat c = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = c.parse(endDate);

        String idCompany =body.get( "idCompany" );
        int d = Integer.parseInt( idCompany );
        String idContact = body.get( "idContact" );
        int e = Integer.parseInt( idContact );
        Company company = conpanyService.get( d );
        Contact contact = contactService.get( e );
        Staff staff = new Staff(  );
        staff.setId( a );
        staff.setStartDate(date);
        staff.setEndDate( date1 );
        staff.setCompany( company );
        staff.setContact( contact );
        Staff staff1 = staffService.save( staff );
        return staff1;
    }
    @PutMapping("/staff/put/{id}")
    Staff staff(@PathVariable int id,@RequestBody Map<String,String>body) throws ParseException {

        String startDate= body.get( "startDate" );
        DateFormat b = new SimpleDateFormat("yyyy-MM-dd");
        Date date = b.parse(startDate);
        String endDate = body.get( "endDate" );
        DateFormat c = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = c.parse(endDate);

        String idCompany =body.get( "idCompany" );
        int d = Integer.parseInt( idCompany );
        String idContact = body.get( "idContact" );
        int e = Integer.parseInt( idContact );
        Company company = conpanyService.get( d );
        Contact contact = contactService.get( e );
        Staff staff = new Staff(  );
        staff.setId( id );
        staff.setStartDate(date);
        staff.setEndDate( date1 );
        staff.setCompany( company );
        staff.setContact( contact );
        Staff staff1 = staffService.save( staff );
        return staff1;
    }

    @DeleteMapping("/deleteStaff/{id}")
    void staff(@PathVariable int id){
        staffService.delete( id );
    }

}
