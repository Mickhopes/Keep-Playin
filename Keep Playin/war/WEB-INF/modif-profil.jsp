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
    <form name="modif-profil" action="/modif" method="post">
      <div class="row">
        <div class="col-sm-3">
        Adresse e-mail :
        </div>
        <div class="col-sm-4"><%=u.getEmail()%>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-sm-3">
          Prénom :
        </div>
        <div class="col-sm-4"><input id="prenom" name="prenom" type="text" value="<%=u.getPrenom()%>">
        </div>
      </div>
      <div class="row">
        <div class="col-sm-3">
        Nom :
        </div>
        <div class="col-sm-4"><input id="nom" name="nom" type="text" value="<%=u.getNom()%>">
        </div>
      </div>
      <div class="row">
        <div class="col-sm-3">
        Nom de scène :
        </div>
        <div class="col-sm-4"><input id="nomDeScene" name="nomDeScene" type="text" value="<%=u.getNomDeScene() != null ? u.getNomDeScene() : ""%>">
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-sm-5">
        Ancien mot de passe :
        </div>
        <div class="col-sm-5"><input id="old-password" name="old-password" type="password">
        </div>
     </div>
      <div class="row">
        <div class="col-sm-5">
        Nouveau mot de passe :
      </div>
      <div class="col-sm-5"><input id="password" name="password" type="password" onkeyup="checkPasswordModif()">
     </div>
      </div>
      <div class="row">
        <div class="col-sm-5">
        Confirmer le nouveau mot de passe :
      </div>
      <div class="col-sm-5"><input id="password_conf" name="password_conf" type="password"
          placeholder="Confirmer le mot de passe"
          onkeyup="checkPasswordModif()">
        </div>
        <div id="confirmer" class="col-sm-1">
        
        </div>
      </div>
      <div class="row">
      	<div class="col-sm-12">
      		<span class="error">
				<c:if test="${!empty param.erreur}">
					<c:choose>
						<c:when test="${param.erreur == 'mememdp'}">
							Vous ne pouvez pas utiliser votre ancien mot de passe pour le nouveau
						</c:when>
						<c:when test="${param.erreur == 'mauvaismdp'}">
							Votre ancien mot de passe n'est pas le bon
						</c:when>
						<c:when test="${param.erreur == 'ancienmdp'}">
							Vous devez renseigner votre ancien mot de passe
						</c:when>
					</c:choose>
				</c:if>
			</span>
      	</div>
      </div>
      <hr>
      <div class="row">
        <div class="col-sm-4">
        Date de naissance :
      </div>
      <div class="col-sm-5">
        <select name="jour">
          <%
          	for(int i = 1; i <= 31; i++) {
          %>
          	<option value="<%= i %>" <%= Integer.parseInt(new SimpleDateFormat("dd").format(u.getDateDeNaissance())) == i ? "selected" : "" %>> <%= i %>
          <%
          	}
          %>
        </select>
        <select name="mois">
          <option value="01" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("01") ? "selected" : "" %>> Janvier
          <option value="02" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("02") ? "selected" : "" %>> Février
          <option value="03" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("03") ? "selected" : "" %>> Mars
          <option value="04" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("04") ? "selected" : "" %>> Avril
          <option value="05" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("05") ? "selected" : "" %>> Mai
          <option value="06" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("06") ? "selected" : "" %>> Juin
          <option value="07" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("07") ? "selected" : "" %>> Juillet
          <option value="08" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("08") ? "selected" : "" %>> Août
          <option value="09" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("09") ? "selected" : "" %>> Septembre
          <option value="10" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("10") ? "selected" : "" %>> Octobre
          <option value="11" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("11") ? "selected" : "" %>> Novembre
          <option value="12" <%= new SimpleDateFormat("MM").format(u.getDateDeNaissance()).equals("12") ? "selected" : "" %>> Décembre
        </select>
        <select name="annee" value="<%=new SimpleDateFormat("yyyy").format(u.getDateDeNaissance())%>">
        	<%
	          	for(int i = 2016; i >= 1905; i--) {
	        %>
            <option value="<%= i %>" <%= Integer.parseInt(new SimpleDateFormat("yyyy").format(u.getDateDeNaissance())) == i ? "selected" : "" %>> <%= i %>
             <%
	          	}
            %>
        </select>
      </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-sm-6">
          <input type="radio" class="gender" name="gender" value="Homme" <%if(u.getSexe().equals("Homme")){%>checked<%}%>> <span class="gender">Homme</span>
          <input type="radio" class="gender" name="gender" value="Femme" <%if(u.getSexe().equals("Femme")){%>checked<%}%>> <span class="gender">Femme</span>
          <input type="radio" class="gender" name="gender" value="Autre" <%if(u.getSexe().equals("Autre")){%>checked<%}%>> <span class="gender">Autre</span>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-sm-4">
        Département :
      </div>
      <div class="col-sm-4">
        <select name="dpt">
          <option value="">
          <% for(Departement dpt : Departement.values()){
            %>
            <option value="<%=dpt.ordinal()%>" <%= u.getDpt() != null && u.getDpt() == dpt ? "selected" : "" %>> <%= dpt.getDpt() %>
            <%
          }%>
        </select>
      </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
          <button id="btn_modif_profil"  type="submit" name="modif-save" class="btn btn-success">Enregistrer</button>
          <a href="/profl"><button type="button" name="modif-cancel" class="btn btn-danger">Annuler</button></a>
        </div>
      </div>
    </form>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
