/*
Yi Tan <tan5@sheridan.desire2learn.com>
----------------------------------------------------------------------
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Yi Tan <tan5@sheridan.desire2learn.com>
 */
public class testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GroupOfCards fullHand = new GroupOfCards();
        fullHand.generateFullCardHand();
        fullHand.shuffle();
        
        ArrayList<GoFishCards> intialCards;
        intialCards = fullHand.distributeInitialCards(7);
        
        
        for(GoFishCards c : fullHand.cards) {
            
            System.out.println(c.getValue() +" "+c.getSuit());
        }
   
        System.out.println("the size of full hand"+ fullHand.cards.size());

    
    }
    
}
