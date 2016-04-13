<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param value="${currentUrl}" name="currentUrl" />
</jsp:include>

<div class="container profil-container">
	<div class="col-sm-6 col-sm-offset-3" style="text-align:center">
		<h1>Utilisateur introuvable !</h1>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
