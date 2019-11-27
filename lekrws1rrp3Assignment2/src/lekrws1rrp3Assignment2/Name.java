package lekrws1rrp3Assignment2;

public class Name {
	// Assign parameters

		private String FirstName;
		private String MiddleName;
		private String LastName;

		// Create the constructor

		public Name(String fName, String mName, String lName) {

			this.FirstName = fName;
			this.MiddleName = mName;
			this.LastName = lName;

		}

		// Create get method for full name

		public String getFullName() {

			return FirstName + " " + MiddleName + " " + LastName;

		}

		// Create get method for firstName

		public String getfirstName() {

			return FirstName;
		}

		// Create get method for Initials
		public String getInititals() {

			return FirstName.substring(0, 1) + MiddleName.substring(0, 1) + LastName.substring(0, 1);
		}


}
