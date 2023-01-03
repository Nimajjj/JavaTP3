package PExercices.PExercice3.PCarteYuGiHO;

abstract class AMonstre implements ICarteYuGiHO {
    public String nom;
    public String attribut;
    public String type;
    public String numero;
    public String description;
    public int niveau;
    public int atk;
    public int def;

    // make a card from raw data
    public AMonstre(String nom, String attribut, String type, String numero, String description, int niveau, int atk, int def) {
        this.nom = nom;
        this.attribut = attribut;
        this.type = type;
        this.numero = numero;
        this.description = description;
        this.niveau = niveau;
        this.atk = atk;
        this.def = def;
    }

    // print formatted infos
    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Niveau : " + "(*) ".repeat(Math.max(0, niveau)));
        System.out.println("Attribut : " + attribut);
        System.out.println("Type : " + "[" + type + "]");
        System.out.println("Numéro : " + numero);
        System.out.println("ATK/" + atk + " DEF/" + def);
        System.out.println("Description : \n\t\"" + description.replace("\n", "\n\t ") + "\"");

        System.out.println();
    }

    public String getId() {
        return numero;
    }
    public String getName() { return nom; }
    public String getAttribute() { return attribut; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public int getLevel() { return niveau; }
    public int getAtk() { return atk; }
    public int getDef() { return def; }
}
