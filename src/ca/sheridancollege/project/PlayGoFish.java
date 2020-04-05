package ca.sheridancollege.project;

import java.util.Collections;
import java.util.Scanner;

public abstract class PlayGoFish extends Game {

    private GroupOfCards userHand;
    private GroupOfCards cpHand;
    private GroupOfCards deck;
    private int userBooks=0, cpBooks=0;

    public PlayGoFish(GroupOfCards userHand, GroupOfCards cpHand, GroupOfCards deck, int userBooks, int cpBooks) {
        super();
        this.userHand = userHand;
        this.cpHand = cpHand;
        this.deck = deck;
        this.userBooks = userBooks;
        this.cpBooks = cpBooks;
    }

    public GroupOfCards getUserHand() {
        return userHand;
    }

    public void setUserHand(GroupOfCards userHand) {
        this.userHand = userHand;
    }

    public GroupOfCards getCpHand() {
        return cpHand;
    }

    public void setCpHand(GroupOfCards cpHand) {
        this.cpHand = cpHand;
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }

    public int getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(int userBooks) {
        this.userBooks = userBooks;
    }

    public int getCpBooks() {
        return cpBooks;
    }

    public void setCpBooks(int cpBooks) {
        this.cpBooks = cpBooks;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void play() {
        deck.generateFullCardHand();
        deck.shuffle();
        //players get the inital cards 
        userHand.cards = deck.distributeInitialCards(7);
        cpHand.cards = deck.distributeInitialCards(7);
        
        System.out.println("Hi, your initial cards are: \n");
        userHand.showCards();
        
        userTurn();
        
       
            
            
        
    }
    
    public void userTurn() {
         boolean flag = true;
        String req_value;
        do {
            System.out.println("Please ask computer a value of the card(using capital words): ");
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
        if(matchCards(req_value, cpHand)[0] ==0) {
            System.out.println("Computer doesn't have the card you asked for. It's computer's turn to ask you question");
            userDrawCard();
        } else {
            System.out.println("you are lucky! computer has the cards you asked for");
            for(int i : matchCards(req_value, cpHand)) {
                userHand.insertCard(cpHand.cards.get(i));
                cpHand.deleteCard(cpHand.cards.get(i));
            }
        }
    }
    
    public void cpTurn() {
         boolean flag = true;
        String req_value;
        
        int max=0;
        for(int i=0; i<cpHand.cards.size();i++) {
            if (Collections.frequency(cpHand.cards, cpHand.cards.get(i).getValue()) > max) {
                max =i;
        }
        }
        
        req_value =  cpHand.cards.get(max).getValue().toString();
                
        System.out.println("Hi user, computer is asking if you have the cards of this value "+ req_value);

        //check if the computer has the cards that the user asks for
        if(matchCards(req_value, userHand)[0] ==0) {
            System.out.println("Computer doesn't have the card you asked for. It's computer's turn to ask you question");
            cpDrawCard();
        } else {
            System.out.println("you are lucky! computer has the cards you asked for");
            for(int i : matchCards(req_value, cpHand)) {
                userHand.insertCard(cpHand.cards.get(i));
                cpHand.deleteCard(cpHand.cards.get(i));
            }
        }
    }
        
        

    public void userDrawCard() {
        userHand.insertCard(deck.cards.get(0));
        deck.deleteCard(deck.cards.get(0));
    
    }
    
    public void cpDrawCard() {
        cpHand.insertCard(deck.cards.get(0));
        deck.deleteCard(deck.cards.get(0));
    
    }

    public void replyOpponent() {
        // TODO - implement PlayGoFish.replyOpponent
        throw new UnsupportedOperationException();
    }

    public int[] matchCards(String req_value, GroupOfCards cpHand) {
        int i, j=0; 
        int[] matchIndex = new int[4]; 
        for(i=0; i<cpHand.getSize();i++) {
            if(req_value.equals(cpHand.cards.get(i).getValue().toString())){
                matchIndex[j] =i;
                j++;
            }
        }
        return matchIndex;
    }

    public void matchBook() {
        // TODO - implement PlayGoFish.matchBook
        throw new UnsupportedOperationException();
    }

    public void displayBook() {
        // TODO - implement PlayGoFish.displayBook
        throw new UnsupportedOperationException();
    }

    public void moveCards() {
        // TODO - implement PlayGoFish.moveCards
        throw new UnsupportedOperationException();
    }

    public int askCards() {
        // TODO - implement PlayGoFish.askCards
        throw new UnsupportedOperationException();
    }

    public int countBooks(GroupOfCards ) {
        // TODO - implement PlayGoFish.countBooks
        throw new UnsupportedOperationException();
    }

    @Override
    public void declareWinner() {

    }

}
