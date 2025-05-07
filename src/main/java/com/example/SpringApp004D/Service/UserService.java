package com.example.SpringApp004D.Service;

import com.example.SpringApp004D.Model.User;
import com.example.SpringApp004D.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(User user) {
        return userRepository.addUser(user);
    }

    public String deleteUser(int id) {
        return userRepository.removeUser(id);
    }

    public String getAllUsers() {
        return userRepository.getAllUsers();
    }

    public String getUserById(int id) {
        return userRepository.getUser(id);
    }

    public String updateUser(int id, User user) {
        return userRepository.updateUser(id, user);
    }
}
