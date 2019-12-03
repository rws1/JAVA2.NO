package lekrws1rrp3Assignment2;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CompetitorMain {

	public static void main(String[] arg) {
		
		
		CompetitorManager Manager = new CompetitorManager();
		Manager.run();
		
		//Turn off metal's use of bold fonts
    	// Set Motif L&F on any platform
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}	
	
	}
