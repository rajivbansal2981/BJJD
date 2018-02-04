package com.jmk.bjjd.persistence.sql.sequence;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.jmk.bjjd.persistence.sql.entities.AddressEntity;
import com.jmk.bjjd.persistence.sql.entities.BaseEntity;
import com.jmk.bjjd.persistence.sql.entities.ExpenseEntity;
import com.jmk.bjjd.persistence.sql.entities.GuestEntity;
import com.jmk.bjjd.persistence.sql.entities.MemberEntity;
import com.jmk.bjjd.persistence.sql.entities.PhotoUploadEntity;
import com.jmk.bjjd.persistence.sql.entities.SevaCategoryEntity;
import com.jmk.bjjd.persistence.sql.entities.SevaEntity;

public class PKSequenceGenerator implements IdentifierGenerator {

	private enum EntityType{MEMBER,SEVACATEGORY,SEVA,GUEST,ADDRESS,ROLE,PHOTOUPLOAD,EXPENSE};
	
	private static final Map<EntityType,Sequence> entityTypeSequences=new HashMap<EntityType,Sequence>();
	
	static{
		entityTypeSequences.put(EntityType.MEMBER,new Sequence("SEQ_MEMBER","BJJDJKYV",4));
		entityTypeSequences.put(EntityType.SEVACATEGORY, new Sequence("SEQ_SEVACATEGORY","SVC",2));
		entityTypeSequences.put(EntityType.GUEST,new Sequence("SEQ_GUEST","GST",3));
		entityTypeSequences.put(EntityType.SEVA,new Sequence("SEQ_SEVA","SV",4));
		entityTypeSequences.put(EntityType.ADDRESS,new Sequence("SEQ_ADDRESS","ADR",4));
		entityTypeSequences.put(EntityType.ROLE,new Sequence("SEQ_ROLE","RL",3));
		entityTypeSequences.put(EntityType.PHOTOUPLOAD,new Sequence("SEQ_PHOTOUPLOAD","PHT",3));
		entityTypeSequences.put(EntityType.EXPENSE,new Sequence("SEQ_EXPENSE","EXP",3));
	}
	
	@Override
	public Serializable generate(SessionImplementor session, Object entity)
			throws HibernateException {
		String sequenceValue="";
		BaseEntity baseEntity=(BaseEntity)entity;
		if(baseEntity.getId()==null){
			Connection connection=session.connection();
			try {
				Sequence sequence=getSequence(entity);
				PreparedStatement preparedStatement=connection.prepareStatement("SELECT "+sequence.getName()+".NEXTVAL AS NEXTVAL FROM DUAL");
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()){
					sequenceValue=resultSet.getString("NEXTVAL");
					sequenceValue=StringUtils.leftPad(sequenceValue, sequence.getSequenceLength(), "0");
					sequenceValue=sequence.getSequencePrefix().concat(sequenceValue);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return sequenceValue;
		}else{
			return baseEntity.getId();
		}
		
	}
	
	protected Sequence getSequence(Object entity){
		if(entity.getClass()==SevaCategoryEntity.class){
			return entityTypeSequences.get(EntityType.SEVACATEGORY);
		}else if(entity.getClass()==MemberEntity.class){
			return entityTypeSequences.get(EntityType.MEMBER);
		}else if(entity.getClass()==GuestEntity.class){
			return entityTypeSequences.get(EntityType.GUEST);
		}else if(entity.getClass()==SevaEntity.class){
			return entityTypeSequences.get(EntityType.SEVA);
		}else if(entity.getClass()==AddressEntity.class){
			return entityTypeSequences.get(EntityType.ADDRESS);
		}else if(entity.getClass()==PhotoUploadEntity.class){
			return entityTypeSequences.get(EntityType.PHOTOUPLOAD);
		}else if(entity.getClass()==ExpenseEntity.class){
			return entityTypeSequences.get(EntityType.EXPENSE);
		}
		
		return null;
	}


}
