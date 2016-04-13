<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,java.util.Collections,fr.keepplayin.model.Utilisateur,fr.keepplayin.model.DemandeAmi"%>
<jsp:include page="header.jsp">
	<jsp:param value="${sessionScope.nombreDemande}" name="nombreDemande" />
</jsp:include>
<c:if test="${!empty erreur}">
	<span class="error col-sm-5 col-sm-offset-4"> ${erreur} </span>
</c:if>

<div class="container" style="padding-top:50px;">
<h2>Demandes en attente :</h2>
<br>
<%
	List<DemandeAmi> dList = (List<DemandeAmi>)session.getAttribute("listeDemandes");
	for(DemandeAmi d : dList) {
%>
<div class="thumbnail border shadow padding_top col-sm-6 col-sm-offset-3">
	<div class="row">
		<div class="col-sm-3">
			<a href="/profil?id=<%= d.getSource().getId()%>"><img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-105" ></a>
		</div>
		<div class="col-sm-9">
		<div class="row">
			<div class="col-sm-4">
				<a href="/profil?id=<%= d.getSource().getId()%>"><%=d.getSource().getPrenom()+" "+d.getSource().getNom()%></a>
			</div>
		</div>
		<div class="row col-sm-12">
			<%if(d.getSource().getNomDeScene() == null) {%>Aucun nom de scène<% } else { out.print(d.getSource().getNomDeScene()); }%>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-12">
				<%= d.getMessage() %>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-2 col-sm-offset-1">
				<form action="/ajoutAmi" method="post">
					<input type="hidden" name="id_demande" value="<%= d.getId() %>">
					<input type="hidden" name="id" value="<%= d.getSource().getId() %>">
					<input type="hidden" name="choix" value="accepter">
					<button type="submit" class="btn btn-success">Accepter</button>
				</form>
			</div>
			<div class="col-sm-2 col-sm-offset-1">
				<form action="/ajoutAmi" method="post">
					<input type="hidden" name="id_demande" value="<%= d.getId() %>">
					<input type="hidden" name="id" value="<%= d.getSource().getId() %>">
					<input type="hidden" name="choix" value="refuser">
					<button type="submit" class="btn btn-danger">Refuser</button>
				</form>
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
