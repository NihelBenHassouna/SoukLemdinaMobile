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

    public Form Customize(Form f, Resources theme) {
        
           f.getToolbar().addCommandToSideMenu("Souk Lemdina", theme.getImage("text.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                

            }
        });

        f.getToolbar().addCommandToSideMenu("Home", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                

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

                

            }
        });
        return f;
    }
}
