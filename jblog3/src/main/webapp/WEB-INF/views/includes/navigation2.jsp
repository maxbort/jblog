<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<ul>
	<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
	<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
	<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">블로그 관리</a></li>
</ul>