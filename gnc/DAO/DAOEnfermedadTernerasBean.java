package DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import entidades.EnfermedadTernera;
import entidades.EnfermedadTerneraPK;
import excepciones.GNCException;
import excepciones.TerneraEnfermaException;

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
     * @throws TerneraEnfermaException 
     */
    public void crearEnfermedadTernera(EnfermedadTernera enfermedadTernera) throws TerneraEnfermaException {
    	try{
	    	em.persist(enfermedadTernera);
	    	em.flush();
        }catch(PersistenceException e){
        	throw new TerneraEnfermaException("Ha ocurrido un error al crear la Ternera Enferma");
        }
    }
    
    /**
     * Editar una Ternera Enferma
     * @param enfermedadTernera
     * @throws TerneraEnfermaException 
     */
    public void editarEnfermedadTernera(EnfermedadTernera enfermedadTernera) throws TerneraEnfermaException{
    	try {
	    	EnfermedadTerneraPK enfTerPk = new EnfermedadTerneraPK();
	    	enfTerPk.setIdTernera(enfermedadTernera.getId().getIdTernera());
	    	enfTerPk.setIdEnfermedad(enfermedadTernera.getId().getIdEnfermedad());
	    	enfTerPk.setFechaDesde(enfermedadTernera.getId().getFechaDesde());
	    	
	    	EnfermedadTernera tern = em.find(EnfermedadTernera.class, enfTerPk);
	    	tern.setObservacion(enfermedadTernera.getObservacion());
	    	tern.setFechaHasta(enfermedadTernera.getFechaHasta());
	    	em.merge(tern);
	    	em.flush();
	    }catch(PersistenceException e){
	    	throw new TerneraEnfermaException("Ha ocurrido un error al editar la Ternera Enferma");
	    }
    	
    }
    
    /**
     * Listado de todas las terneras enfermas
     * @return
     * @throws TerneraEnfermaException 
     */
	@SuppressWarnings("unchecked")
	public List<EnfermedadTernera> obtenerTodasEnfermedadesTerneras() throws TerneraEnfermaException{
		try {
			List<EnfermedadTernera> enf = null;
			enf =   em.createNamedQuery("EnfermedadTernera.obtenerTodasEnfermedadesTerneras").getResultList();
			return enf;
		}catch(PersistenceException e){
        	throw new TerneraEnfermaException("Ha ocurrido un error al listar las Terneras Enfermas");
        }
    	
	}
    /**
     * Verificar que dados una fecha, ternera y enfermedad existe el registro
     *(validacion para no regitrar valores identicos)
     * @param enfermedadTernera
     * @return
     * @throws TerneraEnfermaException 
     */
	public boolean obtenerTerneraEnfermaFechaExiste(EnfermedadTernera enfermedadTernera) throws TerneraEnfermaException {
    	boolean existe = false;
    
    	 int cont = 0;
      	
    	 Query query =  em.createNamedQuery("EnfermedadTernera.existeEnfermedadTernera");
    	 query.setParameter("idEnfermedad", enfermedadTernera.getEnfermedad().getIdEnfermedad());
    	 query.setParameter("idTernera", enfermedadTernera.getTernera().getIdTernera());
    	 query.setParameter("fechaDesde", enfermedadTernera.getId().getFechaDesde());
    	 
    	    	 
    	 cont =   ((Number)query.getSingleResult()).intValue();
    	try { 
	    	 if(cont > 0){
		    	
		    	existe = true;
		    }
	    	 
		}catch(PersistenceException e){
	    	throw new TerneraEnfermaException("Ha ocurrido un error al obtener las  Terneras Enfermas");
	    }
		return existe;
    }
	/**
	 * Verificar que dada una ternera esta tenga registros en la base de datos
	 * @param idEnfermedad
	 * @return
	 * @throws TerneraEnfermaException 
	 */
	public boolean obtenerTerneraEnfermaExiste(long idEnfermedad) throws TerneraEnfermaException {
    	boolean existe = false;
    
    	 int cont = 0;
    	 
    	 Query query =  em.createNamedQuery("EnfermedadTernera.obtenerTerneraEnfermaExiste");
    	 query.setParameter("idEnfermedad", idEnfermedad);
    	 
	    	 cont =   ((Number)query.getSingleResult()).intValue();
	    try {
	    		 
	    	 if(cont > 0){
		    	
		    	existe = true;
		    }
    	 
		}catch(PersistenceException e){
	    	throw new TerneraEnfermaException("Ha ocurrido un error consultar la Ternera Enferma");
	    } 
	    
	    return existe;
    }
	
	
	public EnfermedadTernera obtenerTerneraEnfermaFecha(EnfermedadTernera enfermedadTernera) throws TerneraEnfermaException {
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
		catch(PersistenceException e){
			
	    	throw new TerneraEnfermaException("Ha ocurrido un error al obtener la Ternera Enferma por fecha");
	    } 
    }

}
