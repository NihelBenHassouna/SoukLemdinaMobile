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
public class Commentaire {
    
    int id ;
    int idpc ;
    String emailUser;
    String text ;
    Produit p ;

    public Commentaire() {
    }

    public Commentaire(int idpc,String emailUser ,String text) {
        this.idpc = idpc;
        this.text = text;
        this.emailUser = emailUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdpc(int idpc) {
        this.idpc = idpc;
    }

    public String getemailUser() {
        return emailUser;
    }

    public void setemailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    
    
    public int getId() {
        return id;
    }

    public int getIdpc() {
        return idpc;
    }

    public String getText() {
        return text;
    }

    public Produit getP() {
        return p;
    }
     


    
    
}
