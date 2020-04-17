/*
Yi Tan <tan5@sheridan.desire2learn.com>
----------------------------------------------------------------------
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
public class QuestionValidatorTest {
    
    public QuestionValidatorTest() {
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
    //The best case is to validate the card that appears in the hand great than one time. 
    
    public void testVerificationGood() {
        System.out.println("verification");
        GroupOfCards deck = new GroupOfCards();
        GroupOfCards hand = new GroupOfCards();
        deck.generateFullCardHand();
        hand.distributeInitialCards(7, deck.cards);
        QuestionValidator instance = new QuestionValidator("ONE", deck);
        boolean expResult = true;
        boolean result = instance.verification();
        assertEquals(expResult, result);

    }
     @Test
     // The boundary is to validate the card that appears in the hand only once 
    public void testVerificationBoundary() {
        System.out.println("verification");
        GroupOfCards deck = new GroupOfCards();
        GroupOfCards hand = new GroupOfCards();
        deck.generateFullCardHand();
        hand.distributeInitialCards(7, deck.cards);
        QuestionValidator instance = new QuestionValidator("TWO", deck);
        boolean expResult = true;
        boolean result = instance.verification();
        assertEquals(expResult, result);

    }
     @Test
     //The bad case is to validate the card that never appears in the hand
    public void testVerificationBad() {
        System.out.println("verification");
        GroupOfCards deck = new GroupOfCards();
        GroupOfCards hand = new GroupOfCards();
        deck.generateFullCardHand();
        hand.distributeInitialCards(7, deck.cards);
        QuestionValidator instance = new QuestionValidator("FORTEEN", deck);
        boolean expResult = false;
        boolean result = instance.verification();
        assertEquals(expResult, result);

    }
    
}
