package org.example.services;

import org.example.models.Evenement;
import org.example.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Evenement_Service implements Service<Evenement> {

private final Connection db;
	public Evenement_Service(){
		this.db = DataSource.getInstance().getConnection();
	}
	@Override
	public void ajouter(Evenement evenement){
		try{
				PreparedStatement ps = db.prepareStatement("INSERT INTO EVENEMENT (prix,date_debut,date_fin,nom,description) VALUES (?,?,?,?,?)");
				
				ps.setInt(1,evenement.getPrix());
				ps.setString(2,evenement.getDate_debut());
				ps.setString(3,evenement.getDate_fin());
				ps.setString(4,evenement.getNom());
				ps.setString(5,evenement.getDescription());
				ps.executeUpdate();
		}catch(Exception ignored){}
	}
	@Override
	public void modifier(Evenement evenement){
		try{
				PreparedStatement ps = db.prepareStatement("UPDATE EVENEMENT SET  prix = ?, date_debut = ?, date_fin = ?, nom = ?, description = ? WHERE ID = ? ");
				ps.setInt(1,evenement.getPrix());
				ps.setString(2,evenement.getDate_debut());
				ps.setString(3,evenement.getDate_fin());
				ps.setString(4,evenement.getNom());
				ps.setString(5,evenement.getDescription());
				ps.setInt(6,evenement.getId());
				ps.executeUpdate();
		}catch(Exception ignored){}
	}
	@Override
	public List<Evenement> afficher(){
		try{
				ResultSet rs = db.createStatement().executeQuery("SELECT * FROM Evenement");
				List<Evenement> evenements = new ArrayList<>();
				while(rs.next()){
						evenements.add(new Evenement(rs.getInt("id"),rs.getInt("prix"),rs.getString("date_debut"),rs.getString("date_fin"),rs.getString("nom"),rs.getString("description")));
				}
				return evenements;
		}catch(Exception ignored){return null;}
	}

	@Override
	public void supprimer(Evenement evenement){
		try{
				 PreparedStatement ps = db.prepareStatement("DELETE FROM EVENEMENT WHERE ID = ? ");
				 ps.setInt(1,evenement.getId());
				ps.executeUpdate();
		}catch(Exception ignored){}
	}
	}