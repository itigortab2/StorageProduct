<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<link href="css/style.css" rel="stylesheet"> 
 <link href="css/reset.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<div id="header">
	<%@ page import="ru.storageproduct.Model.User" %>
	<%
	 	HttpSession  s = request.getSession();
		User u = (User) s.getAttribute("user");
	
	 	if( u == null ) 
			response.sendRedirect("index.jsp");
	 %>
		
	<jsp:useBean id="user" scope="session" class="ru.storageproduct.Model.User" /> 	
	
	<h1>Вы зашли как <jsp:getProperty name="user" property="login" /></h1>	
		
	<span class="action">
			<form action="Logout" method="post">
				
				<input type="submit"  value="Выйти"  >	
			</form>
			
			<form action=ProductController method="post">
				
				<input type="submit"  value="Продукты"  >	
			</form>
			
			
			
		</span>
	</div>

	<div class="main">

		<div class="panel">
		
		
			<c:if test = "${sessionScope.user.permission == 1}" >
			
				<jsp:include page="actioncategory.jsp" />
					
			</c:if>
		
				<form class="selcont" action="CategoryController" method="post">
					<span>Количество записей на странице:</span>
					<select name="selectCategory">
		  				<option>5</option>
		  				<option>10</option>	
		  				<option>15</option>
		  				<option>Все</option>		
					</select>
			
					<input type="submit" value="Показать" />
				</form>
			</div>
			
			<table id="cattable"> 
			
				<tr class="titletable">
					<td><h2>Название</h2></td>
					<td><h2>Описание</h2></td>
				</tr>
				
				<c:forEach var="cat" items="${sessionScope.listCategory}">
		   			 <tr>
						<td><c:out value="${cat.getTitle()}"/></td>
						<td><c:out value="${cat.getDescription()}"/></td>	
					</tr>
				</c:forEach>
			</table>
		 
	</div>
</body>
</html>