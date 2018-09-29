package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import enumerados.TipoPerfil;

@Converter(autoApply = true)
public class TipoPerfilConvert implements AttributeConverter<TipoPerfil,String>{

	public String convertToDatabaseColumn(TipoPerfil value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}

	public TipoPerfil convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return TipoPerfil.fromTipoPerfil(dbData);
	}
}
