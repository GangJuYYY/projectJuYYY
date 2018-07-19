<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="게시판 상세보기" />
<meta name="Description" content="게시판 상세보기" />
<link rel="stylesheet" href="../resources/css/screen.css"
	type="text/css" media="screen" />
<title>${bbsnm }</title>
<script type="text/javascript">
	function goList() {
		var form = document.getElementById("listForm");
		form.submit();
	}
	function goWrite() {
		var form = document.getElementById("writeForm");
		form.submit();
	}

	function goView(bbseditno) {
		var form = document.getElementById("viewForm");
		form.bbseditno.value = bbseditno;
		form.submit();

	}
	function goModify() {
		var form = document.getElementById("modifyForm");
		form.submit();

	}
	function goDelete() {
		var form = document.getElementById("deleteForm");
		form.submit();

	}
</script>
</head>
<body>

	<div id="wrap">

		<div id="header"></div>

		<div id="main-menu"></div>

		<div id="container">
			<div id="content" style="min-height: 800px;">
				<div id="url-navi"></div>

				<!-- 본문 시작 -->
				<h1>${bbsnm }</h1>
				<div id="bbs">
					<table>
						<tr>
							<th style="width: 40px;">TITLE</th>
							<th style="text-align: left; color: #555;">${thisBbsVo.title }</th>
							<th style="width: 60px;">DATE</th>
							<th style="width: 90px; color: #555;">${thisBbsVo.bbs_date }</th>
							<br />
							<th>작성자 ${thisBbsVo.memId }</th>
							<th>조회수 ${thisBbsVo.hit }</th>
						</tr>
					</table>
					<br /> <br />
					<div id="gul-content">
						<p>${thisBbsVo.contents }</p>
					</div>
					<br /> <br /> <br />
					<!-- 					<div id="next-prev"> -->
					<%-- 						<c:if test="${nextBbsVo != null }"> --%>
					<!-- 							<p> -->
					<%-- 								다음글 : <a href="javascript:goView('${nextBbsVo.bbseditno }')">${nextBbsVo.title }</a> --%>
					<!-- 							</p> -->
					<%-- 						</c:if> --%>
					<%-- 						<c:if test="${prevBbsVo != null }"> --%>
					<!-- 							<p> -->
					<%-- 								이전글 : <a href="javascript:goView('${prevBbsVo.bbseditno }')">${prevBbsVo.title }</a> --%>
					<!-- 							</p> -->
					<%-- 						</c:if> --%>
					<!-- 					</div> -->


					<div id="view-menu">
						<div class="fl">
							<input type="button" value="수정" onclick="goModify();" /> <input
								type="button" value="삭제" onclick="goDelete()" />
						</div>
						<div class="fr">
							<input type="button" value="목록" onclick="goList()" /> <input
								type="button" value="새글쓰기" onclick="goWrite()" />
						</div>
					</div>

					<!--     <table> -->
					<!--     <tr> -->
					<!--         <th style="width: 60px;">NO</th> -->
					<!--         <th>TITLE</th> -->
					<!--         <th style="width: 84px;">DATE</th> -->
					<!--         <th style="width: 60px;">HIT</th> -->
					<!--     </tr> -->
					<!--      반복 구간 시작 -->
					<%--     <c:forEach var="bbsVo" items="${list }" varStatus="status">   --%>
					<!--     <tr> -->
					<%--         <td style="text-align: center;">${bbsVo.bbseditno }</td> --%>
					<!--         <td> -->
					<%--             <a href="javascript:goView('${bbsVo.bbseditno }')">${bbsVo.title }</a> --%>
					<!--         </td> -->
					<%--         <td style="text-align: center;">${bbsVo.bbs_date}</td> --%>
					<%--         <td style="text-align: center;">${bbsVo.hit }</td> --%>
					<!--     </tr> -->
					<%--     </c:forEach> --%>
					<!--      반복 구간 끝 -->
					<!--     </table> -->
					<!--     <div id="list-menu" style="text-align:  right;"> -->
					<!--         <input type="button" value="새글쓰기" onclick="goWrite()" /> -->
					<!--     </div> -->
					<!-- </div> -->
					<!--  본문 끝 -->

				</div>
				<!-- content 끝 -->
			</div>
			<!--  container 끝 -->

			<div id="sidebar"></div>

			<div id="extra"></div>

			<div id="footer"></div>

		</div>



		<!-- 명령문과 연결 -->

		<div id="form-group" style="display: none;">

			<form id="listForm" action="/shop01/not_bbs/" method="get">
				<p>
					<input type="hidden" name="bbscd" value="${param.bbscd }" />
				</p>
			</form>
		</div>
		<form id="writeForm" action="/shop01/not_bbs_write/" method="get">
			<p>
				<input type="hidden" name="bbscd" value="${bbscd }" />
			</p>
		</form>
		<form id="viewForm" action="/shop01/not_bbs_detail/" method="get">
			<p>
				<input type="hidden" name="bbseditno" /> <input type="hidden"
					name="bbscd" value="${bbscd }" />
			</p>
		</form>
		
		<form id="modifyForm" action="/shop01/not_bbs_edit/" method="get">
			<p>
				<input type="hidden" name="bbseditno"
					value="${thisBbsVo.bbseditno }" /> <input type="hidden"
					name="bbscd" value="${bbscd }" />
			</p>
		</form>
		<form id="deleteForm" action="/shop01/not_bbs_delete/" method="get">
			<p>
				<input type="hidden" name="bbseditno"
					value="${thisBbsVo.bbseditno }" /> /> <input type="hidden"
					name="bbscd" value="${bbscd }" />
			</p>
		</form>
	</div>

</body>
</html>
