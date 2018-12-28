package Controlador;

import java.util.List;
import javax.ejb.Remote;
import entidades.Ternera;
import excepciones.TerneraException;

@Remote
public interface TernerasBeanRemote {
	 List<Ternera> obtenerTodasTerneras() throws TerneraException;
	 Ternera obtenerTerneraPorId(long idTernera);
	 Ternera findTerneraPorId(long idTernera);
	 Ternera obtenerTerneraNroCaravana(long idCaravana) throws TerneraException;
}
