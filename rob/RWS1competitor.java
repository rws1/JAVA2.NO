import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * RWS1competitor represents an athlete in a competition.
 * 
 * @author RWS1
 *
 */

public class RWS1competitor {

	// -- create basic instance variables

	private int competitorNumber;
	private RWS1Name competitorName;
	private String competitorLevel;
	private String nationality;
	private int numberOfAppearances;
	private int Age;
	private int score1;
	private int score2;
	private int score3;
	private int score4;
	private int score5;
	private RWS1Name lastName;
	private RWS1Name competitorInitials;

	/**
	 * 
	 * - Initialises and constructs a Competitor in a competition using the
	 * parameters (cNum,CompetitorName, cLev, born, NoA, s1, s2, s3, s4, s5).
	 * These are used when the ArrayList "competitorsList" is iterated through
	 * on a per competitor basis.
	 * 
	 * @param cNum
	 *            - competitor Number
	 * @param CompetitorName
	 *            - competitors Name,
	 * @param cLev
	 *            - competitors level
	 * @param born
	 *            - competitors country of origin
	 * @param NoA
	 *            - number of appearances for their country
	 * @param s1
	 *            - The first score the competitor achieved
	 * @param s2
	 *            - The second score the competitor achieved
	 * @param s3
	 *            - The third score the competitor achieved
	 * @param s4
	 *            - The fourth score the competitor achieved
	 * @param s5
	 *            - The five score the competitor achieved
	 */
	// num name lvl country age score (array with space) comma delimited 
	// -- constructor that takes an argument of int, RWS1Name Competitor
	// passed from the competitorList ArrayList.
	public RWS1competitor(int cNum, RWS1Name competitorName, String cLev, String born, int Age, int s1, int s2, int s3,
			int s4, int s5, int NoA) {
		this.competitorNumber = cNum;
		this.competitorName = competitorName;
		this.competitorLevel = cLev;
		this.nationality = born;
		this.Age = Age;
		this.score1 = s1;
		this.score2 = s2;
		this.score3 = s3;
		this.score4 = s4;
		this.score5 = s5;
		this.numberOfAppearances = NoA;
	}

	// -- set methods
	public void setCompetitorNumber(int competitorNumber) {
		this.competitorNumber = competitorNumber;
	}

	public void setCompetitorLevel(String competitorLevel) {
		this.competitorLevel = competitorLevel;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setAge(int Age) {
		this.Age = Age;
	}
	public void setNumberOfAppearances(int numberOfAppearances) {
		this.numberOfAppearances = numberOfAppearances;
	}

	public void setScore1(int S1) {
		this.score1 = S1;
	}

	public void setScore2(int S2) {
		this.score2 = S2;
	}

	public void setScore3(int S3) {
		this.score3 = S3;
	}

	public void setScore4(int S4) {
		this.score4 = S4;
	}

	public void setScore5(int S5) {
		this.score5 = S5;
	}

	public void setCompetitorName(RWS1Name competitorName) {
		this.competitorName = competitorName;
	}

	public void setLastName(RWS1Name lastName) {
		this.lastName = lastName;
	}

	public void setCompetitorInitials(RWS1Name competitorInitials) {
		this.competitorInitials = competitorInitials;
	}

	// - get methods
	public RWS1Name getCompetitorName() {
		return competitorName;
	}

	public RWS1Name getLastName() {
		return lastName;
	}

	public RWS1Name getCompetitorInitials() {
		return competitorInitials;
	}

	public int getCompetitorNumber() {
		return competitorNumber;
	}
	public int getAge() {
		return Age;
	}

	public String getCompetitorLevel() {
		return competitorLevel;
	}

	public String getNationality() {
		return nationality;
	}

	public int getNumberOfAppearances() {
		return numberOfAppearances;
	}

	/**
	 * - Creates weighted scores that depend on the competitor level of the
	 * athlete. The level of the athlete denotes the multiplication factor. The
	 * multiplication factor is multiplied by the average score of the athlete,
	 * to add an increasing handicap for the better athletes. If the athlete was
	 * a novice, their average score should be multiplied by 1.15. For each
	 * successive tier the multiplication factor is reduced by 0.05.
	 * 
	 * @return - the resulting score after manipulation, rounded to 2 decimal
	 *         places using the df function.
	 */

	public String getOverallScore() {
		double weightedScore;
			if (competitorLevel.equals("novice")) 
			{
				weightedScore = (getAvrgScore() * 1.15);
			} 
			else if (competitorLevel.equals("amateur")) 
			{
				weightedScore = (getAvrgScore() * 1.1);
			} 
			else if (competitorLevel.equals("semi-professional")) 
			{
				weightedScore = (getAvrgScore() * 1.05);
			}
			else 
			{
				weightedScore = (getAvrgScore() * 1);
			}

		return df.format(weightedScore);
	}

	// -- set decimal output, to 2 - only takes a string

	DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * Creates an array of 5 ints in length, and assigned the 5 scores to
	 * positions in that array
	 * 
	 * @return an array of the 5 scores the athlete achieved.
	 */

	// - Create scores array from
	public int[] getScoreArray() {
		int[] scoresArray = (int[]) Array.newInstance(int.class, 5);
		Array.set(scoresArray, 0, score1);
		Array.set(scoresArray, 1, score2);
		Array.set(scoresArray, 2, score3);
		Array.set(scoresArray, 3, score4);
		Array.set(scoresArray, 4, score5);
		return scoresArray;
	}

	/**
	 * Creates an average score for the athlete. It iterates along the length of
	 * the score array 'getscoresArray' then adds them to the int 'totScore'.
	 * using the .length function it then finds the length of the array and
	 * divides that by the sum of those scores in the 'totscore' int.
	 * 
	 * @return a mean average score for the athlete
	 */
	// -- Find the average mark over the 5 scores
	public double getAvrgScore() {
		int totScore = 0;
		for (int HiScoreIndex = 0; HiScoreIndex < getScoreArray().length; HiScoreIndex++) {
			totScore += getScoreArray()[HiScoreIndex];
		}
		return (totScore / getScoreArray().length);
	}

	/**
	 * Converts the array 'getscoresReport()' to a string by calling the
	 * Arrays.toString(ArrayX) function on it.
	 * 
	 * @return Scores as a String, eg [0,0,0,0,0]
	 */

	public String getscoresReport() {
		return Arrays.toString(getScoreArray());
	}

	/**
	 * Creates a String report of the full details of an athlete. It calls the
	 * getCompetitorName and getLastName function on the variable
	 * 'competitorName' to import the full name and last name of the athlete,
	 * respectively. It uses the get methods getscoresReport(),
	 * getHiScore(),getAvrgScore(), getWeightedScore() to obtain a string of
	 * scores,
	 * 
	 * @return a report of the full details of an athlete, including competitor
	 *         number, Name, Nationality, competitorLevel, Number of
	 *         Appearances, a string of scores, their set of 5 scores, their
	 *         average score and their weighted score.
	 */

	// -- Full Details report
	public String getFullDetails() {
		return competitorName.getCompetitorName() + "(CN " + competitorNumber + ") , " + "who competes for "
				+ nationality + ". " + competitorName.getLastName() + " is a " + competitorLevel + ", "
				+ "who has competed " + numberOfAppearances + " times for their country.\n"
				+ "They achieved scores of " + getscoresReport().replace("[", "").replace("]", "") + ","
				+ " this gives them a high score of " + getHiScore() + " and an average score of " + getAvrgScore()
				+ ", weighted by level to " + getOverallScore() + ".";
	}

	/**
	 * Creates a short report of the competitors details. It comprises of the
	 * competitor number, the initials of the athlete (attained by calling the
	 * getCompetitorInitials function on the competitor name variable), the
	 * average score from the getAvrgScore() function and the weighted score
	 * from the getWeightedScore() function.
	 * 
	 * @return
	 */

	// -- Short Details
	public String getShortDetails() {
		return "CN " + competitorNumber + " " + "(" + competitorName.getCompertitorInitials() + ") "
				+ "has overall score " + getOverallScore() + ".";

	}

	public RWS1Name getRWS1Name() {
		return competitorName;
	}

	/**
	 * creates an int of the highest score of the athlete. It iterates along the
	 * length of the score array 'getscoresArray' and creates an int 'HiScore'
	 * where its value is the value held at the first index position within the
	 * 'getscoresArray'. As it iterates along the array, if the value is higher
	 * than that index of the previous one, it then changes that to be the new
	 * [0] index.
	 * 
	 * @return the highest score of the athlete.
	 */
	// -- Set index 0 to highest score, if new score is higher, make that the
	// new index 0. Returns highest score, held in position [0]
	public int getHiScore() {
		int HiScore = getScoreArray()[0];
		for (int SecScoreIndex = 1; SecScoreIndex < getScoreArray().length; SecScoreIndex++) {
			if (getScoreArray()[SecScoreIndex] > HiScore) {
				HiScore = getScoreArray()[SecScoreIndex];
			}
		}
		return HiScore;

	}
}
// --------------------------------------------------------------------------------------------------------------------------------

// websites used to aid the creation of this class:

// parsing array files in java: https://www.youtube.com/watch?v=xQeVddbMIT8
// Array help: https://www.geeksforgeeks.org/arrays-in-java/
// printing an array: https://www.mkyong.com/java/java-how-to-print-an-array/
// print array without brackets:
// https://forum.tutorials7.com/1546/how-print-arraylist-without-the-square-brackets-and-in-java
// https://www.tutorialspoint.com/javareflect/javareflect_array_set.htm