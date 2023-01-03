package PExercices.PExercice3.PTapisDeJeu;

import PExercices.PExercice3.PCarteYuGiHO.CarteMonstre;
import PExercices.PExercice3.PCarteYuGiHO.ICarteYuGiHO;
import PExercices.PExercice3.PDeck.Deck;

public class TapisDeJeu {
    public enum Zone {
        MONSTRE,
        PIEGE_ET_MAGIE,
        CIMETIERE,
        MAIN,
        TERRAIN,
        EXTRA,
        PENDULE
    }

    public Deck zoneMonstre;
    public Deck zonePiegeEtMagie;
    public Deck zoneCimetiere;
    public Deck zoneDeck;
    public Deck zoneTerrain;
    public Deck zoneExtraDeck;
    public Deck zonePendule;

    public TapisDeJeu() {
        this.zoneMonstre = new Deck();
        this.zonePiegeEtMagie = new Deck();
        this.zoneCimetiere = new Deck();
        this.zoneDeck = new Deck();
        this.zoneTerrain = new Deck();
        this.zoneExtraDeck = new Deck();
        this.zonePendule = new Deck();
    }

    public TapisDeJeu(Deck zoneMonstre, Deck zonePiegeEtMagie, Deck zoneCimetiere, Deck zoneDeck, Deck zoneTerrain, Deck zoneExtraDeck, Deck zonePendule) {
        this.zoneMonstre = zoneMonstre;
        this.zonePiegeEtMagie = zonePiegeEtMagie;
        this.zoneCimetiere = zoneCimetiere;
        this.zoneDeck = zoneDeck;
        this.zoneTerrain = zoneTerrain;
        this.zoneExtraDeck = zoneExtraDeck;
        this.zonePendule = zonePendule;
    }

    public Deck getDeck(Zone zone) {
        return switch (zone) {
            case MONSTRE -> this.zoneMonstre;
            case PIEGE_ET_MAGIE -> this.zonePiegeEtMagie;
            case CIMETIERE -> this.zoneCimetiere;
            case MAIN -> this.zoneDeck;
            case TERRAIN -> this.zoneTerrain;
            case EXTRA -> this.zoneExtraDeck;
            case PENDULE -> this.zonePendule;
            default -> null;
        };
    }

    public void afficherZone(Zone zone) {
        Deck deck = getDeck(zone);
        if (deck == null) {
            System.out.println("Zone inconnue");
            return;
        }

        int i = 0;

        System.out.println("| ---- Zone " + zone + " ----\n|");
        for (ICarteYuGiHO card : deck.getDeck()) {
            String format = card.getName() + " ";
            format += "*".repeat(((CarteMonstre)card).getLevel()) + "\n";
            format += "|\t" + (((CarteMonstre)card).getAttribute()) + " - " + (((CarteMonstre)card).getType());
            format += " - [" + (((CarteMonstre)card).getAtk()) + "/" + (((CarteMonstre)card).getDef()) + "]";


            System.out.println("| " + i + " " + format);
            i++;
        }
        System.out.println("|\n| ----\n");
    }

    public void afficherCarte(Zone zone, int cardIndex) {
        Deck deck = getDeck(zone);
        if (deck == null) {
            System.out.println("Zone inconnue");
            return;
        }

        ICarteYuGiHO card = deck.getDeck().get(cardIndex);
        if (card == null) {
            System.out.println("Carte inconnue");
            return;
        }

        System.out.println("Zone " + zone + " - Carte " + cardIndex + " :");

        card.afficher();

        /*
        System.out.println("| ---- Carte " + card.getName() + " ----\n|");
        System.out.println("| Nom : " + card.getName());
        System.out.println("| Niveau : " + "*".repeat(((CarteMonstre)card).getLevel()));
        System.out.println("| Attribut : " + ((CarteMonstre)card).getAttribute());
        System.out.println("| Type : " + ((CarteMonstre)card).getType());
        System.out.println("| ATK/DEF : " + ((CarteMonstre)card).getAtk() + "/" + ((CarteMonstre)card).getDef());
        System.out.println("| Description : " + ((CarteMonstre)card).getDescription());
        System.out.println("|\n| ----");
         */
    }


    public void moveCard(Zone from, Zone to, ICarteYuGiHO card) {
        Deck fromDeck = getDeck(from);
        Deck toDeck = getDeck(to);

        fromDeck.getDeck().remove(card);
        toDeck.getDeck().add(card);
    }
}
