<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, java.util.Collections, fr.keepplayin.model.Utilisateur"%>
<jsp:include page="header.jsp">
	<jsp:param value="${currentUrl}" name="currentUrl" />
</jsp:include>
<c:if test="${!empty erreur}">
	<span class="error col-md-5 col-md-offset-4"> ${erreur} </span>
</c:if>

<div class="row">
<div class="resultats-recherche col-md-6 col-md-offset-3">
	<form name="recherche-form" action="recherche" method="get">
	<div class="row">
			<div class="col-md-3">
				Personne à rechercher :
			</div>
	    <div class="form-group col-md-9">
	      <input name="recherche" type="text" placeholder="Rechercher..." class="form-control">
	    </div>
	</div>
	<div class="row">
		<div class="col-md-4">
			Instrument :
			<select>
				<option>Indifférent</option>
			</select>
		</div>
		<div class="col-md-4">
			Niveau :
			<select>
				<option>Indifférent</option>
			</select>
		</div>
		<div class="col-md-2 col-md-offset-1">
			<button type="submit" class="btn btn-primary" style="margin-left: 54px;">Rechercher</button>
		</div>
	</div>
</form>
</div>
</div>
<div class="container">
<h2>Résultats de la recherche :</h2>
<br>
<%
	List<Utilisateur> uList = (List<Utilisateur>)request.getAttribute("resultats");
	Collections.sort(uList);
	for(Utilisateur u : uList) {
%>
<div class="thumbnail border shadow padding_top col-md-6 col-md-offset-3">
	<div class="row">
		<div class="col-md-3">
			<a href="/profil?id=<%= u.getId()%>"><img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-105" ></a>
		</div>
		<div class="col-md-9">
		<div class="row">
			<div class="col-md-4">
				<a href="/profil?id=<%= u.getId()%>"><%=u.getPrenom()+" "+u.getNom()%></a>
			</div>
			<div class="col-md-3 col-md-offset-5">
				Amis icon
			</div>
		</div>
		<div class="row col-md-12">
			<%if(u.getNomDeScene() == null)%>Aucun nom de scène<%else %>u.getNomDeScene()%>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">
				Instrument principal
			</div>
			<div class="col-md-6">
				Niveau : Grosse daube
			</div>
		</div>
	</div>
	</div>
</div>
<%
}
%>
</div>

<jsp:include page="footer.jsp"></jsp:include>
