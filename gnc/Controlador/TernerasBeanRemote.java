package Controlador;

import java.util.List;
import javax.ejb.Remote;
import entidades.Ternera;

@Remote
public interface TernerasBeanRemote {
	 List<Ternera> obtenerTodasTerneras();
	 Ternera obtenerTerneraPorId(long idTernera);
	 Ternera findTerneraPorId(long idTernera);
	 Ternera obtenerTerneraNroCaravana(long idCaravana);
}
