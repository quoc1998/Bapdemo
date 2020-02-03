package jp.bap.demo.powerManager.controller;
import jp.bap.demo.powerManager.model.Contract;
import jp.bap.demo.powerManager.model.Staff;
import jp.bap.demo.powerManager.model.User;
import jp.bap.demo.powerManager.service.ContractService;
import jp.bap.demo.powerManager.service.StaffService;
import jp.bap.demo.powerManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ContractController {

    @Autowired
    ContractService contractService;
    @Autowired
    UserService userService;
    @Autowired
    StaffService staffService;
    @GetMapping("/Contract")
    List<Contract>get(){
        List<Contract> contracts = contractService.getContract();
        return contracts;
    }
    @PostMapping("/contract/post")
    Contract contract(@RequestBody Map<String,String>body) throws ParseException {
        String id = body.get( "idContract" );
        int idContact = Integer.parseInt( id );

        String endDate = body.get( "endDate" );
        DateFormat b = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = b.parse( endDate );
        String startDate =body.get( "startDate" );
        DateFormat c = new SimpleDateFormat( "yyy-MM-dd" );
        Date date1 = c.parse( startDate );
        String contractType = body.get( "contractType" );
        int contract1 = Integer.parseInt( contractType );
        String user1 = body.get( "idUsers" );
        int a = Integer.parseInt( user1 );
       User user =   userService.u( a );
       String idStaff = body.get( "idStaff" );
       int id1 = Integer.parseInt( idStaff );
        Staff staff = staffService.getId( id1 );
        Contract contract = new Contract(  );
        contract.setId( idContact );
        contract.setEndDate( date );
        contract.setSrartDate( date1 );
        contract.setContractType( contract1 );
        contract.setUser( user );
        contract.setStaff( staff );
       return contractService.save( contract );
    }
    @PutMapping("/contract/put/{id}")
    Contract contract(@PathVariable int id,@RequestBody Map<String, String>body) throws ParseException {
        String endDate = body.get( "endDate" );
        DateFormat b = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = b.parse( endDate );
        String startDate =body.get( "startDate" );
        DateFormat c = new SimpleDateFormat( "yyy-MM-dd" );
        Date date1 = c.parse( startDate );
        String contractType = body.get( "contractType" );
        int contract1 = Integer.parseInt( contractType );
        String user1 = body.get( "idUsers" );
        int a = Integer.parseInt( user1 );
        User user =   userService.u( a );
        String idStaff = body.get( "idStaff" );
        int id1 = Integer.parseInt( idStaff );
        Staff staff = staffService.getId( id1 );
        Contract contract = new Contract(  );
        contract.setId( id );
        contract.setEndDate( date );
        contract.setSrartDate( date1 );
        contract.setContractType( contract1 );
        contract.setUser( user );
        contract.setStaff( staff );
        return contractService.save( contract );
    }
    @DeleteMapping("/deleteContract/{id}")
    private void contract(@PathVariable int id) {
//     int d = Integer.parseInt( id );
        contractService.delete( id );
    }

}
