<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
   
<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categoryList }" var="categoryvo">
					<li>
					<a href="${pageContext.request.contextPath}/${authUser.id}/${categoryvo.no }">${categoryvo.name }</a>
					</li>

				</c:forEach>
			</ul>
</div>