/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.souklemdina.entities.Produit;
import com.souklemdina.services.ProduitService;
import java.util.ArrayList;

/**
 *
 * @author Nihel
 */
public class ProductDetails {
    Form f;
    Produit p = new Produit();
    SpanLabel lb;
    Label test;

    public ProductDetails() {
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


        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt2.add(prix);
        
        cnt2.add(cnt1);
        return cnt2;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
