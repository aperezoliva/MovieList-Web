/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 14, 2022
*/
package controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author krazy
 *
 */

@Converter(autoApply=true)
public class LocalDateAttributeConverter implements
AttributeConverter<LocalDate, Date> {
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
			return (attribute == null ? null : Date.valueOf(attribute));
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return (dbData == null ? null: dbData.toLocalDate());
	}
}

