package lekrws1rrp3Assignment2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUIOne extends JFrame implements ActionListener {
	
	
	//the competitor list
	private CompetitorList compList;

	//GUI components
	JTextField compNumberField, nameField, locationField, levelField, overallScore, searchField;
	JTextField [] scoresField;
	JLabel result;
	JButton search, update, close;

	 
	 public GUIOne(CompetitorList list) {
		 
		this.compList = list;

		 //set up window title
		 setTitle("Competitor Details");
		 //disable standard close button
		 setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		 
		 setupSouthPanel();
		 setupNorthPanel();
		 setupCenterPanel();
		 
		//pack, set visible and locate in middle of screen
		 pack();
		 setVisible(true);
		 setLocationRelativeTo(null); 
		 
		 //show JOptionpane confirmation when close button pressed
		 addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
			   int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to exit? You're changes will not be saved.", "Exit Programme", JOptionPane.YES_NO_OPTION);

			   if (confirmed == JOptionPane.YES_OPTION) {
			      dispose();
			   }
			 }
		});
	 }
	 	
	 private void setupNorthPanel() {
		//search panel contains label, text field and button
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(2,2));
		
		//setup search field
		searchField = new JTextField(5);
		
		//setup label
		result = new JLabel("");
		result.setForeground(Color.RED);
		
		//setup search button
		search = new JButton("Search");

		//add components to search panel
		searchPanel.add(new JLabel("  Competitor Number:  "));
		searchPanel.add(searchField);
		searchPanel.add(result);
		searchPanel.add(search);
		
		//add the event listener to the buttons
		search.addActionListener(this);
		 
		//add search panel to border layout
		this.add(searchPanel, BorderLayout.NORTH);
		}
	 
	 private void setupCenterPanel() {
		//set up centre panel with labels, text fields, buttons and panels
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(6,2));
		
		//setup competitor number field
		JLabel compNumberLabel = new JLabel("  Competitor Number:  ");
		compNumberField= new JTextField(5);
		compNumberField.setEditable(false);
		
		//setup competitor name field
		JLabel nameLabel = new JLabel("  Name:");
		nameField= new JTextField(10);
		nameField.setEditable(false);
		
		//setup location name field
		JLabel locationLabel = new JLabel("  Location:");
		locationField = new JTextField(5);
		locationField.setEditable(false);
		
		//setup level name field
		JLabel levelLabel = new JLabel("  Experience:");
		levelField = new JTextField(5);
		levelField.setEditable(false);
		
		//setup panel for scores
		JLabel scoresLabel = new JLabel("  Scores:");
		JPanel scoresPanel = new JPanel();
		//assumes only 5 scores
		scoresField = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			  scoresField[i] = new JTextField(2);
			  scoresField[i].setEditable(true);
			  //add to scores panel
			  scoresPanel.add((scoresField[i]));
		  }
		  
		//setup dummy label
		JLabel dummy = new JLabel("");
		
		//setup update button
		update = new JButton ("Update");
		update.setEnabled(false);
		
		//add components to centre panel
		centerPanel.add(compNumberLabel);
		centerPanel.add(compNumberField);
		centerPanel.add(nameLabel);
		centerPanel.add(nameField);
		centerPanel.add(locationLabel);
		centerPanel.add(locationField);
		centerPanel.add(levelLabel);
		centerPanel.add(levelField);
		centerPanel.add(scoresLabel);
		centerPanel.add(scoresPanel);
		centerPanel.add(dummy);
		centerPanel.add(update);
		  
		//add the event listener to the buttons
		update.addActionListener(this);

		//add centre panel to the content pane
		this.add(centerPanel, BorderLayout.CENTER);
		}
	 
	 
	 private void setupSouthPanel() {
		//setup south panel with label and text field containing overall score
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(3,1));
		
		//setup overall score field
		overallScore = new JTextField(25);
		overallScore.setEditable(false);
		
		//setup close button
		close = new JButton("Save and close");
		 
		//add components to south panel
		southPanel.add(new JLabel("  Overall Score: "));
		southPanel.add(overallScore);
		southPanel.add(close);
		
		 //add the event listener to the buttons
		 close.addActionListener(this);
		 
		 
		//add south panel to the content pane
		 this.add(southPanel, BorderLayout.SOUTH);
	 }
	 
	//setup the actions to be performed
	public void actionPerformed(ActionEvent e) {
		//if submit button then use search method
		if (e.getSource() == search) {
			  search();
		}
		//if update button then use update method
		else if (e.getSource() == update) {
		  update();
		}
		//if update button then use update method
		else if (e.getSource() == close) {
		  String report = compList.getAllCompetitors();
		  compList.writeToFile("CompetitorReport.txt", report);
		  dispose();
		}
	 }
	 
	 private void search() {
		 //get input and trim to remove additional spaces
		 String searchString = searchField.getText().trim();
		 
		 //check the input is has a value
		 if(searchString.length() > 0) {
			 
			 //convert user input String searchString to integer
			 int competitorNumber = Integer.parseInt(searchString);
			 Competitor c = compList.findBycompetitorNumber2(competitorNumber);
			 
			 //if the competitor exists then return their details
			 if (c!= null ) {
				 compNumberField.setText(String.valueOf(c.getcompetitorNumber()));
				 nameField.setText(c.getName().getFullName());
				 locationField.setText(c.getcompetitorLocation());
				 levelField.setText(c.getcompetitorLevel());
				 //loop through scores field and scores array to display all scores
				 for (int i = 0; i < 5; i++) {
					 scoresField[i].setText("");
					 }
					 int [] scores = c.getScoreArray();
					 for (int i = 0; i < scores.length; i++) {
						 scoresField[i].setText(String.valueOf(scores[i]));
					  }
				 overallScore.setText(String.valueOf(c.getOverallScore()));
				 update.setEnabled(true);
			 }
			 else {
				compNumberField.setText("not found");
			 	clear();
			 }
		 }
			 else {
				compNumberField.setText("no competitor entered");
		 		clear();
			 }
		 }
	 
	  //updates scores
	  private void update() {
		  String searchString = searchField.getText().trim();
		  int competitorNumber = Integer.parseInt(searchString);
		  Competitor c = compList.findBycompetitorNumber2(competitorNumber);
		  String newScoresStr[] = new String[5];
		  for (int i = 0; i < 5; i++) {
			  newScoresStr[i]=scoresField[i].getText();
		  }
		  int newScores[] = new int[5];
		  	for(int i = 0; i < 5; i++ ) {
		  		newScores[i] = Integer.parseInt(newScoresStr[i]);
		  	}
		  c.setcompetitorScores(newScores);
		  overallScore.setText(String.valueOf(c.getOverallScore()));
	  }
	  
	  private void clear() {
		  nameField.setText("");
		  locationField.setText("");
		  levelField.setText("");
		  for (int i = 0; i < 5; i++) {
			  scoresField[i].setText("");
		  }
		  update.setEnabled(false);
		  }
	
}
