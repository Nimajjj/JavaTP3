package PExercices.PExercice3.PCarteYuGiHO;

import PExercices.PExercice3.PYuGiHOAPI.YuGiHOAPI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CarteMonstre extends AMonstre {
    // make a card from raw data
    public CarteMonstre(String nom, String attribut, String type, String numero, String description, int niveau, int atk, int def) {
        super(nom, attribut, type, numero, description, niveau, atk, def);
    }

    // make a card from a json object (from api)
    public CarteMonstre(JSONObject obj) {
        super(
            (String) obj.get("name"),
            (String) obj.get("attribute"),
            (String) obj.get("type"),
            String.valueOf(obj.get("id")),
            (String) obj.get("desc"),
            Integer.parseInt(String.valueOf(obj.get("level"))),
            Integer.parseInt(String.valueOf(obj.get("atk"))),
            Integer.parseInt(String.valueOf(obj.get("def")))
        );
    }

    public static CarteMonstre GetFromAPI(String name) {    // TODO : move to frabric
        JSONArray result = YuGiHOAPI.call(
                new String[][] {
                        {"name", name}
                }
        );

        if (result == null) {
            System.out.println("Card \"" + name + "\" does not exist.");
            return null;
        }
        return new CarteMonstre((JSONObject) result.get(0));
    }

    public static CarteMonstre GetFromAPI(int id) {     // TODO : move to frabric
        JSONArray result = YuGiHOAPI.call(
                new String[][] {
                        {"id", Integer.toString(id)}
                }
        );

        if (result == null) {
            System.out.println("Card with id: " + id + " does not exist.");
            return null;
        }
        return new CarteMonstre((JSONObject) result.get(0));
    }
}
