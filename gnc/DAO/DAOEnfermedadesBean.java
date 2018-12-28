package DAO;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import entidades.Enfermedad;
import excepciones.EnfermedadException;
import excepciones.TerneraEnfermaException;


/**
 * Session Bean implementation class DAOEnfermedadBea
 */
@Stateless
@LocalBean
public class DAOEnfermedadesBean {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DAOEnfermedadesBean() {
        // TODO Auto-generated constructor stub
    }
    /**
     * Crear una nueva enfermedad
     * @param enfermedad
     * @throws EnfermedadException 
     */
    public void crearEnfermedad(Enfermedad enfermedad) throws EnfermedadException{
    	try {
	    	em.persist(enfermedad);
	    	em.flush();
    	}
		catch(PersistenceException e){
			
	    	throw new EnfermedadException("Ha ocurrido un error al obtener la enfermedad");
	    } 
    }
    /**
     * Elimina una enfermedad
     * @param enfermedad
     * @throws TerneraEnfermaException 
     */
    public void eliminarEnfermedad(Enfermedad enfermedad) throws TerneraEnfermaException{	
    	try {
		   	 em.remove(em.merge(enfermedad));
		     em.flush();
    	}
		catch(PersistenceException e){
			
	    	throw new TerneraEnfermaException("Ha ocurrido un error al Eliminar la enfermedad");
	    } 

    }
	/***
	 * Obtengo un listado de todas las enfermedades
	 * @return
	 * @throws TerneraEnfermaException 
	 */
	@SuppressWarnings("unchecked")
	public List<Enfermedad> obtenerTodasEnfermedades() throws TerneraEnfermaException{
		try {
			List<Enfermedad> enf = null;
	    	enf =   em.createNamedQuery("Enfermedad.findAllEnfermedades").getResultList();
			return enf;
		}catch(PersistenceException e){
			
	    	throw new TerneraEnfermaException("Ha ocurrido un error al obtener la enfermedades");
	    } 

	}
	
	/**
	 * Valida que exista la enfermedad
	 * @param enfermedad
	 * @return
	 * @throws TerneraEnfermaException 
	 */
    public boolean existeEnfermedad( Enfermedad enfermedad) throws TerneraEnfermaException {
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	 Query query =  em.createNamedQuery("Enfermedad.findExisteEnfermedad");
    	 query.setParameter("nombre", enfermedad.getNombre());
    	 query.setParameter("gradoGravedad", enfermedad.getGradoGravedad());

    	 cont =   ((Number)query.getSingleResult()).intValue();
    	 try {
	    	 if(cont > 0){
		    	
		    	existe = true;
		    }
    	 }
    	 catch(PersistenceException e){
 			
 	    	throw new TerneraEnfermaException("Ha ocurrido un error al obtener existe enfermedad");
 	    } 
	    return existe;
    }
    
    /**
     * Para aplicacion Escritorio 2017
     * @param idEnfermedad
     * @return
     * @throws TerneraEnfermaException 
     */
    public Enfermedad obtenerEnfermedadId(long idEnfermedad) throws TerneraEnfermaException {
    	Enfermedad enfermedad = null;
     
    	 Query query =  em.createNamedQuery("Enfermedad.obtenerEnfermedadId");
    	 query.setParameter("idEnfermedad", idEnfermedad);
    	 
    	 try {
    		 enfermedad =   (Enfermedad) query.getSingleResult();
    	 }    	  
    	 catch(PersistenceException e){
 			
 	    	throw new TerneraEnfermaException("Ha ocurrido un error al obtener la enfermedades");
 	    } 
    	 

	    return enfermedad;
    }
    
    /***
     * Para Aplicacion Mobil y web
     * @param idEnfermedad
     * @return
     * @throws TerneraEnfermaException 
     */
    public Enfermedad findEnfermedadId(Long idEnfermedad) throws TerneraEnfermaException {
    	try {
    		return em.find(Enfermedad.class, idEnfermedad);
    	}
    	catch(PersistenceException e){
  			
  	    	throw new TerneraEnfermaException("Ha ocurrido un error al obtener la enfermedades");
  	    } 
    	
    }
    
    
}
