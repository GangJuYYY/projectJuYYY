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
<form action="/shop01/insert.bit/" method="post">
	<div class="form-group">
		<label for="bbsNum">NUM</label>
		<input type="text" class="form-control" name="num" id="num" placeholder="필수" />
	</div>
	<div class="form-group">
		<label for="memId">ID</label>
		<input type="text" class="form-control" name="id" id="id" placeholder="아이디없음" />
	</div>
	<div class="form-group">
		<label for="title">TITLE</label>
		<input type="text" class="form-control" name="title" id="title" placeholder="제목없음" />
	</div>
	<div class="form-group">
		<label for="contents">CONTENTS</label>
		<input type="text" class="form-control" name="contents" id="contents" placeholder="내용없음" />
	</div>
	<button type="submit" class="btn btn-info btn-sm active">입력</button>
	<button type="reset" class="btn btn-info btn-sm active">취소</button>
</form>
</div>
<%@ include file="../template/footer.jsp" %>
</body>
</html>