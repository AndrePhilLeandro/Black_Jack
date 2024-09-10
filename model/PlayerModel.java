package model;

public class PlayerModel {
    private String name;
    private int sum;
    private boolean isActive;

    public PlayerModel(){
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
        return isActive;
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
}
