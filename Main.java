import java.io.FileReader;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
            // Create a Gson object
            
            
            // Read the JSON file into a List of Monsters using Gson
            Gson gson = new Gson();
            Monster[] monsters = gson.fromJson(new FileReader("C:\\Users\\straf\\Desktop\\MonsterData\\monsters.json"), Monster[].class);
            List<Monster> monsterList = Arrays.asList(monsters);
            
            // Print out the Monsters
           for (Monster monster : monsterList) {
            System.out.println("Monster Name: " + monster.getName());
            System.out.println("Monster Meta: " + monster.getMeta());
            System.out.println("AC: " + monster.getArmorClass());
            System.out.println("HP: " + monster.getHitPoints());
            System.out.println();
        }
    }
}
