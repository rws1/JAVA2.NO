package assignment1;

public class Name {

	private String firstName;
	private String middleName;
	private String lastName;

	 public Name(String fName, String lName) {
			firstName = fName;
			middleName = "";
			lastName = lName;
	 }

	public Name (String fName, String mName, String lName)	{		
		this.firstName = fName;
		this.middleName = mName;
		this.lastName = lName;
	}
	
	public Name (String fullName) {
		  int spacePos1 = fullName.indexOf(' ');
		  firstName = fullName.substring(0, spacePos1);
		  int spacePos2 = fullName.lastIndexOf(' ');
		  if (spacePos1 == spacePos2)
			  middleName = "";
		  else 
			  middleName = fullName.substring(spacePos1+1, spacePos2);
		  lastName = fullName.substring(spacePos2 + 1);  
	}
	// get first name
	public String getFirstName() {
		return firstName;
	}
	// get middle name
	public String getMiddleName() {
		return middleName;
	}
	// get last name
	public String getLastName() {
		return lastName;
	}
	// create first name and last name
	public String getFirstAndLastName() {
	 return firstName + " " + lastName; 
	}
	// create last name, first name
	public String getLastCommaFirst() { 
		return lastName + ", " + firstName; 
	}
	// create initial.last name
	public String getInitPeriodLast() {
		return firstName.charAt(0) + ". " + lastName;
	}

	//create initials
	public String getInitials() {
		String result = firstName.substring(0,1);
			if(!middleName.contentEquals("")) {
				result += middleName.substring(0,1);
			}
			result += lastName.substring(0,1);
			return result;
	}
	public void setLastName (String newName) {
		lastName = newName;
	}
	//create full name
	public String getFullName() {
		String result = firstName + " ";
		if (!middleName.contentEquals("")) {
			result += middleName + " ";
		}
		result += lastName;
		return result;
	}
}