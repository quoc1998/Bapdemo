package jp.bap.demo.powerManager.service;

import jp.bap.demo.powerManager.model.Contact;
import jp.bap.demo.powerManager.repository.ContactRepository;

import java.util.List;

public interface ContactService {
    List<Contact>getconcat();
    Contact get(int id);
    Contact save(Contact contact);
    Contact put(Contact contact);
    ContactRepository getcontactRepository();



}
