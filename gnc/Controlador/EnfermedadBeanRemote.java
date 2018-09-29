package Controlador;

import java.util.List;

import javax.ejb.Remote;

import entidades.Enfermedad;
import excepciones.GNCException;

@Remote
public interface EnfermedadBeanRemote {
	boolean ingresarNuevaEnfermedad(Enfermedad enfermedad) throws GNCException ;
	boolean eliminarEnfermedad(Enfermedad enfermedad) throws GNCException;
	Enfermedad obtenerEnfermedadPorId(long idEnfermedad);
	List<Enfermedad> obtenerTodasEnfermedades();
	boolean existeEnfermedad(Enfermedad enfermedad);
}
