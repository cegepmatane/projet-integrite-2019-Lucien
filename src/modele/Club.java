package modele;

public class Club {

    protected int id;
    protected String nom;
    protected String dirigeant;
    protected String adresse;
    protected int dateCreation;
    protected int id_joueur;

    public Club() {

    }

    public Club(String nom, String dirigeant, String adresse, int dateCreation) {
        this.nom = nom;
        this.dirigeant = dirigeant;
        this.adresse = adresse;
        this.dateCreation = dateCreation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDirigeant() {
        return dirigeant;
    }

    public void setDirigeant(String dirigeant) {
        this.dirigeant = dirigeant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getdateCreation() {
        return dateCreation;
    }

    public void setdateCreation(int dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
