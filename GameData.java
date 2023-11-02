import java.util.ArrayList;
import java.util.List;

public class GameData {

    private  Character lastPlayedCharacter;
    private int highScore;
    private int lastPlayedLevel;
    private List<Item> inventory = new ArrayList<Item>();



    public GameData(Character lastPlayedCharacter, int highScore, int lastPlayedLevel) {
        this.lastPlayedCharacter = lastPlayedCharacter;
        this.highScore = highScore;
        this.lastPlayedLevel = lastPlayedLevel;

    }

    public void setLastPlayedCharacter(Character hero)
    {
        this.lastPlayedCharacter = hero;
    }

    public Character getLastPlayedCharacter()
    {
        return lastPlayedCharacter;
    }

    public void setHighScore(int highScore)
    {
        this.highScore = highScore;
    }
    public int getHighScore()
    {
        return highScore;
    }

    public void setLastPlayedLevel(int lastPlayedLevel)
    {
        this.lastPlayedLevel = lastPlayedLevel;
    }
    public int getLastPlayedLevel()
    {
        return lastPlayedLevel;
    }

    public void setInventory(Character hero)
    {
        this.inventory = (List<Item>) hero.displayItem();
    }

    public Item getInventory(){

       return lastPlayedCharacter.displayItem();
    }


}
