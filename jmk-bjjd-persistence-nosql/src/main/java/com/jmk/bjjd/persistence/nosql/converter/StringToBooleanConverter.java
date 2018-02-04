package com.jmk.bjjd.persistence.nosql.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @author rajivb
 *
 */
public class StringToBooleanConverter implements Converter<String,Boolean> {

	@Override
	public Boolean convert(String value) {
		if (value != null){
			if(value=="Y") {
				return Boolean.TRUE;
			}else if(value=="N"){
				return Boolean.FALSE;
			}
		}
		return null;
	}

}
