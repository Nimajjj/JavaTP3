package PExercices.PExercice3.PCarteYuGiHO;

abstract class APiegeEtMagie implements ICarteYuGiHO {
    public String nom;
    public String type;
    public String icone;
    public String description;
    public String numero;

    // make a card from raw data
    public APiegeEtMagie(String nom, String type, String icone, String description, String numero) {
        this.nom = nom;
        this.type = type;
        this.icone = icone;
        this.description = description;
        this.numero = numero;
    }

    // print formatted infos
    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Type : " + "[" + type + "]");
        System.out.println("Icone : " + icone);
        System.out.println("Numéro : " + numero);
        System.out.println("Description : \n\t\"" + description.replace("\n", "\n\t ") + "\"");

        System.out.println();
    }
}
