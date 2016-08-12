package userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public Set<User> getUsers() {
        return userService.get();
    }

    @RequestMapping("/cleanup")
    public boolean cleanupUsers() {
        return userService.cleanup();
    }

    @RequestMapping("/add/{name}")
    public boolean addUser(@PathVariable("name") String name) {
        return userService.add(new User(name));
    }

    @RequestMapping("/remove/{name}")
    public boolean removeUser(@PathVariable("name") String name) {
        return userService.remove(new User(name));
    }

}