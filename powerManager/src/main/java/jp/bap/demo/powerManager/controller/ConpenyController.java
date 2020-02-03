package jp.bap.demo.powerManager.controller;

import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.model.Contact;
import jp.bap.demo.powerManager.service.ConpanyService;
import jp.bap.demo.powerManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConpenyController {
    @Autowired
    ConpanyService conpanyService;
    @Autowired
    ContactService contactService;
    @GetMapping("/vv")
    List<Company>getlist(){
        List<Company>  a = conpanyService.get();
        return a;
    }

    @PostMapping("/Conpany/post")
    Company company(@RequestBody Map<String,String> body){
        String ConpanyId = body.get( "id" );
        int Conpany = Integer.parseInt( ConpanyId );
        String name = body.get( "name" );
        String idContact = body.get( "idContact" );
        int id = Integer.parseInt( idContact );
        Contact contact = contactService.get( id );
        Company company1 = new Company(  );
        company1.setIdCompany( Conpany );
        company1.setName( name );
        company1.setContact( contact );
      return conpanyService.save( company1 );
    }
    @PutMapping("/conpany/put/{id}")
    Company company(@PathVariable int id,@RequestBody Map<String,String>body ){
        String name = body.get( "name" );
        String idContact = body.get( "idContact" );
            Contact contact = contactService.get( id );
            Company company = new Company(  );
            company.setIdCompany( id );
            company.setName( name );
            company.setContact( contact );
            Company company1=  conpanyService.put( company );
            return company1;
    }
//    @DeleteMapping("/deleteConpeny/{id}")
//    public boolean deleteCompany(@PathVariable int id){
//        Company company =conpanyService.getconpenyRepository().getOne( id );
//        company.setContact( null );
//        conpanyService.getconpenyRepository().delete( company );
//        return true;
//    }
    @DeleteMapping("/deleteconpeny/{id}")
    public boolean delete(@PathVariable int id){
        Company company =conpanyService.getconpenyRepository().getOne( id );
        conpanyService.getconpenyRepository().delete( company );
        return true;
    }

}
