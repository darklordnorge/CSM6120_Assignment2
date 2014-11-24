
package search_Algortihms;

import SearchTree.Graph;
import SearchTree.TreeNode;
import csm6120_assignment2.State;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Greedy Best-First Search class
 * 
 * @author stefan
 */
public class GBFS {
    private int pathcost;
    private Graph tree;
    private Queue<TreeNode> searchQueue;
    private Queue<TreeNode> exploredQueue;
    private TreeNode node, root;
    
    /**
     * Constructor of the GBFS class
     */
    public GBFS(){
        this.pathcost = 0;
        this.tree = new Graph();
        this.exploredQueue = new LinkedList();
        this.searchQueue = new LinkedList();
    }
    
    /**
     * Greedy Best-First Search algorithm
     * 
     * @param start The start State of the graph
     * @param goal  The goal State of the graph
     */
    public void gbfs(State start, State goal){
        System.out.println("Using Breadth-First Search");
        root = new TreeNode(start);
        /*
         check the root for being the goal state
         */
        if (root.returnState().compare(goal)) {
            System.out.println("Solution has been found.\n Path cost: "
                    + pathcost);
            System.out.println("Current node: ");
            root.returnState().printArray();
            System.out.println("Goal state: ");
            goal.printArray();
        }
        searchQueue.add(root);

        /*
        Iterate while the search queue is not empty
        */
        while (searchQueue.size() > 0) {
            node = searchQueue.poll();

            /*
             check the current node for being the goal node
             */
            if (node.returnState().compare(goal)) {
                System.out.println("Solution has been found.\n Path cost: "
                        + pathcost);
                System.out.println("Current node: ");
                node.returnState().printArray();
                System.out.println("Goal state: ");
                goal.printArray();
                break;
            }
            //generate the next level based on that node and add
            tree.nextStep(node);

            /*
             add the child of the current node and all its siblings to the queue
             */
            while (node.childrenIsEmpty() != true) {
                searchQueue.add(node.pollChield());
            }
            
            /*
            add the current node to the explored node and 
            update path cost
            */
            exploredQueue.add(node);
            pathcost++;
        }
    }
    
    
   
}
