package Controlador;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import DAO.DAOEnfermedadesBean;
import entidades.Enfermedad;
import excepciones.GNCException;




/**
 * Session Bean implementation class EnfermedadBean
 */
@Stateless
public class EnfermedadBean implements EnfermedadBeanRemote {
	@EJB
	DAOEnfermedadesBean daoEnfermedadBean;
	
	@EJB
	EnfermedadTerneraBean enfermedadTerneraBean;
    /**
     * Default constructor. 
     */
    public EnfermedadBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean ingresarNuevaEnfermedad(Enfermedad enfermedad) throws GNCException  {
    	boolean creado = false;
    	try {
    		
    		if(!existeEnfermedad(enfermedad)){
    			daoEnfermedadBean.crearEnfermedad(enfermedad);
    			creado = true;
    		}	
		} catch (Exception e) {
			throw new GNCException("Error al Crear Enfermedad");	
		}
    	return creado;
    }
    
    @Override
    public boolean eliminarEnfermedad(Enfermedad enfermedad) throws GNCException{
    	boolean eliminado = false;
    	try {
    		if(!enfermedadTerneraBean.existeEnfermedadEnTernaraEnfermedad(enfermedad.getIdEnfermedad())){
    			daoEnfermedadBean.eliminarEnfermedad(enfermedad);
    			eliminado = true;
    		}
			
		} catch (Exception e) {
			throw new GNCException("Error al eliminar Enfermedad");
		}
    	return eliminado;
    }
    public boolean eliminarEnfermedadPorId(long idEnfermedad) throws GNCException{
    	boolean eliminado = false;
    	try {
    		
    		Enfermedad enfermedad = daoEnfermedadBean.findEnfermedadId(idEnfermedad);
    		if(!enfermedadTerneraBean.existeEnfermedadEnTernaraEnfermedad(enfermedad.getIdEnfermedad())){
    			
    			daoEnfermedadBean.eliminarEnfermedad(enfermedad);
    			eliminado = true;
    		}
			
		} catch (Exception e) {
			throw new GNCException("Error al eliminar Enfermedad");
		}
    	return eliminado;
    }
    @Override
    public Enfermedad obtenerEnfermedadPorId(long idEnfermedad){
		return daoEnfermedadBean.obtenerEnfermedadId(idEnfermedad);
	}
    @Override
    public Enfermedad findEnfermedadPorId(long idEnfermedad){
		return daoEnfermedadBean.findEnfermedadId(idEnfermedad);
	}
    @Override
	public List<Enfermedad> obtenerTodasEnfermedades(){
    	List<Enfermedad> enf= null;
    	
    	enf = (List<Enfermedad>) daoEnfermedadBean.obtenerTodasEnfermedades();
    	return enf;
	}
    @Override
    public boolean existeEnfermedad(Enfermedad enfermedad){
    	boolean enferm = daoEnfermedadBean.existeEnfermedad(enfermedad);
		if(enferm == false)
			return false;
		else
			return true;
    	
    }
}
