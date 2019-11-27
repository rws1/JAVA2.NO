public class CompetitorManager {

	private CompetitorList allCompetitors;
	public CompetitorManager() {
		allCompetitors = new CompetitorList();
	}

	public void setCL(CompetitorList cl) {
		this.allCompetitors = cl;
	}
	
	
	public void gui() {		
		
		GUIOne g1 = new GUIOne(allCompetitors);
		g1.pack();  
		g1.setVisible(true);
		
		GUITwo g2 = new GUITwo(allCompetitors);
		g2.pack();  
		g2.setVisible(true);
		
		GUIThree g3 = new GUIThree(allCompetitors);
		g3.pack();  
		g3.setVisible(true);
	}
}
