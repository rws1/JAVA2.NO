package lekrws1rrp3Assignment2;

import java.util.Arrays;

public class Dancer extends Competitor {
	
	
	public Dancer (String competition, int competitorNumber, Name competitorName, String competitorLevel, String competitorLocation,int competitorAge,
			int[] competitorScores) {

			super (competition, competitorNumber, competitorName, competitorLevel, competitorLocation, competitorAge, competitorScores);
			

			}
	
	
	


	public boolean setCompetition () {
		return competition == "Dancer";
	}
	
	//get the scores for round 1
	public int getScores1() {
		return competitorScores[0];
	}
	//get the scores for round 2
	public int getScores2() {
		return competitorScores[1];
	}
	//get the scores for round 3
	public int getScores3() {
		return competitorScores[2];
	}
	//get the scores for round 4
	public int getScores4() {
		return competitorScores[3];
	}
	//get the scores for round 5
	public int getScores5() {
		return competitorScores[4];
	}
	



		//method to generate average from array
		public double getAveragescore(int[] competitorScores) {

			int sum = 0;
			double average = 0;
			for (int i = 0; i < competitorScores.length; i++)
				sum = sum + competitorScores[i];
			average = sum / competitorScores.length;
			return average;
		}
	
	
	public double getOverallScore() {
		double OverallScore;
			if (competitorLevel.equals("novice")) 
			{
				OverallScore = (getAveragescore(competitorScores) * 1.15);
			} 
			else if (competitorLevel.equals("amateur")) 
			{
				OverallScore = (getAveragescore(competitorScores) * 1.1);
			} 
			else if (competitorLevel.equals("semi-professional")) 
			{
				OverallScore = (getAveragescore(competitorScores) * 1.05);
			}
			else 
			{
				OverallScore = (getAveragescore(competitorScores) * 1);
			}
				
		return OverallScore;
		
	}
  
	 
	
	

	public String toString() {
		
		return "" + String.format("%.2f",getOverallScore());
		
	}
	
	
	

    //overrides equals methods higher up the hierarchy
    //first check that other object being compared IS a Dancer
    //if so, cast to Dancer
    //return true if equal, false otherwise
	public boolean equals(Object other){
    	if (!(other instanceof Dancer) )
    		return false;
    	Dancer otherDan = (Dancer) other;
    	return (this.competition.equals(otherDan.competition));
    }
	
	
	//method to print the score array
			public String getarrayofcompetitorScores() {
				return Arrays.toString(competitorScores);
			}
			
			// create a method to get short details
						public String getShortDetails() {
							return "CN " + competitorNumber + " (" + competitorName.getInititals() + ") " + "has overall score " 
						       + String.format("%.2f",getOverallScore())
									;}


			public String getfullDetails() {
				return competitorName.getFullName() + "(CN " + competitorNumber + ") , " + "who competes for "
				+ competitorLocation + ". " + competitorName.getFullName() + " is a " + competitorLevel + ", "
				+ "who has competed " + " times for their country.\n"
				+ "They achieved scores of " + getarrayofcompetitorScores().replace("[", "").replace("]", "") + ","
				+ " this gives them an average score of " + getAveragescore(competitorScores)
				+ ", weighted by level to " + String.format("%.2f",getOverallScore()) + ".";
			}


			
	
	
	
}
