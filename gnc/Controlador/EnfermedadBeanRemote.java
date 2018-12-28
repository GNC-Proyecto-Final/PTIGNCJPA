package Controlador;

import java.util.List;

import javax.ejb.Remote;

import entidades.Enfermedad;
import excepciones.GNCException;
import excepciones.TerneraEnfermaException;

@Remote
public interface EnfermedadBeanRemote {
	boolean ingresarNuevaEnfermedad(Enfermedad enfermedad) throws GNCException ;
	boolean eliminarEnfermedad(Enfermedad enfermedad) throws GNCException;
	boolean eliminarEnfermedadPorId(long idEnfermedad) throws GNCException;
	Enfermedad obtenerEnfermedadPorId(long idEnfermedad) throws TerneraEnfermaException;
	Enfermedad findEnfermedadPorId(long idEnfermedad) throws TerneraEnfermaException;
	List<Enfermedad> obtenerTodasEnfermedades() throws TerneraEnfermaException;
	boolean existeEnfermedad(Enfermedad enfermedad) throws TerneraEnfermaException;
}
