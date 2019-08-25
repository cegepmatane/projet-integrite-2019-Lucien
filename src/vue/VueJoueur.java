package vue;
import action.ControleurJoueur;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Joueur;

public class VueJoueur extends Scene{

	protected Label valeurNom;
	protected Label valeurAge;
	protected Label valeurPoids;
	protected Label valeurNaissance;
	
	@SuppressWarnings("unused")
	private ControleurJoueur controleur = null;	
	
	public VueJoueur() {
		super(new GridPane(),400,400);
		GridPane grilleJoueur = (GridPane) this.getRoot();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new Label("");
		grilleJoueur.add(new Label("Nom : "), 0, 0);
		grilleJoueur.add(valeurNom, 1, 0);
		
		valeurAge = new Label("");
		grilleJoueur.add(new Label("Age : "), 0, 1);
		grilleJoueur.add(valeurAge, 1, 1);

		valeurPoids = new Label("");
		grilleJoueur.add(new Label("Poids : "), 0, 2);
		grilleJoueur.add(valeurPoids, 1, 2);		

		valeurNaissance = new Label("");
		grilleJoueur.add(new Label("Naissance : "), 0, 3);
		grilleJoueur.add(valeurNaissance, 1, 3);				
	}
	
	public void afficherJoueur(Joueur joueur)
	{
		this.valeurNom.setText(joueur.getNom());
		this.valeurAge.setText(joueur.getAge());
		this.valeurPoids.setText(joueur.getPoids());
		this.valeurNaissance.setText(joueur.getNaissance());
	}
	
	
	public void setControleur(ControleurJoueur controleur) {
		this.controleur = controleur;
	}

}
