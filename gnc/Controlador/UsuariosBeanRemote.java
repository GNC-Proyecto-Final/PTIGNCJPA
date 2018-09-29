package Controlador;

import javax.ejb.Remote;

@Remote
public interface UsuariosBeanRemote {
	boolean validarUsuario(String user, String password);
}
