/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

/**
 *
 * @author DELL
 */
public class Panier { 
    
    private int id;
    private int idUser;
    private float prixTotal;

    public Panier() {
    }

    public Panier(int id, float prixTotal,int idUser) {
        this.id = id;
        this.prixTotal = prixTotal;
        this.idUser= idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
    
    
}
