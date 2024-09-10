package models;

public class PlayerModel {
    private String name;
    private int sum;
    private boolean isActiveInGame;

    public PlayerModel(){
        //construtor vazio
    }

    public PlayerModel(String name, int sum){
        this.name = name;
        this.sum = sum;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getSum(){
        return sum;
    }

    public void setSum(int sum){
        this.sum = sum;
    }

    public boolean getIsActive(){
        return isActiveInGame;
    }

    public void setIsActive(boolean isActiveInGame){
        this.isActiveInGame = isActiveInGame;
    }
}