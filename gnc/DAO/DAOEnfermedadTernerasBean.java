package DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
    
    public void crearEnfermedadTernera(EnfermedadTernera enfermedadTernera){
    	/*Query query = em.createQuery("INSERT INTO ENFERMEDAD_TERNERA (ID_TERNERA, ID_ENFERMEDAD, FECHA_DESDE, FECHA_HASTA, OBSERVACION) VALUES (?, ?,?,?,?)");
    	query.setParameter(1, enfermedadTernera.getId().getIdTernera());
    	query.setParameter(2, enfermedadTernera.getId().getIdTernera());
    	query.setParameter(3, enfermedadTernera.getId().getFechaDesde());
    	query.setParameter(4, enfermedadTernera.getFechaHasta());
    	query.setParameter(5, enfermedadTernera.getObservacion());
    	query.executeUpdate();*/
    	em.persist(enfermedadTernera);
    	
    	em.flush();
    }
    
    public void editarEnfermedadTernera(EnfermedadTernera enfermedadTernera){
    	
    	/*Query query = em.createQuery("UPDATE ENFERMEDAD_TERNERA SET FECHA_HASTA = ? , OBSERVACION=? WHERE (ID_ENFERMEDAD=? AND ID_TERNERA = ? AND FECHA_DESDE =?)");
       	query.setParameter(1, enfermedadTernera.getFechaHasta());
    	query.setParameter(2, enfermedadTernera.getObservacion()); 	
    	query.setParameter(3, enfermedadTernera.getId().getIdEnfermedad());
    	query.setParameter(4, enfermedadTernera.getId().getIdTernera());
    	query.setParameter(5, enfermedadTernera.getId().getFechaDesde());
    	query.executeUpdate();*/
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
	@SuppressWarnings("unchecked")
	public List<EnfermedadTernera> obtenerTodasEnfermedadesTerneras(){
    	List<EnfermedadTernera> enf = null;
    	enf =   em.createNamedQuery("EnfermedadTernera.obtenerTodasEnfermedadesTerneras").getResultList();
		 return enf;
	}
    
	public boolean obtenerTerneraEnfermaFechaExiste(EnfermedadTernera enfermedadTernera) {
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	 Query query =  em.createNamedQuery("EnfermedadTernera.existeEnfermedadTernera");
    	 query.setParameter("idEnfermedad", enfermedadTernera.getEnfermedad().getIdEnfermedad());
    	 query.setParameter("idTernera", enfermedadTernera.getTernera().getIdTernera());
    	 query.setParameter("fechaDesde", enfermedadTernera.getId().getFechaDesde());
    	 
    	 cont =   ((Number)query.getSingleResult()).intValue();
    	 
    	 if(cont > 0){
	    	
	    	existe = true;
	    }
	    return existe;
    }
	
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
   
    	 Query query =  em.createNamedQuery("EnfermedadTernera.obtenerTerneraEnfermaFecha");
    	 query.setParameter("idEnfermedad", enfermedadTernera.getId().getIdEnfermedad());
    	 query.setParameter("idTernera", enfermedadTernera.getTernera().getIdTernera());
    	 query.setParameter("fechaDesde", enfermedadTernera.getId().getFechaDesde());
    	 
    	 enfTernera =   (EnfermedadTernera) query.getSingleResult();

	    return enfTernera;
    }

}
