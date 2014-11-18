/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csm6120_assignment2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class StateTest {
    
    public StateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addState method, of class State.
     */
    @Test
    public void testAddState() {
        System.out.println("addState");
        int toAdd = 0;
        int expectedResult = 1;
        State instance = new State();
        instance.addState(toAdd);
      //  assertEquals(expResult, instance.state.size()); //test passes however 
            //would require the arraylist in State to be public
    }

    /**
     * Test of printArray method, of class State.
     */
    @Test
    public void testPrintArray() {
        System.out.println("printArray");
        State instance = new State();
        instance.printArray();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of return_index method, of class State.
     */
    @Test
    public void testReturn_index() {
        System.out.println("return_index");
        int i = 0;
        State instance = new State();
        int expResult = 2;
        instance.addState(1);
        instance.addState(2);
        instance.addState(0);
        instance.addState(3);
        instance.addState(4);
        instance.addState(5);
        instance.addState(6);
        instance.addState(7);
        instance.addState(8);
        int result = instance.return_index(i);
        assertEquals(expResult, result);
    }
    
}
