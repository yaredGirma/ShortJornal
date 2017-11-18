<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/eventScript.js"/>"></script>
	
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.event.view"/></title>
</head>
<body>
<div class="container">
    <div id="content-wrap">
		<div id="centerTable">

			<table id="box-table-a" summary="Events">
				<thead>
					<tr>
						<th scope="col">Date</th>
						<th scope="col">Details</th>
						<th scope="col">Memory</th>
						<th scope="col">Feeling</th>
						<th scope="col">Type</th>
						<th scope="col">Frequency</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${events}" var="event">
						<tr>
							<td>${event.date}</td>
							<td>${event.description}</td>
							<td>${event.duration.duration}</td>
							<td>${event.feeling.feeling}</td>
							<td>${event.type.type}</td>
							<td>${event.frequency.frequency}</td>
							<td><a class="edit" href="<spring:url value="/editEvent/${event.id}"/>">Edit</a></td>
							<td><a class="delete"
								onclick="removeEvent('${event.id}');">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

	</div>
</div>
</body>
