<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- spring에서 부트스트랩 js,css를 가져오기 위해 한 설정
참조: https://k-develpoper.tistory.com/9 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script src="${path }/resources/js/bootstrap.min.js"></script>
<link href="${path }/resources/css/bootstrap.css" rel="stylesheet"/>
<style type="text/css">
	.container {
		margin-top: 2em;
	}
</style>
<meta charset="UTF-8">
<title>WRITE POST</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class=card-body>
				<form method="post">
					<div class="mb-3">
						<label class="form-label" for="title">Title</label>
						<input type="text" class="form-control" id="title" name="title">
					</div>
					<div class="mb-3">
						<label class="form-label" for="writer">Writer</label>
						<input type="text" class="form-control" id="writer" name="writer">
					</div>
					<div class="mb-3">
						<label class="form-label" for="contents">Contents</label>
						<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
					</div>
					<input class="btn btn-primary float-end" type="submit" value="SEND">
				</form>
			</div>
		</div>
	</div>
</body>
</html>