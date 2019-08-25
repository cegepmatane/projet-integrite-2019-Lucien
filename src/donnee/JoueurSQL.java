package donnee;

public interface JoueurSQL {
	
	public static final String SQL_LISTER_JOUEURS = "SELECT * FROM joueur";
	public static final String SQL_AJOUTER_JOUEUR = "INSERT into joueur(nom, age, poids, naissance) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_JOUEUR = "UPDATE joueur SET nom = ?, age = ?, poids = ?, naissance = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_JOUEUR = "SELECT * FROM joueur WHERE id = ?";

}
