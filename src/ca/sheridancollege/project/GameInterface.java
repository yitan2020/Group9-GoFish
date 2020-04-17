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
            boolean flag = true;
            Menu(flag, user1);
        }
        
     
            


        

    }
    
    public static void Menu(boolean flag, UserPlayer user1) {
        // interact with user to start the game or leave the game
            do{
                System.out.println("Press Y to start the game or N to end the game");
                Scanner input = new Scanner (System.in);
                String str = input.nextLine();
                switch (str) {
                        case "Y": 
                            if(user1.play()) {
                                user1.setNumOfWin(1);
                            } else {
                                user1.setNumOfLos(1);
                            }
                            user1.displayResult();
                            break;
                        case "N": 
                            System.out.println("see you next time!");
                            flag=false;
                            break;
                        default:
                            System.out.println("input is invalid. please re-enter");
                            break;
                }    
            } while(flag);
    }


       
}
        
   
      

