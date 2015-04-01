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
        String mysql = "";

        mysql = "SELECT a.numero, a.codecateg, a.codetranche, a.libelle, b.libcateg, c.agemin, c.agemax\n" +
                "FROM jouet a, categorie b, trancheage c\n" +
                "where a.codecateg = b.codecateg\n" +
                "and a.codetranche = c.codetranche";

        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Jouet unJ = new Jouet();
            // il faut redecouper la liste pour retrouver les lignes
            unJ.setNumero(rs.get(index + 0).toString());
            unJ.setCategorie(new Categorie(rs.get(index + 1).toString(), rs.get(index + 4).toString(), null));
            unJ.setTrancheage(new Trancheage(rs.get(index + 2).toString(), Integer.valueOf(rs.get(index + 5).toString()), Integer.valueOf(rs.get(index + 6).toString()), null));
            unJ.setLibelle(rs.get(index + 3).toString());
            // On incr�mente tous les 7 champs
            index = index + 7;
            mesJouets.add(unJ);
        }

        return mesJouets;

    }

    public List<Jouet> listerTousLesJouets(int categorieCode, int trancheCode) throws MonException {
        List<Object> rs;
        List<Jouet> mesJouets = new ArrayList<Jouet>();
        int index = 0;
        String mysql = "";

        mysql = "SELECT * FROM jouet";
        if (categorieCode != 0) {
            mysql += " WHERE codecateg = " + categorieCode;
            if (trancheCode != 0) {
                mysql += " AND codetranche = " + trancheCode;
            }
        }
        if (trancheCode != 0 && categorieCode ==0) {
            mysql += " WHERE codetranche = " + trancheCode;
        }
        mysql += " ORDER BY numero ASC";

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

        mysql = "SELECT * FROM categorie";

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

        mysql = "SELECT * FROM trancheage";

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

        mysql = "SELECT * FROM catalogue";

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
                "WHERE NUMERO =" + id;

        rs = DialogueBd.lecture(mysql);

        Jouet monJouet = new Jouet();
        monJouet.setNumero(rs.get(0).toString());
        monJouet.setCategorie(new Categorie(rs.get(1).toString()));
        monJouet.setTrancheage(new Trancheage(rs.get(2).toString()));
        monJouet.setLibelle(rs.get(3).toString());


        return monJouet;
    }

    public Categorie rechercherCategorie(String codeCategorie) throws MonException {
        List<Object> rs;

        String mysql = "";

        mysql = "SELECT * FROM categorie" +
                "WHERE CODECATEG =" + codeCategorie;

        rs = DialogueBd.lecture(mysql);

        Categorie maCategorie = new Categorie();
        maCategorie.setCodecateg(rs.get(0).toString());
        maCategorie.setLibcateg(rs.get(1).toString());


        return maCategorie;
    }

    public Trancheage rechercherTrancheage(String codetranche) throws MonException {
        List<Object> rs;

        String mysql = "";

        mysql = "SELECT * FROM trancheage" +
                "WHERE CODETRANCHE =" + codetranche;

        rs = DialogueBd.lecture(mysql);

        Trancheage maTranche = new Trancheage();
        maTranche.setCodetranche(rs.get(0).toString());
        maTranche.setAgemin(Integer.valueOf(rs.get(1).toString()));
        maTranche.setAgemax(Integer.valueOf(rs.get(2).toString()));

        return maTranche;
    }

    public Catalogue rechercherCatalogue(String codecatalogue) throws MonException {
        List<Object> rs;

        String mysql = "";

        mysql = "SELECT * FROM catalogue" +
                "WHERE ANNEE =" + codecatalogue;

        rs = DialogueBd.lecture(mysql);

        Catalogue monCatalogue = new Catalogue();
        monCatalogue.setAnnee(Integer.valueOf(rs.get(0).toString()));
        monCatalogue.setQuantiteDistribuee(Integer.valueOf(rs.get(1).toString()));

        return monCatalogue;
    }

    public void modifier(Jouet unJouet) throws MonException {

        String mysql = "";

        mysql = "UPDATE jouet " +
                "SET CODECATEG = " + unJouet.getCategorie() +
                "SET CODETRANCHE = " + unJouet.getTrancheage() +
                "SET LIBELLE = " + unJouet.getLibelle() +
                "WHERE NUMERO =" + unJouet.getNumero();
        DialogueBd.insertionBD(mysql);
    }

    public void ajouter(Jouet unJouet) throws MonException {

        String mysql = "";

        mysql = "INSERT INTO jouet (NUMERO, CODECATEG, CODETRANCHE, LIBELLE) " +
                " VALUES ( \'" + unJouet.getNumero() + "\', \'" + unJouet.getCategorie() + "\', " +
                "\' " + unJouet.getTrancheage() + "\', " + "\' " + unJouet.getLibelle() + " )";
        DialogueBd.insertionBD(mysql);
    }

    public void modifierCatalogue(Catalogue leCatalogue) throws MonException {

        String mysql = "";

        mysql = "UPDATE catalogue " +
                "SET quantiteDistribuee = " + leCatalogue.getQuantiteDistribuee() +
                "WHERE ANNEE =" + leCatalogue.getAnnee();
        DialogueBd.insertionBD(mysql);

    }

    public void effacer(String[] ids) throws MonException {

        int i = 0;
        while (i < ids.length) {
            String mysql = "";
            mysql = "DELETE from jouet where id =" + ids[i] + "";
            DialogueBd.insertionBD(mysql);
        }


    }

    // La requete est fausse
    public int listerCatalogueQuantites(int annee, int nb) throws MonException {
        List<Object> rs;
        int index = 0;
        int anneefin = annee + nb;
        int quantite = 0;

        String mysql = "";
        mysql = "SELECT * FROM catalogue"; // il faut aller chercher la quantité cf image
        rs = DialogueBd.lecture(mysql);

        while (index < rs.size()) {
            // On cr�e un stage
            Catalogue unC = new Catalogue();
            // il faut redecouper la liste pour retrouver les lignes
            unC.setAnnee(Integer.valueOf(rs.get(index + 0).toString()));
            unC.setQuantiteDistribuee(Integer.valueOf(rs.get(index + 1).toString()));

            if (unC.getAnnee() >= annee && unC.getAnnee() <= anneefin) {
                quantite = quantite + unC.getQuantiteDistribuee();
            }
            // On incr�mente tous les 2 champs
            index = index + 2;
        }

        return quantite;
    }

    //a faire
    public HashMap<Categorie, Integer> rechercherDictionnaire(String annee) {

        return null;
    }

}
