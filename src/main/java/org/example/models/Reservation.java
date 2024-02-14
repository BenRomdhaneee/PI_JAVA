package org.example.models;


public class Reservation{

	private Integer id;
	private Integer evenement_id;
	private Integer quantite;
	private Integer utilisateur_id;
	private String date_reservation;

	public Reservation(Integer evenement_id, Integer quantite, Integer utilisateur_id, String date_reservation){
		this.evenement_id = evenement_id;
		this.quantite = quantite;
		this.utilisateur_id = utilisateur_id;
		this.date_reservation = date_reservation;
	}

	public Reservation(Integer id, Integer evenement_id, Integer quantite, Integer utilisateur_id, String date_reservation){
		this.id = id;
		this.evenement_id = evenement_id;
		this.quantite = quantite;
		this.utilisateur_id = utilisateur_id;
		this.date_reservation = date_reservation;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setEvenement_id(Integer evenement_id){
		this.evenement_id = evenement_id;
	}
	public Integer getEvenement_id(){
		return this.evenement_id;
	}
	public void setQuantite(Integer quantite){
		this.quantite = quantite;
	}
	public Integer getQuantite(){
		return this.quantite;
	}
	public void setUtilisateur_id(Integer utilisateur_id){
		this.utilisateur_id = utilisateur_id;
	}
	public Integer getUtilisateur_id(){
		return this.utilisateur_id;
	}
	public void setDate_reservation(String date_reservation){
		this.date_reservation = date_reservation;
	}
	public String getDate_reservation(){
		return this.date_reservation;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", evenement_id=" + evenement_id +
				", quantite=" + quantite +
				", utilisateur_id=" + utilisateur_id +
				", date_reservation='" + date_reservation + '\'' +
				'}';
	}
}