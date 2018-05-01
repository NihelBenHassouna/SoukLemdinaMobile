/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.db.Database;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Form;

/**
 *
 * @author DELL
 */
public class Commande {
    ConnectionRequest connectionRequest;
    Form f = new Form();
         ToolBarCustom tbs = new ToolBarCustom();
       
    Database db;
    
    
    
    
    
    
        public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
    
}
