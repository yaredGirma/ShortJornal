<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<html>
<head>
<meta charset="utf-8">
<link href="/resources/css/style.css" rel="stylesheet">
<title>Feedback Detail</title>
<jsp:include page="/WEB-INF/tiles/template/navigation.jsp" />
</head>
<body>
	<h1>Please enter your feedback</h1>
	<form:form modelAttribute="feedback">
		<form:hidden path="id" />
		<form:errors path="*" cssStyle="color : red;" element="div" />
		<div>
			<label for="subject">Subject</label>
			<div>
				<form:input id="subject" path="subject" type="text" />
				<form:errors path="subject" cssStyle="color : red;" />
			</div>
		</div>

		<div>
			<label for="message">Feedback</label>
			<div>
				<form:textarea rows="10" cols="30" id="message" path="message"
					type="text" />
				<form:errors path="message" cssStyle="color : red;" />
			</div>
		</div>

		<div class="form-group">
			<label for="userName">UserName</label>
			<div>
				<form:input id="userName" path="userName" type="text" />
				<form:errors path="userName" cssStyle="color : red;" />
			</div>
		</div>
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" name="_eventId_feedbackCollected" id="btnAdd"
					class="btn btn-primary" value="Next" />
			</div>
		</div>
	</form:form>
</body>
</html>
