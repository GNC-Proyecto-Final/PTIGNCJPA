package DAO;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Enfermedad;


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
     */
    public void crearEnfermedad(Enfermedad enfermedad){
    	
    	em.persist(enfermedad);
    	em.flush();
    }
    /**
     * Elimina una enfermedad
     * @param enfermedad
     */
    public void eliminarEnfermedad(Enfermedad enfermedad){	
    	
   	 em.remove(em.merge(enfermedad));
     em.flush();

    }
	/***
	 * Obtengo un listado de todas las enfermedades
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Enfermedad> obtenerTodasEnfermedades(){
    	List<Enfermedad> enf = null;
    	enf =   em.createNamedQuery("Enfermedad.findAllEnfermedades").getResultList();
		 return enf;
	}
	
	/**
	 * Valida que exista la enfermedad
	 * @param enfermedad
	 * @return
	 */
    public boolean existeEnfermedad( Enfermedad enfermedad) {
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	 Query query =  em.createNamedQuery("Enfermedad.findExisteEnfermedad");
    	 query.setParameter("nombre", enfermedad.getNombre());
    	 query.setParameter("gradoGravedad", enfermedad.getGradoGravedad());

    	 cont =   ((Number)query.getSingleResult()).intValue();
    	 
    	 if(cont > 0){
	    	
	    	existe = true;
	    }
	    return existe;
    }
    
    /**
     * Para aplicacion Escritorio 2017
     * @param idEnfermedad
     * @return
     */
    public Enfermedad obtenerEnfermedadId(long idEnfermedad) {
    	Enfermedad enfermedad = null;
     
    	 Query query =  em.createNamedQuery("Enfermedad.obtenerEnfermedadId");
    	 query.setParameter("idEnfermedad", idEnfermedad);

    	 enfermedad =   (Enfermedad) query.getSingleResult();

	    return enfermedad;
    }
    
    /***
     * Para Aplicacion Mobil y web
     * @param idEnfermedad
     * @return
     */
    public Enfermedad findEnfermedadId(Long idEnfermedad) {
    	return em.find(Enfermedad.class, idEnfermedad);
    }
    
}
