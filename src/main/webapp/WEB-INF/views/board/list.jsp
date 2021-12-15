<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>
<script src="${path }/resources/js/bootstrap.min.js"></script>
<link href="${path }/resources/css/bootstrap.css" rel="stylesheet"/>
<style type="text/css">
	.container {
		margin-top: 2em;
	}
</style>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>
							title
						</th>
						<th>
							writer
						</th>
						<th>
							time
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${data }">
						<tr>
							<td>
								<a href="/board/detail?id=${i.post_id }">
									${i.title }
								</a>
							</td>
							<td>
								${i.writer }
							</td>
							<td>
								${i.insert_date }
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button class="btn btn-primary float-end" onclick="location.href='/board/write'">POST</button>
		</div>
	</div>
</div>
</body>
</html>