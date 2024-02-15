package com.esprit.services;

import com.esprit.models.Commande;

import com.esprit.utils.DataSource;

import java.sql.*;
import java.util.*;

public class CommandeService implements IService<Commande> {

    private Connection connection;

    public CommandeService() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void ajouter(Commande Commande) {
        String req = "INSERT into commande(nomC, prenomC,numC,adresseC,descriptionC,idResto) values ('" + Commande.getNomC() + "','" + Commande.getPrenomC() + "', '" + Commande.getNumC() + "', '" + Commande.getAdresseC() + "', '" + Commande.getDescriptionC() + "', '" + Commande.getIdResto() + "');";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("commande ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void modifier(Commande commande) {
        String req = "UPDATE commande set nomC = '" + commande.getNomC() + "', prenomC = '" + commande.getPrenomC()  + "', numC = '" + commande.getNumC() + "', adresseC= '" + commande.getAdresseC() +"', idResto = '" + commande.getIdResto()+  "', descriptionC = '" + commande.getDescriptionC()+"' where id_commande = " + commande.getId_commande() + ";";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void supprimer(Commande commande) {
        String req = "DELETE from commande where id_commande = " + commande.getId_commande() + ";";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande supprmiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Commande> afficher() {
        List<Commande> commandes = new ArrayList<>();

        String req = "SELECT c.* , r.nomR from commande c LEFT JOIN resto  r ON c.idResto = r.id_resto ";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                commandes.add(new Commande(rs.getInt("id_commande"),rs.getInt("idResto"),rs.getString("nomC"), rs.getString("prenomC"), rs.getString("numC"), rs.getString("adresseC"), rs.getString("descriptionC")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(commandes);
        return commandes;
    }




}
