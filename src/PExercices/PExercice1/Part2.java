package PExercices.PExercice1;

import PClasse.Classe;
import PEtudiant.Etudiant;

public class Part2 {
    public static void Run() {
        System.out.println("\nPart 2 ----------");

        Classe classe = new Classe();
        classe.initFromFile("ressource/input.json");

        classe.getEtudiant("Mederreg", "Kheir-Edinne").afficherNote();
        classe.getEtudiant("Jeham", "Laurie").afficherNote();

        Etudiant sam = new Etudiant("Sam", "Conraux");
        sam.setNote("maths", new Double[]{10.0, 12.0, 14.0});
        sam.setNote("francais", new Double[]{10.0, 12.0, 14.0});
        sam.setNote("anglais", new Double[]{10.0, 14.0});

        classe.setEtudiant(sam);

        classe.saveToFile("ressource/output.json");
    }
}
