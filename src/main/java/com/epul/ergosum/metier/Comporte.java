package com.epul.ergosum.metier;

/**
 * Created by benoitvuillemin on 14/04/2015.
 */
public class Comporte {
    private int annee;
    private int numero;
    private int quantite;
    private int quantite_distribuee;
    private int difference;

    public Comporte() {
        this.annee = 0;
        this.numero = 0;
        this.quantite = 0;
        this.quantite_distribuee = 0;
        this.difference = 0;
    }

    public Comporte(int annee, int numero, int quantite) {
        this.annee = annee;
        this.numero = numero;
        this.quantite = quantite;
        this.quantite_distribuee = 0;
        this.difference = quantite;
    }

    public Comporte(int annee, int numero, int quantite, int quantite_distribuee) {
        this.annee = annee;
        this.numero = numero;
        this.quantite = quantite;
        this.quantite_distribuee = quantite_distribuee;
        this.difference = quantite - quantite_distribuee;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
        this.difference = quantite - quantite_distribuee;
    }

    public int getQuantite_distribuee() {
        return quantite_distribuee;
    }

    public void setQuantite_distribuee(int quantite_distribuee) {
        this.quantite_distribuee = quantite_distribuee;
        this.difference = quantite - quantite_distribuee;
    }

    public int getDifference() {
        return difference;
    }
}
