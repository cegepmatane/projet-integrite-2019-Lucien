package vue;

import action.ControleurJoueur;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueListeJoueur vueListeJoueur = null;
	private VueJoueur vueJoueur = null;
	private VueAjouterJoueur vueAjouterJoueur = null;
	private VueEditerJoueur vueEditerJoueur = null;
	
	private ControleurJoueur controleur = null;
	
	public NavigateurDesVues() 
	{		
		this.vueListeJoueur = new VueListeJoueur();
		this.vueJoueur = new VueJoueur();
		this.vueAjouterJoueur = new VueAjouterJoueur();
		this.vueEditerJoueur = new VueEditerJoueur();
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurJoueur.getInstance();
		this.controleur.activerVues(this);
		this.vueListeJoueur.setControleur(controleur);
		this.vueJoueur.setControleur(controleur);
		this.vueAjouterJoueur.setControleur(controleur);
		this.vueEditerJoueur.setControleur(controleur);
	}	
	
	public VueListeJoueur getVueListeJoueur() {
		return vueListeJoueur;
	}

	public VueJoueur getVueJoueur() {
		return vueJoueur;
	}
	
	public VueAjouterJoueur getVueAjouterJoueur() {
		return vueAjouterJoueur;
	}

	public VueEditerJoueur getVueEditerJoueur(){
		return this.vueEditerJoueur;
	}
	
	public void naviguerVersVueJoueur() {
		stade.setScene(this.vueJoueur);
		stade.show();
	}
	
	public void naviguerVersVueListeJoueur()
	{
		stade.setScene(this.vueListeJoueur);
		stade.show();		
	}
	
	public void naviguerVersVueAjouterJoueur()
	{
		stade.setScene(this.vueAjouterJoueur);
		stade.show();				
	}

	public void naviguerVersVueEditerJoueur()
	{
		stade.setScene(this.vueEditerJoueur);
		stade.show();				
	}
	
}
