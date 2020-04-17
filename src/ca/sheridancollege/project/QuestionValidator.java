package ca.sheridancollege.project;

import static ca.sheridancollege.project.PlayGoFish.matchCards;
import java.util.ArrayList;


public class QuestionValidator {
    private String req_value;
    private GroupOfCards cardsInHand;

    

    public QuestionValidator(String req_value, GroupOfCards cardsInHand) {
        this.req_value = req_value;
        this.cardsInHand = cardsInHand;
    }

/**
 * 
     * @param req_value
 * @param cardsInHand
     * @return 
 */
public boolean verification() {
    boolean flag = true;
    int count=0;
    for(int i=0; i<cardsInHand.getSize();i++) {
         if (req_value.equals(cardsInHand.cards.get(i).getValue().name())) {
             count++;
           }
    }

    if(count>0) {
             flag =true;
         } else {
            flag = false;
        }
            
    
    return flag;
	
}


}