package com.ef.Parser.factory;

import java.util.Date;

/**
 * Class responsible for creating justification text
 * 
 * @author ramonsantos
 *
 */
public class JustificationFactory {

	/**
	 * method responsible for creating the justification for a ip block
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param qtdAccesses
	 * @return
	 */
	public static String getJustification(Date dateStart, Date dateEnd, String qtdAccesses) {
		String justification = new String();
		justification = String.format(
				"The IP address is blocked because it has been identified that it has accessed %s times between %s and %s.",
				qtdAccesses, dateStart, dateEnd);
		return justification;
	}

}
