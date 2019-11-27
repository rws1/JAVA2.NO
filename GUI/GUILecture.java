import java.awt.*;
import javax.swing.*;

public class GUIOne extends JFrame {

	 //GUI components
	 JTextField result;
	 JTextField searchField;
	 JButton search;
	 JScrollPane scrollList;
	 JButton showListById, showListByName, close;
	 JTextArea displayList;
	 JList competitors;

	 
	 
	 public GUIOne() {
	 
	 
		//set up window title
		 setTitle("Competitor Scoring");
		 //disable standard close button
		 //setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		 setDefaultCloseOperation(this.EXIT_ON_CLOSE); //change this to the above when ready
		 setupSouthPanel();
		 setupNorthPanel();
		 setupCenterPanel();
		 //pack and set visible
		 pack();
		 setVisible(true);
	
	 }
	
	 
	 private void setupCenterPanel() {
		 displayList = new JTextArea(15,20);
		 displayList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		 displayList.setEditable(false);
		 scrollList = new JScrollPane(displayList);
		 this.add(scrollList,BorderLayout.CENTER);
		 }
	
	 private void setupSouthPanel() {
		 //search panel contains label, text field and button
		 JPanel searchPanel = new JPanel();
		 searchPanel.setLayout(new GridLayout(1,3));
		 searchPanel.add(new JLabel("Enter ID"));
		 searchField = new JTextField(5);
		 searchPanel.add(searchField);
		 search = new JButton("Search");
		 searchPanel.add(search);
		 //specify action when button is pressed

	
		 //Set up the area where the results will be displayed.
		 result= new JTextField(25);
		 result.setEditable(false);

		 //set up south panel containing 2 previous areas
		 JPanel southPanel = new JPanel();
		 southPanel.setLayout(new GridLayout(2,1));
		 southPanel.add(searchPanel);
		 southPanel.add(result);

		 //add south panel to the content pane
		 this.add(southPanel, BorderLayout.SOUTH);
		 }

	 private void setupNorthPanel() {
		 //add north panel containing some buttons
		 JPanel northPanel = new JPanel();
		 showListById = new JButton("List By ID");


		 showListByName = new JButton("List By Name");


		 close = new JButton("Close");


		 northPanel.add (showListById);
		 northPanel.add(showListByName);
		 northPanel.add(close);
		 this.add(northPanel, BorderLayout.NORTH);
		 }	


public static void main(String [] args)
{
	GUIOne bf = new GUIOne();
	//bf.setSize(300,320);
	//pack works out the best size of the frame for itself
	//based on what components there are
	bf.pack();  
	bf.setVisible(true);
}

}
