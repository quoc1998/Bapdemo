package jp.bap.demo.powerManager.service.impl;

import jp.bap.demo.powerManager.model.Contact;
import jp.bap.demo.powerManager.repository.ContactRepository;
import jp.bap.demo.powerManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Override
    public List<Contact> getconcat() {
        return contactRepository.findAll();
    }

    @Override
    public Contact get(int id) {
        return contactRepository.findById( id );
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save( contact );
    }

    @Override
    public Contact put(Contact contact) {
        return contactRepository.save( contact );
    }

    @Override
    public ContactRepository getcontactRepository() {
        return getContactRepository();
    }

    public ContactRepository getContactRepository() {
        return contactRepository;
    }


}
