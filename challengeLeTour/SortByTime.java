/**
 * 
 */
package challengeLeTour;

import java.util.Comparator;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class SortByTime implements Comparator<Rider> {

	@Override
	public int compare(Rider o1, Rider o2) {
		// TODO Auto-generated method stub
		return o1.getTime().compareTo(o2.getTime());
	}

}
