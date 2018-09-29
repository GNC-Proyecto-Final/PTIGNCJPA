package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import enumerados.NombreEnfermedad;
@Converter(autoApply = true)
public class NombreEnfermedadConvert implements AttributeConverter<NombreEnfermedad,String>{

	public String convertToDatabaseColumn(NombreEnfermedad value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}


	public NombreEnfermedad convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return NombreEnfermedad.fromNombreEnfermedad(dbData);
	}
}
