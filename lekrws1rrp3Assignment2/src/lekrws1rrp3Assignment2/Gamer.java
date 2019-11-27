package lekrws1rrp3Assignment2;

import java.util.Arrays;

public class Gamer extends Competitor implements Competitordetails{
	
	private int competitorAge;


	public Gamer (int competitorNumber, Name competitorName, String competitorLevel, String competitorLocation,
	int competitorAge, int[] competitorScores) {

	super (competitorNumber, competitorName, competitorLevel, competitorLocation, competitorScores);
	this.competitorAge = competitorAge;

	}
		

	public int getcompetitorAge() {
		return competitorAge;
	}

	public void setcompetitorAge(int competitorAge) {
		this.competitorAge = competitorAge;
	} 	
		
	//method to generate average from array
		public double getAveragescore(int[] competitorScores) {

			int sum = 0;
			double average = 0;
			for (int i = 0; i < competitorScores.length; i++)
				sum = sum + competitorScores[i];
			average = sum / competitorScores.length;
			return average;
		}

		// weighted average score
		public double getOverallScore() {
			double OverallScore;

			{

				if (competitorLevel.equals("Professional")) {
					OverallScore = getAveragescore(competitorScores) * 1.75;

				} else if (competitorLevel.equals("Veteran")) {
					OverallScore = getAveragescore(competitorScores) * 1.5;

				} else {
					OverallScore = getAveragescore(competitorScores) * 1.25;

				}

			}

			return OverallScore;
		}
		
		//method to print the score array
			public String getarrayofcompetitorScores() {
				return Arrays.toString(competitorScores);
			}

		// create get Full details method
			public String getfullDetails() {

				return "Competitor number " + competitorNumber + ", " + "name " + competitorName.getFullName() + ".\n"
						+ competitorName.getfirstName() + " is a " + competitorLevel + " aged " + competitorAge + " from " + competitorLocation + " and received these scores: "
						+ getarrayofcpmpetitorScores().replace("[", " ").replace("]", " ") + "\nThis gives them an overall score of "
						+ getOverallScore() + ".";
			}

}
