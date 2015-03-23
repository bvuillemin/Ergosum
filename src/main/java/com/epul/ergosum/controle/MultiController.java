package com.epul.ergosum.controle;

import com.epul.ergosum.metier.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import com.epul.ergosum.meserreurs.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * Simply selects the home view to render by returning its name.
     */
    private Jouet unJouet;

    @RequestMapping(value = "Accueil.htm", method = RequestMethod.GET)
    public ModelAndView home(Locale locale, Model model) {
        String destinationPage = "";
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        System.out.println("JE construis la page");
        destinationPage = "/Accueil";

        return new ModelAndView(destinationPage);
    }

    /**
     * Affichage de tous les jouets
     */
    @RequestMapping(value = "afficherJouets.htm")

    public ModelAndView afficherLesJouets(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try
        {
            GestionErgosum unService = new GestionErgosum();
            if (unService != null) {
                int categorieCode;
                int trancheCode;
                String categorie = request.getParameter("codecateg");
                String tranche = request.getParameter("codetranche");
                if(categorie == null && tranche == null) {
                    categorieCode = 0;
                    trancheCode = 0;
                } else {
                    categorieCode = Integer.parseInt(categorie);
                    trancheCode = Integer.parseInt(tranche);
                }
                request.setAttribute("mesJouets", unService.listerTousLesJouets(categorieCode, trancheCode));

                request.setAttribute("categories", unService.listerToutesLesCategories());
                request.setAttribute("tranches", unService.listerToutesLesTranches());
            }
        }

        catch (MonException e)
        {
            request.setAttribute("MesErreurs", e.getMessage());
        }
        destinationPage = "/ListeJouets";

        return new ModelAndView(destinationPage);
    }



    /**
     * Ajout d'un jouet
     */
    @RequestMapping(value = "ajouterJouet.htm")

    public ModelAndView ajoutJouet(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        String destinationPage = "";

        try
        {
            GestionErgosum unService = new GestionErgosum();

            if (unService != null)
            {
                // on passe les numÈros de client et de vendeur
                request.setAttribute("jouet", new Jouet());
                request.setAttribute("categories", unService.listerToutesLesCategories());
                request.setAttribute("tranches", unService.listerToutesLesTranches());
                request.setAttribute("catalogues", unService.listerTousLesCatalogues());

                destinationPage = "/AjouterJouet";
            }
        }  catch (MonException e)
        {
            request.setAttribute("MesErreurs", e.getMessage());
        }

        return new ModelAndView(destinationPage);
    }



    /**
     * SÈlection d'une annÈe par catÈgorie
     */
    @RequestMapping(value = "selectionnerAnnee.htm")

    public ModelAndView selectionAnnee(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        String destinationPage = "";
        destinationPage = "/selectionAnneeCat";
        return new ModelAndView(destinationPage);
    }

    /**
     * SÈlection d'une annÈe Ctagoriet
     */
    @RequestMapping(value = "listerCatalogue.htm")

    public ModelAndView choixCatalogue(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        String destinationPage = "/Erreur";
        try
        {
            GestionErgosum unService = new GestionErgosum();

            if (unService != null)
                request.setAttribute("catalogues", unService.listerTousLesCatalogues());
            destinationPage = "/ChoixCatalogue";
        }  catch (MonException e)
        {
            request.setAttribute("MesErreurs", e.getMessage());
        }


        return new ModelAndView(destinationPage);
    }


    /**
     * Modifier Jouet
     */
    @RequestMapping(value = "modifierJouet.htm")

    public ModelAndView modifierJouet(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        String destinationPage = "Erreur";
        try
        {
            String id = request.getParameter("id");
            GestionErgosum unService = new GestionErgosum();

            if (unService != null)
            {
                Jouet unJouet = unService.rechercherJouet(id);
                request.setAttribute("jouet", unJouet);
                request.setAttribute("categories", unService.listerToutesLesCategories());
                request.setAttribute("tranches", unService.listerToutesLesTranches());
                destinationPage = "/ModifierJouet";
            }

        } catch (MonException e)
        {
            request.setAttribute("MesErreurs", e.getMessage());
        }


        return new ModelAndView(destinationPage);
    }


}

	