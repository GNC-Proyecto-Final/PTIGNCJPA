package Controlador;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import DAO.DAOUsuariosBean;
import entidades.Usuario;

/**
 * Session Bean implementation class UsuariosBean
 */
@Stateless
@LocalBean
public class UsuariosBean implements UsuariosBeanRemote {
	@EJB
	DAOUsuariosBean daoUsuariosBean;
    /**
     * Default constructor. 
     */
    public UsuariosBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean validarUsuario(String user, String password){
    	boolean usuario = daoUsuariosBean.usuarioValido(user, password);
		if(usuario == false)
			return false;
		else
			return true;
    	
    }
    
    @Override
    public Usuario obtenerUsuario(String user,String password){
		return daoUsuariosBean.obtenerUsuario(user, password);
	}
}
