<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="menu">
	<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
	<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
	<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">블로그 관리</a></li>
</ul>
