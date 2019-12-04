package lekrws1rrp3Assignment2;

// import toolkits
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** Software Engineering Foundations
 * Assignment 2
 * GUI to display the list of competitors for all competitions
 * or a specified competition.
 * The list can be sorted by competitor number
 * or by name.
 * On close it writes the report to a text file.
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */


public class GUITwo extends JPanel implements ActionListener {

	// the competitor list
	private CompetitorList compList;

	// GUI components
	JScrollPane scrollList;
	JButton submit, orderlistByNumber, orderListByName, close;
	JTextArea resultList;
	JComboBox<String> competitionList = new JComboBox<>();
	DefaultComboBoxModel<String> compModel = new DefaultComboBoxModel<>();

	/**
	 * Creates GUITwo
	 * @param list
	 */
	public GUITwo(CompetitorList list) {
		this.compList = list;

		// pack, set visible and locate in middle of screen
		setVisible(true);
	}

	/**
	 * Sets up the north panel for selecting a competition.
	 * Contains JLabel, JComboBox, JButton
	 * and adds them to the top of the border layout on the JPanel.
	 */
	public void setupNorthPanel() {
		// north panel contains label, combo box and button
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 3));

		// setup combo box
		compModel.addElement("All competitors");
		compModel.addElement("Dancing");
		compModel.addElement("Gaming");
		compModel.addElement("Knitting");
		competitionList.setModel(compModel);
		competitionList.setEditable(false);

		// setup submit button
		submit = new JButton("Submit");

		// setup label and add components to north panel
		northPanel.add(new JLabel(" Select Compitition:  "));
		northPanel.add(competitionList);
		northPanel.add(submit);

		// add the event listener to the buttons
		submit.addActionListener(this);

		// add north panel to the content pane
		this.add(northPanel, BorderLayout.NORTH);
	}

	/**
	 * Sets up the centre panel for displaying the list of competitors.
	 * Contains JTextArea, JScrollPane
	 * and adds them to the middle of the border layout on the JPanel.
	 */
	public void setupCenterPanel() {
		// centre panel contains text area, JScrollPane for results to appear
		resultList = new JTextArea(25, 100);
		resultList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
		resultList.setEditable(false);
		scrollList = new JScrollPane(resultList);

		// add scroll list to border layout
		this.add(scrollList, BorderLayout.CENTER);
	}

	/**
	 * Sets up the south panel for buttons to sort the list
	 * and a close button.
	 * Contains JTextArea, JScrollPane
	 * and adds them to the bottom of the border layout on the JPanel.
	 */
	public void setupSouthPanel() {
		// south panel contains sort buttons and close button
		JPanel southPanel = new JPanel();
		orderlistByNumber = new JButton("Order By #");
		orderListByName = new JButton("Order By Name");
		close = new JButton("Close");

		// add components to south panel
		southPanel.add(orderlistByNumber);
		southPanel.add(orderListByName);
		southPanel.add(close);

		// add the event listener to the buttons
		orderlistByNumber.addActionListener(this);
		orderListByName.addActionListener(this);
		close.addActionListener(this);

		// add south panel to the border layout
		this.add(southPanel, BorderLayout.SOUTH);
	}

	/**
	 *Sets up the actions to be performed depending on which button is pressed.
	 *<li>submit  displays the selected competition
	 *<li>order by number  orders the selected list by competitor number
	 *<li>order by name  orders the selected list by name
	 *<li>close exits the application and writes the report to a text file
	 *<p>
	 *@param e  the event to be processed
	 */
	public void actionPerformed(ActionEvent e) {
		// if submit button then use search method
		if (e.getSource() == submit) {
			search();
		}
		// if order by ID button then use sortByID method
		else if (e.getSource() == orderlistByNumber) {
			sortByNumber();
		}
		// if order by name button then use sortByName method
		else if (e.getSource() == orderListByName) {
			sortByName();
		} 
		// if close button then write to file and exit application
		else if (e.getSource() == close) {
			String report = compList.getAllCompetitors();
			compList.writeToFile("CompetitorReport.txt", report);
			System.exit(0);
		}
	}

	 /**
	  * Identifies the user's selection and searches for the associated list of competitors.
	  * Displays the specified list in the display field 
	  * by creating array lists of the instance based on the selection.
	  */
	private void search() {
		// identify which option from the combo box was chosen
		String competitionSelected = (String) competitionList.getSelectedItem();

		// if selection was all competitors display the full list of competitors
		if (competitionSelected == "All competitors") {
			resultList.setText((reportHeadings()) + (compList.getCompetitorList()));
		}
		// if selection was Dancing return the list of dancers
		else if (competitionSelected == "Dancing") {
			// create new competitor list of dancers 
			CompetitorList dancerList = new CompetitorList();
			
			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a dancer then add to dancer list
				if (c instanceof Dancer) {
					dancerList.add(c);
				}
			}
			// display the list of dancers
			resultList.setText((reportHeadings()) + (dancerList.getCompetitorList()));
		}
		// if selection was Gaming return the list of gamers
		else if (competitionSelected == "Gaming") {
			// create new competitor list of gamers 
			CompetitorList gamerList = new CompetitorList();
			
			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a gamer then add to gamer list
				if (c instanceof Gamer) {
					gamerList.add(c);
				}
			}
			// display the list of gamers
			resultList.setText((reportHeadings()) + (gamerList.getCompetitorList()));
		}
		// if selection was Knitting return the list of knitters
		else if (competitionSelected == "Knitting") {
			// create new competitor list of knitters 
			CompetitorList knitterList = new CompetitorList();

			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a knitter then add to knitter list
				if (c instanceof Knitter) {
					knitterList.add(c);
				}
			}
			// display the list of knitters
			resultList.setText((reportHeadings()) + (knitterList.getCompetitorList()));
		}
	}

	 /**
	  * Identifies the user's selection and searches for the associated list of competitors.
	  * Displays the specified list in the display field
	  * ordered by name
	  * by creating array lists of the instance based on the selection.
	  */
	private void sortByName() {
		// identify which option from the combo box was chosen 
		String competitionSelected = (String) competitionList.getSelectedItem();
		
		// if selection was all competitors display the full list of competitors ordered by name
		if (competitionSelected == "All competitors") {
			resultList.setText((reportHeadings()) + (compList.listByName()));
		} 
		// if selection was Dancing return the list of dancers
		else if (competitionSelected == "Dancing") {
			// create new competitor list of dancers 
			CompetitorList dancerList = new CompetitorList();
			
			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a dancer then add to dancer list
				if (c instanceof Dancer) {
					dancerList.add(c);
				}
			}
			// display the list of dancers in name order
			resultList.setText((reportHeadings()) + (dancerList.listByName()));
		} 
		// if selection was Gaming return the list of gamers
		else if (competitionSelected == "Gaming") {
			// create new competitor list of gamers 
			CompetitorList gamerList = new CompetitorList();

			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a gamer then add to gamer list
				if (c instanceof Gamer) {
					gamerList.add(c);
				}
			}
			// display the list of gamer by name order
			resultList.setText((reportHeadings()) + (gamerList.listByName()));
		} 
		// if selection was Knitting return the list of knitters
		else if (competitionSelected == "Knitting") {
			// create new competitor list of knitters 
			CompetitorList knitterList = new CompetitorList();
			
			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a knitter then add to knitetr list
				if (c instanceof Knitter) {
					knitterList.add(c);
				}
			}
			// display the list of knitter by name order
			resultList.setText((reportHeadings()) + (knitterList.listByName()));
		}
		// if selection isn't made display text
		else
			resultList.setText("not found");
	}

	 /**
	  * Identifies the user's selection and searches for the associated list of competitors.
	  * Displays the specified list in the display field
	  * ordered by number
	  * by creating array lists of the instance based on the selection.
	  */
	private void sortByNumber() {
		// identify which option from the combo box was chosen 
		String competitionSelected = (String) competitionList.getSelectedItem();
		
		// if selection was all competitors display the full list of competitors ordered by competitor number
		if (competitionSelected == "All competitors") {
			resultList.setText((reportHeadings()) + (compList.listByNumber()));
		} 
		// if selection was Dancing return the list of dancers
		else if (competitionSelected == "Dancing") {
			// create new competitor list of dancers 
			CompetitorList dancerList = new CompetitorList();
			
			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a dancer then add to dancer list
				if (c instanceof Dancer) {
					dancerList.add(c);
				}
			}
			// display the list of dancers in number order
			resultList.setText((reportHeadings()) + (dancerList.listByNumber()));
		} 
		// if selection was Gaming return the list of gamers
		else if (competitionSelected == "Gaming") {
			// create new competitor list of dancers 
			CompetitorList gamerList = new CompetitorList();
			
			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a gamer then add to gamer list
				if (c instanceof Gamer) {
					gamerList.add(c);
				}
			}
			// display the list of gamers in number order
			resultList.setText((reportHeadings()) + (gamerList.listByNumber()));
		} 
		// if selection was Knitting return the list of knitters
		else if (competitionSelected == "Knitting") {
			// create new competitor list of knitters 
			CompetitorList knitterList = new CompetitorList();
			// loop through the all competitors
			for (Competitor c : compList.getcompetitorList()) {
				// if the competitor is a knitter then add to knitter list
				if (c instanceof Knitter) {
					knitterList.add(c);
				}
			}
			// display the list of knitters in number order
			resultList.setText((reportHeadings()) + (knitterList.listByNumber()));
		} 
		// if selection isn't made display text
		else
			resultList.setText("not found");
	}
	
	/**
	 * Creates a report of headings to be be
	 * displayed above the list of competitors
	 * in the results field
	 * @return the headings to be displayed
	 */
	private String reportHeadings() {
		// string report of the headers for the results
		String report = "";
		report += (String.format("%-14s", "Competition"));
		report += (String.format("%-6s", "CN"));
		report += (String.format("%-40s", "Name"));
		report += (String.format("%-20s", "Experience"));
		report += (String.format("%-20s", "Location"));
		report += (String.format("%-6s", "Age"));
		report += (String.format("%-20s", "Scores"));
		report += (String.format("%-15s", "Overall Score\n"));
		report += ("----------------------------------------------------------------------------------------------------------------------------------------------------\n");
		return report;
	}
}
