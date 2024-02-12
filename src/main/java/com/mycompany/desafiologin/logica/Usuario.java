package com.mycompany.desafiologin.logica;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario implements Serializable {
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE)
    //Estrategia de generacion de ID comentado debido a que la tabla ya tiene datos antes del mapeo (necesario para poder ingresar)
    private int id;
    private String nombre;
    private String contrasenia;
    
    //Relacion con la tabla Rol e indicamos mediante que columna se relaciona (fk_rol)
    @ManyToOne
    @JoinColumn(name="fk_rol")
    private Rol rol;
    //rol es el atributo que representa la relación Many-to-One entre un usuario y su rol asociado.
    
    public Usuario() {
    }

    public Usuario(int id, String nombre, String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
