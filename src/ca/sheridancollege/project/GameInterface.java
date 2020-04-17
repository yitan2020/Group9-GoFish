/*
Yi Tan <tan5@sheridan.desire2learn.com>
----------------------------------------------------------------------
 */
package ca.sheridancollege.project;

import static ca.sheridancollege.project.PlayGoFish.matchCards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Yi Tan <tan5@sheridan.desire2learn.com>
 */
public class GameInterface {
    public static ArrayList<String> books = new ArrayList<String>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlayGoFish game = new PlayGoFish();
        game.play();
//        GroupOfCards deck = new GroupOfCards();
//        GroupOfCards userHand = new GroupOfCards();
//        GroupOfCards cpHand = new GroupOfCards();
//        int cpBooks =0;
//        deck.generateFullCardHand();
//        deck.shuffle();
//        
//        //players get the inital cards and check if they have any books
//        cpHand.distributeInitialCards(51, deck.cards);
//        cpHand.sort();
//        cpHand.showCards();
//        System.out.println("\n");
//        
//        
//        cpBooks = matchBook(cpHand, books);
//        System.out.println("The no. books are "+ cpBooks);
//        for(String s : books) {
//            System.out.println("The books are: "+ s);
//        }
        

    }

//        public static int matchBook(GroupOfCards cardsInHand, ArrayList<String> books) {
//        int count=0;
//        ArrayList<String> cardValue = new ArrayList<String>();
//        for(int i=0; i<cardsInHand.cards.size();i++) {
//            cardValue.add(cardsInHand.cards.get(i).getValue().toString());
//        }
//       
//        for(int i=0; i<cardsInHand.cards.size();i++) {
//            int num = Collections.frequency(cardValue, cardsInHand.cards.get(i).getValue().toString());
//            if(num==4) {
//                if((!books.contains(cardsInHand.cards.get(i).getValue().toString()))) {
//                    books.add(cardsInHand.cards.get(i).getValue().toString());
//                    count++;
//            }
//        }
//        }
//        
//
//        return count;
//        
//    }
        
}
        
   
      

