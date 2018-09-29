package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import enumerados.TipoAlimento;

@Converter(autoApply = true)
public class TipoAlimentoConvert implements AttributeConverter<TipoAlimento,String>{

	public String convertToDatabaseColumn(TipoAlimento value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}


	public TipoAlimento convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return TipoAlimento.fromTipoAlimento(dbData);
	}
}
