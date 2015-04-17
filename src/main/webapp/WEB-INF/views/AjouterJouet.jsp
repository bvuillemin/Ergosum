<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Ajout d'un jouet</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/rerources/css/main.css">
</head>
<body>
<A href="Accueil.htm" class="btn btn-sm btn-default">
    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
    <span class="glyphicon-class">Retour accueil</span>
</A>

<h3>Ajout d'un Jouet</h3>

<form class="form-horizontal" method="post" action="sauverJouet.htm" onsubmit="return verif();">
    <fieldset>
        <div class="panel panel-default">
            <!-- input fields -->
            <div class="panel-body">
                <div class="form-group">
                    <label for="id" class="col-sm-4 control-label">Numéro</label>

                    <div class="col-sm-6">
                        <input type="number" class="form-control" name="id" id="id" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="libelle" class="col-sm-4 control-label">Libellé</label>

                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="libelle" id="libelle" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="categorie" class="col-sm-4 control-label">Catégorie</label>

                    <div class="col-sm-6">
                        <SELECT class="form-control" name="categorie" size="1" id="categorie">
                            <c:forEach items="${categories}" var="itemcateg">
                                <OPTION value="${itemcateg.codecateg}">${itemcateg.libcateg}</option>
                            </c:forEach>
                        </SELECT>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tranche" class="col-sm-4 control-label">Tranche âge</label>

                    <div class="col-sm-6">
                        <SELECT class="form-control" name="tranche" size="1" id="tranche">
                            <c:forEach items="${tranches}" var="itemtranche">
                                <OPTION value="${itemtranche.codetranche}">${itemtranche.agemin} à ${itemtranche.agemax}
                                    ans
                                </option>
                            </c:forEach>
                        </SELECT>
                    </div>
                </div>
                <div class="form-group">
                    <label for="quantiteDistribution" class="col-sm-4 control-label">Quantité de distribution</label>

                    <div class="col-sm-6">
                        <input type="number" class="form-control" name="quantiteDistribution" id="quantiteDistribution"
                               required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="catalogue" class="col-sm-4 control-label">Dans le catalogue</label>

                    <div class="col-sm-6">
                        <SELECT class="form-control" name="catalogue" size="1" id="catalogue">
                            <c:forEach items="${catalogues}" var="itemcata">
                                <OPTION value="${itemcata.annee}">${itemcata.annee}</option>
                            </c:forEach>
                        </SELECT>
                    </div>
                </div>
            </div>
            <!-- Boutons Ajouter/Reset -->
            <div class="panel-footer clearfix">
                <div class="form-group">
                    <button class="btn btn-lg btn-default" type="submit" name="submit" id="submit" value="ajout">
                        Ajouter
                    </button>
                    <button class="btn btn-lg btn-default" type="reset" name="reset" value="Reset">Reset</button>
                </div>
            </div>
        </div>
    </fieldset>
</form>


<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
