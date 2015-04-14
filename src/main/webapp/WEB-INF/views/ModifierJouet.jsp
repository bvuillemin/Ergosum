<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Ajout d'un jouet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
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
                    <label for="id" class="col-sm-4 control-label">Num�ro</label>

                    <div class="col-sm-6">
                        <input type="number" class="form-control" name="id" id="id" value="${id}"
                               >
                    </div>
                </div>
                <div class="form-group">
                    <label for="libelle" class="col-sm-4 control-label">Libell�</label>

                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="libelle" id="libelle"
                               value="${libelle}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="categorie" class="col-sm-4 control-label">Cat�gorie</label>

                    <div class="col-sm-6">
                        <SELECT class="form-control" name="categorie" size="1" id="categorie">
                            <c:forEach items="${categories}" var="itemcateg">
                                <c:if test="${itemcateg.codecateg == codcateg}">
                                    <OPTION selected value="${itemcateg.codecateg}">${itemcateg.libcateg}</option>
                                </c:if>
                                <c:if test="${itemcateg.codecateg != codcateg}">
                                    <OPTION value="${itemcateg.codecateg}">${itemcateg.libcateg}</option>
                                </c:if>
                            </c:forEach>
                        </SELECT>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tranche" class="col-sm-4 control-label">Tranche �ge</label>

                    <div class="col-sm-6">
                        <SELECT class="form-control" name="tranche" size="1" id="tranche">
                            <c:forEach items="${tranches}" var="itemtranche">
                                <c:if test="${itemtranche.codetranche == jouet.getTrancheage().getCodetranche()}">
                                <OPTION selected value="${itemtranche.codetranche}">${itemtranche.agemin} � ${itemtranche.agemax}
                                    ans
                                </option>
                                </c:if>
                                <c:if test="${itemtranche.codetranche != jouet.getTrancheage().getCodetranche()}">
                                    <OPTION value="${itemtranche.codetranche}">${itemtranche.agemin} � ${itemtranche.agemax}
                                        ans
                                    </option>
                                </c:if>
                            </c:forEach>
                        </SELECT>
                    </div>
                </div>
            </div>
            <!-- Boutons Ajouter/Reset -->
            <div class="panel-footer clearfix">
                <div class="form-group">
                    <button class="btn btn-lg btn-default" type="submit" name="submit" id="submit" value="modif">
                        Modifier
                    </button>
                    <button class="btn btn-lg btn-default" type="reset" name="reset" value="Reset">Reset</button>
                </div>
            </div>
        </div>
    </fieldset>
</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
