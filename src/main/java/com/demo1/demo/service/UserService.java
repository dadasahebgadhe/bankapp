package com.demo1.demo.service;
import com.demo1.demo.exception.ResourceNotFound;
import com.demo1.demo.model.entity.Account;
import com.demo1.demo.repository.UserRepository;
import com.demo1.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFound(" user not found with id " + id));
    }
    // public List<User> getUsers(){
    //  return userRepository.findAll();

    public User updateUser(User user) {
        User olduser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFound(" user not found with id "));
        if (olduser != null) {
            olduser.setName(user.getName());
            olduser.setEmail(user.getEmail());
            olduser.setMobileNumber(user.getMobileNumber());
            olduser.setSecondaryNumber(user.getSecondaryNumber());
            olduser.setMobileNumber(user.getMobileNumber());
            return userRepository.save(user);
        }
        return userRepository.save(new User());
    }

    public ResponseEntity<String> deleteById(Long id) {
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
            return ResponseEntity.status(HttpStatus.OK).build();
    }
}

