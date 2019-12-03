
package lekrws1rrp3Assignment2;

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;

public class CompetitorManager {
	public void run() {

		
		CompetitorList c = new CompetitorList();
		c.readFile("KnitterInput.csv");
		c.readFile("DancerInput.csv");
		c.readFile("GamerInput.csv");
		
		//String report = c.getAllCompetitors();
		//c.writeToFile("CompetitorReport.txt", report);
		tabbedPane tabbedpane = new tabbedPane(c);
		
        JFrame frame = new JFrame("Competitors Are Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new tabbedPane(c), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);

		
			Scanner sc = new Scanner(System.in);
		
		    sc.close();
		    }

}
