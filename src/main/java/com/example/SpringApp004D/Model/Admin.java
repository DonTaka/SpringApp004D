package com.example.SpringApp004D.Model;

public class Admin extends User{
    private String permisos;

    public Admin(){

    }
    public Admin(String username, String password, String email, String permisos) {
        super(username, password, email);
        this.permisos = permisos;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
}
