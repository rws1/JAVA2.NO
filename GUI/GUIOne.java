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
	 JButton search, update;

	 
	 public GUIOne(CompetitorList list) {
		 
		this.compList = list;

		//set up window title
		setTitle("Competitor Scoring");
		//disable standard close button
		setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		setupNorthPanel();
		setupCenterPanel();
		setupSouthPanel();
		//pack and set visible
		pack();
		setVisible(true);
		setLocationRelativeTo(null); //sets position of JFrame to middle of screen
		 
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
		searchPanel.add(new JLabel("  Competitor Number:  "));
		searchField = new JTextField(5);
		searchPanel.add(searchField);
		result = new JLabel("");
		result.setForeground(Color.RED);
		searchPanel.add(result);
		search = new JButton("Search");
		searchPanel.add(search);
		 
		//specify action when button is pressed
		search.addActionListener(this);
		 

		this.add(searchPanel, BorderLayout.NORTH);

		}
	 
	 
	 
	 private void setupCenterPanel() {
		//Set up centre panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(6,2));
		JLabel compNumberLabel = new JLabel("  Competitor Number:  ");
		centerPanel.add(compNumberLabel);
		compNumberField= new JTextField(5);
		compNumberField.setEditable(false);
		centerPanel.add(compNumberField);

		JLabel nameLabel = new JLabel("  Name:");
		centerPanel.add(nameLabel);
		nameField= new JTextField(10);
		nameField.setEditable(false);
		centerPanel.add(nameField);

		JLabel locationLabel = new JLabel("  Location:");
		centerPanel.add(locationLabel);
		locationField = new JTextField(5);
		locationField.setEditable(false);
		centerPanel.add(locationField);

		JLabel levelLabel = new JLabel("  Experience:");
		centerPanel.add(levelLabel);
		levelField = new JTextField(5);
		levelField.setEditable(false);
		centerPanel.add(levelField);

		JLabel scoresLabel = new JLabel("  Scores:");
		centerPanel.add(scoresLabel);
		//assume only 5 scores
		JPanel scoresPanel = new JPanel();
		scoresField = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			  scoresField[i] = new JTextField(2);
			  scoresField[i].setEditable(true);
			  scoresPanel.add((scoresField[i]));
		  }
		  centerPanel.add(scoresPanel);

		JLabel dummy = new JLabel("");
		centerPanel.add(dummy);
		
		update = new JButton ("Update");
		update.setEnabled(false);
		centerPanel.add(update);
		  
		//specify action when button is pressed
		update.addActionListener(this);

		//add centre panel to the content pane
		this.add(centerPanel, BorderLayout.CENTER);
		
		}
	 
	 
	 private void setupSouthPanel() {
		//setup south panel with label and text field containing overall score
		 JPanel southPanel = new JPanel();
		 southPanel.setLayout(new GridLayout(2,1));
		 southPanel.add(new JLabel("  Overall Score: "));
		 overallScore = new JTextField(25);
		 overallScore.setEditable(false);
		 southPanel.add(overallScore);
		 
		 
		//add south panel to the content pane
		 this.add(southPanel, BorderLayout.SOUTH);
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			  search();
			}
			else if (e.getSource() == update) {
			  update();
			 }
	 }
	 
	 private void search() {
		 System.out.println("search");
		 String searchString = searchField.getText().trim();
		 
		 if(searchString.length() > 0) {
			 
			 //convert user input String searchString to integer
			 int competitorNumber = Integer.parseInt(searchString);
			 LEKCompetitor c = compList.findByCompetitorNumber(competitorNumber);

			 if (c!= null ) {
				 compNumberField.setText(String.valueOf(c.getCompetitorNumber()));
				 nameField.setText(c.getCompetitorName().getFullName());
				 locationField.setText(c.getCompetitorLocation());
				 levelField.setText(c.getCompetitorExperience());
				  for (int i = 0; i < 3; i++) {
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
		  System.out.println("update");
//		  String searchString = searchField.getText().trim();
//		  int competitorNumber = Integer.parseInt(searchString);
//		  LEKCompetitor c = compList.findByCompetitorNumber(competitorNumber);
//		  

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
