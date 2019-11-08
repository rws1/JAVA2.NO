package assignment1;

import javax.swing.JOptionPane;

public class CompetitorManager {

	private CompetitorList allCompetitors;
	public CompetitorManager() {
		allCompetitors = new CompetitorList();
	}

	public void setCL(CompetitorList cl)
	{
		this.allCompetitors = cl;
	}
	//run the GUI to ask for a competitor number
	//and if found display competitor's short details
	public void run() {
		//start loop 1
		boolean exit = false;
		while (!exit) {			
			
			//start loop 2
			boolean ok = false;
			while (!ok) {
				try {
					//ask for input
					String cn = JOptionPane.showInputDialog(null,"Enter the competitor number:");
					//remove any spaces on input cn
					cn = cn.trim();
					//convert user input String cn to integer
					int competitorNumber = Integer.parseInt(cn);
					//call the findByCompetitorNumber method
					LEKCompetitor c = allCompetitors.findByCompetitorNumber(competitorNumber);
					
					//if the user input competitor number if found
					//then display the competitor's short details
					//and end loop
					if (c!=null) {
						JOptionPane.showMessageDialog(null, c.getShortDetails());
						ok = true;
					}
					//otherwise display error message and go back to start of loop 2
					else {
						JOptionPane.showMessageDialog(null, "Invalid Competitor Number. Please enter a number between 100 and 114.");
					}
				}
				//catch if user input is not an integer and go back to start of loop 2
				catch (NumberFormatException nfe) {
					String error = "Invalid input. Please enter a number between 100 and 114.";  
					JOptionPane.showMessageDialog(null,error);
				}
				//if cancel selected system exit
				catch (NullPointerException npe) {
					System.exit(0);
				}
			}
			//ask user if they wish to enter another number
			int confirm = JOptionPane.showConfirmDialog(null, "Would you like to search for another Competitor Number?", "Confirmation", JOptionPane.YES_NO_OPTION);
			
			//if yes then go to start of loop 1
			if(confirm == JOptionPane.YES_OPTION) {
				exit = false;
			}
			//otherwise end loop 1
			else {
				exit = true;
			}
		}
	}

}
