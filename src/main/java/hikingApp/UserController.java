package hikingApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //index
    @GetMapping("/users")
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    //show
    @GetMapping("/users/{id}")
    public HashMap<String, Object> findUser(@PathVariable("id") Long id)throws Exception{
        Optional<User> response = userRepository.findById(id);
        if(response.isPresent()){
            User user = response.get();
            HashMap<String, Object> result = new HashMap<>();
            result.put("user", user);
            return result;
        }
        throw new Exception("No such user");
    }

    //register
    @PostMapping("/users")
    public User createUser(@RequestBody User user, HttpSession session){
        User createdUser = userService.saveUser(user);
        if(createdUser != null){
            session.setAttribute("username", createdUser.getUsername());
        }
        return createdUser;
    }

    //remove
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "deleted user " + id;
    }

    //update
    @PutMapping("/users/{id}")
    public User editUser(@PathVariable("id") Long id, @RequestBody User formData) throws Exception{
        Optional<User> editUser = userRepository.findById(id);
        if(editUser.isPresent()){
            User user = editUser.get();
            user.setUsername(formData.getUsername());
            user.setPassword(formData.getPassword());
            return userRepository.save(user);
        }
        throw new Exception("no such user");
    }

    //login
    @PostMapping("/login")
    public User login(@RequestBody User login, HttpSession session) throws Exception {
        User user = userRepository.findByUsername(login.getUsername());
        if(user ==  null){
            throw new IOException("Invalid Credentials");
        }
        boolean valid = bCryptPasswordEncoder.matches(login.getPassword(), user.getPassword());
        if(valid){
            session.setAttribute("username", user.getUsername());
            return user;
        }else{
            throw new Exception("Invalid Credentials");
        }
    }







}