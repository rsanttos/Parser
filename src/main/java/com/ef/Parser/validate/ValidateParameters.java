package com.ef.Parser.validate;

import com.ef.Parser.enums.ParametersEnum;

/**
 * Class responsible for the validation of parameters reported by the user
 * 
 * @author ramonsantos
 *
 */
public class ValidateParameters {

	/**
	 * Method responsible for validating if all parameters are valid
	 * 
	 * @param paramStartDate
	 * @param paramDuration
	 * @param paramThreshould
	 * @param paramAccessLogPath
	 * @return
	 */
	public static boolean isAllValid(String paramStartDate, String paramDuration, String paramThreshould,
			String paramAccessLogPath) {
		if (isValidStartDate(paramStartDate) && isValidDuration(paramDuration) && isValidThreshould(paramThreshould)
				&& isValidAccessLogPath(paramAccessLogPath)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method responsible for verifying that at least one parameter is valid
	 * 
	 * @param params
	 * @return
	 */
	public static boolean hasAnyValid(String[] params) {
		for (String param : params) {
			if (isValidStartDate(param) || isValidDuration(param) || isValidThreshould(param)
					|| isValidAccessLogPath(param)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method responsible for validating whether the startDate parameter is valid
	 * 
	 * @param paramStartDate
	 * @return
	 */
	public static boolean isValidStartDate(String paramStartDate) {
		String strStart = String.format("--%s", ParametersEnum.startDate);
		if (paramStartDate.startsWith(strStart)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method responsible for validating whether the duration parameter is valid
	 * 
	 * @param paramStartDate
	 * @return
	 */
	public static boolean isValidDuration(String paramDuration) {
		String strStart = String.format("--%s", ParametersEnum.duration);
		if (paramDuration.startsWith(strStart)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method responsible for validating whether the threshold parameter is valid
	 * 
	 * @param paramStartDate
	 * @return
	 */
	public static boolean isValidThreshould(String paramThreshould) {
		String strStart = String.format("--%s", ParametersEnum.threshold);
		if (paramThreshould.startsWith(strStart)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method responsible for validating whether the accessLog parameter is valid
	 * 
	 * @param paramStartDate
	 * @return
	 */
	public static boolean isValidAccessLogPath(String paramAccessLogPath) {
		String strStart = String.format("--%s", ParametersEnum.accesslog);
		if (paramAccessLogPath.startsWith(strStart)) {
			return true;
		} else {
			return false;
		}
	}

}
