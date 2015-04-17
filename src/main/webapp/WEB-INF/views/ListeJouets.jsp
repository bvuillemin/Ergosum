<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Affichage de la liste des jouets</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/rerources/css/main.css">
</head>
<body>
<A href="Accueil.htm" class="btn btn-sm btn-default">
    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
    <span class="glyphicon-class">Retour accueil</span>
</A>

<h3>Listing des Jouets</h3>

<TABLE class="table table-striped">
    <thead>
    <TR>
        <TH class="perso">Libellé</TH>
        <TH class="perso">Catégorie</TH>
        <TH class="perso">Tranche Age</TH>
        <TH class="perso">Modifier</TH>
        <TH class="perso">Supprimer</TH>
    </TR>
    </thead>
    <tbody>
    <c:forEach items="${mesJouets}" var="item">
        <tr>
            <td>${item.libelle}</td>
            <td>${item.categorie.libcateg}</td>
            <td>${item.trancheage.agemin} à ${item.trancheage.agemax} ans</td>
            <td>
                <form method="post" action="modifierJouet.htm">
                    <input type="hidden" name="id" value="${item.numero}"/>
                    <input class="btn btn-xs btn-default" type="submit" name="modifier" value="Modifier"/>
                </form>
            </td>
            <td>
                <form method="post" action="effacerJouet.htm">
                    <input type="hidden" name="id" value="${item.numero}"/>
                    <input class="btn btn-xs btn-default" type="submit" name="supprimer" value="Supprimer"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</TABLE>

<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
