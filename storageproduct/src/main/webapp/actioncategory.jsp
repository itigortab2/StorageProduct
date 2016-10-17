<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/script.js"></script>

<div class="rightaction">
	
	<form class="delcat" action="CategoryController" method="post">

		<select name="titlecat">

			<c:forEach var="cat" items="${sessionScope.listCategory}">
				<option><c:out value="${cat.getTitle()}" /></option>
			</c:forEach>

		</select> <input type="submit" value="удалить" />

	</form>

	<input type="submit" class="popup-link-1" value="Добавить" href="" />

	<div class="popup-box" id="popup-box-1">
		<div class="close">X</div>
		<div class="top">
			<h2>Добавить категорию:</h2>
			<form class="add" action="CategoryController" method="post">

				<input type="text" name="cattitle" />

				<textarea name="catdescription">
		
		</textarea>
				<input type="submit" value="добавить" />

			</form>
		</div>

	</div>

</div>

