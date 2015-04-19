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
                <div class="form-group">
                    <button class="btn btn-lg btn-default" type="submit" name="submit" id="submit" value="valider">
                        Valider
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