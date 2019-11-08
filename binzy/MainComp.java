package assignment1;

public class MainComp {

	public static void main(String[] args) {
		CompetitorList cl = new CompetitorList();
		cl .readFile("competitorList.csv");
		String report = cl.getAllCompetitors();
		cl .writeToFile("competitorReport.txt", report);

		CompetitorManager cm = new CompetitorManager();
		cm.setCL(cl);
		cm.run();
	}
}
