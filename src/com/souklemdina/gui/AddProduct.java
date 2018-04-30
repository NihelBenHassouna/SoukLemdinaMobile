/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.SpanButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.souklemdina.entities.Produit;
import static com.souklemdina.gui.Authentification.connectedUser;

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
    SpanButton ajouter;
    Produit p= new Produit();

    public AddProduct() {
       

        f = new Form();
         ToolBarCustom tbs = new ToolBarCustom();
        f = tbs.Customize(f);
//        labelContainer = new Container(BoxLayout.y());
//        textFieldsContainer = new Container(BoxLayout.y());
//        data = new Container(BoxLayout.x());
//        titre = new Label("Titre");
//        description = new Label("Description");
//        prix = new Label("Prix");
//        categorie = new Label("Categorie");
//        quantite = new Label("quantité");
//        titreTextField = new TextField();
//        prixTextField= new TextField();
//        categorieTextField= new TextField();
//        quantiteTextField= new TextField();
//        descriptionTextField= new TextField();
//        
//        p.setTitre(titreTextField.getText());
//        p.setDescription(descriptionTextField.getText());
//        p.setCategorie(categorieTextField.getText());
//        p.setPrix(null);
//        p.setQuantite(10);
//        p.setIda(38);
//    labelContainer.add(titre).add(description).add(prix).add(quantite).add(categorie).add(ajouter);
//        textFieldsContainer.add(titreTextField).add(descriptionTextField).add(prixTextField).add(quantiteTextField).add(categorieTextField);
//        data.add(labelContainer);
//        data.add(textFieldsContainer);
//        f.add(data);
//
//        ajouter = new SpanButton("Ajouter");
//        ajouter.addActionListener(e-> {
//            connectionRequest=new ConnectionRequest();
//            connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/add/produit?titre=" + p.getTitre()+ "&categorie="+p.getCategorie()+
//                "&prix="+p.getPrix()+"&description="+p.getDescription()+"&quantite="+p.getQuantite()+"&ida="+p.getIda());
//        System.out.println("fucking ajout" + p.toString());
//            connectionRequest.addResponseListener((evt) -> {
//                    System.out.println("fucking ajout");
//            Dialog.show("Ajout evenement", "ajout avec succes", "OK",null);
//            Home h = new Home();
//            h.getF().show();
//            
//            });
//         NetworkManager.getInstance().addToQueue(connectionRequest);
//           
//            
//        });
       
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
        TextField image=new TextField("", "image",20,TextField.ANY);
        
                  f.add(image);

         Button valider=new Button("Valider");
         f.add(valider);
         
//f.setToolbar(new Toolbar());
//Style s = UIManager.getInstance().getComponentStyle("Title");
//FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
//
//ImageViewer iv = new ImageViewer(icon);
//        
//f.getToolbar().addCommandToRightBar("", icon, (ev) -> {
//    Display.getInstance().openGallery((e) -> {
//        if(e != null && e.getSource() != null) {
//            try {
//                DefaultListModel<Image> m = (DefaultListModel<Image>)iv.getImageList();
//                Image img = Image.createImage((String)e.getSource());
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
      
         valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            connectionRequest=new ConnectionRequest();
            connectionRequest.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/add/produit/" 
                    +quantite.getText()+ '/'+image.getText()+
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