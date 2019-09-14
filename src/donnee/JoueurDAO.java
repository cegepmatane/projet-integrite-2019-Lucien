package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Joueur;

public class JoueurDAO implements JoueurSQL{
		
	private Connection connection = null;
	
	public JoueurDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}
	
	@SuppressWarnings("unused")
	private List<Joueur> simulerListerJoueurs()
	{
		List<Joueur> listeJoueursTest = new ArrayList<Joueur>();
		listeJoueursTest.add(new Joueur("Dolly", 18, "20 kg", "5 juin 2015"));
		listeJoueursTest.add(new Joueur("Molly", 20, "20 kg", "5 mai 2016"));
		listeJoueursTest.add(new Joueur("Arthurus", 3, "20 kg", "5 mars 2017"));
		listeJoueursTest.add(new Joueur("Cheese", 5, "20 kg", "5 septembre 2015"));
		return listeJoueursTest;
	}	
	
	public List<Joueur> listerJoueurs()
	{

		List<Joueur> listeJoueurs =  new ArrayList<Joueur>();			
		Statement requeteListeJoueurs;
		try {
			requeteListeJoueurs = connection.createStatement();
			ResultSet curseurListeJoueurs = requeteListeJoueurs.executeQuery(JoueurSQL.SQL_LISTER_JOUEURS);
			while(curseurListeJoueurs.next())
			{
				int id = curseurListeJoueurs.getInt("id");
				String nom = curseurListeJoueurs.getString("nom");
				int age = curseurListeJoueurs.getInt("age");
				String poids = curseurListeJoueurs.getString("poids");
				String naissance = curseurListeJoueurs.getString("naissance");
				System.out.println("Joueur " + nom + " née le " + naissance + " : " + poids + "kg " + age);
				Joueur joueur = new Joueur(nom, age, poids, naissance);
				joueur.setId(id);
				listeJoueurs.add(joueur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerJoueurs();
		return listeJoueurs;
	}
	
	public void ajouterJoueur(Joueur joueur)
	{
		System.out.println("JoueurDAO.ajouterJoueur()");
		try {
			PreparedStatement requeteAjouterJoueur = connection.prepareStatement(SQL_AJOUTER_JOUEUR);
			requeteAjouterJoueur.setString(1, joueur.getNom());
			requeteAjouterJoueur.setInt(2, joueur.getAge());
			requeteAjouterJoueur.setString(3, joueur.getPoids());
			requeteAjouterJoueur.setString(4, joueur.getNaissance());
			
			System.out.println("SQL : " + SQL_AJOUTER_JOUEUR);
			requeteAjouterJoueur.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierJoueur(Joueur joueur)
	{
		System.out.println("JoueurDAO.modifierJoueur()");
		try {
			PreparedStatement requeteModifierJoueur = connection.prepareStatement(SQL_MODIFIER_JOUEUR);
			requeteModifierJoueur.setString(1, joueur.getNom());
			requeteModifierJoueur.setInt(2, joueur.getAge());
			requeteModifierJoueur.setString(3, joueur.getPoids());
			requeteModifierJoueur.setString(4, joueur.getNaissance());
			requeteModifierJoueur.setInt(5, joueur.getId());
			
			System.out.println("SQL : " + SQL_MODIFIER_JOUEUR);
			requeteModifierJoueur.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Joueur rapporterJoueur(int idJoueur)
	{
		PreparedStatement requeteJoueur;
		try {
			requeteJoueur = connection.prepareStatement(SQL_RAPPORTER_JOUEUR);
			requeteJoueur.setInt(1, idJoueur);
			System.out.println(SQL_RAPPORTER_JOUEUR);
			ResultSet curseurJoueur = requeteJoueur.executeQuery();
			curseurJoueur.next();
			int id = curseurJoueur.getInt("id");
			String nom = curseurJoueur.getString("nom");
			int age = curseurJoueur.getInt("age");
			String poids = curseurJoueur.getString("poids");
			String naissance = curseurJoueur.getString("naissance");
			System.out.println("Joueur " + nom + " née le " + naissance + " : " + poids + "kg " + age + " ans");
			Joueur joueur = new Joueur(nom, age, poids, naissance);
			joueur.setId(id);
			return joueur;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
