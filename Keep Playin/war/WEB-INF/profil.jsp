<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.keepplayin.model.Utilisateur,java.util.List,java.text.SimpleDateFormat,java.util.Date,java.lang.Boolean,fr.keepplayin.model.Publication,fr.keepplayin.model.Commentaire,java.util.Collections" %>
<jsp:include page="header.jsp">
	<jsp:param value="${currentUrl}" name="currentUrl" />
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
		<label>Instruments</label><a href="#"><span class="badge badge-custom">5</span></a>
		 <div class="list-group">
		  <a href="#" class="list-group-item">First item</a>
		  <a href="#" class="list-group-item">Second item</a>
		  <a href="#" class="list-group-item">Third item</a>
	     </div>
    	</div>
    	<div class="row shadow border infos-details">
    	<label>Genres de musique</label><a href="#"><span class="badge badge-custom">7</span></a>
    	<div class="list-group">
		  <a href="#" class="list-group-item">First item</a>
		  <a href="#" class="list-group-item">Second item</a>
		  <a href="#" class="list-group-item">Third item</a>
	     </div>
    	</div>
    	<div class="row shadow border infos-details">
    	<label>Amis</label><a href="#"><span class="badge badge-custom">42</span></a>
    	<div class="list-group">
		  <a href="#" class="list-group-item">First item</a>
		  <a href="#" class="list-group-item">Second item</a>
		  <a href="#" class="list-group-item">Third item</a>
	     </div>
    	</div>
    	<div class="row shadow border infos-details">
    	<label>Autre</label><a href="#"><span class="badge badge-custom">0</span></a>
    	<div class="list-group">
		  <a href="#" class="list-group-item">First item</a>
		  <a href="#" class="list-group-item">Second item</a>
		  <a href="#" class="list-group-item">Third item</a>
	     </div>
    	</div>
    </div>
  </div>

  <div class="publis-profil col-md-8">
  <div class="thumbnail border shadow padding_top post-options">
  	<div class="row">
            <div class="col-md-2">
              <img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-publi" >
            </div>
            <div class="col-md-10 name-publi">
            <form name="publication_form connectedText" method="post" action="/publi">
            	 <div class="form-group">
  				<textarea required="true" class="form-control publi" name="message" rows="3" placeholder="Rock'n Roll Baby !"></textarea>
				</div>
				<input type="hidden" value="<%= u.getId() %>" name="id"> 
            	<button type="submit" class="btn btn-primary col-md-offset-10">Publier</button>
            </form>
            </div>
        </div>
  </div>

    <!-- Debut zone d'affichage du flux -->
    	<% 
    		List<Publication> pList = u.getPublications();
    		Collections.sort(pList);
    		for(Publication p : pList) {
    	%>
        <div class="thumbnail border shadow padding_top col-md-12">
          <div class="row">
            <div class="col-md-3">
              <img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-105" >
            </div>
            <div class="col-md-9 name-publi">
              <p class="float-left"><%= p.getAuteur().getPrenom() + " " + p.getAuteur().getNom() %></p>
              <p class="float-right">Il y a 10 min</p>
            </div>
            <div class=" col-md-9 text-publi">
              <span><%= p.getMessage() %></span>
            </div>
        	</div>
        </div>
        <%
    		}
        %>

        <!--  <div class="thumbnail border shadow col-md-10 col-md-offset-2 margin_comment">
            <div class="row">
            	<div class="col-md-2">
            		<img src="elias.jpg" alt="Avatar du commentaire" class="img-thumbnail height-comment">
        		</div>
        		<div class="col-md-10 name-comment">
        			<p class="float-left"> Elias de Kelliwic'h</p>
        			<p class="float-right"> Il y a 5 min </p>
        		</div>
        		<div class="col-md-6 text-comment">
        			<span> Un marron.</span>
        		</div>
    		    </div>
    		<hr>
    		<div class="row">
            	<div class="col-md-2">
            		<img src="photo-profil.jpg" alt="Avatar du commentaire" class="img-thumbnail height-comment">
        		</div>
        		<div class="col-md-10 name-comment">
        			<p class="float-left"> Merlin l'Enchtanteur</p>
        			<p class="float-right"> Il y a 3 min </p>
        		</div>
        		<div class="col-md-6 text-comment">
        			<span> Putain il est fort ce con !</span>
        		</div>
    		</div>
		</div>

        <div class="thumbnail border shadow padding_top col-md-12">
          <div class="row">
            <div class="col-md-3">
              <img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-105" >
            </div>
            <div class="col-md-9 name-publi">
              <p class="float-left">Merlin l'Enchanteur</p>
              <p class="float-right">Il y a 15 min</p>
            </div>
            <div class=" col-md-9 text-publi">
              <span>Quand je dis que Rome est à la Cité ce que la chèvre est au fromage de chèvre, je veux dire que c'est le petit plus qu'y est corollaire au noyau mais qui est pas directement dans le cœur du fruit ! </span>
            </div>
          </div>
        </div>-->
        <!-- Fin Model 2 -->
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
