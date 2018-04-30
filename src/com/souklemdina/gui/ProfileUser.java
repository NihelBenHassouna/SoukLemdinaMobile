/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import static com.souklemdina.gui.Authentification.connectedUser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Nihel
 */
public class ProfileUser {

    Form f;
    Container all;
    Container data;
    Container info;
    Container tab1, tab2;
    Tabs profil;
    Tabs abonnement;
    Tabs tab;
    Label nom, prenom, email, adresse, aboButton;
    Resources theme;
    Container x;
    Container x1;
    Container x2;
    Container y;
    Map<String, Object> result;
    Map<String, Object> level1;
    Map<String, Object> level2;
    Map<String, Object> level3;
    Map<String, Object> level4;
    ArrayList<Double> rest;

    public ProfileUser() {
        
        try {
            //Déclaration
            theme = UIManager.initFirstTheme("/theme");
            f = new Form();
            nom = new Label();
            prenom = new Label();
            email = new Label();
            adresse = new Label();
            profil = new Tabs();
            tab = new Tabs();
            tab1 = new Container(BoxLayout.y());
            tab2 = new Container(BoxLayout.y());
            all = new Container(BoxLayout.y());
            data = new Container(BoxLayout.x());
            info = new Container(BoxLayout.y());
            aboButton = new Label(theme.getImage("heart.png").scaled(50, 50));
            //Image du profil
            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(50, 50, 0xffff0000), false);
            URLImage background = URLImage.createToStorage(placeholder, "userProfile.jpg", connectedUser.getImage());
            //background.fetch();
            ImageViewer myPic = new ImageViewer();
            myPic.setImage(background);

            //Tab
            profil.setAnimateTabSelection(true);
            tab.getAllStyles().setBgColor(0xffffff);
            tab.addTab("Information", tab1);
            tab.addTab("Abonnement", tab2);

            //User informations
            nom.setText(connectedUser.getNom());
            prenom.setText(connectedUser.getPrenom());
            info.add(nom).add(prenom);
            data.add(myPic);
            data.add(info);

            //User Information tab
            x = new Container(new BoxLayout(BoxLayout.X_AXIS));
            x1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            x2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label mail = new Label("Email");
            Label phone = new Label("Phone");
            Label adresse = new Label("Adresse");

            x.add(mail).add(new Label(connectedUser.getEmail()));
            x1.add(adresse).add(new Label(connectedUser.getAdresse()));

            y.add(x);
            y.add(x1);
            //User abonnement list
           
            String adress = connectedUser.getAdresse();
            String adressPlaceId = searchLocations(adress);
            ArrayList<Double> latlong = GetLongLat(adressPlaceId);
            Double destinationLat = latlong.get(0);
            Double destinationLng = latlong.get(1);
            LocationManager locationManager = LocationManager.getLocationManager();
            Location location = locationManager.getCurrentLocation();
            Double originLat = location.getLatitude();
            Double originLng = location.getLongitude();
           
            BrowserComponent browser = new BrowserComponent();
            browser.setScrollVisible(false);
            browser.setURL("http://localhost/SoukLemdinaPiDev/web/app_dev.php/api/map?originLat=36.8942449&originLng=10.2762523&destinationLat="+destinationLat+"&destinationLng="+destinationLng);
            browser.setScrollable(false);
            y.add(browser);
             tab1.add(y);
            
            //browser.setURL("http://"+WebService.ip+"/pidev2/web/app_dev.php/covoiturage/api/map?departid=" + cov.getDepart_id() + "&destinationid=" + cov.getDestination_id());
            f.add(data);
            f.add(tab);
            f.add(profil);
//        } catch (IOException ex) {
//
//        }
        } catch (IOException ex) {
            
        }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    String searchLocations(String text) {
        try {
            if (text.length() > 0) {
                ConnectionRequest r = new ConnectionRequest();
                r.setPost(false);
                r.setUrl("https://maps.googleapis.com/maps/api/place/autocomplete/json");
                r.addArgument("key", "AIzaSyCO7IzgeQg0TI-XT2HZl3AQ_T4whs9A4AI");
                r.addArgument("input", text);
                NetworkManager.getInstance().addToQueueAndWait(r);
                Map<String, Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(r.getResponseData()), "UTF-8"));

                ArrayList places = new ArrayList<>();
                places = (ArrayList) (result.get("predictions"));

                Map<String, Object> finale = (Map<String, Object>) places.get(0);
                String placeId = (String) finale.get("place_id");
                ArrayList<Double> test = GetLongLat(placeId);

                return placeId;

//                String[] res = Result.fromContent(result).getAsStringArray("//description");
//                return res;
            }
        } catch (Exception err) {
            Log.e(err);
        }
        return null;
    }

    public ArrayList<Double> GetLongLat(String placeId) {
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeId + "&key=AIzaSyCO7IzgeQg0TI-XT2HZl3AQ_T4whs9A4AI");

        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {

                    result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(con.getResponseData()), "UTF-8"));

//                    System.out.println("level 1" +level1);
                    level1 = (Map) result.get("result");
                    level2 = (Map) level1.get("geometry");
                    level3 = (Map) level2.get("location");
                    double lat = (double) level3.get("lat");
                    double lng = (double) level3.get("lng");
                    rest = new ArrayList<>();
                    rest.add(lat);
                    rest.add(lng);

                } catch (IOException ex) {

                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return rest;

    }

}
