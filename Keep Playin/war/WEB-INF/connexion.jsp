<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp">
	<jsp:param value="${currentUrl}" name="currentUrl"/>
</jsp:include>

<div class="container">

	<!--  code généré grâce au site  -->
	<form class="form-horizontal col-md-4 col-md-offset-4 connexion-form"
		id="form_inscription" action="connexion" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Connexion</legend>

			<!-- Text input-->
			<div class="control-group">
				<label class="control-label" for="mail"></label>
				<div class="controls">
					<input id="mail" name="mail" type="text" placeholder="Adresse e-mail"
						class="input-xlarge input-mail" required="true">

				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<label class="control-label" for="password"></label>
				<div class="controls">
					<input id="password" name="password" type="password" placeholder="Mot de passe"
						class="input-xlarge input-password" required="true">

				</div>
			</div>

			<span class="error">
				<c:if test="${!empty param.erreur}">
					<c:choose>
						<c:when test="${param.erreur == 'infoincorrecte'}">
							Les informations de connexion sont incorrectes !
						</c:when>
					</c:choose>
				</c:if>
			</span>

			<!-- Button -->
			<div class="control-group">
				<input type="hidden" name="currentUrl" value="index">
				<label class="control-label" for="btn_connexion"></label>
				<div class="controls">
					<button id="btn_connexion" name="btn_connexion"
						class="btn btn-success">Se connecter</button>
				</div>
			</div>

		</fieldset>
	</form>
</div>


<jsp:include page="footer.jsp"></jsp:include>