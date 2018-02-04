package com.jmk.bjjd.persistence.mapper;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component("entityModelMapper")
public class EntityModelMapper {
	
	//private static final Mapper mapper=DozerBeanMapperSingletonWrapper.getInstance();
	@Resource(name="dozerBeanMapper")
	private DozerBeanMapper mapper;
	/**
	 * Mapper for source
	 * @param source
	 * @param destinationClass
	 * @return
	 */
	public <T> T map(Object source,Class<T> destinationClass){
		T mappedClass=null;
		if(source!=null){
			mappedClass= mapper.map(source, destinationClass);
		}
		return mappedClass;
	}
	
	
	/**
	 * Mapper for List of sources to convert to list of Destination Class
	 * @param sourceList
	 * @param destinationClass
	 * @return
	 */
	public <T> List<T> map(List<?> sourceList,Class<T> destinationClass){
		List<T> mappedList=null;
		if(sourceList==null){
			return Collections.emptyList();
		}
		mappedList=new ArrayList<T>();
		for(Object source:sourceList){
			T mappedClass=map(source,destinationClass);
			mappedList.add(mappedClass);
		}
		return mappedList;
	}
	
}

