package PExercices.PExercice1.PClasse;

import PExercices.PExercice1.PEtudiant.Etudiant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Classe {
    private Etudiant[] etudiants;


    public Classe() {
        etudiants = new Etudiant[0];
    }

    public Etudiant getEtudiant(String nom, String prenom) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.nom.equals(nom) && etudiant.prenom.equals(prenom)) {
                return etudiant;
            }
        }
        return null;
    }

    public Double moyenneClasse(String matiere) {
        double sum = 0;
        for (Etudiant etudiant : etudiants) {
            double note = etudiant.moyenne(matiere);
            if (note == -1) {
                return -1.0;
            }
            sum += note;
        }
        return sum / etudiants.length;
    }

    public void setEtudiant(Etudiant etudiant) {
        Etudiant[] newEtudiants = new Etudiant[etudiants.length + 1];
        System.arraycopy(etudiants, 0, newEtudiants, 0, etudiants.length);
        newEtudiants[etudiants.length] = etudiant;
        etudiants = newEtudiants;
    }

    public void initFromFile(String path) { // I hate my life
        JSONParser parser = new JSONParser();
        try {
            System.out.println("Reading file " + path);

            Object obj = parser.parse(new FileReader(path));

            JSONObject jsonObject = (JSONObject)obj;

            JSONArray etudiants = (JSONArray)jsonObject.get("etudiants");

            for (Object o : etudiants) {
                JSONObject etudiant = (JSONObject) o;

                Etudiant e = new Etudiant((String) etudiant.get("nom"), (String) etudiant.get("prenom"));

                for (Object matiere : etudiant.keySet()) {
                    if (matiere.equals("nom") || matiere.equals("prenom")) {
                        continue;
                    }

                    JSONObject notes = (JSONObject) etudiant.get(matiere);
                    for (Object note : notes.keySet()) {
                        JSONArray notesArray = (JSONArray) notes.get(note);
                        for (Object value : notesArray) {
                            e.setNote(note.toString(), (Double) value);
                        }
                    }
                }

                setEtudiant(e);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    public String convertWithStream(Map<String, Double[]> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + "=" + Arrays.toString(map.get(key)) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }

    public void saveToFile(String path) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonEtudiants = new JSONArray();

        for (Etudiant etudiant : etudiants) {
            JSONObject jsonEtudiant = new JSONObject();

            jsonEtudiant.put("nom", etudiant.nom);
            jsonEtudiant.put("prenom", etudiant.prenom);
            jsonEtudiant.put("notes", convertWithStream(etudiant.notes).replace("=", ":"));

            jsonEtudiants.add(jsonEtudiant);
        }

        jsonObject.put("etudiants", jsonEtudiants);

        try {
            System.out.println("Saving current classe to : " + path);

            FileWriter file = new FileWriter(path);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
