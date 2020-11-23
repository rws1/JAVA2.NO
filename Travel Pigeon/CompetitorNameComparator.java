package lekrws1rrp3Assignment2;

/** Software Engineering Foundations
 * Assignment 2
 * Defines an ordering on Competitor objects on the name
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

//import toolkits
import java.util.Comparator;

public class CompetitorNameComparator 
             implements Comparator<Competitor> {
	/**
	 *Compares the names of the competitors
	 *
	 *@param  c1 the first competitor to be compared
	 *@param  c2 the first competitor to be compared
	 *
	 *@return the name of the first competitor compared to the name of the second competitor
	 */
	public int compare(Competitor c1, Competitor c2) {
		return c1.getName().getFullName().compareTo(c2.getName().getFullName());
	}
}
