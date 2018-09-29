package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import enumerados.Raza;


@Converter(autoApply = true)
public class RazaConvert implements AttributeConverter<Raza,String>{

	public String convertToDatabaseColumn(Raza value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}


	public Raza convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return Raza.fromRaza(dbData);
	}
}
