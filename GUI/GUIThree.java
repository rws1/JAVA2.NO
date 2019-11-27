import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class GUIThree extends JFrame {

	 //GUI components
	 JScrollPane scrollList;
	 JButton submit, showListById, showListByName, close;
	 JTextArea resultList;
	 JComboBox<String> competitors;
	 JTextField searchField;
	 ButtonGroup detailsGroup;
	 JRadioButton fullDeets, shortDeets;

	 
	 public GUIThree() {

		 //set up window title
		 setTitle("Competitor Details");
		 //disable standard close button
		 setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		 setupSouthPanel();
		 setupNorthPanel();
		 setupCenterPanel();
		 setupWestPanel();
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
	 
	 private void setupWestPanel() {
		 //search panel contains label and text field
		 JPanel searchPanel = new JPanel();
		 searchPanel.setLayout(new GridLayout(1,2));
		 searchPanel.add(new JLabel("Enter ID"));
		 searchField = new JTextField(5);
		 searchPanel.add(searchField);
		 searchPanel.setPreferredSize(new Dimension(20,10));
		 
		 
		 //select panel contains 2 radio buttons
		 JPanel selectPanel = new JPanel();
		 selectPanel.setLayout(new GridLayout(2,1));
		 fullDeets = new JRadioButton("Full Details");
		 shortDeets = new JRadioButton("Short Details");
		 detailsGroup = new ButtonGroup();
		 
		 detailsGroup.add(fullDeets);
		 detailsGroup.add(shortDeets);
		 selectPanel.add(fullDeets);
		 selectPanel.add(shortDeets);
		 
		 //setup submit button
		 submit = new JButton("OK");
		 
				 
		 //set up south panel containing 3 previous areas
		 JPanel westPanel = new JPanel();
		 westPanel.setLayout(new GridLayout(3,1));
		 westPanel.add(searchPanel);
		 westPanel.add(selectPanel);
		 westPanel.add(submit);
		 //westPanel.setPreferredSize(new Dimension(200,400));
		 		 
		 //add west panel to the content pane
		 this.add(westPanel, BorderLayout.WEST);
	 }
	 	
	 private void setupNorthPanel() {
		 //north panel contains label
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(1,1));
		 
		 //setup label
		 northPanel.add(new JLabel("<html>Enter the competitor number and select either<br/>full or short details then press OK.</html>"));
		  
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
		 //add south panel containing close button
		 JPanel southPanel = new JPanel();
		 close = new JButton("Save and Close");

		 southPanel.add(close);
		 this.add(southPanel, BorderLayout.SOUTH);
		 }	

//main method call to be moved to manager
	public static void main(String [] args) {
		GUIThree g2 = new GUIThree();
		g2.pack();  
		g2.setVisible(true);
	}

}
