package PExercices.PExercice1.PEtudiant;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")    // suppress warnings about fucking everything
public class Etudiant {
    public final String nom;
    public final String prenom;
    public Map<String, Double[]> notes;

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new HashMap<String,Double[]>();
    }

    public void afficherNote() {
        System.out.println(nom.toUpperCase() + " " + prenom);

        // iterate in notes with key and value
        for (Map.Entry<String, Double[]> entry : notes.entrySet()) {
            System.out.print(entry.getKey() + " : ");

            for (int i = 0; i < entry.getValue().length; i++) {
                System.out.print(entry.getValue()[i] + " | ");
            }

            System.out.println("");
        }
    }

    public void afficherNote(String matiere) {
        System.out.println(nom.toUpperCase() + " " + prenom);

        Double[] notesMatiere = notes.get(matiere);
        if (notesMatiere == null) {
            System.out.println("Matière inconnue");
            return;
        }

        System.out.print(matiere + " : ");
        for (int i = 0; i < notesMatiere.length; i++) {
            System.out.print(notesMatiere[i] + " | ");
        }
    }

    public double moyenne(String matiere) {
        Double[] notesMatiere = notes.get(matiere);

        if (notesMatiere == null) {
            System.out.println("Matière inconnue");
            return -1;
        }

        double sum = 0;
        for (Double note : notesMatiere) {
            sum += note;
        }
        return sum / notesMatiere.length;
    }

    public void setNote(String matiere, Double note) {
        // push note to notes.get(matiere)
        Double[] notesMatiere = notes.get(matiere);
        Double[] newNotesMatiere = null;
        if (notesMatiere != null) {
            newNotesMatiere = new Double[notesMatiere.length + 1];
            for (int i = 0; i < notesMatiere.length; i++) {
                newNotesMatiere[i] = notesMatiere[i];
            }
            newNotesMatiere[notesMatiere.length] = note;
        } else {
            newNotesMatiere = new Double[1];
            newNotesMatiere[0] = note;
        }

        notes.put(matiere, newNotesMatiere);
    }

    public void setNote(String matiere, int index, Double note) {
        // set note at index in notes.get(matiere)
        Double[] notesMatiere = notes.get(matiere);
        notesMatiere[index] = note;
        notes.put(matiere, notesMatiere);
    }

    public void setNote(String matiere, Double[] note) {
        Double[] notesMatiere = notes.get(matiere);
        Double[] newNotesMatiere = null;

        if (notesMatiere != null) {
            newNotesMatiere = new Double[notesMatiere.length + note.length];

            for (int i = 0; i < notesMatiere.length; i++) {
                newNotesMatiere[i] = notesMatiere[i];
            }

            for (int i = notesMatiere.length; i < notesMatiere.length + note.length; i++) {
                newNotesMatiere[i] = note[i - notesMatiere.length];
            }

        } else {
            newNotesMatiere = new Double[note.length];
            for (int i = 0; i < note.length; i++) {
                newNotesMatiere[i] = note[i];
            }
        }

        notes.put(matiere, newNotesMatiere);
    }
}
