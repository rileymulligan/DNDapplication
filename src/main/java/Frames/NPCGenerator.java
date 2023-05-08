package Frames;

import org.json.JSONArray;
import org.json.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NPCGenerator {

    private static final Random random = new Random();
    private static JSONObject npc;

    public static void main(String[] args) throws IOException {
        npc = generateNPC();
        System.out.println(npc);
    }

    public static JSONObject generateNPC() throws IOException {
        JSONObject json = new JSONObject(Files.readString(Paths.get("classes\\InternalData\\npc.json")));        
        String gender = getRandomItem(json.getJSONArray("Genders"));
        String race = getRandomItem(json.getJSONArray("Races"));
        String firstName = getRandomName(json.getJSONArray(getNameListKey(gender, race, "FirstNames")));
        String lastName = getRandomName(json.getJSONArray(getLastNameListKey(race, "LastNames")));
        List<String> physicalTraits = getRandomItems(json.getJSONArray("PhysicalTraits"), 2);
        List<String> mannerisms = getRandomItems(json.getJSONArray("Mannerisms"), 2);
        String demeanor = getRandomItem(json.getJSONArray("Demeanor"));
        String ideal = getRandomItem(json.getJSONArray("Ideals"));
        String bond = getRandomItem(json.getJSONArray("Bonds"));
        String flaw = getRandomItem(json.getJSONArray("Flaws"));
        String randomFact = getRandomItem(json.getJSONArray("RandomFact"));
        String randomLoot = getRandomItem(json.getJSONArray("RandomLoot"));

        JSONObject npc = new JSONObject();
        npc.put("gender", gender);
        npc.put("race", race);
        npc.put("firstName", firstName);
        npc.put("lastName", lastName);
        npc.put("physicalTraits", new JSONArray(physicalTraits));
        npc.put("mannerisms", new JSONArray(mannerisms));
        npc.put("demeanor", demeanor);
        npc.put("ideal", ideal);
        npc.put("bond", bond);
        npc.put("flaw", flaw);
        npc.put("randomFact", randomFact);
        npc.put("randomLoot", randomLoot);

        return npc;
    }
    // getters
    private static String getNameListKey(String gender, String race, String nameType) {
        
        return race + gender + nameType;
    }
    
    private static String getLastNameListKey(String race, String nameType) {
        
        return race + nameType;
    }
    
    private static String getRandomName(JSONArray names) {
        return names.getString(random.nextInt(names.length()));
    }

    private static String getRandomItem(JSONArray array) {
        return array.getString(random.nextInt(array.length()));
    }

    private static List<String> getRandomItems(JSONArray array, int count) {
        List<String> items = new ArrayList<>();
        while (items.size() < count && items.size() < array.length()) {
            String item = array.getString(random.nextInt(array.length()));
            if (!items.contains(item)) {
                items.add(item);
            }
        }
        return items;
    }

    /**
    Returns a formatted string representation of the NPC's information.
    @param npc the JSONObject representing the NPC.
    @return a string with the NPC's name, gender, race, physical traits, mannerisms, demeanor, ideal, bond, flaw,random fact, and keepsake.
    @throws JSONException if the JSONObject does not contain any of the required fields.
    */

    static String display(JSONObject npc) {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(npc.getString("firstName"));
    sb.append(" ").append(npc.getString("lastName")).append("\n");
    sb.append("Gender: ").append(npc.getString("gender")).append("\n");
    sb.append("Race: ").append(npc.getString("race")).append("\n\n");
    
    sb.append("Physical Traits:\n");
    JSONArray physicalTraits = npc.getJSONArray("physicalTraits");
    for (int i = 0; i < physicalTraits.length(); i++) {
        sb.append("- ").append(physicalTraits.getString(i)).append("\n");
    }
    sb.append("\nMannerisms:\n");
    JSONArray mannerisms = npc.getJSONArray("mannerisms");
    for (int i = 0; i < mannerisms.length(); i++) {
        sb.append("- ").append(mannerisms.getString(i)).append("\n");
    }
    sb.append("\nDemeanor: ").append(npc.getString("demeanor")).append("\n");
    sb.append("\nIdeal: ").append(npc.getString("ideal")).append("\n");
    sb.append("\nBond: ").append(npc.getString("bond")).append("\n");
    sb.append("\nFlaw: ").append(npc.getString("flaw")).append("\n");
    sb.append("\nRandom Fact: ").append(npc.getString("randomFact")).append("\n");
    sb.append("\nKeepsake: ").append(npc.getString("randomLoot")).append("\n");
    
    return sb.toString();
}



}


