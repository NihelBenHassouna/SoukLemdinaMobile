/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.db.Database;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Commande {
     ConnectionRequest connectionRequest;
    Form f = new Form();
         ToolBarCustom tbs = new ToolBarCustom();
         String textAttachmentUri;
         String imageAttachmentUri;
       
    Database db;
    
    public Commande(){
    
        Button commander= new Button("Commander");
        commander.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            connectionRequest=new ConnectionRequest();
            connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/Commander/commande/" 
                    +Authentification.connectedUser.getId()+ '/'+Authentification.connectedUser.getId());
            try{
            db= Database.openOrCreate("souklemdina");
             db.execute("delete from ProduitPanier where idUser="+Authentification.connectedUser.getId()+";");
   System.out.println("deleted!!");}
            
            
            
            catch(IOException ex)
            {
                System.out.println(ex);
            }
  try {
  //String value = Capture.capturePhoto(Display.getInstance().getDisplayWidth() / 2, -1);
  //if(value != null) {
    //Label image = new Label(Image.createImage(value));
    Message msg = new Message("");
    //msg.setAttachment(value);
    //showForm("MainMenu", null);
    Display.getInstance().sendMessage(new String[] {"nihel.hajri@esprit.tn"}, "Commande Souklemdina", msg);
  }
  /*else
  {
    System.out.println("User canceled.");
    genericDialog("Camera Capture Info", "User canceled capture.");
    showForm("MainMenu", null);
  }*/
 catch (Exception ex) {}
            

            
            connectionRequest.addResponseListener((NetworkEvent evtl) -> {
            Dialog.show("Commande affectué", "", "OK",null);
            Home h = new Home();
            h.getF().show();
            
            });
         NetworkManager.getInstance().addToQueue(connectionRequest);
            }
        }
         );
         f.add(commander);
    
    
    }
    
    
    
    
        public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
    
}
