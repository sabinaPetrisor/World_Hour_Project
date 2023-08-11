package com.worldhourproject.utility;

public class DataValidator {
	public static boolean isCountryName(String value) {
		if(value.matches("^[a-zA-Z ]*$")) {
			return true;
		}
		return false;
	}
	
	public static boolean isNull(String value) {
		if(value == null || value.matches("[ ]+") || value.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	/*public static void main(String[] args) {
		String val = "";
		System.out.println(isNull(val));
	}*/
}
