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
import com.souklemdina.entities.Promotion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jskka
 */
public class ProduitPromotionService {
    int idProduitPromo;
    Promotion p = new Promotion();
    String json;
    ArrayList<Promotion> listPromotion;
 
    public ArrayList<Promotion> AllProductsPromotion(String json) {

        listPromotion = new ArrayList<>();
        try {

            JSONParser j = new JSONParser();

            Map<String, Object> Promotions = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println("produittttttttttt" + Promotions);

            List<Map<String, Object>> list = (List<Map<String, Object>>) Promotions.get("root");
            for (Map<String, Object> obj : list) {
                Promotion p = new Promotion();
//                idProduitPromo = ((int) (Float.parseFloat(obj.get("id").toString())));
//                ProduitService ps =new ProduitService();
//                ArrayList<Produit> produitList = ps.GetProdactById(idProduitPromo);
                
                
                p.setId((int) (Float.parseFloat(obj.get("id").toString())));
//                p.getP().setCategorie(obj.get("categorie").toString());
//
//                p.getP().setDescription(obj.get("description").toString());
//                p.getP().setTitre(obj.get("titre").toString());
//
//                p.getP().setPhoto(obj.get("image").toString());
//                p.getP().setIda((int) (Float.parseFloat(obj.get("idartisan").toString())));
//                p.getP().setPrix(Float.parseFloat((obj.get("prix").toString())));
//                p.getP().setQuantite((int) (Float.parseFloat(obj.get("quantite").toString())));
                listPromotion.add(p);
                System.out.println("listppp" + listPromotion);
            }

        } catch (IOException ex) {
        }
        return listPromotion;

    }
    ArrayList<Promotion> listp = new ArrayList<>();

    public ArrayList<Promotion> getList1() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/all/promotions");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitPromotionService per = new ProduitPromotionService();

                String json = new String(con.getResponseData());
                System.out.println("response datat   " + json);
                listp = per.AllProductsPromotion(json);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listp;
    }
    
}
