package jp.bap.demo.powerManager.service;

import jp.bap.demo.powerManager.model.User;

import java.util.List;

public interface UserService {
    List<User>getUser();
   List<User>list(String id);
    User save(User user);
    User put(User user);
    void delete(int id);
    User search(int aa);
   List<User>se(int name);
  List<User> findById(int id);
  User u(int id);


}
