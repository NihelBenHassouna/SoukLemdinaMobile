/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

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
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.souklemdina.entities.Produit;
import com.souklemdina.services.ProduitService;
import java.util.ArrayList;

/**
 *
 * @author jskka
 */
public class ProduitArtisant {
    Form f ;
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
    TextField taux = new TextField("","taux%",20,TextField.ANY);
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
       
    public ProduitArtisant(){
                f = new Form(BoxLayout.y());
                Container cnt = new Container();


    ProduitService ps = new ProduitService();
        ArrayList<Produit> l = ps.GetProdactById(2);
        for (int i = 0; i < l.size(); i++) {

            
            cnt.add(addItem(l.get(i)));
            
        }
        f.add(cnt);
    
}
    
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
        cnt1.add(label);
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(prix);
         cnt1.add(btn);
         


        cnt2.add(cnt1);
        cnt2.setLeadComponent(btn);

        btn.addActionListener((l)->{
                        Info(p).show();

        });
        return cnt2;
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
        Button btnn = new Button("Supprimer Produit");
        btnn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent o) {

                    Dialog d = new Dialog();

                    if (Dialog.show("Confirmation", "delete this product??", "Ok", "Annuler")) {
                        ConnectionRequest req = new ConnectionRequest();

                        req.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/delete/"
                                + p.getId());
                        NetworkManager.getInstance().addToQueue(req);
                        Dialog.show("Suppression", "Produit "+p.getTitre()+" a été supprimé avec succès!", "OK",null);
                       Home h = new Home();
                       h.getF().show();
                       
                    }
                }
              });
         Button pro = new Button("Ajouter une promotion");
        pro.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent o) {

                     connectionRequest=new ConnectionRequest();
            connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/add/promotion/"+taux.getText()+"/"+p.getId());
            connectionRequest.addResponseListener((NetworkEvent evtl) -> {
            Dialog.show("Ajout promotion", "ajout avec succes", "OK",null);
            Home h = new Home();
            h.getF().show();
            
            });
         NetworkManager.getInstance().addToQueue(connectionRequest);
                }
              });
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(titre);
        cnt1.add(categorie);
        cnt1.add(description);
        cnt1.add(prix);
        cnt1.add(label);
        cnt1.add(btnn);
        cnt1.add(taux);
         cnt1.add(pro);
        cnt2.add(cnt1);
       f.add(cnt2);
       
        return f ;

    }
}
