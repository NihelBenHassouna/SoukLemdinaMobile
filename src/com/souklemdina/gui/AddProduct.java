/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Calendar;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.souklemdina.entities.Produit;
import com.souklemdina.services.ProduitService;

/**
 *
 * @author Nihel
 */
public class AddProduct {

    Form f;
    Container labelContainer;
    Container textFieldsContainer;
    Container data;
    Label titre;
    Label prix;
    Label categorie;
    Label quantite;
    Label description;
    TextField titreTextField;
    TextField prixTextField;
    TextField categorieTextField;
    TextField quantiteTextField;
    TextField descriptionTextField;
    SpanButton ajouter;
    
    public AddProduct() {
        f = new Form();
        labelContainer = new Container(BoxLayout.y());
        textFieldsContainer = new Container(BoxLayout.y());
        data = new Container(BoxLayout.x());
        titre = new Label("Titre");
        description = new Label("Description");
        prix = new Label("Prix");
        categorie = new Label("Categorie");
        quantite = new Label("quantité");
        titreTextField = new TextField();
        prixTextField= new TextField();
        categorieTextField= new TextField();
        quantiteTextField= new TextField();
        descriptionTextField= new TextField();
        Produit p = new Produit();
        p.setTitre(titreTextField.getText());
        p.setDescription(descriptionTextField.getText());
        p.setCategorie(categorieTextField.getText());
        p.setPrix(null);
        p.setQuantite(10);
        p.setIda(38);
        ajouter = new SpanButton("Ajouter");
        ajouter.addActionListener(e->{
        ProduitService ps = new ProduitService();
        ps.ajoutTask(p);
            System.out.println("AJOUTER MOTHER FUCKER");
        });
        labelContainer.add(titre).add(description).add(prix).add(quantite).add(categorie).add(ajouter);
        textFieldsContainer.add(titreTextField).add(descriptionTextField).add(prixTextField).add(quantiteTextField).add(categorieTextField);
        data.add(labelContainer);
        data.add(textFieldsContainer);
        f.add(data);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
