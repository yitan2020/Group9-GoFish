package ca.sheridancollege.project;

public class QuestionValidator {
    private String req_value;
    private GroupOfCards cardsInHand; 

    public QuestionValidator(String req_value, GroupOfCards cardsInHand) {
        this.req_value = req_value;
        this.cardsInHand = cardsInHand;
    }

    public String getReq_value() {
        return req_value;
    }

    public void setReq_value(String req_value) {
        this.req_value = req_value;
    }

    public GroupOfCards getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(GroupOfCards cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
    
    
    
    
/**
 * 
     * @param req_value
 * @param cardsInHand
     * @return 
 */
public boolean verification() {
    boolean flag = false;
    for(int i=0; i<this.cardsInHand.getSize();i++) {
        if(this.req_value.equals(this.cardsInHand.cards.get(i).getValue().toString())) {
                    flag =true;
                }
            }
    
    return flag;
	
}


}