import org.json.simple.JSONObject;

public class JSONParser {
    
    public JSONObject parseJSON() {
        myObj = new JSONObject("../bdd/bdd.json");
        System.out.println(myObj.toString());
    }
    
    public String getConversation() {
    
    }
}
