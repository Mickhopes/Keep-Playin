<%@page import="java.util.Locale"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.keepplayin.model.Utilisateur,java.util.List,java.text.SimpleDateFormat,java.util.Date,java.lang.Boolean,fr.keepplayin.model.Publication,fr.keepplayin.model.Commentaire,java.util.Collections, fr.keepplayin.model.Departement, fr.keepplayin.model.Instrument, fr.keepplayin.model.StyleMusical, fr.keepplayin.model.Style, fr.keepplayin.model.Niveau,fr.keepplayin.model.TypeInstrument" %>
<jsp:include page="header.jsp">
	<jsp:param value="${sessionScope.nombreDemande}" name="nombreDemande" />
</jsp:include>

<%
	Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
%>

<div class="container profil-container">
  <div class="infos-profil col-md-4">

  <!-- AVATAR -->
    <div class="photo-profil col-sm-12 shadow border">
      <div class="row">
	      <div class="col-sm-6">
	        <img src="photo-profil.jpg" class="photo photo-container ">
	      </div>
	      <div class="col-sm-6">
		      <div class="row names-profil">
		        <span class="names"><%= u.getPrenom() %></span><span class="names"> <%= u.getNom() %></span>
		      </div>
		      <div class="row pseudo-profil">
		        <span class="pseudo"><% if(u.getNomDeScene() == null) { out.print("Aucun nom de scène"); } else { out.print(u.getNomDeScene()); } %></span>
		      </div>
		      <div class="row birthday-profil">
		        <span class="birthday-info">Né(e) le <%= new SimpleDateFormat("dd/MM/yyyy").format(u.getDateDeNaissance()) %></span>
		      </div>
		      <div class="row">
		        <span>Sexe: <%= u.getSexe() %></span>
		      </div>
		      <%
		      	if (u.getDpt() != null) {
		      %>
		      <div class="row">
		        <span>Département: <%= u.getDpt().getDpt() %></span>
		      </div>
		      <%
		      	}
		      %>
	      </div>
      </div>
    </div>
  </div>

  <div class="col-sm-7 modif-profil col-sm-offset-1 shadow border">
    <form name="modif-profil" action="/modifInstrument" method="post">
      <div class="row">
        <div class="col-sm-4">
        Instrument principal :
      </div>
      <div class="col-sm-5">
        <select name="instrument-principal">
          <option value="">
          <% for(TypeInstrument instrument : TypeInstrument.values()){
            %>
            <option value="<%=instrument.ordinal()%>" <%= u.getInstrumentPrincipal() != null && u.getInstrumentPrincipal().getType().ordinal() == instrument.ordinal() ? "seleted" : "" %>> <%= instrument.getNom() %>
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
        <select name="niv-instrument">
          <% for(Niveau niv : Niveau.values()){
            %>
            <option value="<%=niv.ordinal()%>" <%= u.getNiveauInstrumentPrincipal() != null && u.getNiveauInstrumentPrincipal().ordinal() == niv.ordinal() ? "seleted" : "" %>> <%= niv.toString() %>
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
        <select name="jour-apprenti" >
          <%
          	for(int i = 1; i <= 31; i++) {
          %>
          	<option value="<%= i %>" <%= u.getDebutApprentissage() != null && Integer.parseInt(new SimpleDateFormat("dd").format(u.getDebutApprentissage())) == i ? "selected" : "" %>> <%= i %>
          <%
          	}
          %>
        </select>
        <select name="mois-apprenti">
          <option value="01" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("01") ? "selected" : "" %>> Janvier
          <option value="02" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("02") ? "selected" : "" %>> Février
          <option value="03" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("03") ? "selected" : "" %>> Mars
          <option value="04" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("04") ? "selected" : "" %>> Avril
          <option value="05" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("05") ? "selected" : "" %>> Mai
          <option value="06" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("06") ? "selected" : "" %>> Juin
          <option value="07" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("07") ? "selected" : "" %>> Juillet
          <option value="08" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("08") ? "selected" : "" %>> Août
          <option value="09" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("09") ? "selected" : "" %>> Septembre
          <option value="10" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("10") ? "selected" : "" %>> Octobre
          <option value="11" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("11") ? "selected" : "" %>> Novembre
          <option value="12" <%= u.getDebutApprentissage() != null && new SimpleDateFormat("dd").format(u.getDebutApprentissage()).equals("12") ? "selected" : "" %>> Décembre
        </select>
        <select name="annee-apprenti" size ="1" value="<%=u.getDebutApprentissage() != null ? new SimpleDateFormat("yyyy").format(u.getDebutApprentissage()) : ""%>">
          <%
          	for(int i = 2016; i >= 1905; i--) {
          %>
          	<option value="<%= i %>" <%= u.getDebutApprentissage() != null && Integer.parseInt(new SimpleDateFormat("yyyy").format(u.getDebutApprentissage())) == i ? "selected" : "" %>> <%= i %>
          <%
          	}
          %>
        </select>
      </div>
      </div>
      <div class="row" style="padding-top: 20px">
      	<div class="col-sm-2 col-sm-offset-4">
      		<button type="submit" class="btn btn-success">Enregistrer</button>
      	</div>
      	<div class="col-sm-2">
      		<a href="/profil"><button class="btn btn-danger">Annuler</button></a>
      	</div>
      </div>
    </form>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
