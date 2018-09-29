package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import enumerados.TipoParto;

@Converter(autoApply = true)
public class TipoPartoConvert implements AttributeConverter<TipoParto,String>{

	public String convertToDatabaseColumn(TipoParto value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}


	public TipoParto convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return TipoParto.fromTipoParto(dbData);
	}
}
