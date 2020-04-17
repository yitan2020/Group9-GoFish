/*
Yi Tan <tan5@sheridan.desire2learn.com>
----------------------------------------------------------------------
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Yi Tan <tan5@sheridan.desire2learn.com>
 */
public class GameInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //user login 
        Login login1 = new Login();
        String userID = login1.login();
        //create a player instance 
        Player player1 = new UserPlayer(0,0,userID);
        
        
        if(player1 instanceof UserPlayer) {
            UserPlayer user1 = (UserPlayer) player1;
            if(user1.play()) {
                user1.setNumOfWin(1);
            } else {
                user1.setNumOfLos(1);
            }
            
           user1.displayResult();
        }
        
     
            


        

    }


       
}
        
   
      

