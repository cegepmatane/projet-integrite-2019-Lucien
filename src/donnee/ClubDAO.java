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
                int dateCreation = curseurClub.getInt("telephone");

                club.setNom(nom);
                club.setDirigeant(dirigeant);
                club.setAdresse(adresse);
                club.setdateCreation(dateCreation);

                listClub.add(club);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClub;
    }

    public List<Club> listerClubsParJoueurs(Joueur joueur) {
        System.out.println("ClubDAO.listerClubsParJoueur(joueur)");
        List<Club> listeClubs = new ArrayList<Club>();

        Statement requeteListeClubs;
        try {
            requeteListeClubs = this.connection.createStatement();
            ResultSet curseurClubs = requeteListeClubs.executeQuery("SELECT * from club WHERE id_joueur = " + joueur.getId());
            System.out.println("SELECT * from club WHERE id_joueur = " + joueur.getId());
            while(curseurClubs.next())
            {
                Club club = new Club();

                int id = Integer.parseInt(curseurClubs.getString("id"));
                String nom = curseurClubs.getString("nom");
                String dirigeant = curseurClubs.getString("dirigeant");
                String adresse = curseurClubs.getString("adresse");
                int dateCreation = curseurClubs.getInt("dateCreation");
                club.setId(id);
                club.setNom(nom);
                club.setDirigeant(dirigeant);
                club.setAdresse(adresse);
                club.setdateCreation(dateCreation);

                listeClubs.add(club);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(listeClubs.size() + "slt");
        return listeClubs;
    }

    public void ajouterClub(Club club) {
        PreparedStatement requeteAjouterClub = null;
        try {
            requeteAjouterClub = connection.prepareStatement("INSERT INTO club(nom, dirigeant, adresse, dateCreation, id_joueur)" +
                    "VALUES (?,?,?,?,?)");
            requeteAjouterClub.setString(1, club.getNom());
            requeteAjouterClub.setString(2, club.getDirigeant());
            requeteAjouterClub.setString(3, club.getAdresse());
            requeteAjouterClub.setInt(4, club.getdateCreation());
            requeteAjouterClub.setInt(5, club.getId_joueur());

            requeteAjouterClub.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Club rapporterClub(int id)
    {
        System.out.println("ClubDAO.rapporterClub("+id+")");
        Club club = new Club();

        try {

            Statement requete = connection.createStatement();
            ResultSet curseurClubs = requete.executeQuery("SELECT * FROM club WHERE id = " + id);
            curseurClubs.next();
            String nom = curseurClubs.getString("nom");
            String dirigeant = curseurClubs.getString("dirigeant");
            String adresse = curseurClubs.getString("adresse");
            int dateCreation = curseurClubs.getInt("dateCreation");
            club.setId(id);
            club.setId_joueur(id);
            club.setNom(nom);
            club.setDirigeant(dirigeant);
            club.setAdresse(adresse);
            club.setdateCreation(dateCreation);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return club;
    }
}
