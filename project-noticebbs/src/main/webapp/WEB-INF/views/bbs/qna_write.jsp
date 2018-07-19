<style>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');

body {
	font-family: 'Nanum Gothic', sans-serif;
}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function check() {
		var form = document.getElementById("writeForm");
		//유효성 검사로직 추가
		return true;
	}

	function goList() {
		var form = document.getElementById("listForm");
		form.submit();
	}
</script>
<%@ include file="../template/header.jsp"%>
</head>
<body>
	<%--  <%@ include file="../template/header2.jsp" %> --%>

	<div id="wrap">

		<div id="header"></div>

		<div id="main-menu"></div>

		<div id="container">
			<div id="content" style="min-height: 800px;">
				<div id="url-navi"></div>

				<!-- 본문 시작 -->
				<h1>${bbsnm }</h1>
				<div id="bbs">
					<form id="writeForm" action="/shop01/not_bbs_write/" method="post"
						onsubmit="return check()">
						<p style="margin: 0; padding: 0;">
							<input type="hidden" name="bbscd" value="${param.bbscd }" />
						</p>
						<table id="write-form">
							<tr>
								<td>제목</td>
								<td><input type="text" name="title" size="50" /></td>
							</tr>
							<tr>
							    <td>내용</td>
								<td colspan="4"><br/><textarea name="contents" rows="20"></textarea>
								</td>
							</tr>
						</table>
						<div style="text-align: center; padding-bottom: 15px;">
							<input type="submit" value="전송" /> <input type="button"
								value="목록" onclick="goList()" />
						</div>
					</form>
				</div>
				<!--  본문 끝 -->

			</div>
			<!-- content 끝 -->
		</div>
		<!--  container 끝 -->

		<div id="sidebar"></div>

		<div id="extra"></div>

		<div id="footer"></div>

	</div>

	<div id="form-group" style="display: none;">
		<form id="listForm" action="/shop01/not_bbs/" method="get">
			<p>
				<input type="hidden" name="bbscd" value="${param.bbscd }" />
			</p>
		</form>
	</div>
	<%@ include file="../template/footer.jsp"%>
</body>
</html>
