/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.souklemdina.entities.Produit;
import com.souklemdina.entities.ProduitsPanier;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Panier {
    
    Database db;
    
    
     public Container addItem() {
         try{
         db=Database.openOrCreate("souklemdina");
            Cursor c=db.executeQuery("select * from ProduitPanier where idUser="+Home.ConnectedUser);
        while(c.next())
                {
                    Row row=c.getRow();
                    int id=row.getInteger(0);
                    int idProduit =row.getInteger(1);
                    System.out.println("id:"+id);
                }}
         catch(IOException ex)
         {}
         
        Label titre = new Label();
        Label categorie = new Label();
        Label prix = new Label();


        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        
        cnt2.add(prix);
        
        cnt2.add(cnt1);
        return cnt2;
    }
    
}
