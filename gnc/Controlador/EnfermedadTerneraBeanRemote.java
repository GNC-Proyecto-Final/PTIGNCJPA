package Controlador;

import java.util.List;
import javax.ejb.Remote;
import entidades.EnfermedadTernera;
import excepciones.GNCException;

@Remote
public interface EnfermedadTerneraBeanRemote {
	boolean crearTerneraEnferma(EnfermedadTernera enfermedadTernera)throws GNCException;
	boolean editarTerneraEnferma(EnfermedadTernera enfermedadTernera)throws GNCException;
	List<EnfermedadTernera> obtenerTodasEnfermedadesTerneras();
	public List<EnfermedadTernera> obtenerInformeTodasEnfermedadesTerneras();
	boolean obtenerTerneraEnfermaFechaExiste(EnfermedadTernera enfermedadTernera);
	boolean existeEnfermedadEnTernaraEnfermedad(long idTernera);
	EnfermedadTernera obtenerTerneraEnfermaFecha(EnfermedadTernera enfermedadTernera);
}
