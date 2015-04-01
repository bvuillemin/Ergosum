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
          <label for="numero" class="col-sm-4 control-label">Numéro</label>

          <div class="col-sm-6">
            <input type="number" class="form-control" name="numero" id="numero" required>
          </div>
        </div>
        <div class="form-group">
          <label for="libelle" class="col-sm-4 control-label">Libellé</label>

          <div class="col-sm-6">
            <input type="text" class="form-control" name="libelle" id="libelle" required>
          </div>
        </div>
        <div class="form-group">
          <label for="codecateg" class="col-sm-4 control-label">Categorie</label>

          <div class="col-sm-6">
            <input type="text" class="form-control" name="codecateg" id="codecateg" required>
          </div>
        </div>
        <div class="form-group">
          <label for="codetranche" class="col-sm-4 control-label">Tranche âge</label>

          <div class="col-sm-6">
            <input type="text" class="form-control" name="codetranche" id="codetranche" required>
          </div>
        </div>
        <div class="form-group">
          <label for="quantiteDistribution" class="col-sm-4 control-label">Quantité de distribution</label>

          <div class="col-sm-6">
            <input type="number" class="form-control" name="quantiteDistribution" id="quantiteDistribution" required>
          </div>
          <label for="codecatalogue" class="col-sm-4 control-label">Dans le catalogue</label>

          <div class="col-sm-6">
            <input type="number" class="form-control" name="codecatalogue" id="codecatalogue" required>
          </div>
        </div>
      </div>
      <!-- Boutons Ajouter/Reset -->
      <div class="panel-footer clearfix">
        <div class="form-group">
          <button class="btn btn-lg btn-default" type="submit" name="ajouter" value="Ajouter">Ajouter</button>
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
