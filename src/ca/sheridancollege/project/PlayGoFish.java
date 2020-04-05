package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class PlayGoFish extends Game {

    private GroupOfCards userHand;
    private GroupOfCards cpHand;
    private GroupOfCards deck;
    private ArrayList<String> books;    
    private int userBooks=0, cpBooks=0;

    public PlayGoFish(GroupOfCards userHand, GroupOfCards cpHand, GroupOfCards deck, ArrayList<String> books, int userBooks, int cpBooks) {
        super();
        this.userHand = userHand;
        this.cpHand = cpHand;
        this.deck = deck;
        this.books = books;
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

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
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
        userBooks += matchBook(userHand);
        cpHand.cards = deck.distributeInitialCards(7);
        userBooks += matchBook(userHand);
        
        System.out.println("Hi, your initial cards are: \n");
        userHand.showCards();
        
        do {
        userTurn();
        
        if(matchBook(userHand)>0) {
            System.out.println("Congratulations! you got a book!");
            userBooks += matchBook(userHand);
        } else {
            System.out.println("sorry, you didn't get new books.");
        }
        System.out.println("The books have been displayed so far: ");
        displayBooks();
        
        cpTurn();
        
        if(matchBook(userHand)>0) {
            System.out.println("Congratulations! computer got a book");
            userBooks += matchBook(cpHand);
        }
        System.out.println("The books have been displayed so far: ");
        displayBooks();
        
        } while (!deck.cards.isEmpty() && !cpHand.cards.isEmpty() && !userHand.cards.isEmpty());
        
        
       declareWinner();
            
            
        
    }
    
    // in userTurn, the user asks the computer a value, and check the validation of the question, 
    // if computer has the cards, user will insert the cards from computer and computer will delete the same cards
    //if computer has no cards, the user will draw a card from the deck. 
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
            drawCard(userHand);
        } else {
            System.out.println("you are lucky! computer has the cards you asked for");
            for(int i : matchCards(req_value, cpHand)) {
                userHand.insertCard(cpHand.cards.get(i));
                cpHand.deleteCard(cpHand.cards.get(i));
            }
        }
    }
    
    public void cpTurn() {
         
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
            drawCard(cpHand);
        } else {
            System.out.println("you are lucky! computer has the cards you asked for");
            for(int i : matchCards(req_value, cpHand)) {
                userHand.insertCard(cpHand.cards.get(i));
                cpHand.deleteCard(cpHand.cards.get(i));
            }
        }
    }
        
        

    public void drawCard(GroupOfCards cardsInHand) {
        cardsInHand.insertCard(deck.cards.get(0));
        deck.deleteCard(deck.cards.get(0));
    
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
    
    // will check the cards in hand to see if any book forms. if so, will return the number of books 
    //and save the book as string to the arraylist books. 
    public int matchBook(GroupOfCards cardsInHand) {
        int count=0;
        for(int i=0; i<cardsInHand.getSize();i++) {
             if (Collections.frequency(cardsInHand.cards,cardsInHand.cards.get(i).getValue()) ==4) {
                books.add(cardsInHand.cards.get(i).getValue().toString());
                 count++;
            }
        }
        return count;
        
    }

    public void displayBooks() {
        for(String s: books) {
            System.out.println(s +" ");
        }
    }



    @Override
    public void declareWinner() {
        if (userBooks > cpBooks) {
         System.out.println("You won!"); 
        } else {
         System.out.println("You lost!");
        }
        
        
    }

}
