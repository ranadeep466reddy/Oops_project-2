/////////////////////////////////////////////////////////////////////
//Title : Java code that uses a loop to repeatedly prompt for a domain name, and indicates the domain level of the input followed by a core generic TLD.
//Files : TopLevelDomain.java
//Semester : FALL 2016
//Author : Mulucuri Ranadeep Reddy
//Email : rxr160330@utdallas.edu
//Lecturer's Name : Nassim Sohaee
//Course Section : MIS 6323.502
/////////////////////////////////////////////////////////////////////


import java.util.Scanner;
public class TopLevelDomain {

/**
 * This function takes integer input to return subscript string for the domain level number
 * @param value of type integer
 * @return String value which is a subscript of the domain level number i.e; "th", "st", "nd", "rd"
 */
	public static String NumberSubscript(int value)
	{
		int remForHun = value % 100; 
		int remForTen = value % 10; 
		if (remForHun - remForTen == 10) { 
		return "th"; 
		} 
		switch (remForTen) { 
		case 1: 
		return "st"; 
		case 2: 
		return "nd"; 
		case 3: 
		return "rd"; 
		default: 
		return "th"; 
		} 
		} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "";
		String name = "";
		String search = "";
		String core_generic = ".com";
		String core_generic1 = ".net";
		String core_generic2 = ".org";
		String core_generic3 = ".info";
		boolean domain_name = false;
		boolean domain_generic = false;
		int count, level;
		int position = 0;
		int i = 0;
		
		System.out.println("Enter the domain name (<Enter> to exit):\n");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		
		while(input.length() > 0)
		{
			name = input.toLowerCase();
			domain_name = false;
			domain_generic = false;
						
			count = 0;
			for(i = 0; i < input.length();i++ )
			{
				if(name.charAt(i) == '.')
				{
					count++;
					position = i;
				}
			}
/**
 * This part of code is to check two cases for ex: ".com" and "com."			
 */
	if ((name.charAt(0) != '.') && (name.charAt(name.length() - 1) != '.'))
	{
		domain_name = true;
	}
			
	if(domain_name)
{
	search = name.substring(position);
if(search.equals(core_generic) || search.equals(core_generic1)|| search.equals(core_generic2) || search.equals(core_generic3))
{
	domain_generic = true;
}
				
}		
		if((domain_name) && (domain_generic))
		{
			level = count + 1;
			System.out.println("Valid domain");
			String sub = NumberSubscript(level);
			System.out.println(level + sub + "-level domain.\n");
		}
		else
		{
			System.out.println("This is not a core generic domain.\n");
		}
		System.out.println("Enter the next domain name (<Enter> to exit):\n");
		input = sc.nextLine();
		}
		sc.close();
	}

}
