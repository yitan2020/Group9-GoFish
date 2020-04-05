/*
Yi Tan <tan5@sheridan.desire2learn.com>
----------------------------------------------------------------------
 */
package ca.sheridancollege.project;

/**
 *
 * @author Yi Tan <tan5@sheridan.desire2learn.com>
 */
public class GoFishCards extends Card implements Comparable<GoFishCards> {
    private CardValue value;
    private CardSuit suit;
    
    public GoFishCards() {
        super();
    }
    
    public GoFishCards(CardValue value, CardSuit suit) {
        super();
        this.value = value;
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }
    
    @Override
    public String toString() {
        return this.value + " " +this.suit;
    }

    @Override
    public int compareTo(GoFishCards o) {
        return this.getValue().compareTo(o.getValue());
    }
    
    
    
    
}
