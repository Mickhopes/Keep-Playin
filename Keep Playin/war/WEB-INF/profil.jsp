<%@page import="java.util.Locale"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.keepplayin.model.Utilisateur,java.util.List,java.text.SimpleDateFormat,java.util.Date,java.lang.Boolean,fr.keepplayin.model.Publication,fr.keepplayin.model.Commentaire,java.util.Collections" %>
<jsp:include page="header.jsp">
	<jsp:param value="${sessionScope.nombreDemande}" name="nombreDemande" />
</jsp:include>
<c:if test="${!empty erreur}">
	<span class="error col-sm-5 col-sm-offset-4"> ${erreur} </span>
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
  <div class="infos-profil col-sm-4">

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
      <%
      	if (!enVisite) {
      %>
      <hr>
      <div class="row">
      	<div class="col-sm-12 lien-profil">
      		<a href="/modif"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Modifier mon profil</a>
      	</div>
      </div>
      <hr>
      <div class="row">
      	<div class="col-sm-12 lien-profil" style="padding-bottom:15px;">
      		<a href="/modifInstrument"><span class="glyphicon glyphicon-headphones" aria-hidden="true"></span> Gérer mes instruments</a>
      	</div>
      </div>
      <%
      	}
      
      	Boolean estAmi = (Boolean) session.getAttribute("ami");
      	if (estAmi != null && estAmi)
        {
      %>
      <hr>
      <div class="row">
      	<div class="col-sm-4 col-sm-offset-4" style="padding-bottom:15px;">
      		<form action="/supprimerAmi" method="post">
      			<input type="hidden" name="id" value="<%= u.getId() %>">
      			<button class="btn btn-danger">Ne plus être ami</button>
      		</form>
      	</div>
      </div>
      <%
      	}
      %>
    </div>
    <!-- INFOS -->
    <div class="infos-container col-sm-12">
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

  <div class="publis-profil col-sm-8">
  <%
  	if (estAmi != null && estAmi || !enVisite) {
  %>
  	<div class="thumbnail border shadow padding_top post-options">
  	<div class="row">
         <div class="col-sm-2">
           <img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-publi" >
         </div>
         <div class="col-sm-10 name-publi">
         <form name="publication_form connectedText" method="post" action="/publi">
         	 <div class="form-group">
				<textarea required="true" class="form-control publi" name="message" rows="3" placeholder="Rock'n Roll Baby !"></textarea>
			</div>
			<input type="hidden" value="<%= u.getId() %>" name="id"> 
         	<button type="submit" class="btn btn-primary col-sm-offset-10">Publier</button>
         </form>
         </div>
      </div>
    </div>
  <%
  	} else {
  		Boolean estEnAttente = (Boolean) session.getAttribute("enAttente");
  		if (estEnAttente != null) {
  			if (!estEnAttente) {
  %>
  	<div class="thumbnail border shadow padding_top post-options">
  		<div class="row">
         <div class="col-sm-12 name-publi">
         <form name="publication_form connectedText" method="post" action="/demandeAmi">
         	 <div class="form-group">
				<textarea required="true" class="form-control publi" name="message" rows="3">Bonjour, je souhaiterais vous ajouter dans ma liste d'amis !</textarea>
			</div>
			<input type="hidden" value="<%= u.getId() %>" name="id"> 
         	<button type="submit" class="btn btn-success col-sm-offset-5 col-sm-2">Ajouter en ami</button>
         </form>
         </div>
      </div>
   </div>
  <%
  			}
  		}
  	}
  %>

    <!-- Debut zone d'affichage du flux -->
    	<% 
    		List<Publication> pList = u.getPublications();
    		Collections.sort(pList);
    		for(Publication p : pList) {
    	%>
        <div class="thumbnail border shadow padding_top col-sm-12">
          <div class="row">
            <div class="col-sm-3">
              <img src="photo-profil.jpg" alt="Avatar du post" class="img-thumbnail height-105" >
            </div>
            <div class="col-sm-9 name-publi">
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
            <div class=" col-sm-9 text-publi">
              <span><%= p.getMessage() %></span>
            </div>
         </div>
         <%
         	if (estAmi != null && estAmi || !enVisite) {
         %>
          <hr />
    		<div class="row">
 				<form name="publication_form connectedText" method="post" action="/comm">
	           	<div class="form-group col-sm-9">
	 					<input type="text" required="true" class="form-control publi" name="message" placeholder="Quelque chose à dire ?"></textarea>
				</div>
				<input type="hidden" value="<%= u.getId() %>" name="id"> 
				<input type="hidden" value="<%= p.getId() %>" name="id_publi"> 
	           	<button type="submit" class="btn btn-primary  col-sm-2">Commenter</button>
       			</form>
    		</div>
    	<%
         	}
    	%>
        </div>
    	<%
    			List<Commentaire> cList = p.getCommentaires();
    			Collections.sort(cList);
    			if (!cList.isEmpty()) {
    	%>
    				<div class="thumbnail border_comment shadow_comment col-sm-10 col-sm-offset-2 margin_comment">
    	<%
    			}
    	
    			for(Commentaire c : cList) {
    	%>
    				<div class="row">
		            	<div class="col-sm-2">
		            		<img src="photo-profil.jpg" alt="Avatar du commentaire" class="img-thumbnail height-comment">
		        		</div>
		        		<div class="col-sm-10 name-comment">
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
		        		<div class="col-sm-10 text-comment">
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
