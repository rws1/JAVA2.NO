package lekrws1rrp3Assignment2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUITwo extends JFrame implements ActionListener {
	
	//the competitor list
	private CompetitorList compList;
	private knitterList knitterList;


	 //GUI components
	 JScrollPane scrollList;
	 JButton submit, orderListByID, orderListByName, close;
	 JTextArea resultList;
	 JComboBox<String> competitionList = new JComboBox<>();
	 DefaultComboBoxModel<String> compModel = new DefaultComboBoxModel<>();

	 
	 public GUITwo(CompetitorList list, knitterList listKnitters) {
		 
		 this.compList = list;
		 this.knitterList = listKnitters; 

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
		 //north panel contains label, combo box and button
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(1,3));
		 
		 //setup label
		 northPanel.add(new JLabel(" Select Compitition:  "));
		 
		 //setup combo box
		 compModel.addElement("All competitors");
		 compModel.addElement("Dancing");
		 compModel.addElement("Gaming");
		 compModel.addElement("Knitting");
		 
		 competitionList.setModel(compModel);
		 competitionList.setEditable(false);
		 
		 //setup submit button
		 submit = new JButton("Submit");
		 
		 //add components to north panel
		 northPanel.add(competitionList);
		 northPanel.add(submit);
		 
		 //add the event listener to the buttons
		 submit.addActionListener(this);

		 //add north panel to the content pane
		 this.add(northPanel, BorderLayout.NORTH);
		 }
	 	 
	 
	 private void setupCenterPanel() {
		 //centre panel contains text area for results to appear
		 resultList = new JTextArea(15,20);
		 resultList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		 resultList.setEditable(false);
		 scrollList = new JScrollPane(resultList);
		 
		 //add scroll list to border layout
		 this.add(scrollList,BorderLayout.CENTER);
		 }

	 
	 private void setupSouthPanel() {
		 //south panel contains sort buttons and close button
		 JPanel southPanel = new JPanel();
		 orderListByID = new JButton("Order By ID");
		 orderListByName = new JButton("Order By Name");
		 close = new JButton("Close");
		 
		 //add components to south panel
		 southPanel.add (orderListByID);
		 southPanel.add(orderListByName);
		 southPanel.add(close);
		 
		 //add the event listener to the buttons
		 orderListByID.addActionListener(this);
		 orderListByName.addActionListener(this);
		 close.addActionListener(this);
		 
		 //add south panel to the border layout
		 this.add(southPanel, BorderLayout.SOUTH);
		 }	
	 
	 //setup the actions to be performed
	 public void actionPerformed(ActionEvent e) {
		 
		//if submit button then use search method
		if (e.getSource() == submit) {
	    		search();
	    }
		//if order by ID button then use sortByID method
	    else if (e.getSource() == orderListByID) {
	    		sortByID();
	    }
		//if order by name button then use sortByName method
	    else if (e.getSource() == orderListByName ) {
	    		sortByName();
	    }
	 }
	 
	 
	 //THIS MIGHT NEED TO CHANGE DEPENDING ON HOW THE COMPLIST WILL
	 //RETURN THE LIST OF COMPETITORS FOR THE COMPETITIONS
	 
	 //identify which option from the combo box was chosen and display 
	 //the corresponding details for the selection
	 private void search() {
		String competitionSelected = (String)competitionList.getSelectedItem();

		//THIS WORKS - RETURNS LIST OF ALL COMPETITORS
		if(competitionSelected == "All competitors") {
			 resultList.setText(compList.getCompetitorList());
		}
		
		
//		else if (competitionSelected == "Dancing") {
//			resultList.setText(compList.getCompetitionCount("Dancer"));
//			//TEST TO CHECK COMBOBOX WORKS
//			//resultList.setText("Dancing button test");
//		}
//		
		
		else if (competitionSelected == "Dancing") {
			resultList.setText(compList.getCompetitionList("Dancer"));
			//TEST TO CHECK COMBOBOX WORKS
			//resultList.setText("Dancing button test");
		}
		else if (competitionSelected == "Gaming") {
			resultList.setText(compList.getCompetitionList("Gamer"));
			//TEST TO CHECK COMBOBOX WORKS
			//resultList.setText("Gaming button test");
		}
		else if (competitionSelected == "Knitting") {
			resultList.setText(knitterList.getKnitterList());
			//TEST TO CHECK COMBOBOX WORKS
			//resultList.setText("Knitting button test");
		}
	 }
	 
	 //THE FOLLOWING TWO METHODS WILL ADDITIONAL ELSE STATEMENTS
	 //DEPENDING ON THE COMPETITION SELECTED
	 //ONCE THE COMPLIST METHODS ARE DONE
	 
	 //identify which option from the combo box was chosen and display 
	 //the corresponding details for the selection in name order
	 public void sortByName() {
		 String competitionSelected = (String)competitionList.getSelectedItem();
		 	//THIS WORKS - RETURNS LIST OF ALL COMPETITORS IN ID ORDER
		 	if(competitionSelected == "All competitors") {
		 		resultList.setText(compList.listByName());
		 	 }
			 else
				 resultList.setText("not found");
	 }
	 
	 //identify which option from the combo box was chosen and display 
	 //the corresponding details for the selection in ID order
	 public void sortByID() {
		 String competitionSelected = (String)competitionList.getSelectedItem();
		 	//THIS WORKS - RETURNS LIST OF ALL COMPETITORS IN NAME ORDER
		 	if(competitionSelected == "All competitors") {
		 		resultList.setText(compList.listByID());
		 	 }
			 else
				 resultList.setText("not found");
	 }
}

