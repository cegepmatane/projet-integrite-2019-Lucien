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

public class VueAjouterClub extends Scene {

    protected TextField valeurNom;
    protected TextField valeurDirigeant;
    protected TextField valeurAdresse;
    protected TextField valeurTelephone;
    protected TextField valeurIdJoueur;

    private ControleurJoueur controleur = null;
    protected Button actionEnregistrerJoueur = null;

    public VueAjouterClub()  {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleJoueur = new GridPane();
        this.actionEnregistrerJoueur = new Button("Enregistrer");


        this.actionEnregistrerJoueur.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                controleur.notifierEnregistrerAjoutClub();

            }});

        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
        valeurNom = new TextField();
        grilleJoueur.add(new Label("Nom : "), 0, 0);
        grilleJoueur.add(valeurNom, 1, 0);

        valeurDirigeant = new TextField("");
        grilleJoueur.add(new Label("Dirigeant : "), 0, 1);
        grilleJoueur.add(valeurDirigeant, 1, 1);

        valeurAdresse = new TextField("");
        grilleJoueur.add(new Label("Adresse : "), 0, 2);
        grilleJoueur.add(valeurAdresse, 1, 2);

        valeurTelephone = new TextField("");
        grilleJoueur.add(new Label("Telephone : "), 0, 3);
        grilleJoueur.add(valeurTelephone, 1, 3);

        // Todo : retirer les textes magiques
        panneau.getChildren().add(new Label("Ajouter un joueur")); // Todo : cr?er un sous-type de Label ou Text pour les titres
        panneau.getChildren().add(grilleJoueur);
        panneau.getChildren().add(this.actionEnregistrerJoueur);
    }

    public Club demanderClub()
    {
        Club club = new Club(this.valeurNom.getText(),
                this.valeurDirigeant.getText(),
                this.valeurAdresse.getText(),
                this.valeurTelephone.getText()
        );
        return club;
    }

    public void setControleur(ControleurJoueur controleur) {
        this.controleur = controleur;
    }
}
