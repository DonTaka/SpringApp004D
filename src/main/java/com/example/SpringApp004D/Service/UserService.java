package com.example.SpringApp004D.Service;

import com.example.SpringApp004D.Model.Usuario;
import com.example.SpringApp004D.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Usuario addUser(Usuario user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public Usuario getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public Usuario updateUser(int id, Usuario user) {
        Usuario us =  userRepository.findById(id).get();
        us.setUsername(user.getUsername());
        us.setPassword(user.getPassword());
        us.setEmail(user.getEmail());
        userRepository.save(us);
        return us;
    }
}
