package lekrws1rrp3Assignment2;

/** Software Engineering Foundations
 * Assignment 2
 * GUI to allow the user to search for a competitor
 * and display either that competitor's
 * full details or short details
 * On close it writes the report to a text file.
 * The Competitor class is inherited by Dancer, Gamer and Knitter classes.
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

public abstract class Competitor {
	protected String competition;
	protected int competitorNumber;
	protected Name competitorName;
	protected String competitorLevel;
	protected String competitorLocation;
	protected int competitorAge;
	protected int[] competitorScores;

	/**
	 * The constructor for the competitor class
	 * 
	 * @param C  the competition the competitor is in
	 * @param cNo  the competitor's competitor number
	 * @param cNa  the competitor's name
	 * @param cL  the competitor's level
	 * @param cLo   the competitor's location
	 * @param cage  the competitor's age
	 * @param cS  the competitor's scores
	 */
	public Competitor(String C, int cNo, Name cNa, String cL, String cLo, int cage, int[] cS) {
		competition = C;
		competitorNumber = cNo;
		competitorName = cNa;
		competitorLevel = cL;
		competitorLocation = cLo;
		competitorAge = cage;
		competitorScores = cS;
	}

	/**
	 * Returns the competitor's competition
	 * @return  competition
	 */
	public String getcompetition() {
		return competition;
	}

	/**
	 * Returns the competitor's competitor number
	 * @return  competitor number
	 */
	public int getcompetitorNumber() {
		return competitorNumber;
	}

	/**
	 * Returns the competitor's name
	 * @return  competitor name
	 */
	public Name getName() {
		return competitorName;
	}

	/**
	 * Returns the competitor's level
	 * @return competitor level
	 */
	public String getcompetitorLevel() {
		return competitorLevel;
	}

	/**
	 * Returns the competitor's location
	 * @return competitor location
	 */
	public String getcompetitorLocation() {
		return competitorLocation;
	}

	/**
	 * Returns the competitor's age
	 * @return  competitor age
	 */
	public int getAge() {
		return competitorAge;
	}

	/**
	 * Returns the competitor's array of scores
	 * @return  competitor scores
	 */
	public int[] getScoreArray() {
		return competitorScores;
	}

	/**
	 * Sets the competitor's name
	 * @param competition
	 */
	public void setcompetition(String competition) {
		this.competition = competition;
	}

	/**
	 * Sets the competitor's competitor number
	 * @param competitorNumber
	 */
	public void setcompetitorNumber(int competitorNumber) {
		this.competitorNumber = competitorNumber;
	}

	/**
	 * Sets the competitor's name
	 * @param competitorName
	 */
	public void setName(Name competitorName) {
		this.competitorName = competitorName;
	}

	/**
	 * Sets the competitor's level
	 * @param competitorLevel
	 */
	public void setcompetitorLevel(String competitorLevel) {
		this.competitorLevel = competitorLevel;
	}

	/**
	 * Sets the competitor's location
	 * @param competitorLocation
	 */
	public void setcompetitorLocation(String competitorLocation) {
		this.competitorLocation = competitorLocation;
	}

	/**
	 * Sets the competitor's age
	 * @param competitorAge
	 */
	public void setAge(int competitorAge) {
		this.competitorAge = competitorAge;
	}

	/**
	 * Sets the competitor's array of scores
	 * @param competitorScores
	 */
	public void setcompetitorScores(int[] competitorScores) {
		this.competitorScores = competitorScores;
	}

	/**
	 * Returns a string containing the short details of the competitor
	 * @return  the competitor's short details
	 */
	public String getshortDetails() {
		return "CN " + competitorNumber + " (" + competitorName.getInititals() + ") " + "has overall score "
				+ toString();
	}

	/**
	 * Returns the overall score for a competitor
	 * @return  overall score for competitor
	 */
	public abstract double getOverallScore();

	/**
	 * Returns the full details for a competitor
	 * @return  full details of competitor
	 */
	public abstract String getfullDetails();

	/**
	 * Returns the array of scores for a competitor
	 * @return  score array for competitor
	 */
	protected abstract String getarrayofcompetitorScores();
}
