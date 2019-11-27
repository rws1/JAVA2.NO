package lekrws1rrp3Assignment2;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Dancer extends Competitor implements Competitordetails{
	private int numberOfAppearances;
	public Dancer (int competitorNumber, Name competitorName, String competitorLevel, String competitorLocation,
			int[] competitorScores, int numberOfAppearances) {

			super (competitorNumber, competitorName, competitorLevel, competitorLocation, competitorScores);
			this.numberOfAppearances = NoA;

			}
	
	
	public void setNumberOfAppearances(int numberOfAppearances) {
		this.numberOfAppearances = numberOfAppearances;
	}
	
	public int getNumberOfAppearances() {
		return numberOfAppearances;
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
	
	
	public String getOverallScore() {
		double weightedScore;
			if (competitorLevel.equals("novice")) 
			{
				weightedScore = (getAveragescore(competitorScores) * 1.15);
			} 
			else if (competitorLevel.equals("amateur")) 
			{
				weightedScore = (getAveragescore(competitorScores) * 1.1);
			} 
			else if (competitorLevel.equals("semi-professional")) 
			{
				weightedScore = (getAveragescore(competitorScores) * 1.05);
			}
			else 
			{
				weightedScore = (getAveragescore(competitorScores) * 1);
			}

		return df.format(weightedScore);
	}

	// -- set decimal output, to 2 - only takes a string

	DecimalFormat df = new DecimalFormat("#.##");

	
	//method to print the score array
			public String getarrayofcompetitorScores() {
				return Arrays.toString(competitorScores);
			}
			
			
			// -- Full Details report
			public String getFullDetails() {
				return competitorName.getCompetitorName() + "(CN " + competitorNumber + ") , " + "who competes for "
						+ competitorLocation + ". " + competitorName.getLastName() + " is a " + competitorLevel + ", "
						+ "who has competed " + numberOfAppearances + " times for their country.\n"
						+ "They achieved scores of " + getarrayofcompetitorScores().replace("[", "").replace("]", "") + ","
						+ " this gives them an average score of " + getAveragescore(competitorScores)
						+ ", weighted by level to " + getOverallScore() + ".";
			}		
			
	
	
	
}
