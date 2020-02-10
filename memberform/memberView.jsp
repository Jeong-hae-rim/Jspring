<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스크립트 태그</h1>
<h1>회원 정보</h1>
<%
	MemberVO vo = (MemberVO)request.getAttribute("memberVO");
%>
<%if(vo != null){%>
<ul>
<li> 회원 이름 : <%=vo.getName() %></li>
<li> 계정 : <%=vo.getId() %></li>
<li> 암호 : <%=vo.getPasswd() %></li>
<li> 전화번호 : <%=vo.getPhone() %></li>
</ul>
<%}else{%>
	<h1>객체 없음</h1>
<%}%>
<hr>

<h1>액션 태그</h1>
<jsp:useBean id="memberVO" class="vo.MemberVO" scope="request"/>
<h1>회원 정보</h1>
<ul>
<li> 회원 이름 : <jsp:getProperty name ="memberVO" property="name"/></li>
<li> 계정 : <jsp:getProperty name ="memberVO" property="id"/></li>
<li> 암호 : <jsp:getProperty name ="memberVO" property="passwd"/></li>
<li> 전화번호 : <jsp:getProperty name ="memberVO" property="phone"/></li>
</ul>
<hr>

<h1>표현 언어(EL)</h1>
<h1>회원 정보</h1>
<ul>
<li> 회원 이름 : ${requestScope.memberVO.name}</li>
<li> 계정 : ${requestScope.memberVO.id}</li>
<li> 암호 : ${requestScope.memberVO.passwd}</li>
<li> 전화번호 : ${requestScope.memberVO.phone}</li>
</ul>
<hr>
</body>
</html>