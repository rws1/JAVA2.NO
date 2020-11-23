package lekrws1rrp3Assignment2;

/** Software Engineering Foundations
 * Assignment 2
 * The main GUI Frame that contains
 * the three GUIs in tabs.
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class tabbedPane extends JPanel {
	/**
	 * Create the tabbedPane GUI
	 * @param list
	 */
	public tabbedPane(CompetitorList list) {
		super(new GridLayout(1, 1));

		final GUIOne guiOne = new GUIOne(list);
		final GUITwo guiTwo = new GUITwo(list);
		final GUIThree guiThree = new GUIThree(list);
		final JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon1 = createImageIcon("Trophy.png");
		ImageIcon icon2 = createImageIcon("Sort.png");
		ImageIcon icon3 = createImageIcon("Search.png");

		tabbedPane.add("GUI One", guiOne);
		guiOne.setPreferredSize(new Dimension(500, 600));
		guiOne.setupNorthPanel();
		guiOne.setupWestPanel();
		guiOne.setupCenterPanel();
		guiOne.setupSouthPanel();
		tabbedPane.addTab("Competitor Scores", icon1, guiOne,
				"Change/Update the scores of your competitors and retrieve the updated overall score");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		tabbedPane.add("GUI Two", guiTwo);
		guiTwo.setupNorthPanel();
		guiTwo.setupCenterPanel();
		guiTwo.setupSouthPanel();
		guiTwo.setPreferredSize(new Dimension(850, 550));
		tabbedPane.addTab("Competitor Sorter", icon2, guiTwo,
				"Filter competitors based on attributes, such as competition and/or name etc");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

		tabbedPane.add("GUI Three", guiThree);
		guiThree.setupNorthPanel();
		guiThree.setupWestPanel();
		guiThree.setupCenterPanel();
		guiThree.setupSouthPanel();
		guiThree.setPreferredSize(new Dimension(500, 400));
		tabbedPane.addTab("ID Search", icon3, guiThree,
				"Change/Update the scores of your competitors and retrieve the updated overall score");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_3);

		// Add the tabbed pane to this panel
		add(tabbedPane);

		// The following line enables to use scrolling tabs
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}

	/**
	 * Creates the images to be used on the GUI
	 * @param path
	 * @returnImageIcon, or null if the path was invalid
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = tabbedPane.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
