package com.trangile.ui.req.dto;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "this is sumit.";
		String str1 = "";
		for (int i = str.length() -1; i >= 0; i--) {
			str1 = str1+str.charAt(i);
		}
		System.out.println(str1);

	}

}
