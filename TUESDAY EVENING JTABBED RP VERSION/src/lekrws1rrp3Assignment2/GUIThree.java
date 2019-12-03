package lekrws1rrp3Assignment2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class GUIThree extends JPanel implements ActionListener {
	
	//the competitor list
	private CompetitorList compList;


	 //GUI components
	 JScrollPane scrollList;
	 JButton submit, close;
	 JTextArea resultList;
	 JTextField searchField;
	 ButtonGroup detailsGroup;
	 JRadioButton fullDeets, shortDeets;

	 
	 public GUIThree(CompetitorList list) {
		 
		 this.compList = list;


	 }
	 
	 public void setupWestPanel() {
		 //search panel contains label and text field
		 JPanel searchPanel = new JPanel();
		 searchPanel.setLayout(new GridLayout(1,2));
		 searchPanel.add(new JLabel("Enter ID"));
		 searchField = new JTextField(5);
		 searchPanel.add(searchField);
		 searchPanel.setPreferredSize(new Dimension(20,10));
		  setFont(new Font (Font.MONOSPACED, Font.PLAIN,20));
		 
		 //select panel contains 2 radio buttons
		 JPanel selectPanel = new JPanel();
		 selectPanel.setLayout(new GridLayout(2,1));
		 
		 fullDeets = new JRadioButton("Full Details");
		 shortDeets = new JRadioButton("Short Details");
		 fullDeets.setActionCommand("fullDetails");
		 shortDeets.setActionCommand("shortDetails");
		 
		 fullDeets.setSelected(true);
		 detailsGroup = new ButtonGroup();
		 detailsGroup.add(fullDeets);
		 detailsGroup.add(shortDeets);
		 selectPanel.add(fullDeets);
		 selectPanel.add(shortDeets);
		
		 
		 
		 //setup submit button
		 submit = new JButton("OK");
		 
		 //specify action when button is pressed
		 submit.addActionListener(this);
		 
				 
		 //set up south panel containing 3 previous areas
		 JPanel westPanel = new JPanel();
		 westPanel.setLayout(new GridLayout(3,1));
		 westPanel.add(searchPanel);
		 westPanel.add(selectPanel);
		 westPanel.add(submit);
		 //westPanel.setPreferredSize(new Dimension(200,400));
		 		 
		 //add west panel to the content pane
		 this.add(westPanel, BorderLayout.SOUTH);
	 }
	 	
	 public void setupNorthPanel() {
		 //north panel contains label
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(1,1));
		 
		 //setup label
		 northPanel.add(new JLabel("<html> Please enter a competitor number from 1 to 20 for Dancers, 100 to 114 for Knitters and 200 to 210 for Gamers <br/> and select either full or short details then press OK.</html>"));
		  
		 //add north panel to the content pane
		 this.add(northPanel, BorderLayout.NORTH);
		 }
	 
	 
	 
	 public void setupCenterPanel() {
		 resultList = new JTextArea(10,100);
		 resultList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		 resultList.setEditable(false);
		 scrollList = new JScrollPane(resultList);
		 this.add(scrollList,BorderLayout.SOUTH);
		 }

	 
	public void setupSouthPanel() {
		 //add south panel containing close button
		 JPanel southPanel = new JPanel();
		 close = new JButton("Save and Close");

		 southPanel.add(close);
		 
		 close.addActionListener(this);
		 
		 this.add(southPanel, BorderLayout.SOUTH);
		 }	
	 
	 public void actionPerformed(ActionEvent e) {
		//if submit button then use search method
			if (e.getSource() == submit) {
		    	search();
			}
			else if(e.getSource() == close ) {
			  String report = compList.getAllCompetitors();
			  compList.writeToFile("CompetitorReport.txt", report);
			  System.exit(0);
			}
	 }
	 
	 private void search() {
		 String searchString = searchField.getText().trim();
		 String detailsCommand = detailsGroup.getSelection().getActionCommand();
		 
		 if(detailsCommand == "fullDetails") {
		 
			 if(searchString.length() > 0) {
				 
				 //convert user input String searchString to integer
				 int competitorNumber = Integer.parseInt(searchString);
				 Competitor c = compList.findBycompetitorNumber2(competitorNumber);
	
				 if (c!= null ) {
					 resultList.setText(c.getfullDetails());
				 }
				 else
					 resultList.setText("Competitor not found");
				 }
				 else
					 resultList.setText("no text entered");
		}
		 else {
			 
		 	if(searchString.length() > 0) {
			 
			 //convert user input String searchString to integer
			 int competitorNumber = Integer.parseInt(searchString);
			Competitor c = compList.findBycompetitorNumber2(competitorNumber);

			 if (c!= null ) {
				 resultList.setText(c.getshortDetails());
			 }
			 else
				 resultList.setText("not found");
			 }
			 else
				 resultList.setText("no text entered");
		 }
	 	
	 }
}