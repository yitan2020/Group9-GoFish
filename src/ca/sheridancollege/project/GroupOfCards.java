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
    public ArrayList <GoFishCards> cards = new ArrayList<>();
    /**
	 * the size of the grouping
	 * @param givenSize
    * */
    private int size;
    
    public GroupOfCards() {
       
    }

    public GroupOfCards(ArrayList<GoFishCards> cards, int size) {
        this.cards = cards;
        this.size = size;
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

      //generate 52 cards saved in the cards arrayList  
    public void generateFullCardHand() {
                for(CardSuit s: CardSuit.values())
                {
                    for(CardValue v: CardValue.values())
                    {                  
                       this.cards.add(new GoFishCards(v,s));
                    }
                }//end outter for
        }//end method
    
    
    public ArrayList<GoFishCards> distributeInitialCards(int givenSize)
    {

        ArrayList<GoFishCards> distributedCards = new ArrayList<>();
        
        for(int i=0; i< givenSize; i++) {
            distributedCards.add(this.cards.get(i));
        }
        
        for(int i=0; i< givenSize; i++) {
            this.cards.remove(i);
        }
        
        return distributedCards; 
       
        }//end method
    
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
//    public void showCards()
//    {
//        return cards;
//    }
    
    //after generate full hand cards, use this method to shuffle the cards
    public void shuffle()
    {
        Collections.shuffle(this.cards);
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
    
        
	
}

	
    