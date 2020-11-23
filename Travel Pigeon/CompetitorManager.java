package lekrws1rrp3Assignment2;

/** Software Engineering Foundations
 * Assignment 2
 * This class reads the input files and 
 * sets up and runs the main GUI JFrame
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;

public class CompetitorManager {
	/**
	 * Reads the input files 
	 * and creates the main GUI JFrame
	 */
	public void run() {

		CompetitorList c = new CompetitorList();
		c.readFile("KnitterInput.csv");
		c.readFile("DancerInput.csv");
		c.readFile("GamerInput.csv");

		tabbedPane tabbedpane = new tabbedPane(c);

		JFrame frame = new JFrame("Competitors Are Here");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new tabbedPane(c), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

		//open the scanner
		Scanner sc = new Scanner(System.in);
		//close the scanner
		sc.close();
	}
}
