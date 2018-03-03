/** Program: Pig Latin
 * File: PigLatin.java
 * Summary: This program reads text from a text file and converts it to Pig Latin.
 * 
 *
 * Author: Keith Harrison
 * Date: 3/2/2018
 * 
 */

// Import Scanner.
import java.util.Scanner;

public class PigLatin {

    // Declare variables
    static String vowels = "aeuioy"; // Vowels found in strings
    static String PL_SUFFIX1 = "yay"; // Suffix "way"
    static String PL_SUFFIX2 = "ay";  // Suffix "ay"

	public static void toPigLatin(String s) {
            // Convert to lower case.
            char[] letters = s.toLowerCase().toCharArray();
		// If the first letter is a vowel, append Pig Latin Suffix 1.
		if(vowels.contains(Character.toString(letters[0]))) {
			// Print the new Pig Latin word to the console.
                        System.out.println(s + "\t\t" + (s + PL_SUFFIX1).toUpperCase());
		// Else iterate through the word to find the first vowel.
                } else {
			// Find all the consonants before the first vowel.
                        String consonant = "";
			int count = 0;
			
			while(!vowels.contains(Character.toString(letters[count]))
					&& count < s.length()-1) {
				consonant += letters[count];
				count++;
			}
			// Find the core of the word that starts with a vowel.
			String core = s.substring(count);
                        // Print the new Pig Latin word to the console.
			System.out.println(s + "\t\t" + (core + consonant + PL_SUFFIX2).toUpperCase());
		} //End of Loop
	}
	
	public static void main(String[] args) throws Exception {
		
            // Create a File instance	
            java.io.File file = new java.io.File("NowIsTheTime.txt");
		 
            // Create a Scanner object
            Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			toPigLatin(sc.next());
		}
		
            // Close Scanner object    
            sc.close();
	}

}