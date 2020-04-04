/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author Yi Tan
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;/**
	 * the size of the grouping
	 * @param givenSize
	 */
    
    public void distributeInitialCards(int givenSize)
    {
       
        }//end metho
    
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
    public void sort() {
		// TODO - implement GroupOfCards.sort
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cards
	 * @param size
	 */
    public void generateCardHand(Card cards, int size) {
	
	}

	
    
}//end class
