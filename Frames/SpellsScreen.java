/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Frames;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author straf
 */
public class SpellsScreen extends javax.swing.JInternalFrame {

    public DefaultListModel<String> spellListModel;

    /**
     * Creates new form SpellsScreen
     */
    public SpellsScreen() throws IOException, FileNotFoundException, ParseException {
        
        initComponents();
        /// Parse the JSON file
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new org.json.JSONObject(new JSONTokener(new FileReader("src\\main\\Java\\InternalData\\spells.json")));


        // Get the array of spells
        JSONArray spellsArray = (JSONArray) jsonObject.get("results");

        // Create a default list model to hold the spell names
        DefaultListModel<String> spellModel = new DefaultListModel<>();

        // Loop through the array of spells and add each name to the list model
        for (Object spellObj : spellsArray) {
            JSONObject spellJson = (JSONObject) spellObj;
            String spellName = (String) spellJson.get("name");
            spellModel.addElement(spellName);
        }
        spellList.setModel(spellModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        spellList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        spellDisplay = new javax.swing.JTextPane();

        jScrollPane2.setViewportView(jEditorPane1);

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        spellList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        spellList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                spellListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(spellList);

        spellDisplay.setContentType("text/html"); // NOI18N
        jScrollPane3.setViewportView(spellDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spellListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_spellListValueChanged
       String selectedSpell = spellList.getSelectedValue();
       System.out.println(selectedSpell);
    if (selectedSpell != null) {
        selectedSpell = selectedSpell.replaceAll(" ", "-").toLowerCase();
        String apiUrl = "https://www.dnd5eapi.co/api/spells/" + selectedSpell;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            String resultString = result.toString();

// Parse the JSON string to a JsonObject
JsonParser parser = new JsonParser();
JsonObject spellJson = parser.parse(resultString).getAsJsonObject();

StringBuilder formattedResult = new StringBuilder();

// Extract the spell information
String name = spellJson.get("name").getAsString();
String desc = spellJson.get("desc").getAsJsonArray().toString();
String range = spellJson.get("range").getAsString();
String components = spellJson.get("components").getAsJsonArray().toString();
String duration = spellJson.get("duration").getAsString();
String castingTime = spellJson.get("casting_time").getAsString();
int level = spellJson.get("level").getAsInt();
// Build the formatted text
// Format the spell information with labels
formattedResult.append("<html>");
formattedResult.append("<b>Name:</b> ").append(name).append("<br>");
formattedResult.append("<b>Description:</b> ").append(desc).append("<br>");
formattedResult.append("<b>Range:</b> ").append(range).append("<br>");
formattedResult.append("<b>Components:</b> ").append(components).append("<br>");
formattedResult.append("<b>Duration:</b> ").append(duration).append("<br>");
formattedResult.append("<b>Casting Time:</b> ").append(castingTime).append("<br>");
formattedResult.append("<b>Level:</b> ").append(level).append("<br>");
formattedResult.append("</html>");

// Set the text of the spellDisplay JTextPane
spellDisplay.setText(formattedResult.toString());

    
            System.out.println("Spell found!");

            // Create the formatted text
            

            // Set the text of the spellDisplay JTextPane
            
            System.out.println("Displayed");

        } catch (IOException | JSONException e) {
            // Handle any exceptions
        }
    }
    }//GEN-LAST:event_spellListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane spellDisplay;
    private javax.swing.JList<String> spellList;
    // End of variables declaration//GEN-END:variables

}