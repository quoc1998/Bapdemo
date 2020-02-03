package jp.bap.demo.powerManager.controller;
import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.model.Contact;
import jp.bap.demo.powerManager.model.User;
import jp.bap.demo.powerManager.service.ConpanyService;
import jp.bap.demo.powerManager.service.ContactService;
import jp.bap.demo.powerManager.service.UserService;
import jp.bap.demo.powerManager.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ConpanyService conpanyService;
    @Autowired
    ContactService contactService;
    @Autowired
    UserServiceImpl userServiceimpl;

    @GetMapping("/user")
    List<User> get() {
        List<User> user = userService.getUser();
        return user;
    }



//    @PostMapping("/user")
//
//    private List<User> usere(@RequestBody Map<String,String>body) {
//        String name =body.get( "text" );
//        List<User> user = userService.list( name );
//        return user;
//    }


//
            @DeleteMapping("/user/delete/{id}")
    private void user(@PathVariable int id) {
//     int d = Integer.parseInt( id );
        userService.delete( id );
            }
//    @DeleteMapping(value = "/delete/{id}")
//    public  ResponseEntity<?> user(@PathVariable("id") String id) {
//        int v = Integer.parseInt( id );
//        userService.delete( v );
//        return ResponseEntity.ok(v);
//    }


    //
//            @GetMapping(value = "/sheck/{aa}")
//    private User user(@PathVariable("aa") String aa){
//        int a = Integer.parseInt( aa );
//        User users = userService.sheck( a );
//        return users;
//    }
    @GetMapping(value = "/search/{id}")
    public ResponseEntity<?> user1(@PathVariable("id") String id) {
        int a = Integer.parseInt( id );
        User usersw = userService.search( a );
        return ResponseEntity.ok( usersw );
    }

    @PostMapping(value = "/search")
    public ResponseEntity<?> user1(@RequestBody User user) {
        User users = userService.search( user.getId() );
        return ResponseEntity.ok( users );
    }


    @PostMapping("/user/{idCompany}/{idContact}")
    public User create(@RequestBody User user, @PathVariable String idCompany,
                       @PathVariable String idContact) {
        int a = Integer.parseInt( idCompany );
        int b = Integer.parseInt( idContact );
        Company company = conpanyService.get( a );
        Contact contact = contactService.get( b );
        user.setCompany( company );
        user.setContact( contact );
        return userService.save( user );

    }

    @PostMapping("/add")
    public User create(@RequestBody Map<String, String> body) {
        String idusers = body.get( "idusers" );
        int a = Integer.parseInt( idusers );
        String nameUsers = body.get( "nameUsers" );
        String idContac = body.get( "idContac" );

        int b = Integer.parseInt( idContac );

        String idCompany = body.get( "idCompany" );
        int c = Integer.parseInt( idCompany );

        Contact contact2 = contactService.get( b );
        Company company1 = conpanyService.get( c );

        User user = new User();
        user.setContact( contact2 );
        user.setCompany( company1 );
        user.setId( a );
        user.setName( nameUsers );

        User user1 = userService.save( user );
        return user1;
    }

    //
//    @PostMapping("/add")
//    public User create(@RequestBody User user,
//                       @RequestBody Map<String,String>body)
//    {
//        String v =body.get( "idCompany" );
//        String vv = body.get( "idContact" );
//        int company = Integer.parseInt( v );
//        int contact = Integer.parseInt( vv );
//        Company company1 = conpanyService.get( company );
//        Contact contact2 = contactService.get(contact );
//        user.setCompany( company1 );
//        user.setContact( contact2 );
//        User user1 = userService.save( user );
//        return user1;
//    }
    @PutMapping("/put/{id}/{idCompany}/{idContact}")
    public User d(@PathVariable String id,
                  @PathVariable String idCompany,
                  @PathVariable String idContact
            , @RequestBody User user) {
        int aa = Integer.parseInt( id );
        user.setId( aa );
        int a = Integer.parseInt( idCompany );
        int b = Integer.parseInt( idContact );
        Company company = conpanyService.get( a );
        Contact contact = contactService.get( b );
        user.setCompany( company );
        user.setContact( contact );
        User qc = userService.put( user );
        return qc;
    }

    @GetMapping("orderBy/{name}")
    private List<User> cv(@PathVariable int name) {
        List<User> user = userService.se( name );
        return user;
    }

    @GetMapping("c/{id}")
    private List<User> cx(@PathVariable int id) {
        List<User> users = userService.findById( id );
        return users;
    }

    //    @GetMapping("/user/a/{id}")
//    public Optional<UserLimited> getUser(@PathVariable int id) {
//        return userServiceimpl.getUserRepository().getById(id);
//    }
//    @GetMapping("/user")
//    Optional<UserLimited> vcd() {
//        Optional<UserLimited> vdv = userServiceimpl.getUserRepository().
//        return user;
//    }
    @GetMapping("/user/a/{id}")
    public Optional<UserLimited> getUser(@PathVariable int id) {
        return userServiceimpl.getUserRepository().getById( id );
    }
}