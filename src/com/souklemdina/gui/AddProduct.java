/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Calendar;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.souklemdina.entities.Produit;
import com.souklemdina.services.ProduitService;

/**
 *
 * @author Nihel
 */
public class AddProduct {
    ConnectionRequest connectionRequest;
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
    Produit p;
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
        p = new Produit();
        p.setTitre(titreTextField.getText());
        p.setDescription(descriptionTextField.getText());
        p.setCategorie(categorieTextField.getText());
        p.setPrix(null);
        p.setQuantite(10);
        p.setIda(38);
        ajouter = new SpanButton("Ajouter");
        ajouter.addActionListener(e-> {

            connectionRequest=new ConnectionRequest();
            connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/add/produit?id="+10+"titre=" + titreTextField.getText()+ "&categorie="+categorieTextField.getText()+"&prix="+p.getPrix()+"&description="+p.getDescription()+"&quantite="+p.getQuantite()+"&ida="+p.getIda());
        System.out.println("fucking ajout" + p.toString());
            connectionRequest.addResponseListener((evt) -> {
                    System.out.println("fucking ajout");
            Dialog.show("Ajout evenement", "ajout avec succes", "OK",null);
            Home h = new Home();
            h.getF().show();
            
            });
         NetworkManager.getInstance().addToQueue(connectionRequest);
           
            
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
