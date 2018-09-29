package enumerados.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import enumerados.TipoMedicamento;

@Converter(autoApply = true)
public class TipoMedicamentoConvert implements AttributeConverter<TipoMedicamento,String>{

	public String convertToDatabaseColumn(TipoMedicamento value){
		if(value == null){
			return null;
		}
		return value.getNombre();
	}


	public TipoMedicamento convertToEntityAttribute(String dbData) {
		if(dbData == null){
			return null;
		}
		return TipoMedicamento.fromTipoMedicamento(dbData);
	}
}
