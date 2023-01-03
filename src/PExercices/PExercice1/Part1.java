package PExercices.PExercice1;

import PExercices.PExercice1.PEtudiant.Etudiant;

public class Part1 {
    public static void Run() {
        System.out.println("\nPart 1 ----------");

        Etudiant etudiant = new Etudiant("Borello", "Benjamin");

        etudiant.setNote("Réseau", 4.0);
        etudiant.setNote("Réseau", 3.25);
        etudiant.setNote("Réseau", 8.5);
        etudiant.setNote("Réseau", 10.0);

        etudiant.setNote("POO", 20.0);
        etudiant.setNote("POO", 19.5);
        etudiant.setNote("POO", 18.0);
        etudiant.setNote("POO", 20.0);

        etudiant.setNote("Java", 20.0);
        etudiant.setNote("Java", 15.5);
        etudiant.setNote("Java", 17.75);
        etudiant.setNote("Java", 19.75);

        etudiant.afficherNote("Java");
        etudiant.afficherNote();

        System.out.println("Moyenne en POO: " + etudiant.moyenne("POO"));
        etudiant.setNote("POO", 2, 20.0);
        System.out.println("Moyenne en POO: " + etudiant.moyenne("POO"));
    }
}
