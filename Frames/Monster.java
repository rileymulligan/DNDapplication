package Frames;


import com.google.gson.annotations.SerializedName;

public class Monster {
     @SerializedName("name")
    private String name;
    @SerializedName("meta")
    private String meta;
    @SerializedName("Armor Class")
    private String armorClass; // changed field name
    @SerializedName("Hit Points")
    private String hitPoints; // changed field name
    @SerializedName("Speed")
    private String speed;
    @SerializedName("STR")
    private String str;
    @SerializedName("STR_mod")
    private String strMod;
    @SerializedName("DEX")
    private String dex;
    @SerializedName("DEX_mod")
    private String dexMod;
    @SerializedName("CON")
    private String con;
    @SerializedName("CON_mod")
    private String conMod;
    @SerializedName("INT")
    private String intStat;
    @SerializedName("INT_mod")
    private String intMod;
    @SerializedName("WIS")
    private String wis;
    @SerializedName("WIS_mod")
    private String wisMod;
    @SerializedName("CHA")
    private String cha;
    @SerializedName("CHA_mod")
    private String chaMod;
    @SerializedName("Saving Throws")
    private String savingThrows;
    @SerializedName("Skills")
    private String skills;
    @SerializedName("Damage Immunities")
    private String damageImmunities;
    @SerializedName("Condition Immunities")
    private String conditionImmunities;
    @SerializedName("Senses")
    private String senses;
    @SerializedName("Languages")
    private String languages;
    @SerializedName("Challenge")
    private String challenge;
    @SerializedName("Traits")
    private String traits;
    @SerializedName("Actions")
    private String actions;
    @SerializedName("img_url")
    private String imageUrl;
    
     // getters
    public String getName() {
        return name;
    }

    public String getMeta() {
        return meta;
    }

    public String getArmorClass() {
        return armorClass;
    }

    public String getHitPoints() {
        return hitPoints;
    }

    public String getSpeed() {
        return speed;
    }

    public String getStr() {
        return str;
    }

    public String getStrMod() {
        return strMod;
    }

    public String getDex() {
        return dex;
    }

    public String getDexMod() {
        return dexMod;
    }

    public String getCon() {
        return con;
    }

    public String getConMod() {
        return conMod;
    }

    public String getIntStat() {
        return intStat;
    }

    public String getIntMod() {
        return intMod;
    }

    public String getWis() {
        return wis;
    }

    public String getWisMod() {
        return wisMod;
    }

    public String getCha() {
        return cha;
    }

    public String getChaMod() {
        return chaMod;
    }

    public String getSavingThrows() {
        return savingThrows;
    }

    public String getSkills() {
        return skills;
    }

    public String getDamageImmunities() {
        return damageImmunities;
    }

    public String getConditionImmunities() {
        return conditionImmunities;
    }

    public String getSenses() {
        return senses;
    }

    public String getLanguages() {
        return languages;
    }

    public String getChallenge() {
        return challenge;
    }

    public String getTraits() {
        return removeHtmlTags(traits);
    }

    public String getActions() {
        return removeHtmlTags(actions);
    }

    public String getImageUrl() {
        return imageUrl;
    }
    
    public double getChallengeValue() {
    String challengeString = this.getChallenge();
    int challengeIndex = challengeString.indexOf("(");
    if (challengeIndex != -1) {
        challengeString = challengeString.substring(0, challengeIndex).trim();
    }
    if (challengeString.contains("/")) {
        String[] fraction = challengeString.split("/");
        double numerator = Double.parseDouble(fraction[0]);
        double denominator = Double.parseDouble(fraction[1]);
        return numerator / denominator;
    } else {
        return Double.parseDouble(challengeString);
    }
}
    
    public String removeHtmlTags(String text) {
        //text = text.replace("<em>", "");
       // text = text.replace("<strong>", "");
       // text = text.replace("<p>", "");
       // text = text.replace("</p>", "");
       // text = text.replace("</strong>", "");
       // text = text.replace("</em>", "");
        return text;
    }

  
    
    
}

