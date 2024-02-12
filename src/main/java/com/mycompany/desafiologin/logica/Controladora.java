package com.mycompany.desafiologin.logica;

import com.mycompany.desafiologin.persistencia.ControladoraPersistencia;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;

public class Controladora {
    //instancia de la controladora de persistencia
    ControladoraPersistencia controladora;
    
    public Controladora(){
        controladora = new ControladoraPersistencia();
    }
    
    public Usuario validarUsuario(String usuario, String password) {
        //Traemos la lista de usuarios de la DB
        List<Usuario> listaUsuarios = controladora.traerUsuarios();
        
        //Inicializamos el objeto usuario
        Usuario user = null;
      
        //Por cada usuario de mi lista de usuarios compruebo si el usuario y contrasenia ingresado existen.
        for (Usuario usuarios : listaUsuarios){
            //Comprobamos si el nombre de usuario ingresado en el login por el usuario existe.
            if(usuarios.getNombre().equals(usuario)){
                //Si el usuario ingresado existe comprobamos si concuerda con la contrasenia ingresada.
                if(usuarios.getContrasenia().equals(password)){
                    user = usuarios;
                    return user;
                } 
                //Si el nombre de usuario existe pero la contrasenia no concuerda retornamos null
                else {
                    user = null;
                    return user;

                }
            } 
            //Si no existe el nombre de usuario ingresado por el usuario retornamos null
            else {
                user = null;

            }
        }
        //Si no se cumple ninguna condicion (nombre y contrasenia que no existen o no son validos) retornamos null
        return user;
    }

    public List<Usuario> cargarDatosUsuarios() {
        return controladora.traerUsuarios();
    }

    public void borrarUsuario(int num_usuario) {
        controladora.borrarUsuario(num_usuario);
    }

    public List<Rol> traerRoles() {
        return controladora.traerRoles();
    }

    public void crearUsuario(String nombre, String password, String nombreRol) {
        Usuario user = new Usuario();
        //Seteamos los valores ingresados por el usuario en nuestro objeto user
        user.setNombre(nombre);
        user.setContrasenia(password);
        
        //Instanciamos nuestra clase rol
        Rol rol = new Rol();
        //ejecutamos el metodo traerRol en la misma controladora usamos this.
        rol = this.traerRol(nombreRol);
        //Si lo que nos retorna el metodo es diferente a null seteamos el rol en nuestro objeto user
        if(rol!=null){
            user.setRol(rol);
        }
        
        //Llamamos al metodo buscarUltimaId (this / ya se encuentra en esta misma clase controladora) y guardamos el valor
        int id = this.buscarUltimaId();
        //Le asignamos la ID al usuario creado debido a que no tenemos estrategia de generacion en el mapeo, le aumentamos el valor obtenido en +1
        //debido a que en el metodo  buscarUltimaId obtenemos el valor mediante .size()-1 que nos retorna el valor del ultimo elemento de la lista
        //de tal manera que evitamos tener ID's repetidas y evitar errores.
        user.setId(id+1);
    
        controladora.crearUsuario(user);
        
    }

    private Rol traerRol(String nombreRol) {
        //Obtengo una lista de todos los roles ejecutando el metodo traerRoles en la misma clase de controladora (this.)
        List<Rol> listaRol = this.traerRoles();
        
        //Lista de roles existentes.
        for(Rol rol:listaRol){
            //Si el rol que nos paso el usuario esta, retornamos el rol completo.
            if(rol.getNombreRol().equals(nombreRol))
                return rol;
        }
        //Si no se encuentra retorna null
        return null;
    }

    private int buscarUltimaId() {
        List<Usuario> listaUsuarios = this.cargarDatosUsuarios();
        
        Usuario user = listaUsuarios.get(listaUsuarios.size()-1);
        return user.getId();
        
    }

    public Usuario traerUsuario(int id_usuario) {
        return controladora.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usuarioEditable, String nombre, String password, String nombreRol) {
        usuarioEditable.setNombre(nombre);
        usuarioEditable.setContrasenia(password);
        
        Rol rol = new Rol();
        rol = this.traerRol(nombreRol);
        if(rol!=null){
            usuarioEditable.setRol(rol);
        }
        
        controladora.editarUsuario(usuarioEditable);
        
    }
      
}
