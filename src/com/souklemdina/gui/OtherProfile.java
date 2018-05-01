/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;

import com.codename1.ui.Tabs;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.souklemdina.entities.User;
import static com.souklemdina.gui.Authentification.connectedUser;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Nihel
 */
public class OtherProfile {

    Form f;
    Container all;
    Container data;
    Container info;
    Container tab1, tab2;
    Tabs profil;
    Tabs abonnement;
    Tabs tab;
    Label nom, prenom, email, adresse;
    public static int targetUserId;
    Resources theme;
    Button aboButton;
      
    public OtherProfile(User user) {
        theme = UIManager.initFirstTheme("/theme");
        f = new Form();
        nom = new Label(user.getNom() + " - " + user.getEmail());
        aboButton = new Button("abo", theme.getImage("heart.png"));

        targetUserId = user.getId();
        aboButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                System.out.println("eyyyyyy");
                ConnectionRequest con = new ConnectionRequest();

                con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/abo?idM=" + connectedUser.getId() + "&idA=" + targetUserId);
                System.out.println("here1");
                con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        System.out.println("here2");
                        String json = new String(con.getResponseData());
                        JSONParser j = new JSONParser();
                        System.out.println("here3");
                        Map<String, Object> abos = null;
                        try {
                            abos = j.parseJSON(new CharArrayReader(json.toCharArray()));
                            System.out.println("here4");
                        } catch (IOException ex) {
                            // Logger.getLogger(OtherProfile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("tesst ABOOOO " + abos.toString());

                    }

                });
                NetworkManager.getInstance().addToQueue(con);
            }

        });

        f.add(nom);

        f.add(aboButton);

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
