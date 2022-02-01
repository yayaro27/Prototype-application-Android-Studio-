package com.example.tuto;


public class Challenge {
    private String nom;
    private String description;
    private String image;
    public Challenge (){}
    public Challenge (String nom, String description,String img){
        this.nom = nom;
        this.description =description;
        this.image = img;
    }
    public String getImage() { return "http://192.168.0.17/challengeMCA/img/"+this.image;
    }

    public void setImage(String nom) {
        this.image = nom;
    }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
