/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

/**
 *
 * @author jskka
 */
public class Promotion {
    
    int id ; 
    int idp ; 
    float taux ;
    Produit p ;
    

    public Promotion() {
    
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public Produit getP() {
        return p;
    }
    

    public Promotion(int idp, float taux) {
        this.idp = idp;
        this.taux = taux;
    }

    public int getId() {
        return id;
    }

    public int getIdp() {
        return idp;
    }

    public float getTaux() {
        return taux;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

   
    
    
}
