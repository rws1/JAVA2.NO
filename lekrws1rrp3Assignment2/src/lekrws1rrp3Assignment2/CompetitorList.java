package lekrws1rrp3Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitorList {
	
	/**
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
	 * Supplied text to writer to write a report
	 * 
	 * @return report with competitor information
	 */

	// method to create report with one line per person
	public String getAllCompetitors() {
		String report = "";

		for (Competitor c : competitorList) {
			
			report += String.format("%-10d", c.getcompetitorNumber());

			//report += String.format("%-30s", c.getshortDetails());
			
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
	//if else
	
	// create method to process line from the input file
		private void processLine(String line) {
			try {
				String parts[] = line.split(","); {
				 
				if (parts [0] == ("Gamer")) {
					
					
					Name competitorName = new Name(parts[2], parts[3], parts[4]);
					String competitorNumber = parts[1];
					int cnum = Integer.parseInt(competitorNumber);
					String competitorLevel = parts[5];
					String competitorLocation = parts[6];
					String competitorAge = parts[7];
					int cage = Integer.parseInt(competitorAge);
					

					int scoresLength = parts.length - 8;
					String scoresStr[] = new String[scoresLength];
				
					//copy from input array to string of scores
					System.arraycopy(parts, 8, scoresStr, 0, scoresLength); 
				
					//convert from string array to int array
							
					int competitorScores[] = new int[scoresLength];
						for(int i = 0; i < scoresLength; i++ ) {
							competitorScores[i] = Integer.parseInt(scoresStr[i]);
							if(competitorScores[i] > 0 && competitorScores[i] <= 5); 
						}
						
						String competition = null;
						Competitor c = new Competitor(competition, cnum, competitorName, competitorLevel, competitorLocation, cage, competitorScores);
						this.add(c);
						
					
					}
						
				else if (parts [0] == ("Dancer")) {
				
					Name competitorName = new Name(parts[2], parts[3], parts[4]);
					String competitorNumber = parts[1];
					int cnum = Integer.parseInt(competitorNumber);
					String competitorLevel = parts[5];
					String competitorLocation = parts[6];
					String competitorAge = parts[7];
					int cage = Integer.parseInt(competitorAge);
					

					int scoresLength = parts.length - 8;
					String scoresStr[] = new String[scoresLength];
				
					//copy from input array to string of scores
					System.arraycopy(parts, 8, scoresStr, 0, scoresLength); 
				
					//convert from string array to int array
							
					int competitorScores[] = new int[scoresLength];
						for(int i = 0; i < scoresLength; i++ ) {
							competitorScores[i] = Integer.parseInt(scoresStr[i]);
							if(competitorScores[i] > 0 && competitorScores[i] <= 5); 
						}
						
						String competition = null;
						Competitor c = new Competitor(competition, cnum, competitorName, competitorLevel, competitorLocation, cage, competitorScores);
						this.add(c);
						
					
					}
				else {
					
					Name competitorName = new Name(parts[2], parts[3], parts[4]);
					String competitorNumber = parts[1];
					int cnum = Integer.parseInt(competitorNumber);
					String competitorLevel = parts[5];
					String competitorLocation = parts[6];
					String competitorAge = parts[7];
					int cage = Integer.parseInt(competitorAge);
					

					int scoresLength = parts.length - 8;
					String scoresStr[] = new String[scoresLength];
				
					//copy from input array to string of scores
					System.arraycopy(parts, 8, scoresStr, 0, scoresLength); 
				
					//convert from string array to int array
							
					int competitorScores[] = new int[scoresLength];
						for(int i = 0; i < scoresLength; i++ ) {
							competitorScores[i] = Integer.parseInt(scoresStr[i]);
							if(competitorScores[i] > 0 && competitorScores[i] <= 5); 
						}
						
						String competition = null;
						Competitor c = new Competitor(competition, cnum, competitorName, competitorLevel, competitorLocation, cage, competitorScores);
						this.add(c);
						
					
					}
				
				}				
				
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
			

	
	
	/**
	 * Will find maximum overall score in the list
	 * 
	 * @return maximum overall score value
	 */
		// create method to get maximum weighted AverageScore to get the winner
	//may need to change this
		public double getMaxoverallScore() {
			double MaxoverallScore = 0;
			double OverallScore = 0;
			for (Competitor c : competitorList) {
				
				if (c.getcompetition().equals ("Dancer") ){ 
				   OverallScore = ((Dancer)c).getOverallScore();
				
				}
				else if (c.getcompetition().equals ("Gamer") ){ 
					OverallScore = ((Gamer)c).getOverallScore();
					
					}
				else { 
					OverallScore = ((Knitter)c).getOverallScore();
					
					}
						
				if (OverallScore > MaxoverallScore) {
					MaxoverallScore = OverallScore;
				}
			}
			return MaxoverallScore;
		}
		
		/**
		 * Will find competitor based on competitor number
		 * 
		 * @param competitorNumber competitor number from the input list
		 * @return Short details and full details of requested competitor number
		 */
		public String findBycompetitorNumber(int competitorNumber) {
			for (Competitor c : competitorList) {
				
				if (c.getcompetition().equals ("Dancer") ){ 
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return "\n" + "Full details: " + "\n" + ((Dancer)c).getfullDetails();
					}
				}
				else if (c.getcompetition().equals ("Gamer") ){ 
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return "\n" + "Full details: " + "\n" + ((Gamer)c).getfullDetails();
					}
				}
				else { 
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return "\n" + "Full details: " + "\n" + ((Knitter)c).getfullDetails();
					}
				}
			}
			return "\nCompetitor " + competitorNumber + " does not exist. Please enter a valid competitor number.";
		}




		/**
		 * Will find the winner of the competition based on maximum weighted average
		 * score
		 * 
		 * @param competitorName the name of the competitor
		 * @return Name and details of the winner
		 */
	/*
	 * // return the winner //public String findtheCompetitorwithhighestScore
	 * (String competitorName) { //String res = null; //for (Competitor c :
	 * competitorList) { //if (c.getMaxoverallScore() == (getMaxoverallScore())) {
	 * 
	 * return res = "Competitor " + c.getName().getFullName() +
	 * " has the higest score of " + getMaxoverallScore() + ".\n" +
	 * "\nFollowing are the details of the winner: " + "\n" + c.getfullDetails(); }
	 * } return res;
	 * 
	 * }
	 */
		

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
				//fw.write("\n> The competitor with highest score is " + c.findtheCompetitorwithhighestScore());
					

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

		
		
		

		public void readFile(String string) {
			try { 
			switch(string) {
			
			case "GameInput.csv" :
				File g = new File("GamerInput.csv");
				scanner = new Scanner(g);
				while (scanner.hasNextLine()) {
					String inputLine = scanner.nextLine();
					if (inputLine.length() != 0) {
						processLine(inputLine);
					}

				}
				break;
				
				
			case "DancerInput.csv" :
				File d = new File("DancerInput.csv");
				scanner = new Scanner(d);
				while (scanner.hasNextLine()) {
					String inputLine = scanner.nextLine();
					if (inputLine.length() != 0) {
						processLine(inputLine);
					}

				}
				break;
				
				
			case "KnitterInput.csv" :
				File k = new File("KnitterInput.csv");
				scanner = new Scanner(k);
				while (scanner.hasNextLine()) {
					String inputLine = scanner.nextLine();
					if (inputLine.length() != 0) {
						processLine(inputLine);
					}

				}
				break;
				
							
			}
		

			} catch (FileNotFoundException fnf) {
				System.out.println(string + " not found ");
				System.exit(0);
			}
			
		}


}
