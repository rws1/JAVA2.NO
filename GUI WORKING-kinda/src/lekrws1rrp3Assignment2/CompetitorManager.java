package lekrws1rrp3Assignment2;

import java.util.Scanner;

public class CompetitorManager {
	public void run() {

		
		CompetitorList c = new CompetitorList();
		c.readFile("KnitterInput.csv");
		c.readFile("DancerInput.csv");
		c.readFile("GamerInput.csv");
		
		knitterList k = new knitterList();
		k.readFile("KnitterInput.csv");
		
		String report = c.getAllCompetitors();

		c.writeToFile("CompetitorReport.txt", report);
		
		
//		GUIOne g1 = new GUIOne(c);
//		g1.pack();  
//		g1.setVisible(true);
		
		GUITwo g2 = new GUITwo(c, k);
		g2.pack();  
		g2.setVisible(true);
		
		GUIThree g3 = new GUIThree(c);
		g3.pack();  
		g3.setVisible(true);
		
		
			Scanner sc = new Scanner(System.in);
		
		    sc.close();
		    }

}
