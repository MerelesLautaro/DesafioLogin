package com.mycompany.desafiologin.persistencia;

import com.mycompany.desafiologin.logica.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioController = new UsuarioJpaController();
    
    public List<Usuario> traerUsuarios() {
        
        return usuarioController.findUsuarioEntities();
    }
    
}
