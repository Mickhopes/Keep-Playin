<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param value="${currentUrl}" name="currentUrl" />
</jsp:include>
<c:if test="${!empty erreur}">
	<span class="error col-md-5 col-md-offset-4"> ${erreur} </span>
</c:if>

  <div class="container index-container">
	 	<div class="col-md-5 jumbo">
      <!-- <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="#">About</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
          </ul>
        </nav>
        <h3 class="text-muted">Project name</h3>
      </div> -->
	
      <div class="jumbotron image-accueil">
        <span class="welcome">Bienvenue sur <br>Keep Playin' !</span>
        <span class="lead msg-home">Si vous êtes nouveau par ici, lancez-vous et inscrivez-vous via le formulaire. Sinon connectez-vous grâce à la barre de navigation en haut.</span>
<!--         <p><a class="btn btn-lg btn-success" href="#" role="button">Je m'inscris !</a></p> -->
      </div>
    </div>

     <!--  <div class="row marketing">
        <div class="col-lg-6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

        <div class="col-lg-6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
      </div> -->

      <div class="col-md-6 col-md-offset-1">

        <c:choose>
          <c:when test="${empty param.etat}">
            <!--  code généré grâce au site  -->
            <form class="form-horizontal"
              id="form_inscription" action="Init" method="post">
              <fieldset>

                <!-- Form Name -->
                <legend>Inscription</legend>

                <div class="control-group form-inscription">
                  <div class="controls">
                    

                      <input id="prenom" name="prenom" type="text" placeholder="Prénom"
                        class="input-xlarge input-name" required="true">
                      <input id="nom" name="nom" type="text" placeholder="Nom"
                      class="input-xlarge input-name" required="true">
                    
                  </div>
                </div>

                 <span class="error">
					<c:if test="${!empty param.erreur}">
						<c:choose>
							<c:when test="${param.erreur == 'utilise'}">
								Cette adresse e-mail est déjà utilisée !
							</c:when>
						</c:choose>
					</c:if>
				</span>
                <!-- Text input-->
                <div class="control-group form-inscription">
                  <!-- <label class="control-label" for="email">Adresse e-mail</label> -->
                  <div class="controls">
                    
                      <input id="email" name="email" type="text" placeholder="Adresse e-mail"
                        class="input-xlarge input-mail" required="true">
                    
                  </div>
                </div>
               

                <!-- Text input-->
                <div class="control-group form-inscription">
                <!--   <label class="control-label" for="password">Mot de passe</label> -->
                  <div class="controls">
                    
                      <input id="password" name="password" type="password"
                        placeholder="Mot de passe" class="input-xlarge input-password" required="true">
                    
                  </div>
                </div>

                <!-- Text input-->
                <div class="control-group form-inscription">
                  <!-- <label class="control-label" for="password_conf">Confirmer
                    le mot de passe</label> -->
                  <div class="controls">
                    
                      <input id="password_conf" name="password_conf" type="password"
                        placeholder="Confirmer le mot de passe" class="input-xlarge input-password" required="true"
                        onkeyup="checkPassword()">
                    
                  </div>
                </div>

                <div class="control-group form-inscription">
                  <label class="control-label" for="birthday">Date de naissance</label>
                  <div class="controls">
                  
                    <select name="jour" size="1">
                      <c:forEach var="i" begin="1" end="31">
                        <option><c:out value="${i}"/>
                      </c:forEach>
                    </select>
                    <select name="mois" size="1">
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
                    <select name="annee" size ="1">
                      <c:forEach var="i" begin="1905" end="2016">
                        <option><c:out value="${2016-i+1905}"/>
                      </c:forEach>
                    </select>
                  
                  </div>
                </div>

                <div class="control-group form-inscription">
                <label class="control-label" for="gender">Sexe</label>
                  <div class="controls">
                  
                    <input type="radio" name="gender" value="Homme"> <span class="gender">Homme</span>
                    <input type="radio" class="gender" name="gender" value="Femme"> <span class="gender">Femme</span>
                    <input type="radio" class="gender" name="gender" value="Autre"> <span class="gender">Autre</span>
                    
                  </div>
                </div>


                <!-- <span class="error">
                  <c:if test="${!empty param.erreur}">
                    <c:choose>
                      <c:when test="${param.erreur == 'utilise'}">
                        Ce pseudo est déjà utilisé !
                      </c:when>
                      <c:when test="${param.erreur == 'connexion_erreur'}">
                        Erreur de connexion, veuillez réessayer plus tard.
                      </c:when>
                    </c:choose>
                  </c:if>
                </span> -->

                <!-- Button -->
                <div class="control-group">
                  <label class="control-label" for="btn_inscription"></label>
                  <div class="controls">
                    <button id="btn_inscription" name="btn_inscription"
                      class="btn btn-success" disabled="true">S'inscrire</button>
                  </div>
                </div>

              </fieldset>
            </form>
          </c:when>
          <c:when test="${!empty param.etat && param.etat == 'succes'}">
            <span class="valide col-lg-6 col-lg-offset-3">
              Inscription réussie !
              <br />
              Vous pouvez maintenant vous connecter et naviguer sur le site.
            </span>
          </c:when>
        </c:choose>
      </div>

    </div> <!-- /container -->

  <jsp:include page="footer.jsp"></jsp:include>
