package kz.lab9.User;

import kz.lab9.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import kz.lab9.Service.UserServiceImpl;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/create")
    public void createUserByUsernamePassword(String username,
                                             String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        UserService userService = null;
        userService.createUser(user);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        System.out.println("UserController.createUser");
        System.out.println("user = " + user);

        UserService userService = null;
        userService.createUser(user);
    }
    @GetMapping
    List<User> getUsers() {
        return userRepository.findAll();
    }



    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        UserService userService = null;
        userService.updateUser(id, user);
    }


    @DeleteMapping("courseId}/students/{studentId}")
    void deleteUser(@PathVariable Long id) {

    }
}
