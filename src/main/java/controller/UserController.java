package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        userRepository.save(user);
        return user;

    }
    @GetMapping("/all-user")
    public List<User> getAllUser(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
    @PostConstruct
    public void saveUser(){
        User user = new User(1,"Mano","kalamarudur",22);
        userRepository.save(user);

    }
}
