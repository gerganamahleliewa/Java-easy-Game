import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;

public class DataManger {

    private String filepath;
    private GameData gameData;

    public DataManger(String filepath)
    {
        this.filepath = filepath;
    }

    public void setGameData(GameData newGameData)
    {
        this.gameData = newGameData;
    }

    public GameData getGameData()
    {
        return gameData;
    }
    public void saveGame() {

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath)))
        {
            bufferedWriter.write("Last Played Character: "+gameData.getLastPlayedCharacter().getName());
            bufferedWriter.newLine();
            bufferedWriter.write("High Score: "+gameData.getHighScore());
            bufferedWriter.newLine();
            bufferedWriter.write("Last Played Level: "+gameData.getLastPlayedLevel());
            bufferedWriter.newLine();
            bufferedWriter.write("Inventory: "+gameData.getInventory());

            System.out.println("Game data is save successfully");
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public String loadGame()
    {
        String st = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath)))
        {
            while((st = bufferedReader.readLine()) != null)
            {
                System.out.println(st);
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return st;
    }


}
