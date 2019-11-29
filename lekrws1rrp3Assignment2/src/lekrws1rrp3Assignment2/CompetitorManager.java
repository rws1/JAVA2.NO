package lekrws1rrp3Assignment2;

import java.util.Scanner;

public class CompetitorManager {
	public void run() {

		CompetitorList c = new CompetitorList();

		c.readFile("KnitterInput.csv");
		c.readFile("DancerInput.csv");
		c.readFile("GamerInput.csv");
		
		String report = c.getAllCompetitors();

		c.writeToFile("CompetitorReport.txt", report);
		
		
		
			Scanner sc = new Scanner(System.in);
		/*
		 * System.out.
		 * print("\nPlease enter the competitor number to retrive information: "); try {
		 * int competitorNumber = sc.nextInt();
		 * System.out.println(c.findBycompetitorNumber(competitorNumber)); // to add
		 * this method in SuperClass } catch (Exception notfound) {
		 * System.out.println("\nCompetitor number invalid. Please enter a valid number"
		 * ); }
		 */
		    sc.close();
		    }

}
