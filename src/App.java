import donnee.ClubDAO;
import modele.Club;
import vue.NavigateurDesVues;

import java.util.List;

public class App {

	public static void main(String[] parametres) {
		
		ClubDAO accesseurClub = new ClubDAO();
		List<Club> listeClub = accesseurClub.listerClub();
		for (Club club :
				listeClub) {
			System.out.println(club.getNom());
			System.out.println(club.getDirigeant());
			System.out.println(club.getAdresse());
			System.out.println(club.getTelephone());
		}
		NavigateurDesVues.launch(NavigateurDesVues.class, parametres);
	}
}
