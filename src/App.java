import donnee.ClubDAO;
import modele.Club;
import modele.Joueur;
import vue.NavigateurDesVues;

import java.util.List;

public class App {

	public static void main(String[] parametres) {
		
		ClubDAO accesseurClub = new ClubDAO();
		Joueur joueur1 = new Joueur("");
		joueur1.setId(2);

		List<Club> listeClub = accesseurClub.listerClubsParJoueurs(joueur1);
		for (Club club :
				listeClub) {
			System.out.println(club.getNom() + " " + club.getDirigeant() + " " + club.getAdresse() + " " + club.getTelephone());
		}
		NavigateurDesVues.launch(NavigateurDesVues.class, parametres);
	}
}
