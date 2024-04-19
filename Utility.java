// Colin Benware Cis340 Tu/Th 1:30 MP2
import java.util.Scanner;

import java.lang.*;

public class Utility {
	// scanner to be used in methods
	private  static Scanner inputDevice = new Scanner(System.in);
	
	//methods
	public static int readInt() {
	// value to store input
	int value;
	
	//get and store the integer input 
	try {
		value = Integer.parseInt ( inputDevice.nextLine() );
	
	}
	
	catch(NumberFormatException e) {
		value = -1;
		
	}// end of try catch
	
	//return the value stored
	return value;

	}
	
	public static String readString() {
	// values store the input to be returned later
	String value;
	
	//next line statement grabs the User's input. try and catch block used to find accidental string inputs,
	value = inputDevice.nextLine();
	
	//return it
	return value;
	
	}
	
	public static void systemHeader() {
	System.out.println("\t\t\t Library Device Checkout System\n");
	
	}
	
	//overloaded so that the header can be changed to show which section the system is in
	public static void systemHeader( String section) {
	System.out.printf("\n\n\n\n\n\t\t\t Library Device Checkout System" + " - " + section + "\n\n\n");
	
	}
	
	public static void tableheader() {
	System.out.printf("%-3s %-9s %-45s\n", "#", "SKU", "Name");
		
	}
	
	public static void pause() {
	//using a nextline pause the code until the user hits a key to continue
	System.out.println("\nPress Enter to continue...");
	inputDevice.nextLine();
	
	}
	
	public static void invalidOption() {
	// prints the invalid option when called
	System.out.println("Invalid Option");
	
	}
	
	
	
}
