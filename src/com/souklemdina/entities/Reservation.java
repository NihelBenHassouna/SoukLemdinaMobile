/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

/**
 *
 * @author Souhir
 */
public class Reservation {
    private int id;
    private int id_user;
    private int id_evenement;
    private int nbplace_Res;

    public Reservation() {
        
    }

    public Reservation(int id_user, int id_evenement) {
        this.id_user = id_user;
        this.id_evenement = id_evenement;
    }
    

    public Reservation(int id, int id_user, int id_evenement, int nbplace_Res) {
        this.id = id;
        this.id_user = id_user;
        this.id_evenement = id_evenement;
        this.nbplace_Res = nbplace_Res;
    }

    public Reservation(int id_user, int id_evenement, int nbplace_Res) {
        this.id_user = id_user;
        this.id_evenement = id_evenement;
        this.nbplace_Res = nbplace_Res;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_User() {
        return id_user;
    }

    public void setId_User(int id_user) {
        this.id_user = id_user;
    }

    public int getId_Evenement() {
        return id_evenement;
    }

    public void setId_Evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getNbplace_Res() {
        return nbplace_Res;
    }

    public void setNbplace_Res(int nbplace_Res) {
        this.nbplace_Res = nbplace_Res;
    }
    
    
}
