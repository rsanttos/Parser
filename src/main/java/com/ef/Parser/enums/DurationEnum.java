package com.ef.Parser.enums;

/**
 * Enum for duration types
 * @author ramonsantos
 *
 */
public enum DurationEnum {
	HOURLY ("hourly"),
	DAILY ("daily");
	
	public String value;
	
	DurationEnum(String value){
		this.value = value;
	}
}
