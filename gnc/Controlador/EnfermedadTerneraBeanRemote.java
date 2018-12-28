package Controlador;

import java.util.List;
import javax.ejb.Remote;
import entidades.EnfermedadTernera;
import excepciones.GNCException;
import excepciones.TerneraEnfermaException;

@Remote
public interface EnfermedadTerneraBeanRemote {
	boolean crearTerneraEnferma(EnfermedadTernera enfermedadTernera)throws GNCException;
	boolean editarTerneraEnferma(EnfermedadTernera enfermedadTernera)throws GNCException;
	List<EnfermedadTernera> obtenerTodasEnfermedadesTerneras() throws TerneraEnfermaException;
	public List<EnfermedadTernera> obtenerInformeTodasEnfermedadesTerneras() throws TerneraEnfermaException;
	boolean obtenerTerneraEnfermaFechaExiste(EnfermedadTernera enfermedadTernera) throws TerneraEnfermaException;
	boolean existeEnfermedadEnTernaraEnfermedad(long idEnfermedad) throws TerneraEnfermaException;
	EnfermedadTernera obtenerTerneraEnfermaFecha(EnfermedadTernera enfermedadTernera) throws TerneraEnfermaException;
	
}
