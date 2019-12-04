package lekrws1rrp3Assignment2;

import java.util.Comparator;

/** Software Engineering Foundations
 * Assignment 2
 * Defines an ordering on Competitor objects on the competitor number
 * @author Lynsey Kirk, Rachana Patel, Rob Stone
 */

public class CompetitorNumberComparitor 
             implements Comparator<Competitor> {
	/**
	 *Compares the competitor numbers of the competitors
	 *
	 *@param  c1 the first competitor to be compared
	 *@param  c2 the first competitor to be compared
	 *
	 *@return the competitor number of the first competitor 
	 *		  compared to the competitor number of the second competitor
	 */
	public int compare(Competitor c1, Competitor c2) {
		return c1.getcompetitorNumber()-c2.getcompetitorNumber();
	}
}
