package jp.bap.demo.powerManager.repository;

import jp.bap.demo.powerManager.controller.UserLimited;
import jp.bap.demo.powerManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
   List<User>findAllByNameContaining(String name);
  User findById(int id);
   @Query(nativeQuery = true,
            value = "SELECT * FROM user  ORDER BY name asc limit :s ")
     List<User>findAllOrOrderByNameAsc(@Param( "s" )int s);
   @Query(nativeQuery = true,
   value ="select *from user where id>:id" )
   List<User> findByIds(@Param("id") int id);

//    @Query("SELECT e FROM User e WHERE e.id = ?1")
//    Optional<?>findById();
    @Query(value = "SELECT * FROM user  WHERE id =?1", nativeQuery = true)
    Optional<UserLimited> getById(int id);

}
