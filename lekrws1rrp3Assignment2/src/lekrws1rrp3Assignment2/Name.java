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
		
		
		
		
		public Name (String fullName) {
			  int spacePos1 = fullName.indexOf(' ');
			  FirstName = fullName.substring(0, spacePos1);
			  int spacePos2 = fullName.lastIndexOf(' ');
			  if (spacePos1 == spacePos2)
				  MiddleName = "";
			  else 
				  MiddleName = fullName.substring(spacePos1+1, spacePos2);
			  LastName = fullName.substring(spacePos2 + 1);  
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

		public String getCompetitorName() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getLastName() {
			// TODO Auto-generated method stub
			return null;
		}


}
