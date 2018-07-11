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
<div class="container">
<form action="/shop01/update.bit/" method="post" class="form-horizontal">
<div class="form-group">
	<label for="bbsNum" class="col-sm-2">NUM</label>
	<div class="well well-sm col-sm-10">${bean.bbsNum }</div>
	<input type="hidden" value="${bean.bbsNum }" name="num" id="num" class="form-control"/>
</div>
<div class="form-group">
	<label for="memId" class="col-sm-2">ID</label>
	<div class="col-sm-10">
	<input type="text" value="${bean.memId }" name="id" id="id" class="form-control"/>
	</div>
</div>

<div class="form-group">
	<label for="title" class="col-sm-3">TITLE</label>
	<div class="col-sm-10">
	<input type="text" value="${bean.title }" name="title" id="title" class="form-control"/>
	</div>
</div>

<div class="form-group">
	<label for="contents"  class="col-sm-4">CONTENTS</label>
	<div class="col-sm-10">
	<input type="text" value="${bean.contents }" name="contents" id="contents" class="form-control"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2">DATE</label>
	<div class="well well-sm col-sm-10">${bean.bbs_date }</div>
</div>
<div class="form-group">
	<div class="col-sm-offset-2 col-sm-10">
	<button type="submit" class="btn btn-info btn-sm active">수정</button>
	<button type="reset" class="btn btn-info btn-sm active">취소</button>
	</div>
</div>
</form>
</div>
</div>

<%@ include file="../template/footer.jsp" %>
</body>
</html>