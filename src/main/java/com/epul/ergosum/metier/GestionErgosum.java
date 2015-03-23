package com.epul.ergosum.metier;

import com.epul.ergosum.meserreurs.MonException;
import com.epul.ergosum.persistance.DialogueBd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benoitvuillemin on 23/03/2015.
 */
public class GestionErgosum {

    public List<Jouet> listerTousLesJouets(int categorieCode, int trancheCode) throws MonException {
        List<Object> rs;
        List<Jouet> mesJouets = new ArrayList<Jouet>();
        int index = 0;
        String mysql = "";

        mysql = "SELECT * FROM jouet" +
                " WHERE codecateg = " + categorieCode +
                " AND codetranche = " + trancheCode +
                " ORDER BY id ASC";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Jouet unJ = new Jouet();
            // il faut redecouper la liste pour retrouver les lignes
            unJ.setNumero(rs.get(index + 0).toString());
            unJ.setCategorie(new Categorie(rs.get(index + 1).toString()));
            unJ.setTrancheage(new Trancheage(rs.get(index + 2).toString()));
            unJ.setLibelle(rs.get(index + 3).toString());
            // On incr�mente tous les 4 champs
            index = index + 4;
            mesJouets.add(unJ);
        }

        return mesJouets;

    }

    public List<Categorie> listerToutesLesCategories() throws MonException {
        List<Object> rs;
        List<Categorie> mesCategories = new ArrayList<Categorie>();
        int index = 0;
        String mysql = "";

        mysql = "SELECT * FROM categorie" +
                " ORDER BY id ASC";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Categorie uneC = new Categorie();
            // il faut redecouper la liste pour retrouver les lignes
            uneC.setCodecateg(rs.get(index + 0).toString());
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
        String mysql = "";

        mysql = "SELECT * FROM trancheage" +
                " ORDER BY id ASC";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Trancheage uneT = new Trancheage();
            // il faut redecouper la liste pour retrouver les lignes
            uneT.setCodetranche(rs.get(index + 0).toString());
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
        String mysql = "";

        mysql = "SELECT * FROM catalogue" +
                " ORDER BY id ASC";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Catalogue unC = new Catalogue();
            // il faut redecouper la liste pour retrouver les lignes
            unC.setAnnee(Integer.valueOf(rs.get(index + 0).toString()));
            unC.setQuantiteDistribuee(Integer.valueOf(rs.get(index + 1).toString()));
            // On incr�mente tous les 2 champs
            index = index + 2;
            mesCatalogues.add(unC);
        }

        return mesCatalogues;

    }

    public Jouet rechercherJouet(String id) throws MonException {
        List<Object> rs;

        String mysql = "";

        mysql = "SELECT * FROM jouet" +
                "WHERE NUMERO =" + id +
                " ORDER BY id ASC";

        rs = DialogueBd.lecture(mysql);

        Jouet monJouet = new Jouet();
        monJouet.setNumero(rs.get(0).toString());
        monJouet.setCategorie(new Categorie(rs.get(1).toString()));
        monJouet.setTrancheage(new Trancheage(rs.get(2).toString()));
        monJouet.setLibelle(rs.get(3).toString());


        return monJouet;
    }
}
