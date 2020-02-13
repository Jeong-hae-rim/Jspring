<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선택된 상품 정보는 다음과 같습니다.(스크립트 태그)</h1>
	<hr>
	<%
		ProductVO vo = (ProductVO)session.getAttribute("psession");
		if (vo != null) {
	%>
	선택된 사과의 갯수 :
	<%=vo.getApple()%><br>
	선택된 바나나의 갯수 :
	<%=vo.getBanana()%><br>
	선택된 한라봉의 갯수 :
	<%=vo.getHanra()%><br>
	<%
		} else {
	%>
	정보가 없습니다.
	<%
		}
	%>
	<hr>
	
	<h1>선택된 상품 정보는 다음과 같습니다.(액션 태그)</h1>
	<hr>
	<jsp:useBean id="psession" class="vo.ProductVO" scope="session" />
	선택된 사과의 갯수 :
	<jsp:getProperty name="psession" property="apple"/><br>
	선택된 바나나의 갯수 :
	<jsp:getProperty name="psession" property="banana"/><br>
	선택된 한라봉의 갯수 :
	<jsp:getProperty name="psession" property="hanra"/><br>
	<hr>
	
	<h1>선택된 상품 정보는 다음과 같습니다.(표현 언어EL)</h1>
	<hr>
	선택된 사과의 갯수 :
	${sessionScope.psession.apple}<br>
	선택된 바나나의 갯수 :
	${sessionScope.psession.banana}<br>
	선택된 한라봉의 갯수 :
	${sessionScope.psession.hanra}<br>
	
	<br>
	<a href='${header.referer}'>상품선택화면</a>
</body>
</html>