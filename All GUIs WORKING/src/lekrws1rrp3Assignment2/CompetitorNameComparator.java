package lekrws1rrp3Assignment2;

//defines an ordering on Competitor objects on the name

import java.util.Comparator;
public class CompetitorNameComparator 
             implements Comparator<Competitor>
{
	public int compare(Competitor c1, Competitor c2) {
		return c1.getName().getFullName().compareTo(c2.getName().getFullName());
	}
}
