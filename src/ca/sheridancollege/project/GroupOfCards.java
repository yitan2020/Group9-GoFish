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
   private int size;
    //The group of cards, stored in an ArrayList
    public ArrayList <GoFishCards> cards = new ArrayList<>();
   
    
    public GroupOfCards() {
       
    }

       /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return this.cards.size();
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
    
    /**
     * 
     * @param givenSize
     * @return 7 initial cards 
     */
    public void distributeInitialCards(int givenSize, ArrayList <GoFishCards> deck)
    {
        
        for(int i=0; i< givenSize; i++) {
            this.cards.add(deck.get(i));
        }
        
        for(int i=givenSize-1; i>=0; i--) {
            deck.remove(i);
        }
       
        }//end method
    
    //insert a card to hand
    public void insertCard(GoFishCards card) {
        this.cards.add(card);
    }
    
    //delete a card from hand
    public void deleteCard(GoFishCards card) {
        System.out.println("this card is removed :"+card.toString());
        this.cards.remove(card);
    }
    
    
    /**
     * A method that will get the group of cards as an ArrayList
     */
    public void showCards()
    {
        for(GoFishCards card : this.cards) {
            System.out.print(card.toString()+" ");
        }
    }
    
    //after generate full hand cards, use this method to shuffle the cards
    public void shuffle()
    {
        Collections.shuffle(this.cards);
    }

    //sort the cards by value 
    public void sort() {
        Collections.sort(this.cards );
    }

	
    
        
	
}

	
    