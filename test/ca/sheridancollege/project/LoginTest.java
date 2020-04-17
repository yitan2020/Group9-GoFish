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
public class LoginTest {
    
    public LoginTest() {
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
    //The best case the Login name has greater than 5 characters
    public void testLoginForTestingGood() {
        System.out.println("login");
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.loginForTesting("tan555");
        assertEquals(expResult, result);

    }
     @Test
    // the boundary case that the login name has 5 characters
    public void testLoginForTestingBoundary() {
        System.out.println("login");
        Login instance = new Login();
         boolean expResult = true;
        boolean result = instance.loginForTesting("tan55");
        assertEquals(expResult, result);

    }
    @Test
    //The boundary case that the login name has less than 5 characters 
    public void testLoginForTestingBad() {
        System.out.println("login");
        Login instance = new Login();
         boolean expResult = false;
        boolean result = instance.loginForTesting("tan");
        assertEquals(expResult, result);

    }
    
}
