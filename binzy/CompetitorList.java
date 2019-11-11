package assignment1;

/** Software Engineering Foundations
 * Assignment 1
 * This class read the input file containing the list of competitors
 * and prints this to a report along with some summary statistics
 * @author Lynsey Kirk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CompetitorList {

	private ArrayList<LEKCompetitor> competitorList;
	
	//creates an empty arraylist
	public CompetitorList() {
		competitorList = new ArrayList<LEKCompetitor> ();
	}
	//adds student object to arraylist
	public void add(LEKCompetitor c) {
		competitorList.add(c);
	}

	/** creates the report of competitors with the full details of each competitor
	 * @param competitorList the list of competitors
	 * @return returns report of competitors full details with one line per competitor
	 */
	public String getAllCompetitors() {
		String report = "";
		for (LEKCompetitor c  : competitorList){
			report += String.format("%-6d", c.getCompetitorNumber());
			report += String.format("%-40s", c.getCompetitorName().getFullName() );
			report += String.format("%-20s", c.getCompetitorExperience());
			report += String.format("%-20s", c.getCompetitorLocation());
			report += String.format("%-60s", c.getDOB());
			report += String.format("%-20s", c.getDisplayScores());			
			report += String.format("%-1.1f", c.getOverallScore());
			report += "\n";
		}
		return report;
	}

	/** writes the text to a file
	 * check for missing file, missing text to write
	 * @param competitorReport the name of the file to write to
	 * @param report the text to be written to the file
	 */
	public  void writeToFile(String competitorReport, String report) {
		 FileWriter fw;
		 try {
		    fw = new FileWriter(competitorReport);
		    fw.write("The 25th Annual Speed Knitting Competition\n\n");
		    fw.write("The Competitors:\n\n");
		    fw.write(String.format("%-6s", "CN"));
		    fw.write(String.format("%-40s", "Name"));
		    fw.write(String.format("%-20s", "Experience"));
		    fw.write(String.format("%-20s", "Location"));
		    fw.write(String.format("%-60s", "DOB"));
		    fw.write(String.format("%-20s", "Scores"));
		    fw.write(String.format("%-15s", "Overall Score\n"));
		    fw.write("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		    //print the report
		    fw.write(report);
		    fw.write("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n\n\n");
		    fw.write("RESULTS\n\n");
		    //get the details of the winner
		    fw.write(getWinnerReport() + "\n\n");
		    fw.write("STATISTICAL REPORT\n\n");
		    //get the number of competitors
		    fw.write("Number of competitors: " + getSize() + "\n");
		    //get the highest and lowest scores
		    fw.write("Highest score awarded for a given round: " + getHighestScore() + "\n");
		    fw.write("Lowest score awarded for a given round: " + getLowestScore() + "\n");
		    //get the total of the scores
		    fw.write("The total of all the scores given: " + getTotal() + "\n");
		    //get the average of the scores
		    fw.write("The average of all scores given: " + String.format("%.1f",getTotalAverage()) + "\n\n");
		    //get the experience frequency report
		    fw.write("The number of competitors in each experience category:\n");
		    fw.write("Beginner: " + getExperienceCount("Beginner")+"\n");
		    fw.write("Intermediate: " + getExperienceCount("Intermediate")+"\n");
		    fw.write("Expert: " + getExperienceCount("Expert")+"\n\n");
		    //get the scores frequency report
		    fw.write(getScoresFrequencyReport() +"\n\n");
		    fw.close();
		 }

		 //message and stop if file not found
		 catch (FileNotFoundException fnf){
			 System.out.println(competitorReport + " not found ");
			 System.exit(0);
		 }

		 //message and stop if report is null
		 catch (NullPointerException npe) {
			 System.out.println("No text to write to file");
			 System.exit(0);
		 }		 
	 
		 //stack trace here because we don't expect to come here
		 catch (IOException ioe){
		    ioe.printStackTrace();
		    System.exit(1);
		 }
	}
	
	/** reads file with given name, extracting competitor data, creating competitor objects
	 * and adding them to the list of competitors
	 * Blank lines are skipped
	 * Validation for integer scores, missing items
	 * @param competitorList the name of the input file
	 */
	public void readFile(String competitorList) {
		try {
			File f = new File(competitorList);
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				String inputLine = scanner.nextLine(); 
				if (inputLine.length() != 0) { //ignored if blank line
					processLine(inputLine);
				}
			}
		}

		//if the file is not found, stop with system exit
		catch (FileNotFoundException fnf){
			 System.out.println( competitorList + " not found ");
			 System.exit(0);
		 }
	}

	/** Processes line, extracts data, creates LEKCompetitor object
	 * and adds to list
	 * Checks for non-numeric scores and missing items
	 * Checks scores are given in a range of 1 to 5
	 * Will still crash if name entered without a space
	 * @param line the line to be processed
	 */
	private void processLine(String line) {
		boolean valid = false;
		while (!valid) {
			try {
				String parts [] = line.split(",");
				Name competitorName = new Name(parts[1]);
				String competitorNumberString = parts[0];
			
				//remove any spaces
				competitorNumberString = competitorNumberString.trim();
			
				//convert string competitor number to int
				int competitorNumber = Integer.parseInt(competitorNumberString);
				String competitorExperience = parts[2];
				String competitorLocation = parts[3];
				String dobString = parts[4];
				
				SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
				Date dob = dateFormat.parse(dobString);
				
				
				int scoresLength = parts.length - 5;
				String scoresStr[] = new String[scoresLength];
			
				//copy from input array to string of scores
				System.arraycopy(parts, 5, scoresStr, 0, scoresLength); 
			
				//convert from string array to int array
						
				int scores[] = new int[scoresLength];
					for(int i = 0; i < scoresLength; i++ ) {
						scores[i] = Integer.parseInt(scoresStr[i]);
						if(scores[i] > 0 && scores[i] <= 5) {
							valid = true;
						}
						else {
							System.out.println("The scores provided are not within the range 1-5");
							System.exit(0);
						}
				}
		
			//create LEKCompetitor object and add to the list
			LEKCompetitor c = new LEKCompetitor(competitorNumber, competitorName, competitorExperience, competitorLocation, dob, scores);
			this.add(c);
			}
			//catches if trying to convert String to int
			catch (NumberFormatException nfe) {
				String error = "Number conversion error in '" + line + "'  - " 
				                  + nfe.getMessage();
				System.out.println(error);
			}
			// catches missing items
			catch (ArrayIndexOutOfBoundsException air) {
				String error = "Not enough items in  : '" + line
				                        + "' index position : " + air.getMessage();
				System.out.println(error);
			}
			//catches if part of a name is missing
			catch (StringIndexOutOfBoundsException sir) {
				String error = "Name is missing in  : '" + line
			                        + "' index position : " + sir.getMessage();
				System.out.println(error);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/** returns the number of competitors in the list
	 * @return size of the competitorList
	 */
	public int getSize() {
		return competitorList.size();
	}

	/** returns the competitor with the specified competitor number
	 * @param competitorNumber the competitor number of a competitor
	 * @return the competitor object
	 */
	public LEKCompetitor findByCompetitorNumber(int competitorNumber) {		
		//searches through the arraylist
		for (LEKCompetitor c : competitorList) {
			if (c.getCompetitorNumber()==competitorNumber) {			
				//returns competitor object if found
				return c;
			}
		}
		//otherwise returns null
		return null;
	}

	/** returns the total of all the scores given
	 * @return total of all scores
	 */
	
	public int getTotal() {
		//sets the total to 0
		int total = 0;
		for (LEKCompetitor c : competitorList) {
			//searches through the score array 
			for (int i = 0; i < c.getScoreArray().length; i++) {
			// adds to the total if a higher value is found
			total += c.getScoreArray()[i];
			}
		}
		return total;
	}
	
	/** returns the average score of all the competitors in the list
	 * @return average of all scores
	 */
	public double getTotalAverage(){
		double average = 0;
		double total = 0;
		for (LEKCompetitor c : competitorList) {
			total += c.getAverage();
			average = total/competitorList.size();
		}
		return average;
	}
	
	/** returns the winning overall score
	 * and the full details of the competitors with that score
	 * @return full details of the competitor(s) with highest overall score
	 */
	public String getWinnerReport() {
		double hos = 0;
		
		for (LEKCompetitor c : competitorList) {
			//if the competitor's overall score equals
			//the highest overall score
			//it becomes the highest overall score
			if (c.getOverallScore() > hos) {		
				hos = c.getOverallScore();
			}
			
		}
		//create the report of winners
		String report = "The winning overall score is: " + String.format("%.1f",hos) + "\n\n"
						+ "The competitors who received this score are:\n\n";
		for (LEKCompetitor c : competitorList) {
			if (c.getOverallScore()==(hos)) {
				report += c.getFullDetails() + "\n\n";
		}
		}
		return report;	
	}
	
	/** returns the highest score from all the scores given in the competition
	 * @return the highest given score
	 */	
	public int getHighestScore() {
		//sets the highest score to 0
		int highestScore = 0;
		for (LEKCompetitor c : competitorList) {
			//iterates through the score array 
			for (int scoreIndex = 1; scoreIndex < c.getScoreArray().length; scoreIndex++) {
				//replaces highest score if a higher value is found
				if (c.getScoreArray()[scoreIndex] > highestScore) {
					highestScore = c.getScoreArray()[scoreIndex];
				}
			}
		}
		//returns the highest score
		return highestScore;		
	}

	/** returns the lowest score from all the scores given in the competition
	 * @return the lowest given score
	 */
	public int getLowestScore() {
		//sets the lowest score to the highest score
		int lowestScore = getHighestScore();
		for (LEKCompetitor c : competitorList) {
			//iterates through the score array 
			for (int scoreIndex = 1; scoreIndex < c.getScoreArray().length; scoreIndex++) {
				// replaces lowest score if a lower value is found
				if (c.getScoreArray()[scoreIndex] < lowestScore) {
					lowestScore = c.getScoreArray()[scoreIndex];
				}
			}
		}
		//returns the lowest score
		return lowestScore;		
	}

	/** returns a frequency report of all the scores given in the competition
	 * @return frequency report of scores
	 */
	public String getScoresFrequencyReport() {
		//gets the highest score
		int maxScore = getHighestScore();
		//create array for frequency of scores and set length
		int [] freqScores = new int [maxScore];
		//search through list and add frequency to each score
		for (LEKCompetitor c : competitorList) {
			int score = c.getScores1();
			freqScores[score-1]++;
		}
		for (LEKCompetitor c : competitorList) {
			int score = c.getScores2();
		freqScores[score-1]++;
		}	
		for (LEKCompetitor c : competitorList) {
			int score = c.getScores3();
			freqScores[score-1]++;
		}	
		for (LEKCompetitor c : competitorList) {
			int score = c.getScores4();
			freqScores[score-1]++;
		}	
		for (LEKCompetitor c : competitorList) {
			int score = c.getScores5();
			freqScores[score-1]++;
		}	
		//create a report
		String report = "The following individual scores were awarded:\n";
		for (int i = 0; i < freqScores.length; i++) {
		report += "Score " + (i+1) + " : " + freqScores[i] + "\n";
			}
		return report;
		}

	/** returns a count of the competitors' experience level
	 * @param experience the level of experience a competitor has
	 * @return count of experience
	 */
	public String getExperienceCount(String experience) {
		//set count to 0
		int count = 0;
		for (LEKCompetitor c : competitorList) {
			//iterate through list and add to count
			//if experience is equal
			if(c.getCompetitorExperience().equals(experience)) 
				count++;
				}
		//create a report
			String report = "" + count;
			return report;			
		}
}



