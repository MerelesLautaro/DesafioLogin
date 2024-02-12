package com.mycompany.desafiologin.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol implements Serializable {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //Estrategia de generacion de ID comentado debido a que la tabla ya tiene datos antes del mapeo (necesario para poder ingresar)
    private int id;
    private String nombreRol;
    private String descripcion;
    
    //Relacion con la tabla Usuario e indicamos el nombre del atributo con el que se relaciona
    @OneToMany(mappedBy="rol")
    private List<Usuario> listaUsuarios;
    //La lista de usuarios representa la relacion entre un rol y la lista de usuarios asociados (un rol puede estar en muchos usuarios)
    
    public Rol() {
    }

    public Rol(int id, String nombreRol, String descripcion, List<Usuario> listaUsuarios) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
