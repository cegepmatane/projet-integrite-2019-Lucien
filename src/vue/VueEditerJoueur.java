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

import java.sql.SQLOutput;
import java.util.List;

public class VueEditerJoueur extends Scene {

	protected TextField valeurNom;
	protected TextField valeurAge;
	protected TextField valeurPoids;
	protected TextField valeurNaissance;
	
	private ControleurJoueur controleur = null;
	protected Button actionEnregistrerJoueur = null;
	protected Button actionAjouterClub = null;
	
	private int idJoueur = 0;
	private int idClub = 0;
	private GridPane grilleClubs = null;
	
	public VueEditerJoueur()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleJoueur = new GridPane();
		this.grilleClubs = new GridPane();
				
		this.actionEnregistrerJoueur = new Button("Enregistrer");
		this.actionAjouterClub = new Button("Ajouter un club");

		this.actionEnregistrerJoueur.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerJoueur();
				
			}});

		this.actionAjouterClub.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				controleur.notifierNaviguerAjouterClub();

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
		panneau.getChildren().add(new Label("Editer un joueur")); // Todo : cr�er un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleJoueur);
		panneau.getChildren().add(this.actionEnregistrerJoueur);
		panneau.getChildren().add(this.actionAjouterClub);
		panneau.getChildren().add(this.grilleClubs);
	}
	
	public void afficherJoueur(Joueur joueur)
	{
		this.idJoueur = joueur.getId();
		this.valeurNom.setText(joueur.getNom());
		this.valeurAge.setText(joueur.getAge() + "");
		this.valeurPoids.setText(joueur.getPoids());
		this.valeurNaissance.setText(joueur.getNaissance());
	}
		
	public Joueur demanderJoueur()
	{
		Joueur joueur = new Joueur(this.valeurNom.getText(),
								Integer.parseInt(this.valeurAge.getText()),
								this.valeurPoids.getText(), 
								this.valeurNaissance.getText());
		joueur.setId(idJoueur);
		return joueur;
	}
	
	public void setControleur(ControleurJoueur controleur) {
		this.controleur = controleur;
	}

	public void afficheListeClub(List<Club> listeClubs) {
		this.grilleClubs.getChildren().clear();
		int rangee = 0;
		System.out.println(listeClubs.size());
		for (Club club :
				listeClubs) {
			Button actionEditerClub = new Button("Editer");
			actionEditerClub.setUserData(club.getId());
			actionEditerClub.setOnAction(evenement -> {
				int id = (int)((Button)evenement.getSource()).getUserData();
				controleur.notifierNaviguerEditerClub(id);
			});
			this.grilleClubs.add(new Label(club.getNom()), 0, rangee);
			this.grilleClubs.add(actionEditerClub, 1, rangee++);
		}
	}
}
