package search_Algortihms;

import csm6120_assignment2.State;
import java.util.Comparator;

/**
 * This class is used to compare to states together. Implements teh Comparator
 * interface
 *
 * @author Stefan
 */
public class StateComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String goal) {
        int match;
        match = o1.compareTo(goal);
        return match;
    }

}
