package org.example.services;
import org.example.models.Reservation;
import org.example.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Reservation_Service implements Service<Reservation> {

private final Connection db;
	public Reservation_Service(){
		this.db = DataSource.getInstance().getConnection();
	}
	@Override
	public void ajouter(Reservation reservation){
		try{
				PreparedStatement ps = db.prepareStatement("INSERT INTO RESERVATION (evenement_id,quantite,utilisateur_id,date_reservation) VALUES (?,?,?,?)");
				
				ps.setInt(1,reservation.getEvenement_id());
				ps.setInt(2,reservation.getQuantite());
				ps.setInt(3,reservation.getUtilisateur_id());
				ps.setString(4,reservation.getDate_reservation());
				ps.executeUpdate();
		}catch(Exception ignored){
			System.out.println(ignored.getMessage());
		}
	}
	@Override
	public void modifier(Reservation reservation){
		try{
				PreparedStatement ps = db.prepareStatement("UPDATE RESERVATION SET  evenement_id = ?, quantite = ?, utilisateur_id = ?, date_reservation = ? WHERE ID = ? ");
				ps.setInt(1,reservation.getEvenement_id());
				ps.setInt(2,reservation.getQuantite());
				ps.setInt(3,reservation.getUtilisateur_id());
				ps.setString(4,reservation.getDate_reservation());
				ps.setInt(5,reservation.getId());
				ps.executeUpdate();
		}catch(Exception ignored){}
	}
	@Override
	public List<Reservation> afficher(){
		try{
				ResultSet rs = db.createStatement().executeQuery("SELECT * FROM Reservation");
				List<Reservation> reservations = new ArrayList<>();
				while(rs.next()){
						reservations.add(new Reservation(rs.getInt("id"),rs.getInt("evenement_id"),rs.getInt("quantite"),rs.getInt("utilisateur_id"),rs.getString("date_reservation")));
				}
				return reservations;
		}catch(Exception ignored){return null;}
	}
	@Override
	public void supprimer(Reservation reservation){
		try{
				 PreparedStatement ps = db.prepareStatement("DELETE FROM RESERVATION WHERE ID = ? ");
				 ps.setInt(1,reservation.getId());
				ps.executeUpdate();
		}catch(Exception ignored){}
	}
	}