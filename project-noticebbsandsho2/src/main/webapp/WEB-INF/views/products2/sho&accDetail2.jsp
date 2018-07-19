<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.location01{
  padding-top: 0px;
  padding-left: 250px;
}
hr.line{

  width: 400px;
  color: black;
  border: thin solid black;
  border-bottom:2px;
  text-align:left; 
  margin-left: 0px;
  
  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../template2/header.jsp" %>
</head>
<body>
<%@ include file="../template2/header2.jsp" %>
<div class="location01">
<img src="../resources/imgs/dre58-1.jpg" alt="..." align=left hspace=20>
<h4>모던하고 베이직한 스트랩 샌들</h4>
<hr class="line">
<br/>
<h5>깔끔하고 모던한 디자인의 스트랩 샌들입니다.<br/><br/>
누구나 잘 소화시킬 수 있는 베이직한 디자인으로,<br/><br/>
탄탄하고 부드러운 합성피혁소재로 관리가 쉽습니다.<br/><br/>
굽높이가 적당해 장시간 착용하기에도 좋습니다.</h5>
<br/>
<br/>

<h4>PRICE :28,000원</h4>
<!-- 옵션 선택,버튼 start -->
<div class="container">
	<div class="row">
        COLOR :&nbsp;&nbsp;&nbsp;
        <div class="btn-group show-on-hover">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            -옵션 선택- <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">WHITE</a></li>
            <li><a href="#">BLACK</a></li>
          </ul>
        </div>
        <br/><br/>
        SIZE :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <!-- Single button -->
        <div class="btn-group">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            -옵션 선택- <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">225</a></li>
            <li><a href="#">230</a></li>
            <li><a href="#">235</a></li>
            <li><a href="#">240</a></li>
            <li><a href="#">245</a></li>
            <li><a href="#">250</a></li>
          </ul>
        </div>
        <br/><br/>
               상품 갯수 :
        <!-- Single button -->
        <div class="btn-group">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            -갯수 선택- <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
          </ul>
        </div>
         <br/><br/><br/>
         
         <button class="btn btn-info btn-sm active" style="width: 288px" type="button"  onclick="location.href=''">BUY</button>
         <br/><br/>
         <button class="btn btn-info btn-sm active" style="width: 288px" type="button"  onclick="location.href=''">CART</button>
    
	</div>
</div>
<!-- 옵션 선택창,버튼 end -->
</div>
<br clear=left>
<!-- 이미지 옆 글씨를 다시 이미지 아래로 -->
<%@ include file="../template2/footer.jsp" %>
</body>
</html>