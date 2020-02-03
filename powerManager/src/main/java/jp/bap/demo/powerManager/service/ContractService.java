package jp.bap.demo.powerManager.service;

import jp.bap.demo.powerManager.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract>getContract();
    Contract save(Contract contract);
    void delete(int id);

}
