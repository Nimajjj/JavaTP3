package PExercices.PExercice3;

import java.io.Serializable;

public class Global {
    public enum Type implements Serializable {
        NORMAL("Normal"),
        MAGICIEN("Magicien"),
        RITUEL("Rituel"),
        DRAGON("Dragon"),
        XYZ_MONSTER("XYZ Monster");

        private final String value;

        Type(String type) {
            this.value = type;
        }

        public String getType() {
            return value;
        }
    }

    public enum TypeBis implements Serializable {
        NULL(""),
        NORMAL("Normal"),
        EFFET("Effet");

        private final String value;

        TypeBis(String type) {
            this.value = type;
        }

        public String getType() {
            return value;
        }
    }

    public enum Attribut implements Serializable {
        TERRE("地 Terre"),
        FEU("火 Feu"),
        EAU("水 Eau"),
        LUMIERE("光 Lumière"),
        TENEBRE("闇 Ténèbres"),
        DIVIN("神 Divin"),
        VENT("風 Vent");

        private final String value;

        Attribut(String attr) {
            this.value = attr;
        }

        public String getAttr() {
            return value;
        }
    }
}
