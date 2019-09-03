package action;

import java.util.ArrayList;
import java.util.List;

import donnee.ClubDAO;
import donnee.JoueurDAO;
import modele.Club;
import modele.Joueur;
import vue.NavigateurDesVues;
import vue.VueEditerJoueur;
import vue.VueListeJoueur;
import vue.VueJoueur;

public class ControleurJoueur {
	
	private NavigateurDesVues navigateur;
	private VueListeJoueur vueListeJoueur = null;
	private VueJoueur vueJoueur = null;
	//private VueAjouterJoueur vueAjouterJoueur = null;
	private VueEditerJoueur vueEditerJoueur = null;
	private JoueurDAO joueurDAO = null;
	
	private ControleurJoueur()
	{
		System.out.println("Initialisation du controleur");	
		this.joueurDAO = new JoueurDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		//this.vueAjouterJoueur = navigateur.getVueAjouterJoueur();
		this.vueJoueur = navigateur.getVueJoueur();
		this.vueListeJoueur = navigateur.getVueListeJoueur();
		this.vueEditerJoueur = navigateur.getVueEditerJoueur();
						
		//// TEST ////
		Joueur joueur = new Joueur("Dolly", "Grise", "20 kg", "5 juin 2015");
		this.vueJoueur.afficherJoueur(joueur); // Appel de ma fonction avant de la programmer (pour tester � mesure)
		
		this.navigateur.naviguerVersVueJoueur();
		
		/// TEST ///
		List<Joueur> listeJoueursTest = joueurDAO.listerJoueurs();
		this.vueListeJoueur.afficherListeJoueur(listeJoueursTest); // Appel de ma fonction avant de la programmer (pour tester � mesure)
		
		this.navigateur.naviguerVersVueListeJoueur();		
				
		//this.navigateur.naviguerVersVueAjouterJoueur();
		
		//this.vueEditerJoueur.afficherListeDistinction(this.distinctionDAO.listerDistinctions());
		
	}
	
	// SINGLETON DEBUT
	private static ControleurJoueur instance = null;
	public static ControleurJoueur getInstance()
	{
		if(null == instance) instance = new ControleurJoueur();
		return instance;
	}
	// SINGLETON FINI

	
	
	
	
	
	
	//**********************************************************//
	//                                                          //
	//                   NOTIFICATIONS                          //
	//                                                          //
	//**********************************************************//
	
	// Les notifications peuvent �tre g�r�es par callback comme ici ou par �v�nement,
	// Mais dans les deux cas les op�rations sont divis�es dans des fonctions comme ici
	// Pas de code dans un switch - case
	
	public void notifierEnregistrerNouveauJoueur()
	{
		System.out.println("ControleurJoueur.notifierEnregistrerNouveauJoueur()");
		Joueur joueur = this.navigateur.getVueAjouterJoueur().demanderJoueur();
		this.joueurDAO.ajouterJoueur(joueur);
		this.vueListeJoueur.afficherListeJoueur(this.joueurDAO.listerJoueurs()); // TODO optimiser
		this.navigateur.naviguerVersVueListeJoueur();
	}
	
	public void notifierEnregistrerJoueur()
	{
		System.out.println("ControleurJoueur.notifierEnregistrerJoueur()");
		Joueur joueur = this.navigateur.getVueEditerJoueur().demanderJoueur();
		this.joueurDAO.modifierJoueur(joueur);
		this.vueListeJoueur.afficherListeJoueur(this.joueurDAO.listerJoueurs()); // TODO optimiser
		this.navigateur.naviguerVersVueListeJoueur();		
	}
	
	public void notifierNaviguerAjouterJoueur()
	{
		System.out.println("ControleurJoueur.notifierNaviguerAjouterJoueur()");
		this.navigateur.naviguerVersVueAjouterJoueur();
	}
	
	public void notifierNaviguerEditerJoueur(int idJoueur)
	{
		System.out.println("ControleurJoueur.notifierEditerJoueur("+idJoueur+")");
		// savoir par la vue liste quel numero de joueur a ete clique
		this.vueEditerJoueur.afficherJoueur(this.joueurDAO.rapporterJoueur(idJoueur));
		this.navigateur.naviguerVersVueEditerJoueur();


		/* Debut mockup
		List<Club> listeClubs = new ArrayList<Club>();

		Club toto = new Club();
		toto.setNom("Toto");
		listeClubs.add(toto);

		Club lulu = new Club();
		lulu.setNom("Lulu");
		listeClubs.add(lulu);
		*/

		//TEST
		ClubDAO accesseurClub = new ClubDAO();
		Joueur joueur1 = new Joueur("");
		joueur1.setId(2);

		List<Club> listeClub = accesseurClub.listerClubsParJoueurs(joueur1);

		this.vueEditerJoueur.afficheListeClub(listeClub);
		
	}
}
