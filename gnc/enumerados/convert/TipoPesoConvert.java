package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import enumerados.TipoPeso;

@Converter(autoApply = true)
public class TipoPesoConvert implements AttributeConverter<TipoPeso,String>{

	public String convertToDatabaseColumn(TipoPeso value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}


	public TipoPeso convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return TipoPeso.fromTipoPeso(dbData);
	}
}
