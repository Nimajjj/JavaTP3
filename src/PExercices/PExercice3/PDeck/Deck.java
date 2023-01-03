package PExercices.PExercice3.PDeck;

import PExercices.PExercice3.PCarteYuGiHO.ICarteYuGiHO;

import java.util.HashMap;
import java.util.Vector;

public class Deck {
    private Vector<ICarteYuGiHO> cards;


    // constructor

    public Deck() {
        this.cards = new Vector<>();
    }

    public Deck(Vector<ICarteYuGiHO> cards) {
        this.cards = cards;
    }


    // test methods

    public boolean isAValidMainDeck() {
        // test deck size
        if (cards.size() > 60) {
            return false;
        } else if (cards.size() < 40) {
            return false;
        }

        // test number of copies
        HashMap<String, Integer> map = new HashMap<>();
        for (ICarteYuGiHO card : cards) {
            String id = card.getId();

            if (map.containsKey(id)) {
                map.put(id, map.get(id) + 1);
                if (map.get(id) > 3) {
                    return false;
                }
            } else {
                map.put(id, 1);
            }
        }

        return true;
    }


    // setters

    public void setDeck(Vector<ICarteYuGiHO> cards) {
        this.cards = cards;
    }


    // getters
    public Vector<ICarteYuGiHO> getDeck() {
        return this.cards;
    }

    public int getSize() {
        return this.cards.size();
    }

    public ICarteYuGiHO getCard(int index) {
        return this.cards.get(index);
    }

    public void addCard(ICarteYuGiHO card) {
        this.cards.add(card);
    }
}
