package com.jmk.bjjd.persistence.sql.sequence;


public final class Sequence {

	private final String name;
	
	private final String sequencePrefix;
	
	private final int sequenceLength;

	public Sequence(String name, String sequencePrefix, int sequenceLength) {
		super();
		this.name = name;
		this.sequencePrefix = sequencePrefix;
		this.sequenceLength = sequenceLength;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the sequencePrefix
	 */
	public String getSequencePrefix() {
		return sequencePrefix;
	}

	/**
	 * @return the sequenceLength
	 */
	public int getSequenceLength() {
		return sequenceLength;
	}

	
	
}
