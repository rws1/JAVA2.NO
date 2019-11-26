
/**
 * RWS1Name represents the full name of the athlete within the competition. Full
 * name comprises of a first name, middle name and last Name.
 */

public class RWS1Name {
	// instance variables for competitor names
	private String firstName;
	private String middleName;
	private String lastName;

	public RWS1Name(String fName, String lName) {
		firstName = fName;
		middleName = "";
		lastName = lName;
	}

	/**
	 * Constructs and initialises the RWS1Name (the full name) of the athlete, using
	 * fName, mName and lName (three strings).
	 * 
	 * @param fName - competitors first name
	 * @param mName - competitors middle name
	 * @param lName - competitors last name
	 */
	// constructor
	public RWS1Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
	}

	/**
	 * Creates a name from a string of names separated by spaces, parsing it into the first, middle and last name.
	 * String does not need a middle name. 
	 *  
	 * @param fullName a string of names, first, middle and last or first and last. 
	 */
	
	public RWS1Name (String fullName) {
				  int spacePos1 = fullName.indexOf(' ');
				  firstName = fullName.substring(0, spacePos1);
				  int spacePos2 = fullName.lastIndexOf(' ');
				  if (spacePos1 == spacePos2)
					  middleName = "";
				  else 
					  middleName = fullName.substring(spacePos1+1, spacePos2);
				  lastName = fullName.substring(spacePos2 + 1);
				}
		
	// get methods for the name variables
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// concatenate
	/**
	 * Creates a formatted name as a String, in the form shown below. Where M is the
	 * first initial of the middleName parameter.
	 * 
	 * @return - FirstName M. LastName.
	 */
	public String getCompetitorName() {
		return firstName + " " + middleName.charAt(0) + "." + " " + lastName;
	}

	/**
	 * Creates a 3 character string from the names provided. Where F, M and L are
	 * all the first characters of the competitors First, Middle and Last names
	 * respectfully.
	 * 
	 * @return - FML
	 */
	public String getCompertitorInitials() {
		return firstName.substring(0, 1) + middleName.substring(0, 1) + lastName.substring(0, 1);
	}
	  
	  public String getFullName() {
		  String fname = firstName + " ";
		  if (!middleName.equals("")) 
		  {
			  fname += middleName + " ";
		  }
		  fname += lastName;
		  return fname;	  
	  }
	
}
