package com.cs.stringexample;

public class StringNullCheck {
	static String SUCCESS = "success";
	public static void main(String[] args) {
		String sTest = null;
		try{
			//always check with constants..
			if(SUCCESS.equals(sTest)){ //this means if(sTest != null && sTest.equals(SUCCESS))
				System.out.println("SUCCESS");
			}
			else{
				System.out.println("FAILURE");
			}
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
