package search_Algortihms;

import SearchTree.TreeNode;
import csm6120_assignment2.State;
import java.util.Comparator;

/**
 * This class is used to compare to states together. Implements teh Comparator
 * interface
 *
 * @author Stefan
 */
public class StateComparator implements Comparator<TreeNode> {

    @Override
    public int compare(TreeNode o1, TreeNode o2) {
        int match;
        match = o1.returnState().getStringtoString().compareTo(o2.returnState().getStringtoString());
        return match;
    }

}
