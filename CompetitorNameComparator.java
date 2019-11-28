//defines an ordering on Staff objects on the name

import java.util.Comparator;
public class CompetitorNameComparator 
               implements Comparator<LEKCompetitor>
{
	public int compare(LEKCompetitor c1, LEKCompetitor c2) {
		return c1.getCompetitorName().getFullName().compareTo(c2.getCompetitorName().getFullName());
	}
}
