package com.ef.Parser.enums;

/**
 * Enum for the date formats that the program will treat
 * @author ramonsantos
 *
 */
public enum DateFormatEnum {
	
	csvDateFormat("yyyy-MM-dd HH:mm:ss.SSS"), parameterDateFormat("yyyy-MM-dd.HH:mm:ss");

	public String value;

	DateFormatEnum(String value) {
		this.value = value;
	}

}
