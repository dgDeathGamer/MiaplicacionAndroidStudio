package com.example.myapplication.Modelo;

public class Usuario {

    private String Id;
    private String Nombre;
    private String Contraseña;
    private String Correo;

    public Usuario() {

    }

    public Usuario(String id, String nombre, String contraseña, String correo) {
        Id = id;
        Nombre = nombre;
        Contraseña = contraseña;
        Correo = correo;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
