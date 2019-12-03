package lekrws1rrp3Assignment2;

//defines an ordering on Competitor objects on competitor number

import java.util.Comparator;
public class CompetitorNumberComparitor 
             implements Comparator<Competitor>
{
	public int compare(Competitor c1, Competitor c2) {
		return c1.getcompetitorNumber()-c2.getcompetitorNumber();
	}
}