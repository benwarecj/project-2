// Colin Benware Cis340 Tu/Th 1:30 MP2
import java.util.ArrayList;

public class DeviceSystem {
	//arraylist of objects
	private ArrayList<Device> deviceList = new ArrayList<Device>(10);

	public static void main(String[] args) {
	
	DeviceSystem System1 = new DeviceSystem();
	
	}
	
	//constructor
	public DeviceSystem() {
	
	//adds the starting devices then calls the menu upon creation
	startingDevices();
	
	systemMenu();
	}

	//add 5 objects at start
	private void startingDevices() {

	Device Object1 = new Device( "6757A", "Apple 9.7-inch iPad Pro" );
	deviceList.add(Object1);
	
	Device Object2 = new Device( "93P51B", "Amazon Kindle Fire Kids Edition" );
	deviceList.add(Object2);
	
	Device Object3 = new Device( "10N8C", "LeapFrog Epic Learning Tablet" );
	deviceList.add(Object3);
	
	Device Object4 = new Device( "85U20", "Amazon kindle Fire Hd 8" );
	
	Object4.setStatus("Checked Out");
	deviceList.add(Object4);
	
	Device Object5 = new Device( "91H2D", "HP Envy 8 Note" );
	deviceList.add(Object5);
	
	}// end of Starting devices
	
	//system menu
	private void systemMenu() {
	//variables
	int userChoice;
	
	// do while loop that runs until user exits
	do
	{
		//adding some spacing in between loop
		System.out.println("\n\n\n\n\n");
		
		Utility.systemHeader();
		
		//print a list of options
		System.out.println("1. List Devices by Title\n" + "2. Add New Devices\n" + "3. Edit Device Information\n" +
		"4. Search By Device Name\n" + "5. Check Out Devices\n" + "6. Check In Devices\n" + "7. Exit");
		
		//ask user to pick a option and store the choice
		System.out.print("\n\nSelect menu options 1-7: ");
		userChoice = Utility.readInt();
		
		// Switch statement to determine which method to call. 7 ends the programs instead of calling a system method. Pause method used to pause the end of each method used.
		switch( userChoice )
		{
		case 1:
		displayList();
		Utility.pause();
		break;
		
		case 2:
		addUnit();
		Utility.pause();
		break;
		
		case 3:
		editUnit();
		Utility.pause();
		break;
		
		case 4:
		searchByName();
		Utility.pause();
		break;
		
		case 5:
		checkOutUnit();
		Utility.pause();
		break;
		
		case 6:
		checkInUnit();
		Utility.pause();
		break;
		
		case 7:
		System.out.println("End of program");
		System.exit(0);
		break;

		}// end of switch
			
	} while( userChoice != 7);
	
	}// end of system menu method
	
	//system menu methods
	private void displayList() {
	// overloaded header method that contains what section its apart of
	Utility.systemHeader( "List" );
	
	//column header for the list
	Utility.tableheader();
	
	//enhanced for each loop used to display the array contents
	for ( Device x : deviceList) {
		
		System.out.printf("%-3d %-9s %-45s %s\n",
		deviceList.indexOf( x ) + 1, x.getUnitSKU(), x.getUnitName(), x.getStatus());
		
	} // end of enhanced for loop
	
	} // end of System list
	
	private void addUnit() {
	
	//header
	Utility.systemHeader( "Add New Device");
	
	//Create a new device with the default constructor it will then prompt the user to add detail about the device such as name and SKU.
	//After that it is added to the list
	Device newDevice = new Device();
	
	deviceList.add(newDevice);
	
	//print out the name of the device added
	System.out.printf("\nAdded %s to Catalog.", newDevice.getUnitName() );
	
	}// end of add unit
	
	private void editUnit() {
	//variables
	int deviceNum;
	
	//call the display list method to show all the options
	displayList();
	
	//ask which device to change with value to be stored -1 to fit how arrays are arranged.
	System.out.printf("\nEnter Device number to edit (1-%d): ", deviceList.size());
	deviceNum = Utility.readInt() - 1 ;
	
	//attempt to change the details using the addDetail methods in a try catch block.
	//Catch will print a invalid number if a error occurs.
	
	try {
		deviceList.get(deviceNum).addDetails();
		
		// let user know it was successful 
		System.out.println("\nDevice information updated.");
		
	}
	
	catch( IndexOutOfBoundsException e ) { 
		Utility.invalidOption();
		
	}// end of try catch
	
	}// end of the update method
	
	private void searchByName() {
	//variables
	String searchFor;
	
	//header
	Utility.systemHeader( "Search");
	
	//ask user for what they are looking for and repeat it back
	System.out.print("Enter Device to seach for: ");
	searchFor = Utility.readString();
	
	System.out.printf("\nListings for \'%s\'\n", searchFor);
	
	//for each loop that show all the objects that have the words the User inputed
	Utility.tableheader();
	
	for ( Device x : deviceList) {
		//if statement gets the name of each device and checks if it contains the search for string
		if ( x.getUnitName().contains( searchFor )) {
			System.out.printf("%-3d %-9s %-45s %s\n",
			deviceList.indexOf( x ) + 1, x.getUnitSKU(), x.getUnitName(), x.getStatus());
			
		}
		
	}// end of enhanced for loop
	
	}// end of search by name method
	
	private void displayStatus( String Availability ) {
	//display Status method is used for both checkOut and checkIn method.It picks which one to display based on the parameter given
	//setup table with columns headers then a enhanced for loop to go through the array list.
	//It will display the values that contain the same status as the method param done using a If statement.

	Utility.tableheader();
		
	for ( Device x : deviceList) {
		
		if (x.getStatus().equalsIgnoreCase(Availability))
		System.out.printf("%-3d %-9s %-45s \n",
		deviceList.indexOf( x ) + 1, x.getUnitSKU(), x.getUnitName());
			
	}// end of enhanced for loop
	
	}
	
	private void checkOutUnit() {
	//variables
	int deviceNum;
		
	//Headers. The 2nd header to me is unnecessary but adding it anyway.
	Utility.systemHeader( "Check Out Devices" );
	
	System.out.println("Available Devices\n");
	
	//call the display Availability method set to those Available
	displayStatus( "Available" );
	
	//ask user for which device number they want to check out. -1 to fit arrays
	System.out.print("\nEnter Device Number: ");
	deviceNum = Utility.readInt() - 1;
	
	// try catch block to prevent invalid numbers for the array from crashing the system. If Statement to stop unneeded uses of setters
	try {
		if( deviceList.get(deviceNum).getStatus().equalsIgnoreCase("Checked Out") ) {
			System.out.println("Device is already Checked Out");
		
		}
		else {
			deviceList.get(deviceNum).setStatus( "Checked Out");
		
			System.out.println("Device Checked Out");
		
		}
		
	}
	catch (IndexOutOfBoundsException e) {
		Utility.invalidOption();
		
	}// end of try catch
	
	}// end of Check out method
	
	private void checkInUnit() {
	//variables just the device num varaiable that store user input
	int deviceNum;
	
	//Headers.
	Utility.systemHeader( "Check In Devices" );
		
	System.out.println("Checked Out Devices\n");
		
	//call the display Availability method set to those Checked Out
	displayStatus( "Checked Out" );
	
	//ask user for which device number they want to check out. -1 to fit arrays
		System.out.print("\nEnter Device Number: ");
		deviceNum = Utility.readInt() - 1;
	
	// try catch block used to catch bad numbers ie those outside of possible array values. If statement stops setter use for objects not on the list.
	try {
		if( deviceList.get(deviceNum).getStatus().equalsIgnoreCase("Available") ) {
			System.out.println("This  device is not checked out");
		
		}
		else {
			deviceList.get(deviceNum).setStatus( "Available" );
		
			System.out.println("Device Checked Out");
		
		}
		
	}
	catch (IndexOutOfBoundsException e) {
		Utility.invalidOption();
		
	}// end of try catch
	
	}// end of Check in method
	
}// end of Device System class
