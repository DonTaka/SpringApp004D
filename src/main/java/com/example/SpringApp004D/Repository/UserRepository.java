package com.example.SpringApp004D.Repository;

import com.example.SpringApp004D.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {

    }

    public String getUser(String username){
        String output ="";
        for(User temp:users){
            if(temp.getUsername().equalsIgnoreCase(username)){
                output += "username: "+temp.getUsername();
                output += "password: "+temp.getPassword();
                output += "email: "+temp.getEmail();
                return output;
            }
        }
        return "Usuario no existe";
    }

    //Agregar un usuario
    public void addUser(User user){
        users.add(user);
        System.out.println("Usuario agregado con exito");

    }

    public void removeUser(String username){
        for(User temp:users){
            if(temp.getUsername().equalsIgnoreCase(username)){
                users.remove(temp);
                System.out.println("Usuario removido con exito");
                break;
            }
        }
        System.out.println("Usuario no encontrado");;
    }

    public void updateUser (User user){
        for(User temp:users){
            if(temp.getUsername().equalsIgnoreCase(user.getUsername())){
                //SET
                int index = users.indexOf(temp);
                users.set(index, user);
                System.out.println("Usuario actualizado con exito");
                break;
            }
        }
        System.out.println("Usuario no encontrado");
    }
}
