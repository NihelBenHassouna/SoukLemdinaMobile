/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.souklemdina.entities.User;
import static com.souklemdina.gui.Authentification.connectedUser;
import com.souklemdina.services.UserService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    Resources theme;
    Container x;
    Container x1;
    Container x2;
    Container y;
   
    public ProfileUser() {

       
            //Déclaration
            theme = UIManager.initFirstTheme("/theme");
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
            aboButton = new Label(theme.getImage("heart.png").scaled(50, 50));
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

            //User Information tab
            x = new Container(new BoxLayout(BoxLayout.X_AXIS));
            x1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            x2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label mail = new Label("Email");
            Label phone = new Label("Phone");
            Label adresse = new Label("Adresse");

            x.add(mail).add(new Label(connectedUser.getEmail()));
            x1.add(adresse).add(new Label(connectedUser.getAdresse()));

            y.add(x);
            y.add(x1);
            //User abonnement list

            

            ConnectionRequest con = new ConnectionRequest();
            con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/get/abo?idM=" + connectedUser.getId());
            con.addResponseListener((NetworkEvent e) -> {
                try {
                    String json = new String(con.getResponseData());
                    JSONParser j = new JSONParser();
                    
                    
                    HashMap<String, Object> abos = (HashMap) j.parseJSON(new InputStreamReader(new ByteArrayInputStream(con.getResponseData()), "UTF-8"));
                    System.out.println(abos);
                    // Map<String, Object> test = (Map) abos.get("root");

                    ArrayList<Object> test = (ArrayList<Object>) abos.get("root");
                    for(int i=0; i<test.size();i++){
                        Map<String, Object> artisan = (Map) test.get(i);
                        System.out.println(artisan.get("idartisan"));
                        Map<String, Object> last = (Map) artisan.get("idartisan");
                        
                        int id = (int) Float.parseFloat(last.get("id").toString());
                        System.out.println(id);
                        User u = new User();
                        UserService us = new UserService();
                        u = us.GetUserById(id);
                        Container cnt = new Container();
                        cnt = follower(u);
                        tab2.add(cnt);
                    }
                } catch (IOException ex) {
                 //   Logger.getLogger(ProfileUser.class.getName()).log(Level.SEVERE, null, ex);
                
                } 

            });
            NetworkManager.getInstance().addToQueue(con);

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

   
    public Container follower(User u){
        Container cnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container data = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label name = new Label(u.getNom()+" "+u.getPrenom());
        Label email = new Label(u.getEmail());
        data.add(name).add(email);
        Label photo = new Label(theme.getImage("follow.png").scaled(30, 30));
        Label desabo = new Label(theme.getImage("cancel1.png").scaled(15, 15));
        desabo.addPointerPressedListener(e->{
        UserService us = new UserService();
        us.Desabo(connectedUser.getId(), u.getId());
        ProfileUser p = new ProfileUser();
        p.getF().show();
        });
        cnt.add(photo).add(data).add(desabo);
        return cnt;
    }

}
