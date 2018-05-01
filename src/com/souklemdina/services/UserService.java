/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.souklemdina.entities.Abonnement;
import com.souklemdina.entities.User;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author Nihel
 */
public class UserService {

    User user;
    ConnectionRequest connectionRequest;
    Map<String, Object> abos;

    public User GetUserById(int id) {

        connectionRequest = new ConnectionRequest();
        connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/get/user?id=" + id);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                try {
                    user = new User();
                    String res = new String(connectionRequest.getResponseData());
                    JSONParser j = new JSONParser();

                    Map<String, Object> User = j.parseJSON(new CharArrayReader(res.toCharArray()));
                    //Map<String, Object> User = (Map<String, Object>) users.get("root");
                    //System.out.println(User.get("root").toString());

                    String email = User.get("email").toString();
                    int id = (int) Float.parseFloat(User.get("id").toString());
                    String nom = User.get("nom").toString();
                    String prenom = User.get("prenom").toString();
                    String role = User.get("roles").toString();
                    String adresse = User.get("adresse").toString();

                    user.setEmail(email);
                    String img = "http://localhost/pidev/profileimages/" + email + ".png";
                    user.setAdresse(adresse);
                    user.setNom(nom);
                    user.setPrenom(prenom);
                    user.setId(id);
                    user.setRole(role);
                    user.setImage(img);

                } catch (IOException ex) {

                }
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);

        return user;

    }

    public void addAbo(Abonnement a) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/add/abo?idartisan=" + a.getIdArtisan() + "&idmembre=" + a.getIdMembre();
        con.setUrl(Url);

        System.out.println("AJOUTEEEEEEEEEEE");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public boolean IsAbo(int idMembre, int idArtisan) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/abo?idM=" + idMembre + "&idA=" + idArtisan);
        con.addResponseListener((NetworkEvent evt) -> {
            String json = new String(con.getResponseData());
            JSONParser j = new JSONParser();

            try {
                abos = j.parseJSON(new InputStreamReader(new ByteArrayInputStream(con.getResponseData()), "UTF-8"));

            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueue(con);
        return false;
    }
    
    public void Desabo(int idm, int ida){
          ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/desabo?idm="+idm+"&ida="+ida);
        con.addResponseListener((NetworkEvent evt) -> {
            String json = new String(con.getResponseData());
            JSONParser j = new JSONParser();

            try {
                abos = j.parseJSON(new InputStreamReader(new ByteArrayInputStream(con.getResponseData()), "UTF-8"));

            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueue(con);
    }

}
