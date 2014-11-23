package search_Algortihms;

import SearchTree.*;
import csm6120_assignment2.State;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author stefan
 */
public class DFS {

    Graph tree;
    TreeNode node, root;
    Stack<TreeNode> searchStack, exploredStack;
    int pathcost;
    ArrayList expanded;

    public DFS() {
        tree = new Graph();
        searchStack = new Stack();
        exploredStack = new Stack();
        pathcost = 0;
        expanded = new ArrayList<String>();
    }

    public void dfs(State start, State goal) {
        System.out.println("Using Depth-First Search");
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
        searchStack.add(root);

        while (searchStack.size() > 0) {
            node = searchStack.pop();

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
            while (node.hasChildren() != true) {
                /*
                 Add the current node to a an ArrayList of expanded nodes
                 */
                if (expanded.contains(node.returnState().returnString()) == false) {
                    expanded.add(node.returnState().returnString());
                }
                String s = node.peekChield().returnState().returnString();
                if (expanded.contains(s) == false) {
                    expanded.add(s);
                    searchStack.push(node.returnChield());
                } else {
                    node.removeFirstChield();
                }
            }
            exploredStack.add(node);
            pathcost++;
        }
    }
}
