package com.example.blooddonation;

public class User {
    String adresse, group_sanguin, nom_prénom, numero_phone, surl;

    User(){

    }
    public User(String adresse, String group_sanguin, String nom_prénom, String numero_phone, String surl) {
        this.adresse = adresse;
        this.group_sanguin = group_sanguin;
        this.nom_prénom = nom_prénom;
        this.numero_phone = numero_phone;
        this.surl = surl;

    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setGroup_sanguin(String group_sanguin) {
        this.group_sanguin = group_sanguin;
    }

    public void setNom_prénom(String nom_prénom) {
        this.nom_prénom = nom_prénom;
    }

    public void setNumero_phone(String numero_phone) {
        this.numero_phone = numero_phone;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getAdresse() {
        return adresse;
    }


    public String getGroup_sanguin() {
        return group_sanguin;
    }

    public String getNom_prénom() {
        return nom_prénom;
    }

    public String getNumero_phone() {
        return numero_phone;
    }

    public String getSurl() {
        return surl;
    }

}