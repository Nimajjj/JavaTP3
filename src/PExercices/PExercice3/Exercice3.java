package PExercices.PExercice3;

import PExercices.PExercice3.PCarteYuGiHO.CarteMonstre;
import PExercices.PExercice3.PCarteYuGiHO.CartePiegeEtMagie;
import PExercices.PExercice3.PTapisDeJeu.TapisDeJeu;


public class Exercice3 {
    public static void Run() {
        System.out.println("\n\nExercice 3 --------------------");

        CarteMonstre c1 = CarteMonstre.GetFromAPI("Blue-Eyes White Dragon");
        assert c1 != null;
        c1.afficher();

        try {
            CartePiegeEtMagie c2 = CartePiegeEtMagie.GetFromAPI(34541863);
            c2.afficher();
        } catch (Exception e) {
            System.out.println("/!\\ Error : " + e.getMessage() + "\n");
        }

        try {
            CartePiegeEtMagie c3 = CartePiegeEtMagie.GetFromAPI(68170903);
            c3.afficher();
        } catch (Exception e) {
            System.out.println("/!\\ Error : " + e.getMessage() + "\n");
        }

        TapisDeJeu tapis = new TapisDeJeu();
        tapis.zoneDeck.addCard(c1);
        tapis.zoneDeck.addCard(c1);
        tapis.zoneDeck.addCard(c1);

        tapis.afficherZone(TapisDeJeu.Zone.MAIN);

        tapis.afficherCarte(TapisDeJeu.Zone.MAIN, 0);

    }
}
