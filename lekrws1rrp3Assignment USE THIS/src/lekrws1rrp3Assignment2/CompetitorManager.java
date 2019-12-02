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
		
		    sc.close();
		    }

}
