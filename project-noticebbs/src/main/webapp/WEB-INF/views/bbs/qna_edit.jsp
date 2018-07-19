<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="Keywords" content="게시판 수정하기 폼" />
<meta name="Description" content="게시판 수정하기 폼" />
<link rel="stylesheet" href="../resources/css/screen.css" type="text/css" media="screen" />
<title>${bbsnm }</title>
<script type="text/javascript">
//<![CDATA[
   function check() {
       var form = document.getElementById("modifyForm");
       //TODO 유효성 검사
       return true;
   }
 
   function goList() {
       var form = document.getElementById("listForm");
       form.submit();
   }
 
   function goView() {
       var form = document.getElementById("viewForm");
       form.submit();
   }
   
//    function goModify(){
//        var form = document.getElementById("modifyForm");
//        form.submit();
      
//    }
//    function goDelete(){
//        var form = document.getElementById("deleteForm");
//        form.submit();
      
//    }
//]]>
</script>          
</head>
<body>
 
<div id="wrap">
 
    <div id="header">
    </div>
 
    <div id="main-menu">
    </div>
 
    <div id="container">
        <div id="content" style="min-height: 800px;">
            <div id="url-navi"></div>
           
<!-- 본문 시작 -->
<h1>${bbsnm }${param }</h1>
<div id="bbs">
<h2>수정</h2>
<form id="modifyForm" action="/shop01/not_bbs_edit/" method="post" onsubmit="return check()">
<p style="margin: 0;padding: 0;">
    <input type="hidden"  name="bbseditno" value="${param.bbseditno }" />
    <input type="hidden"  name="bbscd" value="${param.bbscd }" />
</p>
<table id="write-form">
<tr>
    <td>제목</td>
    <td><input type="text" name="title" size="50" value="${thisBbsVo.title }" /></td>
</tr>
<tr>
    <td colspan="2">
        <textarea name="contents" rows="17">${thisBbsVo.contents }</textarea>
    </td>
</tr>
 
</table>
<div style="text-align: center;padding-bottom: 15px;">
    <input type="submit" value="전송" />
    <input type="button" value="상세보기" onclick="goView()" />
    <input type="button" value="목록" onclick="goList()" />
</div>
</form>
   
</div><!-- bbs 끝 -->
<!--  본문 끝 -->
        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
   
    <div id="sidebar">
    </div>
   
    <div id="extra">
    </div>
 
    <div id="footer">
    </div>
 
</div>
 
<div id="form-group" style="display: none;">
    <form id="listForm" action="/shop01/not_bbs/" method="get">
        <p>
        <input type="hidden" name="bbscd" value="${param.bbscd }" />
        </p>
    </form>
    <form id="viewForm" action="/shop01/not_bbs_detail/" method="get">
        <p>
        <input type="hidden" name="bbseditno" value="${param.bbseditno }"/>
        <input type="hidden" name="bbscd" value="${param.bbscd }" />
        </p>
    </form>
<!--      <form id="modifyForm" action="/shop01/not_bbs_edit/" method="get"> -->
<!--     <p> -->
<%--         <input type="hidden" name="bbseditno" value="${thisBbsVo.bbseditno }"/> --%>
<%--         <input type="hidden" name="bbscd" value="${bbscd }" /> --%>
<!--     </p> -->
<!--     </form> -->
<!--     <form id="deleteForm" action="/shop01/not_bbs_delete/" method="get"> -->
<!--     <p> -->
<%--         <input type="hidden" name="bbseditno" value="${thisBbsVo.bbseditno }"/> /> --%>
<%--         <input type="hidden" name="bbscd" value="${bbscd }" /> --%>
<!--     </p> -->
<!--     </form> -->
</div>
 
</body>
</html>

