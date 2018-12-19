package Controlador;

import javax.ejb.Remote;

import entidades.Usuario;

@Remote
public interface UsuariosBeanRemote {
	boolean validarUsuario(String user, String password);
	Usuario obtenerUsuario(String user,String password);
}
