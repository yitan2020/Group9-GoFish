/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * Yi Tan
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye
 */
public abstract class Game 
{
    private String gameName;//the title of the game
    private ArrayList <Player> players;/**
	 * the players of the game
	 * @param gameName
	 * @param playerName
	 */
    
    

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
    /**
	 * 
	 * @param ganmeName
	 * @param playerName
	 */
	public void playerLogin(String ganmeName, String playerName) {
		// TODO - implement Game.playerLogin
		throw new UnsupportedOperationException();
	}
    
    public void startGame(String gameName, String playerName)
    {
        this.gameName = gameName;
        players = new ArrayList();
    }
    
    /**
     * Play the game.This might be one method or many method calls depending
 on your game.

     */
    public abstract void play();
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();

	

   
    
}//end class
