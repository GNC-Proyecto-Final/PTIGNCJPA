package DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.EnfermedadTernera;
import entidades.EnfermedadTerneraPK;

/**
 * Session Bean implementation class DAOEnfermedadTerneraBean
 */
@Stateless
@LocalBean
public class DAOEnfermedadTernerasBean {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DAOEnfermedadTernerasBean() {
        // TODO Auto-generated constructor stub
    }
    /**
     * Crea una Ternera Enferma.
     * @param enfermedadTernera
     */
    public void crearEnfermedadTernera(EnfermedadTernera enfermedadTernera){
    	em.persist(enfermedadTernera);
    	em.flush();
    }
    
    /**
     * Editar una Ternera Enferma
     * @param enfermedadTernera
     */
    public void editarEnfermedadTernera(EnfermedadTernera enfermedadTernera){
    	
    	EnfermedadTerneraPK enfTerPk = new EnfermedadTerneraPK();
    	enfTerPk.setIdTernera(enfermedadTernera.getId().getIdTernera());
    	enfTerPk.setIdEnfermedad(enfermedadTernera.getId().getIdEnfermedad());
    	enfTerPk.setFechaDesde(enfermedadTernera.getId().getFechaDesde());
    	
    	EnfermedadTernera tern = em.find(EnfermedadTernera.class, enfTerPk);
    	tern.setObservacion(enfermedadTernera.getObservacion());
    	tern.setFechaHasta(enfermedadTernera.getFechaHasta());
    	em.merge(tern);
    	em.flush();
    	
    }
    
    /**
     * Listado de todas las terneras enfermas
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<EnfermedadTernera> obtenerTodasEnfermedadesTerneras(){
    	List<EnfermedadTernera> enf = null;
    	enf =   em.createNamedQuery("EnfermedadTernera.obtenerTodasEnfermedadesTerneras").getResultList();
		 return enf;
	}
    /**
     * Verificar que dados una fecha, ternera y enfermedad existe el registro
     *(validacion para no regitrar valores identicos)
     * @param enfermedadTernera
     * @return
     */
	public boolean obtenerTerneraEnfermaFechaExiste(EnfermedadTernera enfermedadTernera) {
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	
    	 
    	 Query query =  em.createNamedQuery("EnfermedadTernera.existeEnfermedadTernera");
    	 query.setParameter("idEnfermedad", enfermedadTernera.getEnfermedad().getIdEnfermedad());
    	 query.setParameter("idTernera", enfermedadTernera.getTernera().getIdTernera());
    	 query.setParameter("fechaDesde", enfermedadTernera.getId().getFechaDesde());
    	 
    	System.out.println("idEnfermedad "+enfermedadTernera.getEnfermedad().getIdEnfermedad());
    	 System.out.println("fecha " + enfermedadTernera.getId().getFechaDesde());
    	 System.out.println("idTernera "+ enfermedadTernera.getTernera().getIdTernera());
    	 
    	 cont =   ((Number)query.getSingleResult()).intValue();
    	 
    	 if(cont > 0){
	    	
	    	existe = true;
	    }
	    return existe;
    }
	/**
	 * Verificar que dada una ternera esta tenga registros en la base de datos
	 * @param idEnfermedad
	 * @return
	 */
	public boolean obtenerTerneraEnfermaExiste(long idEnfermedad) {
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	 Query query =  em.createNamedQuery("EnfermedadTernera.obtenerTerneraEnfermaExiste");
    	 query.setParameter("idEnfermedad", idEnfermedad);
    	 
    	 cont =   ((Number)query.getSingleResult()).intValue();
    	 
    	 if(cont > 0){
	    	
	    	existe = true;
	    }
	    return existe;
    }
	
	
	public EnfermedadTernera obtenerTerneraEnfermaFecha(EnfermedadTernera enfermedadTernera) {
		EnfermedadTernera enfTernera= null;
		try{
	    	 Query query =  em.createNamedQuery("EnfermedadTernera.obtenerTerneraEnfermaFecha");
	    	 query.setParameter("idEnfermedad", enfermedadTernera.getId().getIdEnfermedad());
	    	 query.setParameter("idTernera", enfermedadTernera.getTernera().getIdTernera());
	    	 query.setParameter("fechaDesde", enfermedadTernera.getId().getFechaDesde());
	    	 
	    	 enfTernera =   (EnfermedadTernera) query.getSingleResult();
	
		    return enfTernera;
		 } catch (NoResultException e) {
				return null;
		}
    }

}
