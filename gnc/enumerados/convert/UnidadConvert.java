package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import enumerados.Unidad;

@Converter(autoApply = true)
public class UnidadConvert implements AttributeConverter<Unidad,String>{

	public String convertToDatabaseColumn(Unidad value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}


	public Unidad convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return Unidad.fromUnidad(dbData);
	}
}
