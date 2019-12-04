package lekrws1rrp3Assignment2;



// import toolkits
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

/** Software Engineering Foundations
 * Assignment 2
 * GUI to allow the user to search for a competitor
 * and display either that competitor's
 * full details or short details
 * On close it writes the report to a text file.
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

public class GUIThree extends JPanel implements ActionListener {

	// the competitor list
	private CompetitorList compList;

	// GUI components
	JScrollPane scrollList;
	JButton submit, close;
	JTextArea resultList;
	JTextField searchField;
	ButtonGroup detailsGroup;
	JRadioButton fullDeets, shortDeets;

	/**
	 * Create GUIThree
	 * @param list
	 */
	public GUIThree(CompetitorList list) {
		this.compList = list;
	}

	/**
	 * Sets up the west panel for searching for a competitor
	 * and selecting full details or short details
	 * Contains JLabel, JRadioButtons, JButton
	 * and adds them to the left of the border layout on the JPanel.
	 */
	public void setupWestPanel() {
		// setup search panel with label and text field
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(1, 2));
		searchPanel.setPreferredSize(new Dimension(20, 10));
		setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		
		//set up search field
		searchField = new JTextField(5);
		
		// add components to search panel
		searchPanel.add(new JLabel("Enter ID"));
		searchPanel.add(searchField);


		// setup select panel with 2 radio buttons
		JPanel selectPanel = new JPanel();
		selectPanel.setLayout(new GridLayout(2, 1));

		// setup radio buttons
		fullDeets = new JRadioButton("Full Details");
		shortDeets = new JRadioButton("Short Details");
		fullDeets.setActionCommand("fullDetails");
		shortDeets.setActionCommand("shortDetails");
		// set default selected button
		fullDeets.setSelected(true);
		detailsGroup = new ButtonGroup();
		detailsGroup.add(fullDeets);
		detailsGroup.add(shortDeets);
		
		// add components to select panel
		selectPanel.add(fullDeets);
		selectPanel.add(shortDeets);

		// setup submit button
		submit = new JButton("OK");

		// setup west panel containing 3 previous areas
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(3, 1));
		
		// add components to  west panel
		westPanel.add(searchPanel);
		westPanel.add(selectPanel);
		westPanel.add(submit);

		// specify action when button is pressed
		submit.addActionListener(this);
		
		// add west panel to the content pane
		this.add(westPanel, BorderLayout.SOUTH);
	}

	/**
	 * Sets up the north panel to give the user
	 * additional information on how to search
	 * Contains JLabel
	 * and adds them to the top of the border layout on the JPanel.
	 */
	public void setupNorthPanel() {
		// set up north panel with label
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 1));

		// setup label
		northPanel.add(new JLabel (
				"<html> Please enter a competitor number.<br/>"
				+ "Select either full or short details then press OK.<br/>"
				+ "<li>1 to 20 for Dancers <br/>"
				+ "<li>100 to 114 for Knitters <br/>"
				+ "<li>200 to 210 for Gamers</html>"
				));

		// add north panel to the content pane
		this.add(northPanel, BorderLayout.NORTH);
	}

	/**
	 * Sets up the centre panel to display the details
	 * Contains JTextArea
	 * and adds them to the centre of the border layout on the JPanel.
	 */
	public void setupCenterPanel() {
		//setup centre panel with text area
		resultList = new JTextArea(10, 100);
		resultList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		resultList.setEditable(false);
		scrollList = new JScrollPane(resultList);
		
		// add center panel to broder layout
		this.add(scrollList, BorderLayout.SOUTH);
	}

	/**
	 * Sets up the south panel for the close button
	 * Contains JButton
	 * and adds them to the bottom of the border layout on the JPanel.
	 */
	public void setupSouthPanel() {
		// add south panel containing close button
		JPanel southPanel = new JPanel();
		close = new JButton("Save and Close");
		
		// add close button to south panel
		southPanel.add(close);
		
		// add the event listener to the button
		close.addActionListener(this);
		
		// add the south panel to the border layout
		this.add(southPanel, BorderLayout.SOUTH);
	}

	/**
	 *Sets up the actions to be performed depending on which button is pressed.
	 *<li>submit  displays the selected competition
	 *<li>close exits the application and writes the report to a text file
	 *<p>
	 *@param e  the event to be processed
	 */
	public void actionPerformed(ActionEvent e) {
		// if submit button then use search method
		if (e.getSource() == submit) {
			search();
		} 
		// if close button then write to file and exit application
		else if (e.getSource() == close) {
			String report = compList.getAllCompetitors();
			compList.writeToFile("CompetitorReport.txt", report);
			System.exit(0);
		}
	}
	
	 /**
	  * Identifies the user's input and searches for the associated competitor.
	  * Displays that competitor's full or short details
	  * dependent on the user's selection
	  * if the search was valid.
	  */
	private void search() {
		// get input and trim to remove additional spaces
		String searchString = searchField.getText().trim();
		
		// identify the selected button
		String detailsCommand = detailsGroup.getSelection().getActionCommand();

		//if full details selected then find the competitor and return full details
		if (detailsCommand == "fullDetails") {	
			
			// check the input is has a value
			if (searchString.length() > 0) {
				// convert user input String searchString to integer
				int competitorNumber = Integer.parseInt(searchString);
				// return the competitor object
				Competitor c = compList.findBycompetitorNumber2(competitorNumber);
				
				// if the competitor exists then return the full details
				if (c != null) {
					resultList.setText(c.getfullDetails());
				}
				// if the competitor doesn't exist display text
				else
					resultList.setText("Competitor not found");
			}
			// if no competitor number has been entered in the search box display text
			else
				resultList.setText("No competitor entered");
		}
		// else find the competitor and return short details
		else {
			// check the input is has a value
			if (searchString.length() > 0) {
				// convert user input String searchString to integer
				int competitorNumber = Integer.parseInt(searchString);
				// return the competitor object
				Competitor c = compList.findBycompetitorNumber2(competitorNumber);
				
				// if the competitor exists then return the short details
				if (c != null) {
					resultList.setText(c.getshortDetails());
				} 
				// if the competitor doesn't exist display text
				else
					resultList.setText("Competitor not found");
			} 
			// if no competitor number has been entered in the search box display text
			else
				resultList.setText("No competitor entered");
		}
	}
}
