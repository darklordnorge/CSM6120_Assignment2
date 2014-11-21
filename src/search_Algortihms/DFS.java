
package search_Algortihms;
import SearchTree.*;
import csm6120_assignment2.State;
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
    Stack<TreeNode> searchQueue, exploredQueue;
    int pathcost;
    
    public DFS(){
        tree = new Graph();
        searchQueue = new Stack();
        exploredQueue = new Stack();
        pathcost = 0;
    }
    
    public void dfs(State start, State goal){
        System.out.println("Using Depth-First Search");
        root = new TreeNode(start);
        /*
        check the root for being the goal state
        */
        if(root.returnState().compare(goal)){
            System.out.println("Solution has been found.\n Path cost: " 
                    +  pathcost);
            System.out.println("Current node: ");
            root.returnState().printArray();
            System.out.println("Goal state: ");
            goal.printArray();
        }
         searchQueue.add(root);
         
         while(searchQueue.size() > 0){
             node = searchQueue.pop();
             
             /*
             check the current node for being the goal node
             */
             if(node.returnState().compare(goal)){
                System.out.println("Solution has been found.\n Path cost: " 
                    +  pathcost);
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
             while(node.hasChildren() != true){ 
                 searchQueue.add(node.returnChild());
             }
             exploredQueue.add(node);
             pathcost++;
             node = searchQueue.pop();
        }
    }
}
