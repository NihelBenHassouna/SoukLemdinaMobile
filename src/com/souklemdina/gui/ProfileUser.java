/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Calendar;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import static com.souklemdina.gui.Authentification.connectedUser;

/**
 *
 * @author Nihel
 */
public class ProfileUser {

    Form f;
    Container all;
    Container data;
    Container info;
    Container tab1, tab2;
    Tabs profil;
    Tabs abonnement;
    Tabs tab;
    Label nom, prenom, email, adresse, aboButton;

    public ProfileUser() {
        //Déclaration
        f = new Form();
        nom = new Label();
        prenom = new Label();
        email = new Label();
        adresse = new Label();
        profil = new Tabs();
        tab = new Tabs();
        tab1 = new Container(BoxLayout.y());
        tab2 = new Container(BoxLayout.y());
        all = new Container(BoxLayout.y());
        data = new Container(BoxLayout.x());
        info = new Container(BoxLayout.y());
        
        //Image du profil
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(50, 50, 0xffff0000), false);
        URLImage background = URLImage.createToStorage(placeholder, "userProfile.jpg", connectedUser.getImage());
        //background.fetch();
        ImageViewer myPic = new ImageViewer();
        myPic.setImage(background);

        //Tab
        profil.setAnimateTabSelection(true);
        tab.getAllStyles().setBgColor(0xffffff);
        tab.addTab("Information", tab1);
        tab.addTab("Abonnement", tab2);

        //User informations
        nom.setText(connectedUser.getNom());
        prenom.setText(connectedUser.getPrenom());
        info.add(nom).add(prenom);
        data.add(myPic);
        data.add(info);
        
        
        //User abonnement list
        tab2.add(new Label("abo"));
        
        //Form add
        f.add(data);
        f.add(tab);
        f.add(profil);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
