/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.ui.CN;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import static com.souklemdina.gui.Authentification.connectedUser;

/**
 *
 * @author Nihel
 */
public class ToolBarCustom {

    public Form f;
    Toolbar tb;

    public ToolBarCustom() {
        this.f = new Form();

    }

    public Form Customize(Form f) {
        
           f.getToolbar().addCommandToSideMenu("Souk Lemdina", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                

            }
        });

        f.getToolbar().addCommandToSideMenu("Home", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                ToolBarCustom tbs = new ToolBarCustom();
                Home h = new Home();
                h.setF(tbs.Customize(h.getF()));
                h.getF().show();

            }
        });
        f.getToolbar().addCommandToSideMenu("Mon Panier", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                

            }
        });
        
        f.getToolbar().addCommandToSideMenu("Messages", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                   
                


                
            }
        });
        
         f.getToolbar().addCommandToSideMenu("Profil", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ToolBarCustom tbs = new ToolBarCustom();
                ProfileUser pf = new ProfileUser();
                pf.setF(tbs.Customize(pf.getF()));
                pf.getF().show();

            }
        });
         if (connectedUser.getRole().equalsIgnoreCase("[ROLE_ARTISAN, ROLE_USER]")){
         f.getToolbar().addCommandToSideMenu("ajouter produit", null, new ActionListener() {
                

            @Override
            public void actionPerformed(ActionEvent evt) {
             ToolBarCustom tbs = new ToolBarCustom();
               AddProduct ap = new AddProduct();
               ap.setF(tbs.Customize(ap.getF()));
        ap.getF().show();
                
            }
        });
          f.getToolbar().addCommandToSideMenu("statistique", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ToolBarCustom tbs = new ToolBarCustom();
             Statistic s = new Statistic();
             s.setF(tbs.Customize(s.getF()));
             s.createPieChartForm().show();
                

            }
        });
          f.getToolbar().addCommandToSideMenu("MyProduit", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                   ToolBarCustom tbs = new ToolBarCustom();
                ProduitArtisant pa = new ProduitArtisant();
                pa.setF(tbs.Customize(pa.getF()));
                pa.getF().show();
                


                
            }
        });
         }
        return f;
    }

    
    public void setF(Form f) {
        this.f = f;
    }

    
    public Form getF() {
        return f;
    }
    
}
