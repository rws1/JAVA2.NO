package lekrws1rrp3Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Dancer extends Competitor implements Competitordetails{
	
	public Dancer (String competition, int competitorNumber, Name competitorName, String competitorLevel, String competitorLocation,int competitorAge,
			int[] competitorScores) {

			super (competition, competitorNumber, competitorName, competitorLevel, competitorLocation, competitorAge, competitorScores);
			

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
		String middle = df.format(OverallScore);
		int score = Integer.parseInt(middle);
		return score;
		
				
		}
		
		return OverallScore;
		
	}

	
	// -- set decimal output, to 2 - only takes a string

	DecimalFormat df = new DecimalFormat("#.##");

	
	//method to print the score array
			public String getarrayofcompetitorScores() {
				return Arrays.toString(competitorScores);
			}
			
			// create a method to get short details
			public String getshortDetails() {

				return "CN " + competitorNumber + " (" + competitorName.getInititals() + ") " + "has overall score "
						+ getOverallScore() + ".";
			}
			


			public String getfullDetails() {
				return competitorName.getFullName() + "(CN " + competitorNumber + ") , " + "who competes for "
				+ competitorLocation + ". " + competitorName.getFullName() + " is a " + competitorLevel + ", "
				+ "who has competed " + " times for their country.\n"
				+ "They achieved scores of " + getarrayofcompetitorScores().replace("[", "").replace("]", "") + ","
				+ " this gives them an average score of " + getAveragescore(competitorScores)
				+ ", weighted by level to " + getOverallScore() + ".";
			}


			
	
	
	
}
