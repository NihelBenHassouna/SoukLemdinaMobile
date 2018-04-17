/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

import java.util.List;

/**
 *
 * @author jskka
 */
public class Produit {

    private String categorie;
    private String titre;
    private String description;
    private Float prix;
    private String photo;
    private int id;
    private int ida;
    private int quantite;

    public Produit() {
    }

   

    public Produit(String categorie, String titre, String description, Float prix, String photo, int quantite) {
        this.categorie = categorie;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
        this.quantite = quantite;
    }

    public String getCategorie() {
        return categorie;
    }

    

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrix() {
        return prix;
    }

    

    public String getPhoto() {
        return photo;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

   
    public void setIda(int ida) {
        this.ida = ida;
    }

    public int getIda() {
        return ida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String descriptio) {
        this.description = descriptio;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    
    
    
}
