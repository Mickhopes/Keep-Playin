<%@page import="java.util.Locale"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.keepplayin.model.Utilisateur,java.util.List,java.text.SimpleDateFormat,java.util.Date,java.lang.Boolean,fr.keepplayin.model.Publication,fr.keepplayin.model.Commentaire,java.util.Collections, fr.keepplayin.model.Departement, fr.keepplayin.model.Instrument, fr.keepplayin.model.StyleMusical, fr.keepplayin.model.Style, fr.keepplayin.model.Niveau,fr.keepplayin.model.TypeInstrument" %>
<jsp:include page="header.jsp">
	<jsp:param value="${sessionScope.nombreDemande}" name="nombreDemande" />
</jsp:include>
<c:if test="${!empty erreur}">
	<span class="error col-md-5 col-md-offset-4"> ${erreur} </span>
</c:if>

<%
	Utilisateur u;
	Boolean enVisite = (Boolean) session.getAttribute("visite");
	if (enVisite) {
		u = (Utilisateur) session.getAttribute("utilisateurVisite");
	} else {
		u = (Utilisateur) session.getAttribute("utilisateur");
	}
%>

<div class="container profil-container">
  <div class="infos-profil col-md-4">

  <!-- AVATAR -->
    <div class="photo-profil col-md-12 shadow border">
      <div class="photo-container col-md-6">
        <img src="photo-profil.jpg" class="photo">
      </div>
      <div class="names-profil col-md-6">
        <span class="names"><%= u.getPrenom() %></span><span class="names"> <%= u.getNom() %></span>
      </div>
      <div class="pseudo-profil col-md-6">
        <span class="pseudo"><% if(u.getNomDeScene() == null) { out.print("Aucun nom de scène"); } else { out.print(u.getNomDeScene()); } %></span>
      </div>
      <div class="birthday-profil col-md-6">
        <span class="birthday-info"> <%= new SimpleDateFormat("dd/MM/yyyy").format(u.getDateDeNaissance()) %></span>
      </div>
    </div>
    <!-- INFOS -->
    <div class="infos-container col-md-12">
    	<div class="row shadow border infos-details">
		<label style="padding-left:10px">Instruments</label><a href="#"><span class="badge badge-custom">5</span></a>
		 <div class="list-group">
		  <a href="#" class="list-group-item">First item</a>
		  <a href="#" class="list-group-item">Second item</a>
		  <a href="#" class="list-group-item">Third item</a>
	     </div>
    	</div>
    	<div class="row shadow border infos-details">
    	<label style="padding-left:10px">Genres de musique</label><a href="#"><span class="badge badge-custom">7</span></a>
    	<div class="list-group">
		  <a href="#" class="list-group-item">First item</a>
		  <a href="#" class="list-group-item">Second item</a>
		  <a href="#" class="list-group-item">Third item</a>
	     </div>
    	</div>
    	<div class="row shadow border infos-details">
    	<%
    		List<Utilisateur> amisList = u.getAmis();
    		Collections.sort(amisList);
    	%>
    	<label style="padding-left:10px">Amis</label><span class="badge badge-custom"><%= amisList.size() %></span>
    	<div class="list-group">
    	  <%
    	  	for(Utilisateur ami : amisList) {
    	  %>
			  <a href="/profil?id=<%= ami.getId() %>" class="list-group-item"><%= ami.getPrenom() + " " + ami.getNom() %></a>
		  <%
    	  	}
		  %>
    	</div>
    	</div>
    </div>
  </div>

  <div class="col-md-7 modif-profil col-md-offset-1 shadow border">
    <form name="modif-profil" action="/modif" method="post">
      <div class="row">
        <div class="col-md-3">
        Adresse e-mail :
        </div>
        <div class="col-md-4"><%=u.getEmail()%>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-3">
          Prénom :
        </div>
        <div class="col-md-4"><input id="prenom" name="prenom" type="text" value="<%=u.getPrenom()%>"
          class="input-xlarge input-name">
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
        Nom :
        </div>
        <div class="col-md-4"><input id="nom" name="nom" type="text" value="<%=u.getNom()%>"
          class="input-xlarge input-name">
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
        Nom de scène :
        </div>
        <div class="col-md-4"><input id="nomDeScene" name="nomDeScene" type="text" value="<%=u.getNomDeScene() != null ? u.getNomDeScene() : ""%>"
          class="input-xlarge input-name">
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-4">
        Ancien mot de passe :
        </div>
        <div class="col-md-5"><input id="old-password" name="old-password" type="password"
       class="input-xlarge input-password">
        </div>
     </div>
      <div class="row">
        <div class="col-md-4">
        Nouveau mot de passe :
      </div>
      <div class="col-md-5"><input id="password" name="password" type="password"
       class="input-xlarge input-password">
     </div>
      </div>
      <div class="row">
        <div class="col-md-4">
        Confirmer le nouveau mot de passe :
      </div>
      <div class="col-md-5"><input id="password_conf" name="password_conf" type="password"
          placeholder="Confirmer le mot de passe" class="input-xlarge input-password"
          onkeyup="checkPassword()">
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-4">
        Date de naissance :
      </div>
      <div class="col-md-5">
        <select name="jour" size="1" value="<%=new SimpleDateFormat("dd").format(u.getDateDeNaissance())%>">
          <c:forEach var="i" begin="1" end="31">
            <option><c:out value="${i}"/>
          </c:forEach>
        </select>
        <select name="mois" size="1" value="<%=new SimpleDateFormat("MM").format(u.getDateDeNaissance())%>">
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
        <select name="annee" size ="1" value="<%=new SimpleDateFormat("yyyy").format(u.getDateDeNaissance())%>">
          <c:forEach var="i" begin="1905" end="2016">
            <option><c:out value="${2016-i+1905}"/>
          </c:forEach>
        </select>
      </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-6">
          <input type="radio" class="gender" name="gender" value="Homme" <%if(u.getSexe().equals("Homme")){%>checked<%}%>> <span class="gender">Homme</span>
          <input type="radio" class="gender" name="gender" value="Femme" <%if(u.getSexe().equals("Femme")){%>checked<%}%>> <span class="gender">Femme</span>
          <input type="radio" class="gender" name="gender" value="Autre" <%if(u.getSexe().equals("Autre")){%>checked<%}%>> <span class="gender">Autre</span>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-4">
        Département :
      </div>
      <div class="col-md-4">
        <select name="dpt" value="<%=u.getDpt() != null ? u.getDpt() : ""%>">
          <option value="">
          <% for(Departement dpt : Departement.values()){
            %>
            <option value="<%=dpt.getCode()%>"> <%= dpt.getDpt() %>
            <%
          }%>
        </select>
      </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-4">
        Instrument principal :
      </div>
      <div class="col-md-5">
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
        <div class="col-md-4">
        Niveau instrument principal :
      </div>
      <div class="col-md-5">
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
        <div class="col-md-4">
        Date de début d'apprentissage :
      </div>
      <div class="col-md-6">
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
      <hr>
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <button type="submit" name="modif-save" class="btn btn-success">Enregistrer</button>
          <a href="/profl"><button type="button" name="modif-cancel" class="btn btn-danger">Annuler</button></a>
        </div>
      </div>
    </form>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
