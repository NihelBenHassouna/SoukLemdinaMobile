/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Nihel
 */
public class Register {
    Form f;
    Container icon;
    Container data;
    TextField email;
    TextField nom;
    TextField prenom;
    TextField phone;
    TextField adresse;
    TextField password;
    SpanButton register;
    SpanButton reset;
    Label img;
    TextField confirmPassword;

    public Register(Resources theme) {
        f = new Form();
        icon = new Container();
        data = new Container();
        email = new TextField();
        password= new TextField();
        adresse = new  TextField();
        phone= new TextField();
        nom = new TextField();
        prenom = new TextField();
        register = new SpanButton("Register");
        
        reset = new SpanButton("Reset");
        reset.addActionListener(e->{
        email.clear();
        nom.clear();
        prenom.clear();
        password.clear();
        confirmPassword.clear();
        adresse.clear();
        phone.clear();
        });
        confirmPassword = new TextField();
        nom.setHint("Nom");
        prenom.setHint("Prenom");
        email.setHint("email");         
        password.setHint("password");
        confirmPassword.setHint("Confirm password");
        confirmPassword.setConstraint(TextField.PASSWORD);
        password.setConstraint(TextField.PASSWORD);
        adresse.setHint("Adresse");
        phone.setHint("Phone");
        data.add(nom).add(prenom).add(email).add(password).add(confirmPassword).add(register).add(reset);
        f.add(icon);
        f.add(data);
    }

    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
}
