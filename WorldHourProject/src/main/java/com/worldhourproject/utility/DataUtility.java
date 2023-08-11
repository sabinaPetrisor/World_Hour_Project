package com.worldhourproject.utility;

public class DataUtility {
	public static String getString(String value) {
		if(!DataValidator.isNull(value)) {
			return value.trim();
		}
		return "";
	}
}
