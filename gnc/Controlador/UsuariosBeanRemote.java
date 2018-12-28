package Controlador;

import javax.ejb.Remote;

import entidades.Usuario;
import excepciones.UsuarioException;

@Remote
public interface UsuariosBeanRemote {
	boolean validarUsuario(String user, String password) throws UsuarioException;
	Usuario obtenerUsuario(String user,String password);
}
