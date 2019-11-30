package lekrws1rrp3Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Gamer extends Competitor implements Competitordetails{
	
	
	public Gamer (String competition, int competitorNumber, Name competitorName, String competitorLevel, String competitorLocation,int competitorAge,
			int[] competitorScores) {

			super (competition, competitorNumber, competitorName, competitorLevel, competitorLocation, competitorAge, competitorScores);
	}
		

	public int getcompetitorAge() {
		return competitorAge;
	}

	public void setcompetitorAge(int competitorAge) {
		this.competitorAge = competitorAge;
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

		// weighted average score
		public double getOverallScore() {
			double OverallScore;

			{

				if (competitorLevel.equals("Professional")) {
					OverallScore = getAveragescore(competitorScores) * 1.75;

				} else if (competitorLevel.equals("Veteran")) {
					OverallScore = getAveragescore(competitorScores) * 1.5;

				} else {
					OverallScore = getAveragescore(competitorScores) * 1.25;

				}

			}

			return OverallScore;
		}
		
		public String toString() {

			return getOverallScore() + "";
		}
		
		
		//method to print the score array
			public String getarrayofcompetitorScores() {
				return Arrays.toString(competitorScores);
			}

			
		

		@Override
		public String getfullDetails() {
			return "Competitor number " + competitorNumber + ", " + "name " + competitorName.getFullName() + ".\n"
					+ competitorName.getfirstName() + " is a " + competitorLevel + " aged " + competitorAge + " from " + competitorLocation + " and received these scores: "
					+ getarrayofcompetitorScores().replace("[", " ").replace("]", " ") + "\nThis gives them an overall score of "
					+ getOverallScore() + ".";
		}

}
