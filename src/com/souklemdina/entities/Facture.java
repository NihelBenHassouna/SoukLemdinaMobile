/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

/**
 *
 * @author Farouk
 */
public class Facture {

    private int id ;
    
    private String nom;
    private String prenom;
    private String Adresse;
    private int phone;
    private String email;
    private String username;
    private String produit;
    private float Prix;

    public Facture() {
    }

    public Facture(int id, String nom, String prenom, String Adresse, int phone, String email, String username, String produit, float Prix) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.Adresse = Adresse;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.produit = produit;
        this.Prix = Prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Facture{" + "nom=" + nom + ", prenom=" + prenom + ", Adresse=" + Adresse + ", phone=" + phone + ", email=" + email + ", username=" + username + ", produit=" + produit + ", Prix=" + Prix + '}';
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getProduit() {
        return produit;
    }

    public float getPrix() {
        return Prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public void setPrix(float Prix) {
        this.Prix = Prix;
    }

    
}
