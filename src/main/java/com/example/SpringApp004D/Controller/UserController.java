package com.example.SpringApp004D.Controller;


import com.example.SpringApp004D.Model.User;
import com.example.SpringApp004D.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User user){
        return  userService.updateUser(id,user);
    }

}
