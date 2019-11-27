import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUITwo extends JFrame {

	 //GUI components
	 JScrollPane scrollList;
	 JButton submit, showListById, showListByName, close;
	 JTextArea resultList;
	 JComboBox<String> competitors;

	 
	 public GUITwo() {

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
			        "Are you sure you want to exit?", "Exit Programme", JOptionPane.YES_NO_OPTION);

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
		 JComboBox<String> compList = new JComboBox<>();
		 DefaultComboBoxModel<String> compModel = new DefaultComboBoxModel<>();
		 compModel.addElement("Knitting");
		 compModel.addElement("Gaming");
		 compModel.addElement("Dancing");
		 compList.setModel(compModel);
		 compList.setEditable(false);
		 northPanel.add(compList);
		 
		 submit = new JButton("Submit");
		 northPanel.add(submit);

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
		 showListById = new JButton("Order By ID");


		 showListByName = new JButton("Order By Name");


		 close = new JButton("Close");


		 southPanel.add (showListById);
		 southPanel.add(showListByName);
		 southPanel.add(close);
		 this.add(southPanel, BorderLayout.SOUTH);
		 }	

//main method call to be moved to manager
	public static void main(String [] args) {
		GUITwo g2 = new GUITwo();
		g2.pack();  
		g2.setVisible(true);
	}

}
