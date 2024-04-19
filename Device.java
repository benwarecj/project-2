// Colin Benware Cis340 Tu/Th 1:30 MP2

public class Device {
	//fields
	private String unitSKU;
	
	private String unitName;
	
	private String status;
	
	//constructors
	public Device( String SKU, String name ) {
	//name and SKU are set equal to their corresponding fields
	unitSKU = SKU;
	
	unitName = name;
	
	//status is set to Available as default
	status = "Available";
	
	}// end of constructor
	
	//default constructor calls the add details method and set availability.
	public Device() {
	addDetails();
	
	//status is set to Available as default
	status = "Available";
	
	}// end of default constructor
	
	//mutators
	public String getStatus() {
	return status;
		
	}
	
	public String getUnitName() {
	return unitName;
	
	}
	
	public String getUnitSKU() {
	return unitSKU;
	
	}
	
	public void setStatus( String newStatus ) {
	//if statement used to if status is being changed. If not it will spit out a error letting the user know
	status = newStatus;
	
	}
	
	public void setUnitName( String newName ) {
	unitName = newName;
	
	}
	
	public void setUnitSKU( String newSKU ) {
	unitSKU = newSKU;
	
	}
	
	//methods
	public void addDetails() {
	//This method will be used  to add or update the fields of an object when called.
	//variables that contain the values from the user that will later be added to field specified.
	String addSKU;
	
	String addName;
	
	//Prompt the user to add details
	System.out.print("SKU: ");
	addSKU = Utility.readString();
		
	System.out.print("Name: ");
	addName = Utility.readString();
	
	//set the corresponding device fields to those inputs
	
	unitSKU = addSKU;
	
	unitName = addName;
	
	}// end of addDetails method

}// end of Device class
