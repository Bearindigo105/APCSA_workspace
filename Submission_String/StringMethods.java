/*
 * @author Subhash Muthu
 * Just playin' around with strings
 */

package Submission_String;

public class StringMethods 
{

	public static void main(String[] args) 
	{
		
		String myString = "Run some methods on this jawn";
		
		//1. write  code which will return the character at index 5 and 
		//  store it in a variable.  display the value of the variable in the console
		
		char sixthChar = myString.charAt(5);
		System.out.println(String.valueOf(sixthChar));
		
		//2. write code which will return the length of the string and store it in a 
		//   variable.   Display the content of the variable in the console.
		
		int length = myString.length();
		System.out.println(length);
		
		//3. write code which will return the word 'some' and store it in a variable 
		//     you must use a method on myString to generate the word, you may not type 'some'
		
		String someSubstr = myString.substring(4, 8);
		System.out.println(someSubstr);
		
		//4. write code which will display the string in myString with all char 'o' 
		//      replaced with '*'

		String replaceString = myString.replace('o', '*');
		System.out.println(replaceString);
		
		//write a line of code which will return and print the index of the letter m in the 
		//      given string, myString

		int indexOfM = myString.indexOf("m");
		System.out.println(indexOfM);

	}

}
