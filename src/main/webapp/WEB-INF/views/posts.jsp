<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/blogScript.js"/>"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%-- <meta th:name="_csrf" th:content="${_csrf.token}"/> --%>
<%-- <meta th:name="_csrf_header" th:content="${_csrf.headerName}"/> --%>

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>


<title>Blog Posts</title>
</head>
<body>

	<div id="content-wrap">
		<div id="centerTable">
		<h2 style="color:#9fcc7f; margin-bottom: 40px;">Posts</h2>

			<table id="box-table-a" summary="Employee Pay Sheet">
				<thead>
					<tr>
						<th scope="col" class="custom">Title</th>
						<th scope="col" class="custom">Date</th>
						<th scope="col">Content</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${blogPosts}" var="post">
						<tr>
							<td>${post.title}</td>
							<td>${post.date}</td>
							<td><p id="postDescription">${post.desciption}</p></td>
							<td><a class="edit" href="<spring:url value='/blogManagement/editPost?id=${post.id}' />">Edit</a></td>
							<td><a class="delete"
								onclick="removeFromCart('${post.id}');">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


	<a href="<spring:url value='/blogManagement/addPost' />">Add Post</a>

		</div>

	</div>


</body>
</html>