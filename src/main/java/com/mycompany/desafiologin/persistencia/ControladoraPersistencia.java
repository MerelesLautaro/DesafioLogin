package com.mycompany.desafiologin.persistencia;

import com.mycompany.desafiologin.logica.Rol;
import com.mycompany.desafiologin.logica.Usuario;
import com.mycompany.desafiologin.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioController = new UsuarioJpaController();
    RolJpaController rolController  = new RolJpaController();
    
    public List<Usuario> traerUsuarios() {
        
        return usuarioController.findUsuarioEntities();
    }


    public void borrarUsuario(int num_usuario) {
        try {
            usuarioController.destroy(num_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Rol> traerRoles() {
        return rolController.findRolEntities();
    }

    public void crearUsuario(Usuario user) {
        usuarioController.create(user);
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuarioController.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usuarioEditable) {
        try {
            usuarioController.edit(usuarioEditable);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
