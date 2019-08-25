package modele;

public class Joueur {

	protected int id;
	protected String nom;
	protected String age;
	protected String poids;
	protected String naissance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Joueur(String nom) {
		super();
		this.nom = nom;
	}
	public Joueur(String nom, String age) {
		super();
		this.nom = nom;
		this.age = age;
	}
	public Joueur(String nom, String age, String poids) {
		super();
		this.nom = nom;
		this.age = age;
		this.poids = poids;
	}
	public Joueur(String nom, String age, String poids, String naissance) {
		super();
		this.nom = nom;
		this.age = age;
		this.poids = poids;
		this.naissance = naissance;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getNaissance() {
		return naissance;
	}
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	public String getPoids() {
		return poids;
	}
	public void setPoids(String poids) {
		this.poids = poids;
	}
	
}
