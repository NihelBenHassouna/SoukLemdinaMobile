/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.souklemdina.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author Nihel
 */
public class Evenement {
    private int id;
    private String label;
    private String description;
    private int nbPlace;
    private float prix;
    private String localisation;
    private Time duree;
    private String image;
    private Date dateDebut;
    private Date dateFin;

    public Evenement() {
    }

    public Evenement(int id, String label, String description, int nbPlace, float prix, String localisation, Time duree, String image, Date dateDebut, Date dateFin) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.nbPlace = nbPlace;
        this.prix = prix;
        this.localisation = localisation;
        this.duree = duree;
        this.image = image;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Evenement(String label, String description, int nbPlace, float prix, String localisation, Time duree, String image, Date dateDebut, Date dateFin) {
        this.label = label;
        this.description = description;
        this.nbPlace = nbPlace;
        this.prix = prix;
        this.localisation = localisation;
        this.duree = duree;
        this.image = image;
        this.dateDebut = dateDebut;
        this.dateFin=dateFin;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", label=" + label + ", description=" + description + ", nbPlace=" + nbPlace + ", prix=" + prix + ", localisation=" + localisation + ", duree=" + duree + ", image=" + image + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    } 
    
    
    
}
