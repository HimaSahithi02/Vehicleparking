package edu.util;

public class CommonUtil {

	public static String getTokenId() {
		return (("V" + Math.random()).replace(".", "1")).substring(0, 7);
	}

}
