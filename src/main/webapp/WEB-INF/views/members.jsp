<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Members</title>
</head>
<body>
	<div id="content-wrap">
		<div id="centerTable">

			<table id="box-table-a" summary="Employee Pay Sheet">
				<thead>
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">View In Detail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${members}" var="member">
						<tr>
							<td>${member.firstName}</td>
							<td>${member.lastName}</td>

							<%-- <td><a href="<spring:url value="/registers/${member.id}" />">View</a></td>  --%>
							<td><spring:url value="/registers/${member.id}" var="member"/>
							<a class="edit" href="${member}">View Detail</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<a href="<spring:url value="/registers/addAdmin" />">Add New User</a>

		</div>

	</div>
</body>
</html>





