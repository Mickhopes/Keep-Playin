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
    <meta name="author" content="Pouvaret,Turnel, Vernet">
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
      <a class="navbar-brand" href="index.php">Keep Playin'</a>
    </div>
    <div class="collapse navbar-collapse">
      	<ul class="nav navbar-nav" id="nav_menu">
        	<li role="presentation" class="active"><a href="#">Home</a></li>
          <li role="presentation"><a href="#">About</a></li>
          <li role="presentation"><a href="#">Contact</a></li>
      	</ul>
          	<form name="connect_form" class="navbar-form navbar-right" action="connexion_action.php" method="post">
				<div class="form-group">
					<input required="true" name="pseudo" type="text" placeholder="Identifiant" class="form-control">
				</div>
				<div class="form-group">
					<input required="true" name="password" type="password" placeholder="Mot de passe" class="form-control">
				</div>
				<input type="hidden" name="currentUrl" value="<?php echo $url; ?>">
				<a onClick="connect_form.submit()"><span class="glyphicon glyphicon-log-in green"></span></a>
      		</form>
      		<form name="deconnect_form" class="navbar-form navbar-right" action="deconnexion_action.php" method="post" style="margin-top:14px;">
				<div class="form-group connectedText"></div>
				<input type="hidden" name="currentUrl" value="<?php echo $url; ?>">
				<a href="parametres.php"><span class="glyphicon glyphicon-cog grey"></span></a>
				<a onClick="deconnect_form.submit()"><span class="glyphicon glyphicon-log-out red"></span></a>
			</form>
    </div>
 	 </div>
	</div>