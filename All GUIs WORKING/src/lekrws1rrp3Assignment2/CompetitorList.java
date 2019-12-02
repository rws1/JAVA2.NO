package lekrws1rrp3Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CompetitorList {
	

		private ArrayList<Competitor> competitorList;

		
		private Scanner scanner;
		
						
		public CompetitorList() {
			competitorList = new ArrayList<Competitor>();
			
			
		}

		
		public void add(Competitor c) {
			competitorList.add(c);
			
		}

		
	
	// method to create report with one line per person
	public String getAllCompetitors() {
		String report = "";

		for (Competitor c : competitorList) {
				
			report += String.format("%-15d", c.getcompetitorNumber());
			report += String.format("%-30s",  c.getshortDetails());				
			report += "\n";
		}
		return report;
	}
	
	/** creates the report of competitors with the full details of each competitor
	 * @param competitorList the list of competitors
	 * @return returns report of competitors full details with one line per competitor
	 */
	public String getCompetitorList() {
		String report = "";
		for (Competitor c  : competitorList) {
			report += String.format("%-40s", c.getcompetition());
			report += String.format("%-6d", c.getcompetitorNumber());
			report += String.format("%-40s", c.getName().getFullName() );
			report += String.format("%-20s", c.getcompetitorLevel());
			report += String.format("%-20s", c.getcompetitorLocation());
			report += String.format("%-20s", c.getAge());
			report += String.format("%-20s", c.getarrayofcompetitorScores().replace("[", " ").replace("]", " "));			
			report += String.format("%-1.1f", c.getOverallScore());
			report += "\n";
		}
		return report;
	}
	
	public String getCompetitionCount (String compCount) {
		//set count to 0
		int count = 0;
		for (Competitor c : competitorList) {
			//iterate through list and add to count
			//if experience is equal
			if(c.getcompetition().equals(compCount)); 
				count++;
				}
		//create a report
			String report = "" + count;
			return report;			
		}

	
	// METHOD TO CREATE A REPORT OF ALL COMPETITORS IN THE DANCING CLASS
	public String getCompetitionList(String comp) {
		String report = "";
		for (Competitor c : competitorList) { 
			 if(c.getcompetition().equals(comp)) 
				report = "";
				report += String.format("%-40s", c.getcompetition());
				report += String.format("%-6d", c.getcompetitorNumber());
				report += String.format("%-40s", c.getName().getFullName() );
				report += String.format("%-20s", c.getcompetitorLevel());
				report += String.format("%-20s", c.getcompetitorLocation());
				report += String.format("%-20s", c.getAge());
				report += String.format("%-20s", c.getcompetitorScores());			
				report += String.format("%-1.1f", c.getOverallScore());
				report += "\n";
		}
		return report;
	}
	
	
//	// METHOD TO CREATE A REPORT OF ALL COMPETITORS IN THE DANCING CLASS
//	public String getDancers() {
//		String report = "";
//		for (Competitor c : competitorList) { 
//			 if (c.getcompetition().equals("Dancer")) 
//				report = "";
//				report += String.format("%-40s", c.getcompetition());
//				report += String.format("%-6d", c.getcompetitorNumber());
//				report += String.format("%-40s", c.getName().getFullName() );
//				report += String.format("%-20s", c.getcompetitorLevel());
//				report += String.format("%-20s", c.getcompetitorLocation());
//				report += String.format("%-20s", c.getAge());
//				report += String.format("%-20s", c.getScoreArray());			
//				report += String.format("%-1.1f", c.getOverallScore());
//				report += "\n";
//		}
//		return report;
//	}
//	
//	// METHOD TO CREATE A REPORT OF ALL COMPETITORS IN THE GAMER CLASS
//	public String getGamers() {
//		String report = "";
//		for (Competitor c : competitorList) { 
//			 if (c.getcompetition().equals("Gamer")) 
//				report = "";
//			 	report += String.format("%-40s", c.getcompetition());
//				report += String.format("%-6d", c.getcompetitorNumber());
//				report += String.format("%-40s", c.getName().getFullName() );
//				report += String.format("%-20s", c.getcompetitorLevel());
//				report += String.format("%-20s", c.getcompetitorLocation());
//				report += String.format("%-20s", c.getAge());
//				report += String.format("%-20s", c.getScoreArray());			
//				report += String.format("%-1.1f", c.getOverallScore());
//				report += "\n";
//		}
//		return report;
//	}
//	
//	// METHOD TO CREATE A REPORT OF ALL COMPETITORS IN THE KNITTER CLASS
//	public String getKnitters() {
//		String report = "";
//		for (Competitor c : competitorList) { 
//			 if (c.getcompetition().equals("Knitter"))
//				report = "";
//			 	report += String.format("%-40s", c.getcompetition());
//				report += String.format("%-6d", c.getcompetitorNumber());
//				report += String.format("%-40s", c.getName().getFullName() );
//				report += String.format("%-20s", c.getcompetitorLevel());
//				report += String.format("%-20s", c.getcompetitorLocation());
//				report += String.format("%-20s", c.getAge());
//				report += String.format("%-20s", c.getScoreArray());			
//				report += String.format("%-1.1f", c.getOverallScore());
//				report += "\n";
//			 
//		}
//		return report;
//	}
//	
	
	
	

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
				String competition = parts[0].trim(); 
				
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
						
						if (competition.equals("Gamer")) {
						Competitor c = new Gamer(competition, cnum, competitorName, competitorLevel, competitorLocation, cage, competitorScores);
						competitorList.add(c);
						}
						
						else if (competition.equals("Dancer")) {
						Competitor c = new Dancer(competition, cnum, competitorName, competitorLevel, competitorLocation, cage, competitorScores);
						competitorList.add(c);
						}
						
						else if (competition.equals("Knitter")) {
						Competitor c = new Knitter(competition, cnum, competitorName, competitorLevel, competitorLocation, cage, competitorScores);
						competitorList.add(c);
						}
						
					
					}
//				/else {
//					
//					//String competition = parts[0].trim();
//					Name competitorName = new Name(parts[2], parts[3], parts[4]);
//					String competitorNumber = parts[1];
//					int cnum = Integer.parseInt(competitorNumber);
//					String competitorLevel = parts[5];
//					String competitorLocation = parts[6];
//					String competitorAge = parts[7];
//					int cage = Integer.parseInt(competitorAge);
//					
//
//					int scoresLength = parts.length - 8;
//					String scoresStr[] = new String[scoresLength];
//				
//					//copy from input array to string of scores
//					System.arraycopy(parts, 8, scoresStr, 0, scoresLength); 
//				
//					//convert from string array to int array
//							
//					int competitorScores[] = new int[scoresLength];
//						for(int i = 0; i < scoresLength; i++ ) {
//							competitorScores[i] = Integer.parseInt(scoresStr[i]);
//							if(competitorScores[i] > 0 && competitorScores[i] <= 5); 
//						}
//						
//						
//						Competitor c = new Knitter(competition, cnum, competitorName, competitorLevel, competitorLocation, cage, competitorScores);
//						this.add(c);
//				
//								
//				}
				
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
				
				if (c instanceof Dancer){
					Dancer d = (Dancer) c;
					  OverallScore = d.getOverallScore();
				  
				}
				else if (c instanceof Gamer){ 
					Gamer g = (Gamer) c;
					    OverallScore = g.getOverallScore();
					
					}
 				else if(c instanceof Knitter){ 
 					Knitter k = (Knitter) c;
					    OverallScore = k.getOverallScore();
					
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
				
				if (c instanceof Dancer){
					Dancer d = (Dancer) c;
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return "\n" + "Full details: " + "\n" + d.getfullDetails();
					}
				}
				else if (c instanceof Gamer){
					     Gamer g = (Gamer) c;
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return "\n" + "Full details: " + "\n" + g.getShortDetails();
					}
				}
				else if (c instanceof Knitter){
				     Knitter k = (Knitter) c; 
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return "\n" + "Full details: " + "\n" + k.getfullDetails();
					}
				}
			}
			return "\nCompetitor " + competitorNumber + " does not exist. Please enter a valid competitor number.";
		}

		/**
		 * Will find competitor based on competitor number
		 * 
		 * @param competitorNumber competitor number from the input list
		 * @return the competitor object
		 */
		//CREATED AS NEEDED TO RETURN THE OBJECT WHEN FINDING THE COMPETITOR NUMBER RATHER THAN A STRING
		public Competitor findBycompetitorNumber2(int competitorNumber) {
			for (Competitor c : competitorList) {
				
				if (c instanceof Dancer){
					Dancer d = (Dancer) c;
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return d;
					}
				}
				else if (c instanceof Gamer){
					     Gamer g = (Gamer) c;
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return g;
					}
				}
				else if (c instanceof Knitter){
				     Knitter k = (Knitter) c; 
					if (c.getcompetitorNumber() == (competitorNumber)) {
						return k;
					}
				}
			}
			return null;
		}

		// create a method to get short details
	/*
	 * public String toString() { String res = null; for (Competitor c :
	 * competitorList) {
	 * 
	 * if (c.getcompetition().equals ("Dancer") ){ return res =
	 * ((Dancer)c).toString(); } else if (c.getcompetition().equals ("Gamer") ){
	 * return res = ((Gamer)c).toString(); } else{ return res =
	 * ((Knitter)c).toString(); } } return res;
	 * 
	 * }
	 */
					
					
					
		/**
		 * Will find the winner of the competition based on maximum weighted average
		 * score
		 * 
		 * @param competitorName the name of the competitor
		 * @return Name and details of the winner
		 */

	 // return the winner 
	public String findtheCompetitorwithhighestScore
	 (String res) { 
			 for (Competitor c : competitorList) { 
			 if (c instanceof Dancer){
					Dancer d = (Dancer) c;
							
				        if (d.getOverallScore() == getMaxoverallScore())
					         return res = "Competitor " + c.getName().getFullName() +
					         " has the higest score of " + String.format("%.2f",getMaxoverallScore()) + ".\n" +
					         "\nFull details of the competitor with highest score: " + "\n" + d.getfullDetails();
				        
				         }	 
			 
		     else if (c instanceof Gamer){
					    Gamer g = (Gamer) c;
					     					
			               if (g.getOverallScore() == getMaxoverallScore())
				              return res = "Competitor " + g.getName().getFullName() +
				              " has the higest score of " + String.format("%.2f",getMaxoverallScore()) + ".\n" +
				              "\nFull details of the competitor with highest score: " + "\n" + g.getfullDetails(); 
			              
							
			       }	
		     else if (c instanceof Knitter){
					Knitter k = (Knitter) c;
					
					
		    	         if (k.getOverallScore() == getMaxoverallScore())
					       return res = "Competitor " + k.getName().getFullName() +
					       " has the higest score of " + String.format("%.2f",getMaxoverallScore()) + ".\n" +
					       "\nFull details of the competitor with highest score: " + "\n" + k.getfullDetails();  
		    	        
		 				
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
		 * @param Report the name of the file to be written to
		 * @param report     the text to be written to file
		 */
		// writes text to file to generate report
		public void writeToFile(String Report, String report) {

			FileWriter fw;
			try {
				fw = new FileWriter(Report);
				fw.write("THE REPORT\n");
				fw.write("\n"
						+ "Competitor     Short Details\n");
				fw.write(report);
				fw.write("\n> The competitor with highest score is " + findtheCompetitorwithhighestScore(report));
					

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
			
			case "GamerInput.csv" :
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

		
		//THE FOLLOWING TWO METHODS WILL NEED TO BE ADAPTED TO
		//IDENTIFY THE DIFFERENT COMPETITIONS
		//AND BE ABLE TO ORDER JUST FOR A SPECIFIED COMPETITION
		
		/**
		 * @return All the competitors details in name order
		 */
		public String listByName() {
			Collections.sort(competitorList, new CompetitorNameComparator());
			return getCompetitorList();
		}

		/**
		 * @return All the competitors details in id order
		 */
		public String listByID() {
			Collections.sort(competitorList, new CompetitorNumberComparitor());
			return getCompetitorList();
		}

}
