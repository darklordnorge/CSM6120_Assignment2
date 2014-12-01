package SearchAlgortihms;

import SearchTree.TreeNode;
import java.util.Comparator;

/**
 * This class is used to compare to states together. 
 * Implements the Comparator interface
 *
 * @author Stefan
 */
public class StateComparator implements Comparator<TreeNode> {
    
    /**
     * Method to compare 2 TreeNode objects for order. 
     * Compares 2 objects state string representation 
     * and orders them based on their natural ordering i.e.
     * 0 1 2 3 4 5 6 7 8 
     * 
     * @param o1    TreeNode object 1 to compare 
     * @param o2    TreeNode object 2 to compare
     * @return      a negative integer, zero, or a positive integer as the 
     *              first argument is less than, equal to, or greater 
     *              than the second
     */
    @Override
    public int compare(TreeNode o1, TreeNode o2) {
        int match;
        match = o1.getState().getStringtoString().compareTo
            (o2.getState().getStringtoString());
        return match;
    }

}
