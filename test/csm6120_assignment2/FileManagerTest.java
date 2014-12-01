/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csm6120_assignment2;

import csm6120.State;
import csm6120.FileManager;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stefan
 */
public class FileManagerTest {
    
    public FileManagerTest() {
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
     * Test of reader method, of class FileManager.
     */
//    @Test
//    public void testReader() {
//        System.out.println("reader");
//        State s = new State();
//        File path = null;
//        FileManager instance = new FileManager();
//        instance.reader(s, path);
//        // TODO review the generated test code and remove the default call to fail.
//    //    fail("The test case is a prototype.");
//    }

    /**
     * Test of findInteger method, of class FileManager.
     */
    @Test
    public void testFindInteger() {
        System.out.println("findInteger");
        String s = "1, 2 ";
        State state = new State();
        FileManager instance = new FileManager();
        instance.findInteger(s, state);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    
}
