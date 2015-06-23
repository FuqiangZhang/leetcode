package string;

import java.util.Hashtable;


public class ChapterOne {
	public static void main(String[] args){
		System.out.println(ChapterOne.question2(" abcdefg"));
	}
	
	
	/**
	 * Determine if a string has all unique characters.  ---start---
	 * */
	public static boolean question1(String input){
		boolean[] bArray = new boolean[128];
		for(int i = 0;i<input.length();i++){
			int v = input.charAt(i);
			if(bArray[v]){
				return false;
			}
			bArray[v] = true;
		}
		return true;
	}
	
	// assume the string only uses the lower case letters a through z
	public static boolean question1solution2(String input){
		int checker = 0;
		for(int i =0;i<input.length();i++){
			int val = input.charAt(i)-'a';
			System.out.println(checker & (1<<val));
			if((checker & (1<<val)) >0){
				return false;
			}
			checker |= (1<<val);
			System.out.println(checker);
		}
		return true;
	}
	
	/**
	 * Determine if a string has all unique characters. ---end---
	 * */
	
	/**
	 * reverse a string in c or c++ ---start---
	 * */
	
	public static String question2(String input){
		char[] cAr=input.toCharArray();
		char temp = ' ';
		for(int i=0;i<input.length()/2;i++){
			temp = cAr[i];
			cAr[i]=cAr[cAr.length-i-1];
			cAr[cAr.length-i-1]=temp;
		}
		System.out.println(String.copyValueOf(cAr));
		return String.copyValueOf(cAr);
	}
	
	/**
	 * reverse a string in c or c++ ---start---
	 * */
	
	
	/**
	 * Give two strings,write a method to decide if one is a permutation of the other.
	 * 
	 * Assume "Dog" is different from "god" and "dog   " is different from "god"
	 * */
	public static boolean question3(String stra,String strb){
		
		
		return true;
	}
}
