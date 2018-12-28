package DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import entidades.Ternera;
import excepciones.EnfermedadException;
import excepciones.TerneraException;


/**
 * Session Bean implementation class DAOTerneras
 */
@Stateless
@LocalBean
public class DAOTernerasBean {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DAOTernerasBean() {
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("unchecked")
	public List<Ternera> obtenerTodasTerneras() throws TerneraException{
    	List<Ternera> enf = null;
    	try {
	    	
	    	enf =   em.createNamedQuery("Ternera.obtenerTodasTerneras").getResultList();
			 return enf;
	    }
		catch(PersistenceException e){
			
	    	throw new TerneraException("Ha ocurrido un error al obtener las terneras");
	    } 
	}
    

    public Ternera obtenerTerneraNroCaravana(long nroCaravana) throws TerneraException {
    	Ternera tenera = null;
    	try {
	    	
	     
	    	 Query query =  em.createNamedQuery("Ternera.obtenerTerneraNroCaravana");
	    	 query.setParameter("nroCaravana", nroCaravana);
	
	    	 tenera =   (Ternera) query.getSingleResult();
	
		    return tenera;
	    }
		catch(PersistenceException e){
			
	    	throw new TerneraException("Ha ocurrido un error al obtener las terneras");
	    } 
    }
	public Ternera obtenerTerneraId(long idTernera) {
		Ternera ternera = null;
		try {
		   	Query query =  em.createNamedQuery("Ternera.obtenerTerneraId");
		   	query.setParameter("idTernera", idTernera);
		
		   	ternera = (Ternera) query.getSingleResult();
	
		    return ternera;
		 } catch (NoResultException e) {
 			return null;
		 }

	}
   
	
    /***
     * Para Aplicacion Mobil y web
     * @param idEnfermedad
     * @return
     */
    public Ternera findTerneraId(Long idTernera) {
    	return em.find(Ternera.class, idTernera);
    }
}
