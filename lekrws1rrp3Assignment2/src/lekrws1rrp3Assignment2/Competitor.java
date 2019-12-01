package lekrws1rrp3Assignment2;

 public abstract class Competitor {
	protected String competition;
	protected int competitorNumber;// create a method to get short details
	protected Name competitorName;
 	protected String competitorLevel;
 	protected String competitorLocation;
 	protected int competitorAge;
 	protected int[] competitorScores;
	
	 public Competitor(String C, int cNo, Name cNa, String cL, String cLo, int cage, int[] cS) {
		    competition = C;	
			competitorNumber = cNo;
			competitorName = cNa;
			competitorLevel = cL;
			competitorLocation = cLo;
			competitorAge = cage;
			competitorScores = cS;
	}

	
	
	 
	 public String getcompetition () { return competition; }
	 public int getcompetitorNumber () { return competitorNumber; }
	 public Name getName () { return competitorName; }
	 public String getcompetitorLevel () { return competitorLevel; }
	 public String getcompetitorLocation () { return competitorLocation; }
	 public int [] getScoreArray() { return competitorScores; }
	 
	 public void setcompetition (String competition) {this.competition = competition;}
	 public void setcompetitorNumber (int competitorNumber) {this.competitorNumber = competitorNumber;}
	 public void setName(Name competitorName) {this.competitorName = competitorName;}
	 public void setcompetitorLevel (String competitorLevel) { this.competitorLevel = competitorLevel;}
	 public void setcompetitorLocation (String competitorLocation) {this.competitorLocation = competitorLocation; }
	 public void setcompetitorScores (int [] competitorScores) { this.competitorScores = competitorScores;}

	// create a method to get short details
		public String getshortDetails() {
			return "CN " + competitorNumber + " (" + competitorName.getInititals() + ") " + "has overall score " + toString()
					;}

		
		public abstract double getOverallScore();
		public abstract String getfullDetails();
		
		
	}

	

	
	 
	 
 
 

 
 
 
 
	
 
  




 
 


