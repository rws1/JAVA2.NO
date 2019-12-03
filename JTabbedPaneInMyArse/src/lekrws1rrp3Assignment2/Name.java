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

		//create initials
		public String getInititals() {
			String result = FirstName.substring(0,1);
				if(!MiddleName.contentEquals("")) {
					result += MiddleName.substring(0,1);
				}
				result += LastName.substring(0,1);
				return result;
		}

		

}
