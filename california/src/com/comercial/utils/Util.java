package com.comercial.utils;

public class Util {
	
	public static boolean isNotBlank(String val) {
		
		if (val==null || val.trim().equalsIgnoreCase("")){
			return false;
		}
		return true;
	}

}
