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
    public void crearEnfermedad(Enfermedad enfermedad){
    	
    	em.persist(enfermedad);
    	em.flush();
    }
    public void eliminarEnfermedad(Enfermedad enfermedad){	
    	
   	 em.remove(em.merge(enfermedad));
     em.flush();

    }
	
	@SuppressWarnings("unchecked")
	public List<Enfermedad> obtenerTodasEnfermedades(){
    	List<Enfermedad> enf = null;
    	enf =   em.createNamedQuery("Enfermedad.findAllEnfermedades").getResultList();
		 return enf;
	}
	
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
    public Enfermedad obtenerEnfermedadId(long idEnfermedad) {
    	Enfermedad enfermedad = null;
     
    	 Query query =  em.createNamedQuery("Enfermedad.obtenerEnfermedadId");
    	 query.setParameter("idEnfermedad", idEnfermedad);

    	 enfermedad =   (Enfermedad) query.getSingleResult();

	    return enfermedad;
    }
    
}
