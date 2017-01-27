package com.cs.stringexample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAssignment {

	public static void main(String[] args) {
		System.out.println("Study Hard..!!!");
		String s1 = "Hello"; // cached in string pool
		String s2 = s1.toUpperCase();
		System.out.println(s1);
		System.out.println(s2);

		String s3 = "Hello"; // s3 will point to s2
		System.out.println("Are the same reference? " + (s1 == s3));

		String s4 = new String("Hello"); // this is pointing to a new object in
											// heap
		System.out.println("Are the same reference s3==s4?" + (s3 == s4));

		System.out.println("Intern :" + (s3 == (s4.intern())));

		System.out.println("Are the same reference s3==s4?" + (s3 == s4));

		System.out.println(s1.indexOf("llo"));
		System.out.println(s1.indexOf("He"));
		String s5 = "Hello lo lo";
		System.out.println(s5.lastIndexOf("lo")); // this would return 9
		System.out.println(s5.matches("(.*)o"));
		System.out.println(s5.contains("He"));

		// find occurrences of word
		String test = "HellofsfsfHello";
		Pattern pattern = Pattern.compile("Hello");
		Matcher matcher = pattern.matcher(test);
		int occur = 0;
		while (matcher.find()) {
			occur++;
		}
		System.out.println("No of occurrences of Hello :" + occur);

		System.out.println(test.substring(5, 10));

		// length will return empty string
		//substring operation is source of memory leak unitl JDK 7, java create new string 
		//this issue has been fixed in Java 7
		System.out.println("Empty String =" + test.substring(test.length()));

		try {
			System.out.println(test.substring(50));
		} catch (StringIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
