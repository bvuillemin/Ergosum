<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>S�lection d'une ann�e</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Accueil.htm">Ergosum</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Accueil.htm">Accueil</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown" role="button"
                       aria-expanded="false">Jouets <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="afficherJouets.htm">Affichage</a></li>
                        <li><a href="ajouterJouet.htm">Ajout</a></li>
                    </ul>
                </li>
                <li><a href="listerCatalogue.htm">Affichage des catalogues</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown" role="button"
                       aria-expanded="false">Dictionnaires <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="selectionnerAnnee.htm">Affichage simple</a></li>
                        <li><a href="selectionnerAnneeCateg.htm">Affichage avec cat�gories</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div class="container">
    <h3>Choix du dictionnaire</h3>

    <form class="form-horizontal" method="post" action="afficherDictionnaire.htm" onsubmit="return verif();">
        <fieldset>
            <div class="panel panel-default">
                <!-- input fields -->
                <div class="panel-body">
                    <div class="form-group">
                        <label for="annee" class="col-sm-4 control-label">Catalogue</label>

                        <div class="col-sm-6">
                            <SELECT class="form-control" name="annee" size="1" id="annee">
                                <c:forEach items="${catalogues}" var="itemcata">
                                    <OPTION value="${itemcata.annee}">${itemcata.annee}</option>
                                </c:forEach>
                            </SELECT>
                        </div>
                    </div>
                </div>
                <!-- Boutons Ajouter/Reset -->
                <div class="panel-footer clearfix">
                    <div class="col-md-4 col-md-offset-4">
                        <button class="btn btn-lg btn-default col-md-6" type="reset" name="reset" value="Reset">
                            Reset
                        </button>
                        <button class="btn btn-lg btn-default col-md-6" type="submit" name="submit" id="submit"
                                value="valider">
                            Valider
                        </button>
                    </div>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
