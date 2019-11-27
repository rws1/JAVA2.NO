package lekrws1rrp3Assignment2;

public class Competitor {
	private int competitorNumber;
 	private Name competitorName;
 	private String competitorLevel;
 	private String competitorLocation;
 	private int[] competitorScores;

	public Competitor (competitorNumber cNo, competitorName cNa, competitorLevel cL, competitorLocation cLo, competitorScores cS)
	{
	competitorNumber = cNo;
	competitorName = cNa;
	competitorLevel = cL;
	competitorLocation = cLo;
	competitorScores = cS;
		
}
	
 public int getcompetitorNumber () { return competitorNumber; }
 public Name getName () { return competitorName; }
 public String getcompetitorLevel () { return competitorLevel; }
 public String getcompetitorLocation () { return competitorLocation; }
 public int [] getScoreArray() { return competitorScores; }
 
 
 public void setcompetitorNumber (int competitorNumber) {this.competitorNumber = competitorNumber;}
 public void setName(Name competitorName) {this.competitorName = competitorName;}
 public void setcompetitorLevel (String competitorLevel) { this.competitorLevel = competitorLevel;}
 public void setcompetitorLocation (String competitorLocation) {this.competitorLocation = competitorLocation; }
 public void setcompetitorScores (int [] competitorScores) { this.competitorScores = competitorScores;}
 
 
 
 

 //getcompetitorwithhighest score
 
 
 
 
 
 public String getshortDetails() {
	 for (Competitor c : CompetitorList) {
		return "CN " + competitorNumber + " (" + competitorName.getInititals() + ") " + "has overall score "
				+ getOverallScore() + ".";
	}
 }

//overrides equals methods higher up the hierarchy
 //first check that other object being compared IS an Employee
 //if so, cast to an Employee
 //return true if equal, false otherwise
 public boolean equals(Object other){
 	if (!(other instanceof Competitor) )
 		return false;
 	Competitor otherComp = (Competitor) other;
 	return (this.eID.equals(otherComp.eID));
 }
 
 
 

}
