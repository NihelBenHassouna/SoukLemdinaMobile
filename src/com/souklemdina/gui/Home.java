/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;

import com.codename1.db.Database;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.souklemdina.entities.Produit;
import com.souklemdina.entities.User;
import static com.souklemdina.gui.Authentification.connectedUser;
import com.souklemdina.services.ProduitService;

import java.io.IOException;

import com.souklemdina.services.UserService;

import java.util.ArrayList;

/**
 *
 * @author Nihel
 */
 public class Home {
    public static  int NB_PRODUIT;
    User user;
    Form f;
    Produit p = new Produit();
    SpanLabel lb;
    Label test;

    Database db;
    

    Label titre;
    Label prix;

    Label image;

    Label categorie;
    TextField quantitePanier;
    Label quantite;
    Label description;
    Label artisan;
    ConnectionRequest connectionRequest;
    Resources theme;
    Button AddToCart;


    public Home() {
        theme = UIManager.initFirstTheme("/theme");
        f = new Form(BoxLayout.y());
        Container cnt = new Container();
        test = new Label();
        lb = new SpanLabel("");

        ProduitService ps = new ProduitService();
        ArrayList<Produit> l = ps.getList2();
        for (int i = 0; i < l.size(); i++) {
             NB_PRODUIT=l.size();
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
                "Large_" + "http://localhost/SoukLemdinaPiDev/web/uploads/images/" + p.getPhoto()
                + "", "http://localhost/SoukLemdinaPiDev/web/uploads/images/" + p.getPhoto()
                + "", URLImage.RESIZE_SCALE_TO_FILL));

        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(label);
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(prix);
        

        cnt1.add(btn);


        cnt2.add(cnt1);
        cnt2.setLeadComponent(btn);


        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent l) {
                //  ToolBarCustom tbs = new ToolBarCustom();
              
                Info(p).show();
            }

        });
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
        quantitePanier = new TextField();
        UserService us = new UserService();
        int id = p.getIda();
        user = new User();
        user = us.GetUserById(id);
        artisan = new Label(user.getNom());
        artisan.addPointerPressedListener(e->{
        OtherProfile op = new OtherProfile(user);
        

         Label titre = new Label(p.getTitre());
        Label categorie = new Label(p.getCategorie());
        Label prix = new Label(p.getPrix().toString());
        Label description = new Label(p.getDescription().toString());
        TextField quantitePanier=new TextField();
       // TextField quantitePanier= new TextField();
        
        System.out.println(p.getId());
        



        op.getF().show();
        });
        Label label = new Label();

        int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
        Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        label.setIcon(URLImage.createToStorage(encImage,
                "Large_" + "http://localhost/SoukLemdinaPiDev/web/uploads/images/" + p.getPhoto()
                + "", "http://localhost/SoukLemdinaPiDev/web/uploads/images/" + p.getPhoto()
                + "", URLImage.RESIZE_SCALE_TO_FILL));

        Button btnn = new Button("Ajout produit");
        btnn.addActionListener(e -> {
            ToolBarCustom tbs = new ToolBarCustom();
            AddProduct ap = new AddProduct();
            ap.setF(tbs.Customize(ap.getF()));
            ap.getF().show();
        });
        
   

        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(description);
        cnt1.add(prix);
        cnt1.add(quantitePanier); 
        
    Button AddToCart=new Button("Add To Cart");
AddToCart.addActionListener((l)->{
   try{ System.out.println(quantitePanier.getText());
   db= Database.openOrCreate("souklemdina");
             db.execute("insert into ProduitPanier (nomProduit,idUser,quantite,prix)values('"+p.getTitre()+"','"+Authentification.connectedUser.getId()+"','"+Integer.parseInt(quantitePanier.getText())+"','"+p.getPrix()+"');");
   System.out.println("done!!");
   }
              
              catch(IOException ex){
                  System.out.println(ex);}
});
        //cnt1.add(quantite);
        
        cnt1.add(AddToCart);

        //cnt1.add(artisan);
       // cnt1.add(label);
        //cnt1.add(btnn);

        cnt2.add(cnt1);
        f.add(cnt2);

        return f;

    }

}
