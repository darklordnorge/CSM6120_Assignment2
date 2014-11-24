package csm6120_assignment2;

import java.util.ArrayList;

/**
 * This class has methods and variables to hold an input state. This will be
 * used to hold the start and goal state object.
 *
 * @author stefan
 */
public class State {

    private ArrayList<Integer> state;

    /**
     * Constructor for the State object creates an empty arrayList in which the
     * state data will be saved
     */
    public State() {
        this.state = new ArrayList();
    }

    /**
     * Constructor for the State object creates a deep clone of the state object
     * which is specified in the parameter field
     *
     * @param s The state to clone
     */
    public State(State s) {
        this.state = new ArrayList();
        state.addAll(s.state);
    }

    /**
     * Method to add an integer to the arrayList
     *
     * @param toAdd The integer to add
     */
    public void addState(int toAdd) {
        this.state.add(toAdd);
    }

    /**
     * Print the arraylist
     */
    public void printArray() {
        for (int i = 0; i < state.size(); i++) {
            System.out.println(state.get(i));
        }
    }

    /**
     * Method to return the index of a specific item in the arraylist
     *
     * @param i The item to search for
     * @return The position of the item in the arraylist
     */
    public int returnIndex(int i) {
        return this.state.indexOf(i);
    }

    /**
     * Method to exchange to tiles
     *
     * @param i Index of the tile to change
     * @param j Index of the Empty tile to change
     */
    public void changeTiles(int i, int j) {
        int temp, tempIndex, empty, emptyIndex;

        temp = this.state.get(i);
        this.state.remove(i);
        this.state.add(i, 0); //move empty tile where i was
        this.state.remove(j);
        this.state.add(j, temp);

    }

    /**
     * This method clones the arrayList and returns it
     *
     * @return The cloned arrayList
     */
    public ArrayList clone() {
        ArrayList clone = new ArrayList();
        for (Integer state1 : state) {
            clone.add(state1);
        }
        return clone;
    }

    public boolean compare(State s) {
        int match = 0;
        for (int i = 0; i < s.state.size(); i++) {
            if (this.state.get(i) == s.state.get(i)) {
                match++;
            }
        }
        if (match == 9) {
            return true;
        }
        return false;
    }

    public String returnString() {
        String s = this.state.toString();
        return s;
    }
}
