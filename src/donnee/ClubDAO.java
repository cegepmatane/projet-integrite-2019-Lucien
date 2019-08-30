package donnee;

import modele.Club;
import modele.Joueur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return null;
    }
}