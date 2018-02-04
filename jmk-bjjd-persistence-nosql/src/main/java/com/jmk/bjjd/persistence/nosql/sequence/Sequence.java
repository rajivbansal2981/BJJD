package com.jmk.bjjd.persistence.nosql.sequence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="sequence")
public class Sequence {

	@Id
	private String id;
	
	@Field("seqvalue")
	private int sequenceValue;
	
	@Field("seqprefix")
	private String sequencePrefix;
	
	@Field("seqlength")
	private int sequenceLength;

	public Sequence(String id, int sequenceValue, String sequencePrefix,
			int sequenceLength) {
		super();
		this.id = id;
		this.sequenceValue = sequenceValue;
		this.sequencePrefix = sequencePrefix;
		this.sequenceLength = sequenceLength;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSequenceValue() {
		return sequenceValue;
	}

	public void setSequenceValue(int sequenceValue) {
		this.sequenceValue = sequenceValue;
	}

	public String getSequencePrefix() {
		return sequencePrefix;
	}

	public void setSequencePrefix(String sequencePrefix) {
		this.sequencePrefix = sequencePrefix;
	}

	public int getSequenceLength() {
		return sequenceLength;
	}

	public void setSequenceLength(int sequenceLength) {
		this.sequenceLength = sequenceLength;
	}

	
	
}
