<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- spring에서 부트스트랩 js,css를 가져오기 위해 한 설정
참조: https://k-develpoper.tistory.com/9 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Detail</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class=card-body>
				<div class="mb-3">
					${data.title }<br>
					<small>${data.insert_date }</small>
				</div>
				<hr>
				<div class="mb-3">
					${data.contents }
				</div>
				<button class="btn btn-primary" onclick="location.href='/board/list'">LIST</button>
				<button class="btn btn-secondary" onclick="location.href='/board/delete?id=${data.post_id}'">DELETE</button>
			</div>
		</div>
	</div>
</body>
</html>