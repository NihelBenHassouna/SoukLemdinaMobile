/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.souklemdina.entities.Produit;
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
    
   public Produit GetProdactById(Integer id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/all/produit");

        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                json = new String(con.getResponseData());
                ArrayList<Produit> List = AllProducts(json);

                for (Produit x : List) {
                    if (x.getId() == id) {
                        p = x;
                    }
                }
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return p;

    }
    public ArrayList<Produit> AllProducts(String json) {
        ArrayList<Produit> listProduit = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> Produits = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(Produits);

            List<Map<String, Object>> list = (List<Map<String, Object>>) Produits.get("root");

            for (Map<String, Object> obj : list) {
                Produit p = new Produit();
                p.setId((int)(Float.parseFloat(obj.get("id").toString())));
                p.setCategorie(obj.get("categorie").toString());
                p.setDescription(obj.get("description").toString());
              
                //p.setPhoto(obj.get("photo").toString());
                p.setIda((int)(Float.parseFloat(obj.get("idartisan").toString())));
                p.setPrix(Float.parseFloat((obj.get("prix").toString())));
                p.setQuantite((int)(Float.parseFloat(obj.get("quantite").toString())));
                listProduit.add(p);

            }

        } catch (IOException ex) {
        }
        return  listProduit;

    }
    ArrayList<Produit> listp = new ArrayList<>();

  public ArrayList<Produit> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/all/produit");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitService per = new ProduitService();
                listp = per.AllProducts(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listp;
    }   
}
