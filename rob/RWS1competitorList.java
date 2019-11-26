import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;
/**
 * Reads and processes a file input from the manager class, to create statistical output including writing a report . Creates an Arraylist 'competitorsList' from the
 * input file and populates it, allows other methods to interrogate to obtain the required information. 
 * @author rws1
 *
 */
public class RWS1competitorList {

	// creates a private arraylist using the competitor class
	private ArrayList<RWS1competitor> competitorsList;

	//creates a public arraylist, accessible by the manager class. 
	public RWS1competitorList() {
		competitorsList = new ArrayList<RWS1competitor>();
	}

	// Function to allow addition of competitors (lines) to be added to the competitorsList via .add(c). 
	public void add(RWS1competitor c) {
		competitorsList.add(c);
	}

	/**
	 * Iterates through the lines of an arrayList 'Competitors List', calling 7 methods and
	 * formatting tools on these lines and appends them them to an output
	 * string, 'report'.
	 * 
	 * @return report
	 */
	// gets information on all the competitors added to the arrayList,
	// competitors list.
	public String getAllCompetitors() {
		String report = "";
		for (RWS1competitor c : competitorsList) {

			report += "  ";
			report += String.format("%-10d", c.getCompetitorNumber());
			report += String.format("%-30s", c.getRWS1Name().getFullName());
			report += String.format("%-25s", c.getCompetitorLevel());
			report += String.format("%-20s", c.getNationality());
			report += String.format("%-10d", c.getNumberOfAppearances());
			report += c.getscoresReport().replace("[", "").replace("]", ""); // 13
			report += "     ";
			report += String.format("%-10s", c.getOverallScore());
			report += "\n";
		}
		return report;

	}

	/**
	 * Uses a lines unique number to search through an arraylist. If a matching
	 * number is found the current number is not added(false), if not it is
	 * added(true). Prevents duplicate lines in the arraylist.
	 * 
	 * @param c a potential new line for an arraylist.
	 * @return boolean true / false
	 */
	// Gets the competitor number and checks if its already in the Arraylist.
	// if not, return true and add line c to Arraylist 'competitorsList'
	public boolean addUniqueCompetitor(RWS1competitor c) {
		int competitorNumber = c.getCompetitorNumber();
		RWS1competitor inList = this.getByCompNo(competitorNumber);
		if (inList == null) {
			this.competitorsList.add(c);
			return true;
		}
		System.out.println("\nA duplicate competitor number was found in for competitor :\n" + c.getCompetitorNumber()
				+ ", " + c.getRWS1Name().getFullName()
				+ "\nThis line was ignored to prevent duplicate athele representation.\n");

		return false;
	}

	// Returns number of competitors (lines/elements)
	public int getNoCompetitors() {
		return competitorsList.size();
	}

	/**
	 * Uses a unique number to search an arraylist and return that line, if
	 * present.
	 * 
	 * @param cNumber the unique competitor number
	 * @return c the line of information containing the matching number
	 */
	// searches the Arraylist for a cNumber. returns the competitor at a given
	// position of the index
	public RWS1competitor getByCompNo(int cNumber) {
		for (RWS1competitor c : competitorsList) {
			if (c.getCompetitorNumber() == (cNumber)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Calculates the average score of all competitors across the whole
	 * competition
	 * 
	 * @return average score
	 */
	public double getOverallAvrgSc() {
		double total = 0;

		for (RWS1competitor c : competitorsList) {
			total += Double.parseDouble(c.getOverallScore());
		}
		return total / getNoCompetitors();
	}

	/**
	 * Calculate the percentage difference between the average score this year
	 * vs 'last years'.
	 * 
	 * @return String rounded percentage difference between years scores
	 */
	public String getPercDif() {
		double lastYearsAvrg = 3.42;
		double total = ((getOverallAvrgSc() - lastYearsAvrg) / (((getOverallAvrgSc() + lastYearsAvrg)) / 2));
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(total);
	}

	/**
	 * Helps generate the statistical report. Gives appropriate wording ie
	 * "increase or decrease" for scores. Creates fully dynamic statistics in
	 * the report, based on the results of getPercDif.
	 * 
	 * @return String "percent increase", "percent decrease" or "did not change"
	 */
	public String getIncOrDec() {
		String word;
		double number = Double.parseDouble(getPercDif());
		if (number > 0) {
			word = " percent increase";
		} else if (number < 0) {
			word = " percent decrease";
		} else {
			word = "did not change";
		}
		return word;
	}

	/**
	 * Calculates the winner of the competition by iterating through the
	 * competitorsList. It creates two variables, one empty string 'WinnerName'
	 * and an int 'winnerScore' set to 0. It then iterates through the rest of
	 * the arraylist and compares each successive to the 'winnerScore'. If its
	 * higher, then the winnerScore is set to this and other details from the
	 * line are also taken.
	 * 
	 * @return String winnerName, score and other details.
	 */
	public String getWinnerDetails() {
		double winnerScore = 0;
		String winnerName = "";
		String winnerDetails = "";
		for (RWS1competitor c : competitorsList) {
			if (Double.parseDouble(c.getOverallScore()) > winnerScore) {
				winnerScore = Double.parseDouble(c.getOverallScore());
				winnerName = c.getRWS1Name().getCompetitorName();
				winnerDetails = c.getFullDetails();
			}
		}
		return winnerName + " won this years competition with a score of " + winnerScore
				+ ".\n\n| WINNER SPOTLIGHT | \n\n" + winnerDetails;
	}

	/**
	 * Calculates the competitor with the most appearances. It creates an int 'maxA' to hold the maximum value for appearances, set to 0. It then loops through
	 * competitors list and uses the getNumberOfAppearances method to compare successive lines value of appearances to maxA. If the current line 
	 * getNumberOfAppearances > maxA, that line value becomes the new maxA, at this point it then uses getRWS1Name().getFullName() to acquire the full name
	 *  of the competitor held in this line and stores it in the 'name' String. 
	 * 
	 * @return String of max appearances and some description 
	 */
	public String getMaxApps() {
		int maxA = 0;
		String name = "";
		for (RWS1competitor c : competitorsList) {
			int maxA2 = c.getNumberOfAppearances();
			if (maxA2 > maxA) {
				maxA = maxA2;
				name = c.getRWS1Name().getFullName();
			}
		}
		return "The most experienced competitor in this competition is" + name + "with a total of " + maxA
				+ " appearances.";

	}

	private ArrayList<Integer> allScores = new ArrayList<>();

	/**
	 * Generates a frequency report of each score given across the competition.
	 * It does this by adding all the scores to an arrayList 'allScores', using
	 * a nested for loop. It loops through the competitors list, gets each
	 * competitors scores array, using getScoreArray method. Another for loop is
	 * then used to add the individual ints of the scores arrays to the
	 * 'allScores' arraylist, as they cannot be added as a whole. A third for
	 * loop then counts from 0 to 6. While this occurs the collections.frequency
	 * function is using the number in tandem to search the arraylist for that
	 * number and adds +1 to the Freq array, at the number -1. This results in
	 * an array with a count of each score, at each successive index of the Freq
	 * array.
	 * 
	 * @return frequency report of scores
	 */
	public String getFrequencyCount() {
		int maxCount = 6;
		int[] Freq = new int[maxCount];
		for (RWS1competitor c : competitorsList) {
			int[] x = c.getScoreArray();
			for (int i = 0; i < (x).length; i++) {
				allScores.add(x[i]);
			}
		}

		for (int i = 0; i < maxCount; i++) {
			int occurences = Collections.frequency(allScores, i);
			Freq[i] = occurences;
		}

		String report = "The frequency of the scores given by the five judges were:\n"
				+ "     Score : 0\t1\t2\t3\t4\t5\n Frequency : ";
		for (int i = 0; i < Freq.length; i++) {
			report += Freq[i] + "\t";
		}

		return report;

	}

	private ArrayList<String> allLevels = new ArrayList<>();

	/**
	 * Generates a frequency report of competitor levels across the competition.
	 * It does this by adding all the levels to an arrayList 'allLevels', using
	 * a for loop. It loops through the competitors list and gets each
	 * competitors level, using getCompetitorLevel method and adds them to the
	 * arrayList.
	 * 
	 * A second for loop then counts from 0 to 4. While this occurs the
	 * collections.frequency function is using the number in tandem with a for
	 * loop, looping through the parts of the divLevels array to search the
	 * arraylist for that String and adds +1 to the Freq array, at the number
	 * -1. This results in an array with a count of each level, at each
	 * successive index of the Freq array.
	 * 
	 * @return frequency report of competitor levels
	 */

	public String getCompLevelCount() {
		int[] Freq = new int[4];
		for (RWS1competitor c : competitorsList) {
			String x = c.getCompetitorLevel();
			allLevels.add(x);
		}
		String[] divLevels = { "novice", "amateur", "semi-professional", "professional" };

		for (int i = 0; i < 4; i++) {
			int occurences = Collections.frequency(allLevels, divLevels[i]);
			Freq[i] = occurences;
		}
		String report = "The frequency of the different competitor levels were:\n      Type : "
				+ "novice             amateur            semi-professional  professional\n Frequency : ";
		for (int i = 0; i < Freq.length; i++) {
			report += Freq[i] + "                  ";
		}

		return report;
	}

	/**
	 * Writes a report file a .txt output. Uses the report generated by
	 * getAllCompetitors and the report handed from the manager. Adds some
	 * visual elements as strings and statistics generated using the get methods
	 * held within the class to create a final report to write to file.
	 * 
	 * @param report the report generated by the getAllCompetitors() method.
	 */

	// Adds visual elements to the basic report generated, then writes to output
	// file
	public void writeToFile(String RWS1Report, String report) {

		FileWriter fw;
		try {
			fw = new FileWriter(RWS1Report);
			fw.write("\n| EDINBURGH ANNUAL BALLROOM DANCING SCORES | Sponsored by Robgen, a JavaNovice Partner\n"
					+ "___________________________________________________________________________________________________________________________________\n"
					+ "  CN        Competitor Name               Competitor Level         Nationality         NoA       Scores            Weighted Score\n"
					+ "-----------------------------------------------------------------------------------------------------------------------------------\n"
					+ report
					+ "__________________________________________________________________________________________________________________________________\n"
					+ " CN = Competitor Number          |\n" + " NoA = Number of Appearances     |\n"
					+ "_________________________________|\n");
			fw.write("\n\n| STATISTICS |" + "\n\nThis years competition saw " + getNoCompetitors()
					+ "competitors compete across the event, all bidding to impress the 5 judges.\n" + getMaxApps()
					+ "\n" + "The average overall score achieved by a competitor in this event was "
					+ getOverallAvrgSc() + ", which is a " + (getPercDif().replace("-", "")) + getIncOrDec()
					+ " from last year.\n" + "\n" + getFrequencyCount() + "\n\n" + getCompLevelCount() + "\n\n"
					+ getWinnerDetails());

			fw.close();
		} catch (FileNotFoundException fnf) {
			System.out.println(RWS1Report + "report not found");
			System.exit(0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Parsing the CSV file using scanner. Takes a file and iterates along the
	 * lines of the file, storing each line as a variable which is then
	 * processed by the 'readcsvfile' function.
	 * 
	 * @param filename the name of the input file
	 */
	// Reads file passed from scanner on line at a time, passes lines to
	// processCsvLine.
	public void readFile(String filename) {
		try {
			File c = new File(filename);

			Scanner inputStream = new Scanner(c);
			while (inputStream.hasNextLine()) {
				String inputCsvLine = inputStream.nextLine();
				if (inputCsvLine.length() != 0) {
					;
					processCsvLine(inputCsvLine);
				}
			}
			inputStream.close();
		}
		// - has next line to prevent I/O errors
		catch (FileNotFoundException fnf) {
			System.out.println(filename + "file name not found, or wrong format");
			System.exit(0);
		}
	}

	/**
	 * Processes the output from scanner "cLine" by splitting the output using
	 * comma delimiters and storing them in an array. These array parts are then
	 * assigned to variables.
	 * 
	 * @param cLine the string output from scanner
	 */

	// - processes the String scanner produces by storing them in an array.
	private void processCsvLine(String cLine) {
		try {
			String parts[] = cLine.split(",");
			String scNum = parts[0];
			int cNum = Integer.parseInt(scNum);
			// RWS1Name fullName = new RWS1Name(parts[1]);
			RWS1Name CompetitorName = new RWS1Name(parts[1], parts[2], parts[3]);
			String cLev = parts[4];
			String born = parts[5];
			String sAge = parts[6];
			// convert strings to integers
			int Age = Integer.parseInt(sAge);
			String ss1 = parts[7];
			int s1 = Integer.parseInt(ss1);
			String ss2 = parts[8];
			int s2 = Integer.parseInt(ss2);
			String ss3 = parts[9];
			int s3 = Integer.parseInt(ss3);
			String ss4 = parts[10];
			int s4 = Integer.parseInt(ss4);
			String ss5 = parts[11];
			int s5 = Integer.parseInt(ss5);
			String sNoA = parts[12];
			int NoA = Integer.parseInt(sNoA);
			
			// constructor for processCsvLine
			RWS1competitor c = new RWS1competitor(cNum, CompetitorName, cLev, born, Age, s1, s2, s3, s4, s5, NoA);
			addUniqueCompetitor(c);
		} catch (NumberFormatException f) {
			String error = "Conversion error ' " + cLine + " '  - " + f.getMessage();
			System.out.println(error);
		} catch (ArrayIndexOutOfBoundsException e) {
			String error = "Referencing an invalid index : '" + cLine + "' index position : " + e.getMessage();
			System.out.println(error);
		}
	}
}

// help from - https://www.baeldung.com/java-csv-file-array