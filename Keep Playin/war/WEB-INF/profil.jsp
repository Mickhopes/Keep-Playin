<%@page import="java.util.Locale"%>
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
              <p class="float-right">
              <%
              	long diff = new Date().getTime() - p.getDateDePublication().getTime();
              	long jours = (diff / (1000*60*60*24));
              	long heures = (diff / (1000*60*60))%24;
              	long minutes = (diff / (1000*60))%60;
              	long secondes = (diff / 1000)%60;
				
				String affHeure = "Il y a ";
				if (jours > 0)
					affHeure = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE).format(p.getDateDePublication());
				else {
					if (heures > 0) 
  					affHeure += heures + " h, ";
  				if (minutes > 0)
  					affHeure += minutes + " m, ";
  				if (secondes > 0)
  					affHeure += secondes + " s";
  				if (affHeure.endsWith(", "))
  					affHeure = affHeure.substring(0, affHeure.length()-2);
				}
  			%>
  			<%= affHeure %>
              </p>
            </div>
            <div class=" col-md-9 text-publi">
              <span><%= p.getMessage() %></span>
            </div>
         </div>
          <hr />
    		<div class="row">
 				<form name="publication_form connectedText" method="post" action="/comm">
	           	<div class="form-group col-md-9">
	 					<input type="text" required="true" class="form-control publi" name="message" placeholder="Quelque chose à dire ?"></textarea>
				</div>
				<input type="hidden" value="<%= u.getId() %>" name="id"> 
				<input type="hidden" value="<%= p.getId() %>" name="id_publi"> 
	           	<button type="submit" class="btn btn-primary  col-md-2">Commenter</button>
       			</form>
    		</div>
        </div>
    	<%
    			List<Commentaire> cList = p.getCommentaires();
    			Collections.sort(cList);
    			if (!cList.isEmpty()) {
    	%>
    				<div class="thumbnail border_comment shadow_comment col-md-10 col-md-offset-2 margin_comment">
    	<%
    			}
    	
    			for(Commentaire c : cList) {
    	%>
    				<div class="row">
		            	<div class="col-md-2">
		            		<img src="photo-profil.jpg" alt="Avatar du commentaire" class="img-thumbnail height-comment">
		        		</div>
		        		<div class="col-md-10 name-comment">
		        			<p class="float-left"><%= c.getAuteur().getPrenom() + " " + c.getAuteur().getNom() %></p>
		        			<p class="float-right">
		        			<%
		        				diff = new Date().getTime() - c.getDateDeCommentaire().getTime();
		        				jours = (diff / (1000*60*60*24));
		        				heures = (diff / (1000*60*60))%24;
		        				minutes = (diff / (1000*60))%60;
		        				secondes = (diff / 1000)%60;
		        				
		        				affHeure = "Il y a ";
		        				if (jours > 0)
		        					affHeure = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE).format(c.getDateDeCommentaire());
		        				else {
		        					if (heures > 0) 
			        					affHeure += heures + " h, ";
			        				if (minutes > 0)
			        					affHeure += minutes + " m, ";
			        				if (secondes > 0)
			        					affHeure += secondes + " s";
			        				if (affHeure.endsWith(", "))
			        					affHeure = affHeure.substring(0, affHeure.length()-2);
		        				}
		        			%>
		        			<%= affHeure %>
		        			</p>
		        		</div>
		        		<div class="col-md-10 text-comment">
		        			<span><%= c.getMessage() %></span>
		        		</div>
	    		    </div>
        <%
    			}
    			
    			if (!cList.isEmpty()) {
    	%>
    				</div>
    	<%
    			}
    		}
        %>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
