package controllers;

public class GameController {
    private boolean isRunning;

    public GameController(){
        //construtor vazio
    }

    public void startNewGame(){
        setIsRunning(true);
        while (isRunning == true) {
            //TODO fazer a lógica de inicialização
        }
    }

    public boolean getIsRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
}