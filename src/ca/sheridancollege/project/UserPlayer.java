package ca.sheridancollege.project;

public class UserPlayer extends Player {

    private int numOfWin;
    private int numOfLos;
    
    
    public int getNumOfWin() {
        return numOfWin;
    }

    public void setNumOfWin(int numOfWin) {
        this.numOfWin = numOfWin;
    }

    public int getNumOfLos() {
        return numOfLos;
    }

    public void setNumOfLos(int numOfLos) {
        this.numOfLos = numOfLos;
    }
    
    public UserPlayer (String name, int numOfWin, int numOfLos) {
        super(name);
        this.numOfWin = numOfWin;
        this.numOfLos = numOfLos;        
    }
    
    @Override
    public void play() {
        
    }

    public void storeWinResult() {
        this.numOfWin += 1;   
     }
    
    public void storeLosResult() {
        this.numOfLos += 1;   
     }
    
    public void displayResult() {
        String format ="%s has won %d games and lost %d games so far!";
        System.out.println(String.format(format, this.numOfWin, this.numOfLos));
    }

}