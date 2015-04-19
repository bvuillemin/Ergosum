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

<h3>Voici les quantités distribuées pour la catégorie ${categorie}</h3>

<TABLE class="table table-striped">
    <thead>
    <TR>
        <TH class="perso">Année</TH>
        <TH class="perso">Quantité distribuée</TH>
    </TR>
    </thead>
    <tbody>
    <c:forEach items="${dictionnaire}" var="item">
        <tr>
            <td>${item.key}</td>
            <td>${item.value}</td>
        </tr>
    </c:forEach>
    <tr>
        <td><b>Total</b></td>
        <td><b>${total}</b></td>
    </tr>
    </tbody>
</TABLE>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
