<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, java.util.Collections, fr.keepplayin.model.Utilisateur, fr.keepplayin.model.TypeInstrument, fr.keepplayin.model.Niveau"%>
<jsp:include page="header.jsp">
	<jsp:param value="${currentUrl}" name="currentUrl" />
</jsp:include>
<c:if test="${!empty erreur}">
	<span class="error col-sm-5 col-sm-offset-4"> ${erreur} </span>
</c:if>

<div class="row">
        <div class="col-sm-4">
        Instrument principal :
      </div>
      <div class="col-sm-5">
        <select name="instrument-principal" value="<%= u.getInstrumentPrincipal() != null ? u.getInstrumentPrincipal().getType().getNom() : ""%>">
          <option value="">
          <% for(TypeInstrument instrument : TypeInstrument.values()){
            %>
            <option value="<%=instrument.getNom()%>"> <%= instrument.getNom() %>
            <%
          }%>
        </select>
      </div>
      </div>
      <div class="row">
        <div class="col-sm-4">
        Niveau instrument principal :
      </div>
      <div class="col-sm-5">
        <select name="niv-instrument" value="<%=u.getNiveauInstrumentPrincipal() != null ? u.getNiveauInstrumentPrincipal().toString() : ""%>">
          <option value="">
          <% for(Niveau niv : Niveau.values()){
            %>
            <option value="<%=niv.toString()%>"> <%= niv.toString() %>
            <%
          }%>
        </select>
      </div>
      </div>
      <div class="row">
        <div class="col-sm-4">
        Date de début d'apprentissage :
      </div>
      <div class="col-sm-6">
        <select name="jour-apprenti" size="1" value="<%=u.getDebutApprentissage() != null ? new SimpleDateFormat("dd").format(u.getDebutApprentissage()) :""%>">
          <option value="">
          <c:forEach var="i" begin="1" end="31">
            <option><c:out value="${i}"/>
          </c:forEach>
        </select>
        <select name="mois-apprenti" size="1" value="<%=u.getDebutApprentissage() != null ? new SimpleDateFormat("MM").format(u.getDebutApprentissage()) : ""%>">
          <option value="">
          <option value="01"> Janvier
          <option value="02"> Février
          <option value="03"> Mars
          <option value="04"> Avril
          <option value="05"> Mai
          <option value="06"> Juin
          <option value="07"> Juillet
          <option value="08"> Août
          <option value="09"> Septembre
          <option value="10"> Octobre
          <option value="11"> Novembre
          <option value="12"> Décembre
        </select>
        <select name="annee-apprenti" size ="1" value="<%=u.getDebutApprentissage() != null ? new SimpleDateFormat("yyyy").format(u.getDebutApprentissage()) : ""%>">
          <option value="">
          <c:forEach var="i" begin="1905" end="2016">
            <option><c:out value="${2016-i+1905}"/>
          </c:forEach>
        </select>
      </div>
      </div>

<div class="row">
<div class="resultats-recherche col-sm-6 col-sm-offset-3">
	<form name="recherche-form" action="/recherche" method="get">
	<div class="row">
			<div class="col-sm-3">
				Personne à rechercher :
			</div>
	    <div class="form-group col-sm-9">
	      <input name="recherche" type="text" placeholder="Rechercher..." class="form-control" value="<%= request.getParameter("recherche") %>">
	    </div>
	</div>
	<div class="row">
		<div class="col-sm-4">
			Instrument :
			<select name="type" value="<%= request.getParameter("type") != null && !request.getParameter("type").equals("") ? TypeInstrument.values()[Integer.parseInt(request.getParameter("type"))] : "" %>">
				<option value="">Indifférent</option>
				<%
					for(TypeInstrument type : TypeInstrument.values()) {
				%>
					<option value="<%= type.ordinal() %>"> <%= type.getNom() %>
				<%
					}
				%>
			</select>
		</div>
		<div class="col-sm-4">
			Niveau :
			<select name="niveau" value="<%= request.getParameter("niveau") != null && !request.getParameter("niveau").equals("") ? TypeInstrument.values()[Integer.parseInt(request.getParameter("niveau"))] : "" %>">
				<option value="">Indifférent</option>
				<%
					for(Niveau niveau : Niveau.values()) {
				%>
					<option value="<%= niveau.ordinal() %>"> <%= niveau.toString() %>
				<%
					}
				%>
			</select>
		</div>
		<div class="col-sm-2 col-sm-offset-1">
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
	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
	List<Utilisateur> uList = (List<Utilisateur>)request.getAttribute("resultats");
	Collections.sort(uList);
	for(Utilisateur u : uList) {
%>
<div class="thumbnail border shadow padding_top col-sm-6 col-sm-offset-3">
	<div class="row">
		<div class="col-sm-3">
			<a href="/profil?id=<%= u.getId()%>"><img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-105" ></a>
		</div>
		<div class="col-sm-9">
		<div class="row">
			<div class="col-sm-4">
				<a href="/profil?id=<%= u.getId()%>"><%=u.getPrenom()+" "+u.getNom()%></a>
			</div>
			<%
				if (user.estAmi(u)) {
			%>
			<div class="col-sm-3 col-sm-offset-5">
				Ami <span class="glyphicon glyphicon-ok green" aria-hidden="true" style="padding-left:10px;"></span>
			</div>
			<%
				}
			%>
		</div>
		<div class="row col-sm-12">
			<%if(u.getNomDeScene() == null)%>Aucun nom de scène<%else %>u.getNomDeScene()%>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-6">
				Instrument principal : <%= u.getInstrumentPrincipal() != null ? u.getInstrumentPrincipal().getType().getNom() : "Aucun" %>
			</div>
			<div class="col-sm-6">
				Niveau : <%= u.getNiveauInstrumentPrincipal() != null ? u.getNiveauInstrumentPrincipal().toString() : "Aucun" %>
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
