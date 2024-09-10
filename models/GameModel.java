package models;

public class GameModel {
    private int numberOfPlayers;
    private int bestScore;
    private String winner;

    public GameModel(){
        //construtor vazio
    }

    public GameModel(int numberOfPlayers){
        setNumberOfPlayers(numberOfPlayers);
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getBestScore(){
        return bestScore;
    }

    public void setBestScore(int bestScore){
        this.bestScore = bestScore;
    }

    public String getWinner(){
        return winner;
    }

    public void setWinner(String winner){
        this.winner = winner;
    }
}