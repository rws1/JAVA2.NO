import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUITwo extends JFrame implements ActionListener {
	
	//the competitor list
	private CompetitorList compList;

	 //GUI components
	 JScrollPane scrollList;
	 JButton submit, orderListByID, orderListByName, close;
	 JTextArea resultList;
	 JComboBox<String> competitionList = new JComboBox<>();
	 DefaultComboBoxModel<String> compModel = new DefaultComboBoxModel<>();

	 
	 public GUITwo(CompetitorList list) {
		 
		 this.compList = list;

		 //set up window title
		 setTitle("Competitor Details");
		 //disable standard close button
		 setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		 setupSouthPanel();
		 setupNorthPanel();
		 setupCenterPanel();
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
		 //north panel contains label, combo box and button
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(1,3));
		 
		 //setup label
		 northPanel.add(new JLabel(" Select Compitition:  "));
		 
		 //setup combo box

		 compModel.addElement("Knitting");
		 compModel.addElement("Gaming");
		 compModel.addElement("Dancing");
		 competitionList.setModel(compModel);
		 competitionList.setEditable(false);
		 northPanel.add(competitionList);
		 
		 submit = new JButton("Submit");
		 northPanel.add(submit);
		 
		 //specify action when button is pressed
		 submit.addActionListener(this);

		 //add north panel to the content pane
		 this.add(northPanel, BorderLayout.NORTH);
		 }
	 	 
	 
	 private void setupCenterPanel() {
		 resultList = new JTextArea(15,20);
		 resultList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		 resultList.setEditable(false);
		 scrollList = new JScrollPane(resultList);
		 this.add(scrollList,BorderLayout.CENTER);
		 }

	 
	 private void setupSouthPanel() {
		 //add south panel containing some buttons
		 JPanel southPanel = new JPanel();
		 orderListByID = new JButton("Order By ID");
		 orderListByName = new JButton("Order By Name");
		 close = new JButton("Close");

		 southPanel.add (orderListByID);
		 southPanel.add(orderListByName);
		 southPanel.add(close);
		 //specify action when button is pressed
		 orderListByID.addActionListener(this);
		 orderListByName.addActionListener(this);
		 close.addActionListener(this);
		 this.add(southPanel, BorderLayout.SOUTH);
		 }	
	 
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == submit) {
	    		search();
	    	}
	    	else if (e.getSource() == orderListByID) {
	    		sortByID();
	    	}
	    	else if (e.getSource() == orderListByName ) {
	    		sortByName();
	    	}
	 }
	 
	 private void search() {
		 String competitionSelected = (String)competitionList.getSelectedItem();

		 if(competitionSelected == "Knitting") {
			 resultList.setText(compList.getAllCompetitors());
			 }
			 else
				 resultList.setText("not found");
	 }
	 
	 public void sortByName() {
		 String competitionSelected = (String)competitionList.getSelectedItem();
		 	if(competitionSelected == "Knitting") {
		 		resultList.setText(compList.listByName());
		 	 }
			 else
				 resultList.setText("not found");
	 }
	 
	 public void sortByID() {
		 String competitionSelected = (String)competitionList.getSelectedItem();
		 	if(competitionSelected == "Knitting") {
		 		resultList.setText(compList.listByID());
		 	 }
			 else
				 resultList.setText("not found");
	 }
	 
	 	
}

