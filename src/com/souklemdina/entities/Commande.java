/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

import java.sql.Date;


/**
 *
 * @author Farouk
 */
public class Commande {

    private int id;
    private int idUser;
    private int idPanier;
    private Date date;
    private boolean etat = false;
    
    

    
     public Commande() {
    
     }
     
    public Commande(int idUser, int panier, Date date, float prix,boolean etat) {
        this.idUser = idUser;
        this.idPanier = panier;
        this.date = date;
        this.etat = etat;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int panier) {
        this.idPanier = panier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    
   

}
