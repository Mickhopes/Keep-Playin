<%@page import="java.util.Locale"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.keepplayin.model.Utilisateur,java.util.List,java.text.SimpleDateFormat,java.util.Date,java.lang.Boolean,fr.keepplayin.model.Publication,fr.keepplayin.model.Commentaire,java.util.Collections, fr.keepplayin.model.Departement, fr.keepplayin.model.Instrument, fr.keepplayin.model.StyleMusical, fr.keepplayin.model.Style, fr.keepplayin.model.Niveau,fr.keepplayin.model.TypeInstrument" %>
<jsp:include page="header.jsp">
	<jsp:param value="${sessionScope.nombreDemande}" name="nombreDemande" />
</jsp:include>

<div class="container profil-container">
  <div class="infos-profil col-md-4">

  <!-- AVATAR -->
    <div class="photo-profil col-sm-12 shadow border">
      <div class="row">
	      <div class="col-sm-6">
          <!-- Copier contenu de instrument.txt -->
          <img src="/images/guitare-seche.png" class="photo photo-container ">
	      </div>
	      <div class="col-sm-6">
		      <div class="row names-profil">
		        <span class="names">Guitare Sèche</span>
		      </div>
	      </div>
      </div>
    </div>
  </div>

  <div class="col-sm-7 modif-profil col-sm-offset-1 shadow border">
    Statistiques ici
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
