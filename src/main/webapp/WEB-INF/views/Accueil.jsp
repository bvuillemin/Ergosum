<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="java.util.Date,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Gestion des stages</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">

</head>
<body>
<H1> Gestion des Stages HIGH TECH </H1> <BR> <BR>

<H2> Nous sommes le <%= DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(new Date()) %>
</H2>
<dl class="dl-horizontal">
    <dt><a href="afficherJouets.htm">Affichage</a></dt>
    <dd>Pour voir la liste de tous les stages et agir dessus</dd>
</dl>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
