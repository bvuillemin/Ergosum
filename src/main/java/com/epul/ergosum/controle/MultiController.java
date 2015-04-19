package com.epul.ergosum.controle;

import com.epul.ergosum.metier.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import com.epul.ergosum.meserreurs.*;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MultiController extends MultiActionController {

    private static final Logger logger = LoggerFactory
            .getLogger(MultiController.class);

    @RequestMapping(value = "Accueil.htm", method = RequestMethod.GET)
    public ModelAndView home(Locale locale, Model model) {
        String destinationPage;
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        destinationPage = "/Accueil";

        return new ModelAndView(destinationPage);
    }

    /**
     * Affichage de tous les jouets
     */
    @RequestMapping(value = "afficherJouets.htm")

    public ModelAndView afficherLesJouets(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        try {
            GestionErgosum unService = new GestionErgosum();
            request.setAttribute("mesJouets", unService.listerTousLesJouets());
            request.setAttribute("categories", unService.listerToutesLesCategories());
            request.setAttribute("tranches", unService.listerToutesLesTranches());
            destinationPage = "/ListeJouets";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }

        return new ModelAndView(destinationPage);
    }


    /**
     * Ajout d'un jouet
     */
    @RequestMapping(value = "ajouterJouet.htm")

    public ModelAndView ajoutJouet(HttpServletRequest request) throws Exception {

        String destinationPage = "";

        try {
            GestionErgosum unService = new GestionErgosum();

            // on passe les numÈros de client et de vendeur
            request.setAttribute("jouet", new Jouet());
            request.setAttribute("categories", unService.listerToutesLesCategories());
            request.setAttribute("tranches", unService.listerToutesLesTranches());
            request.setAttribute("catalogues", unService.listerTousLesCatalogues());

            destinationPage = "/AjouterJouet";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }

        return new ModelAndView(destinationPage);
    }


    /**
     * SÈlection d'une annÈe par catÈgorie
     */
    @RequestMapping(value = "selectionnerAnnee.htm")

    public ModelAndView selectionAnnee(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        try {
            GestionErgosum unService = new GestionErgosum();

            request.setAttribute("catalogues", unService.listerTousLesCatalogues());
            destinationPage = "/SelectionAnnee";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }


        return new ModelAndView(destinationPage);
    }

    /**
     * SÈlection d'une annÈe et catÈgorie
     */
    @RequestMapping(value = "selectionnerAnneeCateg.htm")

    public ModelAndView selectionAnneeCateg(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        try {
            GestionErgosum unService = new GestionErgosum();

            request.setAttribute("catalogues", unService.listerTousLesCatalogues());
            request.setAttribute("categories", unService.listerToutesLesCategories());
            destinationPage = "/SelectionAnneeCateg";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }


        return new ModelAndView(destinationPage);
    }

    /**
     * SÈlection d'une annÈe Ctagoriet
     */
    @RequestMapping(value = "listerCatalogue.htm")

    public ModelAndView choixCatalogue(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        try {
            GestionErgosum unService = new GestionErgosum();

            request.setAttribute("catalogues", unService.listerTousLesCatalogues());
            destinationPage = "/ChoixCatalogue";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }


        return new ModelAndView(destinationPage);
    }


    /**
     * Modifier Jouet
     */
    @RequestMapping(value = "modifierJouet.htm")

    public ModelAndView modifierJouet(HttpServletRequest request) throws Exception {

        String destinationPage = "Erreur";
        try {
            String id = request.getParameter("id");
            GestionErgosum unService = new GestionErgosum();

            Jouet unJouet = unService.rechercherJouet(id);
            request.setAttribute("jouet", unJouet);
            request.setAttribute("id", unJouet.getNumero());
            request.setAttribute("libelle", unJouet.getLibelle());
            request.setAttribute("codcateg", unJouet.getCategorie().getCodecateg());
            request.setAttribute("codtranche", unJouet.getTrancheage().getCodetranche());
            request.setAttribute("categories", unService.listerToutesLesCategories());
            request.setAttribute("tranches", unService.listerToutesLesTranches());
            destinationPage = "/ModifierJouet";

        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }


        return new ModelAndView(destinationPage);
    }

    /**
     * Sauver jouet
     */
    @RequestMapping(value = "sauverJouet.htm")
    public ModelAndView sauverJouet(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        try {
            String id = request.getParameter("id");
            GestionErgosum unService = new GestionErgosum();

            // fabrication du jouet ‡ partir des paramËtres de la requÍte
            // Si le jouet n'est pas ‡ crÈer, il faut le rÈcupÈrer de la session
            // courante
            // Ensuite on peut modifier ses champs

                /*
      Simply selects the home view to render by returning its name.
     */
            Jouet unJouet;
            if (request.getParameter("submit").equals("ajout"))
                unJouet = new Jouet();
            else { // on rÈcupËre le jouet courant

                unJouet = unService.rechercherJouet(id);
            }
            unJouet.setNumero(request.getParameter("id"));
            unJouet.setLibelle(request.getParameter("libelle"));
            Categorie uneCateg = unService.rechercherCategorie(request.getParameter("categorie"));
            unJouet.setCategorie(uneCateg);

            Trancheage uneTranche = unService.rechercherTrancheage(request.getParameter("tranche"));
            unJouet.setTrancheage(uneTranche);

            // sauvegarde du jouet
            if (request.getParameter("submit").equals("modif")) {
                unService.modifier(unJouet);
            } else {

                Catalogue leCatalogue = unService.rechercherCatalogue(request.getParameter("catalogue"));
                Comporte c = new Comporte(Integer.valueOf(request.getParameter("catalogue")),
                        Integer.valueOf(request.getParameter("id")), Integer.valueOf(request.getParameter("quantiteDistribution")));
                int quantiteDistribution = Integer.parseInt(request.getParameter("quantiteDistribution"));
                if (quantiteDistribution > 0) {
                    leCatalogue.setQuantiteDistribuee(leCatalogue.getQuantiteDistribuee() + quantiteDistribution);
                    unService.modifierCatalogue(leCatalogue);
                }
                unService.ajouter(unJouet, c);
            }
            try {
                request.setAttribute("mesJouets", unService.listerTousLesJouets());
                destinationPage = "/ListeJouets";
            } catch (MonException e) {
                request.setAttribute("MesErreurs", e.getMessage());
            }

        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }

        return new ModelAndView(destinationPage);
    }


    /**
     * effacer  jouet
     */
    @RequestMapping(value = "effacerJouet.htm")
    public ModelAndView effacerJouet(HttpServletRequest request) throws Exception {

        String destinationPage = "";
        try {
            GestionErgosum unService = new GestionErgosum();

            // recuperation de la liste des id a effacer
            String[] ids = request.getParameterValues("id");
            // effacement de la liste des id
            try {
                if (ids != null) {
                    unService.effacer(ids);
                }
                // preparation de la liste
                request.setAttribute("mesJouets", unService.listerTousLesJouets());
            } catch (MonException e) {
                request.setAttribute("MesErreurs", e.getMessage());
            }

            destinationPage = "/ListeJouets";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }
        return new ModelAndView(destinationPage);
    }


    /**
     * afficher Catalogue
     */
    @RequestMapping(value = "afficherCatalogues.htm")
    public ModelAndView afficherCatalogue(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        try {
            GestionErgosum unService = new GestionErgosum();

            // preparation de la liste
            request.setAttribute("mesCataloguesQuantites", unService.listerCatalogueQuantites(Integer.parseInt(request.getParameter("anneeDebut")), Integer.parseInt(request.getParameter("nbAnnees"))));
            destinationPage = "/AfficherCatalogues";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }

        return new ModelAndView(destinationPage);
    }


    /**
     * afficher le Dictionnaire
     */
    @RequestMapping(value = "afficherDictionnaire.htm")
    public ModelAndView afficherDictionnaire(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        String annee = request.getParameter("annee");
        try {
            GestionErgosum unService = new GestionErgosum();
            HashMap<Categorie, Integer> hashCatInt = unService.rechercherDictionnaire(annee);
            int total = unService.rechercherTotalDictionnaire(annee);
            request.setAttribute("dictionnaire", hashCatInt);
            request.setAttribute("total", total);
            request.setAttribute("anneecatalogue", annee);
            destinationPage = "/AfficherDictionnaire";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }

        return new ModelAndView(destinationPage);
    }

    /**
     * afficher le Dictionnaire en fonction aussi de la categorie
     */
    @RequestMapping(value = "afficherDictionnaireCateg.htm")
    public ModelAndView afficherDictionnaireCateg(HttpServletRequest request) throws Exception {

        String destinationPage = "/Erreur";
        int annee = Integer.valueOf(request.getParameter("annee"));
        int duree = Integer.valueOf(request.getParameter("duree"));
        String codecateg = request.getParameter("categorie");

        try {
            GestionErgosum unService = new GestionErgosum();
            HashMap<Integer, Integer> hashCatInt = unService.rechercherDictionnaireCateg(annee, duree, codecateg);
            Categorie c = unService.rechercherCategorie(codecateg);
            int total = unService.rechercherTotalDictionnaireCateg(annee, duree, codecateg);
            request.setAttribute("dictionnaire", hashCatInt);
            request.setAttribute("total", total);
            request.setAttribute("categorie", c.getLibcateg());
            destinationPage = "/AfficherDictionnaireCateg";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }

        return new ModelAndView(destinationPage);
    }
}

	