/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

/**
 *
 * @author Nihel
 */
public class Abonnement {
    public int idMembre;
    public  int idArtisan;

    public Abonnement(int idMembre, int idArtisan) {
        this.idMembre = idMembre;
        this.idArtisan = idArtisan;
    }

    public Abonnement() {
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdArtisan() {
        return idArtisan;
    }

    public void setIdArtisan(int idArtisan) {
        this.idArtisan = idArtisan;
    }
    
    
    
}
