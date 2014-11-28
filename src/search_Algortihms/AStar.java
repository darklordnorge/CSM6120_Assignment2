/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search_Algortihms;

import SearchTree.Graph;
import SearchTree.TreeNode;
import csm6120_assignment2.State;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A* algorithm class
 *
 * @author Stefan
 */
public class AStar {

    private int pathcost, maxDistance;
    private Graph tree;
    private PriorityQueue<TreeNode> searchQueue;
    private Queue<TreeNode> exploredQueue;
    private TreeNode node, root;
    private StateComparator comparator;
    private ArrayList<String> expanded;
    private ManhattanDistance md;
    private int manhattanDistanceSum;

    /**
     * A* class constructor
     */
    public AStar() {
        this.pathcost = 0;
        this.maxDistance = 0;
        this.tree = new Graph();
        this.exploredQueue = new LinkedList();
        comparator = new StateComparator();
        this.searchQueue = new PriorityQueue(500, comparator);
        expanded = new ArrayList<String>();
        manhattanDistanceSum = 0;

    }

    /**
     * A* algorithm
     *
     * @param start The start State
     * @param goal The goal State
     */
    public void astar(State start, State goal) {
        System.out.println("Using A* Search");
        /*
         initialise ManhattanDistance
         */
        this.md = new ManhattanDistance(start, goal);

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

        manhattanDistanceSum = md.calcManhattanDistance(root.returnState(), goal);
        System.out.println("Manhatten distance is: " + manhattanDistanceSum);


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
            this.addNode(node, goal);
            /*
             add the child of the current node and all its siblings to the queue
             */
//            while (node.childrenIsEmpty() != true) {
//                /*
//                 Add the current node to a an ArrayList of expanded nodes
//                 */
//                if (expanded.contains(node.returnState().getStringtoString()) == false) {
//                    expanded.add(node.returnState().getStringtoString());
//                }
//                String s = node.peekChield().returnState().getStringtoString();
//                if (expanded.contains(s) == false && pathcost < manhattanDistanceSum) {
//                    expanded.add(s);
//                    searchQueue.add(node.pollChield());
//                } else {
//                    node.removeFirstChield();
//                }
//            }

            /*
             add the current node to the explored node and 
             update path cost
             */
            exploredQueue.add(node);
            pathcost = exploredQueue.size();
        }
    }
    
    /**
     * Method to add a new node the the search queue.
     * This method calculates the Manhattan Distance for every child in the 
     * current node and only add them to the search queue if the 
     * Manhattan Distance is less than the original calculated one.
     * 
     * @param current       The current node
     * @param goal          The goal node, use for the Manhattan Distance
     *                      calculation
     */
    public void addNode(TreeNode current, State goal) {
        int currentManhattanDistance;
        String s;
        TreeNode temp;

        while (current.childrenIsEmpty() != true) {
            /*
             Add the current node to the list of expanded nodes
             */
            if (expanded.contains(current.returnState().getStringtoString()) == false) {
                expanded.add(current.returnState().getStringtoString());
            }

            s = current.peekChield().returnState().getStringtoString();

            if (expanded.contains(s) == false) {
                temp = current.pollChield();
                currentManhattanDistance = md.
                        calcManhattanDistance(temp.returnState(), goal);

                if (currentManhattanDistance < manhattanDistanceSum) {
                    expanded.add(s);
                    searchQueue.add(temp);
                }
            } else {
                current.removeFirstChield();
            }
        }
    }
}
