package DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Ternera;


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
	public List<Ternera> obtenerTodasTerneras(){
    	List<Ternera> enf = null;
    	enf =   em.createNamedQuery("Ternera.obtenerTodasTerneras").getResultList();
		 return enf;
	}
    

    public Ternera obtenerTerneraNroCaravana(long nroCaravana) {
    	Ternera tenera = null;
     
    	 Query query =  em.createNamedQuery("Ternera.obtenerTerneraNroCaravana");
    	 query.setParameter("nroCaravana", nroCaravana);

    	 tenera =   (Ternera) query.getSingleResult();

	    return tenera;
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
