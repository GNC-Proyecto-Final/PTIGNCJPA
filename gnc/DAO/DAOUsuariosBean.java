package DAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


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
    public boolean usuarioValido(String user, String password){
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	 Query query =  em.createNamedQuery("Usuario.usuarioValido");
    	 query.setParameter("usuario", user);
    	 query.setParameter("contrasenia", password);

    	 cont =   ((Number)query.getSingleResult()).intValue();
    	 
    	 if(cont > 0){
	    	
	    	existe = true;
	    }
	    return existe;
    }
}