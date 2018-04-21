/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.souklemdina.entities.Produit;
import com.souklemdina.services.ProduitService;
import java.util.ArrayList;

/**
 *
 * @author Nihel
 */
public class Home {
    Form f;
    Produit p = new Produit();
    SpanLabel lb;

    public Home(){
        f = new Form(BoxLayout.y());
    
        
         lb = new SpanLabel("");
         
        f.add(lb);
        ProduitService ps =new ProduitService();
        lb.setText(ps.getList2().toString());
      
        
     
        ;

        
    }
    
        
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
