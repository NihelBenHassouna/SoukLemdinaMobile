/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Label;

/**
 *
 * @author Nihel
 */
public class ArtisanHome {
    Form f;
    public ArtisanHome(){
        f = new Form();
        f.add(new Label("Artisan"));
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
