<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Affichage de la liste des jouets</title>
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
    <TH class="perso">Numéro</TH>
    <TH class="perso">Libellé</TH>
  </TR>
  <thead>
  <tbody>
  <c:forEach items="${mesJouets}" var="item">
  <tr>
    <td>${item.numero}</td>
    <td>${item.libelle}</td>
  </tr>
  </c:forEach>
  <tbody>
</TABLE>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
