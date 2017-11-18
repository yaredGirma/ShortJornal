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
	<div class="container">

		<form:form modelAttribute="newfeedback">
			<fieldset>
				<form:hidden path="id" />
				<form:errors path="*" cssClass="color : red;" element="div" />
				<div>
					<label for="subject">Subject</label>
					<div>
						<form:input id="subject" path="subject" type="text" />
						<form:errors path="subject" cssClass="color : red;" />
					</div>
				</div>

				<div>
					<label for="message">Feedback</label>
					<div>
						<form:textarea rows="10" cols="30" id="message" path="message"
							type="text" />
						<form:errors path="message" cssClass="color : red;" />
					</div>
				</div>

				<div class="form-group">
					<label for="userName">UserName</label>
					<div>
						<form:input id="userName" path="userName" type="text" />
						<form:errors path="userName" cssClass="color : red;" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Send" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
