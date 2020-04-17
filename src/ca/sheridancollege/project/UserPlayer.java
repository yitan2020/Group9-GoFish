package ca.sheridancollege.project;

public class UserPlayer extends Player {

    private int numOfWin;
    private int numOfLos;

    public UserPlayer(int numOfWin, int numOfLos, String playerID) {
        super(playerID);
        this.numOfWin = numOfWin;
        this.numOfLos = numOfLos;
    }
    
    
    public int getNumOfWin() {
        return numOfWin;
    }

    public void setNumOfWin(int numOfWin) {
        this.numOfWin += numOfWin;
    }

    public int getNumOfLos() {
        return numOfLos;
    }

    public void setNumOfLos(int numOfLos) {
        this.numOfLos += numOfLos;
    }
    
    public UserPlayer (String name, int numOfWin, int numOfLos) {
        super(name);
        this.numOfWin = numOfWin;
        this.numOfLos = numOfLos;        
    }
    


    public void storeWinResult() {
        this.numOfWin += 1;   
     }
    
    public void storeLosResult() {
        this.numOfLos += 1;   
     }
    
    public void displayResult() {
        String format ="%s has won %d games and lost %d games so far!";
        System.out.println(String.format(format, getPlayerID(),this.numOfWin, this.numOfLos));
    }

    @Override
    public boolean play() {
       PlayGoFish game = new PlayGoFish();
       return game.play();
    }

}