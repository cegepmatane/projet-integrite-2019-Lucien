package vue;

import action.ControleurJoueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Club;
import modele.Joueur;

import java.util.List;

public class VueEditerJoueur extends Scene {

	protected TextField valeurNom;
	protected TextField valeurAge;
	protected TextField valeurPoids;
	protected TextField valeurNaissance;
	
	private ControleurJoueur controleur = null;
	protected Button actionEnregistrerJoueur = null;
	
	private int idJoueur = 0;
	
	public VueEditerJoueur()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleJoueur = new GridPane();
				
		this.actionEnregistrerJoueur = new Button("Enregistrer");
		
		this.actionEnregistrerJoueur.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerJoueur();
				
			}});
		
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleJoueur.add(new Label("Nom : "), 0, 0);
		grilleJoueur.add(valeurNom, 1, 0);
		
		valeurAge = new TextField("");
		grilleJoueur.add(new Label("Age : "), 0, 1);
		grilleJoueur.add(valeurAge, 1, 1);

		valeurPoids = new TextField("");
		grilleJoueur.add(new Label("Poids : "), 0, 2);
		grilleJoueur.add(valeurPoids, 1, 2);		

		valeurNaissance = new TextField("");
		grilleJoueur.add(new Label("Naissance : "), 0, 3);
		grilleJoueur.add(valeurNaissance, 1, 3);				
	
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer un joueur")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleJoueur);
		panneau.getChildren().add(this.actionEnregistrerJoueur);
	}
	
	public void afficherJoueur(Joueur joueur)
	{
		this.idJoueur = joueur.getId();
		this.valeurNom.setText(joueur.getNom());
		this.valeurAge.setText(joueur.getAge());
		this.valeurPoids.setText(joueur.getPoids());
		this.valeurNaissance.setText(joueur.getNaissance());
	}
		
	public Joueur demanderJoueur()
	{
		Joueur joueur = new Joueur(this.valeurNom.getText(),
								this.valeurAge.getText(), 
								this.valeurPoids.getText(), 
								this.valeurNaissance.getText());
		joueur.setId(idJoueur);
		return joueur;
	}
	
	public void setControleur(ControleurJoueur controleur) {
		this.controleur = controleur;
	}

	public void afficheListeClub(List<Club> listeClubs) {

	}
}
