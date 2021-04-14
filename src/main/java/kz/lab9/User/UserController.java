package kz.lab9.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("courseId}/students/{studentId}")
    void replaceUser(@RequestBody User newUser, @PathVariable Long id) {


    }

    @DeleteMapping("courseId}/students/{studentId}")
    void deleteUser(@PathVariable Long id) {

    }
}
