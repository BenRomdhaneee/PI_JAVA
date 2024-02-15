package com.esprit.tests;

import com.esprit.models.Commande;
import com.esprit.models.Resto;
import com.esprit.services.CommandeService;
import com.esprit.services.RestoService;

public class MainProg {

    public static void main(String[] args) {

        CommandeService ps = new CommandeService();
       RestoService pss = new RestoService();
     // pss.ajouter(new Resto(9,"lilo","lilo",23142627));
       // pss.modifier(new Resto(4,"zero","zz",2));
       //pss.supprimer(new Resto(2,"nidhallllllllll","zz",2));
   ps.ajouter(new Commande( 2,4,"LILO","LILO","LILO","LILO","LILO" ));
  // ps.supprimer(new Commande(7, 2,"Med","26562536","Ruuuuuuuuuue","sandwitch","aa"));
     // ps.modifier(new Commande(21, 4, "tyty","Tyty","33356755","bb","test"));
     // System.out.println(ps.afficher());
     //   PersonneService2 ps2 = new PersonneService2();
  //      ps2.ajouter(new Personne("Fedi2", "Naoufel"));
       // ps.afficher();
    }
}
