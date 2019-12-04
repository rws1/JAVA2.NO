package lekrws1rrp3Assignment2;

/**
 * Software Engineering Foundations Assignment 2 Class to define the varying
 * instances of Names for the competitors
 * 
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

public class Name {

	// Assign parameters
	private String FirstName;
	private String MiddleName;
	private String LastName;

	// Create the constructor
	/**
	 * @param fName  the competitor's first name
	 * @param mName  the competitor's middle name
	 * @param lName  the competitor's last name
	 */
	public Name(String fName, String mName, String lName) {
		
		this.FirstName = fName;
		this.MiddleName = mName;
		this.LastName = lName;
	}

	/**
	 * Creates the competitor's full name
	 * from the individual first, middle and last names
	 * and takes into consideration
	 * if a competitor doesn't have a middle name
	 * @param fullName  the competitor's full name
	 */
	public Name(String fullName) {
		int spacePos1 = fullName.indexOf(' ');
		FirstName = fullName.substring(0, spacePos1);
		int spacePos2 = fullName.lastIndexOf(' ');
		if (spacePos1 == spacePos2)
			MiddleName = "";
		else
			MiddleName = fullName.substring(spacePos1 + 1, spacePos2);
		LastName = fullName.substring(spacePos2 + 1);
	}

	/**
	 * Returns the competitor's full name
	 * @return  the competitor's full name
	 */
	public String getFullName() {
		return FirstName + " " + MiddleName + " " + LastName;
	}

	/**
	 * Return the competitor's first name
	 * @return  the competitor's first name
	 */
	public String getfirstName() {
		return FirstName;
	}

	/**
	 * Creates the competitor's initials
	 * from the individual first, middle and last names
	 * and takes into consideration
	 * if a competitor doesn't have a middle name
	 * @return initials for the competitor
	 */
	public String getInititals() {
		String result = FirstName.substring(0, 1);
		if (!MiddleName.contentEquals("")) {
			result += MiddleName.substring(0, 1);
		}
		result += LastName.substring(0, 1);
		return result;
	}
}
