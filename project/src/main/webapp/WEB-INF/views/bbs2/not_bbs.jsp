<style>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');

body { font-family: 'Nanum Gothic', sans-serif;}
.location01{
  padding-top: 0px;
  padding-left: 300px;
}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../template/header.jsp" %>
</head>
<body>
<%@ include file="../template/header2.jsp" %>
<div class="location01">
<table class="table">
	<thead>
		<tr>
			<th>NUM</th>
			<th>ID</th>
			<th>TITLE</th>
			<th>CONTENTS</th>
			<th>DATE</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${alist }" var="bean">
			<tr>
				<td><a href="ndetail.bit?idx=${bean.bbsNum }">${bean.bbsNum }</a></td>
				<td><a href="ndetail.bit?idx=${bean.bbsNum }">${bean.memId }</a></td>
				<td><a href="ndetail.bit?idx=${bean.bbsNum }">${bean.title }</a></td>
				<td><a href="ndetail.bit?idx=${bean.bbsNum }">${bean.contents }</a></td>
			    <td><a href="ndetail.bit?idx=${bean.bbsNum }">${bean.bbs_date }</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/shop01/nadd.bit/" role="btn" class="btn btn-info btn-sm active">입력</a>
</div>
<%@ include file="../template/footer.jsp" %>
</body>
</html>