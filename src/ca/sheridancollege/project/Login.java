/*
Yi Tan <tan5@sheridan.desire2learn.com>
----------------------------------------------------------------------
 */
package ca.sheridancollege.project;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Yi Tan <tan5@sheridan.desire2learn.com>
 */
public class Login {
    public String login() {
        
        System.out.println("Welcome!");
        String userID=null;

        do {
        System.out.println("Please enter your user ID"); 
        Scanner input = new Scanner(System.in);
        userID = input.nextLine();
        } while(userID.length() >= 5);

        return userID;
    }
    
     public  boolean loginForTesting(String str) {
        
        System.out.println("Welcome!");
        String userID=null;
        Boolean flag=true;
//        do {
//        System.out.println("Please enter your user ID"); 
//        Scanner input = new Scanner(System.in);
//        userID = input.nextLine();
//        } while(userID.length() >= 5);
        if (str.length() >=5) {
            System.out.printf("Hi %s, you have logged in.\n", userID);
            flag =true;
        } else {
            flag = false;
        }
        return flag;
    }
    
}
