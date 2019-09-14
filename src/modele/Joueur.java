package modele;

public class Joueur {

	protected int id;
	protected String nom;
	protected int age;
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
	public Joueur(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}
	public Joueur(String nom, int age, String poids) {
		super();
		this.nom = nom;
		this.age = age;
		this.poids = poids;
	}
	public Joueur(String nom, int age, String poids, String naissance) {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
