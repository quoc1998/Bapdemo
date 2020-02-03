package jp.bap.demo.powerManager.service.impl;

import jp.bap.demo.powerManager.model.Contract;
import jp.bap.demo.powerManager.repository.ContractRepository;
import jp.bap.demo.powerManager.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;


    @Override
    public List<Contract> getContract() {
        return contractRepository.findAll();
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save( contract );
    }

    @Override
    public void delete(int id) {
        contractRepository.deleteById( id );
    }
}
