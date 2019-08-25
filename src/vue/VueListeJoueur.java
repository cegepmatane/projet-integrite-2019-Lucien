package vue;
import java.util.List;

import action.ControleurJoueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Joueur;

public class VueListeJoueur extends Scene {

	protected GridPane grilleJoueurs;
	
	private ControleurJoueur controleur = null;
	
	private Button actionNaviguerAjouterJoueur;
	public VueListeJoueur() {
		super(new GridPane(), 400,400);
		grilleJoueurs = (GridPane) this.getRoot();
		this.actionNaviguerAjouterJoueur = new Button("Ajouter un joueur");
	}
	
	public void afficherListeJoueur(List<Joueur> listeJoueurs)
	{
		this.grilleJoueurs.getChildren().clear();
		
		int numero = 0;
		this.grilleJoueurs.add(new Label("Nom"), 0, numero);
		this.grilleJoueurs.add(new Label("Naissance"), 1, numero);	
		for(Joueur joueur : listeJoueurs)
		{
			Button actionEditerJoueur = new Button("Editer");
			actionEditerJoueur.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent a) {
					controleur.notifierNaviguerEditerJoueur(joueur.getId()); // TODO ameliorer ceci pour respecter architecture cible = pas de parametre dans les notifications au controleur
				}});
			numero++;
			this.grilleJoueurs.add(new Label(joueur.getNom()), 0, numero);
			this.grilleJoueurs.add(new Label(joueur.getNaissance()), 1, numero);
			this.grilleJoueurs.add(actionEditerJoueur, 2, numero);
		}
		
		this.actionNaviguerAjouterJoueur.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerAjouterJoueur();
			}	
		});
		
		this.grilleJoueurs.add(this.actionNaviguerAjouterJoueur, 1, ++numero);
	}

	public void setControleur(ControleurJoueur controleur) {
		this.controleur = controleur;
	}

}
