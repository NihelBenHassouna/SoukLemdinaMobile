/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.souklemdina.entities.Produit;
import static com.souklemdina.gui.Authentification.connectedUser;
import com.souklemdina.services.ProduitService;
import java.io.IOException;
import rest.file.uploader.tn.FileUploader;


//import rest.file.uploader.tn.FileUploader;


/**
 *
 * @author Nihel
 */
public class AddProduct {
    ConnectionRequest connectionRequest;
    Form f;
    Container labelContainer;
    Container textFieldsContainer;
    Container data;
    Label titre;
    Label prix;
    Label categorie;
    Label quantite;
    Label description;
    TextField titreTextField;
    TextField prixTextField;
    TextField categorieTextField;
    TextField quantiteTextField;
    TextField descriptionTextField;
    ImageViewer image;
    SpanButton ajouter;
    Button choose ; 
    Produit p= new Produit();
    public static String path;

    public AddProduct()  {
       

        f = new Form();
         ToolBarCustom tbs = new ToolBarCustom();
        f = tbs.Customize(f);

       
         TextField titre = new TextField("","titre",20,TextField.ANY);
         f.add(titre);
         TextField description = new TextField("","description",20,TextField.ANY);
         f.add(description);
         TextField categorie = new TextField("","categorie",20,TextField.ANY);
         f.add(categorie);
         TextField prix=new TextField("", "prix",20,TextField.ANY);
         f.add(prix);
         TextField quantite=new TextField("", "quantité",20,TextField.ANY);
         f.add(quantite);
                 choose=new Button("choose image");

                 f.add(choose);
        image =new ImageViewer();
        
                  f.add(image);

choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ProduitService s=new ProduitService();
           s.browseImage(image);
          
            }
        });
                  
                  
                  
                  Button valider=new Button("Valider");
         f.add(valider);
        


//         f.setToolbar(new Toolbar());
//Style s = UIManager.getInstance().getComponentStyle("Title");
//FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
//
//ImageViewer iv = new ImageViewer(icon);
//
//f.getToolbar().addCommandToRightBar("", icon, (ev) -> {
//    Display.getInstance().openGallery((e) -> {
// 
//        if(e != null && e.getSource() != null) {
//            try {
//                DefaultListModel<Image> m = (DefaultListModel<Image>)iv.getImageList();
//                Image img = Image.createImage((String)e.getSource());
//                System.out.println(e.getSource()+"source");
//                path = (String)e.getSource();
//                
//                int last =path.lastIndexOf("/");
//                String finalPath= path.substring(last+1, path.length());
//                System.out.println("IMAGE   "+finalPath);
//                System.out.println("image path"+path);
//                image.setText(finalPath);
//                if(m == null) {
//                    m = new DefaultListModel<>(img);
//                    iv.setImageList(m);
//                    iv.setImage(img);
//                    System.out.println(img.getImage().toString()+ "hhhhhhhhhhhhhhhhhhhhhh");
//                } else {
//                    m.addItem(img);
//                }
//                m.setSelectedIndex(m.getSize() - 1);
//            } catch(IOException err) {
//                Log.e(err);
//            }
//        }
//    }, Display.GALLERY_IMAGE);
//
//});
// FileUploader fu = new FileUploader("localhost/SoukLemdinaPiDev/web/");
//        try {
//            String ss= fu.upload(path);
//            System.out.println(ss+"loooooooooool");
//        } catch (Exception ex) {
//        }      

         valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            connectionRequest=new ConnectionRequest();
                System.out.println(path+" last chance");
            connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/add/produit/" 
                    +quantite.getText()+ '/'+image.getImage().getImageName()+
                    '/'+description.getText()+'/'+categorie.getText()+'/'+titre.getText()+'/'+prix.getText()+'/'+connectedUser.getId());
            connectionRequest.addResponseListener((NetworkEvent evtl) -> {
            Dialog.show("Ajout produit", "ajout avec succes", "OK",null);
            Home h = new Home();
            h.getF().show();
            
                
                        });
         NetworkManager.getInstance().addToQueue(connectionRequest);
            }
        });

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   

}
