package com.cs.stringexample;

public class StringBufferAndBuilderClasses {
	
	public static void main(String[] args) {
		//StringBuffer is thread safe, every api is synchronized
		String s = "This " + 20 + " is " + Boolean.valueOf(true);
		System.out.println(s);
		//Above approach internally use StringBuilder 
		
	}
}
