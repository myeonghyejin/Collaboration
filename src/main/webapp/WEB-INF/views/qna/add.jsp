<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA ADD</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<!-- 전체 -->
<div class="container-fluid my-5">

	<!-- Title -->
	<div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
		<p class="fs-2" style="font-family: 'Impact'">QNA Add Page</p>
	</div>
	
	<form action="./add" method = "post" enctype="multipart/form-data">
		<div class="row col-md-4 mx-auto my-5">
			<div class="fw-bold fs-5 col-12">
				<label for="title" class="form-label fw-bold fs-6">제목</label>
				<input type="text" name="qnaTitle" class="form-control" id="title" placeholder="제목 입력"><br>
			</div>
			<div class="fw-bold fs-5 col-12">
				<label for="writer" class="form-label fw-bold fs-6">작성자</label>
				<input type="text" name="qnaWriter" class="form-control" id="writer" placeholder="닉네임 입력"><br>
			</div>
			<div class="fw-bold fs-5 col-12">
				<label for="contents" class="form-label fw-bold fs-6">내용</label>
				<textarea name="qnaContents" class="form-control" id="contents" rows="3" placeholder="내용 입력"></textarea><br>
			</div>	
			<div class="fw-bold fs-5 col-12 mt-3">
				<label for="files" class="form-label">File</label>
				<input type="file" class="form-control" id="files" name="multipartFile">
			</div>	
		</div>
		
	<!-- QNA 등록 버튼 -->
	<div class="row justify-content-center mx-auto">
		<button type="submit" class="btn btn-primary col-2">등록</button>
	</div>
	</form>

</div>

<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>