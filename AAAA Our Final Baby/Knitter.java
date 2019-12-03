package lekrws1rrp3Assignment2;

/** Software Engineering Foundations
 * Assignment 2
 * The class for the competitors who are in the Knitting competition.
 * Constructs the Knitter object and calculates the various
 * statistics and detail reportS required for the application.
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

import java.util.Arrays;

public class Knitter extends Competitor {

	/**
	 * The constructor for the Knitter class
	 * 
	 * @param competition  the competition the competitor is in
	 * @param competitorNumber  the competitor's competitor number
	 * @param competitorName  the competitor's name
	 * @param competitorLevel  the competitor's level
	 * @param competitorLocation  the competitor's location
	 * @param competitorAge  the competitor's age
	 * @param competitorScores  the competitor's scores
	 */
	public Knitter(String competition, int competitorNumber, Name competitorName, String competitorLevel,
			String competitorLocation, int competitorAge, int[] competitorScores) {

		super(competition, competitorNumber, competitorName, competitorLevel, competitorLocation, competitorAge,
				competitorScores);
	}
 
	/**
	 * Returns the competitor's highest three scores received
	 * @return top three scores
	 */
	public int[] getTopThree() {
		Arrays.sort(competitorScores);
		int max1 = competitorScores[2];
		int max2 = competitorScores[3];
		int max3 = competitorScores[4];
		int[] topThree = { max1, max2, max3 };
		return topThree;
	}

	/**
	 * Returns the scores for round 1
	 * @return round 1 scores
	 */
	public int getScores1() {
		return competitorScores[0];
	}

	/**
	 * Returns the scores for round 2
	 * @return round 2 scores
	 */
	public int getScores2() {
		return competitorScores[1];
	}

	/**
	 * Returns the scores for round 3
	 * @return round 3 scores
	 */
	public int getScores3() {
		return competitorScores[2];
	}

	/**
	 * Returns the scores for round 4
	 * @return round 4 scores
	 */
	public int getScores4() {
		return competitorScores[3];
	}

	/**
	 * Returns the scores for round 5
	 * @return round 5 scores
	 */
	public int getScores5() {
		return competitorScores[4];
	}

	/**
	 * Calculates and returns the competitor's highest score
	 * @return
	 */
	public int getHighestScore() {
		// sets the highest score the the first number in the array
		int highestScore = competitorScores[0];
		// iterates through the score array
		for (int scoreIndex = 1; scoreIndex < competitorScores.length; scoreIndex++) {
			// replaces highest score if a higher value is found
			if (competitorScores[scoreIndex] > highestScore) {
				highestScore = competitorScores[scoreIndex];
			}
		}
		// returns highest score
		return highestScore;
	}

	/**
	 * Calculates and returns gets the competitor's lowest score
	 * @return lowest score
	 */
	public int getLowestScore() {
		// sets the lowest score the the first number in the array
		int lowestScore = competitorScores[0];
		// iterates through the score array
		for (int scoreIndex = 1; scoreIndex < competitorScores.length; scoreIndex++) {
			// replaces lowest score if a lower value is found
			if (competitorScores[scoreIndex] < lowestScore) {
				lowestScore = competitorScores[scoreIndex];
			}
		}
		// returns lowest score
		return lowestScore;
	}

	/**
	 * Calculates and returns the competitor's overall score
	 * @return overall score
	 */
	public double getOverallScore() {
		// sets the total to 0
		int total = 0;
		// iterates through the competitor's top three scores
		for (int topScoresIndex = 0; topScoresIndex < getTopThree().length; topScoresIndex++) {
			// adds to the total if a higher value is found
			total += getTopThree()[topScoresIndex];
		}
		// calculates average
		return (double) total / getTopThree().length;
	}

	/**
	 * Calculates and returns the competitor's average score
	 * @return average score
	 */
	public double getAverage() {
		// sets the total to 0
		double total = 0;
		// searches through the score array
		for (int i = 0; i < competitorScores.length; i++) {
			// adds to the total if a higher value is found
			total += competitorScores[i];
		}
		// calculates average
		return (double) total / competitorScores.length;
	}

	/**
	 * Converts the score array to a String array to be readable
	 *@return result  String of scores
	 */
	public String getarrayofcompetitorScores() {
		String result = Arrays.toString(getScoreArray());
		try {
			// removes the brackets
			result = result.substring(1, 14);
		}
		// catch if there are scores missing from array
		// system exit
		catch (StringIndexOutOfBoundsException sir) {
			String error = "Scores are missing from list";
			System.out.println(error);
			System.exit(0);
		}
		return result;
	}

	/**
	 * Converts overall score to a String to be readable
	 * @return String of overall score
	 */
	public String toString() {
		return String.format("%.2f", getOverallScore()) + "";
	}

	/**
	 * Returns a string containing the short details of the competitor
	 * @return  the competitor's short details
	 */
	public String getShortDetails() {
		return "CN " + competitorNumber + " (" + competitorName.getInititals() + ") " + "has overall score "
				+ String.format("%.2f", getOverallScore());
	}

	/**
	 * Returns a string containing the full details of the competitor
	 * @return  the competitor's short details
	 */
	public String getfullDetails() {
		return competitorName.getFullName() + " is an " + competitorLevel + " knitter and has come from "
				+ competitorLocation + " to compete in the competition. \n"
				// + "Their favourite thing they have knitted prior to entering the competition
				// was a '" + favouriteKnit + "'.\n"
				+ competitorName.getfirstName() + " received the following scores for each round: "
				+ getarrayofcompetitorScores() + ".\n" + "This gives " + competitorName.getfirstName()
				+ " an overall score of " + String.format("%.2f", getOverallScore()) + ".";
	}

}
