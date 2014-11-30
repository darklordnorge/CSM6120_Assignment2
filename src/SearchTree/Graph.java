package SearchTree;

import csm6120_assignment2.State;


/**
 * This class is used to generate the next step in the graph.
 *
 * @author Stefan
 */
public class Graph {

    /**
     * Constructor for the graph object
     */
    public Graph() {

    }

    /**
     * Algorithm to generate the next state in the graph Based on the fact that
     * empty space can only move horizontally and vertically. To make the
     * process easier simple numbers identifiers are assigned to the possible
     * tiles in the puzzle. These numbers represent indices in the arrayList and
     * are : 0 1 2 3 4 5 6 7 8 This method checks where the empty tile is and
     * calls other methods to switch the tiles.
     *
     * @param s The state on which the next step will be based
     */
    public void nextStep(TreeNode s) {
        int emptyTile; //index of the empty tile
        emptyTile = s.getState().returnIndex(0);

        if (emptyTile == 0) {
            this.corner(emptyTile, s);
        } else if (emptyTile == 1) {
            this.midSection(emptyTile, s);
        } else if (emptyTile == 2) {
            this.corner(emptyTile, s);
        } else if (emptyTile == 3) {
            this.midSection(emptyTile, s);
        } else if (emptyTile == 4) {
            this.center(emptyTile, s);
        } else if (emptyTile == 5) {
            this.midSection(emptyTile, s);
        } else if (emptyTile == 6) {
            this.corner(emptyTile, s);
        } else if (emptyTile == 7) {
            this.midSection(emptyTile, s);
        } else if (emptyTile == 8) {
            this.corner(emptyTile, s);
        }
    }

    /**
     * This method is used to generate the next level of the graph when the
     * empty tile is at a corner. Saves all changes to a arrayList of possible
     * states. The tiles where this method is used corresponds with the fields
     * 0, 2, 6 ,and 8 as shown below
     *
     * 0 1 2
     * 3 4 5
     * 6 7 8
     *
     * @param tile The index of the empty tile(0)
     * @param s The state to base algorithm on
     */
    public void corner(int tile, TreeNode s) {
        State tempState1 = new State(s.getState());
        State tempState2 = new State(s.getState());
        TreeNode firstChield, secondChield;
        if (tile == 0) {
            tempState1.changeTiles(1, 0);
            firstChield = new TreeNode(tempState1);

            tempState2.changeTiles(3, 0);
            secondChield = new TreeNode(tempState2);

            firstChield.addSibling(secondChield);
            s.addChild(firstChield);
            s.addChild(secondChield);

        } else if (tile == 2) {
            tempState1.changeTiles(1, 2);
            firstChield = new TreeNode(tempState1);

            tempState2.changeTiles(5, 2);
            secondChield = new TreeNode(tempState2);

            firstChield.addSibling(secondChield);
            s.addChild(firstChield);
            s.addChild(secondChield);
        } else if (tile == 6) {
            tempState1.changeTiles(3, 6);
            firstChield = new TreeNode(tempState1);

            tempState2.changeTiles(7, 6);
            secondChield = new TreeNode(tempState2);

            firstChield.addSibling(secondChield);
            s.addChild(firstChield);
            s.addChild(secondChield);
        } else if (tile == 8) {
            tempState1.changeTiles(5, 8);
            firstChield = new TreeNode(tempState1);

            tempState2.changeTiles(7, 8);
            secondChield = new TreeNode(tempState2);

            firstChield.addSibling(secondChield);
            s.addChild(firstChield);
            s.addChild(secondChield);
        }
    }

    /**
     * This method to generate the next level of the graph when the empty
     * tile(0) is on the midsection of the sides. Saves all possible states to
     * an arrayList. The tiles where this method will be used correspond to the
     * fields 1, 3, 5, and 7 as shown below
     *
     * 0 1 2
     * 3 4 5
     * 6 7 8
     *
     * @param tile The index of the empty tile(0)
     * @param s The state to base algorithm on
     */
    public void midSection(int tile, TreeNode s) {
        State tempState1 = new State(s.getState());
        State tempState2 = new State(s.getState());
        State tempState3 = new State(s.getState());
        TreeNode chield1, chield2, chield3;

        if (tile == 1) {
            tempState1.changeTiles(0, tile);
            chield1 = new TreeNode(tempState1);

            tempState2.changeTiles(2, tile);
            chield2 = new TreeNode(tempState2);

            tempState3.changeTiles(4, tile);
            chield3 = new TreeNode(tempState3);

            chield1.addSibling(chield2);
            chield2.addSibling(chield3);
            s.addChild(chield1);
            s.addChild(chield2);
            s.addChild(chield3);

        } else if (tile == 3) {
            tempState1.changeTiles(0, tile);
            chield1 = new TreeNode(tempState1);

            tempState2.changeTiles(4, tile);
            chield2 = new TreeNode(tempState2);

            tempState3.changeTiles(6, tile);
            chield3 = new TreeNode(tempState3);

            chield1.addSibling(chield2);
            chield2.addSibling(chield3);
            s.addChild(chield1);
            s.addChild(chield2);
            s.addChild(chield3);
        } else if (tile == 5) {
            tempState1.changeTiles(2, tile);
            chield1 = new TreeNode(tempState1);

            tempState2.changeTiles(4, tile);
            chield2 = new TreeNode(tempState2);

            tempState3.changeTiles(8, tile);
            chield3 = new TreeNode(tempState3);

            chield1.addSibling(chield2);
            chield2.addSibling(chield3);
            s.addChild(chield1);
            s.addChild(chield2);
            s.addChild(chield3);
        } else if (tile == 7) {
            tempState1.changeTiles(4, tile);
            chield1 = new TreeNode(tempState1);

            tempState2.changeTiles(6, tile);
            chield2 = new TreeNode(tempState2);

            tempState3.changeTiles(8, tile);
            chield3 = new TreeNode(tempState3);

            chield1.addSibling(chield2);
            chield2.addSibling(chield3);
            s.addChild(chield1);
            s.addChild(chield2);
            s.addChild(chield3);
        }
    }

    /**
     * This method generates the next level of the graph if the empty tile(0) is
     * in the center of the puzzle. (Tile 4 in the representation below Saves
     * all possible states to an arrayList.
     *
     * 0 1 2
     * 3 4 5
     * 6 7 8
     *
     * @param tile The index of the empty tile
     * @param s The state to base algorithm on
     */
    public void center(int tile, TreeNode s) {
        State tempState1 = new State(s.getState());
        State tempState2 = new State(s.getState());
        State tempState3 = new State(s.getState());
        State tempState4 = new State(s.getState());
        TreeNode chield1, chield2, chield3, chield4;

        tempState1.changeTiles(1, tile);
        chield1 = new TreeNode(tempState1);

        tempState2.changeTiles(3, tile);
        chield2 = new TreeNode(tempState2);

        tempState3.changeTiles(5, tile);
        chield3 = new TreeNode(tempState3);

        tempState4.changeTiles(7, tile);
        chield4 = new TreeNode(tempState4);

        chield1.addSibling(chield2);
        chield2.addSibling(chield3);
        chield3.addSibling(chield4);
        s.addChild(chield1);
        s.addChild(chield2);
        s.addChild(chield3);
        s.addChild(chield4);
    }
}
