/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.souklemdina.entities.Produit;
import com.souklemdina.entities.ProduitsPanier;
import static com.souklemdina.gui.Authentification.connectedUser;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Panier {
    ConnectionRequest connectionRequest;
    Form f = new Form();
         ToolBarCustom tbs = new ToolBarCustom();
       
    Database db;
    int id=0;
                    String nomProduit ;
                    int quantite =0;
                    double prix=0 ;
                    double Total=0 ;
                     double Totalp=0 ;
                    
                    Label idp= new Label();
                    Label nomProduip =new Label();
                     Label prixx =new Label();
                      Label quantitee =new Label();
                      Label TotalPrix  =new Label();
                      Container cnt = new Container(BoxLayout.y());
    
     public Panier() {
         try{
         db=Database.openOrCreate("souklemdina");
            Cursor c=db.executeQuery("select * from ProduitPanier where idUser="+Authentification.connectedUser.getId()+";");
        //f.add("id");
         Container cnt1 = new Container(BoxLayout.x());
          
        cnt1.add("Produit");
        
       cnt1.add("Prix");
       cnt1.add("Quantite");
       cnt.add(cnt1);
       
       //f.add(cnt1);
       
        while(c.next())
                {
                    Row row=c.getRow();
                    //id=row.getInteger(1);
                     System.out.println(id+"user");
                    //Label idp= new Label();
                    //idp.setText(Integer.toString(id));
                    nomProduit =row.getString(2);
                    quantite =row.getInteger(3);
                     prix = row.getDouble(4);
                     Totalp=Totalp+(row.getDouble(4)*row.getInteger(3));
                    System.out.println("produit:"+nomProduit+"prix"+prix);
                    Label nomProduip = new Label();
         nomProduip.setText(nomProduit);
        Label prixx= new Label();
        prixx.setText(Double.toString(prix));
        Label quantitee= new Label();
        quantitee.setText(Integer.toString(quantite));
          Label TotalPrix= new Label();
          TotalPrix.setText(Double.toString(Total));
        Container cnt2 = new Container(BoxLayout.x());
              //f.add(idp);
        cnt2.add(nomProduip);
        
       cnt2.add(prixx);
       cnt2.add(quantitee);
       cnt.add(cnt2);
     
                    
          
                }}
         catch(IOException ex)
         {
             System.out.println(ex);         
         }
        
  cnt.add("Total");
  Total=Total+Totalp;
        cnt.add(Double.toString(Total));
      
       f.add(cnt);
       Button validerachat=new Button("Valider Achat");
       validerachat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            connectionRequest=new ConnectionRequest();
            connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/Valider/panier/" 
                    +Authentification.connectedUser.getId()+ '/'+Total);
            connectionRequest.addResponseListener((NetworkEvent evtl) -> {
            Dialog.show("Ajout Panier", "ajout avec succes", "OK",null);
            Home h = new Home();
            h.getF().show();
            
            });
         NetworkManager.getInstance().addToQueue(connectionRequest);
            }
        });

        
      // f.add(cnt3);
       f.add(validerachat);
       // f.add(cnt2);
    }
     
           
     
       public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
