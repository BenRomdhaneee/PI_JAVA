package org.example.models;


public class Evenement{

	private Integer id;
	private Integer prix;
	private String date_debut;
	private String date_fin;
	private String nom;
	private String description;

	public Evenement(Integer prix, String date_debut, String date_fin, String nom, String description){
		this.prix = prix;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.nom = nom;
		this.description = description;
	}

	public Evenement(Integer id, Integer prix, String date_debut, String date_fin, String nom, String description){
		this.id = id;
		this.prix = prix;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.nom = nom;
		this.description = description;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setPrix(Integer prix){
		this.prix = prix;
	}
	public Integer getPrix(){
		return this.prix;
	}
	public void setDate_debut(String date_debut){
		this.date_debut = date_debut;
	}
	public String getDate_debut(){
		return this.date_debut;
	}
	public void setDate_fin(String date_fin){
		this.date_fin = date_fin;
	}
	public String getDate_fin(){
		return this.date_fin;
	}
	public void setNom(String nom){
		this.nom = nom;
	}
	public String getNom(){
		return this.nom;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}

	@Override
	public String toString() {
		return "Evenement{" +
				"id=" + id +
				", prix=" + prix +
				", date_debut='" + date_debut + '\'' +
				", date_fin='" + date_fin + '\'' +
				", nom='" + nom + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}