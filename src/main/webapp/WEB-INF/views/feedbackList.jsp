<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FeedBack List</title>

</head>
<body>
	<div id="content-wrap">
		<div id="centerTable">

			<table id="box-table-a" summary="Employee Pay Sheet">
				<thead>
					<tr>
						<th scope="col">Subject</th>
						<th scope="col">Feedback Message</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allFeedBack}" var="feedBack">
						<tr>
							<td>${feedBack.subject}</td>
							<td><spring:url value="/feedback/feedbackDetail/${feedBack.id}" var="feedback"/>
							<a class="edit" href="${feedback}">View Message</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="<spring:url value="/feedback/add" />">Add a new FeedBack</a>
		</div>

	</div>
</body>
</html>




