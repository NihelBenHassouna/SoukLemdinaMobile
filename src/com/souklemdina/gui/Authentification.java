/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Nihel
 */
public class Authentification {
    Form f;
    Container icon;
    Container data;
    TextField email;
    TextField password;
    SpanButton login;
    SpanButton reset;
    Label img;
    
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
        reset = new SpanButton("RESET");
        reset.addActionListener(e->{
        email.clear();
        password.clear();
        });
        //email.setDisabledStyle(TextField.);
        img = new Label(theme.getImage("log.png"));
        icon.add(BoxLayout.X_AXIS, img);
        data.add(email);
        data.add(password);
        data.add(login);
        data.add(reset);
        f.add(icon);
        f.add(data);
    }

    public Form getF() {
        return f;
    }
}
