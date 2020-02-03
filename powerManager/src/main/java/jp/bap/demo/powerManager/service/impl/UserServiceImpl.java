package jp.bap.demo.powerManager.service.impl;

import jp.bap.demo.powerManager.model.User;
import jp.bap.demo.powerManager.repository.UserRepository;
import jp.bap.demo.powerManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> list(String id) {
        return userRepository.findAllByNameContaining( id );
    }

    @Override
    public User save(User user) {
        User user1 =new User(  );
        user1.setId( user.getId() );
         user1.setName( user.getName() );
         user1.setContact( user.getContact() );
         user1.setCompany( user.getCompany() );
        return userRepository.save( user1 );
    }

    @Override
    public User put(User user) {
        return userRepository.save( user );
    }

    @Override
    public void delete(int id) {

        userRepository.deleteById( id );
    }

    @Override
    public User search(int aa) {

        return userRepository.findById(aa);
    }

    @Override
    public List<User> se(int name) {
        return userRepository.findAllOrOrderByNameAsc( name );
    }

    @Override
    public List<User> findById(int id) {
        return userRepository.findByIds( id );
    }

    @Override
    public User u(int id) {
        return userRepository.findById(id);
    }

    public UserRepository getUserRepository(){
        return userRepository;
    }


}
