package com.d.tdd;


public class StringHelper_Rhsb
{
	public String replaceAInFirst2Positions(String str)
	{
		if (str.length() < 2)
		{
			return str.replaceAll("A", "");
		}
		
		if (str.indexOf("A") <= 1)
		{
			String first2Characters = str.substring(0,2);
			String remainngCharacters = str.substring(2);
			
			return first2Characters.replaceAll("A", "") + remainngCharacters;
		}
		else
		{
			return str;
		}	
	}

	public boolean areFirstTwoAndLastTwoCharsTheSame(String str)
	{
		int length = str.length();
		
		if (length < 2)
		{
			return false;
		}
		
		String first2Chars = str.substring(0,2);
		String last2Chars = str.substring(length - 2);
		
		return first2Chars.equals(last2Chars);
	}
}
