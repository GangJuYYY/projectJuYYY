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
<script type="text/javascript">
	function detail(){
		$('.detailForm input').hide();
		$('.modal-title').html('DETAIL PAGE');
		$('.modal-footer').show();		
		$('.well-input').show();
	}
	function edit(){
		$('.detailForm input').show();
		$('.modal-title').html('EDIT PAGE');
		$('.modal-footer').hide();
		$('.well-input').hide();
	}
	
	$(function(){
		detail();
		
		$('#myModal-${bbsNum }').modal({show:true});
		
		$('.yourModal').on('hide.bs.modal', function (e) { detail(); });
		$('.edit').click(function(){ edit(); });
	});
</script>
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
	        <td><a href="" data-toggle="modal" data-target="#myModal-${bean.bbsNum }">${bean.bbsNum }</a></td>
	  	    <td><a href="" data-toggle="modal" data-target="#myModal-${bean.bbsNum }">${bean.memId }</a></td>
	  	    <td><a href="" data-toggle="modal" data-target="#myModal-${bean.bbsNum }">${bean.title }</a></td>
	  	    <td><a href="" data-toggle="modal" data-target="#myModal-${bean.bbsNum }">${bean.contents }</a></td>
	        <td><a href="" data-toggle="modal" data-target="#myModal-${bean.bbsNum }">${bean.bbs_date }</a></td>
	    </tr>
  <!-- Modal -->
<div class="modal fade yourModal" id="myModal-${bean.bbsNum }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-${bean.bbsNum }">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel-${bean.bbsNum }">${bean.bbsNum }님 상세페이지</h4>
		      </div>
		      <div class="modal-body">
		        <form action="./${bean.bbsNum }" method="post" class="detailForm">
		        	<input type="hidden" name="_method" value="put">
		      		<div class="form-group">
		      			<label for="bbsNum">NUM</label>
				        <div class="well well-sm">${bean.bbsNum }</div>
		      			<input type="hidden" value="${bean.bbsNum }" class="form-control" name="num" id="num" placeholder="번호" />
		      		</div>
		      		<div class="form-group">
		      			<label for="memId">MEMID</label>
				        <div class="well well-sm well-input">${bean.memId }</div>
		      			<input type="text" value="${bean.memId }" class="form-control" name="id" id="id" placeholder="아이디" />
		      		</div>
		      		<div class="form-group">
		      			<label for="title">TITLE</label>
				        <div class="well well-sm well-input">${bean.title }</div>
		      			<input type="text" value="${bean.title }" class="form-control" name="title" id="title" placeholder="제목" />
		      		</div>
		
		      		<div class="form-group">
		      			<label for="contents">CONTENTS</label>
				        <div class="well well-sm well-input">${bean.contents }</div>
		      			<input type="text" value="${bean.contents }" class="form-control" name="content" id="content" placeholder="내용" />
		      		</div>
		      		
		      		<div class="form-group">
		      			<label>DATE</label>
				        <div class="well well-sm">${bean.bbs_date }</div>
		      		</div>
		      		
			        <input type="submit" class="btn btn-danger" value="수정"/>
			        <input type="button" class="btn btn-default" data-dismiss="modal" value="Close"/>
		      	</form>
		      </div>
		      <div class="modal-footer">
		        <form action="./${bean.bbsNum }" method="post">
		        <input type="hidden" name="_method" value="delete">
		        <button type="button" class="btn btn-default" data-dismiss="modal">CANCEL</button>
		        <button type="button" class="btn btn-primary edit">EDIT</button>
		        <button type="submit" class="btn btn-danger delete">DELETE</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
	</c:forEach>
	</tbody>
	</table>
	
<a href="#" role="btn" class="btn btn-info btn-sm active" data-toggle="modal" data-target=".bs-example-modal-lg">입력</a>						
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		      	<h4>입력페이지</h4>
		      </div>
		      <div class="modal-body">
		      	<form method="post">
<!-- 		      		<div class="form-group"> -->
<!-- 		      			<label for="sabun">sabun</label> -->
<!-- 		      			<input type="text" class="form-control" name="sabun" id="sabun" placeholder="사번" /> -->
<!-- 		      		</div> -->
		      		<div class="form-group">
		      			<label for="title">TITLE</label>
		      			<input type="text" class="form-control" name="title" id="title" placeholder="제목" />
		      		</div>
		      		<div class="form-group">
		      			<label for="contents">CONTENTS</label>
		      			<input type="text" class="form-control" name="contents" id="contents" placeholder="내용" />
		      		</div>
			        <button type="submit" class="btn btn-primary">ADD</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">CANCEL</button>
		      	</form>
		      </div>
		      </div>
		    </div>
		  </div>
		</div> 
<!-- <div class="list-group"> -->
<%@ include file="../template/footer.jsp" %>
</body>
</html>