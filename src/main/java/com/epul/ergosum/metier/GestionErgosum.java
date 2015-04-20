package com.epul.ergosum.metier;

import com.epul.ergosum.meserreurs.MonException;
import com.epul.ergosum.persistance.DialogueBd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by benoitvuillemin on 23/03/2015.
 */
public class GestionErgosum {

    // par défault qui liste tous les jouets sans critères
    public List<Jouet> listerTousLesJouets() throws MonException {
        List<Object> rs;
        List<Jouet> mesJouets = new ArrayList<Jouet>();
        int index = 0;
        String mysql;

        mysql = "SELECT a.numero, a.codecateg, a.codetranche, a.libelle, b.libcateg, c.agemin, c.agemax\n" +
                "FROM jouet a, categorie b, trancheage c\n" +
                "where a.codecateg = b.codecateg\n" +
                "and a.codetranche = c.codetranche";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Jouet unJ = new Jouet();
            // il faut redecouper la liste pour retrouver les lignes
            unJ.setNumero(rs.get(index).toString());
            unJ.setCategorie(new Categorie(rs.get(index + 1).toString(), rs.get(index + 4).toString(), null));
            unJ.setTrancheage(new Trancheage(rs.get(index + 2).toString(), Integer.valueOf(rs.get(index + 5).toString()), Integer.valueOf(rs.get(index + 6).toString()), null));
            unJ.setLibelle(rs.get(index + 3).toString());
            // On incr�mente tous les 7 champs
            index = index + 7;
            mesJouets.add(unJ);
        }

        return mesJouets;

    }

    public List<Categorie> listerToutesLesCategories() throws MonException {
        List<Object> rs;
        List<Categorie> mesCategories = new ArrayList<Categorie>();
        int index = 0;
        String mysql;

        mysql = "SELECT * FROM categorie";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Categorie uneC = new Categorie();
            // il faut redecouper la liste pour retrouver les lignes
            uneC.setCodecateg(rs.get(index).toString());
            uneC.setLibcateg(rs.get(index + 1).toString());
            // On incr�mente tous les 2 champs
            index = index + 2;
            mesCategories.add(uneC);
        }

        return mesCategories;

    }

    public List<Trancheage> listerToutesLesTranches() throws MonException {
        List<Object> rs;
        List<Trancheage> mesTranches = new ArrayList<Trancheage>();
        int index = 0;
        String mysql;

        mysql = "SELECT * FROM trancheage";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Trancheage uneT = new Trancheage();
            // il faut redecouper la liste pour retrouver les lignes
            uneT.setCodetranche(rs.get(index).toString());
            uneT.setAgemin(Integer.valueOf(rs.get(index + 1).toString()));
            uneT.setAgemax(Integer.valueOf(rs.get(index + 2).toString()));
            // On incr�mente tous les 3 champs
            index = index + 3;
            mesTranches.add(uneT);
        }

        return mesTranches;

    }

    public List<Catalogue> listerTousLesCatalogues() throws MonException {
        List<Object> rs;
        List<Catalogue> mesCatalogues = new ArrayList<Catalogue>();
        int index = 0;
        String mysql;

        mysql = "SELECT * FROM catalogue";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Catalogue unC = new Catalogue();
            // il faut redecouper la liste pour retrouver les lignes
            unC.setAnnee(Integer.valueOf(rs.get(index).toString()));
            unC.setQuantiteDistribuee(Integer.valueOf(rs.get(index + 1).toString()));
            // On incr�mente tous les 2 champs
            index = index + 2;
            mesCatalogues.add(unC);
        }

        return mesCatalogues;

    }

    public Jouet rechercherJouet(String id) throws MonException {
        List<Object> rs;

        String mysql;

        mysql = "SELECT * FROM jouet " +
                "WHERE NUMERO =" + id;

        rs = DialogueBd.lecture(mysql);

        Jouet monJouet = new Jouet();
        if (rs.size() != 0) {
            monJouet.setNumero(rs.get(0).toString());
            monJouet.setCategorie(new Categorie(rs.get(1).toString()));
            monJouet.setTrancheage(new Trancheage(rs.get(2).toString()));
            monJouet.setLibelle(rs.get(3).toString());
        }


        return monJouet;
    }

    public Categorie rechercherCategorie(String codeCategorie) throws MonException {
        List<Object> rs;

        String mysql;

        mysql = "SELECT * FROM categorie WHERE CODECATEG = " + codeCategorie;

        rs = DialogueBd.lecture(mysql);

        Categorie maCategorie = new Categorie();
        if (rs.size() != 0) {
            maCategorie.setCodecateg(rs.get(0).toString());
            maCategorie.setLibcateg(rs.get(1).toString());
        }


        return maCategorie;
    }

    public Trancheage rechercherTrancheage(String codetranche) throws MonException {
        List<Object> rs;

        String mysql;

        mysql = "SELECT * FROM trancheage " +
                "WHERE CODETRANCHE =" + codetranche;

        rs = DialogueBd.lecture(mysql);

        Trancheage maTranche = new Trancheage();
        if (rs.size() != 0) {
            maTranche.setCodetranche(rs.get(0).toString());
            maTranche.setAgemin(Integer.valueOf(rs.get(1).toString()));
            maTranche.setAgemax(Integer.valueOf(rs.get(2).toString()));
        }

        return maTranche;
    }

    public Catalogue rechercherCatalogue(String codecatalogue) throws MonException {
        List<Object> rs;

        String mysql;

        mysql = "SELECT * FROM catalogue " +
                "WHERE ANNEE =" + codecatalogue;

        rs = DialogueBd.lecture(mysql);
        Catalogue monCatalogue = new Catalogue();
        if (rs.size() != 0) {
            monCatalogue.setAnnee(Integer.valueOf(rs.get(0).toString()));
            monCatalogue.setQuantiteDistribuee(Integer.valueOf(rs.get(1).toString()));
        }

        return monCatalogue;
    }

    public void modifier(Jouet unJouet) throws MonException {

        String mysql;

        mysql = "UPDATE jouet " +
                "SET CODECATEG = " + unJouet.getCategorie().getCodecateg() +
                ", CODETRANCHE = " + unJouet.getTrancheage().getCodetranche() +
                ", LIBELLE = " + "\'" + unJouet.getLibelle() + "\'" +
                " WHERE NUMERO = " + unJouet.getNumero();
        DialogueBd.insertionBD(mysql);
    }

    public void ajouter(Jouet unJouet, Comporte c) throws MonException {

        String mysql;

        mysql = "INSERT INTO jouet (NUMERO, CODECATEG, CODETRANCHE, LIBELLE) " +
                " VALUES ( \'" + unJouet.getNumero() + "\', \'" + unJouet.getCategorie().getCodecateg() +
                "\', \'" + unJouet.getTrancheage().getCodetranche() + "\', \'" + unJouet.getLibelle() + "\')";
        DialogueBd.insertionBD(mysql);
        if (c != null) {
            mysql = "INSERT INTO comporte (ANNEE, NUMERO, QUANTITE) " +
                    " VALUES ( \'" + c.getAnnee() + "\', \'" + c.getNumero() +
                    "\', \'" + c.getQuantite() + "\')";
            DialogueBd.insertionBD(mysql);
        }
    }

    public void modifierCatalogue(Catalogue leCatalogue) throws MonException {

        String mysql;

        mysql = "UPDATE catalogue " +
                "SET quantiteDistribuee = " + leCatalogue.getQuantiteDistribuee() +
                " WHERE ANNEE =" + leCatalogue.getAnnee();
        DialogueBd.insertionBD(mysql);

    }

    public void effacer(String[] ids) throws MonException {
        String mysql;
        for (String id : ids) {
            mysql = "DELETE from comporte where NUMERO = " + id;
            DialogueBd.insertionBD(mysql);
            mysql = "DELETE from jouet where NUMERO = " + id;
            DialogueBd.insertionBD(mysql);
        }


    }

    public List<Comporte> listerCatalogueQuantites(int annee, int nb) throws MonException {
        List<Object> rs;
        int index = 0;
        int anneefin = annee + nb;
        List<Comporte> mescomporte = new ArrayList<Comporte>();

        String mysql = "SELECT a.ANNEE, a.QUANTITE, b.QUANTITEDISTRIBUEE " +
                "FROM COMPORTE a, CATALOGUE b " +
                "WHERE a.ANNEE = b.ANNEE " +
                "AND a.ANNEE >= " + annee +
                " AND a.ANNEE < " + anneefin;

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Comporte unC = new Comporte();
            // il faut redecouper la liste pour retrouver les lignes
            unC.setAnnee(Integer.valueOf(rs.get(index).toString()));
            unC.setQuantite(Integer.valueOf(rs.get(index + 1).toString()));
            unC.setQuantite_distribuee(Integer.valueOf(rs.get(index + 2).toString()));
            // On incr�mente tous les 3 champs
            index = index + 3;
            mescomporte.add(unC);
        }
        return mescomporte;
    }

    public HashMap<Categorie, Integer> rechercherDictionnaire(String annee) throws MonException {
        List<Object> rs;
        int index = 0;
        HashMap<Categorie, Integer> resultat = new HashMap<Categorie, Integer>();

        String mysql = "SELECT d.LIBCATEG, SUM(f.QUANTITE) " +
                "FROM CATEGORIE d, JOUET e, COMPORTE f " +
                "WHERE d.CODECATEG = e.CODECATEG " +
                "AND e.NUMERO = f.NUMERO " +
                "AND f.ANNEE = " + annee + " " +
                "GROUP BY d.LIBCATEG";
        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Categorie uneC = new Categorie();
            int valeur;
            // il faut redecouper la liste pour retrouver les lignes
            uneC.setLibcateg(rs.get(index).toString());
            valeur = Integer.valueOf(rs.get(index + 1).toString());
            // On incr�mente tous les 2 champs
            index = index + 2;
            resultat.put(uneC, valeur);
        }
        return resultat;
    }

    public int rechercherTotalDictionnaire(String annee) throws MonException {
        List<Object> rs;

        String mysql = "SELECT IFNULL(SUM(c.QUANTITE), 0) " +
                "FROM CATEGORIE a, JOUET b, COMPORTE c " +
                "WHERE a.CODECATEG = b.CODECATEG " +
                "AND b.NUMERO = c.NUMERO " +
                "AND c.ANNEE = " + annee;
        rs = DialogueBd.lecture(mysql);
        int total;
        total = Integer.valueOf(rs.get(0).toString());
        return total;
    }

    public HashMap<Integer, Integer> rechercherDictionnaireCateg(int annee, int nb, String codecateg) throws MonException {
        List<Object> rs;
        int index = 0;
        int annee_fin = annee + nb;
        HashMap<Integer, Integer> resultat = new HashMap<Integer, Integer>();

        String mysql = "SELECT f.ANNEE, SUM(f.QUANTITE) " +
                "FROM CATEGORIE d, JOUET e, COMPORTE f " +
                "WHERE d.CODECATEG = e.CODECATEG " +
                "AND e.NUMERO = f.NUMERO " +
                "AND f.ANNEE >= " + annee + " " +
                "AND f.ANNEE < " + annee_fin + " " +
                "AND d.CODECATEG = " + codecateg + " " +
                "GROUP BY f.ANNEE";
        rs = DialogueBd.lecture(mysql);
        System.out.println(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            int annee_key;
            int valeur;
            // il faut redecouper la liste pour retrouver les lignes
            annee_key = Integer.valueOf(rs.get(index).toString());
            valeur = Integer.valueOf(rs.get(index + 1).toString());
            // On incr�mente tous les 2 champs
            index = index + 2;
            resultat.put(annee_key, valeur);
        }
        return resultat;
    }

    public int rechercherTotalDictionnaireCateg(int annee, int nb, String codecateg) throws MonException {
        List<Object> rs;
        int annee_fin = annee + nb;

        String mysql = "SELECT IFNULL(SUM(f.QUANTITE), 0) " +
                "FROM CATEGORIE d, JOUET e, COMPORTE f " +
                "WHERE d.CODECATEG = e.CODECATEG " +
                "AND e.NUMERO = f.NUMERO " +
                "AND f.ANNEE >= " + annee + " " +
                "AND f.ANNEE < " + annee_fin + " " +
                "AND d.CODECATEG = " + codecateg + " ";
        rs = DialogueBd.lecture(mysql);
        int total;
        if (rs.get(0).toString() != "NULL") {
            total = Integer.valueOf(rs.get(0).toString());
        } else {
            total = 0;
        }
        return total;
    }
}
