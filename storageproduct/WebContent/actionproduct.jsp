<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/script.js"></script>

<div class="rightaction">
<form class="delcat" action="ProductController" method="post">
	
	<select name="title">
		
		<c:forEach var="pr" items="${sessionScope.productList}">
			 <option><c:out value="${pr.getTitle()}"/></option>
		</c:forEach>
		
	</select>
	
	<input type="submit"  value="удалить" />

</form>

<input type="submit" class="popup-link-1" value="Добавить" href="" />
 
<div class="popup-box" id="popup-box-1">
    <div class="close">X</div>
    <div class="top">
        <h2>Добавить продукт:</h2>
    	<form class="add" action="ProductController" method="post">
	
		<input placeholder="Название"type="text" name="prtitle" />
		
		<input placeholder="Цена" type="text" name="prprice" />
		
		<input placeholder="Количество" type="text" name="prnumber" />
		
		<input placeholder="Картинка" type="text" name="primg" />
		
		<input placeholder="Категория" type="text" name="pridcat" />
		
		<textarea name="prdescription" >
		
		</textarea>
		<input type="submit"  value="добавить" />
	
  </form>	
</div>
    
</div>

</div>

