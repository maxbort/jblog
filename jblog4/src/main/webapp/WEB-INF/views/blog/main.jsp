<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1><a href="${pageContext.request.contextPath}/${id}">${blogVo.title }</a></h1>
			<c:import url="/WEB-INF/views/includes/navigation2.jsp" />
		</div>
		
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
				
					<h4>${nowPost.title }</h4>
					<p>
						${nowPost.contents }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList }" var="postvo">
					<li><a href="${pageContext.request.contextPath}/${id}/${postvo.categoryNo }/${postvo.no}">${postvo.title }</a> <span>${postvo.regDate }</span></li>
				
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath }${blogVo.logo }">
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/navigation.jsp" />

		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2024
			</p>
		</div>
	</div>
</body>
</html>