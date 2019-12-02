package lekrws1rrp3Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class knitterList {

	private ArrayList<Knitter> knitterList;

	private Scanner scanner;

	public knitterList() {
		knitterList = new ArrayList<Knitter>();

	}

	public void add(Knitter k) {
		knitterList.add(k);

	}

	private void processLine(String line) {
		try {
			String parts[] = line.split(",");
			{
				String competition = parts[0].trim();

				Name competitorName = new Name(parts[2], parts[3], parts[4]);
				String competitorNumber = parts[1];
				int cnum = Integer.parseInt(competitorNumber);
				String competitorLevel = parts[5];
				String competitorLocation = parts[6];
				String competitorAge = parts[7];
				int cage = Integer.parseInt(competitorAge);

				int scoresLength = parts.length - 8;
				String scoresStr[] = new String[scoresLength];

				// copy from input array to string of scores
				System.arraycopy(parts, 8, scoresStr, 0, scoresLength);

				// convert from string array to int array

				int competitorScores[] = new int[scoresLength];
				for (int i = 0; i < scoresLength; i++) {
					competitorScores[i] = Integer.parseInt(scoresStr[i]);
					if (competitorScores[i] > 0 && competitorScores[i] <= 5)
						;
				}

				Knitter k = new Knitter(competition, cnum, competitorName, competitorLevel, competitorLocation, cage,
						competitorScores);
				knitterList.add(k);
			}
		}

		// catches for exceptions - both have been tested for functionality by
		// altering
		// the input file
		catch (NumberFormatException ohno) {
			String error = "Number conversion error in '" + line + "'  - " + ohno.getMessage();
			System.out.println(error);
		} catch (ArrayIndexOutOfBoundsException ohshoot) {
			String error = "Not enough items in  : '" + line + "' index position : " + ohshoot.getMessage();
			System.out.println(error);

		}
	}

	public void readFile(String string) {
		try {
		File k = new File("KnitterInput.csv");
		scanner = new Scanner(k);
		while (scanner.hasNextLine()) {
			String inputLine = scanner.nextLine();
			if (inputLine.length() != 0) {
				processLine(inputLine);
			}
		} 
		}
		catch (FileNotFoundException fnf) {
			System.out.println(string + " not found ");
			System.exit(0);
		}
	}
	
	public String getKnitterList() {
		String report = "";
		for (Knitter k  : knitterList) {
			report += String.format("%-40s", k.getcompetition());
			report += String.format("%-6d", k.getcompetitorNumber());
			report += String.format("%-40s", k.getName().getFullName() );
			report += String.format("%-20s", k.getcompetitorLevel());
			report += String.format("%-20s", k.getcompetitorLocation());
			report += String.format("%-20s", k.getAge());
			report += String.format("%-20s", k.getScoreArray());			
			report += String.format("%-1.1f", k.getOverallScore());
			report += "\n";
		}
		return report;
	}
	
	
}
