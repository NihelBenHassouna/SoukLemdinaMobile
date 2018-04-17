/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

import java.sql.Date;


/**
 *
 * @author Nihel
 */
public class User {
    public String nom;
    public String prenom;
    public String username;
    public String email;
    public String role;
    public String password;
    public Date birth_date;
    public int phone;
    public String adresse;
    public String image;
    
    public User(String nom, String prenom, String username, String email, String role, String password, Date birth_date, int phone, String adresse,String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
        this.birth_date = birth_date;
        this.phone = phone;
        this.adresse = adresse;
        this.image = image;
    }


    
    /*
    
    
    
    public User(String nom, String prenom, String username, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    

    
    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(String nom, String prenom, String email,String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public User(String nom, String prenom, String username, String email, String password, String birth_date, int phone, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
        this.phone = phone;
        this.adresse = adresse;
    }
*/
    public User() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}