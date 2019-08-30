package modele;

public class Club {

    protected String nom;
    protected String dirigeant;
    protected String adresse;
    protected String telephone;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
