/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.souklemdina.entities.User;
import com.souklemdina.services.UserService;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Nihel
 */
public class Authentification {
    public static User connectedUser;
    Form f;
    Container icon;
    Container data;
    TextField email;
    TextField password;
    SpanButton login;
    SpanButton reset;
    SpanButton fb;
    Label img;
    String role;
    Integer userId;
    public Authentification(Resources theme){
        
        f = new Form(BoxLayout.y());
        icon = new Container();
        data = new Container();
        email = new TextField();
        email.setHint("Email");
        password = new TextField();
        password.setHint("Password");
        password.setConstraint(TextField.PASSWORD);
        login = new SpanButton("LOGIN");
        fb = new SpanButton("Facebook Connect");
        reset = new SpanButton("RESET");
        reset.addActionListener(e->{
        email.clear();
        password.clear();
        });
        //email.setDisabledStyle(TextField.);
        img = new Label(theme.getImage("log.png"));
        icon.add(img);
        data.add(email);
        data.add(password);
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
             ConnectionRequest con = new ConnectionRequest();
                String name = email.getText();
                String pswd = password.getText();
               
              
                
                con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/login?email="+name+"&password="+pswd);
               
                con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                         try {
                    String json=new String(con.getResponseData());
                      JSONParser j = new JSONParser();
                              
                    Map<String, Object> users = j.parseJSON(new CharArrayReader(json.toCharArray())); 
                              System.out.println("roleeeee"+users.get("id")+users.get("nom"));
                              
                              
                              //connectedUser = new User();
//                              UserService us = new UserService();
//                              connectedUser = us.GetUserById(userId);
                              System.out.println(userId + "allalala");
                    if(users.get("password").equals("0")) 
                        {
                          Dialog.show("Erreur d'authentification", "Verifier votre Nom d'utilisateur ou mot de passe!!", "OK", "Annuler");

                         }
                    else {
                        
                        connectedUser = new User();
                            userId = (int)Float.parseFloat(users.get("id").toString());
                            UserService us = new UserService();
                            connectedUser=us.GetUserById(userId);
                            System.out.println("rolee"+connectedUser.getRole());
                        if (connectedUser.getRole().equalsIgnoreCase("[ROLE_MEMBER, ROLE_USER]"))
                        {
                            
                            ToolBarCustom tbs = new ToolBarCustom();
                            
                            Home h = new Home();
                            h.setF(tbs.Customize(h.getF()));
                            h.getF().show();
                        }else{
                            ToolBarCustom tbs = new ToolBarCustom();
                            ArtisanHome h = new ArtisanHome();
                            h.setF(tbs.Customize(h.getF()));
                            h.getF().show();
                        }
                    
                    }
                    
                } catch (IOException ex) {
                }   
                 }
                });
                     NetworkManager.getInstance().addToQueue(con);
                      
            }
        });
        
        fb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            }
        });
        
        data.add(login);
        data.add(reset);
        
        Label reg = new Label("Register ?");
        reg.addPointerPressedListener(e->{
        Register h = new Register(theme);
        h.getF().show();
        
        });
      
        data.add(reg);
        f.add(icon);
        f.add(data);
        UserService us = new UserService();
        System.out.println("lé");
        us.GetUserById(2);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public User getConnectedUser() {
        return connectedUser;
    }

    public void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }
    
    
}
