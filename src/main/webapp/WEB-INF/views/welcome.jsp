<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

<link href="${pageContext.request.contextPath}/resource/css/style.css" />

</head>
<body>
	<section>
		<p>
			${GreetingMessage}
		</p>
		<div>
			<c:if test="${hasImage}">
				<img src="<c:url value="/resource/images/${userName}.jpg"></c:url>"
				alt="image" width="200" height="150" />
			</c:if>
			<c:if test="${!hasImage}">
				<img src="<c:url value="/resource/images/default.jpg"></c:url>"
				alt="image" width="200" height="150" />
			</c:if>
		</div>
	</section>

</body>
</html>
