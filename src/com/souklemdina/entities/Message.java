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
public class Message {
    
    private int id ;
    private int idEnv ;
    private int idRes ;
    private String contenu ;

    public Message() {
    }

    public Message(int id, int idEnv, int idRes, String contenu) {
        this.id = id;
        this.idEnv = idEnv;
        this.idRes = idRes;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public int getIdEnv() {
        return idEnv;
    }

    public int getIdRes() {
        return idRes;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEnv(int idEnv) {
        this.idEnv = idEnv;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", idEnv=" + idEnv + ", idRes=" + idRes + ", contenu=" + contenu + '}';
    }
    
    
    
}
