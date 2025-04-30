package com.example.SpringApp004D.Repository;

import com.example.SpringApp004D.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {

    }

    public String getAllUsers() {
        String output ="";
        for(User temp:users) {
            output += "Id del usuario: " + temp.getId() + "\n";
            output += "username: " + temp.getUsername() + "\n";
            output += "password: " + temp.getPassword() + "\n";
            output += "email: " + temp.getEmail()+"\n \n";

        }
        if(output.isEmpty()){
            return "No se encuentran usuarios";
        }else{
            return output;
        }
    }

    //findById
    public String getUser(int id){
        String output ="";
        for(User temp:users) {
            if (temp.getId() == id) {
                output += "Id del usuario: " + temp.getId()+"\n";
                output += "username: " + temp.getUsername()+"\n";
                output += "password: " + temp.getPassword()+"\n";
                output += "email: " + temp.getEmail()+"\n \n";
                return output;
            }
        }
        return "Usuario no existe";
    }

    //Agregar un usuario
    public String addUser(User user){
        users.add(user);
        return "Usuario agregado con exito";

    }

    public String removeUser(int id){
        for(User temp:users){
            if(temp.getId() == id){
                users.remove(temp);
                return "Usuario removido con exito";
            }
        }
        return "Usuario no encontrado";
    }

    public String updateUser (int id,User user){
        int index = 0;
        for(User temp:users){
            if(temp.getId() == id){
                //SET
                index = users.indexOf(temp);
            }
        }
        if(index == -1){
            return "Usuario no  encontrado";
        }else{
            users.set(index, user);
            return "Usuario actualizado con exito";
        }
    }
}
