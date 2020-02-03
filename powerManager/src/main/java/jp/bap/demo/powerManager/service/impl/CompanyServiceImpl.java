package jp.bap.demo.powerManager.service.impl;

import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.repository.ConpenyRepository;
import jp.bap.demo.powerManager.repository.ContactRepository;
import jp.bap.demo.powerManager.service.ConpanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ConpanyService {
    @Autowired
    ConpenyRepository conpenyRepository;


    @Override
    public List<Company> get() {
        return conpenyRepository.findAll();
    }

    @Override
    public Company get(int id) {
        return conpenyRepository.findById( id );
    }

    @Override
    public Company save(Company company) {
        return conpenyRepository.save( company );
    }

    @Override
    public Company put(Company company) {
        return conpenyRepository.save( company );
    }

    @Override
    public ConpenyRepository getconpenyRepository() {
        return getCompanyRepository();
    }


    public ConpenyRepository getCompanyRepository() {
        return conpenyRepository;
    }
    public void setCompanyRepository(ConpenyRepository companyRepository) {
        this.conpenyRepository = companyRepository;
    }

//    @Override
//    public boolean delete(int id){
//        conpenyRepository.deleteById( id );
//        getcontactRepository().findContactByCompanies( company ).setCompanies( null );
//
//    }
//
//    Company company =conpanyService.getconpenyRepository().getOne( id );
//    contactService.getcontactRepository().findContactByCompanies( company ).setCompanies( null );
//        conpanyService.getconpenyRepository().delete( company );
//        return true;
//    @Override
//    public Company c(Company company) {
//        Company company1 = new Company(  );
//        company1.setIdCompany( company.getIdCompany() );
//        company1.setName( company.getName() );
//        return conpenyRepository.save( company1 );
//    }
}
