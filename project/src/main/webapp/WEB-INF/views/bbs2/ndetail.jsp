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
<div class="well well-sm">${bean.bbsNum }</div>
<div class="well well-sm">${bean.memId }</div>
<div class="well well-sm">${bean.title }</div>
<div class="well well-sm">${bean.contents }</div>


<div class="btn-group" role="group">
	<a href="/shop01/edit.bit/?idx=${bean.bbsNum }" role="btn" class="btn btn-info btn-sm active">수정</a>
	<a href="/shop01/delete.bit/?idx=${bean.bbsNum }" role="btn" class="btn btn-info btn-sm active">삭제</a>
</div>
</div>
<%@ include file="../template/footer.jsp" %>
</body>
</html>