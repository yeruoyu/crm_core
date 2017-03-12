package com.lodge.crm.core.util;

public class StringUtil {

	/**
	 * left pad string
	 * @param length
	 * @param number
	 * @return
	 */
	public static String lpad(int length, int number) {
		String f = "%0" + length + "d";
		return String.format(f, number);
	}

}
