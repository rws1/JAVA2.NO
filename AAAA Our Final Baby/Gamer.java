package lekrws1rrp3Assignment2;

/** Software Engineering Foundations
 * Assignment 2
 * The class for the competitors who are in the Gaming competition.
 * Constructs the Gamer object and calculates the various
 * statistics and detail reportS required for the application.
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */


import java.util.Arrays;

public class Gamer extends Competitor {

	/**
	 * The constructor for the Gamer class
	 * 
	 * @param competition  the competition the competitor is in
	 * @param competitorNumber  the competitor's competitor number
	 * @param competitorName  the competitor's name
	 * @param competitorLevel  the competitor's level
	 * @param competitorLocation  the competitor's location
	 * @param competitorAge  the competitor's age
	 * @param competitorScores  the competitor's scores
	 */
	public Gamer(String competition, int competitorNumber, Name competitorName, String competitorLevel,
			String competitorLocation, int competitorAge, int[] competitorScores) {

		super(competition, competitorNumber, competitorName, competitorLevel, competitorLocation, competitorAge,
				competitorScores);
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
	 * Iterates through the array of scores to
	 * calculate the average of the given scores
	 * @param competitorScores
	 * @return average score
	 */
	public double getAveragescore(int[] competitorScores) {

		int sum = 0;
		double average = 0;
		for (int i = 0; i < competitorScores.length; i++)
			sum = sum + competitorScores[i];
		average = sum / competitorScores.length;
		return average;
	}

	/**
	 * Calculates and returns the competitor's overall score
	 * using a weighted average
	 * @return overall score
	 */
	public double getOverallScore() {
		double OverallScore; 
			if (competitorLevel.equals("Professional")) {
				OverallScore = getAveragescore(competitorScores) * 1.75;
			} 
			else if (competitorLevel.equals("Veteran")) {
				OverallScore = getAveragescore(competitorScores) * 1.5;
			} 
			else {
				OverallScore = getAveragescore(competitorScores) * 1.25;
			}
		return OverallScore;
	}

	/**
	 * Converts overall score to a String to be readable
	 * 
	 * @return String of overall score
	 */
	public String toString() {
		return "" + String.format("%.2f", getOverallScore());
	}

	/**
	 * Converts the score array to a String array to be readable
	 * 
	 * @return result String of scores
	 */
	public String getarrayofcompetitorScores() {
		return Arrays.toString(competitorScores);
	}

	/**
	 * Returns a string containing the short details of the competitor
	 * 
	 * @return the competitor's short details
	 */
	public String getShortDetails() {
		return "CN " + competitorNumber + " (" + competitorName.getInititals() + ") " + "has overall score "
				+ String.format("%.2f", getOverallScore());
	}

	/**
	 * Returns a string containing the full details of the competitor
	 * 
	 * @return the competitor's full details
	 */
	public String getfullDetails() {
		return "Competitor number " + competitorNumber + ", " + "name " + competitorName.getFullName() + ".\n"
				+ competitorName.getfirstName() + " is a " + competitorLevel + " aged " + competitorAge + " from "
				+ competitorLocation + " and received these scores: "
				+ getarrayofcompetitorScores().replace("[", " ").replace("]", " ")
				+ "\nThis gives them an overall score of " + String.format("%.2f", getOverallScore()) + ".";
	}
}
