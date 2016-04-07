<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param value="${currentUrl}" name="currentUrl" />
</jsp:include>
<c:if test="${!empty erreur}">
	<span class="error col-md-5 col-md-offset-4"> ${erreur} </span>
</c:if>

<div class="container profil-container">
  <div class="infos-profil col-md-4 border shadow">
    <div class="photo-profil col-md-12">
      <div class="photo-container col-md-6">
        <img src="merlin.jpg" class="photo">
      </div>
      <div class="names-profil col-md-6">
        <span class="names">Merlin</span><span class="names"> L'ENCHANTEUR</span>
      </div>
      <div class="pseudo-profil col-md-6">
        <span class="pseudo">Coco l'Asticot</span>
      </div>
      <div class="birthday-profil col-md-6">
        <span class="birthday-info"> 01/01/1133 (883 ans)</span>
      </div>
    </div>
  </div>

  <div class="publis-profil col-md-8">
    <!-- Debut zone d'affichage du flux -->
        <!-- Model 1 -->
        <div class="thumbnail border shadow padding_top">
          <div class="row">
            <div class="col-md-3">
              <img src="merlin.jpg" alt="Avatar du post" class="img-thumbnail height-105" >
            </div>
            <div class="col-md-9">
              <p class="float-left">Maurice D.</p>
              <p class="float-right">Il y a 10 min</p>
            </div>
            <div class=" col-md-9">
              <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mollis justo odio, at vestibulum arcu cursus sed. Nam id lectus justo. Mauris dapibus, ex ut scelerisque. </span>
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-md-3">
              <img src="merlin.jpg" alt="Avatar du post" class="img-thumbnail height-105" >
            </div>
            <div class="col-md-9">
              <p class="float-left">Maurice D.</p>
              <p class="float-right">Il y a 10 min</p>
            </div>
            <div class=" col-md-9">
              <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mollis justo odio, at vestibulum arcu cursus sed. Nam id lectus justo. Mauris dapibus, ex ut scelerisque. </span>
            </div>
          </div>
        </div>
        <!-- Fin Model 1 -->
        <!-- Model 2 -->
        <div class="thumbnail border shadow padding_top">
          <div class="row">
            <div class="col-md-3">
              <img src="merlin.jpg" alt="Avatar du post" class="img-thumbnail height-105" >
            </div>
            <div class="col-md-9">
              <p class="float-left">Maurice D.</p>
              <p class="float-right">Il y a 10 min</p>
            </div>
            <div class=" col-md-9">
              <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mollis justo odio, at vestibulum arcu cursus sed. Nam id lectus justo. Mauris dapibus, ex ut scelerisque. </span>
            </div>
          </div>
        </div>
        <div class="thumbnail border shadow padding_top">
          <div class="row">
            <div class="col-md-3">
              <img src="merlin.jpg" alt="Avatar du post" class="img-thumbnail height-105" >
            </div>
            <div class="col-md-9">
              <p class="float-left">Maurice D.</p>
              <p class="float-right">Il y a 10 min</p>
            </div>
            <div class=" col-md-9">
              <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mollis justo odio, at vestibulum arcu cursus sed. Nam id lectus justo. Mauris dapibus, ex ut scelerisque. </span>
            </div>
          </div>
        </div>
        <!-- Fin Model 2 -->
        <!-- Model 3 -->
        <div class="row">
          <div class="col-md-3">
            <div class="thumbnail shadow">
              <img id="test" src="merlin.jpg" alt="Avatar du post" class="img-thumbnail" >
            </div>
          </div>
          <div class="col-md-9">
            <div class="thumbnail shadow">
              <div class="row">
                <div class="col-md-12">
                  <p class="float-left">Maurice D.</p>
                  <p class="float-right">Il y a 10 min</p>
                </div>
                <div class="col-md-12">
                  <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mollis justo odio, at vestibulum arcu cursus sed. Nam id lectus justo. Mauris dapibus, ex ut scelerisque. </span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Fin Model 3 -->
        <!-- Model 4 -->
        <div class="thumbnail border shadow padding_top">
          <div class="row">
            <div class="col-md-2">
              <img src="merlin.jpg" alt="Avatar du post" class="img-circle avatar_post" >
            </div>
            <div class="col-md-10">
              <p class="float-left">Maurice D.</p>
              <p class="float-right">Il y a 10 min</p>
            </div>
            <div class=" col-md-10">
              <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mollis justo odio, at vestibulum arcu cursus sed. Nam id lectus justo. Mauris dapibus, ex ut scelerisque. </span>
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-md-2">
              <img src="merlin.jpg" alt="Avatar du post" class="img-circle avatar_post" >
            </div>
            <div class="col-md-10">
              <p class="float-left">Maurice D.</p>
              <p class="float-right">Il y a 10 min</p>
            </div>
            <div class=" col-md-10">
              <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mollis justo odio, at vestibulum arcu cursus sed. Nam id lectus justo. Mauris dapibus, ex ut scelerisque. </span>
            </div>
          </div>
        </div>
        <!-- Fin Model 4 -->
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
