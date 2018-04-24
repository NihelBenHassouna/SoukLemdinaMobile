/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.souklemdina.entities.Produit;
import com.souklemdina.services.ProduitService;
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
    Label titre;
    Label prix;
    Label image ;
    Label categorie;
    Label quantite;
    Label description;
    ConnectionRequest connectionRequest;
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
        titre = new Label(p.getTitre());
        categorie = new Label(p.getCategorie());
        prix = new Label(p.getPrix().toString());
        image = new Label(p.getPhoto().toString());
                Label label = new Label();

                 Button btn = new Button("detail produit");
 int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
                                Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
                                EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
                                label.setIcon(URLImage.createToStorage(encImage,
                                        "Large_" + "http://localhost/SoukLemdinaPiDev/web/uploads/images/"+p.getPhoto()+
                                                "", "http://localhost/SoukLemdinaPiDev/web/uploads/images/"+p.getPhoto()+
                                                        "", URLImage.RESIZE_SCALE_TO_FILL));
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(btn);
        cnt1.add(prix);
        cnt1.add(label);

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

        
        titre = new Label(p.getTitre());
        categorie = new Label(p.getCategorie());
        prix = new Label(p.getPrix().toString());
        description = new Label(p.getDescription().toString());
        Label label = new Label();
         int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
                                Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
                                EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
                                label.setIcon(URLImage.createToStorage(encImage,
                                        "Large_" + "http://localhost/SoukLemdinaPiDev/web/uploads/images/"+p.getPhoto()+
                                                "", "http://localhost/SoukLemdinaPiDev/web/uploads/images/"+p.getPhoto()+
                                                        "", URLImage.RESIZE_SCALE_TO_FILL));
        Button btnn = new Button("Ajout produit");
        btnn.addActionListener(e->{
        AddProduct ap = new AddProduct();
        ap.getF().show();
        });
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(description);
        cnt1.add(prix);
        cnt1.add(label);
        cnt1.add(btnn);
        cnt2.add(cnt1);
       f.add(cnt2);
       
        return f ;

    }

}
