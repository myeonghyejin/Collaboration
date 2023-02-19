<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA LIST</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<!-- 전체 -->
<div class="container-fluid my-5">

	<!-- Title -->
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">QNA List Page</p>
	</div>
	
	<!-- List -->
	<div class="row col-md-4 mx-auto my-5">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>이자율</th>
					<th>판매 여부</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${list}" var="DTO">
					<tr>
						<td class="tdl_td">${DTO.qnaNum}</td>
						<td><a href="./detail?qnaNum=${DTO.qnaNum}">${pageScope.DTO.qnaTitle}</a></td>
						<td class="tdl_td">${DTO.qnaWriter}</td>
						<td class="tdl_td">${DTO.qnaDate}</td>
						<td class="tdl_td">${DTO.qnaHit}</td>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	<!-- Paging -->
	<div class="rowmx-auto">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
			
				<li class="page-item ${pagination.page eq 1?'disabled':''}">
					<a class="page-link" href="./list?page=1&condition=${pagination.condition}&search=${pagination.search}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				
				<li class="page-item ${pagination.pre?'disabled':''}">
					<a class="page-link" href="./list?page=${pagination.startNum-1}&condition=${pagination.condition}&search=${pagination.search}" aria-label="Previous">
						<span aria-hidden="true">&lsaquo;</span>
					</a>
				</li>
									
				<c:forEach begin="${pagination.startNum}" end="${pagination.lastNum}" var="i">
					<li class="page-item"><a class="page-link" href="./list?page=${i}&condition=${pagination.condition}&search=${pagination.search}">${i}</a></li>
				</c:forEach>
				
				<li class="page-item  ${pagination.next eq false ? 'disabled' : ''}">
					<a class="page-link" href="./list?page=${pagination.lastNum+1}&condition=${pagination.condition}&search=${pagination.search}"  aria-label="Next">
						<span aria-hidden="true">&rsaquo;</span>
					</a>
 				</li>
	 				
	 			<li class="page-item ${pagination.page eq pagination.totalPage?'disabled' : ''}">
					<a class="page-link" href="./list?page=${pagination.totalPage}&condition=${pagination.condition}&search=${pagination.search}"  aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
					</li>
					
			</ul>
		</nav>
	</div>
	
	<!-- 검색창 -->
	<form action="./list" method="get" class="row g-3">
		<div class="row justify-content-center mx-auto">
			<div class="col-auto">
				<label for="condition" class="visually-hidden">Email</label>
				<select class="form-select" name="condition" id="condition" aria-label="Default select example">
					<option value="title">제목</option>
					<option value="contents">내용</option>
					<option value="writer">작성자</option>
				</select>
			</div>
			<div class="col-auto">
				<label for="search" class="visually-hidden">Search</label>
				<input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력하세요.">
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-outline-primary mb-3">검색</button>
			</div>
		</div>
	</form>
	
	<!-- QNA 등록 버튼 -->
	<div class="row justify-content-center mx-auto">
		<a href=./add class="btn btn-primary col-2">QNA 등록</a>
	</div>

</div>

<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>