package com.ef.Parser.utils;

import java.text.ParseException;
import java.util.Date;

import com.ef.Parser.enums.DateFormatEnum;

/**
 * Class responsible for managing user-informed parameters
 * 
 * @author ramonsantos
 *
 */
public class ParametersUtil {
	
	/**
	 * Method responsible for getting the startDate parameter value
	 * 
	 * @param param
	 * @return
	 * @throws ParseException
	 */
	public static Date getStartDate(String param) throws ParseException {
		String[] strParamValue = param.split("=");
		Date startDate = DateUtil.formatStringToDate(strParamValue[1], DateFormatEnum.parameterDateFormat.value);
		return startDate;
	}

	/**
	 * Method responsible for getting the duration parameter value
	 * 
	 * @param param
	 * @return
	 */
	public static String getDuration(String param) {
		String[] strParamValue = param.split("=");
		return strParamValue[1];
	}

	/**
	 * Method responsible for getting the threshold parameter value
	 * 
	 * @param param
	 * @return
	 */
	public static int getThreshold(String param) {
		String[] strParamValue = param.split("=");
		return Integer.parseInt(strParamValue[1]);
	}

	/**
	 * Method responsible for getting the accessLog parameter value
	 * 
	 * @param param
	 * @return
	 */
	public static String getAccessLogPath(String param) {
		String[] strParamValue = param.split("=");
		return strParamValue[1];
	}
}
