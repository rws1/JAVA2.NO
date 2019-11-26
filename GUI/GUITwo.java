import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

public class GUITwo extends JFrame {

	 //GUI components
	 JTextField result;
	 JTextField searchField;
	 JButton search;
	 JScrollPane scrollList;
	 JButton showListById, showListByName, close;
	 JTextArea displayList;
	 JList<String> competitors;

	 
	 
	 public GUITwo() {
	 
	 
		//set up window title
		 setTitle("Competitor Details");
		 //disable standard close button
		 //setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		 setDefaultCloseOperation(this.EXIT_ON_CLOSE); //change this to the above when ready
		 setupSouthPanel();
		 setupNorthPanel();
		 setupCenterPanel();
		 setupWestPanel();
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
	
	 private void setupWestPanel() {
		 //setup list panel
		 JPanel compListPanel = new JPanel();
		 compListPanel.setLayout(new GridLayout(2,1));
		 compListPanel.add(new JLabel("Select Competition:"));
		 //setup list
		 JList<String> compList = new JList<>();
		 DefaultListModel<String> compModel = new DefaultListModel<>();
		 compModel.addElement("Knitting");
		 compModel.addElement("Gaming");
		 compModel.addElement("Dancing");
		 compList.setModel(compModel);
		 compListPanel.add(compList);
		 
		 compList.setPreferredSize(new Dimension(90, 70));
		 compList.setBorder(BorderFactory.createEtchedBorder());
		 
		 
		 
		 //set up west panel containing 2 previous areas
		 JPanel westPanel = new JPanel();
		 westPanel.setLayout(new GridLayout(2,1));
		 westPanel.add(compListPanel);
		 
		 

		 //add north panel to the content pane
		 this.add(westPanel, BorderLayout.WEST);
		 }

		 
	 
	
	 private void setupNorthPanel() {
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

		 //set up north panel containing 2 previous areas
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(2,1));
		 northPanel.add(searchPanel);
		 northPanel.add(result);

		 //add north panel to the content pane
		 this.add(northPanel, BorderLayout.NORTH);
		 }

	 private void setupSouthPanel() {
		 //add north panel containing some buttons
		 JPanel southPanel = new JPanel();
		 showListById = new JButton("List By ID");


		 showListByName = new JButton("List By Name");


		 close = new JButton("Close");


		 southPanel.add (showListById);
		 southPanel.add(showListByName);
		 southPanel.add(close);
		 this.add(southPanel, BorderLayout.SOUTH);
		 }	


public static void main(String [] args)
{
	GUITwo bf = new GUITwo();
	//bf.setSize(300,320);
	//pack works out the best size of the frame for itself
	//based on what components there are
	bf.pack();  
	bf.setVisible(true);
}

}
