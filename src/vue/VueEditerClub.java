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
import modele.Club;

import java.util.List;

public class VueEditerClub extends Scene {

    protected TextField valeurNom;
    protected TextField valeurDirigeant;
    protected TextField valeurAdresse;
    protected TextField valeurTelephone;

    private ControleurJoueur controleur = null;
    protected Button actionEnregistrerClub = null;
    protected Button actionAjouterClub = null;

    private int idClub = 0;
    private GridPane grilleClubs = null;

    public VueEditerClub()  {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleClub = new GridPane();
        this.grilleClubs = new GridPane();

        this.actionEnregistrerClub = new Button("Enregistrer");

        this.actionEnregistrerClub.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

            }});

        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
        valeurNom = new TextField();
        grilleClub.add(new Label("Nom : "), 0, 0);
        grilleClub.add(valeurNom, 1, 0);

        valeurDirigeant = new TextField("");
        grilleClub.add(new Label("Dirigeant : "), 0, 1);
        grilleClub.add(valeurDirigeant, 1, 1);

        valeurAdresse = new TextField("");
        grilleClub.add(new Label("Adresse : "), 0, 2);
        grilleClub.add(valeurAdresse, 1, 2);

        valeurTelephone = new TextField("");
        grilleClub.add(new Label("Telephone : "), 0, 3);
        grilleClub.add(valeurTelephone, 1, 3);

        // Todo : retirer les textes magiques
        panneau.getChildren().add(new Label("Editer un club")); // Todo : créer un sous-type de Label ou Text pour les titres
        panneau.getChildren().add(grilleClub);
        panneau.getChildren().add(this.actionEnregistrerClub);
        panneau.getChildren().add(this.grilleClubs);
    }

    public void setControleur(ControleurJoueur controleur) {
        this.controleur = controleur;
    }
}
