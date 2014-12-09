package SearchAlgortihms;

import SearchTree.TreeNode;
import SearchTree.Graph;
import csm6120.State;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Depth-First search algorithm class
 *
 * @author stefan
 */
public class DFS {

    private Graph tree;
    private TreeNode node, root;
    private Stack<TreeNode> searchStack;
    private Queue<TreeNode> exploredQueue;
    private int pathcost;
    private ArrayList expanded;
    private boolean solutionFound;

    /**
     * Constructor of the DFS object
     */
    public DFS() {
        this.tree = new Graph();
        this.searchStack = new Stack();
        this.exploredQueue = new LinkedList();
        this.pathcost = 0;
        this.expanded = new ArrayList<String>();
        this.solutionFound = false;
    }

    /**
     * Depth-First Search algorithm
     *
     * @param start The start state of the graph
     * @param goal The goal state of the graph
     */
    public void dfs(State start, State goal) {
        System.out.println("Using Depth-First Search");
        System.out.println("This may take a lot of time, please be patient");
        root = new TreeNode(start);
        /*
         check the root for being the goal state
         */
        if (root.getState().compare(goal)) {
            System.out.println("Solution has been found.\n Path cost: "
                    + pathcost);
            System.out.println("Nodes expanded: " + expanded.size());
            System.out.println("Current node: ");
            root.getState().printArray();
            System.out.println("Goal state: ");
            goal.printArray();
        }
        searchStack.add(root);

        while (searchStack.size() > 0) {
            node = searchStack.pop();

            /*
             check the current node for being the goal node
             */
            if (node.getState().compare(goal)) {
                System.out.println("Solution has been found.\n Path cost: "
                        + pathcost);
                System.out.println("Nodes expanded: " + expanded.size());
                System.out.println("Current node: ");
                node.getState().printArray();
                System.out.println("Goal state: ");
                exploredQueue.add(node);
                solutionFound = true;
                goal.printArray();
                break;
            }
            //generate the next level based on that node and add
            tree.nextStep(node);

            /*
             add the child of the current node and all its siblings to the queue
             */
            while (node.childrenIsEmpty() != true) {
                /*
                 Add the current node to a an ArrayList of expanded nodes
                 */
                if (expanded.contains(node.getState().getStringtoString()) == false) {
                    expanded.add(node.getState().getStringtoString());
                }
                String s = node.peekChild().getState().getStringtoString();
                if (expanded.contains(s) == false) {
                    expanded.add(s);
                    searchStack.push(node.getFirstChild());
                } else {
                    node.removeFirstChild();
                }
            }
            /*
             Add the current node to the exploredQueue
             and update the path cost
             */
            exploredQueue.add(node);
            pathcost = exploredQueue.size();
        }
        if (solutionFound == false) {
            System.out.println("No solution could be found");
        } else {
            this.printPath();
        }
    }

    /**
     * Prints the path from the start to the goal state of the puzzle
     */
    public void printPath() {
        System.out.println("The path to the goal is as follows: ");
        while (exploredQueue.isEmpty() == false) {

            exploredQueue.poll().getState().printArray();
        }
    }
}
