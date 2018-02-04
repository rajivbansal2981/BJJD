package com.jmk.bjjd.persistence.nosql.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @author rajivb
 *
 */
public class BooleanToStringConverter implements Converter<Boolean,String> {

	@Override
	public String convert(Boolean value) {
		if (value != null && value.booleanValue()) {
			return "Y";
		}
		return "N";
	}

}
