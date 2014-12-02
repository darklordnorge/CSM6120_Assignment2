package SearchAlgortihms;

import SearchTree.TreeNode;
import SearchTree.Graph;
import csm6120.State;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class file for the Breadth first search algorithm
 *
 * @author stefan
 */
public class BFS {

    Graph tree;
    TreeNode node, root;
    Queue<TreeNode> searchQueue;
    Stack<TreeNode> exploredStack;
    int pathcost;

    /**
     * Constructor of the BFS object
     */
    public BFS() {
        tree = new Graph();
        searchQueue = new LinkedList();
        exploredStack = new Stack();
        pathcost = 0;
    }

    /**
     * Breath-First search method 
     * 
     * @param start     The start State of the graph
     * @param goal      The goal State of the graph 
     */
    public void bfs(State start, State goal) {
        System.out.println("Using Breadth-First Search");
        root = new TreeNode(start);
        /*
         check the root for being the goal state
         */
        if (root.getState().compare(goal)) {
            System.out.println("Solution has been found.\n Path cost: "
                    + pathcost);
            System.out.println("Current node: ");
            root.getState().printArray();
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
            if (node.getState().compare(goal)) {
                System.out.println("Solution has been found.\n Path cost: "
                        + pathcost);
                System.out.println("Current node: ");
                node.getState().printArray();
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
                searchQueue.add(node.getFirstChild());
            }
            
            /*
            add the current node to the explored node and 
            update path cost
            */
            exploredStack.add(node);
            pathcost = exploredStack.size();
        }
    }
}