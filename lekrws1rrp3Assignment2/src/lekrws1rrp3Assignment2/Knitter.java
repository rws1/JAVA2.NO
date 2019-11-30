package lekrws1rrp3Assignment2;

import java.util.Arrays;

public class Knitter extends Competitor implements Competitordetails{
	
	public Knitter (String competition, int competitorNumber, Name competitorName, String competitorLevel, String competitorLocation,int competitorAge,
			int[] competitorScores) {

			super (competition, competitorNumber, competitorName, competitorLevel, competitorLocation, competitorAge, competitorScores);
			
						
			}
			
		
			
			//get the competitor's highest three scores received
			public int [] getTopThree() {
				Arrays.sort(competitorScores);
				int max1 = competitorScores[2];
				int max2 = competitorScores[3];
				int max3 = competitorScores[4];
				int [] topThree = {max1, max2, max3};
				return topThree;
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
			
			
			//get the competitor's highest score
			public int getHighestScore() {
				//sets the highest score the the first number in the array
				int highestScore = competitorScores[0];
				//iterates through the score array
				for (int scoreIndex = 1; scoreIndex < competitorScores.length; scoreIndex++) {
					// replaces highest score if a higher value is found
					if (competitorScores[scoreIndex] > highestScore) {
						highestScore = competitorScores[scoreIndex];
					}
				}
				//returns highest score
				return highestScore;
			}
			
			
			//gets the competitor's lowest score
			public int getLowestScore() {
				//sets the lowest score the the first number in the array
				int lowestScore = competitorScores[0];
				//iterates through the score array
				for (int scoreIndex = 1; scoreIndex < competitorScores.length; scoreIndex++) {
					// replaces lowest score if a lower value is found
					if (competitorScores[scoreIndex] < lowestScore) {
						lowestScore = competitorScores[scoreIndex];
					}
				}
				//returns lowest score
				return lowestScore;
			}
			
			
			//get the competitor's overall score
			public double getOverallScore() {
				//sets the total to 0
				int total = 0;
				//iterates through the competitor's top three scores
				for (int topScoresIndex = 0; topScoresIndex < getTopThree().length; topScoresIndex++) {
					// adds to the total if a higher value is found
					total += getTopThree()[topScoresIndex];
				}
				//calculates average
				return (double) total/getTopThree().length;
			}
			
			public double getAverage() {
				//sets the total to 0
				double total = 0;
				//searches through the score array 
					for (int i = 0; i < competitorScores.length; i++) {
					// adds to the total if a higher value is found
					total += competitorScores[i];
					}
					//calculates average
					return (double) total/competitorScores.length;
			}
			
			//converts the score array to a string to be readable
			public String getDisplayScores() {
				String result = Arrays.toString(getScoreArray());
				try {
					//removes the brackets
					result = result.substring(1,14);
				}
				//catch if there are scores missing from array
				//system exit
				catch (StringIndexOutOfBoundsException sir) {
					String error = "Scores are missing from list";
					System.out.println(error);
					System.exit(0);
				}		
				return result;
			}
			
			public String toString() {

				return getOverallScore() + "";
			}
					
			

			//display full details
			public String getfullDetails() { 
				return "Full details for competitor " + competitorNumber + ":\n"
						+ competitorName.getFullName() + " is an "
						+ competitorLevel + " knitter and has come from "
						+ competitorLocation + " to compete in the competition. \n"
						//+ "Their favourite thing they have knitted prior to entering the competition was a '" + favouriteKnit + "'.\n"
						+ competitorName.getfirstName() + " received the following scores for each round: "
						+ getDisplayScores() + ".\n"
						+ "This gives " + competitorName.getfirstName() 
						+ " an overall score of " + String.format("%.1f",getOverallScore()) + ".";
			}
			
				

}
