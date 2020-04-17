package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
/**
 * 
 * @author Yi Tan <tan5@sheridan.desire2learn.com>
 * This class is used to implement the GoFish game 
 * extends the Game class 
 */


public class PlayGoFish extends Game {
   // private ArrayList<GoFishCards> userHand,cpHand,deck;
    private ArrayList<String> books = new ArrayList<String>();    
    private int userBooks=0, cpBooks=0;

    public PlayGoFish() {
        super();
    }
    
    


    @Override
    public boolean play() {
        GroupOfCards deck = new GroupOfCards();
        GroupOfCards userHand = new GroupOfCards();
        GroupOfCards cpHand = new GroupOfCards();
        deck.generateFullCardHand();
        deck.shuffle();
        
        //players get the inital cards and check if they have any books
        cpHand.distributeInitialCards(7, deck.cards);
        cpHand.sort();
        //cpBooks += matchBook(cpHand, books);
        System.out.println("cp initial cards are: ");
        cpHand.showCards();
        System.out.println("\n ");
        cpBooks = matchBook(cpHand, books);
        
        
        userHand.distributeInitialCards(7, deck.cards);
        userHand.sort();
        System.out.println("user initial cards are: ");
        userHand.showCards();
        System.out.println("\n");
        userBooks = matchBook(userHand, books);


        System.out.println("\n after get the initial cards, books user has: "+userBooks);
        System.out.println("\n after get the initial cards, books cp has: "+cpBooks);
        
    
        do {
        userTurn(userHand, cpHand, deck);
        System.out.println("***********************************************");

        System.out.println("It's computer's turn to ask you question");
        
        cpTurn(userHand, cpHand, deck);
        
        System.out.println("***********************************************");

        } while (!(deck.cards.isEmpty()) && (!cpHand.cards.isEmpty()) && (!userHand.cards.isEmpty()));
        System.out.println("***********************************************");
        return declareWinner();
    }
   
    // in userTurn, the user asks the computer a value, and check the validation of the question, 
    // if computer has the cards, user will insert the cards from computer and computer will delete the same cards
    //if computer has no cards, the user will draw a card from the deck. 
    public void userTurn(GroupOfCards userHand, GroupOfCards cpHand, GroupOfCards deck) {
         boolean flag = true;
        String req_value;
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.clear();
        //System.out.printf("there are %d card in the match array", index.size());
        
        //get a value of the card from user and validate the value
        do {
            System.out.println("\n Please ask computer a value of the card(using capital words): ");
            Scanner input = new Scanner (System.in);
             req_value = input.nextLine();
            QuestionValidator checkQuestion = new QuestionValidator(req_value, userHand);
            if(checkQuestion.verification()) {
                flag =false;
            } else {
                System.out.println("Your question is not valid! Please re-enter. \n");
            }
        }while (flag); 
        
        //check if the computer has the cards that the user asks for
        index = matchCards(req_value, cpHand, index);
        
        //if computer doesn't have the card, user draw a card from the deck and display the cards in hand
        if(index.isEmpty()) {
            System.out.println("************************************************************");
            System.out.println("Computer doesn't have the card you asked for. ");
            System.out.println("You can draw a card");
            System.out.println("You got a new card: "+deck.cards.get(0));
            drawCard(userHand, deck);
            System.out.println("************************************************************");
            System.out.println("The cards in your hands are: ");
            userHand.sort();
            userHand.showCards();
            System.out.println("\n");
            
            // if computer has the cards, will pass the cards to user 
        } else {
            System.out.println("you are lucky! computer has the cards you asked for");
            //System.out.printf("there are %d card in the match array before inserting", index.size());
            for(int i : index) {
                userHand.insertCard(cpHand.cards.get(i));
            }
            //System.out.printf("there are %d card in the match array after inserting", index.size());
            
            for(int i=index.size()-1; i>=0; i--) {
                cpHand.deleteCard(cpHand.cards.get(index.get(i)));
            }
            System.out.println("************************************************************");
            System.out.println("now your cards in hand are: ");
            userHand.sort();
            userHand.showCards();
            //System.out.println("\n cp cards are: ");
            //cpHand.showCards();
            System.out.println("************************************************************");
            System.out.println("\n");
            displayBooks();

        }
        
        //after either draw a card or get the cards from computer, match books 
        userBooks = matchBook(userHand, books);
        if(userBooks>0) {
            System.out.println("************************************************************");
            System.out.println("Congratulations! you got a book!");
            System.out.println("The number of books user have so far: " +userBooks);
            System.out.println("************************************************************");
            System.out.println("The books displayed are : ");
            displayBooks();
        } else {
            System.out.println("sorry, you didn't get new books.");
        }
    }
//    
    public void cpTurn(GroupOfCards userHand, GroupOfCards cpHand, GroupOfCards deck) {
         
        String req_value;
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.clear();
        //CP intelligence to decide the card value
        int max=0;
        for(int i=0; i<cpHand.cards.size();i++) {
            if (Collections.frequency(cpHand.cards, cpHand.cards.get(i).getValue()) > max) {
                max =i;
        }
        }
        
        req_value =  cpHand.cards.get(max).getValue().name();
                
        System.out.println("Hi user, computer is asking if you have the cards of this value "+ req_value);

        //check if the USER has the cards that the CP asks for
       index = matchCards(req_value, userHand, index);
       //if user doesn't have the card, computer can draw a card 
        if(index.isEmpty()) {
            //System.out.println("user doesn't have the card you asked for.");
            //System.out.println("You can draw a card");
            drawCard(cpHand,deck);
            //System.out.println("CP, The cards in your hands are: ");
            cpHand.sort();
            //cpHand.showCards();
            System.out.println("\n");

        } else {
            //if the user has the cards computer asks for, pass to computer
            System.out.println("you are lucky! user has the cards you asked for");
            //System.out.printf("there are %d card in the match array before inserting", index.size());
            for(int i : index) {
                cpHand.insertCard(userHand.cards.get(i));
            }
           // System.out.printf("there are %d card in the match array before inserting", index.size());
            for(int i=index.size()-1; i>=0; i--) {
                userHand.deleteCard(userHand.cards.get(index.get(i)));
            }
            System.out.println("************************************************************");
            System.out.println("The cards user have are: ");
            userHand.showCards();
        }
        cpBooks = matchBook(cpHand, books);
        if(cpBooks>0) {
            System.out.println("Congratulations! computer got a book");
            System.out.println("************************************************************");
           System.out.println("The number of books computer have so far: " +cpBooks);
           displayBooks();
            System.out.println("\n");
       }
        
    }
      

    public void drawCard(GroupOfCards cardsInHand, GroupOfCards deck) {
        if(!(deck.cards.isEmpty())) {
        cardsInHand.insertCard(deck.cards.get(0));
        deck.deleteCard(deck.cards.get(0));
        } else {
            System.out.println("deck runs out card, game is over");
        }
    
    }
//
    public static ArrayList<Integer> matchCards(String req_value, GroupOfCards cardsInHand, ArrayList<Integer> matchIndex) {
        int i=0; 

        for(i=0; i<cardsInHand.getSize();i++) {
            if(req_value.equals(cardsInHand.cards.get(i).getValue().name())){
                System.out.println("yes, match" + cardsInHand.cards.get(i).getValue());
                matchIndex.add(i);
            }
        }
        return matchIndex;
    }

//    
    // will check the cards in hand to see if any book forms. if so, will return the number of books 
    //and save the book as string to the arraylist books. 
        public static int matchBook(GroupOfCards cardsInHand, ArrayList<String> books) {
        int count=0;
        ArrayList<String> cardValue = new ArrayList<String>();
        for(int i=0; i<cardsInHand.cards.size();i++) {
            cardValue.add(cardsInHand.cards.get(i).getValue().toString());
        }
       
        for(int i=0; i<cardsInHand.cards.size();i++) {
            String value=cardsInHand.cards.get(i).getValue().toString();
            int num = Collections.frequency(cardValue, value);
            if(num==4) {
                if((!books.contains(value))) {
                    books.add(value);
                    count++;
            }
        }
        }
        

        return count;
        
    }
//
    public void displayBooks() {
        if(!(books.isEmpty())){
        for(String s: books) {
            System.out.println(s +" ");
        }
        }
    }
//
//
//
    @Override
    public boolean declareWinner() {
        boolean result;
        if (userBooks > cpBooks) {
         System.out.println("USER You won!"); 
         result = true;
        } else {
         System.out.println("USER You lost!");
         result = false;
        }
        
        return result;
    }
}
//
//}
