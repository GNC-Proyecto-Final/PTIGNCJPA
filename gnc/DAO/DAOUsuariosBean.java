package DAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import entidades.Usuario;
import excepciones.TerneraEnfermaException;
import excepciones.UsuarioException;


/**
 * Session Bean implementation class DAOUsuariosBean
 */
@Stateless
@LocalBean
public class DAOUsuariosBean {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DAOUsuariosBean() {
        // TODO Auto-generated constructor stub
    }
    public boolean usuarioValido(String user, String password) throws UsuarioException{
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	 Query query =  em.createNamedQuery("Usuario.usuarioValido");
    	 query.setParameter("usuario", user);
    	 query.setParameter("contrasenia", password);

    	 cont =   ((Number)query.getSingleResult()).intValue();
    	 try {
    		 
	    	 if(cont > 0){
		    	
		    	existe = true;
		    }
		}catch(PersistenceException e){
	    	throw new UsuarioException("Ha ocurrido un error al obtener el usuario");
	    }
	    return existe;
    }
    public Usuario obtenerUsuario(String user, String password) {
    	Usuario usuario = null;
    	try {
	    	 Query query =  em.createNamedQuery("Usuario.usuarioLogin");
	    	 query.setParameter("usuario", user);
	    	 query.setParameter("contrasenia", password);

	    	 usuario =   (Usuario) query.getSingleResult();
	    	
	    	//usuario.getGuacheras().size();
    		 return usuario;
    	 } catch (NoResultException e) {
    			return null;
    	}
    		  
    	
    }
}
