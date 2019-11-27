package lekrws1rrp3Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitorList {
	
	/**
	 * @author Rachana Patel email: rrp3@hw.ac.uk
	 * @version 3.6 (current version number of program)
	 * @since 3.0 (the version of the package this class was first added to)
	 * Creates an Arraylist 'competitorsList' from the
	 * input file and populates it, allows other methods to interrogate to obtain the required information. 
	 */

	

		private ArrayList<Competitor> competitorList;
		

		private Scanner scanner;

		// create an empty array list
		public CompetitorList() {
			competitorList = new ArrayList<Competitor>();
		}

		/**
		 * 
		 * @param c is the competitor to be added to competitor list
		 */
		public void add(Competitor c) {
			competitorList.add(c);
		}

		/**
		 * Reads specified files, extracts competitor information, creating competitor
		 * objects Add the information to list of competitors
		 * 
		 * @param filename is the name of the input file
		 * @exception FileNotFoundException if the file does not exists
		 */

}
	public void readFile(String filename) {
		try {
			File f = new File("CompetitorInput");
			scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				String inputLine = scanner.nextLine();
				if (inputLine.length() != 0) {
					processLine(inputLine);
				}

			}

		} catch (FileNotFoundException fnf) {
			System.out.println(filename + " not found ");
			System.exit(0);
		}
	}

	
	
	
	/**
	 * Supplied text to writer to write a report
	 * 
	 * @return report with competitor information
	 */

	// method to create report with one line per person
	public String getAllCompetitors() {
		String report = "";

		for (Competitor c : competitorList) {
			
			report += String.format("%-10d", c.getcompetitorNumber());

			report += String.format("%-30s", c.getshortDetails());
			
			report += "\n";
		}
		return report;
	}
	
	
	
	

	/**
	 * Process line, extracts information and creates Competitor object
	 * 
	 * @exception NumberFormatException          if unable to format string to
	 *                                           number.
	 * @exception ArrayIndexOutOfBoundsException if the array index does not exist.
	 * @param line the line processed from input file
	 */

	// create method to process line from the input file
	private void processLine(String line) {
		try {
			String parts[] = line.split(",");
			Name competitorName = new Name(parts[1], parts[2], parts[3]);
			String competitorNumber = parts[0];
			int cnum = Integer.parseInt(competitorNumber);
			String competitorLevel = parts[4];
			String competitorLocation = parts[5];
			String competitorAge = parts[7];
			int cage = Integer.parseInt(competitorAge);
			String[] cS = parts[8].split(",");  
			int competitorScores = cS.length;
			int[] competitorScores = new int[competitorScores];
			for (int i = 0; i < competitorScores; i++) {
				competitorScores[i] = Integer.parseInt(cS[i]);
			String sNoA = parts[9];
			int NoA = Integer.parseInt(sNoA);
			}

			Competitor c = new Competitor(cnum, competitorName, competitorLevel, competitorLocation,cage,
					competitorScores, NoA);
			this.add(c);
		}

		// catches for exceptions - both have been tested for functionality by altering
		// the input file
		catch (NumberFormatException ohno) {
			String error = "Number conversion error in '" + line + "'  - " + ohno.getMessage();
			System.out.println(error);
		} catch (ArrayIndexOutOfBoundsException ohshoot) {
			String error = "Not enough items in  : '" + line + "' index position : " + ohshoot.getMessage();
			System.out.println(error);

		}
	
		
	}

	
	
	// create method to get maximum weighted AverageScore to get the winner
	//may need to change this
		public double getMaxoverallScore() {
			double MaxoverallScore = 0;
			for (Competitor c : competitorList) {
				double weightedAverageScore = c.getOverallScore();
				if (weightedAverageScore > OverallScore) {
					MaxoverallScore = OverallScore;
				}
			}
			return MaxoverallScore;
		}
		
		
		

		/**
		 * Will find the winner of the competition based on maximum weighted average
		 * score
		 * 
		 * @param competitorName the name of the competitor
		 * @return Name and details of the winner
		 */
		// return the winner
		public String findtheCompetitorwithhighestScore (String competitorName) {
			String res = null;
			for (Competitor c : competitorList) {
				if (c.getMaxoverallScore() == (getMaxoverallScore())) {

					return res = "Competitor " + c.getName().getFullName()
							+ " is the winner of Battle of Wits with the overall score of " + getMaxweightedAverageScore()
							+ ".\n" + "\nFollowing are the details of the winner: " + "\n" + c.getfullDetails();
				}
			}
			return res;

		}
	
		/**
		 * writes supplied text to file
		 * 
		 * @exception FileNotFoundException if an attempt to open the file denoted by a
		 *                                  specified pathname has failed
		 * @exception IOExceptionif         stream to file cannot be written to or
		 *                                  closed
		 * @param rrp3Report the name of the file to be written to
		 * @param report     the text to be written to file
		 */
		// writes text to file to generate report
		public void writeToFile(String Report, String report) {

			FileWriter fw;
			try {
				fw = new FileWriter(Report);
				fw.write("THE REPORT\n");
				fw.write("\n"
						+ "Competitor                              Short Details\n");
				fw.write(report);
				fw.write("\n> The competitor with highest score is " + findtheCompetitorwithhighestScore());
					

				fw.close();
			}

			// if file not found give message and stop
			catch (FileNotFoundException fnf) {
				System.out.println(Report + " not found ");
				System.exit(0);
			}

			// stack trace here- stackoverflow - encountered this one too
			catch (IOException ioe) {
				ioe.printStackTrace();
				System.exit(1);
			}
		}


}
