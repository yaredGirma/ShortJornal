<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Feedback Detail</title>
</head>
<body>
	<div id="content-wrap">
		<div id="centerTable">

			<table id="box-table-a" summary="Employee Pay Sheet">
				<thead>
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">User Name</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${member.firstName}</td>
						<td>${member.lastName}</td>
						<td>${member.email}</td>
						<td>${member.userCredentials.username}</td>
						<td><spring:url value="/registers/editUser/${member.id}"
								var="useredit" /> <a class="edit" href="${useredit}">Edit</a></td>
						<td><a class="delete" href="<spring:url value="/registers/deleteUser/${member.id}" />">Delete</a></td>
					</tr>
				</tbody>
			</table>
			<a href="<spring:url value="/registers/addAdmin" />">Add a new
				User</a>
		</div>

	</div>

</body>
</html>