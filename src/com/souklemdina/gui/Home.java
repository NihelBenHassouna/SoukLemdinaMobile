/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.db.Database;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.souklemdina.entities.Produit;
import com.souklemdina.services.ProduitService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nihel
 */
public class Home {

    Form f;
    Produit p = new Produit();
    SpanLabel lb;
    Label test;
    Database db;

    public Home() {
        f = new Form(BoxLayout.y());
Container cnt = new Container();
        test = new Label();
        lb = new SpanLabel("");

        ProduitService ps = new ProduitService();
        ArrayList<Produit> l = ps.getList2();
        for (int i = 0; i < l.size(); i++) {

            
            cnt.add(addItem(l.get(i)));
            
        }
        f.add(cnt);

    }

//fonction traja3 container yekhou produit en parametre w kol mara 3aytelha hne    
    public Container addItem(Produit p) {
        Label titre = new Label(p.getTitre());
        Label categorie = new Label(p.getCategorie());
        Label prix = new Label(p.getPrix().toString());
                 Button btn = new Button("detail produit");


        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(btn);
        cnt2.add(prix);
        btn.addActionListener((l)->{
            Info(p).show();
        });
        cnt2.setLeadComponent(btn);
        cnt2.add(cnt1);
        return cnt2;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    private Form Info(Produit p) {
       Form f = new Form();

        
         Label titre = new Label(p.getTitre());
        Label categorie = new Label(p.getCategorie());
        Label prix = new Label(p.getPrix().toString());
        Label description = new Label(p.getDescription().toString());
        TextField quantite= new TextField();
        
        System.out.println(p.getId());
        
Button AddToCart=new Button("Add To Cart");
AddToCart.addActionListener((l)->{
   try{ System.out.println(quantite.getText());
   db= Database.openOrCreate("souklemdina");
             db.execute("insert into ProduitPanier (idProduit,quantite,prix)values('"+p.getId()+"','"+Integer.parseInt(quantite.getText())+"','"+p.getPrix()+"');");
   System.out.println("done!!");
   }
              
              catch(IOException ex){
                  System.out.println(ex);}
});

        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(description);
        cnt1.add(prix);
        cnt1.add(quantite);
        cnt1.add(AddToCart);
        cnt2.add(cnt1);
       f.add(cnt2);
        return f ;

    }

}
