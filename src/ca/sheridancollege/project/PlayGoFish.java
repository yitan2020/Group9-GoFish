package ca.sheridancollege.project;

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
    public void play() {
        deck.generateFullCardHand();
        deck.shuffle();
        //players get the inital cards 
        userHand.cards = deck.distributeInitialCards(7);
        cpHand.cards = deck.distributeInitialCards(7);
        
        
        
        
    }

    public void goFish() {
        // TODO - implement PlayGoFish.goFish
        throw new UnsupportedOperationException();
    }

    public void replyOpponent() {
        // TODO - implement PlayGoFish.replyOpponent
        throw new UnsupportedOperationException();
    }

    public void matchCards() {
        // TODO - implement PlayGoFish.matchCards
        throw new UnsupportedOperationException();
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
