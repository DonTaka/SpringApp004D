package com.example.SpringApp004D.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String username;
    private String password;
    private String email;


}
