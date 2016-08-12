package userService;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private Set<User> users = new HashSet<>();

    public boolean add(User user) {

        return users.add(user);
    }

    public Set<User> get() {

        return users;
    }

    public boolean remove(User user) {

        return users.remove(user);
    }

    public boolean cleanup() {

        try{
            users.clear();
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
}
