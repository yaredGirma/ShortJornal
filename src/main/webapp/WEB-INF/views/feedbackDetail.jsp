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
						<th scope="col">Subject</th>
						<th scope="col">Message</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${feedbackDetail.subject}</td>
						<td>${feedbackDetail.message}</td>
						<td><spring:url
								value="/feedback/editFeedback/${feedbackDetail.id}"
								var="feedbackedit" /> <a class="edit" href="${feedbackedit}">Edit</a></td>
						<td><spring:url
								value="/feedback/deleteFeedback/${feedbackDetail.id}"
								var="feedbackdelete" /> <a class="delete"
							href="${feedbackdelete}">Delete</a></td>
					</tr>
				</tbody>
			</table>
			<a href="<spring:url value="/feedback/add" />">Add a new FeedBack</a>
		</div>

	</div>
</body>
</html>


