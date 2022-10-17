<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>doC 페이지</h2>
<!-- name과 price는 각각 getter로 가져온다. -->
상품명  : ${map.product.name} <br>
가격 : ${map.product.price} <br>
</body>
</html>