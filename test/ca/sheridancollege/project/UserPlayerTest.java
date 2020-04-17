/*
Yi Tan <tan5@sheridan.desire2learn.com>
----------------------------------------------------------------------
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yi Tan <tan5@sheridan.desire2learn.com>
 */
public class UserPlayerTest {
    
    public UserPlayerTest() {
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

 


    @Test
    // create a new instance of UserPlayer, the String with user ID, the number of game winning
    // and the number of game losing should be displayed in the console
    public void testDisplayResult() {
        System.out.println("displayResult");
        UserPlayer instance = new UserPlayer("tan5", 2, 0);
        instance.displayResult();

    }

    
}
