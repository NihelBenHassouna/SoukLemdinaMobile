/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.services;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.File;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.ImageIO;
import com.codename1.util.Base64;
import com.souklemdina.entities.Produit;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jskka
 */
public class ProduitService {

    Produit p = new Produit();
    String json;
    ArrayList<Produit> listProduit;

    public void ajoutTask(Produit p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/add/produit?titre=" + p.getTitre() + "&categorie=" + p.getCategorie()
                + "&prix=" + p.getPrix() + "&description=" + p.getDescription() + "&quantite=" + p.getQuantite() + "&ida=" + p.getIda();
        con.setUrl(Url);

        System.out.println("AJOUTEEEEEEEEEEE");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<Produit> GetProdactById(Integer id) {
        listProduit = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/all/produitartisant/" + id);

        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                json = new String(con.getResponseData());
                ArrayList<Produit> List = AllProducts(json);

                for (Produit x : List) {
                    if (x.getIda() == id) {
                        p = x;
                    }
                }
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listProduit;

    }

    public ArrayList<Produit> AllProducts(String json) {

        listProduit = new ArrayList<>();
        try {

            JSONParser j = new JSONParser();

            Map<String, Object> Produits = j.parseJSON(new CharArrayReader(json.toCharArray()));
            

            List<Map<String, Object>> list = (List<Map<String, Object>>) Produits.get("root");

            for (Map<String, Object> obj : list) {
                Produit p = new Produit();
                p.setId((int) (Float.parseFloat(obj.get("id").toString())));
                p.setCategorie(obj.get("categorie").toString());
                System.out.println("cat" + p.getCategorie());
                p.setDescription(obj.get("description").toString());
                p.setTitre(obj.get("titre").toString());

                p.setPhoto(obj.get("image").toString());
                p.setIda((int) (Float.parseFloat(obj.get("idartisan").toString())));
                p.setPrix(Float.parseFloat((obj.get("prix").toString())));
                p.setQuantite((int) (Float.parseFloat(obj.get("quantite").toString())));
                listProduit.add(p);
                System.out.println("listppp" + listProduit);
            }

        } catch (IOException ex) {
        }
        return listProduit;

    }
    ArrayList<Produit> listp = new ArrayList<>();

    public ArrayList<Produit> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/all/produit");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitService per = new ProduitService();

                String json = new String(con.getResponseData());
                System.out.println("response datat   " + json);
                listp = per.AllProducts(json);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listp;
    }

    public void setImage(String filePath, ImageViewer iv) {
        try {
            //creation d'image apartir du filepath
            Image i1 = Image.createImage(filePath).scaled(400, 400);
            iv.setImage(i1);
            if (i1 != null) {
                   //FileSystemStorage  
                //trodek tnajm testoki l image en binaire
                ImageIO imgIO = ImageIO.getImageIO();
                //stocker l'inage dans le flux
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                imgIO.save(i1, out, File.separator, 1);
                //recuperer l image du flux dans un tab binaire
                byte[] ba = out.toByteArray();
                //cryptage de l image binaire
                String Imagecode = Base64.encode(ba);
                ConnectionRequest request = new ConnectionRequest();
                request.addResponseListener((NetworkEvent evt) -> {
                    byte[] data = (byte[]) evt.getMetaData();
                    String imageName = new String(data);
                    System.out.println("metadata " + imageName);
                    iv.getImage().setImageName(imageName);
                });
                request.setPost(true);
                request.setHttpMethod("POST");
                // imagecode sequence binaire de l image coder
                request.addArgument("Image", Imagecode);
                request.setUrl("http://localhost:80/Upload.php");
                NetworkManager.getInstance().addToQueueAndWait(request);
            } else {
                System.out.println("Unable to upload");
            }
            iv.getParent().revalidate();

        } catch (Exception ex) {

        }

    }

    public void browseImage(ImageViewer im) {
        //open gallery
        Display.getInstance().openGallery((ActionListener) (ActionEvent ev) -> {

            if (ev != null && ev.getSource() != null) {
                String filePath = (String) ev.getSource();
                // retenue de nom d'image
//             int fileNameIndex = filePath.lastIndexOf("/") + 1;
//             String fileName = filePath.substring(fileNameIndex);
                // Do something

                setImage(filePath, im);
            }
        }, Display.GALLERY_IMAGE);

    }
}
