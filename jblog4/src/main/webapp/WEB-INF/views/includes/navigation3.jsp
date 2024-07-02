<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<ul class="admin-menu">
	<li class="selected">기본설정</li>
	<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
	<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>
</ul>