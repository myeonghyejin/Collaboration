<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA DETAIL</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<!-- 전체 -->
<div class="container-fluid my-5">

	<!-- Title -->
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">QNA Detail Page</p>
	</div>

	<!-- Contents -->
	<div class="row col-md-4 mx-auto my-5">
		<c:choose>
			<c:when test="${not empty DTO.qnaNum}">
				<h3>번호 : ${DTO.qnaNum}</h3>
				<h3>제목 : ${DTO.qnaTitle}</h3>
				<h3>내용 : ${DTO.qnaContents}</h3>
				<h3>작성자 : ${DTO.qnaWriter}</h3>
				<h3>작성 날짜 : ${DTO.qnaDate}</h3>
				<h3>조회수 : ${DTO.qnaHit}</h3>
				<div>
					<c:if test="${not empty DTO.qnaFileDTO}">
						<img alt="" src="../resources/upload/qna/${DTO.qnaFileDTO.qnaFileName}">
					</c:if>
				</div>
			</c:when>
			<c:otherwise>
				<h3>존재하지 않는 게시글입니다.</h3>
			</c:otherwise>
		</c:choose>
	</div>
	
	<!-- Buttons -->
	<div class="row col-md-4 justify-content-center mx-auto">
		<a href=./update?qnaNum=${DTO.qnaNum} class="btn btn-primary col-2 mx-1">수정</a>
		<a href=./delete?qnaNum=${DTO.qnaNum} class="btn btn-primary col-2 mx-1">삭제</a>
		<a href=./list class="btn btn-primary col-2 mx-1">목록</a>
	</div>

</div>

<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>