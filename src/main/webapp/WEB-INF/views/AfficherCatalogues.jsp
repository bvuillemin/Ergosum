<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Gestion des jouets</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/rerources/css/main.css">
</head>
<body>
<A href="Accueil.htm" class="btn btn-sm btn-default">
    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
    <span class="glyphicon-class">Retour accueil</span>
</A>

<h3>Voici la liste des catalogues pour l'intervalle choisi</h3>

<TABLE class="table table-striped">
    <thead>
    <TR>
        <TH class="perso">Ann�e</TH>
        <TH class="perso">Quantit� affect�e</TH>
        <TH class="perso">Quantit� distribu�e</TH>
        <TH class="perso">Diff�rence</TH>
    </TR>
    </thead>
    <tbody>
    <c:forEach items="${mesCataloguesQuantites}" var="item">
        <tr>
            <td>${item.annee}</td>
            <td>${item.quantite}</td>
            <td>${item.quantite_distribuee}</td>
            <td>${item.difference}</td>
        </tr>
    </c:forEach>
    </tbody>
</TABLE>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
