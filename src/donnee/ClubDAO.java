package donnee;

import modele.Club;
import modele.Joueur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClubDAO {
    private Connection connection = null;

    public ClubDAO()
    {
        this.connection = BaseDeDonnees.getInstance().getConnection();
    }

    public List<Club> listerClub() {
        List<Club> listClub = new ArrayList<Club>();

        try {
            Statement requeteListeClub = this.connection.createStatement();
            ResultSet curseurClub = requeteListeClub.executeQuery("SELECT * from club");

            while (curseurClub.next()) {
                Club club = new Club();
                String nom = curseurClub.getString("nom");
                String dirigeant = curseurClub.getString("dirigeant");
                String adresse = curseurClub.getString("adresse");
                String telephone = curseurClub.getString("telephone");

                club.setNom(nom);
                club.setDirigeant(dirigeant);
                club.setAdresse(adresse);
                club.setTelephone(telephone);

                listClub.add(club);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClub;
    }

    public List<Club> listerClubsParJoueurs(Joueur joueur) {
        List<Club> listClub = new ArrayList<Club>();
        Statement requeteListeClubs;

        try {
            requeteListeClubs = this.connection.createStatement();
            ResultSet curseurClubs = requeteListeClubs.executeQuery("SELECT * FROM club WHERE id_joueur = " + joueur.getId());

            while (curseurClubs.next()) {
                Club club = new Club();

                int id = Integer.parseInt(curseurClubs.getString("id"));
                String nom = curseurClubs.getString("nom");
                String dirigeant = curseurClubs.getString("dirigeant");
                String adresse = curseurClubs.getString("adresse");
                String telephone = curseurClubs.getString("telephone");

                club.setId(id);
                club.setNom(nom);
                club.setDirigeant(dirigeant);
                club.setAdresse(adresse);
                club.setTelephone(telephone);

                listClub.add(club);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listClub;
    }

    public void ajouterClub(Club club) {
        PreparedStatement requeteAjouterConcepteur = null;
        try {
            requeteAjouterConcepteur = connection.prepareStatement("INSERT INTO club(nom, dirigeant, adresse, telephone, id_joueur)" +
                    "VALUES (?,?,?,?,?)");
            requeteAjouterConcepteur.setString(1, club.getNom());
            requeteAjouterConcepteur.setString(2, club.getDirigeant());
            requeteAjouterConcepteur.setString(3, club.getAdresse());
            requeteAjouterConcepteur.setString(4, club.getTelephone());
            requeteAjouterConcepteur.setInt(5, club.getId_joueur());

            requeteAjouterConcepteur.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
