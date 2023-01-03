package PExercices.PExercice3.PCarteYuGiHO;

import PExercices.PExercice3.PYuGiHOAPI.YuGiHOAPI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CartePiegeEtMagie extends APiegeEtMagie{
    // make a card from raw data
    public CartePiegeEtMagie(String nom, String type, String icone, String description, String numero) {
        super(nom, type, icone, description, numero);
    }

    // make a card from a json object (from api)
    public CartePiegeEtMagie(JSONObject obj) throws IllegalArgumentException {
        super(
                (String) obj.get("name"),
                (String) obj.get("type"),
                (String) obj.get("race"),
                (String) obj.get("desc"),
                String.valueOf(obj.get("id"))
        );

        if (!type.equals("Spell Card") && !type.equals("Trap Card")) {
            throw new IllegalArgumentException("Type must be Spell Card or Trap Card");
        }
    }

    public String getId() {
        return numero;
    }

    public String getName() {
        return nom;
    }

    public static CartePiegeEtMagie GetFromAPI(String name) throws Exception {    // TODO : move to frabric
        JSONArray result = YuGiHOAPI.call(
                new String[][] {
                        {"name", name}
                }
        );

        if (result == null) {
            throw new Exception("Card \"" + name + "\" does not exist.");
        }

        CartePiegeEtMagie carte = new CartePiegeEtMagie((JSONObject) result.get(0));

        if (!carte.type.equals("Spell Card") && !carte.type.equals("Trap Card")) {
            throw new Exception("Card's type is not Spell Card or Trap Card : " + carte.type);
        }

        return carte;
    }

    public static CartePiegeEtMagie GetFromAPI(int id) throws Exception {    // TODO : move to frabric
        JSONArray result = YuGiHOAPI.call(
                new String[][] {
                        {"id", Integer.toString(id)}
                }
        );

        if (result == null) {
            throw new Exception("Card with id: " + id + " does not exist.");
        }

        CartePiegeEtMagie carte = new CartePiegeEtMagie((JSONObject) result.get(0));

        if (!carte.type.equals("Spell Card") && !carte.type.equals("Trap Card")) {
            throw new Exception("Card's type is not Spell Card or Trap Card : " + carte.type);
        }

        return carte;
    }
}
