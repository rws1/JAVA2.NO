package assignment1;

import java.util.Arrays;
import java.util.Date;

public class LEKCompetitor {

	private int competitorNumber;
	private String competitorExperience;
	private String competitorLocation;
	private Name competitorName;
	private Date dob;
	private int [] scores = new int [5];	

	public LEKCompetitor (int competitorNumber, Name competitorName, String competitorExperience, String competitorLocation, Date dob, int [] scores) {		
		this.competitorNumber = competitorNumber;
		this.competitorExperience = competitorExperience;
		this.competitorLocation = competitorLocation;
		this.competitorName = competitorName;
		this.dob = dob;
		this.scores = scores;
	}
	//get the array of scores
	public int [] getScoreArray() {
		return scores;
	}
	//get the competitor number
	public int getCompetitorNumber() {
		return competitorNumber;
	}
	//get the competitor experience
	public String getCompetitorExperience() {
		return competitorExperience;
	}
	//get the competitor location
	public String getCompetitorLocation() {
		return competitorLocation;
	}
	//get the competitor's name
	public Name getCompetitorName() {
		  return competitorName; 
	}
	//get the competitor's date of birth
	public Date getDOB() {
		  return dob; 
	}
	//get the competitor's highest three scores received
	public int [] getTopThree() {
		Arrays.sort(scores);
		int max1 = scores[2];
		int max2 = scores[3];
		int max3 = scores[4];
		int [] topThree = {max1, max2, max3};
		return topThree;
	}
	//get the scores for round 1
	public int getScores1() {
		return scores[0];
	}
	//get the scores for round 2
	public int getScores2() {
		return scores[1];
	}
	//get the scores for round 3
	public int getScores3() {
		return scores[2];
	}
	//get the scores for round 4
	public int getScores4() {
		return scores[3];
	}
	//get the scores for round 5
	public int getScores5() {
		return scores[4];
	}
	//get the competitor's highest score
	public int getHighestScore() {
		//sets the highest score the the first number in the array
		int highestScore = scores[0];
		//iterates through the score array
		for (int scoreIndex = 1; scoreIndex < scores.length; scoreIndex++) {
			// replaces highest score if a higher value is found
			if (scores[scoreIndex] > highestScore) {
				highestScore = scores[scoreIndex];
			}
		}
		//returns highest score
		return highestScore;
	}
	//gets the competitor's lowest score
	public int getLowestScore() {
		//sets the lowest score the the first number in the array
		int lowestScore = scores[0];
		//iterates through the score array
		for (int scoreIndex = 1; scoreIndex < scores.length; scoreIndex++) {
			// replaces lowest score if a lower value is found
			if (scores[scoreIndex] < lowestScore) {
				lowestScore = scores[scoreIndex];
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
			for (int i = 0; i < scores.length; i++) {
			// adds to the total if a higher value is found
			total += scores[i];
			}
			//calculates average
			return (double) total/scores.length;
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

	//display full details
	public String getFullDetails() { 
		return "Full details for competitor " + competitorNumber + ":\n"
				+ competitorName.getFullName() + " is an "
				+ competitorExperience + " knitter and has come from "
				+ competitorLocation + " to compete in the competition. \n"
				//+ "Their favourite thing they have knitted prior to entering the competition was a '" + favouriteKnit + "'.\n"
				+ competitorName.getFirstName() + " received the following scores for each round: "
				+ getDisplayScores() + ".\n"
				+ "This gives " + competitorName.getFirstName() 
				+ " an overall score of " + String.format("%.1f",getOverallScore()) + ".";
	}

	//display short details
	public String getShortDetails()
	{ return "CN " + competitorNumber + " (" + competitorName.getInitials() + ") has overall score " + String.format("%.1f",getOverallScore()); }
}
