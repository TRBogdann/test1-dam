package com.example.trascau_teodor_bogdan_1101;

import java.io.Serializable;

public class Factura implements Serializable {
    long codClient;
    String categorie;
    float suma;
    String descriere;

    public Factura(long codClient, String categorie, float suma, String descriere) {
        this.codClient = codClient;
        this.categorie = categorie;
        this.suma = suma;
        this.descriere = descriere;
    }

    @Override
    public String   toString() {
        return "Factura{" +
                "codClient=" + codClient +
                ", categorie='" + categorie + '\'' +
                ", suma=" + suma +
                ", descriere='" + descriere + '\'' +
                '}';
    }

    public Factura()
    {
        this.codClient = 10001;
        this.categorie = "unk";
        this.suma =0.0f;
        this.descriere = "";
    }

    public float getSuma() {
        return suma;
    }

    public long getCodClient() {
        return codClient;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setCodClient(long codClient) {
        this.codClient = codClient;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }
}
