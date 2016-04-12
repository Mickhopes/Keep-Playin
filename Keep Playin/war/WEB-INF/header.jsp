<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Keep Playin'">
    <meta name="author" content="Pouvaret, Turnel, Vernet">
    <title>Keep Playin'</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/custom.css" rel="stylesheet">

  </head>

  <body>
  	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="nav_bar">
  <div class="container" id="navbar-container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/index">Keep Playin'</a>
    </div>
    <form name="search_form connectedText" class="navbar-form navbar-left" action="recherche" method="get">
            <div class="form-group">
              <input name="recherche" type="text" placeholder="Rechercher..." class="form-control">
              </div>
    </form>
    <div class="collapse navbar-collapse">
      	<ul class="nav navbar-nav" id="nav_menu">
          <!-- <li role="presentation"><a href="#">About</a></li> -->
      	</ul>

          <c:if test="${(!empty sessionScope.utilisateur)}">
            <form name="deconnect_form" class="navbar-form navbar-right" action="deconnexion" method="post" style="margin-top:14px;">
            <div class="form-group connectedText"></div>
            <a href="parametres_form.submit()"><span class="glyphicon glyphicon-cog grey"></span></a>
            <a onClick="deconnect_form.submit()"><span class="glyphicon glyphicon-log-out red cliquable"></span></a>
          </form>
          </c:if>
          <c:if test="${(empty sessionScope.utilisateur)}">
            <form name="connect_form" class="navbar-form navbar-right" action="connexion" method="post">
            <div class="form-group">
              <input required="true" name="mail" type="text" placeholder="Adresse e-mail" class="form-control">
            </div>
            <div class="form-group">
              <input required="true" name="password" type="password" placeholder="Mot de passe" class="form-control">
            </div>
            <button type="submit" hidden>Hidden</button>
            <a onClick="connect_form.submit()"><span class="glyphicon glyphicon-log-in green cliquable"></span></a>
              </form>
          </c:if>


    </div>
 	 </div>
	</div>
