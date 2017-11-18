<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In Form</title>
</head>
<body>

	<div>
		<p>
			${GreetingMessage}
		</p>
		<c:if test="${not empty error}">
			<div>
				<spring:message
					code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
				<br />
			</div>
		</c:if>
		<form action="<spring:url value="/login"></spring:url>" method="post">
			<fieldset>
				<div>
					<input placeholder="User Name"
						name='username' type="text">
				</div>
				<div>
					<input placeholder="Password"
						name='password' type="password" value="">
				</div>
				<div>
					<input type='checkbox' name="keepMe" />Remember Me? <br />
				</div>
				<input type="submit" value="Login">
			</fieldset>
			<security:csrfInput />
		</form>

	</div>
</body>