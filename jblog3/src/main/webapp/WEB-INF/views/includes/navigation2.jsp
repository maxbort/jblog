<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<ul>
	<c:choose>
		<c:when test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			<c:choose>
				<c:when test="${authUser.id eq blogVo.id }">
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic"> 블로그 관리</a></li>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</ul>