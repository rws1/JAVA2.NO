import java.util.Scanner;
/**
 * Once initialised by RWS1competitorMain run() function, it requests a file from user which is subsequently parsed into a report. Supplementary user input then provides
 * additional statistics if requested. 
 * @author rws1
 *
 */
public class RWS1Manager {

	public void run() {
		RWS1competitorList c = new RWS1competitorList();

		Scanner userInput = new Scanner(System.in);
		System.out.print(
				"Welcome to JavaCompetitorProcessor.\n\nTo create a report for your competition, please provide the file path : ");
		try {
			String filename = userInput.next();

			c.readFile(filename);
			String overallReport = c.getAllCompetitors();
			c.writeToFile("RWS1Report.txt", overallReport);

			System.out.println("\nThe report has been written to file RWS1Report.txt\n");
		}

		catch (Exception f) {
			System.out.println("\nFile not found, please try again");
		}

		System.out.println("Would you like to search for the details of a competitor? (Y or N) : ");
		String input2 = userInput.next();

		do {
			try {

				switch (input2) {
				case "Y":

					System.out
							.print("Please enter the competitor number for the athlete you are looking for, as there are "
									+ (c.getNoCompetitors()) + " competitors, please enter a number between 1 and "
									+ (c.getNoCompetitors())
									+ ".\nIf you dont want to search or are done searching, please enter 0 to finish : ");
					int input3 = userInput.nextInt();
					do 
					{
						if (input3 <= c.getNoCompetitors() && input3 >= 1) 
						{
							System.out.println(	"\n| Short Details |\n" + (c.getByCompNo(input3).getShortDetails() + "\n"));
							System.out.println("| Full Details |\n" + (c.getByCompNo(input3).getFullDetails()) + "\n");
							break;

						} 
						else if (input3 == 0) {
							System.out.println("\nThank you for using JavaCompetitorProcessor.");
							System.exit(0);
							break;

						}
						else
							System.out.println(
									"No Competitor found with that number, please enter a valid competitor number.\n\n");
						break;
					}
					while (input3 != 0);
// allow to fall
				case "N":
					System.out.println("Thank you for using JavaCompetitorProcessor.");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid character input, please enter Y or N");
					System.exit(0);
				}
			} 
			catch (NumberFormatException f) {
				String error = "Conversion error ' " + input2 + " '  - " + f.getMessage();
				System.out.println(error);
			}

			userInput.close();
		} 
		while (input2 != "Y" && input2 != "N");
	}
}
