package com.mycompany.desafiologin.logica;

import com.mycompany.desafiologin.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controladora;
    
    public Controladora(){
        controladora = new ControladoraPersistencia();
    }
    
    public String validarUsuario(String usuario, String password) {
        List<Usuario> listaUsuarios = controladora.traerUsuarios();
        
        String mensaje = "";
        
        for (Usuario usuarios : listaUsuarios){
            if(usuarios.getNombre().equals(usuario)){
                if(usuarios.getContraseña().equals(password)){
                    mensaje = "Usuario Correcto";
                } else {
                    mensaje = "Contraseña incorrecta";
                }
            } else {
                mensaje = "Usuario incorrecto";
            }
        }
        return mensaje;
    }
    
    
}
